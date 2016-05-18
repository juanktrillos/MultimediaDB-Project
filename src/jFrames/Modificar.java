/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jFrames;

import database.BaseDatos;
import entidades.Contenidos_Multimedia;
import entidades.Imagenes;
import entidades.Sitios_Interes;
import java.awt.event.ContainerListener;
import java.util.LinkedList;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author CATV
 */
public class Modificar extends JPanel {

    Ventana ven;
    LinkedList<Sitios_Interes> sitios;
    LinkedList<Contenidos_Multimedia> contenido;
    LinkedList<Imagenes> imagen;
    String category;

    ImageIcon img;

    Sitios_Interes sitio;

    /**
     * Creates new form PAg
     *
     * @param ven
     */
    public Modificar(Ventana ven) {
        initComponents();
        this.ven = ven;
        img = new ImageIcon();
        sitios = new LinkedList<>();
        imagen = new LinkedList<>();
        contenido = new LinkedList<>();
        sitio = new Sitios_Interes();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Jlista = new javax.swing.JComboBox<String>();
        JAtras = new javax.swing.JButton();
        JMod = new javax.swing.JButton();
        JNombre = new javax.swing.JTextField();
        JDireccion = new javax.swing.JTextField();
        JInfo = new javax.swing.JTextField();
        JCalificacion = new javax.swing.JComboBox<String>();
        JReseña = new javax.swing.JTextField();
        JHorario = new javax.swing.JTextField();
        JImagen = new javax.swing.JLabel();
        JAdd = new javax.swing.JButton();
        jLugares = new javax.swing.JComboBox<String>();
        JID = new javax.swing.JLabel();
        JidImagen = new javax.swing.JLabel();
        JIdContenido = new javax.swing.JLabel();
        Jfondo = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(718, 529));
        setLayout(null);

        Jlista.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Centro Comercial", "Hotel", "Restaurante" }));
        Jlista.setSelectedIndex(-1);
        Jlista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JlistaActionPerformed(evt);
            }
        });
        add(Jlista);
        Jlista.setBounds(70, 70, 209, 20);

        JAtras.setText("Atras");
        JAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JAtrasActionPerformed(evt);
            }
        });
        add(JAtras);
        JAtras.setBounds(30, 490, 59, 23);

        JMod.setText("Modificar");
        JMod.setEnabled(false);
        JMod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JModActionPerformed(evt);
            }
        });
        add(JMod);
        JMod.setBounds(210, 490, 75, 23);
        add(JNombre);
        JNombre.setBounds(150, 200, 223, 20);
        add(JDireccion);
        JDireccion.setBounds(150, 230, 223, 20);
        add(JInfo);
        JInfo.setBounds(150, 410, 223, 66);

        JCalificacion.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5" }));
        JCalificacion.setSelectedIndex(1);
        add(JCalificacion);
        JCalificacion.setBounds(150, 270, 31, 20);
        add(JReseña);
        JReseña.setBounds(150, 340, 223, 66);
        add(JHorario);
        JHorario.setBounds(150, 310, 223, 20);
        add(JImagen);
        JImagen.setBounds(420, 70, 260, 210);

        JAdd.setText("Agregar");
        JAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JAddActionPerformed(evt);
            }
        });
        add(JAdd);
        JAdd.setBounds(520, 370, 71, 23);

        jLugares.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jLugaresActionPerformed(evt);
            }
        });
        add(jLugares);
        jLugares.setBounds(70, 130, 200, 20);

        JID.setFont(new java.awt.Font("Noteworthy", 0, 18)); // NOI18N
        JID.setForeground(new java.awt.Color(255, 255, 255));
        add(JID);
        JID.setBounds(120, 160, 80, 30);

        JidImagen.setFont(new java.awt.Font("Noteworthy", 0, 18)); // NOI18N
        JidImagen.setForeground(new java.awt.Color(255, 255, 255));
        add(JidImagen);
        JidImagen.setBounds(530, 290, 80, 30);

        JIdContenido.setFont(new java.awt.Font("Noteworthy", 0, 18)); // NOI18N
        JIdContenido.setForeground(new java.awt.Color(255, 255, 255));
        add(JIdContenido);
        JIdContenido.setBounds(560, 320, 80, 30);

        Jfondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fotos/MenuMod.png"))); // NOI18N
        add(Jfondo);
        Jfondo.setBounds(0, 0, 720, 530);
    }// </editor-fold>//GEN-END:initComponents

    private void JAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JAddActionPerformed
        img = Imagenes.cargarArchivos();
        JImagen.setIcon(img);
        JMod.setEnabled(true);
    }//GEN-LAST:event_JAddActionPerformed

    private void JModActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JModActionPerformed
        // TODO add your handling code here:
        BaseDatos base = new BaseDatos();
        Sitios_Interes lugar;
        Imagenes imagenTemp;
        String Nombre = JNombre.getText();
        String Dir = JDireccion.getText();
        String Horario = JHorario.getText();
        String Reseña = JReseña.getText();
        String Info = JInfo.getText();
        int calificacion = (JCalificacion.getSelectedIndex() + 1);
        int idSitio = new Integer(JID.getText());
        int categoria = (Jlista.getSelectedIndex() + 1);

        if (base.crearConexion()) {
            lugar = new Sitios_Interes(idSitio, Nombre, Dir, calificacion, Reseña, Horario, Info, categoria);
            base.update(lugar.update());
            //IMAGEN
            int idContenido = new Integer(JIdContenido.getText());
            int idImagen = new Integer(JidImagen.getText());
            imagenTemp = new Imagenes(idImagen, Nombre, Reseña, img, idContenido);
            base.updateImage(imagenTemp);
        }
    }//GEN-LAST:event_JModActionPerformed

    private void JlistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JlistaActionPerformed
        // TODO add your handling code here:
        category = Jlista.getSelectedItem().toString();
        System.out.println(category);
        chargeSitios();
        for (Sitios_Interes sitio1 : sitios) {
            jLugares.addItem(sitio1.getNombre());
        }
    }//GEN-LAST:event_JlistaActionPerformed


    private void jLugaresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jLugaresActionPerformed
        // TODO add your handling code here:
        int lugar = (jLugares.getSelectedIndex());
        System.out.println("Pulsee  " + lugar);

        JNombre.setText(sitios.get(lugar).getNombre());
        JDireccion.setText(sitios.get(lugar).getDireccion());
        JHorario.setText(sitios.get(lugar).getHorario());
        JReseña.setText(sitios.get(lugar).getReseña());
        JInfo.setText(sitios.get(lugar).getInfoAdicional());
        JID.setText("" + sitios.get(lugar).getIdSitio());

        //Imagen
        img = imagen.get(lugar).getImagen();
        JImagen.setIcon(img);
        JIdContenido.setText("" + contenido.get(lugar).getIdContenido());
        JidImagen.setText("" + imagen.get(lugar).getIdImagen());
        JMod.setEnabled(true);
    }//GEN-LAST:event_jLugaresActionPerformed

    private void JAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JAtrasActionPerformed
        // TODO add your handling code here:
        MenuAdmin menu = new MenuAdmin(ven);
        ven.setContentPane(menu);
        ven.setSize(720, 580);
    }//GEN-LAST:event_JAtrasActionPerformed

    //<editor-fold defaultstate="collapsed" desc="ObtenerInfo(): Metodo que Busca los Sitios en la DB">
    private void chargeSitios() {
        BaseDatos db = new BaseDatos();
        if (db.crearConexion()) {
            //SE BUSCAN LOS SITIOS DE INTERES
            chargeDataSitios(db, 8);
            //SE BUSCAN LOS CONTENIDOS MULTIMEDIA DEL SITIO DE INTERES
            chargeDataContenido(db, 3);
            //SE BUSCAN LAS IMAGENES DE LOS CONTENIDOS MULTIMEDIA
            if (!contenido.isEmpty()) {
                chargeDataImagenes(db, 6);
            }
        }
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="chargeDataSitios(BaseDatos, int)">
    public void chargeDataSitios(BaseDatos db, int attri) {
        String sql = "SELECT sitios_interes.* FROM categorias, sitios_interes "
                + "WHERE idCategoria=idCategoriaS and nombreCategoria='" + category + "'";
        LinkedList<Object> list = db.select(sql);
        LinkedList<Object> listValues;

        int size = list.size();
        int cant = size / attri;

        for (int i = 0; i < cant; i++) {
            listValues = new LinkedList<>();
            for (int j = 0; j < attri; j++) {
                if (!list.isEmpty()) {
                    listValues.add(list.removeFirst());
                }
            }
            Sitios_Interes sitioTemp = new Sitios_Interes();
            sitioTemp.read(listValues);
            sitios.add(sitioTemp);
        }
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="chargeDataContenido(BaseDatos, int)">
    public void chargeDataContenido(BaseDatos db, int attri) {
        String sql = "SELECT contenidos_multimedia.* FROM categorias, sitios_interes, contenidos_multimedia "
                + "WHERE idCategoria=idCategoriaS and idSitio=idSitiosc and nombreCategoria='" + category + "'";
        LinkedList<Object> list = db.select(sql);
        LinkedList<Object> listValues;

        int size = list.size();
        int cant = size / attri;

        for (int i = 0; i < cant; i++) {
            listValues = new LinkedList<>();
            for (int j = 0; j < attri; j++) {
                if (!list.isEmpty()) {
                    listValues.add(list.removeFirst());
                }
            }
            Contenidos_Multimedia cont = new Contenidos_Multimedia();
            cont.read(listValues);
            contenido.add(cont);
        }
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="chargeDataImagenes(BaseDatos, int)">
    public void chargeDataImagenes(BaseDatos db, int attri) {

        LinkedList<Object> list;
        LinkedList<Object> listValues;
        for (Contenidos_Multimedia cont : contenido) {

            Imagenes imgTemp = new Imagenes(cont.getIdContenido());
            list = db.select(imgTemp.selectFK());

            int size = list.size();
            int cant = size / attri;

            for (int i = 0; i < cant; i++) {
                listValues = new LinkedList<>();
                for (int j = 0; j < attri; j++) {
                    if (!list.isEmpty()) {
                        listValues.add(list.removeFirst());
                    }
                }
                imgTemp.read(listValues);
                imagen.add(imgTemp);
            }
        }
    }
//</editor-fold>

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JAdd;
    private javax.swing.JButton JAtras;
    private javax.swing.JComboBox<String> JCalificacion;
    private javax.swing.JTextField JDireccion;
    private javax.swing.JTextField JHorario;
    private javax.swing.JLabel JID;
    private javax.swing.JLabel JIdContenido;
    private javax.swing.JLabel JImagen;
    private javax.swing.JTextField JInfo;
    private javax.swing.JButton JMod;
    private javax.swing.JTextField JNombre;
    private javax.swing.JTextField JReseña;
    private javax.swing.JLabel Jfondo;
    private javax.swing.JLabel JidImagen;
    private javax.swing.JComboBox<String> Jlista;
    private javax.swing.JComboBox<String> jLugares;
    // End of variables declaration//GEN-END:variables
}
