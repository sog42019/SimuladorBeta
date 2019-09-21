/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulador.de.procesos;

import simulador.de.procesos.Ventana;

/**
 *
 * @author guido
 */
public class Interfaz extends javax.swing.JFrame {

    /**
     * Creates new form Interfaz
     */
    public Interfaz() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonSalir = new javax.swing.JButton();
        jLabelUTNLOGO = new javax.swing.JLabel();
        jButtonEMPEZAR = new javax.swing.JButton();
        jLabelFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonSalir.setBackground(new java.awt.Color(0, 0, 102));
        jButtonSalir.setFont(new java.awt.Font("Dialog", 3, 11)); // NOI18N
        jButtonSalir.setForeground(new java.awt.Color(255, 255, 255));
        jButtonSalir.setText("Salir");
        jButtonSalir.setBorder(new javax.swing.border.MatteBorder(null));
        jButtonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalirActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 10, 50, 20));

        jLabelUTNLOGO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/UTN.png"))); // NOI18N
        jLabelUTNLOGO.setText("jLabel1");
        getContentPane().add(jLabelUTNLOGO, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, 290, 340));

        jButtonEMPEZAR.setBackground(new java.awt.Color(0, 0, 102));
        jButtonEMPEZAR.setFont(new java.awt.Font("Dialog", 3, 36)); // NOI18N
        jButtonEMPEZAR.setForeground(new java.awt.Color(0, 204, 204));
        jButtonEMPEZAR.setText("Iniciar");
        jButtonEMPEZAR.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        jButtonEMPEZAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEMPEZARActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonEMPEZAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 420, 200, 40));

        jLabelFondo.setBackground(new java.awt.Color(255, 255, 255));
        jLabelFondo.setForeground(new java.awt.Color(255, 255, 255));
        jLabelFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Aurora boreal .jpg"))); // NOI18N
        jLabelFondo.setText("Fondo");
        getContentPane().add(jLabelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 409, 561));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalirActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jButtonSalirActionPerformed

    private void jButtonEMPEZARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEMPEZARActionPerformed
        // TODO add your handling code here:
        Ventana v2 = new Ventana();
        dispose();
        v2.setVisible(true);
        
        
        
    }//GEN-LAST:event_jButtonEMPEZARActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interfaz().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonEMPEZAR;
    private javax.swing.JButton jButtonSalir;
    private javax.swing.JLabel jLabelFondo;
    private javax.swing.JLabel jLabelUTNLOGO;
    // End of variables declaration//GEN-END:variables
}
