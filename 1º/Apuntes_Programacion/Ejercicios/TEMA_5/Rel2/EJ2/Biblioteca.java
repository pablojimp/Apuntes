package Apuntes.Apuntes_Programacion.Ejercicios.TEMA_5.Rel2.EJ2;

import java.util.ArrayList;

public class Biblioteca {

    ArrayList<Libro> libros;

    Biblioteca() {
        this.libros = new ArrayList<>();
    }


    /** 
     * @param libro
     */
    public void agregarLibro(Libro libro) {
        libros.add(libro);
    }


    /** 
     * @param libro
     */
    public void prestarLibro(Libro libro){
        

        if (libro.isDisponible() == true) {
            libro.setDisponible(false);
            System.out.println("se puede prestar");
        }
        else{
            System.out.println("no se puede prestar");
        }
    }

     /** 
      * @param libro 
      */
     public void devolverLibro(Libro libro){
    
        if (libro.isDisponible() == false) {
            libro.setDisponible(true);
            System.out.println("se puede devolver");
        }
        else{
            System.out.println("no se puede devolver");
        }
    }
}
