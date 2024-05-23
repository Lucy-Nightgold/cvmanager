package org.hortense.cvmanager.service;

import org.hortense.cvmanager.entities.Cv24Type;
import org.hortense.cvmanager.entities.IdentiteType;
import org.hortense.cvmanager.repositories.Cv24TypeRepository;
import org.hortense.cvmanager.repositories.IdentityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.StringReader;
import java.net.URL;
import java.util.Optional;

@Service
public class CvManagerService {

    @Autowired
    private Cv24TypeRepository cv24TypeRepository;

    @Autowired
    private IdentityRepository identityRepository;



    public String retrieveResumes() {
        Iterable<Cv24Type> cvs = cv24TypeRepository.findAll();
        return "test";
    }

    public void validateXML(String cvXML) throws Exception{
        SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        URL xsd = getClass().getClassLoader().getResource("static/cv.xsd");
        Schema schema = factory.newSchema(xsd);
        Validator validator = schema.newValidator();

        DocumentBuilder parser = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document document = parser.parse(new InputSource(new StringReader(cvXML)));

        validator.validate(new StreamSource(new StringReader(cvXML)));

    }

    public Cv24Type addCV(Cv24Type cv) {
        return cv24TypeRepository.save(cv);
    }

    public boolean cvAlreadyExists(Cv24Type cv) {
        Optional<IdentiteType> identity = identityRepository.findByNomAndPrenomAndTelAndGenre(
                cv.getIdentite().getNom(),
                cv.getIdentite().getPrenom(),
                cv.getIdentite().getTel(),
                cv.getIdentite().getGenre()
        );
        return identity.isPresent();
    }

    public Optional<Cv24Type> findCvById(Long id) {
        return cv24TypeRepository.findById(id);
    }

    public void deleteCv(Cv24Type cv) {
        cv24TypeRepository.delete(cv);
    }
}
