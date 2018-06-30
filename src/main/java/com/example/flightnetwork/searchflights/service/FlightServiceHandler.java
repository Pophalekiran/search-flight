package com.example.flightnetwork.searchflights.service;

import com.example.flightnetwork.searchflights.model.Flight;

import java.util.List;

public interface FlightServiceHandler {
    public List<Flight> getFlight(String origin, String destination);
}
