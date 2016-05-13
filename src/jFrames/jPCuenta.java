/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jFrames;

import entidades.Cuentas;
import database.BaseDatos;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author CATV
 */
public class jPCuenta extends JPanel {

    Ventana ven;
    //Cuentas cuenta;
    boolean root = false;

    public jPCuenta(Ventana vena) {
        initComponents();
        this.ven = vena;
//        cuenta = new Cuentas();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCorreo = new javax.swing.JTextField();
        JPass = new javax.swing.JPasswordField();
        BtIngreso = new javax.swing.JButton();
        JFondo = new javax.swing.JLabel();

        setToolTipText("Cuenta");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setPreferredSize(new java.awt.Dimension(400, 300));
        setSize(new java.awt.Dimension(400, 300));
        setLayout(null);
        add(jCorreo);
        jCorreo.setBounds(140, 90, 198, 26);

        JPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JPassActionPerformed(evt);
            }
        });
        add(JPass);
        JPass.setBounds(140, 130, 198, 26);

        BtIngreso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fotos/BtIcon.jpg"))); // NOI18N
        BtIngreso.setBorder(null);
        BtIngreso.setMargin(new java.awt.Insets(0, 5, 0, 2));
        BtIngreso.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtIngresoMouseClicked(evt);
            }
        });
        BtIngreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtIngresoActionPerformed(evt);
            }
        });
        add(BtIngreso);
        BtIngreso.setBounds(170, 180, 120, 40);

        JFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fotos/Login.jpg"))); // NOI18N
        add(JFondo);
        JFondo.setBounds(0, 0, 418, 300);
    }// </editor-fold>//GEN-END:initComponents

    private void JPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JPassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JPassActionPerformed

    private void BtIngresoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtIngresoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_BtIngresoMouseClicked

    private void BtIngresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtIngresoActionPerformed
        // TODO add your handling code here:

        if (ComprobarUser()) {
            if (root) {
                MenuAdmin menu = new MenuAdmin(ven);
                ven.setContentPane(menu);
                ven.setSize(640, 480);

            } else {
                PagInfo pag = new PagInfo(ven);
                ven.setContentPane(pag);
                ven.setSize(900, 378);
            }
        }


    }//GEN-LAST:event_BtIngresoActionPerformed

    public boolean ComprobarUser() {

        boolean flag = false;
        BaseDatos base = new BaseDatos();
        String correo = jCorreo.getText();
        String password = new String(JPass.getPassword());
        String cifrado = Cuentas.Encriptar(password);
        Cuentas cuenta = new Cuentas(correo, cifrado);

        if (base.crearConexion()) {
            LinkedList<Object> list = base.select(cuenta.select());

            if (!list.isEmpty()) {
                cuenta.read(list);

                if (jCorreo.getText().equals(cuenta.getCorreo()) && cifrado.equals(cuenta.getPassword())) {
                    if (jCorreo.getText().equals("root")) {
                        root = true;
                    }
                    ven.cuenta = cuenta;
                    flag = true;
                } else {
                    JOptionPane.showMessageDialog(null, " Error de contraseña\nintente de nuevo");
                    flag = false;
                }
            } else {
                JOptionPane.showMessageDialog(null, " Este usuario no existe \nintente de nuevo");
                flag = false;
            }
        }
        return flag;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtIngreso;
    private javax.swing.JLabel JFondo;
    private javax.swing.JPasswordField JPass;
    private javax.swing.JTextField jCorreo;
    // End of variables declaration//GEN-END:variables
}
