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
        Alumno a2 = new Alumno( 345873216, "Benavidez", "Soledad", LocalDate.of(1986, 10, 28), true);

        AlumnoData alumData = new AlumnoData();
   //        alumData.guardarAlumno(a2);
      //  alumData.modificarAlumno(a2);
       // alumData.eliminarAlumno(2);
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
      
      
      
      ////---------------- materia 
      
      
  //     Materia mat1 = new Materia("analisis computacional", 3, true);
 //    MateriaData matData = new MateriaData();
 //       matData.guardarMateria(mat1);
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
   //    matData.eliminarMateria(3);
     
   /*
        List<Materia> listaMateria = matData.listarMateria();
        System.out.println("\nLista de materias datos de alta:\n");
        for (Materia materia : listaMateria) {
            System.out.println("-ID : " + materia.getIdMateria() + " Nombre: " + materia.getNombre() + " Año: " + materia.getAnioMateria() + "\n") ;
        }
       
    */  
   
   
   
        ///------- inscripcion
        
        AlumnoData ad = new AlumnoData();
        MateriaData md = new MateriaData();
         InscripcionData id=new InscripcionData();
      
         
         /*guardar una Inscripcionn 
        Alumno b1 = ad.buscarAlumno(10);
        Materia prog1 = md.buscarMateria(3);
        Inscripcion ins1 = new Inscripcion(10, b1, prog1);
   //     id.guardarInscripcion(ins1);
 
     */    

      
    //    id.borrarInscripcion(16, 7);
     
       
         
        
/* todas las inscripciones
        List <Inscripcion> inscripcionLis= id.obtenerInscripciones();   
        System.out.println("Lista de inscripciones: \n");
            for (Inscripcion inscripcion : inscripcionLis){
            System.out.println("id de inscripción: " + inscripcion.getIdInscripcion());
            System.out.println("Nota: " + inscripcion.getNota());
            System.out.println("id de alumno: " + inscripcion.getAlumno().getIdAlumno());
            System.out.println("id materia: " + inscripcion.getMateria().getIdMateria());
            System.out.println("\n");
        }
    
   */

/* inscripciones por alumno
        List<Inscripcion> listaInscripcionesAlumno = id.obtenerInscripcionesPorAlumno(10);// 
        if (listaInscripcionesAlumno.isEmpty() != true) {
            for (Inscripcion aux : listaInscripcionesAlumno) {             
                System.out.println("Alumno: " + aux.getAlumno().getNombre() + " " + aux.getAlumno().getApellido() + ", se encuentra inscripto en: " + aux.getMateria().getNombre());
            }
        } else {
            System.out.println("El id alumno que ingresaste no está inscripto en ninguna materia");
        }
*/


      /*    
           //materias cursadas
        List<Materia> materiasCursadas = id.obtenerMateriasCursadas(10);
          if (materiasCursadas.isEmpty() != true) {
            for (Materia x : materiasCursadas) {
               // System.out.println(id.obtenerMateriasCursadas(2).toString() );
                System.out.println( "Materia cursadas : " + x.getNombre() + " id: " + x.getIdMateria() + " año: " + x.getAnioMateria());
            }
        } else {
            System.out.println("el n° de id de alumno, no existe o es incorrecto");
        }
          
          
     */
      
      
    
//            materias NO cursadas
            List<Materia> materias=id.materiasNoCursadasPorAlumno(10);
            if (materias.isEmpty()!=true){
                for (Materia x: materias){
                System.out.println("El alumno no cursa actualmente la materia:  "+ x.getNombre() + " id  : "+x.getIdMateria() + " correspondiente al año:"+x.getAnioMateria());
            }
            }else{
                 System.out.println("id incorrecto");
            }
            
      // ---- alumnos cursantes x IDmateria
      
  List<Alumno> alumnosCursandoMateria = id.alumnosPorMateria(2);

        if (alumnosCursandoMateria.isEmpty()) {
            System.out.println("No hay alumnos cursando la materia con idMateria ingresado ");
        } else {
            System.out.println("Alumnos cursando  :");
            for (Alumno alumno : alumnosCursandoMateria) {
                System.out.println("id: " + alumno.getIdAlumno() +
                                   " DNI: " + alumno.getDni() +
                                   " nombre: " + alumno.getNombre() +
                                   " apellido: " + alumno.getApellido() +
                                   " fecha de Nacimiento: "+  alumno.getFechaNacimiento());      
            }
        }



    }

   
    
}
