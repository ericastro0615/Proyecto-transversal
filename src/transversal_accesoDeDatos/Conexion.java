/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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

    public Conexion() {
    }
     
    
    public static Connection getConexion () {
        //la conexion es nula al principio y se intenta conectar en la linea 27-28
        if(conexion == null) {
            try {
                 //1. Cargar el driver MariaDB.
                //2. Establecer la conexión a la base de datos previamente creada.
                Class.forName("org.mariadb.jdbc.Driver"); 
                java.sql.Connection conexion=  DriverManager.getConnection(url, usuario, contrasenia);
                System.out.println("conectado desde clase conexion");
            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "error al conectarse a la base de datos");
                ex.printStackTrace();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "error SQL");
                ex.printStackTrace();
            }
            
            
        }
        return conexion;
        
    }
    
    
}
