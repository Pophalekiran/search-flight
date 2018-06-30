package com.example.flightnetwork.searchflights.model;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.text.ParseException;
import java.util.Date;
import java.util.Objects;

import static com.example.flightnetwork.searchflights.util.StringUtil.parseDate;


@ToString

public class Flight implements Serializable {
    private String origin;
    private Date departureTime;
    private String destination;
    private Date destinationTime;
    private Double price;

    public Flight(String origin, Date departureTime, String destination, Date destinationTime, Double price) {
        this.origin = origin;
        this.departureTime = departureTime;
        this.destination = destination;
        this.destinationTime = destinationTime;
        this.price = price;
    }

    public Flight(String[] string) throws ParseException {
        this.origin = string[0];
        this.departureTime = parseDate(string[1]);
        this.destination = string[2];
        this.destinationTime = parseDate(string[3]);
        this.price = Double.parseDouble(string[4].substring(1, string[4].length()));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Flight)) return false;
        Flight flight = (Flight) o;
        return Objects.equals(getOrigin(), flight.getOrigin()) &&
                Objects.equals(getDepartureTime(), flight.getDepartureTime()) &&
                Objects.equals(getDestination(), flight.getDestination()) &&
                Objects.equals(getDestinationTime(), flight.getDestinationTime()) &&
                Objects.equals(getPrice(), flight.getPrice());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getOrigin(), getDepartureTime(), getDestination(), getDestinationTime(), getPrice());
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Date getDestinationTime() {
        return destinationTime;
    }

    public void setDestinationTime(Date destinationTime) {
        this.destinationTime = destinationTime;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
