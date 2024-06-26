//
// Ce fichier a été généré par Eclipse Implementation of JAXB, v3.0.2 
// Voir https://eclipse-ee4j.github.io/jaxb-ri 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2024.05.23 à 08:44:18 PM CEST 
//


package org.hortense.cvmanager.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.springframework.data.jpa.domain.AbstractPersistable;

import java.util.ArrayList;
import java.util.List;


/**
 * <p>Classe Java pour diversType complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="diversType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="lv" type="{http://univ.fr/cv24}lvType" maxOccurs="5"/&gt;
 *         &lt;element name="autre" type="{http://univ.fr/cv24}autreType" maxOccurs="3" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "diversType", namespace = "http://univ.fr/cv24", propOrder = {
    "lv",
    "autre"
})
@Entity
public class DiversType extends AbstractPersistable<Long> {

    @XmlElement(namespace = "http://univ.fr/cv24", required = true)
    @OneToMany(cascade = CascadeType.ALL)
    protected List<LvType> lv;

    @OneToMany(cascade = CascadeType.ALL)
    @XmlElement(namespace = "http://univ.fr/cv24")
    protected List<AutreType> autre;

    /**
     * Gets the value of the lv property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the lv property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLv().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LvType }
     * 
     * 
     */
    public List<LvType> getLv() {
        if (lv == null) {
            lv = new ArrayList<LvType>();
        }
        return this.lv;
    }

    /**
     * Gets the value of the autre property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the autre property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAutre().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AutreType }
     * 
     * 
     */
    public List<AutreType> getAutre() {
        if (autre == null) {
            autre = new ArrayList<AutreType>();
        }
        return this.autre;
    }

}
