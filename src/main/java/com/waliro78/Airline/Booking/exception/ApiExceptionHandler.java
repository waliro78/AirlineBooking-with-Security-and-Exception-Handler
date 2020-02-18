package com.waliro78.Airline.Booking.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalTime;

/**
 * Created by User on 11/02/2020.
 */
@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value={ApiException.class})
    public ResponseEntity<Object> exceptionHandler(ApiException apiException){
        //1.create payload containing the details
        //2.return ResponseEntity
        HttpStatus status =HttpStatus.BAD_REQUEST;
        PayloadMessage payloadMessage =new PayloadMessage(
                apiException.getMessage(),
                status =HttpStatus.BAD_REQUEST,
                LocalTime.now());
    return new ResponseEntity<Object>(payloadMessage,status);
    }
    @ExceptionHandler(value = {ApiGetTicketIdException.class})
    public ResponseEntity<Object> exception2 (ApiGetTicketIdException ticketIdException){
        HttpStatus server = HttpStatus.NOT_FOUND;
        PayloadMessage message = new PayloadMessage(
                ticketIdException.getMessage(),
                server,
                LocalTime.now());
        return new ResponseEntity<>(message,server);

    }
}
