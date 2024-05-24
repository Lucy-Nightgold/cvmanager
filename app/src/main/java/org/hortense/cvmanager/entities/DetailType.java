//
// Ce fichier a été généré par Eclipse Implementation of JAXB, v3.0.2 
// Voir https://eclipse-ee4j.github.io/jaxb-ri 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2024.05.23 à 08:44:18 PM CEST 
//


package org.hortense.cvmanager.entities;


import jakarta.persistence.Entity;
import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import org.hortense.cvmanager.tools.DateAdapter;
import org.springframework.data.jpa.domain.AbstractPersistable;

import java.time.LocalDate;


/**
 * <p>Classe Java pour detailType complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="detailType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="datedeb" type="{http://univ.fr/cv24}localDate"/&gt;
 *         &lt;element name="datefin" type="{http://univ.fr/cv24}localDate" minOccurs="0"/&gt;
 *         &lt;element name="titre" type="{http://univ.fr/cv24}string128"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "detailType", namespace = "http://univ.fr/cv24", propOrder = {
    "datedeb",
    "datefin",
    "titre"
})
@Entity
public class DetailType extends AbstractPersistable<Long> {

    @XmlElement(namespace = "http://univ.fr/cv24", required = true)
    @XmlSchemaType(name = "date")
    @XmlJavaTypeAdapter(DateAdapter.class)
    protected LocalDate datedeb;

    @XmlElement(namespace = "http://univ.fr/cv24")
    @XmlSchemaType(name = "date")
    @XmlJavaTypeAdapter(DateAdapter.class)
    protected LocalDate datefin;

    @XmlElement(namespace = "http://univ.fr/cv24", required = true)
    protected String titre;

    /**
     * Obtient la valeur de la propriété datedeb.
     * 
     * @return
     *     possible object is
     *     {@link LocalDate }
     *     
     */
    public LocalDate getDatedeb() {
        return datedeb;
    }

    /**
     * Définit la valeur de la propriété datedeb.
     * 
     * @param value
     *     allowed object is
     *     {@link LocalDate }
     *     
     */
    public void setDatedeb(LocalDate value) {
        this.datedeb = value;
    }

    /**
     * Obtient la valeur de la propriété datefin.
     * 
     * @return
     *     possible object is
     *     {@link LocalDate }
     *     
     */
    public LocalDate getDatefin() {
        return datefin;
    }

    /**
     * Définit la valeur de la propriété datefin.
     * 
     * @param value
     *     allowed object is
     *     {@link LocalDate }
     *     
     */
    public void setDatefin(LocalDate value) {
        this.datefin = value;
    }

    /**
     * Obtient la valeur de la propriété titre.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTitre() {
        return titre;
    }

    /**
     * Définit la valeur de la propriété titre.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTitre(String value) {
        this.titre = value;
    }

}
