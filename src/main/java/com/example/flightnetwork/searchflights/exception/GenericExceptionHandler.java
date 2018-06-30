package com.example.flightnetwork.searchflights.exception;

import com.example.flightnetwork.searchflights.model.ErrorModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GenericExceptionHandler {


    @ExceptionHandler(RuntimeException.class)
     public ResponseEntity<ErrorModel>  generateRuntimeError(Exception ex){
        return new ResponseEntity<>(new ErrorModel(HttpStatus.INTERNAL_SERVER_ERROR,ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
     }

        @ExceptionHandler(SearchFlightsException.class)
     public ResponseEntity<ErrorModel> generateFlightNotFoundException(Exception ex){
        return new ResponseEntity<>(new ErrorModel(HttpStatus.NOT_FOUND,ex.getMessage()), HttpStatus.NOT_FOUND);
     }

}
