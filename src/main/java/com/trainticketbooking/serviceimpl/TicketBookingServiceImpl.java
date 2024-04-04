package com.trainticketbooking.serviceimpl;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.stereotype.Component;

import com.trainticketbooking.beans.TicketBookRequest;
import com.trainticketbooking.beans.TrainData;
import com.trainticketbooking.service.TicketBookingService;

@Component
public class TicketBookingServiceImpl implements TicketBookingService {

    final int maxSeatForEachSection=10;

    Random rand = new Random();

    @Override
    public String bookTicket(TicketBookRequest ticketBookRequest,TrainData trainData) {
        try{
            Map<String,TicketBookRequest> sectionA = trainData.getsectionA();
            Map<String,TicketBookRequest> sectionB = trainData.getsectionB();
            int ticketCountSectionA = sectionA.size();
            int ticketCountSectionB = sectionB.size();

            if(ticketCountSectionA>maxSeatForEachSection && ticketCountSectionB>maxSeatForEachSection){
                return "Seats not available";
            }
            String seatNo;
            if(ticketCountSectionA<maxSeatForEachSection){
                seatNo="A"+rand.nextInt(10000);
                ticketBookRequest.setSeatNo(seatNo);
                sectionA.put(seatNo, ticketBookRequest);
            }else{
                seatNo="B"+rand.nextInt(10000);
                ticketBookRequest.setSeatNo(seatNo);
                sectionB.put(seatNo, ticketBookRequest);
            }
            return "Booked Successfully - Seat Number:"+seatNo;
        }catch(Exception e){
            e.printStackTrace();
        }

       return "Unable to book ticket";
    }

    @Override
    public String removeTicket(String seatNo,TrainData trainData) {
       Map<String,TicketBookRequest> sectionA = trainData.getsectionA();
       Map<String,TicketBookRequest> sectionB = trainData.getsectionB();
       
       if(sectionA.containsKey(seatNo)){
        sectionA.remove(seatNo);
       }else if(sectionB.containsKey(seatNo)){
        sectionB.remove(seatNo);
       }else{
        return "Ticket not booked with the given seat number.";
       }

       return "Ticket removed successfully";
    }

    @Override
    public String modifyTicket(String seatNo,TrainData sessionData) {
       Map<String,TicketBookRequest> sectionA = sessionData.getsectionA();
       Map<String,TicketBookRequest> sectionB = sessionData.getsectionB();
       
       int ticketCountSectionA = sectionA.size();
       int ticketCountSectionB = sectionB.size();

       if(ticketCountSectionA>maxSeatForEachSection && ticketCountSectionB>maxSeatForEachSection){
        return "Can't modify seat. All seats are filled";
       }
       
       TicketBookRequest ticketBookRequest;
       if(sectionA.containsKey(seatNo)){
        ticketBookRequest=sectionA.get(seatNo);
        sectionA.remove(seatNo);
       }else if(sectionB.containsKey(seatNo)){
        ticketBookRequest=sectionB.get(seatNo);
        sectionB.remove(seatNo);
       }else{
        return "Ticket not booked with the given seat number.";
       }

        ticketCountSectionA = sectionA.size();
        ticketCountSectionB = sectionB.size();
       if(ticketCountSectionA<maxSeatForEachSection){
        seatNo="A"+rand.nextInt(10000);
        ticketBookRequest.setSeatNo(seatNo);
        sectionA.put(seatNo, ticketBookRequest);
       }else{
        seatNo="B"+rand.nextInt(10000);
        ticketBookRequest.setSeatNo(seatNo);
        sectionB.put(seatNo, ticketBookRequest);
       }

       return "New Seat number:"+seatNo;
    }

    @Override
    public Map<String, TicketBookRequest> getTicketDetails(String section, TrainData trainData) {
        if(section.equalsIgnoreCase("a"))
            return trainData.getsectionA();
        else
            return trainData.getsectionB();
        
    }

    @Override
    public Map<String, TicketBookRequest> getUserTicketDetails(String email, TrainData trainData) {
       
        Map<String, TicketBookRequest> result=new HashMap<String, TicketBookRequest>();

        for (HashMap.Entry<String, TicketBookRequest> entry: trainData.getsectionA().entrySet()) {
            if(entry.getValue().getUser().getEmail().equals(email)){
                result.put(entry.getKey(), entry.getValue());
            }
        }
        for (HashMap.Entry<String, TicketBookRequest> entry: trainData.getsectionB().entrySet()) {
            if(entry.getValue().getUser().getEmail().equals(email)){
                result.put(entry.getKey(), entry.getValue());
            }
        }

        return result;
    }
    
}
