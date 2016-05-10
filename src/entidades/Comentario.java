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
    private String texto;
    private int idSitioComent;

    /**
     * Creates new form Comentario
     */
    public Comentario() {
        
    }


    public Comentario(int idComentario, String texto) {
        this.idComentario = idComentario;
        this.texto = texto;
    }

    public Comentario(int idComentario) {
        this.idComentario = idComentario;
    }

    public int getIdSitioComent() {
        return idSitioComent;
    }

    public void setIdSitioComent(int idSitioComent) {
        this.idSitioComent = idSitioComent;
    }
    
    

    public int getIdComentario() {
        return idComentario;
    }

    public void setIdComentario(int idComentario) {
        this.idComentario = idComentario;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    @Override
    public String toString() {
        return "Comentario{" + "idComentario=" + idComentario + ", texto=" + texto + ", idSitioComent=" + idSitioComent + '}';
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
            this.texto = (String) list.get(1);
            this.idSitioComent = (Integer) list.get(2);

        }
    }

    /**
     * cadena que recibe la base de datos, para selecionar una ocurrencia
     *
     * @return String
     */
    public String select() {
        String select = "comentarios WHERE idSitioComent=" + "\"" + idSitioComent + "\"";

        return select;

    }
}
