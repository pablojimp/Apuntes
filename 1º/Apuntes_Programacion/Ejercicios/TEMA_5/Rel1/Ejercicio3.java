package Apuntes.Apuntes_Programacion.Ejercicios.TEMA_5.Rel1;

public class Ejercicio3 {

    public static void main(String[] args) {
        Alumno alumno = new Alumno("Pablo", "Tecnologia", 6.8);
        System.out.println(alumno);
    }

}

class Alumno {

    String nombre;
    String materia;
    double calificacion;

    Alumno(String nombre, String materia, double calificacion) {
        this.nombre = nombre;
        this.materia = materia;
        this.calificacion = calificacion;
    }

    boolean aprobo() {
        return calificacion >= 6;
    }

    @Override
    public String toString() {
        String mensajeAprobado = (this.aprobo()) ? "Está aprobado" : "Está suspenso";

        return "El nombres es: " + this.nombre + " | La materia es: " + this.materia + " | La calificacion es: "
                + this.calificacion + " | " + mensajeAprobado;
    }
}
