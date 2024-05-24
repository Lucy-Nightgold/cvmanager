package org.hortense.cvmanager.entities.responses;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.hortense.cvmanager.entities.DiplomeType;
import org.hortense.cvmanager.entities.IdentiteType;
import org.hortense.cvmanager.entities.ObjectifType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cv_resume", namespace = "http://univ.fr/cv24")
public class ResumeCv {

    @XmlElement(namespace = "http://univ.fr/cv24")
    private Long id;

    @XmlElement(name = "identite", namespace = "http://univ.fr/cv24")
    private IdentiteType identiteType;

    @XmlElement(name = "objectif", namespace = "http://univ.fr/cv24")
    private ObjectifType objectifType;

    @XmlElement(name = "diplome", namespace = "http://univ.fr/cv24")
    private DiplomeType diplomeType;

    public IdentiteType getIdentiteType() {
        return identiteType;
    }

    public void setIdentiteType(IdentiteType identiteType) {
        this.identiteType = identiteType;
    }

    public ObjectifType getObjectifType() {
        return objectifType;
    }

    public void setObjectifType(ObjectifType objectifType) {
        this.objectifType = objectifType;
    }

    public DiplomeType getDiplomeType() {
        return diplomeType;
    }

    public void setDiplomeType(DiplomeType diplomeType) {
        this.diplomeType = diplomeType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
