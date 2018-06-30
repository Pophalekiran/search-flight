package com.example.flightnetwork.searchflights.testcases;


import com.example.flightnetwork.searchflights.model.Flight;
import com.example.flightnetwork.searchflights.repository.FlightRepo;
import com.example.flightnetwork.searchflights.service.FlightServiceHandlerImpl;
import com.example.flightnetwork.searchflights.util.StringUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class FlightServiceHandlerImplTest {

    @InjectMocks
    FlightServiceHandlerImpl flightServiceHandler;

    @Mock
    FlightRepo flightRepo;

    @Test
    public void testFlightFromYYZtoYYC() throws ParseException {
        Flight firstFlight = new Flight("YYZ", StringUtil.parseDate("2014-06-15 06:45:00"), "YYC", StringUtil.parseDate("2014-06-15 08:54:00"), 578.0);
        Flight secondFlight = new Flight("YYZ", StringUtil.parseDate("2014-06-26 12:00:00"), "YYC", StringUtil.parseDate("2014-06-26 14:09:00"), 630.0);
        List<Flight> lstFlight = new ArrayList<>();
        lstFlight.add(firstFlight);
        lstFlight.add(secondFlight);
        when(flightRepo.searchFlight("YYZ", "YYC")).thenReturn(lstFlight);
        List<Flight> lstResult = flightServiceHandler.getFlight("YYZ", "YYC");
        assertThat(lstResult, is(lstFlight));
    }

    @Test
    public void testFlightFromYYCtoYYZ() throws ParseException {
        Flight firstFlight = new Flight("YYC", StringUtil.parseDate("2014-06-15 06:45:00"), "YYZ", StringUtil.parseDate("2014-06-15 08:54:00"), 578.0);
        Flight secondFlight = new Flight("YYC", StringUtil.parseDate("2014-06-26 12:00:00"), "YYZ", StringUtil.parseDate("2014-06-26 14:09:00"), 630.0);
        List<Flight> lstFlight = new ArrayList<>();
        lstFlight.add(firstFlight);
        lstFlight.add(secondFlight);
        when(flightRepo.searchFlight("YYC", "YYZ")).thenReturn(lstFlight);
        List<Flight> lstResult = flightServiceHandler.getFlight("YYC", "YYZ");
        assertThat(lstResult, is(lstFlight));
    }

}
