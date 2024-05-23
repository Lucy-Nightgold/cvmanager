package org.hortense.cvmanager.entities.miscellaneaous;

import jakarta.persistence.*;
import org.hortense.cvmanager.entities.Cv;
import org.hortense.cvmanager.entities.types.LangCertification;
import org.hortense.cvmanager.entities.types.LanguageLevel;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Table(name = "language")
public class Language extends AbstractPersistable<Long> {

    //attributes:

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private LangCertification certification;

    @Column
    private LanguageLevel level;

    @Column
    private int numLevel;

    @ManyToOne
    @JoinColumn(name ="cv_id", referencedColumnName = "id")
    private Cv cv;

    //constructors:

    public Language(String name, LangCertification certification, LanguageLevel level, int numLevel, Cv cv) {
        this.name = name;
        this.certification = certification;
        this.level = level;
        this.numLevel = numLevel;
        this.cv = cv;
    }

    public Language() {

    }

    //requests

    public String getName() {
        return name;
    }

    public LangCertification getCertification() {
        return certification;
    }

    public LanguageLevel getLevel() {
        return level;
    }

    public int getNumLevel() {
        return numLevel;
    }

    public Cv getCv() {
        return cv;
    }

    //commands

    public void setName(String name) {
        this.name = name;
    }

    public void setCertification(LangCertification certification) {
        this.certification = certification;
    }

    public void setLevel(LanguageLevel level) {
        this.level = level;
    }

    public void setNumLevel(int numLevel) {
        this.numLevel = numLevel;
    }

    public void setCv(Cv cv) {
        this.cv = cv;
    }
}
