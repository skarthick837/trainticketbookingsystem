package com.trainticketbooking.beans;

public class TicketBookRequest {
    String seatNo;
    String from;
    String to;
    String price = "$5";
    User user;

    public String getFrom() {
        return from;
    }
    public String getTo() {
        return to;
    }
    public String getPrice() {
        return price;
    }
    public User getUser() {
        return user;
    }
    public void setFrom(String from) {
        this.from = from;
    }
    public void setTo(String to) {
        this.to = to;
    }
    public void setPrice(String price) {
        this.price = price;
    }
    public void setUser(User user) {
        this.user = user;
    }

    public String getSeatNo() {
        return seatNo;
    }
    public void setSeatNo(String seatNo) {
        this.seatNo = seatNo;
    }
    @Override
    public String toString() {
        return "TicketBookRequest [seatNo=" + seatNo + ", from=" + from + ", to=" + to + ", price=" + price + ", user="
                + user + "]";
    }
    
    
    
}
