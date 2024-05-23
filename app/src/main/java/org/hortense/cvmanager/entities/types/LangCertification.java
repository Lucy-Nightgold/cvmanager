package org.hortense.cvmanager.entities.types;

public enum LangCertification {

    MAT("mat"),
    CLES("cles"),
    TOEIC("toeic");

    private String name;

    private LangCertification(String name) {}

    @Override
    public String toString() {
        return name;
    }
}
