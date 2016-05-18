/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.util.LinkedList;

/**
 *
 * @author CATV
 */
public class Sitios_Interes {

    private int idSitio;//PK AUTO_INCREMENT
    private String Nombre;
    private String Direccion;
    private int Calificacion;// dominio
    private String Reseña;
    private String Horario;
    private String infoAdicional;
    private int Categoria;

    public Sitios_Interes() {
        
    }

    public Sitios_Interes(int idSitio) {
        this.idSitio = idSitio;
    }

    public Sitios_Interes(int idSitio, String Nombre, String Direccion, int Calificacion, String Reseña, String Horario, String infoAdicional, int Categoria) {
        this.idSitio = idSitio;
        this.Nombre = Nombre;
        this.Direccion = Direccion;
        this.Calificacion = Calificacion;
        this.Reseña = Reseña;
        this.Horario = Horario;
        this.infoAdicional = infoAdicional;
        this.Categoria = Categoria;
    }

    public Sitios_Interes(String Nombre, String Direccion, int Calificacion, String Reseña, String Horario, String infoAdicional, int Categoria) {
        this.Nombre = Nombre;
        this.Direccion = Direccion;
        this.Calificacion = Calificacion;
        this.Reseña = Reseña;
        this.Horario = Horario;
        this.infoAdicional = infoAdicional;
        this.Categoria = Categoria;
    }

   

    public int getIdSitio() {
        return idSitio;
    }

    public void setIdSitio(int idSitio) {
        this.idSitio = idSitio;
    }

    public String getReseña() {
        return Reseña;
    }

    public void setReseña(String Reseña) {
        this.Reseña = Reseña;
    }

    public String getInfoAdicional() {
        return infoAdicional;
    }

    public void setInfoAdicional(String infoAdicional) {
        this.infoAdicional = infoAdicional;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public int getCalificacion() {
        return Calificacion;
    }

    public void setCalificacion(int Calificacion) {
        this.Calificacion = Calificacion;
    }

    public String getHorario() {
        return Horario;
    }

    public void setHorario(String Horario) {
        this.Horario = Horario;
    }

    public int getCategoria() {
        return Categoria;
    }

    public void setCategoria(int Categoria) {
        this.Categoria = Categoria;
    }

    @Override
    public String toString() {
        return "Sitios_Interes{" + "idSitio=" + idSitio + ", Nombre=" + Nombre + ", Direccion=" + Direccion + ", Calificacion=" + Calificacion + ", Rese\u00f1a=" + Reseña + ", Horario=" + Horario + ", infoAdicional=" + infoAdicional + ", Categoria=" + Categoria + '}';
    }

    /**
     * cadena que recibe la base de datos, para inserciones
     *
     * @return String
     */
    public String insert() {
        String insert = "Sitios_Interes(nombreSitio,direccionSitio,calificacionSitio,reseñaSitio,horarioSitio,infoAdicionalSitio"
                + ",idCategoriaS) values(" + "\"" + Nombre + "\""
                + "," + "\"" + Direccion + "\""
                + "," + Calificacion
                + "," + "\"" + Reseña + "\""
                + "," + "\"" + Horario + "\""
                + "," + "\"" + infoAdicional + "\""
                + "," + Categoria
                + ")";

        return insert;
    }

    /**
     * cadena que recibe la base de datos, para actualizaciones
     *
     * @return String
     */
    public String update() {
        String update = "Sitios_Interes SET "
                + " nombreSitio=" + "\"" + Nombre + "\""
                + ",direccionSitio=" + "\"" + Direccion + "\""
                + ",calificacionSitio=" + Calificacion
                + ",reseñaSitio=" + "\"" + Reseña + "\""
                + ",horarioSitio=" + "\"" + Horario + "\""
                + ",infoAdicionalSitio=" + "\"" + infoAdicional + "\""
                + " WHERE idSitio=" + idSitio;

        return update;
    }

    /**
     * cadena que recibe la base de datos, para eliminar ocurrencia
     *
     * @return String
     */
    public String delete() {
        String delete = "Sitios_Interes WHERE idSitio=" + "\"" + idSitio + "\"";

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
            this.idSitio = (int) list.get(0);
            this.Nombre = (String) list.get(1);
            this.Direccion = (String) list.get(2);
            this.Calificacion = (int) list.get(3);
            this.Reseña = (String) list.get(4);
            this.Horario = (String) list.get(5);
            this.infoAdicional = (String) list.get(6);
            this.Categoria = (int) list.get(7);
        }
    }

    /**
     * cadena que recibe la base de datos, para selecionar una ocurrencia
     *
     * @return String
     */
    public String select() {
        String select = "Sitios_Interes WHERE idSitio=" + "\"" + idSitio + "\"" + "";

        return select;
    }

}
