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
public class Locales {

    private int idLocal;
    private int numeroLocal;
    private int idCategoriap;
    private int idSitioin;

    public Locales() {
    }

    public Locales(int idLocal, int numeroLocal, int idCategoriap, int idSitioin) {
        this.idLocal = idLocal;
        this.numeroLocal = numeroLocal;
        this.idCategoriap = idCategoriap;
        this.idSitioin = idSitioin;
    }

    public int getIdLocal() {
        return idLocal;
    }

    public void setIdLocal(int idLocal) {
        this.idLocal = idLocal;
    }

    public int getNumeroLocal() {
        return numeroLocal;
    }

    public void setNumeroLocal(int numeroLocal) {
        this.numeroLocal = numeroLocal;
    }

    public int getIdCategoriap() {
        return idCategoriap;
    }

    public void setIdCategoriap(int idCategoriap) {
        this.idCategoriap = idCategoriap;
    }

    public int getIdSitioin() {
        return idSitioin;
    }

    public void setIdSitioin(int idSitioin) {
        this.idSitioin = idSitioin;
    }

    @Override
    public String toString() {
        return "Locales{" + "idLocal=" + idLocal + ", numeroLocal=" + numeroLocal + ", idCategoriap=" + idCategoriap + ", idSitioin=" + idSitioin + '}';
    }

}
