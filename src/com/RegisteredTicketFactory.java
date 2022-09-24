package com;

public class RegisteredTicketFactory extends AbstractFactory{

    @Override
    Ticket getTicket(String ticketType) {
        if(ticketType.equalsIgnoreCase("Registered Adult")){
            return new RegisteredAdultTicket();
        }else if (ticketType.equalsIgnoreCase("Registered Child")){
            return new RegisteredChildTicket();
        }
        return null;
    }
    
    
}