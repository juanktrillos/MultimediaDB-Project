/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jFrames;

import database.BaseDatos;
import entidades.Registro_Visitas;
import entidades.Sitios_Interes;
import java.io.*;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jfree.chart.*;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author Cristian Trujillo 
 * @author Juan Camilo Trillos 
 * @author Kevin Carrillo
 */
public class Grafica extends javax.swing.JPanel {

    LinkedList<Sitios_Interes> sitios;
    LinkedList<Registro_Visitas> registro;
    DefaultPieDataset dataset;

    public Grafica() {
        initComponents();
        sitios = new LinkedList<>();
        registro = new LinkedList<>();
        dataset = new DefaultPieDataset();
    }

    public void chargeDataSitios(String category) {
        BaseDatos db = new BaseDatos();
        if (db.crearConexion()) {
            String sql = "SELECT sitios_interes.* FROM categorias, sitios_interes "
                    + "WHERE idCategoria=idCategoriaS and nombreCategoria='" + category + "'";
            LinkedList<Object> list = db.select(sql);
            LinkedList<Object> listValues;

            int size = list.size();
            int cant = size / 8;

            for (int i = 0; i < cant; i++) {
                listValues = new LinkedList<>();
                for (int j = 0; j < 8; j++) {
                    if (!list.isEmpty()) {
                        listValues.add(list.removeFirst());
                    }
                }
                Sitios_Interes sitioTemp = new Sitios_Interes();
                sitioTemp.read(listValues);
                sitios.add(sitioTemp);
            }
        }
    }

    public void chargeDataRegistros(String select) {
        BaseDatos db = new BaseDatos();
        if (db.crearConexion()) {
            LinkedList<Object> list = db.select(select);
            LinkedList<Object> listValues;

            int size = list.size();
            int cant = size / 4;

            for (int i = 0; i < cant; i++) {
                listValues = new LinkedList<>();
                for (int j = 0; j < 4; j++) {
                    if (!list.isEmpty()) {
                        listValues.add(list.removeFirst());
                    }
                }
                Registro_Visitas visita = new Registro_Visitas();
                visita.read(listValues);
                registro.add(visita);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        Jlista = new javax.swing.JComboBox<String>();
        Jfondo = new javax.swing.JLabel();

        jButton1.setText("Grafica");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        Jlista.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Centro Comercial", "Hotel", "Restaurante" }));
        Jlista.setSelectedIndex(-1);
        Jlista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JlistaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Jfondo, javax.swing.GroupLayout.DEFAULT_SIZE, 811, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(147, 147, 147)
                .addComponent(Jlista, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Jfondo, javax.swing.GroupLayout.PREFERRED_SIZE, 468, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(Jlista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        try {
            String category = Jlista.getSelectedItem().toString();

            JFreeChart chart = ChartFactory.createPieChart(
                    category, // chart title
                    dataset, // data
                    true, // include legend
                    true,
                    false);

            int width = 560;
            /* Width of the image */
            int height = 370;
            /* Height of the image */
            File pieChart = new File("Pie_Chart.jpeg");

            ChartUtilities.saveChartAsJPEG(pieChart, chart, width, height);
//        Jfondo.setIcon(new ImageIcon(chart.getBackgroundImage()));
        } catch (IOException ex) {
            Logger.getLogger(Grafica.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void JlistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JlistaActionPerformed
        // TODO add your handling code here:
        String category = Jlista.getSelectedItem().toString();
        System.out.println("::" + category + "::");
        BaseDatos db = new BaseDatos();
        chargeDataSitios(category);
        if (db.crearConexion()) {
            for (Sitios_Interes sitio : sitios) {
                Registro_Visitas visita = new Registro_Visitas(sitio.getIdSitio());
                chargeDataRegistros(visita.selectFK());
                for (Registro_Visitas vis : registro) {
                    dataset.setValue(new Integer(vis.getIdSitios()), new Integer(vis.getIdSitios()));
                }
            }
        }
    }//GEN-LAST:event_JlistaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Jfondo;
    private javax.swing.JComboBox<String> Jlista;
    private javax.swing.JButton jButton1;
    // End of variables declaration//GEN-END:variables
}
