package com.skillbox.airport;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Flight {
    private static final SimpleDateFormat HOUR_FORMAT = new SimpleDateFormat("HH:mm");

    private String code;
    private Type type;
    private Date date;
    private Aircraft aircraft;

    public Flight(String code, Type type, Date date, Aircraft aircraft) {
        this.code = code;
        this.type = type;
        this.date = date;
        this.aircraft = aircraft;
    }

    public String getCode() {
        return code;
    }

    public Type getType() {
        return type;
    }

    public Date getDate() {
        return date;
    }

    public Aircraft getAircraft() {
        return aircraft;
    }

    @Override
    public String toString() {
        return HOUR_FORMAT.format(date) + " / " + code + " / " + type;
    }

    public enum Type {
        ARRIVAL,
        DEPARTURE
    }
}
