/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.util.LinkedList;
import java.security.MessageDigest;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;

/**
 *
 * @author Cristian Trujillo 
 * @author Juan Camilo Trillos 
 * @author Kevin Carrillo
 */
public class Cuentas {

    private String correoCuenta;
    private String passwordCuenta;
    private String nombreCuenta;
    private String apellidoCuenta;
    private String celularCuenta;

    public Cuentas() {

    }

    public Cuentas(String Correo, String Password, String Nombre, String Apellido, String Celular) {
        this.correoCuenta = Correo;
        this.passwordCuenta = Password;
        this.nombreCuenta = Nombre;
        this.apellidoCuenta = Apellido;
        this.celularCuenta = Celular;
    }

    public Cuentas(String Correo, String Contraseña) {
        this.correoCuenta = Correo;
        passwordCuenta = Contraseña;
    }

    public Cuentas(String Correo) {
        this.correoCuenta = Correo;
    }

    public String getCorreo() {
        return correoCuenta;
    }

    public void setCorreo(String Correo) {
        this.correoCuenta = Correo;
    }

    public String getPassword() {
        return passwordCuenta;
    }

    public void setPassword(String Password) {
        this.passwordCuenta = Password;
    }

    public String getNombre() {
        return nombreCuenta;
    }

    public void setNombre(String Nombre) {
        this.nombreCuenta = Nombre;
    }

    public String getCelular() {
        return celularCuenta;
    }

    public void setCelular(String Celular) {
        this.celularCuenta = Celular;
    }

    public String getApellido() {
        return apellidoCuenta;
    }

    public void setApellido(String Apellido) {
        this.apellidoCuenta = Apellido;
    }

    @Override
    public String toString() {
        return "Cuentas{" + "correoCuenta=" + correoCuenta + ", passwordCuenta=" + passwordCuenta + ", nombreCuenta=" + nombreCuenta + ", apellidoCuenta=" + apellidoCuenta + ", celularCuenta=" + celularCuenta + '}';
    }

    /**
     * cadena que recibe la base de datos, para inserciones
     *
     * @return String
     */
    public String insert() {
        String insert = "Cuentas(correoCuenta,passwordCuenta,nombreCuenta,apellidoCuenta,celularCuenta) "
                + "values(" + "\"" + correoCuenta + "\"" + "," + "\"" + passwordCuenta + "\"" + "," + "\"" + nombreCuenta + "\"" + "," + "\"" + apellidoCuenta + "\"" + "," + "\"" + celularCuenta + "\"" + ")";
        return insert;
    }

    /**
     * cadena que recibe la base de datos, para actualizaciones
     *
     * @return String
     */
    public String update() {
        String update = "Cuentas SET "
                        + "nombreCuenta=" + "\"" + nombreCuenta + "\"" + ","
                        + "apellidoCuenta=" + "\"" + apellidoCuenta + "\"" + ","
                        + "celularCuenta=" + "\"" + celularCuenta + "\""
                        + "WHERE correoCuenta=" + "\"" + correoCuenta + "\"";
              

        return update;
    }

    /**
     * cadena que recibe la base de datos, para eliminar ocurrencia
     *
     * @return String
     */
    public String delete() {
        String delete = "Cuentas WHERE correoCuenta=" + "\"" + correoCuenta + "\"" + "";

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
            this.correoCuenta = (String) list.get(0);
            this.passwordCuenta = (String) list.get(1);
            this.nombreCuenta = (String) list.get(2);
            this.apellidoCuenta = (String) list.get(3);
            this.celularCuenta = (String) list.get(4);
        }
    }

    /**
     * cadena que recibe la base de datos, para selecionar una ocurrencia
     *
     * @return String
     */
    public String select() {
        String select = "SELECT * FROM Cuentas WHERE correoCuenta=" + "\"" + correoCuenta + "\"";

        return select;
    }

    public static String Encriptar(String texto) {

        String secretKey = "qualityinfosolutions"; //llave para encriptar datos
        String base64EncryptedString = "";

        try {

            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digestOfPassword = md.digest(secretKey.getBytes("utf-8"));
            byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);

            SecretKey key = new SecretKeySpec(keyBytes, "DESede");
            Cipher cipher = Cipher.getInstance("DESede");
            cipher.init(Cipher.ENCRYPT_MODE, key);

            byte[] plainTextBytes = texto.getBytes("utf-8");
            byte[] buf = cipher.doFinal(plainTextBytes);
            byte[] base64Bytes = Base64.encodeBase64(buf);
            base64EncryptedString = new String(base64Bytes);

        } catch (Exception ex) {
        }
        return base64EncryptedString;
    }

    public static String Desencriptar(String textoEncriptado) throws Exception {

        String secretKey = "qualityinfosolutions"; //llave para encriptar datos
        String base64EncryptedString = "";

        try {
            byte[] message = Base64.decodeBase64(textoEncriptado.getBytes("utf-8"));
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digestOfPassword = md.digest(secretKey.getBytes("utf-8"));
            byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);
            SecretKey key = new SecretKeySpec(keyBytes, "DESede");

            Cipher decipher = Cipher.getInstance("DESede");
            decipher.init(Cipher.DECRYPT_MODE, key);

            byte[] plainText = decipher.doFinal(message);

            base64EncryptedString = new String(plainText, "UTF-8");

        } catch (Exception ex) {
        }
        return base64EncryptedString;
    }

}
