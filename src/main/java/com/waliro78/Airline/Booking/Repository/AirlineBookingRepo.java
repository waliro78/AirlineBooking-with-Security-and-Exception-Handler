package com.waliro78.Airline.Booking.Repository;

import com.waliro78.Airline.Booking.Entity.AirlineBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by WALE on 03/12/2019.
 */
@Repository
public interface AirlineBookingRepo extends JpaRepository<AirlineBooking,Integer> {

}
