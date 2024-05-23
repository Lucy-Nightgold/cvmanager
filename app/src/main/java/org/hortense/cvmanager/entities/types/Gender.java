package org.hortense.cvmanager.entities.types;

public enum Gender {

    MME("Mme","fr"),
    M("M.","fr"),
    MRS("Mrs","en"),
    MISS("Miss","en"),
    MR("Mr","en");

    private String name;
    private String language;

    private Gender(String name, String language) {}

    @Override
    public String toString() {
        return name;
    }
}
