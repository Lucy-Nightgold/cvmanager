//
// Ce fichier a été généré par Eclipse Implementation of JAXB, v3.0.2 
// Voir https://eclipse-ee4j.github.io/jaxb-ri 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2024.05.23 à 08:44:18 PM CEST 
//


package org.hortense.cvmanager.entities;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour statutType.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * <pre>
 * &lt;simpleType name="statutType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="stage"/&gt;
 *     &lt;enumeration value="emploi"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "statutType", namespace = "http://univ.fr/cv24")
@XmlEnum
public enum StatutType {

    @XmlEnumValue("stage")
    STAGE("stage"),
    @XmlEnumValue("emploi")
    EMPLOI("emploi");
    private final String value;

    StatutType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static StatutType fromValue(String v) {
        for (StatutType c: StatutType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
