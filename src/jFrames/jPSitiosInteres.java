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
import entidades.Sitios_Interes;
import java.util.LinkedList;
import javax.swing.JOptionPane;

/**
 *
 * @author CATV
 */
public class jPSitiosInteres extends javax.swing.JPanel {

    LinkedList<Sitios_Interes> sitios;
    LinkedList<Imagenes> imagen;
    LinkedList<Comentario> coment;
    private int pos = 0;
    private int posC = 0;
    Ventana ven;

    public jPSitiosInteres(String caso, Ventana ven) {
        initComponents();
        sitios = new LinkedList<>();
        imagen = new LinkedList<>();
        coment = new LinkedList<>();
        ObtenerInfo(caso);
        this.ven = ven;
        JComentario.setEnabled(false);

    }

    public void ObtenerInfo(String caso) {

        BaseDatos db = new BaseDatos();
        String select = "SELECT sitios_interes.* FROM ";
        LinkedList<Object> listHotel;
        String sql = select + "categorias, sitios_interes "
                + "WHERE idCategoria=idCategoriaS and nombreCategoria='" + caso + "'";

        System.out.println(sql);
        if (db.crearConexion()) {
            LinkedList<Object> list = db.readM(sql);
            int size = list.size();
            int cant = size / 8;

            System.out.println("cantidad :" + cant);
            for (int i = 0; i < cant; i++) {
                listHotel = new LinkedList<>();
                for (int j = 0; j < 8; j++) {
                    if (!list.isEmpty()) {
                        listHotel.add(list.removeFirst());
                    }
                }
                Sitios_Interes hotel = new Sitios_Interes();
                hotel.read(listHotel);
                sitios.add(hotel);
            }

            Contenidos_Multimedia cont = new Contenidos_Multimedia(sitios.get(pos).getIdSitio());
            LinkedList<Object> listContenido = db.read(cont.selectFK());
            if (!listContenido.isEmpty()) {
                cont.read(list);

                Imagenes img = new Imagenes(cont.getIdContenido());
                LinkedList<Object> listImagen = db.read(cont.selectFK());
                if (!listImagen.isEmpty()) {
                    img.read(list);
                    imagen.add(img);

                } else {
                    System.out.println("Error al buscar imagen");
                }

            } else {
                System.out.println("Error al buscar Contenido_multimedia");
            }

        }
        despliege();
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
        JDir = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        JCalificacion = new javax.swing.JLabel();
        JComentario = new javax.swing.JTextArea();
        JAdd = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jNext = new javax.swing.JButton();
        jNext1 = new javax.swing.JButton();

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

        JReseña.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N

        JNombre.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N

        JHorario.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N

        jLabel6.setText("Reseña");

        JDir.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N

        jLabel4.setText("Calificacion");

        JCalificacion.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N

        JComentario.setEditable(false);
        JComentario.setColumns(20);
        JComentario.setRows(5);
        JComentario.setBorder(null);
        JComentario.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        JAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/circle.png"))); // NOI18N
        JAdd.setPreferredSize(new java.awt.Dimension(32, 32));
        JAdd.setSize(new java.awt.Dimension(32, 32));
        JAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JAddActionPerformed(evt);
            }
        });

        jLabel1.setText("Comentario");

        jNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/Next.png"))); // NOI18N
        jNext.setPreferredSize(new java.awt.Dimension(32, 32));
        jNext.setSize(new java.awt.Dimension(32, 32));
        jNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jNextActionPerformed(evt);
            }
        });

        jNext1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/NextI.png"))); // NOI18N
        jNext1.setPreferredSize(new java.awt.Dimension(32, 32));
        jNext1.setSize(new java.awt.Dimension(32, 32));
        jNext1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jNext1ActionPerformed(evt);
            }
        });

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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(45, 45, 45)
                                .addComponent(JHorario, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JComentario, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(JAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jNext, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jNext1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(80, 80, 80)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(14, 14, 14)
                        .addComponent(JReseña, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
                            .addComponent(JReseña, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JCalificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(50, 50, 50))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(JDir, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(JHorario, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jLabel1)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(JComentario)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(JAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jNext, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jNext1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())))))
        );
    }// </editor-fold>//GEN-END:initComponents

    public void Comentario() {
        Comentario comentario = new Comentario(sitios.get(pos).getIdSitio());
        BaseDatos base = new BaseDatos();
        LinkedList<Object> list = new LinkedList<>();

        System.out.println(comentario.toString());

        if (base.crearConexion()) {
            list = base.read(comentario.select());
            Comentario comtemp = new Comentario();
            comtemp.read(list);
            coment.add(comtemp);
            System.out.println(coment.toString());
            System.out.println("Entre");
        }

    }

    public void despliege() {
        Comentario();

        JNombre.setText(sitios.get(pos).getNombre());
        JDir.setText(sitios.get(pos).getDireccion());
        JReseña.setText(sitios.get(pos).getReseña());
        JCalificacion.setText(Integer.toString(sitios.get(pos).getCalificacion()));
        JHorario.setText(sitios.get(pos).getHorario());
        JFondo.setIcon(imagen.get(pos).getImagen());

        if (coment.get(pos).getTexto() == "") {

            JComentario.setText("");
            System.out.println("No tengo nada");

        } else {
            JComentario.setText(coment.get(pos).getTexto());

        }

//        //Comentario
//        jPComentario com = new jPComentario();
//        this.PComentatio.add(com);
//        Imagenes img = new Imagenes();
//        ArrayList<Image> lista = null;
//        try {
//            lista = img.getImagenes();
//        } catch (IOException ex) {
//            Logger.getLogger(jPSitiosInteres.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        JFondo.setIcon(new ImageIcon(lista.get(0)));
    }

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
            pos = 0;
        }
        despliege();
    }//GEN-LAST:event_BtIActionPerformed

    private void JAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JAddActionPerformed

        String add = JOptionPane.showInputDialog("Mensaje");

        System.out.println("Mensaje :" + add);

        BaseDatos base = new BaseDatos();

        if (base.crearConexion()) {
            Comentario com = new Comentario(add, sitios.get(pos).getIdSitio());
            boolean insert = base.insert(com.insert());

            if (insert) {
                JOptionPane.showMessageDialog(null, "Comentario add");
                despliege();
            }
        }


    }//GEN-LAST:event_JAddActionPerformed

    private void jNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jNextActionPerformed

        posC++;

        if (posC >= sitios.size()) {
            posC = 0;
        }

        JComentario.setText(coment.get(posC).getTexto());

        System.out.println(coment.get(posC).getTexto());

        System.out.println(posC);

    }//GEN-LAST:event_jNextActionPerformed

    private void jNext1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jNext1ActionPerformed
        // TODO add your handling code here:
        posC--;

        if (posC < 0) {
            posC = 0;
        }
        System.out.println(posC);

        JComentario.setText(coment.get(posC).getTexto());

        System.out.println(coment.get(posC).getTexto());


    }//GEN-LAST:event_jNext1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtD;
    private javax.swing.JButton BtI;
    private javax.swing.JButton JAdd;
    private javax.swing.JLabel JCalificacion;
    private javax.swing.JTextArea JComentario;
    private javax.swing.JLabel JDir;
    private javax.swing.JLabel JFondo;
    private javax.swing.JLabel JHorario;
    private javax.swing.JLabel JNombre;
    private javax.swing.JLabel JReseña;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JButton jNext;
    private javax.swing.JButton jNext1;
    // End of variables declaration//GEN-END:variables
}
