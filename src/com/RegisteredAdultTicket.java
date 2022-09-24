package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class RegisteredAdultTicket implements Ticket{
    
    
    public RegisteredAdultTicket(){
        createConnection();
    }
    Connection con;
    int newLoyaltyPoints;
    int ticketPrice;
    
    void createConnection(){

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/scope_db","root","123456789");}
        catch (ClassNotFoundException ex){
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE,null,ex);
                }
        catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
                }
    }

    @Override
    public void TicketWithDiscount() {
        ticketPrice = 600 - 200;
        newLoyaltyPoints = 0;
    }

    @Override
    public void TicketWithoutDiscount(int loyaltyPoints) {
        ticketPrice = 600;
        newLoyaltyPoints = loyaltyPoints + 10;
    }

    @Override
    public void addToDatabase(int show_id, String show_date, String show_time, int seat_no, String username, String show_name) {
        
        try{
            //updating the loyaltypoints
            Statement stmt;
            stmt = con.createStatement();
            String updateQ = ("UPDATE `scope_db`.`registered_user_tbl` SET `loyalty_point` = '"+newLoyaltyPoints+"' WHERE `username` = '"+username+"';");
            stmt.executeUpdate(updateQ);
            
            
            //insert ticket
            String insertQuery = ("INSERT INTO ticket_tbl (show_id,show_date,show_time,seat_no,amount,ticket_type) VALUES ('"+show_id+"','"+show_date+"','"+show_time+"','"+seat_no+"','"+ticketPrice+"','Full')");
            stmt.execute(insertQuery);

            String updateq = ("UPDATE seat SET `status` = 'Booked' WHERE (`show_id` = '"+show_id+"') AND (`seat_no` = '"+seat_no+"');");
            stmt.executeUpdate(updateq);
            int i = stmt.executeUpdate(updateq);
            if(i>0){
                JOptionPane.showMessageDialog(null, "Booking Successful!", "Click OK to proceed....", 1);
             }
            JOptionPane.showMessageDialog(null, "Movie Title: "+show_name+"\n\nDate: "+show_date+"\n\nTime: "+show_time+"\n\nSeat no:  "+seat_no+"\n\nPrice:  "+ticketPrice+"\n", "Receipt", 1);
            
            stmt.close();
        }catch (SQLException ex) {
                 Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
}