package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class UnregisteredAdultTicket implements Ticket{
    
    public UnregisteredAdultTicket(){
        createConnection();
    }
    Connection con;
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
        
    }

    @Override
    public void TicketWithoutDiscount(int loyaltyPoints) {
        ticketPrice = 600;
    }

    @Override
    public void addToDatabase(int show_id, String show_date, String show_time, int seat_no, String username, String show_name) {
        try{
            
            Statement stmt;
            stmt = con.createStatement();
                        
            //insert ticket
            String insertQuery = ("INSERT INTO ticket_tbl (show_id,show_date,show_time,seat_no,amount,ticket_type) VALUES ('"+show_id+"','"+show_date+"','"+show_time+"','"+seat_no+"','"+ticketPrice+"','Full')");
            stmt.execute(insertQuery);

            String updateq = ("UPDATE seat SET `status` = 'Booked' WHERE (`show_id` = '"+show_id+"') AND (`seat_no` = '"+seat_no+"');");
            stmt.executeUpdate(updateq);
            int i = stmt.executeUpdate(updateq);
            if(i>0){
                JOptionPane.showMessageDialog(null, "Seat Update Successful!", "Click OK to proceed....", 1);
             }
            JOptionPane.showMessageDialog(null, "Movie Title: "+show_name+"\n\nDate: "+show_date+"\n\nTime: "+show_time+"\n\nSeat no:  "+seat_no+"\n\nTicket Type: Full\n\n", "Receipt", 1);
            
            stmt.close();
        }catch (SQLException ex) {
                 Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}