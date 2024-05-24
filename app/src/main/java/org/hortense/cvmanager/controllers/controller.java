package org.hortense.cvmanager.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import org.hortense.cvmanager.entities.*;
import org.hortense.cvmanager.entities.responses.ResumeCVs;
import org.hortense.cvmanager.entities.responses.ResumeCv;
import org.hortense.cvmanager.service.CvManagerService;

import org.hortense.cvmanager.service.XMLService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.StringWriter;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class controller {
    private final CvManagerService cvManagerService;
    private final XMLService xmlService;

    public controller(CvManagerService cvManagerService) {
        this.cvManagerService = cvManagerService;
        this.xmlService = new XMLService();
    }

    @GetMapping(value = "/cv24/resume/xml",
            produces = MediaType.APPLICATION_XML_VALUE)
    @Operation(summary = "Get a list of stored cv in XML")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "No cv in the server."),
            @ApiResponse(responseCode = "200", description = "Resume of cvs")})
    public ResponseEntity<String>  getResumesXML() {
        Iterable<Cv24Type> cvs = cvManagerService.retrieveCvs();

        if (!cvs.iterator().hasNext()) {
            return new ResponseEntity<>("Aucun CV dans le serveur.", HttpStatus.NO_CONTENT);
        }

        ResumeCVs resumeCVs = new ResumeCVs();

        for (Cv24Type cv : cvs) {
            ResumeCv resumeCv = new ResumeCv();
            resumeCv.setId(cv.getId());
            resumeCv.setIdentiteType(cv.getIdentite());
            resumeCv.setObjectifType(cv.getObjectif());
            resumeCv.setDiplomeType(cvManagerService.getHighestDiplome(cv));
            resumeCVs.addResumeCv(resumeCv);
        }

        try {
            JAXBContext context = JAXBContext.newInstance(ResumeCVs.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            StringWriter sw = new StringWriter();
            marshaller.marshal(resumeCVs, sw);
            return new ResponseEntity<>(sw.toString(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Erreur interne du serveur", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/cv24/resume",
            produces = MediaType.TEXT_HTML_VALUE)
    @Operation(summary = "Get a list of stored cv in HTML")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Resume of cvs")})
    public ModelAndView getResumesHTML() {
        ModelAndView modelAndView = new ModelAndView("resumes");
        Iterable<Cv24Type> cvs = cvManagerService.retrieveCvs();



        modelAndView.addObject("cvs", cvs);
        return modelAndView;
    }

    @GetMapping(value = "/cv24/xml",
            produces = MediaType.APPLICATION_XML_VALUE)
    @Operation(summary = "Get a cv in XML by his id", description = "Id must be in database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "CV returned"),
            @ApiResponse(responseCode = "404", description = "CV not found")})
    public ResponseEntity<String> getCvXML(@RequestParam Long id) throws JAXBException {
        Optional<Cv24Type> cv = cvManagerService.findCvById(id);

        if (cv.isEmpty()) {
            return new ResponseEntity<>(xmlService.createResponseXML(id, "ERROR", ""), HttpStatus.NOT_FOUND);
        }

        String sw = xmlService.marshal(cv.get());

        return new ResponseEntity<>(sw, HttpStatus.OK);
    }

    @GetMapping(value = "/cv24/html",
            produces = MediaType.TEXT_HTML_VALUE)
    @Operation(summary = "Get a cv in HTML by his id", description = "Id must be in database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "CV returned")})
    public ModelAndView getCvHTML(@RequestParam Long id) {
        Optional<Cv24Type> cv = cvManagerService.findCvById(id);
        ModelAndView modelAndView;

        if (cv.isPresent()) {
            modelAndView = new ModelAndView("cv");
            modelAndView.addObject("cv", cv.get());
        } else {
            modelAndView = new ModelAndView("cvNotFound");
            modelAndView.addObject("id", id);
        }

        return modelAndView;
    }

    @PostMapping(value = "/cv24/insert",
            produces = MediaType.APPLICATION_XML_VALUE,
            consumes = MediaType.APPLICATION_XML_VALUE)
    @Operation(summary = "Add a new cv in database", description = "XML mush respect CV24 XSD")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "CV inserted"),
            @ApiResponse(responseCode = "403", description = "CV not validated"),
            @ApiResponse(responseCode = "409", description = "CV already in database")})
    public ResponseEntity<String> insertCV(@RequestBody String cvXML) {
        String status = "";
        String details = "";
        Long id = null;

        // Validate the XML against the schema
        try {
            xmlService.validateXML(cvXML);
        } catch (Exception e) {
            status = "error while validating xml";
            details = "INVALID";
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(xmlService.createResponseXML(null, status, details));
        }

        //parse XML:
        Cv24Type cv;
        try {
            cv = xmlService.unmarshal(cvXML);
        } catch (Exception e) {
            status = "error while parsing xml";
            details = "INVALID";
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(xmlService.createResponseXML(null, status, details));
        }

        //check cv existence in database:
        if (cvManagerService.cvAlreadyExists(cv)) {
            status = "ERROR";
            details = "DUPLICATED";
            return ResponseEntity.status(HttpStatus.CONFLICT).body(xmlService.createResponseXML(null, status, details));
        }

        //save cv in database:
        Cv24Type savedCv = cvManagerService.addCV(cv);
        id = savedCv.getId();
        status = "INSERTED";
        return ResponseEntity.status(HttpStatus.CREATED).body(xmlService.createResponseXML(id, status, details));
    }

    @DeleteMapping(value = "/cv24/delete",
            produces = MediaType.APPLICATION_XML_VALUE
    )
    @Operation(summary = "Delete a cv by his id", description = "Id must be in database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "CV deleted"),
            @ApiResponse(responseCode = "400", description = "CV not founded")})
    public ResponseEntity<String> deleteCv(@RequestParam Long id) {
        Optional<Cv24Type> cv = cvManagerService.findCvById(id);

        if (cv.isEmpty()) {
            return new ResponseEntity<>(xmlService.createResponseXML(null, "ERROR", ""), HttpStatus.BAD_REQUEST);
        }

        cvManagerService.deleteCv(cv.get());

        return new ResponseEntity<>(xmlService.createResponseXML(id, "DELETED", ""), HttpStatus.OK);
    }

}
