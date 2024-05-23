package org.hortense.cvmanager.entities;

import jakarta.persistence.*;
import org.springframework.data.jpa.domain.AbstractPersistable;

import java.util.Date;

@Entity
@Table(name = "experience")
public class Experience extends AbstractPersistable<Long> {

    //attributes:

    @Column(nullable = false)
    private Date startDate;

    @Column
    private Date endDate;

    @Column(nullable = false)
    private String title;

    @ManyToOne
    @JoinColumn(name = "cv_id", referencedColumnName = "id")
    private Cv cv;

    //constructors:

    public Experience(Date startDate, Date endDate, String title, Cv cv) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.title = title;
        this.cv = cv;
    }

    public Experience() {

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
