package com.waliro78.Airline.Booking.exception;

/**
 * Created by User on 11/02/2020.
 */
public class ApiException extends RuntimeException {

    public ApiException(String message) {
        super(message);
    }
}
