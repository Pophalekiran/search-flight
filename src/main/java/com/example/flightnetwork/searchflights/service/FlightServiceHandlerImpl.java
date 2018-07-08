package com.example.flightnetwork.searchflights.service;

import com.example.flightnetwork.searchflights.model.Flight;
import com.example.flightnetwork.searchflights.repository.FlightRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class FlightServiceHandlerImpl implements FlightServiceHandler {

    @Autowired
    FlightRepo flightRepo;

    @Override
    public List<Flight> getFlight(String origin, String destination) {
        List<Flight> flights = flightRepo.searchFlight(origin, destination);
        Collections.sort(flights, this::compareByPriceAndDepartureTime);
        return flights;
    }

    private int compareByPriceAndDepartureTime(Flight flight, Flight flight1){
        int compariosion = flight.getPrice().compareTo(flight1.getPrice());
        if(compariosion!=0){
            return compariosion;
        }
        compariosion = flight.getDepartureTime().compareTo(flight1.getDepartureTime());
        return compariosion ;
    }

}
