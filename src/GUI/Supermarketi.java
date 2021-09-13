package GUI;


import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

public final class Supermarketi extends javax.swing.JFrame {

    public Supermarketi() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        llogarit();
        showData();
        setFocusable(true);
    }
  
    public void refresh(){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=supermarket;user=sa;password=sa1234";
            Connection conn = DriverManager.getConnection(url);
            
            String sql = "SELECT * FROM SHITJA";
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            
            tabelaKryesore.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception ex){
            showMessageDialog(null, ex);
        }
    }
    
    public void showData() {
        try {
            String sql = "Select * from SHITJA";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=supermarket;user=sa;password=sa1234";
            Connection conn = DriverManager.getConnection(url);
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            tabelaKryesore.setModel(DbUtils.resultSetToTableModel(rs));
            tabelaKryesore.removeColumn(tabelaKryesore.getColumnModel().getColumn(0));
            kalkulo();
            
            
            
        } catch (Exception e) {
            showMessageDialog(null, e);
        }
    }
    
    private void fshij(){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=supermarket;user=sa;password=sa1234";
            Connection conn = DriverManager.getConnection(url);          
            DefaultTableModel model = (DefaultTableModel) tabelaKryesore.getModel();
            int row = tabelaKryesore.getSelectedRow();
            String value = (tabelaKryesore.getModel().getValueAt(row, 0).toString());
            String query = "DELETE FROM SHITJA WHERE SHITJA_ID='" + value +"'";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.executeUpdate();
            model.setRowCount(0);
            showData();
            
            if(row < 0){
                showMessageDialog(null, "Nuk eshte zgjedhe artikulli.");
            }
        }
        catch(Exception e){
            
        }
    }
    
    private void fshijTeGjitha(){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=supermarket;user=sa;password=sa1234";
            Connection conn = DriverManager.getConnection(url);
            String query = "DELETE FROM SHITJA";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.execute();
            showData();
        }
        catch(Exception e){
            
        }
    }
    
    private void llogarit(){
        double rezultati = 0;
        for (int i = 0; i < tabelaKryesore.getRowCount(); i++) {
            String cmimi = tabelaKryesore.getValueAt(i, 7).toString();
            double d1 = Double.parseDouble(cmimi);
            rezultati += d1;
        }
        DecimalFormat format = new DecimalFormat("#.#");
        format.setMinimumFractionDigits(2);
        Totali.setText(format.format(rezultati));
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        DesktopPane = new javax.swing.JDesktopPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaKryesore = new javax.swing.JTable();
        klientetButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        Totali = new javax.swing.JLabel();
        kerkoField = new javax.swing.JTextField();
        fshijButton = new javax.swing.JButton();
        fshijTeGjithaButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        MenuBar = new javax.swing.JMenuBar();
        FileMenu = new javax.swing.JMenu();
        shtoArtikullin = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        listaEPergjithshme = new javax.swing.JMenuItem();
        furnizuesitMenu = new javax.swing.JMenu();
        listaFurnizuesve = new javax.swing.JMenuItem();
        dergesatMenu = new javax.swing.JMenu();
        listaDergesave = new javax.swing.JMenuItem();
        shitjetMenu = new javax.swing.JMenu();
        listaShitjeve = new javax.swing.JMenuItem();
        ckyquMenu = new javax.swing.JMenu();
        dilMenu = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("DPT");
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        DesktopPane.setBackground(new java.awt.Color(255, 255, 255));

        tabelaKryesore.setAutoCreateRowSorter(true);
        tabelaKryesore.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tabelaKryesore.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tabelaKryesore.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tabelaKryesore.setRowHeight(20);
        tabelaKryesore.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tabelaKryesoreKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaKryesore);

        klientetButton.setText("Klientet");
        klientetButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        klientetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                klientetButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 42)); // NOI18N
        jLabel1.setText("MARKET");

        Totali.setBackground(new java.awt.Color(255, 255, 255));
        Totali.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Totali.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        kerkoField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        kerkoField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                kerkoFieldKeyPressed(evt);
            }
        });

        fshijButton.setText("Fshij - DEL");
        fshijButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        fshijButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fshijButtonActionPerformed(evt);
            }
        });

        fshijTeGjithaButton.setText("Fshij te gjitha - ESC");
        fshijTeGjithaButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        fshijTeGjithaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fshijTeGjithaButtonActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Barkodi / Emri i Artikullit");

        DesktopPane.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        DesktopPane.setLayer(klientetButton, javax.swing.JLayeredPane.DEFAULT_LAYER);
        DesktopPane.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        DesktopPane.setLayer(Totali, javax.swing.JLayeredPane.DEFAULT_LAYER);
        DesktopPane.setLayer(kerkoField, javax.swing.JLayeredPane.DEFAULT_LAYER);
        DesktopPane.setLayer(fshijButton, javax.swing.JLayeredPane.DEFAULT_LAYER);
        DesktopPane.setLayer(fshijTeGjithaButton, javax.swing.JLayeredPane.DEFAULT_LAYER);
        DesktopPane.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout DesktopPaneLayout = new javax.swing.GroupLayout(DesktopPane);
        DesktopPane.setLayout(DesktopPaneLayout);
        DesktopPaneLayout.setHorizontalGroup(
            DesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DesktopPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 637, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addGroup(DesktopPaneLayout.createSequentialGroup()
                        .addGroup(DesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(kerkoField, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Totali, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(DesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(klientetButton, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(fshijButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(fshijTeGjithaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        DesktopPaneLayout.setVerticalGroup(
            DesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DesktopPaneLayout.createSequentialGroup()
                .addGroup(DesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DesktopPaneLayout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(jLabel2))
                    .addGroup(DesktopPaneLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(64, 64, 64)
                .addComponent(klientetButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fshijButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fshijTeGjithaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 216, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DesktopPaneLayout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addGroup(DesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(kerkoField)
                    .addComponent(Totali, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        FileMenu.setText("Artikujt");

        shtoArtikullin.setText("Shto Artikull");
        shtoArtikullin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                shtoArtikullinActionPerformed(evt);
            }
        });
        FileMenu.add(shtoArtikullin);

        jMenu1.setText("Lista e Artikujve");

        listaEPergjithshme.setText("Lista e Pergjithshme");
        listaEPergjithshme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listaEPergjithshmeActionPerformed(evt);
            }
        });
        jMenu1.add(listaEPergjithshme);

        FileMenu.add(jMenu1);

        MenuBar.add(FileMenu);

        furnizuesitMenu.setText("Furnizuesit");

        listaFurnizuesve.setText("Lista e Furnizuesve");
        furnizuesitMenu.add(listaFurnizuesve);

        MenuBar.add(furnizuesitMenu);

        dergesatMenu.setText("Dergesat");

        listaDergesave.setText("Lista e Dergesave");
        dergesatMenu.add(listaDergesave);

        MenuBar.add(dergesatMenu);

        shitjetMenu.setText("Shitjet");

        listaShitjeve.setText("Lista e Shitjeve");
        listaShitjeve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listaShitjeveActionPerformed(evt);
            }
        });
        shitjetMenu.add(listaShitjeve);

        MenuBar.add(shitjetMenu);

        ckyquMenu.setText("Çkyqu");

        dilMenu.setText("Dil");
        dilMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dilMenuActionPerformed(evt);
            }
        });
        ckyquMenu.add(dilMenu);

        MenuBar.add(ckyquMenu);

        setJMenuBar(MenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(DesktopPane, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(DesktopPane, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    private void shtoArtikullinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_shtoArtikullinActionPerformed
        ShtoArtikullin sA = new ShtoArtikullin();
        DesktopPane.add(sA);
        sA.show();
        Dimension desktopSize = DesktopPane.getSize();
        Dimension jInternalFrameSize = sA.getSize();
        sA.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
        (desktopSize.height- jInternalFrameSize.height)/2);
    }//GEN-LAST:event_shtoArtikullinActionPerformed

    private void dilMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dilMenuActionPerformed
        LOGIN l = new LOGIN();
        l.show();
        setVisible(false);
    }//GEN-LAST:event_dilMenuActionPerformed

    private void listaEPergjithshmeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listaEPergjithshmeActionPerformed
        ListaArtikujve la = new ListaArtikujve();
        DesktopPane.add(la);
        la.show();
        try{
            la.setMaximum(true);
        }
        catch(Exception ex){
            
        }
    }//GEN-LAST:event_listaEPergjithshmeActionPerformed

    private void listaShitjeveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listaShitjeveActionPerformed
        ListaShitjeve ls = new ListaShitjeve();
        DesktopPane.add(ls);
        ls.show();
        try{
            ls.setMaximum(true);
        }
        catch(Exception ex){
            
        }
    }//GEN-LAST:event_listaShitjeveActionPerformed

    private void klientetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_klientetButtonActionPerformed
        Konsumatoret k = new Konsumatoret();
        DesktopPane.add(k);
        k.show();
        Dimension desktopSize = DesktopPane.getSize();
        Dimension jInternalFrameSize = k.getSize();
        k.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
        (desktopSize.height- jInternalFrameSize.height)/2);
    }//GEN-LAST:event_klientetButtonActionPerformed
    
    private void kerkoFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_kerkoFieldKeyPressed
        KerkoArtikujt ka = new KerkoArtikujt();
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            
            DesktopPane.add(ka);
            
            Dimension desktopSize = DesktopPane.getSize();
            Dimension jInternalFrameSize = ka.getSize();
            ka.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
            (desktopSize.height- jInternalFrameSize.height)/2);
            
            try{
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                String url = "jdbc:sqlserver://localhost:1433;databaseName=supermarket;user=sa;password=sa1234";
                Connection conn = DriverManager.getConnection(url);
                
                String sql = "Select * from ARTIKULLI where EMRI_I_ARTIKULLIT like '%%" + kerkoField.getText().toString() + "%%'";
                PreparedStatement pst = conn.prepareStatement(sql);
                ResultSet rs = pst.executeQuery();
                ka.tabelaKerkoArtikujt.setModel(DbUtils.resultSetToTableModel(rs));
                ka.show();
            }
            catch(Exception ex){
                showMessageDialog(null,ex);
            }
        }
    }//GEN-LAST:event_kerkoFieldKeyPressed

    private void tabelaKryesoreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tabelaKryesoreKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_DELETE) {
            fshij();
            showData();
        }
        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            fshijTeGjitha();
            showData();
        }
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            showData();
        }
    }//GEN-LAST:event_tabelaKryesoreKeyPressed

    private void fshijButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fshijButtonActionPerformed
        fshij();
    }//GEN-LAST:event_fshijButtonActionPerformed

    private void fshijTeGjithaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fshijTeGjithaButtonActionPerformed
        fshijTeGjitha();
    }//GEN-LAST:event_fshijTeGjithaButtonActionPerformed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            showData();
        }
    }//GEN-LAST:event_formKeyPressed
    
    private void kalkulo() {
        double rezultati = 0;
//        for (int i = 0; i < tabelaKryesore.getRowCount(); i++) {
//            String cmimi = tabelaKryesore.getValueAt(i, 2).toString();
//            double d1 = Double.parseDouble(cmimi);
//            rezultati += d1;
//        }
//        DecimalFormat format = new DecimalFormat("#.#");
//        format.setMinimumFractionDigits(2);
        //Totali.setText(format.format(rezultati));
        Totali.setText(""+rezultati);
    }
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Supermarketi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Supermarketi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Supermarketi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Supermarketi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Supermarketi s = new Supermarketi();
                s.setVisible(true);
                s.setExtendedState(JFrame.MAXIMIZED_BOTH);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane DesktopPane;
    private javax.swing.JMenu FileMenu;
    private javax.swing.JMenuBar MenuBar;
    private javax.swing.JLabel Totali;
    private javax.swing.JMenu ckyquMenu;
    private javax.swing.JMenu dergesatMenu;
    private javax.swing.JMenuItem dilMenu;
    private javax.swing.JButton fshijButton;
    private javax.swing.JButton fshijTeGjithaButton;
    private javax.swing.JMenu furnizuesitMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField kerkoField;
    private javax.swing.JButton klientetButton;
    private javax.swing.JMenuItem listaDergesave;
    private javax.swing.JMenuItem listaEPergjithshme;
    private javax.swing.JMenuItem listaFurnizuesve;
    private javax.swing.JMenuItem listaShitjeve;
    private javax.swing.JMenu shitjetMenu;
    private javax.swing.JMenuItem shtoArtikullin;
    public javax.swing.JTable tabelaKryesore;
    // End of variables declaration//GEN-END:variables
}
