
package transversal_accesoDeDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

 
public class Conexion {
    
    private final static String url = "jdbc:mariadb://127.0.0.1:3306/ulp";
    private final static String usuario= "root";
    private final static  String contrasenia = "";
    private static Connection conexion;

    private Conexion() {
    }
     
    
public static Connection getConexion() {
    // Verifica si la conexión ya está establecida
    if (conexion == null) {
        try {
            // Cargar el driver MariaDB.
            // Establecer la conexión a la base de datos previamente creada.
            Class.forName("org.mariadb.jdbc.Driver");
            // se elimino DriverManager que estaba en la izq
            conexion = DriverManager.getConnection(url, usuario, contrasenia);
            System.out.println("Conectado desde clase conexion");
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Error al cargar el driver de la base de datos");
            ex.printStackTrace();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error SQL al establecer la conexión");
            ex.printStackTrace();
        }
    }
    return conexion;
}
}