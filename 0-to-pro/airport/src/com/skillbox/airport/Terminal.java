package com.skillbox.airport;

import java.util.*;

public class Terminal
{
    private String name;

    private TreeMap<Date, Aircraft> departureAircrafts;
    private TreeMap<Date, Aircraft> arrivalAircrafts;
    private ArrayList<Aircraft> parkingAircrafts;

    public Terminal(String name)
    {
        this.name = name;
        departureAircrafts = new TreeMap<>();
        arrivalAircrafts = new TreeMap<>();
        parkingAircrafts = new ArrayList<>();
    }

    public void addDepartureAircraft(Date time, Aircraft aircraft)
    {
        departureAircrafts.put(time, aircraft);
    }

    public void addArrivalAircraft(Date time, Aircraft aircraft)
    {
        arrivalAircrafts.put(time, aircraft);
    }

    public void addParkingAircraft(Aircraft aircraft)
    {
        parkingAircrafts.add(aircraft);
    }

    public Collection<Departure> getDepartureAircrafts()
    {
        ArrayList<Departure> departures = new ArrayList<>();
        for(Date date : departureAircrafts.keySet())
        {
            departures.add(new Departure(departureAircrafts.get(date), date));
        }
        return departures;
    }

    public Collection<Departure> getDepartureAircrafts(Date from, Date to)
    {
        ArrayList<Departure> departures = new ArrayList<>();

        Set<Date> departureDates = departureAircrafts
                .subMap(from, true,
                        to, true)
                .keySet();

        for (Date date : departureDates)
        {
            departures.add(new Departure(departureAircrafts.get(date), date));
        }

        return departures;
    }

    public Collection<Arrival> getArrivalAircrafts()
    {
        ArrayList<Arrival> arrivals = new ArrayList<>();
        for(Date date : arrivalAircrafts.keySet())
        {
            arrivals.add(new Arrival(arrivalAircrafts.get(date), date));
        }
        return arrivals;
    }

    public Collection<Arrival> getArrivalAircrafts(Date from, Date to)
    {
        ArrayList<Arrival> arrivals = new ArrayList<>();

        Set<Date> arrivalDates = arrivalAircrafts
                .subMap(from, true,
                        to, true)
                .keySet();

        for (Date date : arrivalDates)
        {
            arrivals.add(new Arrival(arrivalAircrafts.get(date), date));
        }
        return arrivals;
    }

    public Collection<Aircraft> getParkingAircrafts()
    {
        return parkingAircrafts;
    }
}
