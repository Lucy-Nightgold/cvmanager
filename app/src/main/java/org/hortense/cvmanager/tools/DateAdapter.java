package org.hortense.cvmanager.tools;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateAdapter extends XmlAdapter<String, LocalDate> {

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ISO_LOCAL_DATE;

    @Override
    public String marshal(LocalDate date) {
        return date.format(DATE_TIME_FORMATTER);
    }

    @Override
    public LocalDate unmarshal(String date) {
        return LocalDate.parse(date, DATE_TIME_FORMATTER);
    }

}