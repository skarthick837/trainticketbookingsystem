package com.trainticketbooking.service;

import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.trainticketbooking.beans.TicketBookRequest;
import com.trainticketbooking.beans.TrainData;

@Service
@Component
public interface TicketBookingService {

    String bookTicket(TicketBookRequest ticketBookRequest,TrainData trainData);

    Map<String,TicketBookRequest> getTicketDetails(String section,TrainData trainData);

    Map<String,TicketBookRequest> getUserTicketDetails(String email,TrainData trainData);

    String removeTicket(String seatNo,TrainData trainData);

    String modifyTicket(String seatNo,TrainData trainData);
    
}
