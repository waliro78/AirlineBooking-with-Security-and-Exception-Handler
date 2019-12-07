package com.waliro78.Airline.Booking.Controller;

import com.waliro78.Airline.Booking.Componet.AirlineBookingResponse;
import com.waliro78.Airline.Booking.Entity.AirlineBooking;
import com.waliro78.Airline.Booking.Service.AirlineBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Created by WALE on 03/12/2019.
 */
@RestController
@RequestMapping("/api")
public class AirlineBookingController {

    @Autowired
    private AirlineBookingService airlineBookingService;

    private List<AirlineBooking> airlineBooking;


    @PostMapping("/bookTicket")
    public ResponseEntity<AirlineBooking> bookTicket(@RequestBody AirlineBooking airlineBooking){
        try {
            AirlineBookingResponse airlineBookingResponse = new AirlineBookingResponse();
            HttpStatus serverResponse;
            airlineBookingService.bookTicket(airlineBooking);
            airlineBookingResponse.setActionCode("201");
            airlineBookingResponse.setReason("Ticket Successfully Booked!");
            airlineBookingResponse.setAirlineBooking(airlineBooking);
            serverResponse = HttpStatus.CREATED;
            return new ResponseEntity(airlineBookingResponse, serverResponse);
        }
        catch(Exception exception){
            HttpStatus serverResponse = HttpStatus.BAD_REQUEST;
            AirlineBookingResponse airlineBookingResponse = new AirlineBookingResponse();
            airlineBookingResponse.setActionCode("400");
            airlineBookingResponse.setReason("BAD Request :"  + exception.getMessage());
//            airlineBookingResponse.setReason(exception.getMessage());
            return new ResponseEntity(airlineBookingResponse, serverResponse);
        }
    }
    @GetMapping("/getBookedTicket/{ticketId}")
    public ResponseEntity<AirlineBooking> getBookedTicket(@PathVariable("ticketId") Integer ticketId, AirlineBooking airlineBooking){
        AirlineBookingResponse airlineBookingResponse = new AirlineBookingResponse();
        HttpStatus serverResponse = HttpStatus.FOUND;
        airlineBooking = airlineBookingService.findById(ticketId);
        if(airlineBookingService.existById(ticketId)==true){
            airlineBookingResponse.setActionCode("302");
            airlineBookingResponse.setReason("Ticket Record Found ");
            airlineBookingResponse.setAirlineBooking(airlineBooking);
            return new ResponseEntity(airlineBookingResponse,serverResponse);
        }
        else{
             serverResponse = HttpStatus.NOT_FOUND;
             airlineBookingResponse = new AirlineBookingResponse();
            airlineBookingResponse.setActionCode("404");
            airlineBookingResponse.setReason("Request NOT Found "  );
            return new ResponseEntity(airlineBookingResponse, serverResponse);

        }
    }
    @PutMapping("/updateTicket/{ticketId}")
    public ResponseEntity<AirlineBooking> updateTicketDetail(@PathVariable("ticketId")Integer ticketId, @RequestBody AirlineBooking updateBooking){
        AirlineBookingResponse airlineBookingResponse = new AirlineBookingResponse();
       AirlineBooking airlineBooking = airlineBookingService.findById(ticketId);
       HttpStatus serverResponse = HttpStatus.OK;
        if(airlineBookingService.existById(ticketId)==true){
            airlineBooking.setAddress(updateBooking.getAddress());
            airlineBooking.setBookedDate(updateBooking.getBookedDate());
            airlineBooking.setContact(updateBooking.getContact());
            airlineBooking.setDeparture(updateBooking.getDeparture());
            airlineBooking.setDestination(updateBooking.getDestination());
            airlineBooking.setPassengerName(updateBooking.getPassengerName());
            airlineBookingService.bookTicket(airlineBooking);
            airlineBookingResponse.setActionCode("200");
            airlineBookingResponse.setReason("Update Successful ");
            airlineBookingResponse.setAirlineBooking(airlineBooking);
            return new ResponseEntity(airlineBookingResponse,serverResponse);
        }
        else {
            serverResponse = HttpStatus.NOT_FOUND;
            airlineBookingResponse = new AirlineBookingResponse();
            airlineBookingResponse.setActionCode("404");
            airlineBookingResponse.setReason("Request NOT Found "  );
            return new ResponseEntity(airlineBookingResponse, serverResponse);
        }
    }
    @GetMapping("/listBookedTicket")
    public ResponseEntity<List> listBookedTicket() {
        try {
            HttpStatus serverResponse = HttpStatus.OK;
            AirlineBookingResponse airlineBookingResponse = new AirlineBookingResponse();
            List<AirlineBooking> allTickets = airlineBookingService.listAllTicket();
            airlineBookingResponse.setActionCode("200");
            airlineBookingResponse.setReason("List Of All Booked Ticket Available");
            airlineBookingResponse.setAirlineBooking((AirlineBooking) airlineBooking);
            return new ResponseEntity(allTickets, serverResponse);
        }
        catch (Exception ex){
            AirlineBookingResponse airlineBookingResponse = new AirlineBookingResponse();
            HttpStatus serverReponse = HttpStatus.BAD_REQUEST;
            airlineBookingResponse.setActionCode("400");
            airlineBookingResponse.setReason("BAD Request:" + ex.getMessage());
            airlineBookingResponse.setAirlineBooking((AirlineBooking) airlineBooking);
            return new ResponseEntity(airlineBookingResponse,serverReponse);

        }
    }
}
