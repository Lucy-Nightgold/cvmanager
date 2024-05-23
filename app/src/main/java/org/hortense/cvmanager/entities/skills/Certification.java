package org.hortense.cvmanager.entities.skills;

import jakarta.persistence.*;
import org.hortense.cvmanager.entities.Cv;
import org.springframework.data.jpa.domain.AbstractPersistable;

import java.util.Date;

@Entity
@Table(name = "certification")
public class Certification extends AbstractPersistable<Long> {

    //attributes

    @Column(nullable = false)
    private Date startDate;

    @Column
    private Date endDate;

    @Column(nullable = false)
    private String title;

    @ManyToOne
    @JoinColumn(name ="cv_id", referencedColumnName = "id")
    private Cv cv;

    //constructors

    public Certification(Date startDate, Date endDate, String title, Cv cv) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.title = title;
        this.cv = cv;
    }

    public Certification() {

    }

    //requests:

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public String getTitle() {
        return title;
    }

    public Cv getCv() {
        return cv;
    }

    //commands:

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCv(Cv cv) {
        this.cv = cv;
    }
}
