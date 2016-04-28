/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventana;

import Datos.Cuentas;
import Lugares.PagInfo;
import database.BaseDatos;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author CATV
 */
public class jPCuenta extends javax.swing.JPanel {

    Ventana ven;
    Cuentas cuenta;

    public jPCuenta(Ventana vena) {
        initComponents();
        this.ven = vena;
        cuenta = new Cuentas();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jCorreo = new javax.swing.JTextField();
        JPass = new javax.swing.JPasswordField();
        BtIngreso = new javax.swing.JButton();
        BtRegistro = new javax.swing.JButton();

        setToolTipText("Cuenta");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setPreferredSize(new java.awt.Dimension(400, 300));
        setSize(new java.awt.Dimension(400, 300));
        setLayout(null);

        jLabel1.setText("Correo");
        add(jLabel1);
        jLabel1.setBounds(70, 90, 42, 16);

        jLabel2.setText("Contraseña");
        add(jLabel2);
        jLabel2.setBounds(40, 120, 71, 16);
        add(jCorreo);
        jCorreo.setBounds(130, 80, 198, 26);

        JPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JPassActionPerformed(evt);
            }
        });
        add(JPass);
        JPass.setBounds(130, 110, 198, 26);

        BtIngreso.setText("Ingresar");
        BtIngreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtIngresoActionPerformed(evt);
            }
        });
        add(BtIngreso);
        BtIngreso.setBounds(200, 160, 95, 29);

        BtRegistro.setText("Registro");
        BtRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtRegistroActionPerformed(evt);
            }
        });
        add(BtRegistro);
        BtRegistro.setBounds(290, 250, 96, 30);
    }// </editor-fold>//GEN-END:initComponents

    private void JPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JPassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JPassActionPerformed

    private void BtIngresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtIngresoActionPerformed

        if (ComprobarUser()) {

            PagInfo pag = new PagInfo(ven);
            Ajustes ajuste = new Ajustes(ven,cuenta.getCorreo());
            ven.setContentPane(pag);
            ven.setSize(670, 380);

        }

    }//GEN-LAST:event_BtIngresoActionPerformed

    private void BtRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtRegistroActionPerformed

        Registro reg = new Registro(ven);
        ven.setContentPane(reg);
        ven.setSize(450, 350);


    }//GEN-LAST:event_BtRegistroActionPerformed

    public boolean ComprobarUser() {

        boolean flag = false;
        BaseDatos base = new BaseDatos();
        String contra = new String(JPass.getPassword());
        String cifrado = Cuentas.Encriptar(contra);
        String correo = jCorreo.getText();
        Cuentas cuenta2 = new Cuentas(correo, cifrado);

        if (base.crearConexion()) {

            LinkedList<Object> list = base.read(cuenta2.select());

            System.out.println("tamaño lista   " + list.size());
            if (!list.isEmpty()) {
                cuenta.read(list);
                System.out.println(cuenta.toString());
                if (jCorreo.getText().equals(cuenta.getCorreo()) && cifrado.equals(cuenta.getPassword())) {
                    System.out.println("Correo valido");
                    System.out.println("Contraseña valida");
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
    private javax.swing.JButton BtRegistro;
    private javax.swing.JPasswordField JPass;
    private javax.swing.JTextField jCorreo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
