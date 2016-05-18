/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import database.BaseDatos;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
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
 * @author Cristian Trujillo
 * @author Juan Camilo Trillos
 * @author Kevin Carrillo
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

    public Imagenes(String nombreImagen, String Descripcion,
            ImageIcon Imagen, int idContenidoMultimediaI) {
        this.nombreImagen = nombreImagen;
        System.out.println("hola");
        this.descripcionImagen = Descripcion;
        this.fechaImagen = Date.valueOf(LocalDate.now());
        this.imagen = Imagen;
        this.idContenidoMultimediaI = idContenidoMultimediaI;
    }

    public Imagenes(int idImagen, String nombreImagen, String descripcionImagen, ImageIcon imagen, int idContenidoMultimediaI) {
        this.idImagen = idImagen;
        this.nombreImagen = nombreImagen;
        this.descripcionImagen = descripcionImagen;
        this.fechaImagen = Date.valueOf(LocalDate.now());
        this.imagen = imagen;
        this.idContenidoMultimediaI = idContenidoMultimediaI;
    }

    public Imagenes(int idContenidoMultimediaI) {
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

        String update = "UPDATE Imagenes SET nombreImagen=?,descripcionImagen=?, fechaImagen=?, "
                + "imagen=?  WHERE idImagen=?";
        return update;
    }

    /**
     * cadena que recibe la base de datos, para eliminar ocurrencia
     *
     * @return String
     */
    public String deleteFK() {
        String delete = "Imagenes WHERE idContenidoMultimediaI=" + idContenidoMultimediaI;

        return delete;
    }

    /**
     * cadena que recibe la base de datos, para eliminar ocurrencia
     *
     * @return String
     */
    public String delete() {
        String delete = "Imagenes WHERE idImagen=" + idImagen;

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
            this.fechaImagen = Date.valueOf((String) list.get(3));
            this.idContenidoMultimediaI = (int) list.get(5);
//            this.imagen = (ImageIcon) list.get(4);
            BaseDatos db = new BaseDatos();
            if (db.crearConexion()) {
                this.imagen = db.selectImage("SELECT * FROM imagenes WHERE idimagen=" + this.getIdImagen());
            }
        }
    }

    /**
     * cadena que recibe la base de datos, para selecionar una ocurrencia
     *
     * @return String
     */
    public String select() {
        String select = "SELECT * FROM Imagenes WHERE idImagen=" + idImagen + "";

        return select;
    }

    public String selectFK() {
        String select = "SELECT * FROM Imagenes WHERE idContenidoMultimediaI=" + idContenidoMultimediaI + "";

        return select;
    }

    /**
     * Metodo Static que busca las imagenes en el PC con un JFileChooser
     * 
     * @return 
     */
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
