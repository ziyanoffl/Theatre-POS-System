package com;

public class UnregisteredTicketFactory extends AbstractFactory{

    @Override
    Ticket getTicket(String ticketType) {
        if(ticketType.equalsIgnoreCase("Adult")){
            return new UnregisteredAdultTicket();
        }else if(ticketType.equals("Child")){
            return new UnregisteredChildTicket();
        }
        return null;
    }
    
}