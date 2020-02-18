package com.waliro78.Airline.Booking.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by WALE on 03/12/2019.
 */
@Entity
@Table(name = "AirlineBookingTable")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class AirlineBooking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ticketId;

    @Column(name = "passengerName")
    @NotBlank(message = "Value MUST be inputted")
    private String passengerName;

    @Column(name = "destination")
    @NotBlank(message = "Value MUST be inputted")
    private String destination;

    @Column(name = "departure")
    @NotBlank(message = "Value MUST be inputted")
    private String departure;

    @Column(name = "contact")
    @NotBlank(message = "Value MUST be inputted")
    private String contact;

    @Column(name = "address")
    @NotBlank(message = "Value MUST be inputted")
    private String address;

    @Column(name = "bookedDate")
    @NotBlank(message = "Value MUST be inputted")
    private String bookedDate;

    public Integer getTicketId() {
        return ticketId;
    }

    public void setTicketId(Integer ticketId) {
        this.ticketId = ticketId;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBookedDate() {
        return bookedDate;
    }

    public void setBookedDate(String bookedDate) {
        String pattern = "dd:MM:yyyy  hh:mm";
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        bookedDate = dateFormat.format(new Date());
        this.bookedDate = bookedDate;
    }
}
