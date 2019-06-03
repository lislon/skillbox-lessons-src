package com.skillbox.airport;

import java.util.*;

public class Terminal {
    private String name;

    private List<Flight> flights;
    private List<Aircraft> parkedAircrafts;

    public Terminal(String name) {
        this.name = name;
        flights = new ArrayList<>();
        parkedAircrafts = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public List<Aircraft> getParkedAircrafts() {
        return parkedAircrafts;
    }

    public void addFlight(Flight flight) {
        flights.add(flight);
    }

    public void addParkingAircraft(Aircraft aircraft) {
        parkedAircrafts.add(aircraft);
    }
}
