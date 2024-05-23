package org.hortense.cvmanager.entities.miscellaneaous;

import jakarta.persistence.*;
import org.hortense.cvmanager.entities.Cv;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Table(name = "other")
public class Other extends AbstractPersistable<Long> {

    //attributes:

    @Column(nullable = false)
    private String title;

    @Column
    private String comment;

    @ManyToOne
    @JoinColumn(name = "cv_id", referencedColumnName = "id")
    private Cv cv;

    //constructors

    public Other(String title, String comment, Cv cv) {
        this.title = title;
        this.comment = comment;
        this.cv = cv;
    }

    public Other() {

    }

    //requests:

    public String getTitle() {
        return title;
    }

    public String getComment() {
        return comment;
    }

    public Cv getCv() {
        return cv;
    }

    //commands:

    public void setTitle(String title) {
        this.title = title;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setCv(Cv cv) {
        this.cv = cv;
    }
}
