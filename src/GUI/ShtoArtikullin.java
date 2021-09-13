package GUI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import static javax.swing.JOptionPane.showMessageDialog;

public class ShtoArtikullin extends javax.swing.JInternalFrame {

    Connection conn;

    public ShtoArtikullin() {
        initComponents();
        fillNjesiaCombo();
    }
    
    private void fillNjesiaCombo(){
        String [] s = {null,"KG","Cope"};
        for(int i = 0; i < s.length; i++){
            comboNjesia.addItem(s[i]);
        }
    }

    public void shtoArtikullin() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=supermarket;user=sa;password=sa1234";
            Connection conn = DriverManager.getConnection(url);

            String emri = emriArtikullit.getText();
            String sasia = sasiaArtikullit.getText();
            String njesia = comboNjesia.getSelectedItem().toString();
            String barkodi = barkodiArtikullit.getText();
            String cmimi1 = cmimiMeTVSH.getText();
            String cmimi2 = cmimiPaTVSH.getText();
            String prodhuesi = prodhuesiArtikullit.getText();
            String dataEProdhimit = dataProdhimit.getText();
            String dataESkadimit = dataSkadimit.getText();
            String kategoria = kategoriaArtikullit.getSelectedItem().toString();
            
            
            
            if(emri.trim().isEmpty() || sasia.trim().isEmpty() || barkodi.trim().isEmpty() || cmimi1.trim().isEmpty() || cmimi2.trim().isEmpty() || prodhuesi.trim().isEmpty() ||
                    dataEProdhimit.trim().isEmpty() || dataESkadimit.trim().isEmpty() || kategoria.trim().isEmpty()){
                showMessageDialog(null, "Ju lutem plotesoni hapesirat e zbrazura.");
                return;
            }
            
            if(njesia != "KG" && njesia != "Cope"){
                showMessageDialog(null, "Njesia gabim!");
                return;
            }
            
            if(sasia.contains("[a-z]")){
                showMessageDialog(null, "Sasia gabim!");
                return;
            }
            
            if(barkodi.contains("[a-z]")){
                showMessageDialog(null, "Barkodi gabim!");
                return;
            }
            
            if(cmimi1.contains("[a-z]") || cmimi2.contains("[a-z]")){
                showMessageDialog(null,"Cmimi gabim!");
                return;
            }
            
            boolean b = false;
            char [] c = sasia.toCharArray();
            for(int i = 0; i < c.length; i++){
                if((c[i] > 'a' || c[i] > 'A') && (c[i] < 'z' || c[i] < 'Z')){
                    b = true;
                }
            }
            if(b == true){
                showMessageDialog(null, "Sasia gabim!");
                return;
            }

            long barkodi2 = Long.parseLong(barkodi);
            int sasia2 = Integer.parseInt(sasia);
            double cmimi11 = Double.parseDouble(cmimi1);
            
            double cmimi22 = Double.parseDouble(cmimi2);
            
            String cmimi111 = new DecimalFormat("##.##").format(cmimi11);
            String cmimi222 = new DecimalFormat("##.##").format(cmimi22);
            
            int id = 1;

//            String sql = "INSERT INTO ARTIKULLI(SUPERMARKETI_ID, EMRI_I_ARTIKULLIT, BARKODI, "
//                    + "SASIA, CMIMI_ME_TVSH, CMIMI_PA_TVSH, PRODHUESI, DATA_E_PRODHIMIT, DATA_E_SKADIMIT, KATEGORIA) VALUES"
//                    + "(\'" + id +"\'"
//                    + ",\'" + emri + "\'"
//                    + ",\'" + barkodi2 + "\'"
//                    + ",\'" + sasia2 + "\'"
//                    + ",\'" + cmimiTVSH2 + "\'"
//                    + ",\'" + cmimipatvsh2 + "\'"
//                    + ",\'" + prodhuesi + "\'"
//                    + ",\'" + dataEProdhimit + "\'"
//                    + ",\'" + dataESkadimit + "\'"
//                    + ",\'" + kategoria + "\')";

            String sql = "INSERT INTO ARTIKULLI(SUPERMARKETI_ID, EMRI_I_ARTIKULLIT, BARKODI, SASIA, NJESIA, CMIMI_ME_TVSH, "
                    + "CMIMI_PA_TVSH, PRODHUESI, DATA_E_PRODHIMIT, DATA_E_SKADIMIT, KATEGORIA) VALUES (?,?,?,?,?,?,?,?,?,?,?)";

            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, id);
            pst.setString(2, emri.toUpperCase());
            pst.setLong(3, barkodi2);
            pst.setInt(4, sasia2);
            pst.setString(5, njesia.toUpperCase());
            pst.setString(6, cmimi111);
            pst.setString(7, cmimi222);
            pst.setString(8, prodhuesi.toUpperCase());
            pst.setString(9, dataEProdhimit);
            pst.setString(10, dataESkadimit);
            pst.setString(11, kategoria.toUpperCase());

            pst.execute();
            
            showMessageDialog(null,"Artikulli u shtua");
            
            emriArtikullit.setText(null);
            sasiaArtikullit.setText(null);
            comboNjesia.setSelectedItem(null);
            barkodiArtikullit.setText(null);
            cmimiMeTVSH.setText(null);
            prodhuesiArtikullit.setText(null);
            dataProdhimit.setText(null);
            dataSkadimit.setText(null);
            kategoriaArtikullit.setSelectedItem(null);
            cmimiPaTVSH.setText(null);
            
        } catch (Exception ex) {
            showMessageDialog(null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        DP1 = new javax.swing.JDesktopPane();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        emriArtikullit = new javax.swing.JTextField();
        barkodiArtikullit = new javax.swing.JTextField();
        sasiaArtikullit = new javax.swing.JTextField();
        cmimiMeTVSH = new javax.swing.JTextField();
        prodhuesiArtikullit = new javax.swing.JTextField();
        dataProdhimit = new datechooser.beans.DateChooserCombo();
        dataSkadimit = new datechooser.beans.DateChooserCombo();
        kategoriaArtikullit = new javax.swing.JComboBox<>();
        shtoArtikullin = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        cmimiPaTVSH = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        comboNjesia = new javax.swing.JComboBox<>();

        setBorder(javax.swing.BorderFactory.createEtchedBorder());
        setClosable(true);

        DP1.setBackground(new java.awt.Color(255, 255, 255));
        DP1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Emri:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Barkodi:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Sasia:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Cmimi me TVSH:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Prodhuesi");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Data e Prodhimit:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Data e Skadimit:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Kategoria:");

        emriArtikullit.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        barkodiArtikullit.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        sasiaArtikullit.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        cmimiMeTVSH.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        prodhuesiArtikullit.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        dataProdhimit.setFieldFont(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 14));

        dataSkadimit.setFieldFont(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 14));

        kategoriaArtikullit.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        kategoriaArtikullit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "     ", "Ushqim", "Pije", "Tjeter" }));

        shtoArtikullin.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        shtoArtikullin.setText("Shto Artikullin");
        shtoArtikullin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                shtoArtikullinActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Cmimi pa TVSH:");

        cmimiPaTVSH.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Njesia:");

        DP1.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        DP1.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        DP1.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        DP1.setLayer(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        DP1.setLayer(jLabel6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        DP1.setLayer(jLabel7, javax.swing.JLayeredPane.DEFAULT_LAYER);
        DP1.setLayer(jLabel8, javax.swing.JLayeredPane.DEFAULT_LAYER);
        DP1.setLayer(jLabel9, javax.swing.JLayeredPane.DEFAULT_LAYER);
        DP1.setLayer(emriArtikullit, javax.swing.JLayeredPane.DEFAULT_LAYER);
        DP1.setLayer(barkodiArtikullit, javax.swing.JLayeredPane.DEFAULT_LAYER);
        DP1.setLayer(sasiaArtikullit, javax.swing.JLayeredPane.DEFAULT_LAYER);
        DP1.setLayer(cmimiMeTVSH, javax.swing.JLayeredPane.DEFAULT_LAYER);
        DP1.setLayer(prodhuesiArtikullit, javax.swing.JLayeredPane.DEFAULT_LAYER);
        DP1.setLayer(dataProdhimit, javax.swing.JLayeredPane.DEFAULT_LAYER);
        DP1.setLayer(dataSkadimit, javax.swing.JLayeredPane.DEFAULT_LAYER);
        DP1.setLayer(kategoriaArtikullit, javax.swing.JLayeredPane.DEFAULT_LAYER);
        DP1.setLayer(shtoArtikullin, javax.swing.JLayeredPane.DEFAULT_LAYER);
        DP1.setLayer(jLabel10, javax.swing.JLayeredPane.DEFAULT_LAYER);
        DP1.setLayer(cmimiPaTVSH, javax.swing.JLayeredPane.DEFAULT_LAYER);
        DP1.setLayer(jLabel12, javax.swing.JLayeredPane.DEFAULT_LAYER);
        DP1.setLayer(comboNjesia, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout DP1Layout = new javax.swing.GroupLayout(DP1);
        DP1.setLayout(DP1Layout);
        DP1Layout.setHorizontalGroup(
            DP1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DP1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DP1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(DP1Layout.createSequentialGroup()
                        .addGroup(DP1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel10))
                        .addGap(42, 42, 42)
                        .addGroup(DP1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmimiMeTVSH, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(DP1Layout.createSequentialGroup()
                                .addComponent(cmimiPaTVSH, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(shtoArtikullin))))
                    .addGroup(DP1Layout.createSequentialGroup()
                        .addGroup(DP1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel12))
                        .addGap(94, 94, 94)
                        .addGroup(DP1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(emriArtikullit, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                            .addComponent(barkodiArtikullit)
                            .addComponent(sasiaArtikullit)
                            .addComponent(comboNjesia, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(60, 60, 60)
                        .addGroup(DP1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addGap(27, 27, 27)
                        .addGroup(DP1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(dataSkadimit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dataProdhimit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(prodhuesiArtikullit)
                            .addComponent(kategoriaArtikullit, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        DP1Layout.setVerticalGroup(
            DP1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DP1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DP1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DP1Layout.createSequentialGroup()
                        .addGroup(DP1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(emriArtikullit, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(DP1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(barkodiArtikullit, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(DP1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sasiaArtikullit, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(DP1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(DP1Layout.createSequentialGroup()
                                .addComponent(comboNjesia)
                                .addGap(1, 1, 1))))
                    .addGroup(DP1Layout.createSequentialGroup()
                        .addGroup(DP1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(prodhuesiArtikullit, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(DP1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dataProdhimit, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(DP1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(dataSkadimit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(DP1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(kategoriaArtikullit, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(DP1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmimiMeTVSH, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(DP1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DP1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(DP1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmimiPaTVSH, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(DP1Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(shtoArtikullin, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(DP1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(DP1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void shtoArtikullinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_shtoArtikullinActionPerformed
        shtoArtikullin();
    }//GEN-LAST:event_shtoArtikullinActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane DP1;
    private javax.swing.JTextField barkodiArtikullit;
    private javax.swing.JTextField cmimiMeTVSH;
    private javax.swing.JTextField cmimiPaTVSH;
    private javax.swing.JComboBox<String> comboNjesia;
    private datechooser.beans.DateChooserCombo dataProdhimit;
    private datechooser.beans.DateChooserCombo dataSkadimit;
    private javax.swing.JTextField emriArtikullit;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JComboBox<String> kategoriaArtikullit;
    private javax.swing.JTextField prodhuesiArtikullit;
    private javax.swing.JTextField sasiaArtikullit;
    private javax.swing.JButton shtoArtikullin;
    // End of variables declaration//GEN-END:variables
}
