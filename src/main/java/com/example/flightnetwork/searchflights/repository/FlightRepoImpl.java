package com.example.flightnetwork.searchflights.repository;

import com.example.flightnetwork.searchflights.exception.SearchFlightsException;
import com.example.flightnetwork.searchflights.model.Flight;
import com.example.flightnetwork.searchflights.util.ReadFileUtil;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Component
public class FlightRepoImpl implements FlightRepo {

    private Set<Flight> getAllFlights(){
        return ReadFileUtil.getFlights();
    }

    @Override
    public List<Flight> searchFlight(String origin, String destination) {
        Set<Flight> flights = getAllFlights();
        List<Flight> flights1 = new ArrayList<>();
        for (Flight flight: flights){
            if(flight.getDestination().equals(destination) && flight.getOrigin().equals(origin)){
                flights1.add(flight);
            }
        }
        if(flights1.size()==0){
            throw new SearchFlightsException("No Flights Found for"+ destination +" --> "+ destination);
        }
            return flights1;
    }
}
