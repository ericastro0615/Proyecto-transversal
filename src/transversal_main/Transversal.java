package transversal_main;

import java.sql.Connection;
import java.time.LocalDate;
import transversal_accesoDeDatos.AlumnoData;
import transversal_accesoDeDatos.Conexion;
 
import transversal_entidades.Alumno;




public class Transversal {

    
    public static void main(String[] args) {
        Connection conexion = Conexion.getConexion();
        //Alumno a2 = new Alumno(14, 357452825, "Gutierrez", "Maria Agustina", LocalDate.of(1998, 7, 18), true);

        AlumnoData alumData = new AlumnoData();
        //  alumData.guardarAlumno(a2);
        //alumData.modificarAlumno(a2);
        //alumData.eliminarAlumno(14);
        
        Alumno alumnoEncontrado = alumData.buscarAlumno(6);
       
        System.out.println("Dni :"+alumnoEncontrado.getDni()+ "apellido :"+alumnoEncontrado.getApellido());
        Alumno alumnoEncontradoPorDni = alumData.buscarAlumnoPorDni(3581575);
       
        System.out.println("Dni :"+alumnoEncontradoPorDni.getDni()+ "apellido :"+alumnoEncontradoPorDni.getApellido());
       }
 
       
       }
    

