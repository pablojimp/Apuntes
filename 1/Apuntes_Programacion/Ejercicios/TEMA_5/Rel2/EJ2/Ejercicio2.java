package Apuntes.Apuntes_Programacion.Ejercicios.TEMA_5.Rel2.EJ2;

public class Ejercicio2 {
    public static void main(String[] args) {

        Libro hola = new Libro("LIB356","hola", "Yo",  "LOSOSDLSLODKDASJOFJSE", true); 
        Libro adios = new Libro("LIB366","adios", "Yo",  "LOSOSDLSLODKDASJOFJSE", true); 

        Biblioteca alejandria = new Biblioteca();
        alejandria.agregarLibro(hola);

        alejandria.prestarLibro(adios);
        System.out.println(hola.isDisponible());
        alejandria.prestarLibro(hola);
        System.out.println(hola.isDisponible());
        alejandria.prestarLibro(hola);
    }
}


