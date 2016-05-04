/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author CATV
 */
public class Imagenes {

    private int idImagen;//PK AUTO INCREMENT
    private String nombreImagen;
    private String descripcionImagen;
    private Date fechaImagen;//DATE
    private ImageIcon imagen;
    private int idContenidoMultimediaI;

    public Imagenes() {

    }

    public Imagenes(/*int idImagen, */String nombreImagen, String Descripcion,
            /*Date Fecha,*/ ImageIcon Imagen, int idContenidoMultimediaI) {
//        this.idImagen = idImagen;
        this.nombreImagen = nombreImagen;
        System.out.println("hola");
        this.descripcionImagen = Descripcion;
        this.fechaImagen = Date.valueOf(LocalDate.now());
        this.imagen = Imagen;
        this.idContenidoMultimediaI = idContenidoMultimediaI;
    }

    public int getIdImagen() {
        return idImagen;
    }

    public void setIdImagen(int idImagen) {
        this.idImagen = idImagen;
    }

    public String getNombreImagen() {
        return nombreImagen;
    }

    public void setNombreImagen(String nombreImagen) {
        this.nombreImagen = nombreImagen;
    }

    public String getDescripcionImagen() {
        return descripcionImagen;
    }

    public void setDescripcionImagen(String descripcionImagen) {
        this.descripcionImagen = descripcionImagen;
    }

    public Date getFechaImagen() {
        return fechaImagen;
    }

    public void setFechaImagen(Date fechaImagen) {
        this.fechaImagen = fechaImagen;
    }

    public ImageIcon getImagen() {
        return imagen;
    }

    public void setImagen(ImageIcon imagen) {
        this.imagen = imagen;
    }

    public int getIdContenidoMultimediaI() {
        return idContenidoMultimediaI;
    }

    public void setIdContenidoMultimediaI(int idContenidoMultimediaI) {
        this.idContenidoMultimediaI = idContenidoMultimediaI;
    }

    @Override
    public String toString() {
        return "Imagenes{" + "idImagen=" + idImagen + ", nombreImagen=" + nombreImagen + ", "
                + "descripcionImagen=" + descripcionImagen + ", fechaImagen=" + fechaImagen + ", "
                + "imagen=" + imagen + ", idContenidoMultimediaI=" + idContenidoMultimediaI + '}';
    }

    public ArrayList<Image> getImagenes() throws IOException {
        ArrayList<Image> lista = new ArrayList();
        // try {
        // ResultSet rs = st.executeQuery("SELECT imagen,nombre FROM Imagenes");
        // while (rs.next()) {
        //  Blob blob = rs.getBlob("imagen");
        //String nombre = rs.getObject("nombre").toString();
        //byte[] data = blob.getBytes(1, (int) blob.length());
        //BufferedImage img = null;
        // try {
        //      img = ImageIO.read(new ByteArrayInputStream(data));
        // } catch (IOException ex) {
        //   Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        //}

        //imagen.setImagen(img);
        //imagen.setNombre(nombre);
        //    lista.add( new ImageIcon("/Users/CATV/NetBeansProjects/ProyectoFINAl/src/Fotos/Sariska-Palace.jpg"));
        lista.add(ImageIO.read(new File("src/Fotos/Sariska-Palace.jpg")));
        lista.add(ImageIO.read(new File("src/Fotos/59513efc2ec00974d17049f6ba86bdf3.jpg")));
        lista.add(ImageIO.read(new File("src/Fotos/alberca1.jpg")));
        lista.add(ImageIO.read(new File("src/Fotos/cancha-juegos.jpg")));
        lista.add(ImageIO.read(new File("src/Fotos/entrada_principal.jpg")));
        lista.add(ImageIO.read(new File("src/Fotos/hotel-restinn-estado-mexico-entrada.jpg")));

        //  }
//            rs.close();
//        } catch (SQLException ex) {
//            Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE, null, ex);
//        }
        return lista;
    }

    /**
     * cadena que recibe la base de datos, para inserciones
     *
     * @return String
     */
    public String insert() {
        String insert = "INSERT INTO Imagenes(nombreImagen,descripcionImagen,fechaImagen,"
                + "imagen,idContenidoMultimediaI) values(?,?,?,?,?)";

        return insert;
    }

    /**
     * cadena que recibe la base de datos, para actualizaciones
     *
     * @return String
     */
    public String update() {

        String update = "UPDATE Imagenes SET idImagen=? nombreImagen=? descripcionImagen=? fechaImagen=? "
                + "imagen=? idContenidoMultimediaI=? WHERE idImagen=?";

        return update;
    }

    /**
     * cadena que recibe la base de datos, para eliminar ocurrencia
     *
     * @return String
     */
    public String delete() {
        String delete = "Imagenes WHERE idImagen=" + idImagen + "";

        return delete;
    }

    /**
     * lista que se recibe de la base de datos, para obtener los datos de la
     * ocurrencia
     *
     * @param list
     */
    public void read(LinkedList list) {
        if (!list.isEmpty()) {
            this.idImagen = (int) list.get(0);
            this.nombreImagen = (String) list.get(1);
            this.descripcionImagen = (String) list.get(2);
            this.fechaImagen = (Date) list.get(3);
            this.imagen = (ImageIcon) list.get(4);
            this.idContenidoMultimediaI = (int) list.get(4);
        }
    }

    /**
     * cadena que recibe la base de datos, para selecionar una ocurrencia
     *
     * @return String
     */
    public String select() {
        String select = "Imagenes WHERE idImagen=" + idImagen + "";

        return select;
    }

    static public ImageIcon cargarArchivos() {
        JFrame obj = new JFrame();
        BufferedImage buffered;
        ImageIcon image = new ImageIcon();
//        obj.setIconImage(new ImageIcon(getClass().getResource("/imagenes/Icons/32.png")).getImage());

        String ruta = "";
        File files = null;
        JFileChooser chooserTemp = new JFileChooser();
        chooserTemp.setMultiSelectionEnabled(true);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG file", "PNG file", "jpg", "png");

        chooserTemp.setFileFilter(filter);
        int returnVal = chooserTemp.showOpenDialog(obj);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            try {
                files = chooserTemp.getSelectedFile();
                buffered = ImageIO.read(files);
                image.setImage(buffered);
                //System.out.println("nombre archivo seleccionado "+files[0].getName());
            } catch (IOException ex) {
                Logger.getLogger(Imagenes.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return image;//.getAbsolutePath().toString();
    }

}
