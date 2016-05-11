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
public class Comentario {
    
    private int idComentario;
    private String textComentario;
    private int idSitioComent;

    /**
     * Creates new form Comentario
     */
    public Comentario() {
        
    }

    public Comentario(String textComentario, int idSitioComent) {
        this.textComentario = textComentario;
        this.idSitioComent = idSitioComent;
    }

    public Comentario(int idSitioComent) {
        this.idSitioComent = idSitioComent;
    }

    public int getIdComentario() {
        return idComentario;
    }

    public void setIdComentario(int idComentario) {
        this.idComentario = idComentario;
    }

    public String getTexto() {
        return textComentario;
    }

    public void setTexto(String textComentario) {
        this.textComentario = textComentario;
    }

    public int getIdSitioComent() {
        return idSitioComent;
    }

    public void setIdSitioComent(int idSitioComent) {
        this.idSitioComent = idSitioComent;
    }

    

    @Override
    public String toString() {
        return "Comentario{" + "idComentario=" + idComentario + ", textComentario=" + textComentario + ", idSitioComent=" + idSitioComent + '}';
    }

      /**
     * lista que se recibe de la base de datos, para obtener los datos de la
     * ocurrencia
     *
     * @param list
     */
    public void read(LinkedList list) {
        if (!list.isEmpty()) {
            this.idComentario = (Integer) list.get(0);
            this.textComentario = (String) list.get(1);
            this.idSitioComent = (Integer) list.get(2);

        }
    }

    /**
     * cadena que recibe la base de datos, para selecionar una ocurrencia
     *
     * @return String
     */
    public String select() {
        String select = "SELECT * FROM comentarios WHERE idComentario="  + idComentario;
        return select;
    }

    /**
     * cadena que recibe la base de datos, para selecionar una ocurrencia
     *
     * @return String
     */
    public String selectFK() {
        String select = "SELECT * FROM comentarios WHERE idSitioComent="  + idSitioComent;
        return select;
    }
    
    /**
     * cadena que recibe la base de datos, para inserciones
     *
     * @return String
     */
    public String insert() {
        String insert = "SELECT * FROM comentarios(textComentario,idSitioComent) "
                + "values(" + "\"" + textComentario + "\"" + ","  + idSitioComent  + ")";
        return insert;
    }
}
