//
// Ce fichier a été généré par Eclipse Implementation of JAXB, v3.0.2 
// Voir https://eclipse-ee4j.github.io/jaxb-ri 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2024.05.23 à 08:44:18 PM CEST 
//


package org.hortense.cvmanager.entities;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.*;


/**
 * <p>Classe Java pour cv24Type complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="cv24Type"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;all&gt;
 *         &lt;element ref="{http://univ.fr/cv24}identite"/&gt;
 *         &lt;element ref="{http://univ.fr/cv24}objectif"/&gt;
 *         &lt;element ref="{http://univ.fr/cv24}prof" minOccurs="0"/&gt;
 *         &lt;element ref="{http://univ.fr/cv24}competences"/&gt;
 *         &lt;element ref="{http://univ.fr/cv24}divers" minOccurs="0"/&gt;
 *       &lt;/all&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cv24Type", namespace = "http://univ.fr/cv24", propOrder = {

})
@XmlRootElement(name = "cv24")
@Entity
@Table
public class Cv24Type{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @XmlTransient
    private Long id;

    @XmlElement(namespace = "http://univ.fr/cv24", required = true)
    @OneToOne(cascade = CascadeType.ALL)
    protected IdentiteType identite;

    @XmlElement(namespace = "http://univ.fr/cv24", required = true)
    @OneToOne(cascade = CascadeType.ALL)
    protected ObjectifType objectif;

    @XmlElement(namespace = "http://univ.fr/cv24")
    @OneToOne(cascade = CascadeType.ALL)
    protected ProfType prof;

    @XmlElement(namespace = "http://univ.fr/cv24", required = true)
    @OneToOne(cascade = CascadeType.ALL)
    protected CompetencesType competences;

    @XmlElement(namespace = "http://univ.fr/cv24")
    @OneToOne(cascade = CascadeType.ALL)
    protected DiversType divers;

    /**
     * Obtient la valeur de la propriété identite.
     * 
     * @return
     *     possible object is
     *     {@link IdentiteType }
     *     
     */
    public IdentiteType getIdentite() {
        return identite;
    }

    /**
     * Définit la valeur de la propriété identite.
     * 
     * @param value
     *     allowed object is
     *     {@link IdentiteType }
     *     
     */
    public void setIdentite(IdentiteType value) {
        this.identite = value;
    }

    /**
     * Obtient la valeur de la propriété objectif.
     * 
     * @return
     *     possible object is
     *     {@link ObjectifType }
     *     
     */
    public ObjectifType getObjectif() {
        return objectif;
    }

    /**
     * Définit la valeur de la propriété objectif.
     * 
     * @param value
     *     allowed object is
     *     {@link ObjectifType }
     *     
     */
    public void setObjectif(ObjectifType value) {
        this.objectif = value;
    }

    /**
     * Obtient la valeur de la propriété prof.
     * 
     * @return
     *     possible object is
     *     {@link ProfType }
     *     
     */
    public ProfType getProf() {
        return prof;
    }

    /**
     * Définit la valeur de la propriété prof.
     * 
     * @param value
     *     allowed object is
     *     {@link ProfType }
     *     
     */
    public void setProf(ProfType value) {
        this.prof = value;
    }

    /**
     * Obtient la valeur de la propriété competences.
     * 
     * @return
     *     possible object is
     *     {@link CompetencesType }
     *     
     */
    public CompetencesType getCompetences() {
        return competences;
    }

    /**
     * Définit la valeur de la propriété competences.
     * 
     * @param value
     *     allowed object is
     *     {@link CompetencesType }
     *     
     */
    public void setCompetences(CompetencesType value) {
        this.competences = value;
    }

    /**
     * Obtient la valeur de la propriété divers.
     * 
     * @return
     *     possible object is
     *     {@link DiversType }
     *     
     */
    public DiversType getDivers() {
        return divers;
    }

    /**
     * Définit la valeur de la propriété divers.
     * 
     * @param value
     *     allowed object is
     *     {@link DiversType }
     *     
     */
    public void setDivers(DiversType value) {
        this.divers = value;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long value) {
        this.id = value;
    }
}
