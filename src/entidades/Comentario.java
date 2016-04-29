/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author CATV
 */
public class Comentario {
    
    private int idComentario;
    private String texto;

    /**
     * Creates new form Comentario
     */
    public Comentario() {
        
    }


    public Comentario(int idComentario, String texto) {
        this.idComentario = idComentario;
        this.texto = texto;
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
        return "Comentarios{" + "idComentario=" + idComentario + ", texto=" + texto + '}';
    }
}
