/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lugares;

import Datos.Sitios_Interes;
import Multimedia.Imagenes;
import Multimedia.jPComentario;
import java.awt.Image;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 *
 * @author CATV
 */
public class jPSitiosInteres extends javax.swing.JPanel {

    Sitios_Interes sitio;

    public jPSitiosInteres(String caso) {
        initComponents();
        ObtenerInfo(caso);
    }

    public void ObtenerInfo(String caso) {

        switch (caso) {

            case "Hotel":

//                JNombre.setText(sitio.getNombre());
//                JDir.setText(sitio.getDireccion());
//                JReseña.setText(sitio.getReseña());
//                JCalificacion.setText(""+sitio.getCalificacion());
                //Comentario
                jPComentario com = new jPComentario();
                this.PComentatio.add(com);
                Imagenes img = new Imagenes();
                ArrayList<Image> lista = null;
                try {
                    lista = img.getImagenes();
                } catch (IOException ex) {
                    Logger.getLogger(jPSitiosInteres.class.getName()).log(Level.SEVERE, null, ex);
                }
                JFondo.setIcon(new ImageIcon(lista.get(0)));

                break;
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        JFondo = new javax.swing.JLabel();
        BtD = new javax.swing.JButton();
        BtI = new javax.swing.JButton();
        JReseña = new javax.swing.JLabel();
        JNombre = new javax.swing.JLabel();
        JHorario = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        PComentatio = new javax.swing.JPanel();
        JDir = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        JCalificacion = new javax.swing.JLabel();

        setSize(new java.awt.Dimension(850, 600));
        setLayout(null);

        jLabel2.setText("Direccion");
        add(jLabel2);
        jLabel2.setBounds(30, 430, 60, 16);

        jLabel3.setText("Horario");
        add(jLabel3);
        jLabel3.setBounds(40, 450, 47, 16);
        add(JFondo);
        JFondo.setBounds(80, 60, 722, 365);

        BtD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/arrowsD.png"))); // NOI18N
        BtD.setBorder(null);
        BtD.setBorderPainted(false);
        BtD.setRequestFocusEnabled(false);
        BtD.setSize(new java.awt.Dimension(64, 64));
        BtD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtDActionPerformed(evt);
            }
        });
        add(BtD);
        BtD.setBounds(810, 150, 64, 64);

        BtI.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/arrowsI.png"))); // NOI18N
        BtI.setBorder(null);
        BtI.setBorderPainted(false);
        BtI.setSize(new java.awt.Dimension(64, 64));
        add(BtI);
        BtI.setBounds(10, 160, 64, 64);
        add(JReseña);
        JReseña.setBounds(510, 430, 290, 80);
        add(JNombre);
        JNombre.setBounds(240, 10, 390, 40);
        add(JHorario);
        JHorario.setBounds(120, 450, 128, 16);

        jLabel6.setText("Reseña");
        add(jLabel6);
        jLabel6.setBounds(460, 430, 44, 16);

        PComentatio.setPreferredSize(new java.awt.Dimension(310, 180));

        javax.swing.GroupLayout PComentatioLayout = new javax.swing.GroupLayout(PComentatio);
        PComentatio.setLayout(PComentatioLayout);
        PComentatioLayout.setHorizontalGroup(
            PComentatioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 310, Short.MAX_VALUE)
        );
        PComentatioLayout.setVerticalGroup(
            PComentatioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        add(PComentatio);
        PComentatio.setBounds(50, 470, 310, 120);
        add(JDir);
        JDir.setBounds(120, 430, 240, 16);

        jLabel4.setText("Calificacion");
        add(jLabel4);
        jLabel4.setBounds(500, 520, 80, 16);
        add(JCalificacion);
        JCalificacion.setBounds(600, 520, 128, 20);
    }// </editor-fold>//GEN-END:initComponents


    private void BtDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtDActionPerformed

        Imagenes img = new Imagenes();
        ArrayList<Image> lista = null;
        try {
            lista = img.getImagenes();
        } catch (IOException ex) {
            Logger.getLogger(jPSitiosInteres.class.getName()).log(Level.SEVERE, null, ex);
        }
        JFondo.setIcon(new ImageIcon(lista.get(0)));


    }//GEN-LAST:event_BtDActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtD;
    private javax.swing.JButton BtI;
    private javax.swing.JLabel JCalificacion;
    private javax.swing.JLabel JDir;
    private javax.swing.JLabel JFondo;
    private javax.swing.JLabel JHorario;
    private javax.swing.JLabel JNombre;
    private javax.swing.JLabel JReseña;
    private javax.swing.JPanel PComentatio;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    // End of variables declaration//GEN-END:variables
}
