package org.hortense.cvmanager.entities;

import jakarta.persistence.*;
import org.hortense.cvmanager.entities.miscellaneaous.Language;
import org.hortense.cvmanager.entities.miscellaneaous.Other;
import org.hortense.cvmanager.entities.skills.Certification;
import org.hortense.cvmanager.entities.skills.Degree;
import org.springframework.data.jpa.domain.AbstractPersistable;

import java.util.List;

@Entity
@Table(name = "cv")
public class Cv extends AbstractPersistable<Long> {

    //attributes:

    @OneToOne
    @JoinColumn(name = "identity_id", referencedColumnName = "id")
    private Identity identity;

    @OneToOne
    @JoinColumn(name = "objective_id", referencedColumnName = "id")
    private Objective objective;

    @OneToMany(mappedBy = "cv")
    private List<Experience> experiences;

    @OneToMany(mappedBy = "cv")
    private List<Degree> degrees;

    @OneToMany(mappedBy = "cv")
    private List<Certification> certifications;

    @OneToMany(mappedBy = "cv")
    private List<Language> languages;

    @OneToMany(mappedBy = "cv")
    private List<Other> others;

    //constructors:

    public Cv() {

    }

    //requests:

    public Identity getIdentity() {
        return identity;
    }

    public Objective getObjective() {
        return objective;
    }

    public List<Experience> getExperiences() {
        return experiences;
    }

    public List<Degree> getDegrees() {
        return degrees;
    }

    public List<Certification> getCertifications() {
        return certifications;
    }

    public List<Language> getLanguages() {
        return languages;
    }

    public List<Other> getOthers() {
        return others;
    }

    //commands:

    public void setIdentity(Identity identity) {
        this.identity = identity;
    }

    public void setObjective(Objective objective) {
        this.objective = objective;
    }

    public void setExperiences(List<Experience> experiences) {
        this.experiences = experiences;
    }

    public void setDegrees(List<Degree> degrees) {
        this.degrees = degrees;
    }

    public void setCertifications(List<Certification> certifications) {
        this.certifications = certifications;
    }

    public void setLanguages(List<Language> languages) {
        this.languages = languages;
    }

    public void setOthers(List<Other> others) {
        this.others = others;
    }
}
