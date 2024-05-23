//
// Ce fichier a été généré par Eclipse Implementation of JAXB, v3.0.2 
// Voir https://eclipse-ee4j.github.io/jaxb-ri 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2024.05.23 à 08:44:18 PM CEST 
//


package org.hortense.cvmanager.entities;

import javax.xml.datatype.XMLGregorianCalendar;

import jakarta.persistence.Entity;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import org.hortense.cvmanager.tools.DateAdapter;
import org.springframework.data.jpa.domain.AbstractPersistable;

import java.time.LocalDate;


/**
 * <p>Classe Java pour diplomeType complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="diplomeType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="date" type="{http://univ.fr/cv24}localDate"/&gt;
 *         &lt;element name="institut" type="{http://univ.fr/cv24}string32" minOccurs="0"/&gt;
 *         &lt;element name="titre" type="{http://univ.fr/cv24}string32"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="niveau" use="required" type="{http://univ.fr/cv24}niveauType" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "diplomeType", namespace = "http://univ.fr/cv24", propOrder = {
    "date",
    "institut",
    "titre"
})
@Entity
public class DiplomeType extends AbstractPersistable<Long> {

    @XmlElement(namespace = "http://univ.fr/cv24", required = true)
    @XmlSchemaType(name = "date")
    @XmlJavaTypeAdapter(DateAdapter.class)
    protected LocalDate date;
    @XmlElement(namespace = "http://univ.fr/cv24")
    protected String institut;
    @XmlElement(namespace = "http://univ.fr/cv24", required = true)
    protected String titre;
    @XmlAttribute(name = "niveau", required = true)
    protected int niveau;

    /**
     * Obtient la valeur de la propriété date.
     * 
     * @return
     *     possible object is
     *     {@link LocalDate }
     *     
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * Définit la valeur de la propriété date.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDate(LocalDate value) {
        this.date = value;
    }

    /**
     * Obtient la valeur de la propriété institut.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInstitut() {
        return institut;
    }

    /**
     * Définit la valeur de la propriété institut.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInstitut(String value) {
        this.institut = value;
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

    /**
     * Obtient la valeur de la propriété niveau.
     * 
     */
    public int getNiveau() {
        return niveau;
    }

    /**
     * Définit la valeur de la propriété niveau.
     * 
     */
    public void setNiveau(int value) {
        this.niveau = value;
    }

}
