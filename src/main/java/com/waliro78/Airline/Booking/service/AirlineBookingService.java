package com.waliro78.Airline.Booking.service;

import com.waliro78.Airline.Booking.entity.AirlineBooking;
import com.waliro78.Airline.Booking.repository.AirlineBookingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by WALE on 03/12/2019.
 */
@Service
public class AirlineBookingService {

    @Autowired
    private AirlineBookingRepo airlineBookingRepo;

    public AirlineBooking bookTicket(AirlineBooking airlineBooking){
        return airlineBookingRepo.save(airlineBooking);
    }
    public boolean bookingTrue(Object object){
        return airlineBookingRepo.equals(object);
    }

    public AirlineBooking findById(Integer ticketId) {
       return airlineBookingRepo.getOne(ticketId);
    }

    public boolean existById(Integer ticketId){
        return airlineBookingRepo.existsById(ticketId);
    }
    public List<AirlineBooking> listAllTicket(){
       return airlineBookingRepo.findAll();
    }
}
