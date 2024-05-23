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
 * <p>Classe Java pour nivsType.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * <pre>
 * &lt;simpleType name="nivsType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="A1"/&gt;
 *     &lt;enumeration value="A2"/&gt;
 *     &lt;enumeration value="B1"/&gt;
 *     &lt;enumeration value="B2"/&gt;
 *     &lt;enumeration value="C1"/&gt;
 *     &lt;enumeration value="C2"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "nivsType", namespace = "http://univ.fr/cv24")
@XmlEnum
public enum NivsType {

    @XmlEnumValue("A1")
    A_1("A1"),
    @XmlEnumValue("A2")
    A_2("A2"),
    @XmlEnumValue("B1")
    B_1("B1"),
    @XmlEnumValue("B2")
    B_2("B2"),
    @XmlEnumValue("C1")
    C_1("C1"),
    @XmlEnumValue("C2")
    C_2("C2");
    private final String value;

    NivsType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static NivsType fromValue(String v) {
        for (NivsType c: NivsType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
