package org.hortense.cvmanager.service;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import org.hortense.cvmanager.entities.Cv24Type;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.IOException;
import java.io.StringReader;
import java.net.URL;

@Service
public class XMLService {

    public void validateXML(String xml) throws SAXException, IOException, RuntimeException {
        SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        URL xsd = getClass().getClassLoader().getResource("static/cv.xsd");
        if (xsd == null) {
            throw new RuntimeException("XSD schema not found.");
        }
        Schema schema = schemaFactory.newSchema(xsd);
        schema.newValidator().validate(new StreamSource(xml));
    }

    public Cv24Type unmarshal(String xml) throws JAXBException, SAXException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Cv24Type.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        URL xsd = getClass().getClassLoader().getResource("static/cv.xsd");
        Schema schema = schemaFactory.newSchema(xsd);
        unmarshaller.setSchema(schema);
        return (Cv24Type) unmarshaller.unmarshal(new StreamSource(new StringReader(xml)));
    }

}
