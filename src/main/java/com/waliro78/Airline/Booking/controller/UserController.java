package com.waliro78.Airline.Booking.controller;

import com.waliro78.Airline.Booking.entity.User;
import com.waliro78.Airline.Booking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by User on 2/12/2020.
 */
@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("sales/usercreation")
    public User createANewuser(@RequestBody User user) {
        return userService.createUser(user);
    }
}
