package com.waliro78.Airline.Booking.service;

/**
 * Created by User on 2/12/2020.
 */

import com.waliro78.Airline.Booking.entity.User;
import com.waliro78.Airline.Booking.repository.UserRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public  class UserService {

    @Autowired
    UserRespository userRespository;

    public User createUser(User user){
        return userRespository.save(user);
    }
}
