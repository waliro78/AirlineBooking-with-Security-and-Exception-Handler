package com.waliro78.Airline.Booking;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication

public class AirlineBookingApplication {

	public static void main(String[] args) {
//		PasswordEncoder bcry = new BCryptPasswordEncoder();
//		String word = "jesus";
//		String cod = bcry.encode(word);
//		System.out.println(cod);

		SpringApplication.run(AirlineBookingApplication.class, args);

	}
}

