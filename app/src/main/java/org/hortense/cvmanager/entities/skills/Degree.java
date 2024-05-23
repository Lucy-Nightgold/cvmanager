package org.hortense.cvmanager.entities.skills;

import jakarta.persistence.*;
import org.hortense.cvmanager.entities.Cv;
import org.springframework.data.jpa.domain.AbstractPersistable;

import java.util.Date;

@Entity
@Table(name = "degree")
public class Degree extends AbstractPersistable<Long> {

    //attributes:

    @Column
    private int level;

    @Column(nullable = false)
    private Date date;

    @Column
    private String institute;

    @Column(nullable = false)
    private String title;

    @ManyToOne
    @JoinColumn(name = "cv_id", referencedColumnName = "id")
    private Cv cv;

    //constructors:

    public Degree(int level, Date date, String institute, String title, Cv cv) {
        this.level = level;
        this.date = date;
        this.institute = institute;
        this.title = title;
        this.cv = cv;
    }

    public Degree() {

    }

    //requests:

    public int getLevel() {
        return level;
    }

    public Date getDate() {
        return date;
    }

    public String getInstitute() {
        return institute;
    }

    public String getTitle() {
        return title;
    }

    public Cv getCv() {
        return cv;
    }

    //commands:

    public void setLevel(int level) {
        this.level = level;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setInstitute(String institute) {
        this.institute = institute;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCv(Cv cv) {
        this.cv = cv;
    }
}