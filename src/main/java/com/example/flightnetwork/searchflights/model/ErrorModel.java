package com.example.flightnetwork.searchflights.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;



public class ErrorModel {
    private HttpStatus status;
    private String error;

    public HttpStatus getStatus() {
        return status;
    }

    public ErrorModel(HttpStatus status, String error) {
        this.status = status;
        this.error = error;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
