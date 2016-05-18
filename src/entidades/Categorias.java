/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.util.LinkedList;

/**
 *
 * @author Cristian Trujillo
 * @author Juan Camilo Trillos
 * @author Kevin Carrillo
 */
public class Categorias {

    private int idCategoria;
    private String nombreCategoria;

    public Categorias() {
    }

    public Categorias(int idCategoria, String nombreCategoria) {
        this.idCategoria = idCategoria;
        this.nombreCategoria = nombreCategoria;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    @Override
    public String toString() {
        return "Categorias{" + "idCategoria=" + idCategoria + ", nombreCategoria=" + nombreCategoria + '}';
    }

    /**
     * cadena que recibe la base de datos, para inserciones
     *
     * @return String
     */
    public String insert() {
        String insert = "Categorias(idCategoria,nombreCategoria) "
                + "values(" + idCategoria + ",'" + nombreCategoria + "')";
        return insert;
    }

    /**
     * cadena que recibe la base de datos, para actualizaciones
     *
     * @return String
     */
    public String update() {
        String update = "Categorias SET "
                + "nombreCategoria='" + nombreCategoria + "' "
                + "WHERE idCategoria=" + idCategoria + "";

        return update;
    }

    /**
     * cadena que recibe la base de datos, para eliminar ocurrencia
     *
     * @return String
     */
    public String delete() {
        String delete = "Categorias WHERE idCategoria=" + idCategoria + "";

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
            this.idCategoria = (int) list.get(0);
            this.nombreCategoria = (String) list.get(1);
        }
    }

    /**
     * cadena que recibe la base de datos, para selecionar una ocurrencia
     *
     * @return String
     */
    public String select() {
        String select = "SELECT * FROM Categorias WHERE idCategoria=" + idCategoria + "";

        return select;
    }
}
