package com.waliro78.Airline.Booking.Componet;

import com.waliro78.Airline.Booking.Entity.AirlineBooking;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * Created by WALE on 03/12/2019.
 */
public class AirlineBookingResponse {

        private AirlineBooking airlineBooking;
        private String actionCode;
        private String reason;



    public AirlineBooking getAirlineBooking() {
        return airlineBooking;
    }

    public void setAirlineBooking (AirlineBooking airlineBooking) {
        this.airlineBooking = airlineBooking;
    }

    public String getActionCode() {
        return actionCode;
    }

    public void setActionCode(String actionCode) {
        this.actionCode = actionCode;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

}
