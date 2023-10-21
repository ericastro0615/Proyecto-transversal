
package transversal_accesoDeDatos;

import java.sql.Connection;
import java.sql.Date;
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

public class AlumnoData {

    private Connection con = null;

    public AlumnoData() {
        //inicializa solo la variable conexion
        con = Conexion.getConexion();
       
    }

    public void guardarAlumno(Alumno alumno) {

        try {
            String sql = "INSERT INTO alumno (dni, apellido, nombre, fechaNacimiento, estado)" + "VALUES (?, ?, ?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, alumno.getDni());
            ps.setString(2, alumno.getApellido());
            ps.setString(3, alumno.getNombre());
            ps.setDate(4, Date.valueOf(alumno.getFechaNacimiento()));//localDate a Date
            ps.setBoolean(5, alumno.isEstado());  
            ps.executeUpdate(); 
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                alumno.setIdAlumno(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Alumno añadido con exito.");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Alumno" + ex.getMessage());

            int error = ex.getErrorCode();
            if (error == 1062) {
                JOptionPane.showMessageDialog(null, "Entrada duplicada");
                if (error == 0) {
                    JOptionPane.showMessageDialog(null, "error al ingresar a la base de datos, verifique la URL");

                }
                if (error == 1049) {
                    JOptionPane.showMessageDialog(null, "Error al intentar ingresar a la base de datos, verifique el nombre de la base de datos");

                }
                if (error == 1045) {
                    JOptionPane.showMessageDialog(null, "Acceso denegado, verifique la contraseña ");

                }
                if (error == 1146) {
                    JOptionPane.showMessageDialog(null, "Error al intentar conectarse a a tabla de la base de datos, verifique el nombre");

                } else {
                    JOptionPane.showMessageDialog(null, "error SQL");
                    ex.printStackTrace();
                }
            }

        }

    }

    public void modificarAlumno (Alumno alumno) {
        
        String sqlUpdate = "UPDATE alumno SET dni=?, apellido=?, nombre=?, fechaNacimiento=?"
                + " WHERE idAlumno = ?";
        
        try {
             //setear parametros dinamicos
            PreparedStatement ps = con.prepareStatement(sqlUpdate);
            ps.setInt(1, alumno.getDni());
            ps.setString(2, alumno.getApellido());
            ps.setString(3, alumno.getNombre());
            ps.setDate(4, Date.valueOf(alumno.getFechaNacimiento()));
            ps.setInt(5, alumno.getIdAlumno());
                 
            int queryExitosa = ps.executeUpdate();
            if (queryExitosa==1) {
                JOptionPane.showMessageDialog(null, "Datos de alumno modificado");
            } 
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al intentar acceder a la tabla alumno"+ex.getMessage());
        }
    }
    
    public void eliminarAlumno (int idAlumno) {
        String sqlEliminar  = "UPDATE alumno SET estado=0 WHERE idAlumno = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sqlEliminar);
             ps.setInt(1,idAlumno );
            int queryExitosa = ps.executeUpdate();
             if (queryExitosa>0) {
                JOptionPane.showMessageDialog(null, "Datos del alumno eliminado. De estado 1 a 0" );
            } 
            
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Error al intentar acceder a la tabla alumno"+ex.getMessage());
        }
        
        
    }
    
    
    public Alumno buscarAlumno(int idAlumno){
        String sql=  "SELECT * FROM alumno "
                + " WHERE idAlumno = ? AND estado = 1";
        Alumno alumno = null;
        try {
            PreparedStatement  ps = con.prepareStatement(sql);
            ps.setInt(1, idAlumno);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                int dni = rs.getInt("dni");
                String apellido = rs.getString("apellido");
                String nombre = rs.getString("nombre");
                java.sql.Date fechaNacimiento = rs.getDate("fechaNacimiento");
                boolean estado = rs.getBoolean("estado");

                //se contruye obj alumno con los setters obt de DB
                alumno= new Alumno();
                alumno.setDni(rs.getInt("dni")); 
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre")); 
                alumno.setFechaNacimiento(rs.getDate("fechaNacimiento").toLocalDate());
                alumno.setEstado(true);
            }
            else{
                JOptionPane.showMessageDialog(null,"El alumno no existe");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al intentar acceder a la tabla alumno"+ex.getMessage());
        }
        return alumno;
    }
    
    public Alumno buscarAlumnoPorDni(int dni){
        String sql=  "SELECT * FROM alumno WHERE dni = ? AND estado = 1";
        Alumno alumno = null;
        try {
            PreparedStatement  ps = con.prepareStatement(sql);
            ps.setInt(1, dni);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                alumno= new Alumno();
                alumno.setIdAlumno(rs.getInt("idAlumno"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setDni(rs.getInt("dni"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setFechaNacimiento(rs.getDate("fechaNacimiento").toLocalDate());
                alumno.setEstado(true);
            }
            else{
                JOptionPane.showMessageDialog(null,"El alumno no existe");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al intentar acceder a la tabla alumno"+ex.getMessage());
        }
        return alumno;
    }
    
    public List<Alumno> listarAlumnos(){
        String sql=  "SELECT * FROM alumno WHERE estado = 1";
        ArrayList<Alumno> alumnos = new ArrayList<>();
        try {
            PreparedStatement  ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Alumno alumno= new Alumno();
                alumno.setIdAlumno(rs.getInt("idAlumno"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setDni(rs.getInt("dni"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setFechaNacimiento(rs.getDate("fechaNacimiento").toLocalDate());
                alumno.setEstado(true);
                alumnos.add(alumno);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al intentar acceder a la tabla alumno "+ex.getMessage());
        }
        return alumnos;
    }
    
}

         
   
    

