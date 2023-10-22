package transversal_main;

import java.sql.Connection;
import java.time.LocalDate;
import transversal_accesoDeDatos.AlumnoData;
import transversal_accesoDeDatos.Conexion;
import transversal_accesoDeDatos.InscripcionData;
import transversal_accesoDeDatos.MateriaData;
 
import transversal_entidades.Alumno;
import transversal_entidades.Inscripcion;
import transversal_entidades.Materia;




public class Transversal {

    
    public static void main(String[] args) {
        Connection conexion = Conexion.getConexion();
        //Alumno a2 = new Alumno(14, 357452825, "Gutierrez", "Maria Agustina", LocalDate.of(1998, 7, 18), true);

//        AlumnoData alumData = new AlumnoData();
//        alumData.guardarAlumno(a2);
//        alumData.modificarAlumno(a2);
//        alumData.eliminarAlumno(14);
//        Alumno alumnoEncontrado = alumData.buscarAlumno(6);
//        System.out.println("Dni :"+alumnoEncontrado.getDni()+ "apellido :"+alumnoEncontrado.getApellido());
//        Alumno alumnoEncontradoPorDni = alumData.buscarAlumnoPorDni(3581575);
//        System.out.println("Dni :"+alumnoEncontradoPorDni.getDni()+ "apellido :"+alumnoEncontradoPorDni.getApellido());

//        Alumno a3 = new Alumno(43809895, "Gonzales", "Julieta", LocalDate.of(1993, 7, 18), true);
//        AlumnoData alumData = new AlumnoData();
//        alumData.guardarAlumno(a3);
        //alumData.modificarAlumno(a3);
        //alumData.eliminarAlumno(15);
//        Alumno alumnoEncontrado = alumData.buscarAlumno(6);
//        System.out.println("Dni :"+alumnoEncontrado.getDni()+ "apellido :"+alumnoEncontrado.getApellido());
//        Alumno alumnoEncontradoPorDni = alumData.buscarAlumnoPorDni(3581575);
//        System.out.println("Dni :"+alumnoEncontradoPorDni.getDni()+ "apellido :"+alumnoEncontradoPorDni.getApellido());
//        Materia calculo = new Materia("calculo",2,true);
//        MateriaData calculoData = new MateriaData();
//        calculoData.guardarMateria(calculo);
//       ---- Prueba del metodo guardarIncripcion----
          AlumnoData alum2 = new AlumnoData();
          MateriaData mat2 = new MateriaData();
          InscripcionData incd = new InscripcionData();
          Alumno juanIgnacio = alum2.buscarAlumno(6);
          Materia mate = mat2.buscarMateria(2);
          Inscripcion insc = new Inscripcion(8,juanIgnacio,mate);
          //incd.guardarInscripcion(insc);
//       ---- prueba del metodo actualizarnota---
         //incd.actualizarNota(6, 3, 6);
//      ---  Pruba de metodo borrarIncripcion---
          //incd.borrarInscripcion(7, 2);
//      --- Pruba de metodo obtenerInscricion---
        for (Inscripcion in: incd.obtenerInscripciones()) {
           System.out.println("id"+ in.getIdInscripcion());
           System.out.println("apellido"+ in.getAlumno().getApellido());
           System.out.println("materia"+in.getMateria().getNombre());
      }
 
       
       }
}
    

