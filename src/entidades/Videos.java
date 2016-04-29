/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.awt.Image;
import java.io.InputStream;
import java.util.Date;
import java.util.LinkedList;

/**
 *
 * @author CATV
 */
public class Videos {

    private int idVideo;//PK AUTO INCREMENT
    private String nombreVideo;
    private String descripcionVideo;
    private Date fechaVideo;//DATE
    private InputStream video;
    private int idContenidoMultimediaV;

    public Videos(int idVideo, String nombreVideo, String descripcionVideo, Date fechaVideo, InputStream video, int idContenidoMultimediaV) {
        this.idVideo = idVideo;
        this.nombreVideo = nombreVideo;
        this.descripcionVideo = descripcionVideo;
        this.fechaVideo = fechaVideo;
        this.idContenidoMultimediaV = idContenidoMultimediaV;
        this.video = video;
    }

    public Videos() {

    }

    public int getIdVideo() {
        return idVideo;
    }

    public void setIdVideo(int idVideo) {
        this.idVideo = idVideo;
    }

    public String getNombreVideo() {
        return nombreVideo;
    }

    public void setNombreVideo(String nombreVideo) {
        this.nombreVideo = nombreVideo;
    }

    public String getDescripcionVideo() {
        return descripcionVideo;
    }

    public void setDescripcionVideo(String descripcionVideo) {
        this.descripcionVideo = descripcionVideo;
    }

    public Date getFechaVideo() {
        return fechaVideo;
    }

    public void setFechaVideo(Date fechaVideo) {
        this.fechaVideo = fechaVideo;
    }

    public int getIdContenidoMultimediaV() {
        return idContenidoMultimediaV;
    }

    public void setIdContenidoMultimediaV(int idContenidoMultimediaV) {
        this.idContenidoMultimediaV = idContenidoMultimediaV;
    }

    public InputStream getVideo() {
        return video;
    }

    public void setVideo(InputStream video) {
        this.video = video;
    }

    @Override
    public String toString() {
        return "Videos{" + "idVideo=" + idVideo + ", nombreVideo=" + nombreVideo + ", "
                + "descripcionVideo=" + descripcionVideo + ", fechaVideo=" + fechaVideo + ", "
                + "video=" + video + ", idContenidoMultimediaV=" + idContenidoMultimediaV + '}';
    }

    /**
     * cadena que recibe la base de datos, para inserciones
     *
     * @return String
     */
    public String insert() {
        String insert = "Videos(idVideo,nombreVideo,descripcionVideo,fechaVideo,video,idContenidoMultimediaV) "
                + "values(" + idVideo + "," + nombreVideo + "," + descripcionVideo + "," + fechaVideo + ","
                + video + "," + idContenidoMultimediaV + ")";

        return insert;
    }

    /**
     * cadena que recibe la base de datos, para actualizaciones
     *
     * @return String
     */
    public String update() {

        String update = "Videos SET idVideo=" + idVideo + " nombreVideo=" + nombreVideo + " descripcionVideo="
                + descripcionVideo + " " + "fechaVideo=" + fechaVideo + " " + "video=" + video + " idContenidoMultimediaV="
                + idContenidoMultimediaV + " WHERE idVideo=" + idVideo + "";

        return update;
    }

    /**
     * cadena que recibe la base de datos, para eliminar ocurrencia
     *
     * @return String
     */
    public String delete() {
        String delete = "Videos WHERE idVideo=" + idVideo + "";

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
            this.idVideo = (int) list.get(0);
            this.nombreVideo = (String) list.get(1);
            this.descripcionVideo = (String) list.get(2);
            this.fechaVideo = (Date) list.get(3);
            this.video =  (InputStream) list.get(4);
            this.idContenidoMultimediaV = (int) list.get(4);
        }
    }

    /**
     * cadena que recibe la base de datos, para selecionar una ocurrencia
     *
     * @return String
     */
    public String select() {
        String select = "Videos WHERE idVideo=" + idVideo + "";

        return select;
    }
    
    
    
    
    

}
