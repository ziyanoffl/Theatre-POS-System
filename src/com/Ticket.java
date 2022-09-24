package com;

public interface Ticket {
        void TicketWithDiscount();
        
        void TicketWithoutDiscount(int loyaltyPoints);
               
        void addToDatabase(int show_id, String show_date, String show_time, int seat_no, String username, String show_name);
        
        
}
