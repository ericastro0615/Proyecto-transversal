 
package transversal_accesoDeDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import transversal_entidades.Inscripcion;

 
public class InscripcionData {
    private MateriaData matData;
    private  AlumnoData alumData;
    private Connection conexion=null;
    
     public InscripcionData () {
         //carga metodos de conexion y se  establece con
         this.conexion=Conexion.getConexion();
     }
    
     public void guardarInscripcion (Inscripcion inscri) throws SQLException {
         String sqlGuardarInscri = "INSERT INTO inscripción (idAlumno, idMateria, nota) "
                 + "VALUES (?, ?, ? )";
         try {
             PreparedStatement ps = conexion.prepareStatement(sqlGuardarInscri, Statement.RETURN_GENERATED_KEYS);
             //setear y luego envio datos con update
             ps.setInt(1, inscri.getIdInscripcion());
             ps.setInt(2, inscri.getMateria().getIdMateria());
             ps.setDouble(3, inscri.getNota());
             ps.executeUpdate();
             ResultSet  rs = ps.getGeneratedKeys();
             if (rs.next()) {
                 inscri.setIdInscripcion(rs.getInt(1));
                 JOptionPane.showMessageDialog(null, "Inscripción correcta"); 
             }
             ps.close();
         } catch (Exception ex) {
               JOptionPane.showMessageDialog(null, "Error al acceder a la tabla inscripción" + ex.getMessage());
         }  
         
         
     }     
}
