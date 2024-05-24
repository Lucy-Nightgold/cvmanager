package org.hortense.cvmanager.controllers;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import org.hortense.cvmanager.entities.*;
import org.hortense.cvmanager.service.CvManagerService;

import org.hortense.cvmanager.service.XMLService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.StringReader;
import java.net.URL;
import java.util.Optional;

@RestController
public class controller {
    private final CvManagerService cvManagerService;
    private final XMLService xmlService;

    public controller(CvManagerService cvManagerService) {
        this.cvManagerService = cvManagerService;
        this.xmlService = new XMLService();
    }


    @GetMapping("/test")
    @ResponseStatus(HttpStatus.OK)
    public String test() {
        return "le test";
    }

//    @GetMapping("/")
//    @ResponseStatus(HttpStatus.OK)
//    public ModelAndView index() {
//        return new ModelAndView("index");
//    }

    @GetMapping("/cv24/resume/xml")
    public String getResumesXML() {
        return cvManagerService.retrieveResumes();
    }

    @GetMapping("/cv24/resume/html")
    public String getCvHTML(Model model) {
        model.addAttribute(cvManagerService.retrieveResumes());
        return "resumes";
    }

    @PostMapping("/cv24/insert")
    public ResponseEntity<String> insertCV(@RequestBody String cvXML) {
        String status = "";
        String details = "";
        Long id = null;

        // Validate the XML against the schema
        try {
            xmlService.validateXML(cvXML);
        } catch (Exception e) {
            status = "error while validating xml";
            details = e.getMessage();
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(xmlService.createResponseXML(null, status, details));
        }

        //parse XML:
        Cv24Type cv;
        try {
            cv = xmlService.unmarshal(cvXML);
        } catch (Exception e) {
            status = "error while parsing xml";
            details = e.getMessage();
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
    public ResponseEntity<String> deleteCv(@RequestParam Long id) {
        Optional<Cv24Type> cv = cvManagerService.findCvById(id);

        if (cv.isEmpty()) {
            return new ResponseEntity<>("ERROR", HttpStatus.BAD_REQUEST);
        }

        cvManagerService.deleteCv(cv.get());

        return new ResponseEntity<>("DELETED", HttpStatus.OK);
    }

}
