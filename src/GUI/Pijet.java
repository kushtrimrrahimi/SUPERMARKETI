/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import static javax.swing.JOptionPane.showMessageDialog;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author ARSIM
 */
public class Pijet extends javax.swing.JInternalFrame {

    /**
     * Creates new form Pijet
     */
    public Pijet() {
        initComponents();
        showPijet();
    }
    
    public void showPijet(){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=supermarket;user=sa;password=sa1234";
            Connection conn = DriverManager.getConnection(url);
            
            String sql = "SELECT * FROM ARTIKULLI WHERE KATEGORIA = 'PIJE'";
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            
            tabelaEPijeve.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception ex) {
            showMessageDialog(null, ex);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaEPijeve = new javax.swing.JTable();

        setClosable(true);

        tabelaEPijeve.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tabelaEPijeve.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tabelaEPijeve);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 714, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 468, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaEPijeve;
    // End of variables declaration//GEN-END:variables
}
