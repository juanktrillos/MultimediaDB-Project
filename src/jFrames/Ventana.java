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
        jFondo.setIcon(new ImageIcon("src/Fotos/Fondo.jpg"));
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
        jCuenta = new javax.swing.JLabel();
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

        jCuenta.setFont(new java.awt.Font("Helvetica", 0, 36)); // NOI18N
        jCuenta.setForeground(new java.awt.Color(255, 255, 255));
        jCuenta.setText("Cuenta");
        jCuenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCuentaMouseClicked(evt);
            }
        });
        jPanel1.add(jCuenta);
        jCuenta.setBounds(100, 460, 120, 40);

        jFondo.setToolTipText("");
        jFondo.setPreferredSize(new java.awt.Dimension(900, 600));
        jPanel1.add(jFondo);
        jFondo.setBounds(0, 0, 900, 600);

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

    private void jCuentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCuentaMouseClicked
        jPCuenta jcuenta = new jPCuenta(this);
//        cuenta = jcuenta.cuenta;
        this.setContentPane(jcuenta);
        this.setSize(410, 350);
    }//GEN-LAST:event_jCuentaMouseClicked

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
                v.setSize(900, 600);
                v.setPreferredSize(new Dimension(900, 600));
                v.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu Cuenta;
    private javax.swing.JMenuItem MenuInicio;
    private javax.swing.JMenuItem MenuSalida;
    private javax.swing.JMenuItem jAjustes;
    private javax.swing.JMenuItem jAjustes1;
    private javax.swing.JLabel jCuenta;
    private javax.swing.JLabel jFondo;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
