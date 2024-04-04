package com.trainticketbooking.controller;

import org.springframework.web.bind.annotation.RestController;

import com.trainticketbooking.beans.TrainData;
import com.trainticketbooking.service.TicketBookingService;
import com.trainticketbooking.beans.TicketBookRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
public class TicketBookingController {

    
    TicketBookingService ticketBookingService;
    TrainData trainData;

    public TicketBookingController(TicketBookingService ticketBookingService,TrainData trainData){
        this.ticketBookingService=ticketBookingService;
        this.trainData=trainData;
    }

    @PostMapping("/ticket/book")
    public String bookTicket(@RequestBody TicketBookRequest ticketBookRequest) { 
        try{
        ticketBookingService.bookTicket(ticketBookRequest,trainData);
        return "Ticket booked successfully";
        }catch(Exception e){
            e.printStackTrace();
        }
        return "Ticket booking failed.";
    }

    @GetMapping("/ticket/get/userticketdetails")
    public ResponseEntity<?> getUserTicketDetails(@RequestParam String email) {
       return new ResponseEntity(ticketBookingService.getUserTicketDetails(email, trainData),HttpStatus.OK);
    }

    @GetMapping("/ticket/get/sectionticketdetails")
    public ResponseEntity<?> getTicketDetails(@RequestParam String section) {
       return new ResponseEntity(ticketBookingService.getTicketDetails(section, trainData),HttpStatus.OK);
    }

    @GetMapping("/ticket/delete")
    public String deleteTicket(@RequestParam String seatno) {
        return ticketBookingService.removeTicket(seatno, trainData);
    }

    @GetMapping("/ticket/modifyseat")
    public String modifySeat(@RequestParam String seatno) {
        return ticketBookingService.modifyTicket(seatno, trainData);
    }
    

    
    
    
    
}
