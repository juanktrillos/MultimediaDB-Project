package database;

/**
 *
 * @author Alejo
 */
import entidades.Imagenes;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.sql.*;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

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

    public boolean insert(String Consulta) {

        String sql = "INSERT INTO " + Consulta;
        boolean insert = querySQL(sql);
        System.out.println("inserte datos  " + sql);

        return insert;
    }

    public boolean update(String Consulta) {

        String sql = "UPDATE " + Consulta;
        boolean update = querySQL(sql);
        System.out.println("Actualize: " + sql);
        return update;
    }

    public boolean delete(String Consulta) {

        String sql = "DELETE FROM " + Consulta;
        boolean update = querySQL(sql);

        return update;
    }

    public LinkedList<Object> read(String sql) {

        @SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
        LinkedList<Object> obj = new LinkedList();
        int contador = 1;

        try {
            ResultSet rs = st.executeQuery("SELECT * FROM " + sql);
            ResultSetMetaData rsm = rs.getMetaData();
            int numColumn = rsm.getColumnCount();

            while (rs.next()) {
                while (contador <= numColumn) {
                    obj.add(rs.getObject(contador));
                    contador++;
                }
            }
        } catch (SQLException ex) {
            System.out.println("error en la base de datos");
        }
        return obj;
    }

    public LinkedList<Object> readM(String sql) {

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
            System.out.println("Error al Insertar Imagen");
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

    public boolean updateImage(Imagenes imagen) {
        BufferedImage buff = (BufferedImage) imagen.getImagen().getImage();
        ByteArrayOutputStream byteArray = new ByteArrayOutputStream();

        PreparedStatement ps = null;

        try {
            conexion.setAutoCommit(false);

            ImageIO.write(buff, "jpg", byteArray);
            InputStream inputStream = new ByteArrayInputStream(byteArray.toByteArray());

            ps = conexion.prepareStatement(imagen.update());
            ps.setInt(1, imagen.getIdImagen());
            ps.setString(2, imagen.getNombreImagen());
            ps.setString(3, imagen.getDescripcionImagen());
            ps.setDate(4, (Date) imagen.getFechaImagen());
            ps.setBinaryStream(5, inputStream, inputStream.available());
            ps.setInt(6, imagen.getIdContenidoMultimediaI());
            ps.setInt(7, imagen.getIdImagen());

            ps.executeUpdate();

            conexion.commit();
            return true;
        } catch (Exception ex) {
            System.out.println("Error al Insertar Imagen");
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
