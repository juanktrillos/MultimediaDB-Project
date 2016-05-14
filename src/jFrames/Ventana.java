package jFrames;

import entidades.Cuentas;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenuItem;

/**
 *
 * @author CATV
 */
public class Ventana extends JFrame {

    Cuentas cuenta;

    public Ventana() {
        initComponents();
        super.setTitle("Turismo");
//        this.setLocationRelativeTo(null);
        cuenta = null;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        JRegistro = new javax.swing.JLabel();
        JInicio = new javax.swing.JLabel();
        jFondo = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        MenuInicio = new javax.swing.JMenuItem();
        MenuSalida = new javax.swing.JMenuItem();
        Cuenta = new javax.swing.JMenu();
        jAjustes = new javax.swing.JMenuItem();
        jAjustes1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Incio");
        getContentPane().setLayout(null);

        jPanel1.setPreferredSize(new java.awt.Dimension(900, 600));
        jPanel1.setLayout(null);

        JRegistro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JRegistroMouseClicked(evt);
            }
        });
        jPanel1.add(JRegistro);
        JRegistro.setBounds(40, 510, 310, 80);

        JInicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JInicioMouseClicked(evt);
            }
        });
        jPanel1.add(JInicio);
        JInicio.setBounds(40, 440, 260, 70);

        jFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fotos/Fondo.jpg"))); // NOI18N
        jFondo.setToolTipText("");
        jFondo.setPreferredSize(new java.awt.Dimension(900, 600));
        jPanel1.add(jFondo);
        jFondo.setBounds(0, -20, 900, 630);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 900, 600);

        jMenu1.setText("");

        MenuInicio.setText("Inicio");
        MenuInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuInicioActionPerformed(evt);
            }
        });
        jMenu1.add(MenuInicio);

        MenuSalida.setText("Salir");
        MenuSalida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuSalidaActionPerformed(evt);
            }
        });
        jMenu1.add(MenuSalida);

        jMenuBar1.add(jMenu1);

        Cuenta.setText("Cuenta");

        jAjustes.setText("Ajustes");
        jAjustes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAjustesActionPerformed(evt);
            }
        });
        Cuenta.add(jAjustes);

        jAjustes1.setText("Logout");
        jAjustes1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAjustes1ActionPerformed(evt);
            }
        });
        Cuenta.add(jAjustes1);

        jMenuBar1.add(Cuenta);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MenuInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuInicioActionPerformed

        if (cuenta == null) {
            //cuando se sale de la cuenta
            jPCuenta jPCuenta = new jPCuenta(this);
            this.setContentPane(jPCuenta);
            this.setSize(410, 350);
        } else {
            //cuando la cuesta activa 
            PagInfo pag = new PagInfo(this);
            this.setContentPane(pag);
            this.setSize(640, 480);
        }
    }//GEN-LAST:event_MenuInicioActionPerformed

    private void MenuSalidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuSalidaActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_MenuSalidaActionPerformed

    private void jAjustesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAjustesActionPerformed

        if (cuenta != null) {
            Ajustes ajuste = new Ajustes(this, cuenta.getCorreo());

//        if (ajuste.Recuperar()) {
            ajuste.info();
            this.setContentPane(ajuste);
            this.setSize(400, 400);
//        } else {
//            JOptionPane.showMessageDialog(null, "Contraseña invalida\n Intente de nuevo");
//        }
        }
    }//GEN-LAST:event_jAjustesActionPerformed

    private void jAjustes1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAjustes1ActionPerformed
        // TODO add your handling code here:
        if (cuenta != null) {
            cuenta = null;
            MenuInicioActionPerformed(evt);
        }
    }//GEN-LAST:event_jAjustes1ActionPerformed

    private void JInicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JInicioMouseClicked

        jPCuenta jPCuenta = new jPCuenta(this);
        this.setContentPane(jPCuenta);
        this.setSize(400, 330);

    }//GEN-LAST:event_JInicioMouseClicked

    private void JRegistroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JRegistroMouseClicked
        // TODO add your handling code here:

        Registro reg = new Registro(this);
        this.setContentPane(reg);
        this.setSize(400, 490);
    }//GEN-LAST:event_JRegistroMouseClicked

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
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Ventana v = new Ventana();
                v.setSize(900, 635);
                v.setPreferredSize(new Dimension(900, 635));
                v.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu Cuenta;
    private javax.swing.JLabel JInicio;
    private javax.swing.JLabel JRegistro;
    private javax.swing.JMenuItem MenuInicio;
    private javax.swing.JMenuItem MenuSalida;
    private javax.swing.JMenuItem jAjustes;
    private javax.swing.JMenuItem jAjustes1;
    private javax.swing.JLabel jFondo;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
