package com.skillbox.airport;

import java.time.Duration;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAmount;
import java.time.temporal.TemporalUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class Airport
{
    private final Random random;
    private List<Terminal> terminals;

    private Airport()
    {
        terminals = new ArrayList<>();
        random = new Random(1);
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
            for(Flight flight : terminal.getFlights())
            {
                aircraftList.add(flight.getAircraft());
            }
            aircraftList.addAll(terminal.getParkedAircrafts());
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
                double type = Math.random();
                if(type <= 0.33) {
                    terminal.addFlight(generateFlight(Flight.Type.DEPARTURE));
                }
                else if(type <= 0.8) {
                    terminal.addFlight(generateFlight(Flight.Type.ARRIVAL));
                }
                else {
                    terminal.addParkingAircraft(generateAircraft());
                }
            }
            terminals.add(terminal);
        }
    }

    private Flight generateFlight(Flight.Type type) {
        return new Flight(generateFlightName(), type, generateRandomDate(), generateAircraft());
    }

    private Date generateRandomDate()
    {
        long currentTime = System.currentTimeMillis();
        long randomTime = currentTime + (long)((random.nextDouble() - 0.5) * 2 * 86400000);
        return new Date(randomTime);
    }

    private String generateFlightName()
    {
        String companyCodes[] = {
                "SU",
                "AA",
                "AR",
                "AF",
                "B2",
                "FV"
        };
        String companyPrefix = companyCodes[random.nextInt(companyCodes.length)];
        int routeNumber = random.nextInt(9999) + 1;
        return companyPrefix + " " + routeNumber;
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
        String randomModel = models[random.nextInt(models.length)];
        return new Aircraft(randomModel);
    }
}
