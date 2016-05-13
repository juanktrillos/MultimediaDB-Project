/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jFrames;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author CATV
 */
public class PagInfo extends JPanel {

    Ventana ven;

    /**
     * Creates new form PAg
     *
     * @param ven
     */
    public PagInfo(Ventana ven) {
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

        LCentroC = new javax.swing.JLabel();
        LMuseo = new javax.swing.JLabel();
        LRestaurante = new javax.swing.JLabel();
        LHotel = new javax.swing.JLabel();
        JFondo = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(900, 334));
        setSize(new java.awt.Dimension(900, 334));
        setLayout(null);

        LCentroC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LCentroCMouseClicked(evt);
            }
        });
        add(LCentroC);
        LCentroC.setBounds(500, 0, 400, 170);

        LMuseo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LMuseoMouseClicked(evt);
            }
        });
        add(LMuseo);
        LMuseo.setBounds(510, 170, 390, 160);

        LRestaurante.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LRestauranteMouseClicked(evt);
            }
        });
        add(LRestaurante);
        LRestaurante.setBounds(0, 0, 500, 170);

        LHotel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LHotelMouseClicked(evt);
            }
        });
        add(LHotel);
        LHotel.setBounds(0, 170, 500, 160);

        JFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fotos/Collage.jpg"))); // NOI18N
        JFondo.setMaximumSize(new java.awt.Dimension(900, 334));
        JFondo.setMinimumSize(new java.awt.Dimension(900, 334));
        JFondo.setPreferredSize(new java.awt.Dimension(900, 334));
        add(JFondo);
        JFondo.setBounds(0, 0, 900, 334);
    }// </editor-fold>//GEN-END:initComponents

    private void LCentroCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LCentroCMouseClicked
        jPSitiosInteres sitio = new jPSitiosInteres("Centro Comercial", ven);
        ven.setContentPane(sitio);
        ven.setSize(900, 650);
    }//GEN-LAST:event_LCentroCMouseClicked

    private void LHotelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LHotelMouseClicked
        // TODO add your handling code here:
        jPSitiosInteres sitio = new jPSitiosInteres("Hotel", ven);
        ven.setContentPane(sitio);
        ven.setSize(900, 650);
    }//GEN-LAST:event_LHotelMouseClicked

    private void LRestauranteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LRestauranteMouseClicked
        // TODO add your handling code here:
        jPSitiosInteres sitio = new jPSitiosInteres("Restaurante", ven);
        ven.setContentPane(sitio);
        ven.setSize(900, 650);
    }//GEN-LAST:event_LRestauranteMouseClicked

    private void LMuseoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LMuseoMouseClicked
        // TODO add your handling code here:
        jPSitiosInteres sitio = new jPSitiosInteres("Museo", ven);
        ven.setContentPane(sitio);
        ven.setSize(900, 650);
    }//GEN-LAST:event_LMuseoMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JFondo;
    private javax.swing.JLabel LCentroC;
    private javax.swing.JLabel LHotel;
    private javax.swing.JLabel LMuseo;
    private javax.swing.JLabel LRestaurante;
    // End of variables declaration//GEN-END:variables
}
