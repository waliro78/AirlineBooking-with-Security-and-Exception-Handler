package com.waliro78.Airline.Booking.repository;

import com.waliro78.Airline.Booking.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by User on 2/12/2020.
 */
@Repository
public interface UserRespository extends JpaRepository<User, Integer>   {
   User findByUsername(String username);
}
