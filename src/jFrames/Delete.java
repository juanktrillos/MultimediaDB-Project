/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jFrames;

import database.BaseDatos;
import entidades.Comentario;
import entidades.Contenidos_Multimedia;
import entidades.Imagenes;
import entidades.Registro_Visitas;
import entidades.Sitios_Interes;
import static java.awt.Component.CENTER_ALIGNMENT;
import java.awt.Image;
import java.awt.event.ContainerListener;
import java.util.LinkedList;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author CATV
 */
public class Delete extends JPanel {

    Ventana ven;
    LinkedList<Sitios_Interes> sitios;
    LinkedList<Contenidos_Multimedia> contenido;
    LinkedList<Imagenes> imagen;
    LinkedList<Comentario> comment;

    String category;

    ImageIcon img;

    Sitios_Interes sitio;

    /**
     * Creates new form PAg
     *
     * @param ven
     */
    public Delete(Ventana ven) {
        initComponents();
        this.ven = ven;
        img = new ImageIcon();
        sitios = new LinkedList<>();
        imagen = new LinkedList<>();
        contenido = new LinkedList<>();
        comment = new LinkedList<>();
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
        JDelete = new javax.swing.JButton();
        JNombre = new javax.swing.JTextField();
        JDireccion = new javax.swing.JTextField();
        JInfo = new javax.swing.JTextField();
        JCalificacion = new javax.swing.JComboBox<String>();
        JReseña = new javax.swing.JTextField();
        JHorario = new javax.swing.JTextField();
        JImagen = new javax.swing.JLabel();
        jLugares = new javax.swing.JComboBox<String>();
        JID = new javax.swing.JLabel();
        JidImagen = new javax.swing.JLabel();
        JIdContenido = new javax.swing.JLabel();
        Jfondo = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(710, 520));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Jlista.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Centro Comercial", "Hotel", "Restaurante", "Museo" }));
        Jlista.setSelectedIndex(-1);
        Jlista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JlistaActionPerformed(evt);
            }
        });
        add(Jlista, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, 209, -1));

        JAtras.setText("Atras");
        JAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JAtrasActionPerformed(evt);
            }
        });
        add(JAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 480, -1, -1));

        JDelete.setText("Eliminar");
        JDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JDeleteActionPerformed(evt);
            }
        });
        add(JDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 360, -1, -1));
        add(JNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 190, 223, -1));

        JDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JDireccionActionPerformed(evt);
            }
        });
        add(JDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 230, 223, -1));
        add(JInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 400, 223, 66));

        JCalificacion.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5" }));
        JCalificacion.setSelectedIndex(-1);
        add(JCalificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 260, -1, -1));
        add(JReseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 330, 223, 66));
        add(JHorario, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 300, 223, -1));
        add(JImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 60, 240, 220));

        jLugares.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jLugaresActionPerformed(evt);
            }
        });
        add(jLugares, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, 200, -1));

        JID.setFont(new java.awt.Font("Noteworthy", 0, 14)); // NOI18N
        JID.setForeground(new java.awt.Color(255, 255, 255));
        add(JID, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 160, 80, 30));

        JidImagen.setFont(new java.awt.Font("Noteworthy", 0, 14)); // NOI18N
        JidImagen.setForeground(new java.awt.Color(255, 255, 255));
        add(JidImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 280, 80, 30));

        JIdContenido.setFont(new java.awt.Font("Noteworthy", 0, 14)); // NOI18N
        JIdContenido.setForeground(new java.awt.Color(255, 255, 255));
        add(JIdContenido, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 310, 80, 30));

        Jfondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fotos/MenuMod.png"))); // NOI18N
        Jfondo.setMinimumSize(new java.awt.Dimension(710, 520));
        Jfondo.setPreferredSize(new java.awt.Dimension(710, 520));
        add(Jfondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 710, 520));
    }// </editor-fold>//GEN-END:initComponents

    private void JDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JDeleteActionPerformed
        // TODO add your handling code here:
        BaseDatos base = new BaseDatos();
        Sitios_Interes lugar;
        Imagenes imagenTemp;
        Comentario comentTemp;
        Registro_Visitas visitas;
        Contenidos_Multimedia contTempo;

        if (base.crearConexion()) {
            //SITIO
            int idSitio = new Integer(JID.getText());
            
            //IMAGEN
            int idContenido = new Integer(JIdContenido.getText());
            imagenTemp = new Imagenes(idContenido);
            base.delete(imagenTemp.deleteFK());

            //CONTENIDO
            contTempo = new Contenidos_Multimedia(idContenido);
            base.delete(contTempo.delete());

            //COMENTARIO
            comentTemp = new Comentario(idSitio);
            base.delete(comentTemp.delete());

            //REGISTROVISITAS
            visitas = new Registro_Visitas(idSitio);
            base.delete(visitas.deleteFK());

            lugar = new Sitios_Interes(idSitio);
            base.delete(lugar.delete());
        }
    }//GEN-LAST:event_JDeleteActionPerformed

    private void JlistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JlistaActionPerformed
        // TODO add your handling code here:
        category = Jlista.getSelectedItem().toString();
        System.out.println(category);
        ObtenerInfo();
        if (sitios.isEmpty()) {
            JNombre.setText("");
            JDireccion.setText("");
            JHorario.setText("");
            JReseña.setText("");
            JInfo.setText("");
            JID.setText("");
            Jlista.setSelectedIndex(-1);
            jLugares.setSelectedIndex(-1);
        }
        for (Sitios_Interes sitio1 : sitios) {
            jLugares.addItem(sitio1.getNombre());
        }
    }//GEN-LAST:event_JlistaActionPerformed


    private void jLugaresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jLugaresActionPerformed
        // TODO add your handling code here:
        int lugar = (jLugares.getSelectedIndex());

            JNombre.setText(sitios.get(lugar).getNombre());
            JDireccion.setText(sitios.get(lugar).getDireccion());
            JHorario.setText(sitios.get(lugar).getHorario());
            JReseña.setText(sitios.get(lugar).getReseña());
            JInfo.setText(sitios.get(lugar).getInfoAdicional());
            JID.setText("" + sitios.get(lugar).getIdSitio());

        //Imagen
        img = imagen.get(lugar).getImagen();
        
        ImageIcon icon = img;
        Image ima = icon.getImage().getScaledInstance(240, 220, Image.SCALE_DEFAULT);
        
        JImagen.setIcon(new ImageIcon(ima));
        JImagen.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        
        JIdContenido.setText("" + contenido.get(lugar).getIdContenido());
        JidImagen.setText("" + imagen.get(lugar).getIdImagen());
    }//GEN-LAST:event_jLugaresActionPerformed

    private void JAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JAtrasActionPerformed
        // TODO add your handling code here:

        MenuAdmin menu = new MenuAdmin(ven);
        ven.setContentPane(menu);
        ven.setSize(720, 580);
    }//GEN-LAST:event_JAtrasActionPerformed

    private void JDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JDireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JDireccionActionPerformed

    //<editor-fold defaultstate="collapsed" desc="ObtenerInfo(): Metodo que Busca los Sitios en la DB">
    private void ObtenerInfo() {

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
        sitios = new LinkedList<>();
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

            Imagenes img = new Imagenes(cont.getIdContenido());
            list = db.select(img.selectFK());

            int size = list.size();
            int cant = size / attri;

            for (int i = 0; i < cant; i++) {
                listValues = new LinkedList<>();
                for (int j = 0; j < attri; j++) {
                    if (!list.isEmpty()) {
                        listValues.add(list.removeFirst());
                    }
                }
                img.read(listValues);
                imagen.add(img);
            }
        }
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="chargeDataComentarios(BaseDatos, int)">
    public void chargeDataComentarios(BaseDatos db, int attri) {

        String sql = "SELECT comentarios.* FROM categorias, sitios_interes, comentarios "
                + "WHERE idCategoria=idCategoriaS and idSitio=idSitioComent and nombreCategoria='" + category + "'";
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
            Comentario com = new Comentario();
            com.read(listValues);
            comment.add(com);
        }
    }
//</editor-fold>


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JAtras;
    private javax.swing.JComboBox<String> JCalificacion;
    private javax.swing.JButton JDelete;
    private javax.swing.JTextField JDireccion;
    private javax.swing.JTextField JHorario;
    private javax.swing.JLabel JID;
    private javax.swing.JLabel JIdContenido;
    private javax.swing.JLabel JImagen;
    private javax.swing.JTextField JInfo;
    private javax.swing.JTextField JNombre;
    private javax.swing.JTextField JReseña;
    private javax.swing.JLabel Jfondo;
    private javax.swing.JLabel JidImagen;
    private javax.swing.JComboBox<String> Jlista;
    private javax.swing.JComboBox<String> jLugares;
    // End of variables declaration//GEN-END:variables
}
