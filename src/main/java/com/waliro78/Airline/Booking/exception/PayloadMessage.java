package com.waliro78.Airline.Booking.exception;

import org.springframework.http.HttpStatus;

import java.time.LocalTime;

/**
 * Created by User on 11/02/2020.
 */
public class PayloadMessage {

    private final String message;
    private final HttpStatus httpStatus;
    private final LocalTime timestamp;

    public PayloadMessage(String message,
                          HttpStatus httpStatus,
                          LocalTime timestamp) {
        this.message = message;
        this.httpStatus = httpStatus;
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public LocalTime getTimestamp() {
        return timestamp;
    }
}
