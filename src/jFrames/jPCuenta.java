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
//    Cuentas cuenta;

    public jPCuenta(Ventana vena) {
        initComponents();
        this.ven = vena;
//        cuenta = new Cuentas();
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

        jLabel1.setText("Correo");

        jLabel2.setText("Contraseña");

        JPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JPassActionPerformed(evt);
            }
        });

        BtIngreso.setText("Ingresar");
        BtIngreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtIngresoActionPerformed(evt);
            }
        });

        BtRegistro.setText("Registro");
        BtRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtRegistroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BtRegistro)
                .addGap(21, 21, 21))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(46, 46, 46)
                            .addComponent(jLabel2)
                            .addGap(18, 18, 18)
                            .addComponent(JPass, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(173, 173, 173)
                            .addComponent(BtIngreso))))
                .addContainerGap(118, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(BtIngreso)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(BtRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void JPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JPassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JPassActionPerformed

    private void BtIngresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtIngresoActionPerformed

        if (ComprobarUser()) {
            PagInfo pag = new PagInfo(ven);
//            Ajustes ajuste = new Ajustes(ven, cuenta.getCorreo());
            ven.setContentPane(pag);
            ven.setSize(640, 480);
        }
    }//GEN-LAST:event_BtIngresoActionPerformed

    private void BtRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtRegistroActionPerformed
        Registro reg = new Registro(ven);
        ven.setContentPane(reg);
        ven.setSize(450, 450);
    }//GEN-LAST:event_BtRegistroActionPerformed

    public boolean ComprobarUser() {

        boolean flag = false;
        BaseDatos base = new BaseDatos();
        String correo = jCorreo.getText();
        String password = new String(JPass.getPassword());
        String cifrado = Cuentas.Encriptar(password);
        Cuentas cuenta = new Cuentas(correo, cifrado);

        if (base.crearConexion()) {
            LinkedList<Object> list = base.read(cuenta.select());

            if (!list.isEmpty()) {
                cuenta.read(list);
                if (jCorreo.getText().equals(cuenta.getCorreo()) && cifrado.equals(cuenta.getPassword())) {
                    System.out.println("Correo valido");
                    System.out.println("Contraseña valida");
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
    private javax.swing.JButton BtRegistro;
    private javax.swing.JPasswordField JPass;
    private javax.swing.JTextField jCorreo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
