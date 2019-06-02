package com.skillbox.airport;

import java.util.Date;

public class Departure {
    private Aircraft aircraft;
    private Date time;

    Departure(Aircraft aircraft, Date time) {
        this.aircraft = aircraft;
        this.time = time;
    }

    public Aircraft getAircraft() {
        return aircraft;
    }

    public Date getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "Departure{" +
                "aircraft=" + aircraft +
                ", time=" + time +
                '}';
    }
}
