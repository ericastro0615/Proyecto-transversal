 
package transversal_accesoDeDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import transversal_entidades.Alumno;
import transversal_entidades.Inscripcion;
import transversal_entidades.Materia;

 
public class InscripcionData {
    private MateriaData matData = new MateriaData();
    private  AlumnoData alumData = new AlumnoData();
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
     
     
       public void actualizarNota (int idAlumno,int idMateria,double nota  ) {
             String sqlActualizar = "UPDATE inscripción SET nota = ? "
                     + " WHERE idALumno=? and idMateria = ?";
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
       public void  borrarInscripcion(int idAlumno, int idMateria){
           String sql = "DELETE FROM inscripción WHERE idAlumno = ? and idMateria = ?";
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setDouble(1,idAlumno);
            ps.setInt(2, idMateria);
            int filaActualizada =  ps.executeUpdate();
           if(filaActualizada>0) {
               JOptionPane.showMessageDialog(null, "inscripción borrada");
           }
           ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla inscripción" + ex.getMessage());
        }
       
       }
        public List<Inscripcion> obtenerInscripciones(){
            ArrayList<Inscripcion>  cursada = new ArrayList<>();
            String sql = "SELECT * FROM inscripción ";
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ResultSet  rs = ps.executeQuery();
            while(rs.next()){
               Inscripcion inc = new Inscripcion();
               inc.setIdInscripcion(rs.getInt("idInscripto"));
               Alumno alum = alumData.buscarAlumno(rs.getInt("idAlumno"));
               Materia mate = matData.buscarMateria(rs.getInt("idMateria"));
               inc.setAlumno(alum);
               inc.setMateria(mate);
               inc.setNota(rs.getDouble("nota"));
               cursada.add(inc);
               ps.close();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla inscripción" + ex.getMessage());
        }
        return cursada;
        }
}
