/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

//import java.util.Date;
import java.sql.Date;
import java.util.LinkedList;

/**
 *
 * @author CATV
 */
public class Registro_Visitas {

    private int codigoVisita;// AUTO INCREMENT
    private Date fechaVisita;
    private int idSitios;//FK SITIOS_INTERES
    private String correoCuentas;//FK CUENTAS

    public Registro_Visitas() {

    }

    public Registro_Visitas(/*int codigoVisita,*/Date fechaVisita, int idSitios, String correoCuentas) {
//        this.codigoVisita = codigoVisita;
        this.fechaVisita = fechaVisita;
        this.idSitios = idSitios;
        this.correoCuentas = correoCuentas;
    }

    public Registro_Visitas(int idSitios) {
        this.idSitios = idSitios;
    }
    
    

    public int getCodigoVisita() {
        return codigoVisita;
    }

    public void setCodigoVisita(int codigoVisita) {
        this.codigoVisita = codigoVisita;
    }

    public Date getFechaVisita() {
        return fechaVisita;
    }

    public void setFechaVisita(Date fechaVisita) {
        this.fechaVisita = fechaVisita;
    }

    public int getIdSitios() {
        return idSitios;
    }

    public void setIdSitios(int idSitios) {
        this.idSitios = idSitios;
    }

    public String getCorreoCuentas() {
        return correoCuentas;
    }

    public void setCorreoCuentas(String correoCuentas) {
        this.correoCuentas = correoCuentas;
    }

    @Override
    public String toString() {
        return "Registros_Visitas{" + "codigoVisita=" + codigoVisita + ", fechaVisita=" + fechaVisita + ", idSitios=" + idSitios + ", correoCuentas=" + correoCuentas + '}';
    }

    /**
     * cadena que recibe la base de datos, para inserciones
     *
     * @return String
     */
    public String insert() {
        String insert = "Registros_Visitas(fechaVisita,idSitios,correoCuentas) "
                + "values('" + fechaVisita + "'," + idSitios + ",'" + correoCuentas + "')";
        return insert;
    }

    /**
     * cadena que recibe la base de datos, para actualizaciones
     *
     * @return String
     */
    public String update() {
        String update = "Registros_Visitas SET fechaVisita=" + fechaVisita + " idSitios="
                + idSitios + " " + "correoCuenta='" + correoCuentas + "' WHERE codigoVisita=" + codigoVisita + "";

        return update;
    }

    /**
     * cadena que recibe la base de datos, para eliminar ocurrencia
     *
     * @return String
     */
    public String delete() {
        String delete = "Registros_Visitas WHERE idSitios=" + idSitios;

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
            this.codigoVisita = (int) list.get(0);
            this.fechaVisita = (Date) list.get(1);
            this.idSitios = (int) list.get(2);
            this.correoCuentas = (String) list.get(3);
        }
    }

    /**
     * cadena que recibe la base de datos, para selecionar una ocurrencia
     *
     * @return String
     */
    public String select() {
        String select = "SELECT * FROM Registros_Visitas WHERE idSitios=" + idSitios + "";

        return select;
    }

}
