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
import java.awt.Image;
import java.util.LinkedList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Cristian Trujillo 
 * @author Juan Camilo Trillos 
 * @author Kevin Carrillo
 */
public class jPSitiosInteres extends javax.swing.JPanel {

    LinkedList<Sitios_Interes> sitios;
    LinkedList<Contenidos_Multimedia> contenido;
    LinkedList<Imagenes> imagen;
    LinkedList<Comentario> comment;
    String category;
    int pos = 0;
    int posC = 0;
    Ventana ven;

    public jPSitiosInteres(String caso, Ventana ven) {
        initComponents();
        sitios = new LinkedList<>();
        imagen = new LinkedList<>();
        contenido = new LinkedList<>();
        comment = new LinkedList<>();
        category = caso;
        this.ven = ven;
        JComentario.setEnabled(false);
        ObtenerInfo();
    }

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

            //SE BUSCAN LOS COMENTARIOS DEL SITIO DE INTERES
            chargeDataComentarios(db, 3);
            despliege();
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

    //<editor-fold defaultstate="collapsed" desc="despliege()">
    public void despliege() {

        if (!sitios.isEmpty()) {
            JNombre.setText(sitios.get(pos).getNombre());
            JDir.setText(sitios.get(pos).getDireccion());
            JTReseña.setText(sitios.get(pos).getReseña());
            JCalificacion.setText(Integer.toString(sitios.get(pos).getCalificacion()));
            JHorario.setText(sitios.get(pos).getHorario());
            registro();
        }
        if (!imagen.isEmpty()) {
            
            ImageIcon icon = imagen.get(pos).getImagen();
            Image imagenTemp = icon.getImage().getScaledInstance(760, 365, Image.SCALE_DEFAULT);
            JFondo.setIcon(new ImageIcon(imagenTemp));
            JFondo.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        }
        if (!comment.isEmpty()) {
            commentDisplay(posC, 1);
        }
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="commentDisply(int, int)">
    public void commentDisplay(int posCTemp, int dir) {

        int id = sitios.get(pos).getIdSitio();
        Comentario comTemp = comment.get(posCTemp);
        if (comTemp.getIdSitioComent() == id) {
            JComentario.setText(comTemp.getTexto());
        } else {
            posCTemp += dir;
            if (posCTemp >= comment.size()) {
                posCTemp = 0;
            }
            if (posCTemp < 0) {
                posCTemp = comment.size() - 1;
            }
            posC = posCTemp;
            commentDisplay(posCTemp, dir);
        }
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="registro()">
    public void registro() {

        int idS = sitios.get(pos).getIdSitio();
        String correo = ven.cuenta.getCorreo();
        Registro_Visitas rv = new Registro_Visitas(idS, correo);
        BaseDatos db = new BaseDatos();
        if (db.crearConexion()) {
            db.insert(rv.insert());
        }
    }
//</editor-fold>

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JFondo = new javax.swing.JLabel();
        BtD = new javax.swing.JButton();
        BtI = new javax.swing.JButton();
        JNombre = new javax.swing.JLabel();
        JHorario = new javax.swing.JLabel();
        JDir = new javax.swing.JLabel();
        JCalificacion = new javax.swing.JLabel();
        JTReseña = new javax.swing.JTextArea();
        JComentario = new javax.swing.JTextArea();
        JAdd = new javax.swing.JButton();
        jNext = new javax.swing.JButton();
        jNext1 = new javax.swing.JButton();
        JBack = new javax.swing.JLabel();

        setLayout(null);
        add(JFondo);
        JFondo.setBounds(70, 60, 760, 365);

        BtD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fotos/BotonN.png"))); // NOI18N
        BtD.setBorderPainted(false);
        BtD.setRequestFocusEnabled(false);
        BtD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtDActionPerformed(evt);
            }
        });
        add(BtD);
        BtD.setBounds(820, 150, 70, 70);

        BtI.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/arrowsI.png"))); // NOI18N
        BtI.setBorder(null);
        BtI.setBorderPainted(false);
        BtI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtIActionPerformed(evt);
            }
        });
        add(BtI);
        BtI.setBounds(10, 160, 64, 64);

        JNombre.setFont(new java.awt.Font("Noteworthy", 0, 24)); // NOI18N
        add(JNombre);
        JNombre.setBounds(250, 20, 390, 40);

        JHorario.setFont(new java.awt.Font("Noteworthy", 0, 18)); // NOI18N
        add(JHorario);
        JHorario.setBounds(130, 454, 240, 30);

        JDir.setFont(new java.awt.Font("Noteworthy", 0, 18)); // NOI18N
        add(JDir);
        JDir.setBounds(130, 420, 240, 30);

        JCalificacion.setFont(new java.awt.Font("Noteworthy", 0, 18)); // NOI18N
        add(JCalificacion);
        JCalificacion.setBounds(500, 450, 190, 30);

        JTReseña.setEditable(false);
        JTReseña.setColumns(20);
        JTReseña.setFont(new java.awt.Font("Noteworthy", 0, 18)); // NOI18N
        JTReseña.setRows(5);
        JTReseña.setBorder(null);
        JTReseña.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        add(JTReseña);
        JTReseña.setBounds(460, 490, 230, 90);

        JComentario.setEditable(false);
        JComentario.setColumns(20);
        JComentario.setFont(new java.awt.Font("Noteworthy", 0, 18)); // NOI18N
        JComentario.setRows(5);
        JComentario.setBorder(null);
        JComentario.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        add(JComentario);
        JComentario.setBounds(140, 490, 230, 90);

        JAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/circle.png"))); // NOI18N
        JAdd.setBorderPainted(false);
        JAdd.setPreferredSize(new java.awt.Dimension(32, 32));
        JAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JAddActionPerformed(evt);
            }
        });
        add(JAdd);
        JAdd.setBounds(40, 530, 40, 34);

        jNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/Next.png"))); // NOI18N
        jNext.setBorderPainted(false);
        jNext.setPreferredSize(new java.awt.Dimension(32, 32));
        jNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jNextActionPerformed(evt);
            }
        });
        add(jNext);
        jNext.setBounds(380, 530, 40, 34);

        jNext1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/NextI.png"))); // NOI18N
        jNext1.setBorderPainted(false);
        jNext1.setPreferredSize(new java.awt.Dimension(32, 32));
        jNext1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jNext1ActionPerformed(evt);
            }
        });
        add(jNext1);
        jNext1.setBounds(90, 530, 40, 34);

        JBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fotos/Sitios-01.png"))); // NOI18N
        add(JBack);
        JBack.setBounds(0, 0, 900, 600);
    }// </editor-fold>//GEN-END:initComponents

    private void BtDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtDActionPerformed
        pos++;
        if (pos >= sitios.size()) {
            pos = 0;
        }
        despliege();
    }//GEN-LAST:event_BtDActionPerformed

    private void BtIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtIActionPerformed
        // TODO add your handling code here:
        pos--;
        if (pos < 0) {
            pos = sitios.size() - 1;
        }
        despliege();
    }//GEN-LAST:event_BtIActionPerformed

    private void JAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JAddActionPerformed

        String add = JOptionPane.showInputDialog("Mensaje");
        BaseDatos base = new BaseDatos();

        if (base.crearConexion()) {
            Comentario com = new Comentario(add, sitios.get(pos).getIdSitio());
            boolean insert = base.insert(com.insert());
            if (insert) {
                comment.add(com);
                JOptionPane.showMessageDialog(null, "Comentario add");
                despliege();
            }
        }
    }//GEN-LAST:event_JAddActionPerformed

    private void jNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jNextActionPerformed
        posC++;
        if (posC >= comment.size()) {
            posC = 0;
        }
        commentDisplay(posC, 1);
    }//GEN-LAST:event_jNextActionPerformed

    private void jNext1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jNext1ActionPerformed
        // TODO add your handling code here:
        posC--;
        if (posC < 0) {
            posC = comment.size() - 1;
        }
        commentDisplay(posC, -1);
    }//GEN-LAST:event_jNext1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtD;
    private javax.swing.JButton BtI;
    private javax.swing.JButton JAdd;
    private javax.swing.JLabel JBack;
    private javax.swing.JLabel JCalificacion;
    private javax.swing.JTextArea JComentario;
    private javax.swing.JLabel JDir;
    private javax.swing.JLabel JFondo;
    private javax.swing.JLabel JHorario;
    private javax.swing.JLabel JNombre;
    private javax.swing.JTextArea JTReseña;
    private javax.swing.JButton jNext;
    private javax.swing.JButton jNext1;
    // End of variables declaration//GEN-END:variables
}
