package org.hortense.cvmanager.controllers;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import org.hortense.cvmanager.entities.*;
import org.hortense.cvmanager.service.CvManagerService;

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

    public controller(CvManagerService cvManagerService) {
        this.cvManagerService = cvManagerService;
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

        try {
            // Validate the XML against the schema
            JAXBContext jaxbContext = JAXBContext.newInstance(Cv24Type.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            URL xsd = getClass().getClassLoader().getResource("static/cv.xsd");
            if (xsd == null) {
                throw new RuntimeException("XSD schema not found.");
            }
            Schema schema = schemaFactory.newSchema(xsd);
            unmarshaller.setSchema(schema);
            Cv24Type cv = (Cv24Type) unmarshaller.unmarshal(new StreamSource(new StringReader(cvXML)));

            if (cvManagerService.cvAlreadyExists(cv)) {
                status = "ERROR";
                details = "DUPLICATED";
                return ResponseEntity.status(HttpStatus.CONFLICT).body(createResponseXML(null, status, details));
            }


            Cv24Type savedCv = cvManagerService.addCV(cv);
            id = savedCv.getId();
            status = "INSERTED";
            return ResponseEntity.status(HttpStatus.CREATED).body(createResponseXML(id, status, details));

        } catch (JAXBException e) {
            status = "ERROR";
            details = "INVALID";
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(createResponseXML(id, status, e.toString()));
        } catch (Exception e) {
            status = "ERROR";
            details = "INVALID";
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(createResponseXML(id, status, e.toString()));
        }
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

    private String createResponseXML(Long id, String status, String details) {
        StringBuilder responseXML = new StringBuilder();
        responseXML.append("<response>");
        if (id != null) {
            responseXML.append("<id>").append(id).append("</id>");
        }
        responseXML.append("<status>").append(status).append("</status>");
        if (!details.isEmpty()) {
            responseXML.append("<detail>").append(details).append("</detail>");
        }
        responseXML.append("</response>");
        return responseXML.toString();
    }

}
