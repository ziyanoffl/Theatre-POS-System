package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnection {
    
        
    void createConnection()
    {
         try 
         {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/scop_db", "root", "123456789");
            System.out.println("DB Connection successfull..!!");
            
//            Statement stmt = con.createStatement();
//            ResultSet rs = stmt.executeQuery("select * from users");
//            while(rs.next())
//            {
//                String name = rs.getString("Name");
//                System.out.println(name);
//            }
         } 
                catch (ClassNotFoundException ex) 
                {
                    Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
                } 
                catch (SQLException ex) 
                {
                    Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
                }
    }

}