package com.skillbox.airport;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Airport
{
    private List<Terminal> terminals;

    private Airport()
    {
        terminals = new ArrayList<>();
    }

    public static Airport getInstance()
    {
        var airport = new Airport();
        airport.initializeAirport();
        return airport;
    }

    public List<Aircraft> getAllAircrafts()
    {
        List<Aircraft> aircraftList = new ArrayList<Aircraft>();
        for(Terminal terminal : terminals)
        {
            aircraftList.addAll(terminal.getArrivalAircrafts());
            aircraftList.addAll(terminal.getDepartureAircrafts());
            aircraftList.addAll(terminal.getParkingAircrafts());
        }
        return aircraftList;
    }

    public List<Terminal> getTerminals()
    {
        return terminals;
    }

    //=========================================================================

    private void initializeAirport()
    {
        String terminalNames[] = {"A", "B", "C", "D"};
        int aircraftsCount = 125 + (int)((Math.random() - 0.5) * 50);
        for(String terminalName : terminalNames)
        {
            var terminal = new Terminal(terminalName);
            for(int i = 0; i < aircraftsCount; i++)
            {
                Aircraft aircraft = generateAircraft();
                double type = Math.random();
                if(type <= 0.33) {
                    terminal.addDepartureAircraft(generateRandomDate(), aircraft);
                }
                else if(type <= 0.8) {
                    terminal.addArrivalAircraft(generateRandomDate(), aircraft);
                }
                else {
                    terminal.addParkingAircraft(aircraft);
                }
            }
            terminals.add(terminal);
        }
    }

    private Date generateRandomDate()
    {
        long currentTime = System.currentTimeMillis();
        long randomTime = currentTime + (long)((Math.random() - 0.5) * 2 * 86400000);
        return new Date(randomTime);
    }

    private Aircraft generateAircraft()
    {
        String models[] = {
            "Boeing 737-200",
            "Boeing 737-800",
            "Boeing 777-200",
            "Airbus A-320",
            "Airbus A-319",
            "Airbus A-321"
        };
        String randomModel = models[(int)(models.length * Math.random())];
        return new Aircraft(randomModel);
    }
}