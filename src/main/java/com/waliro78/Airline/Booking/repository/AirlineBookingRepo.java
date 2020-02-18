package com.waliro78.Airline.Booking.repository;

import com.waliro78.Airline.Booking.entity.AirlineBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by WALE on 03/12/2019.
 */
@Repository
public interface AirlineBookingRepo extends JpaRepository<AirlineBooking,Integer> {

}
