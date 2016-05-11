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
public class Contenidos_Multimedia {

    private int idContenido;//PK AUTO INCREMENT
    private int idSitiosC;//FK SITIO
    private String correoCuentasC;//FK CUENTA

    public Contenidos_Multimedia(int idContenido, int idSitiosC, String correoCuentasC) {
        this.idContenido = idContenido;
        this.idSitiosC = idSitiosC;
        this.correoCuentasC = correoCuentasC;
    }

    public Contenidos_Multimedia(int idSitiosC, String correoCuentasC) {
        this.idSitiosC = idSitiosC;
        this.correoCuentasC = correoCuentasC;
    }
    
    public Contenidos_Multimedia() {

    }

    public int getIdContenido() {
        return idContenido;
    }

    public void setIdContenido(int idContenido) {
        this.idContenido = idContenido;
    }

    public int getIdSitiosC() {
        return idSitiosC;
    }

    public void setIdSitiosC(int idSitiosC) {
        this.idSitiosC = idSitiosC;
    }

    public String getCorreoCuentasC() {
        return correoCuentasC;
    }

    public void setCorreoCuentasC(String correoCuentasC) {
        this.correoCuentasC = correoCuentasC;
    }

    @Override
    public String toString() {
        return "Contenidos_Multimedia{" + "idContenido=" + idContenido + ", idSitiosC=" + idSitiosC + ", "
                + "correoCuentasC=" + correoCuentasC + '}';
    }

    /**
     * cadena que recibe la base de datos, para inserciones
     *
     * @return String
     */
    public String insert() {
        String insert = "Contenidos_Multimedia(idSitiosc,correoCuentasC) "
                + "values(" + idSitiosC + "," + "\"" + correoCuentasC + "\"" + ")";

        return insert;
    }

    /**
     * cadena que recibe la base de datos, para actualizaciones
     *
     * @return String
     */
    public String update() {
        String update = "Contenidos_Multimedia SET idContenido=" + idContenido + " idSitiosC=" + idSitiosC + " "
                + "correoCuentasC=" + correoCuentasC + " WHERE idContenido=" + idContenido + "";

        return update;
    }

    /**
     * cadena que recibe la base de datos, para eliminar ocurrencia
     *
     * @return String
     */
    public String delete() {
        String delete = "Contenidos_Multimedia WHERE idContenido=" + idContenido + "";

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
            System.out.println("conte List 0: "+list.get(0));
            this.idContenido = (int) list.get(0);
            this.idSitiosC = (int) list.get(1);
            this.correoCuentasC = (String) list.get(2);
        }
    }

    /**
     * cadena que recibe la base de datos, para selecionar una ocurrencia
     *
     * @return String
     */
    public String select() {
        String select = "SELECT * FROM Contenidos_Multimedia WHERE idContenido=" + idContenido + "";

        return select;
    }

    /**
     * cadena que recibe la base de datos, para selecionar una ocurrencia
     *
     * @return String
     */
    public String selectFK() {
        String select = "SELECT * FROM Contenidos_Multimedia WHERE idSitiosC=" + idSitiosC + "";

        return select;
    }

}
