package com;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class UnregisteredLanding extends javax.swing.JFrame {

    
    public UnregisteredLanding() {
        initComponents();
        this.setLocationRelativeTo(null);
        showTbl.getTableHeader().setFont(new Font("Arial", Font.BOLD, 18));
        createConnection();
        LoadTable();
        
        
    }
    
        Connection con;
    
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
                    DefaultTableModel tm = (DefaultTableModel) showTbl.getModel();//user_table: variable name or our table

                    Statement stmt;
                    stmt = con.createStatement();
                    ResultSet rs =  stmt.executeQuery("SELECT * FROM show_list_tbl WHERE show_status = 'Now Showing'");
                        while(rs.next()){
                             int showID = rs.getInt("show_id");
                             String showName = rs.getString("show_name");
                             String showDate = rs.getString("show_date");
                             String showTime = rs.getString("show_time");
                             tm.addRow(new Object[]{showID,showName,showDate,showTime});
                        }
                            stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            
            

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        custLoginBtn = new javax.swing.JButton();
        registerBtn = new javax.swing.JButton();
        bookBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        showTbl = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 232, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1106, 692));

        custLoginBtn.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        custLoginBtn.setText("LOGIN");
        custLoginBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                custLoginBtnActionPerformed(evt);
            }
        });

        registerBtn.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        registerBtn.setText("REGISTER");
        registerBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerBtnActionPerformed(evt);
            }
        });

        bookBtn.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        bookBtn.setText("Book Ticket");
        bookBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookBtnActionPerformed(evt);
            }
        });

        showTbl.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        showTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Show ID", "Movie Title", "Date", "Show Time"
            }
        ));
        showTbl.setRowHeight(25);
        showTbl.setRowMargin(0);
        jScrollPane1.setViewportView(showTbl);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel3.setText("SCOPE CINEMA");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel3)
                            .addGap(162, 162, 162)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(custLoginBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(registerBtn, javax.swing.GroupLayout.Alignment.TRAILING)))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(372, 372, 372)
                            .addComponent(bookBtn)
                            .addGap(353, 353, 353)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 848, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(custLoginBtn)
                        .addGap(19, 19, 19)
                        .addComponent(registerBtn)))
                .addGap(32, 32, 32)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(bookBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(58, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 900, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 658, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void custLoginBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_custLoginBtnActionPerformed
        new CustomerLogin().setVisible(true); // or this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_custLoginBtnActionPerformed

    private void registerBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerBtnActionPerformed
        new UserRegistration().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_registerBtnActionPerformed

    private void bookBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookBtnActionPerformed
        try {
            DefaultTableModel tm = (DefaultTableModel) showTbl.getModel();
            int row = showTbl.getSelectedRow();
            int showID = (int) tm.getValueAt(row, 0);
            String showName = (String) tm.getValueAt(row, 1);
            String showDate = (String) tm.getValueAt(row, 2);
            String showTime = (String) tm.getValueAt(row, 3);
            
            UnregisteredTicketBooking obj = new UnregisteredTicketBooking();
            obj.setShowID(showID);
            obj.setShowName(showName);
            obj.setShowDate(showDate);
            obj.setShowTime(showTime);
            
            obj.setTexts();
            obj.LoadTbl();
            obj.setVisible(true);
            this.dispose();

        } catch(ArrayIndexOutOfBoundsException e){
            JOptionPane.showMessageDialog(null, "Select a row from the table!", "Error!" ,1);
        }
    }//GEN-LAST:event_bookBtnActionPerformed

    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UnregisteredLanding().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bookBtn;
    private javax.swing.JButton custLoginBtn;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton registerBtn;
    private javax.swing.JTable showTbl;
    // End of variables declaration//GEN-END:variables
}
