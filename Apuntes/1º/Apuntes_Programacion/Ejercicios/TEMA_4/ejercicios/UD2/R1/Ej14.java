package ejercicios.UD2.R1;

import java.util.ArrayList;

public class Ej14 {
    public static void main(String[] args) {
        ArrayList<String> letras = new ArrayList<String>();

        letras.add("5");
        letras.add("10");
        letras.add("15");
        letras.add("20");
        letras.add(letras.getFirst()); 
        letras.removeFirst(); 

        System.out.println(letras);
    }
}
