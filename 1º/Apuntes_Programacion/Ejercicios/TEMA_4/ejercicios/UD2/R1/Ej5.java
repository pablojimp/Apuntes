package ejercicios.UD2.R1;

import java.util.ArrayList;

public class Ej5 {

    public static void main(String[] args) {
        ArrayList<String> animales  = new ArrayList<String>();
        String eliminado = "";
        animales.add("perro");
        animales.add("gato");
        System.out.println((animales));
        animales.addFirst("loro");
        animales.addFirst("tortuga");
        System.out.println(animales);
        eliminado = animales.get(0);
        animales.remove(0);  
        System.out.println(eliminado);
        System.out.println(animales);
    }
}



