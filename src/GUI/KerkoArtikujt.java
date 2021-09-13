/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.math.BigDecimal;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.math.BigDecimal;
import javax.management.Query;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import net.proteanit.sql.DbUtils;

public class KerkoArtikujt extends javax.swing.JInternalFrame{
    public KerkoArtikujt() {
        initComponents();
    }
    Supermarketi sm = new Supermarketi();
    
//    private void showShitja(){
//        try{
//            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//            String url = "jdbc:sqlserver://localhost:1433;databaseName=supermarket;user=sa;password=sa1234";
//            Connection conn = DriverManager.getConnection(url);
//            
//            String sql = "SELECT * FROM SHITJA";
//            PreparedStatement pst = conn.prepareStatement(sql);
//            ResultSet rs = pst.executeQuery();
//            
//            tabelaKerkoArtikujt.setModel(DbUtils.resultSetToTableModel(rs));
//            //tabelaKerkoArtikujt.removeColumn(tabelaKerkoArtikujt.getColumnModel().getColumn(0));
//            //tabelaKerkoArtikujt.removeColumn(tabelaKerkoArtikujt.getColumnModel().getColumn(0));
//        }
//        catch(Exception ex){
//            showMessageDialog(null, ex);
//        }
//    }
    
//    private void showData(){
//        try{
//            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//            String url = "jdbc:sqlserver://localhost:1433;databaseName=supermarket;user=sa;password=sa1234";
//            Connection conn = DriverManager.getConnection(url);
//            
//            String sql = "SELECT EMRI_I_ARTIKULLIT FROM ARTIKULLI";
//            PreparedStatement pst = conn.prepareStatement(sql);
//            ResultSet rs = pst.executeQuery();
//            
//            tabelaKerkoArtikujt.setModel(DbUtils.resultSetToTableModel(rs));
//        }
//        catch(Exception ex){
//            showMessageDialog(null, ex);
//        }
//    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaKerkoArtikujt = new javax.swing.JTable();

        setClosable(true);

        tabelaKerkoArtikujt.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tabelaKerkoArtikujt.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tabelaKerkoArtikujt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tabelaKerkoArtikujtKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaKerkoArtikujt);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1147, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 585, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tabelaKerkoArtikujtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tabelaKerkoArtikujtKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                String url = "jdbc:sqlserver://localhost:1433;databaseName=supermarket;user=sa;password=sa1234";
                Connection conn = DriverManager.getConnection(url);
                int row = tabelaKerkoArtikujt.getSelectedRow();
                
                int id = (int) tabelaKerkoArtikujt.getValueAt(row, 1);
                String emri = tabelaKerkoArtikujt.getValueAt(row, 2).toString();
                Long barkodi = (long) tabelaKerkoArtikujt.getValueAt(row, 3);
                double sasia = (int) tabelaKerkoArtikujt.getValueAt(row,4);
                String njesia = tabelaKerkoArtikujt.getValueAt(row, 5).toString();
                BigDecimal cmimi = (BigDecimal)tabelaKerkoArtikujt.getValueAt(row,6);
                BigDecimal gjithsej = (BigDecimal) tabelaKerkoArtikujt.getValueAt(row, 7);
                
                String sql = "Insert into SHITJA(EMRI_I_ARTIKULLIT,BARKODI,NJESIA_MATESE,SASIA,CMIMI_I_ARTIKULLIT,GJITHSEJ) VALUES (?,?,?,?,?,?)";
                PreparedStatement pst = conn.prepareStatement(sql);
                pst.setString(1, emri);
                pst.setLong(2,barkodi);
                pst.setString(3, njesia);
                pst.setDouble(4, 1);
                pst.setBigDecimal(5, cmimi);
                pst.setBigDecimal(6, gjithsej);
                pst.execute();
                
                setClosed(true);
            } catch (Exception ex) {
                showMessageDialog(null, ex);
            }
        }
        
    }//GEN-LAST:event_tabelaKerkoArtikujtKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable tabelaKerkoArtikujt;
    // End of variables declaration//GEN-END:variables
}
