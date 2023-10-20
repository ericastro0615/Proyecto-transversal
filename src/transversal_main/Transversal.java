package transversal_main;

import java.sql.Connection;
import java.time.LocalDate;
import java.util.List;
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
        Alumno a2 = new Alumno(14, 398456005, "Gutierrez", "Maria Ana", LocalDate.of(1997, 1, 18), true);

        AlumnoData alumData = new AlumnoData();
       //   alumData.guardarAlumno(a2);
    //    alumData.modificarAlumno(a2);
       // alumData.eliminarAlumno(14);
       /*
       Alumno alumEncontrado =alumData.buscarAlumno(7);
            if (alumEncontrado != null) {
              System.out.printf("\n Búsqueda de alumno por id: \n Apellido: " + alumEncontrado.getApellido() + ".\n Nombre " + alumEncontrado.getNombre()+ "\n DNI: "+ alumEncontrado.getDni()+ "\n\n");
 
             } else {
                System.out.println("Alumno no encontrado");
            }
         
            
            Alumno alumEncontradoXDNI =alumData.buscarAlumnoPorDni(3581575);
            if (alumEncontradoXDNI != null) {
              System.out.printf("\n Búsqueda de alumno por DNI: \n Apellido: " + alumEncontradoXDNI.getApellido() + "\n Nombre: " + alumEncontradoXDNI.getNombre() + "\nDNI: "+ alumEncontradoXDNI.getDni()+". \n\n");
              
             } else {
                System.out.println("Alumno no encontrado");
            }
            
            
        AlumnoData alumnosData = new AlumnoData();
        List<Alumno> listaAlumnos = alumnosData.listarAlumnos();
        System.out.println("\nLista de alumnos datos de alta:\n");
        for (Alumno alumno : listaAlumnos) {
            System.out.println("- Nombre: " + alumno.getNombre() + ", Apellido " + alumno.getApellido() + " ID: " + alumno.getIdAlumno() + ", DNI: " + alumno.getDni() );
        }
        */
   //    Materia mat1 = new Materia(45, "matematica computacional", 2, true);
      MateriaData matData = new MateriaData();
    //    matData.guardarMateria(mat1);
    /*
       Materia materiaEncontrada = matData.buscarMateria(19);
       if (materiaEncontrada!=null) {
           System.out.println("Materia: " + materiaEncontrada.getNombre() + " ID: " + materiaEncontrada.getIdMateria());
       }else {
           System.out.println("No se ha encontrado una materia con el ID ingresado");
       }
*/
    
    /*
       matData.modificarMateria(mat1);
       System.out.println("Modificadación exitosa: \n" + mat1);
      */
  //      matData.eliminarMateria(27);
      /* 
        List<Materia> listaMateria = matData.listarMateria();
        System.out.println("\nLista de materias datos de alta:\n");
        for (Materia materia : listaMateria) {
            System.out.println("-ID : " + materia.getIdMateria() + " Nombre: " + materia.getNombre() + " Año: " + materia.getAnioMateria() + "\n") ;
        }
       
        */
        
//        AlumnoData ad = new AlumnoData();
//        MateriaData md = new MateriaData();
//         InscripcionData id=new InscripcionData();
//      
//        Alumno gomez = ad.buscarAlumno(8);
//        Materia prog1 = md.buscarMateria(2);
//        Inscripcion ins1 = new Inscripcion(10, gomez, prog1);
//        id.guardarInscripcion(ins1);

AlumnoData ad = new AlumnoData();
MateriaData md= new MateriaData();
InscripcionData id= new InscripcionData();

Alumno sebaAlumno=ad.buscarAlumno(8);
Materia lab2Materia=md.buscarMateria(1);
Inscripcion inscripcion= new Inscripcion(7,sebaAlumno, lab2Materia);
id.guardarInscripcion(inscripcion);
}
}
    
