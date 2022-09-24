/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ziyan
 */
public class RegisteredTicketBooking extends javax.swing.JFrame {

    /**
     * Creates new form ShowList
     */
    public RegisteredTicketBooking() {
        initComponents();
        this.setLocationRelativeTo(null);
        seatTbl.getTableHeader().setFont(new Font("Arial", Font.BOLD, 18));
        
        createConnection();
        
    }
    Connection con;
    private String userName;
    private int showID;
    private String showName;
    private String showDate;
    private String showTime;
    private int ticketPrice;
    int newLoyaltyPoints;

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setNewLoyaltyPoints(int newLoyaltyPoints) {
        this.newLoyaltyPoints = newLoyaltyPoints;
    }

    public void setTicketPrice(int ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public void setShowID(int showID) {
        this.showID = showID;
    }

    public void setShowName(String showName) {
        this.showName = showName;
    }

    public void setShowDate(String showDate) {
        this.showDate = showDate;
    }

    public void setShowTime(String showTime) {
        this.showTime = showTime;
    }
    
    public void setText(){
        showIDLbl.setText(String.valueOf(showID));
        showTitleLbl.setText(showName);
        showDateLbl.setText(showDate);
        showTimeLbl.setText(showTime);
    }
    
    
    
    
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
    
    void LoadTable(){
            try {
               DefaultTableModel tm = (DefaultTableModel) seatTbl.getModel();
               Statement stmt;
               stmt = con.createStatement();
               ResultSet rs =  stmt.executeQuery("SELECT * FROM seat WHERE show_id = '"+showID+"' AND status = 'Available'");
               while(rs.next()){
                    int seatNo = rs.getInt("seat_no");
                    String availability = rs.getString("status");
                    tm.addRow(new Object[]{seatNo,availability});
                }
               stmt.close();

            } catch (SQLIntegrityConstraintViolationException e){
                JOptionPane.showMessageDialog(null, "Select a seat to book!", "Click OK to proceed", 2);
            } catch (SQLException ex) {
                Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        seatTbl = new javax.swing.JTable();
        ticketTypeList = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        showTitleLbl = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        showTimeLbl = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        showIDLbl = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        showDateLbl = new javax.swing.JLabel();
        bookBtn = new javax.swing.JButton();
        backBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 232, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1106, 692));
        jPanel1.setLayout(null);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        jLabel3.setText("Book Tickets");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(360, 40, 186, 35);

        jLabel4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel4.setText("Show ID:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(210, 100, 79, 22);

        jLabel5.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel5.setText("Show Title:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(210, 170, 99, 22);

        jLabel6.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel6.setText("Seat:");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(210, 380, 46, 22);

        jLabel7.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel7.setText("Type of Ticket:");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(210, 520, 131, 22);

        seatTbl.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        seatTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Seat No.", "Availability"
            }
        ));
        seatTbl.setRowHeight(25);
        seatTbl.setRowMargin(0);
        jScrollPane1.setViewportView(seatTbl);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(390, 370, 303, 126);

        ticketTypeList.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        ticketTypeList.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Registered Adult", "Registered Child" }));
        jPanel1.add(ticketTypeList);
        ticketTypeList.setBounds(390, 510, 303, 39);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        showTitleLbl.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        showTitleLbl.setText("show title");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(showTitleLbl)
                .addGap(0, 218, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(showTitleLbl)
                .addContainerGap())
        );

        jPanel1.add(jPanel4);
        jPanel4.setBounds(390, 160, 303, 40);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        showTimeLbl.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        showTimeLbl.setText("show time");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(showTimeLbl)
                .addGap(0, 212, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(showTimeLbl)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel5);
        jPanel5.setBounds(390, 310, 303, 40);

        jLabel8.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel8.setText("Starting Time:");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(210, 320, 140, 22);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        showIDLbl.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        showIDLbl.setText("show id");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(showIDLbl)
                .addGap(0, 235, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(showIDLbl)
                .addContainerGap())
        );

        jPanel1.add(jPanel6);
        jPanel6.setBounds(390, 90, 303, 40);

        jLabel9.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel9.setText("Show Date:");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(210, 240, 110, 22);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        showDateLbl.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        showDateLbl.setText("show date");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(showDateLbl)
                .addGap(0, 213, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(showDateLbl)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel7);
        jPanel7.setBounds(390, 230, 303, 40);

        bookBtn.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        bookBtn.setText("Book");
        bookBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookBtnActionPerformed(evt);
            }
        });
        jPanel1.add(bookBtn);
        bookBtn.setBounds(370, 580, 120, 33);

        backBtn.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        backBtn.setText("Back");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });
        jPanel1.add(backBtn);
        backBtn.setBounds(30, 30, 100, 33);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bookBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookBtnActionPerformed
        try {
                //To get selected seat no
                DefaultTableModel tm = (DefaultTableModel) seatTbl.getModel();
                int row = seatTbl.getSelectedRow();
                int seatNo = (int) tm.getValueAt(row, 0);
                
                Statement stmt;
                stmt = con.createStatement();
                ResultSet rs =  stmt.executeQuery("SELECT * FROM registered_user_tbl WHERE username = '"+userName+"'");
                while(rs.next()){
                    int currentLoyaltyPoints = rs.getInt("loyalty_point");
                     
                    //get shape factory
                    AbstractFactory RegisteredTicketFactory = FactoryProducer.getFactory(true);
                    //get an object of Shape Rectangle
                    Ticket ticket1 = RegisteredTicketFactory.getTicket(ticketTypeList.getSelectedItem().toString());
                     
                    //this is to implement the correct methods after checking the loyalty points of the user
                     if(ticketTypeList.getSelectedItem().toString().equals("Registered Adult") && currentLoyaltyPoints == 50){
                        
                        //call methods
                        ticket1.TicketWithDiscount();
                        
                        ticket1.addToDatabase(showID, showDate, showTime, seatNo, userName, showName);
                        
                     }else if(ticketTypeList.getSelectedItem().toString().equals("Registered Adult") && currentLoyaltyPoints < 50){
                        
                        ticket1.TicketWithoutDiscount(currentLoyaltyPoints);
                        
                        ticket1.addToDatabase(showID, showDate, showTime, seatNo, userName, showName);
                        
                     }else if(ticketTypeList.getSelectedItem().toString().equals("Registered Child") && currentLoyaltyPoints == 50){
                         
                        ticket1.TicketWithDiscount();
                        
                        ticket1.addToDatabase(showID, showDate, showTime, seatNo, userName, showName);
                        
                        
                     }else if(ticketTypeList.getSelectedItem().toString().equals("Registered Child") && currentLoyaltyPoints < 50){
                        
                        ticket1.TicketWithoutDiscount(currentLoyaltyPoints);
                        
                        ticket1.addToDatabase(showID, showDate, showTime, seatNo, userName, showName);
                        
                     }
                        CustomerLanding obj = new CustomerLanding(userName);
                        obj.LoadTable();
                        obj.setVisible(true);
                        this.dispose();
                 }

                     stmt.close();

             } catch (SQLException ex) {
                 Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
             }
    }//GEN-LAST:event_bookBtnActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        CustomerLanding obj = new CustomerLanding(userName);
        obj.LoadTable();
        obj.setVisible(true);
        this.dispose(); // or this.setVisible(false);
    }//GEN-LAST:event_backBtnActionPerformed

    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RegisteredTicketBooking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegisteredTicketBooking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegisteredTicketBooking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegisteredTicketBooking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new RegisteredTicketBooking().setVisible(true);
//            }
//        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private javax.swing.JButton bookBtn;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable seatTbl;
    private javax.swing.JLabel showDateLbl;
    private javax.swing.JLabel showIDLbl;
    private javax.swing.JLabel showTimeLbl;
    private javax.swing.JLabel showTitleLbl;
    private javax.swing.JComboBox<String> ticketTypeList;
    // End of variables declaration//GEN-END:variables
}
