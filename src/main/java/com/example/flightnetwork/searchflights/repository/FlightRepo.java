package com.example.flightnetwork.searchflights.repository;

import com.example.flightnetwork.searchflights.model.Flight;

import java.util.List;

public interface FlightRepo {
    public List<Flight> searchFlight(String origin, String destination);
}
