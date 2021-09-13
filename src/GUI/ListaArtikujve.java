/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.JOptionPane.showMessageDialog;
import net.proteanit.sql.DbUtils;
/**
 *
 * @author ARSIM
 */
public class ListaArtikujve extends javax.swing.JInternalFrame {
    public ListaArtikujve() {
        initComponents();
        showArtikujt();
    }
    
    
    public void showArtikujt(){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=supermarket;user=sa;password=sa1234";
            Connection conn = DriverManager.getConnection(url);
            
            String sql = "SELECT * FROM ARTIKULLI";
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            
            tabelaArtikujve.setModel(DbUtils.resultSetToTableModel(rs));
            tabelaArtikujve.removeColumn(tabelaArtikujve.getColumnModel().getColumn(0));
            tabelaArtikujve.removeColumn(tabelaArtikujve.getColumnModel().getColumn(0));
        } catch (Exception ex) {
            showMessageDialog(null, ex);
        }
    }
    
    private void fshij(){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=supermarket;user=sa;password=sa1234";
            Connection conn = DriverManager.getConnection(url);
            
            int row = tabelaArtikujve.getSelectedRow();
            String value = (tabelaArtikujve.getModel().getValueAt(row, 0).toString());
            
            String sql = "DELETE FROM ARTIKULLI WHERE ARTIKULLI_ID =" + value;
            PreparedStatement pst = conn.prepareStatement(sql);
            
            if(row < 0){
                showMessageDialog(null, "Zgjidh nje artikull");
                return;
            }
            else{
                pst.executeUpdate();
            }
            
            
            showArtikujt();
        }
        catch(Exception ex){
            showMessageDialog(null,ex);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaArtikujve = new javax.swing.JTable();
        fshijbutton = new javax.swing.JButton();

        setClosable(true);

        tabelaArtikujve.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tabelaArtikujve.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tabelaArtikujve.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tabelaArtikujveKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaArtikujve);

        fshijbutton.setText("F2 - FSHIJ");
        fshijbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fshijbuttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(fshijbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 789, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 437, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fshijbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fshijbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fshijbuttonActionPerformed
        fshij();
    }//GEN-LAST:event_fshijbuttonActionPerformed

    private void tabelaArtikujveKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tabelaArtikujveKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_F2){
            fshij();
        }
    }//GEN-LAST:event_tabelaArtikujveKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton fshijbutton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaArtikujve;
    // End of variables declaration//GEN-END:variables
}
