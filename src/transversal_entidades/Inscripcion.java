 
package transversal_entidades;

 
public class Inscripcion {
    
    private int idInscripcion;
     private double nota;
    Alumno alumno;
    Materia materia;


    public Inscripcion() {
    }

    public Inscripcion(int idInscripcion, double nota, Alumno alumno, Materia materia) {
        this.idInscripcion = idInscripcion;
        this.nota = nota;
        this.alumno = alumno;
        this.materia = materia;
    }

    public Inscripcion(double nota, Alumno alumno, Materia materia) {
        this.nota = nota;
        this.alumno = alumno;
        this.materia = materia;
    }

    public int getIdInscripcion() {
        return idInscripcion;
    }

    public void setIdInscripcion(int idInscripcion) {
        this.idInscripcion = idInscripcion;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }
    
    

//    @Override
//    public String toString() {
//        return "Inscripcion: \n" + "idInscripcion=" + idInscripcion + ", alumno=" + alumno + ", materia=" + materia + ", nota=" + nota  ;
//    }
    
    @Override
     public String toString() {
         String consultaInscripcion = idInscripcion +"" + alumno.getApellido() + "" + alumno.getNombre()+ "" + materia.getNombre() + "";
         return consultaInscripcion;
     }
}
