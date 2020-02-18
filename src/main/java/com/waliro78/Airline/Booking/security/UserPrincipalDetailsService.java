package com.waliro78.Airline.Booking.security;

import com.waliro78.Airline.Booking.entity.User;
import com.waliro78.Airline.Booking.entity.UserPrincipal;
import com.waliro78.Airline.Booking.repository.UserRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by User on 2/13/2020.
 */
@Service
public class UserPrincipalDetailsService implements UserDetailsService {
    @Autowired
    private UserRespository userRespository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRespository.findByUsername(username);
        UserPrincipal userPrincipal = new UserPrincipal(user);
        return userPrincipal;
    }
}
