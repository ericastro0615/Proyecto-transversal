 
package transversal_accesoDeDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    
     /*
     public void guardarInscripcion (Inscripcion inscri)  {
         String sqlGuardarInscri = "INSERT INTO inscripción (nota, idAlumno, idMateria ) "
                 + " VALUES (?, ?, ? )";
         try {
             System.out.println("ingresando al metodo guardarMateria");
             PreparedStatement ps = conexion.prepareStatement(sqlGuardarInscri, Statement.RETURN_GENERATED_KEYS);
             //setear y luego envio datos con update
             
             ps.setDouble(1, inscri.getNota()); 
              ps.setInt(2, inscri.getAlumno().getIdAlumno());
              ps.setInt(3, inscri.getMateria().getIdMateria());
             ps.executeUpdate();
             ResultSet  rs = ps.getGeneratedKeys();
             if (rs.next()) {
                 inscri.setIdInscripcion(rs.getInt(1));
                 JOptionPane.showMessageDialog(null, "Inscripción correcta"); 
             }else {
                   JOptionPane.showMessageDialog(null, "Inscripción correcta"); 
             }
             ps.close();
         } catch (Exception ex) {
               JOptionPane.showMessageDialog(null, "Error al acceder a la tabla inscripción" + ex.getMessage());
         }   
       
     }
*/
     
     public void guardarInscripcion(Inscripcion insc){
        String sql= "INSERT INTO inscripción(nota, idAlumno, idMateria)"
                +" VALUES(?,?,?)";
        
        try {
            PreparedStatement ps = conexion.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
             ps.setDouble(1, insc.getNota());
            ps.setInt(2, insc.getAlumno().getIdAlumno());
            ps.setInt(3, insc.getMateria().getIdMateria());  
            ps.executeUpdate();
            ResultSet rs= ps.getGeneratedKeys();
            if(rs.next()){
                insc.setIdInscripcion(rs.getInt(1));//solo hay una
                JOptionPane.showMessageDialog(null, "Inscripcion registrada");
            }
            
            ps.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(InscripcionData.class.getName()).log(Level.SEVERE, null, ex);
        }
 
    }
     
     
       public void actualizarNota (double nota, int idAlumno, int idMateria) {
             String sqlActualizar = "UPDATE inscripción SET nota = ? "
                     + " WHERE idALumno=?";
        try {
            PreparedStatement ps= conexion.prepareStatement(sqlActualizar);
            ps.setDouble(1, nota);
            ps.setInt(2, idAlumno);
            ps.setInt(3, idMateria);
           int filaActualizada =  ps.executeUpdate();
           if(filaActualizada>0) {
               JOptionPane.showMessageDialog(null, "Se actualizo correctamente la nota, en la tabla inscripción");
           } else {
               JOptionPane.showMessageDialog(null, "Solo es posible modificar la nota");
           }
           ps.close();
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Error al acceder a la tabla inscripción" + ex.getMessage());
        }
             
         }
}
