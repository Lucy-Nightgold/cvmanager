//
// Ce fichier a été généré par Eclipse Implementation of JAXB, v3.0.2 
// Voir https://eclipse-ee4j.github.io/jaxb-ri 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2024.05.23 à 08:44:18 PM CEST 
//


package org.hortense.cvmanager.entities;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour certType.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * <pre>
 * &lt;simpleType name="certType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="MAT"/&gt;
 *     &lt;enumeration value="CLES"/&gt;
 *     &lt;enumeration value="TOEIC"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "certType", namespace = "http://univ.fr/cv24")
@XmlEnum
public enum CertType {

    MAT,
    CLES,
    TOEIC;

    public String value() {
        return name();
    }

    public static CertType fromValue(String v) {
        return valueOf(v);
    }

}
