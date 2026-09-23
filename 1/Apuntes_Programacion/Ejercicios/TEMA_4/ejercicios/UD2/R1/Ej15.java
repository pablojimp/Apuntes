package ejercicios.UD2.R1;

import java.util.ArrayList;

public class Ej15 {
    public static void main(String[] args) {
        ArrayList<String> letras = new ArrayList<String>();

        letras.add("1");
        letras.add("2");
        letras.add("3");
        letras.add("4");
        letras.add("5");
        System.out.println(letras);
        while (!letras.isEmpty()) {
            letras.removeLast();
            System.out.println(letras);
        }
    }
}