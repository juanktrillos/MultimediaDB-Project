/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jFrames;

import entidades.Cuentas;
import database.BaseDatos;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Cristian Trujillo 
 * @author Juan Camilo Trillos 
 * @author Kevin Carrillo
 */
public class Registro extends JPanel {

    Ventana ven;

    public Registro(Ventana ven) {
        initComponents();
        this.ven = ven;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCelular = new javax.swing.JTextField();
        JPasscon = new javax.swing.JPasswordField();
        BtCrear = new javax.swing.JButton();
        jApellido = new javax.swing.JTextField();
        jCorreo = new javax.swing.JTextField();
        jNombre = new javax.swing.JTextField();
        JPass = new javax.swing.JPasswordField();
        JFondo = new javax.swing.JLabel();

        setToolTipText("Cuenta");
        setMinimumSize(new java.awt.Dimension(450, 450));
        setPreferredSize(new java.awt.Dimension(450, 450));
        setSize(new java.awt.Dimension(450, 450));
        setLayout(null);
        add(jCelular);
        jCelular.setBounds(150, 200, 198, 26);

        JPasscon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JPassconActionPerformed(evt);
            }
        });
        add(JPasscon);
        JPasscon.setBounds(150, 350, 198, 26);

        BtCrear.setText("Crear");
        BtCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtCrearActionPerformed(evt);
            }
        });
        add(BtCrear);
        BtCrear.setBounds(210, 400, 77, 29);
        add(jApellido);
        jApellido.setBounds(150, 140, 198, 26);
        add(jCorreo);
        jCorreo.setBounds(150, 250, 198, 26);
        add(jNombre);
        jNombre.setBounds(150, 90, 198, 26);

        JPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JPassActionPerformed(evt);
            }
        });
        add(JPass);
        JPass.setBounds(150, 300, 198, 26);

        JFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fotos/Registo.jpg"))); // NOI18N
        JFondo.setMaximumSize(new java.awt.Dimension(420, 450));
        add(JFondo);
        JFondo.setBounds(0, -3, 400, 450);
    }// </editor-fold>//GEN-END:initComponents

    private void JPassconActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JPassconActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JPassconActionPerformed


    private void BtCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtCrearActionPerformed

        BaseDatos base = new BaseDatos();
        String Nombre = jNombre.getText();
        String Apellido = jApellido.getText();
        String Celular = jCelular.getText();
        String Correo = jCorreo.getText();
        
        try {
            if (base.crearConexion()) {
                if (new String(JPass.getPassword()).equals(new String(JPasscon.getPassword()))) {

                    String Contraseña = new String(JPasscon.getPassword());
                    String cifrado = Cuentas.Encriptar(Contraseña);

                    Cuentas cuentaTemp = new Cuentas(Correo, cifrado, Nombre, Apellido, Celular);
                    boolean insertado = base.insert(cuentaTemp.insert());

                    if (insertado) {
                        JOptionPane.showMessageDialog(null, "Registrado");
                    }
                    jPCuenta reg = new jPCuenta(ven);
                    ven.setContentPane(reg);
                    ven.setSize(410, 350);
                }
            } else {
                JOptionPane.showMessageDialog(null, "La contraseña no coincide");
            }
        } catch (Exception ex) {
            Logger.getLogger(Registro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BtCrearActionPerformed

    private void JPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JPassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JPassActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtCrear;
    private javax.swing.JLabel JFondo;
    private javax.swing.JPasswordField JPass;
    private javax.swing.JPasswordField JPasscon;
    private javax.swing.JTextField jApellido;
    private javax.swing.JTextField jCelular;
    private javax.swing.JTextField jCorreo;
    private javax.swing.JTextField jNombre;
    // End of variables declaration//GEN-END:variables
}
