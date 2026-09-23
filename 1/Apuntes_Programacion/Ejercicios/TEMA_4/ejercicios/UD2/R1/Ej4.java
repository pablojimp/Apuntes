package ejercicios.UD2.R1;

import java.util.ArrayList;

public class Ej4 {

    public static void main(String[] args) {
        ArrayList<String> animales = new ArrayList<String>();
        animales.add("perro");
        animales.add("gato");
       
        System.out.println((animales));
        animales.addFirst("loro");
        animales.addFirst("tortuga");
        System.out.println(animales);
    }
}




