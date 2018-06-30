package com.example.flightnetwork.searchflights.web;


import com.example.flightnetwork.searchflights.model.Flight;
import com.example.flightnetwork.searchflights.service.FlightServiceHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {


    @Autowired
    FlightServiceHandler flightServiceHandler;

    @RequestMapping(value = "searchFlights/{origin}/{destination}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Flight>> searchFlights(@PathVariable String origin,@PathVariable String destination){
        return new ResponseEntity<>(flightServiceHandler.getFlight(origin,destination),HttpStatus.OK);
    }
}
