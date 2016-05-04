/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jFrames;

import database.BaseDatos;
import entidades.Sitios_Interes;
import entidades.Imagenes;
import jFrames.jPComentario;
import java.awt.Image;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 *
 * @author CATV
 */
public class jPSitiosInteres extends javax.swing.JPanel {

    LinkedList<Sitios_Interes> sitios;
    private int pos = 0;

    public jPSitiosInteres(String caso) {
        initComponents();
        sitios = new LinkedList<>();
        ObtenerInfo(caso);
    }

    public void ObtenerInfo(String caso) {

        BaseDatos db = new BaseDatos();
        String select = "SELECT sitios_interes.* FROM ";
        switch (caso) {

            case "Hotel":
                LinkedList<Object> listHotel;
                String sql = select + "categorias, sitios_interes "
                        + "WHERE idCategoria=idCategoriaS and nombreCategoria='" + caso + "'";
                System.out.println(sql);
                if (db.crearConexion()) {
                    LinkedList<Object> list = db.readM(sql);
                    int size = list.size();
                    int cant = size / 8;

                    for (int i = 0; i < cant; i++) {
                        listHotel = new LinkedList<>();
                        for (int j = 0; j < size; j++) {
                            if (!list.isEmpty()) {
                                listHotel.add(list.removeFirst());
                            }
                        }

                        Sitios_Interes hotel = new Sitios_Interes();
                        hotel.read(listHotel);
                        sitios.add(hotel);
                    }
                }
//                JNombre.setText(sitio.getNombre());
                JDir.setText(sitios.get(pos).getDireccion());
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

        jLabel2.setText("Direccion");

        jLabel3.setText("Horario");

        BtD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/arrowsD.png"))); // NOI18N
        BtD.setBorder(null);
        BtD.setBorderPainted(false);
        BtD.setRequestFocusEnabled(false);
        BtD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtDActionPerformed(evt);
            }
        });

        BtI.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/arrowsI.png"))); // NOI18N
        BtI.setBorder(null);
        BtI.setBorderPainted(false);
        BtI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtIActionPerformed(evt);
            }
        });

        jLabel6.setText("Reseña");

        PComentatio.setPreferredSize(new java.awt.Dimension(310, 180));

        javax.swing.GroupLayout PComentatioLayout = new javax.swing.GroupLayout(PComentatio);
        PComentatio.setLayout(PComentatioLayout);
        PComentatioLayout.setHorizontalGroup(
            PComentatioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 310, Short.MAX_VALUE)
        );
        PComentatioLayout.setVerticalGroup(
            PComentatioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 120, Short.MAX_VALUE)
        );

        jLabel4.setText("Calificacion");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(240, 240, 240)
                .addComponent(JNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(BtI)
                .addGap(5, 5, 5)
                .addComponent(JFondo, javax.swing.GroupLayout.PREFERRED_SIZE, 722, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(BtD))
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(47, 47, 47)
                        .addComponent(JDir, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel3)
                        .addGap(45, 45, 45)
                        .addComponent(JHorario, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(PComentatio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(100, 100, 100)
                .addComponent(jLabel6)
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(JReseña, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(JCalificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(JNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(BtI))
                    .addComponent(JFondo, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(BtD)))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(JDir, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(JHorario, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(4, 4, 4)
                        .addComponent(PComentatio, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel6)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JReseña, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(JCalificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );
    }// </editor-fold>//GEN-END:initComponents


    private void BtDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtDActionPerformed

        pos ++;
        
        if(pos>sitios.size()){
            pos = 0;
        }
//        Imagenes img = new Imagenes();
//        ArrayList<Image> lista = null;
//        try {
//            lista = img.getImagenes();
//        } catch (IOException ex) {
//            Logger.getLogger(jPSitiosInteres.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        JFondo.setIcon(new ImageIcon(lista.get(0)));


    }//GEN-LAST:event_BtDActionPerformed

    private void BtIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtIActionPerformed
        // TODO add your handling code here:
        pos--;
        if(pos<0){
            pos = 0;
        }
    }//GEN-LAST:event_BtIActionPerformed


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
