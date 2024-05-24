//
// Ce fichier a été généré par Eclipse Implementation of JAXB, v3.0.2 
// Voir https://eclipse-ee4j.github.io/jaxb-ri 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2024.05.23 à 08:44:18 PM CEST 
//


package org.hortense.cvmanager.entities;

import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;

import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.hortense.cvmanager.entities package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Cv24_QNAME = new QName("http://univ.fr/cv24", "cv24");
    private final static QName _Identite_QNAME = new QName("http://univ.fr/cv24", "identite");
    private final static QName _Objectif_QNAME = new QName("http://univ.fr/cv24", "objectif");
    private final static QName _Prof_QNAME = new QName("http://univ.fr/cv24", "prof");
    private final static QName _Competences_QNAME = new QName("http://univ.fr/cv24", "competences");
    private final static QName _Divers_QNAME = new QName("http://univ.fr/cv24", "divers");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.hortense.cvmanager.entities
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Cv24Type }
     * 
     */
    public Cv24Type createCv24Type() {
        return new Cv24Type();
    }

    /**
     * Create an instance of {@link IdentiteType }
     * 
     */
    public IdentiteType createIdentiteType() {
        return new IdentiteType();
    }

    /**
     * Create an instance of {@link ObjectifType }
     * 
     */
    public ObjectifType createObjectifType() {
        return new ObjectifType();
    }

    /**
     * Create an instance of {@link ProfType }
     * 
     */
    public ProfType createProfType() {
        return new ProfType();
    }

    /**
     * Create an instance of {@link CompetencesType }
     * 
     */
    public CompetencesType createCompetencesType() {
        return new CompetencesType();
    }

    /**
     * Create an instance of {@link DiversType }
     * 
     */
    public DiversType createDiversType() {
        return new DiversType();
    }

    /**
     * Create an instance of {@link DetailType }
     * 
     */
    public DetailType createDetailType() {
        return new DetailType();
    }

    /**
     * Create an instance of {@link DiplomeType }
     * 
     */
    public DiplomeType createDiplomeType() {
        return new DiplomeType();
    }

    /**
     * Create an instance of {@link CertifType }
     * 
     */
    public CertifType createCertifType() {
        return new CertifType();
    }

    /**
     * Create an instance of {@link AutreType }
     * 
     */
    public AutreType createAutreType() {
        return new AutreType();
    }

    /**
     * Create an instance of {@link LvType }
     * 
     */
    public LvType createLvType() {
        return new LvType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Cv24Type }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Cv24Type }{@code >}
     */
    @XmlElementDecl(namespace = "http://univ.fr/cv24", name = "cv24")
    public JAXBElement<Cv24Type> createCv24(Cv24Type value) {
        return new JAXBElement<Cv24Type>(_Cv24_QNAME, Cv24Type.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IdentiteType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link IdentiteType }{@code >}
     */
    @XmlElementDecl(namespace = "http://univ.fr/cv24", name = "identite")
    public JAXBElement<IdentiteType> createIdentite(IdentiteType value) {
        return new JAXBElement<IdentiteType>(_Identite_QNAME, IdentiteType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObjectifType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ObjectifType }{@code >}
     */
    @XmlElementDecl(namespace = "http://univ.fr/cv24", name = "objectif")
    public JAXBElement<ObjectifType> createObjectif(ObjectifType value) {
        return new JAXBElement<ObjectifType>(_Objectif_QNAME, ObjectifType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProfType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ProfType }{@code >}
     */
    @XmlElementDecl(namespace = "http://univ.fr/cv24", name = "prof")
    public JAXBElement<ProfType> createProf(ProfType value) {
        return new JAXBElement<ProfType>(_Prof_QNAME, ProfType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CompetencesType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CompetencesType }{@code >}
     */
    @XmlElementDecl(namespace = "http://univ.fr/cv24", name = "competences")
    public JAXBElement<CompetencesType> createCompetences(CompetencesType value) {
        return new JAXBElement<CompetencesType>(_Competences_QNAME, CompetencesType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DiversType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DiversType }{@code >}
     */
    @XmlElementDecl(namespace = "http://univ.fr/cv24", name = "divers")
    public JAXBElement<DiversType> createDivers(DiversType value) {
        return new JAXBElement<DiversType>(_Divers_QNAME, DiversType.class, null, value);
    }

}
