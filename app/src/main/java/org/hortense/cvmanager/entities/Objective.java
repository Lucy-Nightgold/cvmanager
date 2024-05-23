package org.hortense.cvmanager.entities;

import jakarta.persistence.*;
import org.hortense.cvmanager.entities.types.Contract;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Table(name = "objective")
public class Objective extends AbstractPersistable<Long> {

    //attributes:

    @Column(nullable = false)
    private String job;

    @Column(nullable = false)
    private Contract contract;

    @OneToOne(cascade = CascadeType.REMOVE, mappedBy = "objective")
    private Cv cv;

    //constructors:

    public Objective(String job, Contract contract, Cv cv) {
        this.job = job;
        this.contract = contract;
        this.cv = cv;
    }

    public Objective() {

    }

    //requests:

    public String getJob() {
        return job;
    }

    public Contract getContract() {
        return contract;
    }

    public Cv getCv() {
        return cv;
    }

    //commands:

    public void setJob(String job) {
        this.job = job;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public void setCv(Cv cv) {
        this.cv = cv;
    }
}
