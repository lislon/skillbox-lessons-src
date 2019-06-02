package com.skillbox.airport;

import java.util.Date;

public class Arrival {
    private Aircraft aircraft;
    private Date time;

    Arrival(Aircraft aircraft, Date time) {
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
        return "Arrival{" +
                "aircraft=" + aircraft +
                ", time=" + time +
                '}';
    }
}
