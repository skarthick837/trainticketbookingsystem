package com.trainticketbooking.beans;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope("singleton")
@Component
public class TrainData {
    Map<String,TicketBookRequest> sectionA = new HashMap<String,TicketBookRequest>();
    Map<String,TicketBookRequest> sectionB = new HashMap<String, TicketBookRequest>();
    public Map<String, TicketBookRequest> getsectionA() {
        return sectionA;
    }
    public void setsectionA(Map<String, TicketBookRequest> sectionA) {
        this.sectionA = sectionA;
    }
    public void setsectionB(Map<String, TicketBookRequest> sectionB) {
        this.sectionB = sectionB;
    }
    public Map<String, TicketBookRequest> getsectionB() {
        return sectionB;
    }
    @Override
    public String toString() {
        return "SessionData [sectionA=" + sectionA + ", sectionB=" + sectionB + "]";
    }
    
}
