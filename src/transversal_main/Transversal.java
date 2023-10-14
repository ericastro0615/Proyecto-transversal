package transversal_main;

import java.sql.Connection;
import java.time.LocalDate;
import transversal_accesoDeDatos.AlumnoData;
import transversal_accesoDeDatos.Conexion;
 
import transversal_entidades.Alumno;




public class Transversal {

    
    public static void main(String[] args) {
        Connection conexion = Conexion.getConexion();
        Alumno a2 = new Alumno(14, 357452825, "Gutierrez", "Maria Agustina", LocalDate.of(1998, 7, 18), true);

        AlumnoData alumData = new AlumnoData();
        //  alumData.guardarAlumno(a2);
        //alumData.modificarAlumno(a2);
        alumData.eliminarAlumno(14);

       }
 
       
       }
    

