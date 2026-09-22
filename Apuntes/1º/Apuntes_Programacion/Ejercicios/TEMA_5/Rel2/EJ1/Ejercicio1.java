package Apuntes.Apuntes_Programacion.Ejercicios.TEMA_5.Rel2.EJ1;

public class Ejercicio1 {

    /** 
     * @param args
     */
    public static void main(String[] args) {
        Estudiante alfredo = new Estudiante("Alfredo", 22, "STEM001");
        Estudiante cristobal = new Estudiante("Cristobal", 25, "STEM002");
        System.out.println(alfredo);
        alfredo.setNombre("Alfredo Duro");
        System.out.println(alfredo.getNombre());
        System.out.println(alfredo);
        Universidad ugr = new Universidad();
        ugr.agregarAlumno(alfredo);
        ugr.agregarAlumno(cristobal);
        System.out.println(ugr.mostrarString());
    }
}