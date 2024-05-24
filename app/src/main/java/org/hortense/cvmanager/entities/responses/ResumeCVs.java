package org.hortense.cvmanager.entities.responses;

import jakarta.xml.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "cvs", namespace = "http://univ.fr/cv24")
@XmlType(name = "cvs", namespace = "http://univ.fr/cv24")
@XmlAccessorType(XmlAccessType.FIELD)
public class ResumeCVs {

    @XmlElement(name = "cv_resume", namespace = "http://univ.fr/cv24")
    private List<ResumeCv> resumeCVs;



    public ResumeCVs(List<ResumeCv> resumeCVs) {
        this.resumeCVs = resumeCVs;
    }

    public ResumeCVs() {
        this.resumeCVs = new ArrayList<ResumeCv>();
    }



    public List<ResumeCv> getResumeCVs() {
        return resumeCVs;
    }

    public void addResumeCv(ResumeCv resumeCv) {
        this.resumeCVs.add(resumeCv);
    }

    public void setResumeCVs(List<ResumeCv> resumeCVs) {
        this.resumeCVs = resumeCVs;
    }
}
