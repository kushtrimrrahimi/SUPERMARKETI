package GUI;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ARSIM
 */
public class LOGIN extends javax.swing.JFrame {

    /**
     * Creates new form LOGIN
     */
    public LOGIN() {
        initComponents();
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        DesktopPane = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        perdoruesi = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        passwordi = new javax.swing.JPasswordField();
        kyqu = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        DesktopPane.setBackground(new java.awt.Color(255, 255, 255));
        DesktopPane.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        DesktopPane.setName(""); // NOI18N

        jLabel1.setText("Përdoruesi:");

        jLabel2.setText("Passwordi:");

        kyqu.setText("Kyqu");
        kyqu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kyquActionPerformed(evt);
            }
        });

        DesktopPane.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        DesktopPane.setLayer(perdoruesi, javax.swing.JLayeredPane.DEFAULT_LAYER);
        DesktopPane.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        DesktopPane.setLayer(passwordi, javax.swing.JLayeredPane.DEFAULT_LAYER);
        DesktopPane.setLayer(kyqu, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout DesktopPaneLayout = new javax.swing.GroupLayout(DesktopPane);
        DesktopPane.setLayout(DesktopPaneLayout);
        DesktopPaneLayout.setHorizontalGroup(
            DesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DesktopPaneLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(DesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(kyqu, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(DesktopPaneLayout.createSequentialGroup()
                        .addGroup(DesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(DesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(passwordi, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(perdoruesi, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(59, Short.MAX_VALUE))
        );
        DesktopPaneLayout.setVerticalGroup(
            DesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DesktopPaneLayout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addGroup(DesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(perdoruesi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(DesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(59, 59, 59)
                .addComponent(kyqu, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(DesktopPane)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(DesktopPane, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void kyquActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kyquActionPerformed
        try{
            Supermarketi s = new Supermarketi();
            s.show();
            setVisible(false);
        }
        catch(Exception ex){
            
        }
        
    }//GEN-LAST:event_kyquActionPerformed

//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Windows".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(LOGIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(LOGIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(LOGIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(LOGIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new LOGIN().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane DesktopPane;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton kyqu;
    private javax.swing.JPasswordField passwordi;
    private javax.swing.JTextField perdoruesi;
    // End of variables declaration//GEN-END:variables
}
