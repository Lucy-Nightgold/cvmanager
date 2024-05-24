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
import java.util.Comparator;
import java.util.List;


/**
 * <p>Classe Java pour competencesType complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="competencesType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="diplome" type="{http://univ.fr/cv24}diplomeType" maxOccurs="5"/&gt;
 *         &lt;element name="certif" type="{http://univ.fr/cv24}certifType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "competencesType", namespace = "http://univ.fr/cv24", propOrder = {
    "diplome",
    "certif"
})
@Entity
public class CompetencesType extends AbstractPersistable<Long> {

    @XmlElement(namespace = "http://univ.fr/cv24", required = true)
    @OneToMany(cascade = CascadeType.ALL)
    protected List<DiplomeType> diplome;

    @OneToMany(cascade = CascadeType.ALL)
    @XmlElement(namespace = "http://univ.fr/cv24")
    protected List<CertifType> certif;

    /**
     * Gets the value of the diplome property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the diplome property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDiplome().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DiplomeType }
     * 
     * 
     */
    public List<DiplomeType> getDiplome() {
        if (diplome == null) {
            diplome = new ArrayList<>();
        }
        return this.diplome;
    }

    /**
     * Gets the value of the certif property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the certif property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCertif().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CertifType }
     * 
     * 
     */
    public List<CertifType> getCertif() {
        if (certif == null) {
            certif = new ArrayList<>();
        }
        return this.certif;
    }

    public DiplomeType getHighestDiplomeByLevel() {
        return diplome.stream()
                .max(Comparator.comparingInt(DiplomeType::getNiveau))
                .orElse(null);
    }

}
