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

    public Collection<Aircraft> getDepartureAircrafts()
    {
        return departureAircrafts.values();
    }

    public Collection<Aircraft> getDepartureAircrafts(Date from, Date to)
    {
        ArrayList<Aircraft> aircrafts = new ArrayList<>();
        for(Date date : departureAircrafts.keySet())
        {
            if(date.compareTo(from) >= 0 && date.compareTo(to) <= 0) {
                aircrafts.add(departureAircrafts.get(date));
            }
        }
        return aircrafts;
    }

    public Collection<Aircraft> getArrivalAircrafts()
    {
        return arrivalAircrafts.values();
    }

    public Collection<Aircraft> getArrivalAircrafts(Date from, Date to)
    {
        ArrayList<Aircraft> aircrafts = new ArrayList<>();
        for(Date date : arrivalAircrafts.keySet())
        {
            if(date.compareTo(from) >= 0 && date.compareTo(to) <= 0) {
                aircrafts.add(arrivalAircrafts.get(date));
            }
        }
        return aircrafts;
    }

    public Collection<Aircraft> getParkingAircrafts()
    {
        return parkingAircrafts;
    }
}