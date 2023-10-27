 
package transversal_accesoDeDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
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
    

     
     public void guardarInscripcion(Inscripcion insc){
        String sql= "INSERT INTO inscripción(nota, idAlumno, idMateria)"
                +"VALUES(?,?,?)";
        
        try {
            PreparedStatement ps = conexion.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
             ps.setDouble(1, insc.getNota());
            ps.setInt(2, insc.getAlumno().getIdAlumno());
            ps.setInt(3, insc.getMateria().getIdMateria());
           
            ps.executeUpdate();
            ResultSet rs= ps.getGeneratedKeys();
            if(rs.next()){
                insc.setIdInscripcion(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Inscripción registrada");
            }
            
            ps.close();
            
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Error al acceder a la tabla inscripción" + ex.getMessage());
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
           }else {
                 JOptionPane.showMessageDialog(null, "el num de idAlumno o el idMateria, es incorrecto");
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
        
        
        
        
        public List<Inscripcion> obtenerInscripcionesPorAlumno(int idAlumno){
            ArrayList<Inscripcion>  cursada = new ArrayList<>();
            String sql = "SELECT*  FROM inscripción WHERE idAlumno= ? ";
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, idAlumno);
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
            JOptionPane.showMessageDialog(null, " Error al acceder a la tabla inscripción" + ex.getMessage());
        }
        return cursada;
        }
        
        
        public List<Materia> obtenerMateriasCursadas(int idAlumno) {
        ArrayList<Materia> materias = new ArrayList<>();
        String sqlObtenerMateriasCursadas = "SELECT m.idMateria, m.nombre, m.anio "
                + "FROM inscripción i "
                + "INNER JOIN materia m ON i.idMateria = m.idMateria "
                + "WHERE i.idAlumno = ?";
        try {
            PreparedStatement ps = conexion.prepareStatement(sqlObtenerMateriasCursadas);
            ps.setInt(1, idAlumno);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Materia materia = new Materia();
                materia.setIdMateria(rs.getInt("idMateria"));
                materia.setNombre(rs.getString("nombre"));
                materia.setAnioMateria(rs.getInt("anio"));
                materias.add(materia);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla inscripción: " + ex.getMessage());
        }
        return materias;
    }
    
    
    
    
       public List<Materia> materiasNoCursadasPorAlumno(int idAlumno) {
        List<Materia> materiasNoCursadasXalum = new ArrayList<>();

        // Consulta SQL para seleccionar las materias que no están en la tabla de inscripciones para el alumno específico
        String sqlMateriasNOcursadas = "SELECT * "
                + "FROM materia "
                + "WHERE idMateria NOT IN"
                + " (SELECT idMateria FROM inscripción WHERE idAlumno = ?)";

        try {
            PreparedStatement ps = conexion.prepareStatement(sqlMateriasNOcursadas) ;
            ps.setInt(1, idAlumno); 
            ResultSet rs = ps.executeQuery(); 
            while (rs.next()) {
                int idMateria = rs.getInt("idMateria");
                String nombre = rs.getString("nombre");
                int anioMateria = rs.getInt("anio");
                boolean activo = rs.getBoolean("estado"); 
                Materia materia = new Materia(idMateria, nombre, anioMateria, activo); 
                materiasNoCursadasXalum.add(materia);
            }
        } catch (SQLException ex) {
              JOptionPane.showMessageDialog(null, "Error al acceder a la tabla inscripción" + ex.getMessage());
          //  e.printStackTrace();
        } 
        return materiasNoCursadasXalum;
    }
       
       public List<Alumno> alumnosPorMateria(int idMateria) {
    List<Alumno> alumnosCursandoMateria = new ArrayList<>();

  
    String queryAlumnosXmateria = "SELECT * FROM alumno a "
                + "JOIN inscripción i ON a.idAlumno = i.idAlumno "
                + "WHERE i.idMateria = ? AND a.estado = 1";

        try  {
             PreparedStatement ps = conexion.prepareStatement(queryAlumnosXmateria);
           ps.setInt(1, idMateria);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int idAlumno = rs.getInt("idAlumno");
                int dni = rs.getInt("dni");
                String apellido = rs.getString("apellido");
                String nombre = rs.getString("nombre");
                LocalDate fechaNacimiento = rs.getDate("fechaNacimiento").toLocalDate();
                boolean estado = rs.getBoolean("estado");
                Alumno alumno = new Alumno(idAlumno, dni, apellido, nombre, fechaNacimiento, estado);

                alumnosCursandoMateria.add(alumno);
            }
        } catch (SQLException ex) {
              JOptionPane.showMessageDialog(null, "Error al acceder a la tabla inscripción/ alumno " + ex.getMessage());
       
        }
        return alumnosCursandoMateria;
    }


       
}
