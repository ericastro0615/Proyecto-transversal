
package transversal_accesoDeDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import transversal_entidades.Materia;

 
public class MateriaData {
   private Connection con = null;
   
   public MateriaData () {
      con = Conexion.getConexion();
   }
   
   public void guardarMateria (Materia mate) {
         try {
            String sql = "INSERT INTO materia (nombre, anio, estado) VALUES (?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            ps.setString(1, mate.getNombre());
            ps.setInt(2, mate.getAnioMateria()); 
            ps.setBoolean(3, mate.isActivo());  
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
             if (rs.next()) {
                 System.out.println("Ingresando a rs...");
                 mate.setIdMateria(rs.getInt(""));
                 JOptionPane.showMessageDialog(null, "mate añadido con exito.");
             }
             ps.close();
 /*
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                mate.setIdMateria(rs.getInt("idMateria"));
                JOptionPane.showMessageDialog(null, "Materia añadido con exito.");
            }
            ps.close();
*/
        } catch (SQLException ex) {
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
}
