package org.hortense.cvmanager.entities.types;

public enum Contract {

    JOB("emploi"),
    INTERNSHIP("stage");

    private String name;

    private Contract(String name) {}

    @Override
    public String toString() {
        return name;
    }
}
