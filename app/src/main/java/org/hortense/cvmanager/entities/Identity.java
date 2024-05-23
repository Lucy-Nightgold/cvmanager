package org.hortense.cvmanager.entities;

import jakarta.persistence.*;
import org.hortense.cvmanager.entities.types.Gender;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Table(name = "identity")
public class Identity extends AbstractPersistable<Long> {

    //attributes

    @Column(nullable = false)
    private Gender gender;

    @Column(nullable = false)
    private String lastname;

    @Column(nullable = false)
    private String firstname;

    @Column
    private Long phoneNumber;

    @Column
    private String email;

    @OneToOne(cascade = CascadeType.REMOVE, mappedBy = "identity")
    private Cv cv;

    //constructors:

    public Identity(Gender gender, String lastname, String firstname, Long phoneNumber, String email, Cv cv) {
        this.gender = gender;
        this.lastname = lastname;
        this.firstname = firstname;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.cv = cv;
    }

    public Identity() {

    }

    //requests:

    public Gender getGender() {
        return gender;
    }

    public String getLastname() {
        return lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public Cv getCv() {
        return cv;
    }

    //commands:

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCv(Cv cv) {
        this.cv = cv;
    }
}
