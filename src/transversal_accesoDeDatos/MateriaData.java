
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
import transversal_entidades.Materia;

 
public class MateriaData {
   private Connection con = null;
   
   public MateriaData () {
      con = Conexion.getConexion();
   }
   
   public void guardarMateria (Materia mate)  {
         try {
            String sqlGuardar = "INSERT INTO materia (nombre, anio, estado) VALUES (?, ?, ?)";
             PreparedStatement ps = con.prepareStatement(sqlGuardar, Statement.RETURN_GENERATED_KEYS);
             ps.setString(1, mate.getNombre());
             ps.setInt(2, mate.getAnioMateria());
             ps.setBoolean(3, mate.isActivo());
             ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                mate.setIdMateria(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "materia añadida con exito.");
            }
            ps.close();
                      JOptionPane.showMessageDialog(null, "Materia guardada correctamente"   );
             }  catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Materia" + ex.getMessage());
            ex.printStackTrace();
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

   
   public Materia buscarMateria (int idMateria) {
      String slqBuscar = "SELECT * FROM materia "
              + "WHERE idMateria = ? AND estado = 1 ";
      Materia materia= null;
       try {
            PreparedStatement preparedStatement = con.prepareStatement(slqBuscar);
            preparedStatement.setInt(1, idMateria);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String nombre = resultSet.getString("nombre");                
                int año = resultSet.getInt("anio");
                boolean estado = resultSet.getBoolean("estado");
                //se instancia materia para poder hacer set con los datos obtenidos
                materia = new Materia();
                materia.setIdMateria(idMateria);
                materia.setNombre(nombre);
                materia.setAnioMateria(año);
                materia.setActivo(estado);
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            
            e.printStackTrace();
        }
       return materia;
   }
   
   public void modificarMateria (Materia materia) {
       String sqlModificar = "UPDATE materia SET nombre= ? , anio= ?, estado =?"
               + " WHERE idMateria= ?" ;
       try {
           PreparedStatement ps = con.prepareStatement(sqlModificar);
           ps.setString(1, materia.getNombre());
           ps.setInt(2, materia.getAnioMateria());
           ps.setBoolean(3, materia.isActivo());
           ps.setInt(4, materia.getIdMateria());
           ps.executeUpdate();
           ps.close();
                     JOptionPane.showMessageDialog(null, "Materia actualizada correctamente"   );
       } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Materia" + ex.getMessage());
       }
   }
   
   public void eliminarMateria (int id ) {
        String sqlEliminar = "UPDATE materia SET estado= false"
               + " WHERE materia.idMateria= ?";
       PreparedStatement ps;
       try {
           ps = con.prepareStatement(sqlEliminar);
           ps.setInt(1, id);
           ps.setBoolean(id, false);
           ps.executeUpdate();
           ps.close();
           JOptionPane.showMessageDialog(null, "Materia eliminada correctamente");
       } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Materia" + ex.getMessage());
       } 
   }
   
  public List <Materia> listarMateria (){
      List<Materia> materiaActivaList = new ArrayList<>();
      String sqlListar = "SELECT * FROM materia "
              + " WHERE estado = true";
      
       try {
           PreparedStatement ps = con.prepareStatement(sqlListar);
           ResultSet rs = ps.executeQuery();
           
           while (rs.next()) {
            //get y luego seter para finalmente agregarla a la lista
               int idMateria = rs.getInt("idMateria");
               String nombre = rs.getString("nombre");
               int anioMateria = rs.getInt("anio");
               boolean activo = rs.getBoolean("estado");
               
               Materia materia = new Materia();
               materia.setIdMateria(idMateria);
               materia.setNombre(nombre);
               materia.setAnioMateria(anioMateria);
               materia.setActivo(activo);
              
               materiaActivaList.add(materia);
           }
           rs.close();
           ps.close();
       } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Materia" + ex.getMessage());
       }
      
       return materiaActivaList;
    
}
   
}
