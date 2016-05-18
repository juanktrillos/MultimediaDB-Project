package database;

/**
 *
 * @author Alejo  {Profesor}
 * 
 * @author Cristian Trujillo 
 * @author Juan Camilo Trillos 
 * @author Kevin Carrillo
 */
import entidades.Imagenes;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class BaseDatos {

    /**
     * Método utilizado para recuperar el valor del atributo conexion
     *
     * @return conexion contiene el estado de la conexión
     *
     */
    Connection conexion;
    Statement st;

    public BaseDatos() {
        //conexion
    }

    public Connection getConexion() {
        return conexion;
    }

    /**
     * Método utilizado para establecer la conexión con la base de datos
     *
     * @return estado regresa el estado de la conexión, true si se estableció la
     * conexión, falso en caso contrario
     */
    public boolean crearConexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");                         //database   //user  //pass
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/projectturism2016", "root", "anis1002");
            st = conexion.createStatement();
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     *
     * Método utilizado para realizar las instrucciones: INSERT, DELETE y UPDATE
     *
     * @param sql Cadena que contiene la instrucción SQL a ejecutar
     * @return estado regresa el estado de la ejecución, true(éxito) o
     * false(error)
     *
     */
    public boolean querySQL(String sql) {
        try {
            Statement sentencia = conexion.createStatement();
            sentencia.executeUpdate(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * Metodo General de Inserciones en la base de datos
     * 
     * @param consulta
     * @return 
     */
    public boolean insert(String consulta) {

        String sql = "INSERT INTO " + consulta;
        boolean insert = querySQL(sql);
        return insert;
    }

    /**
     * Metodo General de Actualizaciones en la base de datos
     * @param consulta
     * @return 
     */
    public boolean update(String consulta) {

        String sql = "UPDATE " + consulta;
        boolean update = querySQL(sql);
        return update;
    }

    /**
     * Metodo General de Eliminacion de ocurrencias en la base de datos
     * @param consulta
     * @return 
     */
    public boolean delete(String consulta) {

        String sql = "DELETE FROM " + consulta;
        boolean update = querySQL(sql);

        return update;
    }
    
    /**
     * metodo general de seleccion de las tablas en la base de datos
     * 
     * @param sql
     * @return devuelve los valores en una lista, no las ocurrencias 
     *          ejm: 2 ocurrencias de 5 atributos, la lista tiene 10 valores
     */
    public LinkedList<Object> select(String sql) {

        LinkedList<Object> obj = new LinkedList();
        int contador = 1;

        try {
            ResultSet rs = st.executeQuery(sql);
            ResultSetMetaData rsm = rs.getMetaData();
            int numColumn = rsm.getColumnCount();

            while (rs.next()) {
                while (contador <= numColumn) {
                    obj.add(rs.getObject(contador));
                    contador++;
                }
                contador = 1;
            }
        } catch (SQLException ex) {
            Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obj;
    }

    /**
     * Selector de imagenes, en especifico trae el BLOB de la tabla imagenes
     * 
     * @param sql
     * @return 
     */
    public ImageIcon selectImage(String sql) {

        ImageIcon imagen = new ImageIcon();
        BufferedImage img;
        try {
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                Blob blob = rs.getBlob("imagen");
                byte[] data = blob.getBytes(1, (int) blob.length());
                img = ImageIO.read(new ByteArrayInputStream(data));
                imagen = new ImageIcon(img);
            }
        } catch (SQLException | IOException ex) {
            Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return imagen;
    }

    /**
     * Metodo para insertar ocurrencias en la tabla imagenes
     * 
     * @param imagen
     * @return 
     */
    public boolean insertImage(Imagenes imagen) {

        BufferedImage buff = (BufferedImage) imagen.getImagen().getImage();
        ByteArrayOutputStream byteArray = new ByteArrayOutputStream();

        PreparedStatement ps = null;

        try {
            conexion.setAutoCommit(false);

            ImageIO.write(buff, "jpg", byteArray);
            InputStream inputStream = new ByteArrayInputStream(byteArray.toByteArray());

            ps = conexion.prepareStatement(imagen.insert());
            ps.setString(1, imagen.getNombreImagen());
            ps.setString(2, imagen.getDescripcionImagen());
            ps.setDate(3, (Date) imagen.getFechaImagen());
            ps.setBinaryStream(4, inputStream, inputStream.available());
            ps.setInt(5, imagen.getIdContenidoMultimediaI());
            ps.executeUpdate();

            conexion.commit();
            return true;
        } catch (Exception ex) {
            Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    /**
     * Metodo para actualizar las ocurrencias en la tabla imagenes
     * 
     * @param imagen
     * @return 
     */
    public boolean updateImage(Imagenes imagen) {
        BufferedImage buff = (BufferedImage) imagen.getImagen().getImage();
        ByteArrayOutputStream byteArray = new ByteArrayOutputStream();

        PreparedStatement ps = null;

        try {
            conexion.setAutoCommit(false);

            ImageIO.write(buff, "jpg", byteArray);
            InputStream inputStream = new ByteArrayInputStream(byteArray.toByteArray());

            ps = conexion.prepareStatement(imagen.update());
            ps.setString(1, imagen.getNombreImagen());
            ps.setString(2, imagen.getDescripcionImagen());
            ps.setDate(3, (Date) imagen.getFechaImagen());
            ps.setBinaryStream(4, inputStream, inputStream.available());
            ps.setInt(5, imagen.getIdImagen());

            ps.executeUpdate();

            conexion.commit();
            return true;
        } catch (Exception ex) {
            Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }
}
