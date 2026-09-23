package ejercicios.UD2.R1;

import java.util.ArrayList;

public class Ej13 {
    public static void main(String[] args) {
        ArrayList<String> letras = new ArrayList<String>();
        ArrayList<String> letrasInvertido = new ArrayList<String>();
        
        letras.add("A");
        letras.add("B");
        letras.add("C");
        letras.add("D");
        
        for (int i = letras.size() - 1; i >= 0; i--) {
            letrasInvertido.add(letras.get(i));
        }
        System.out.println("Invertido: " + letrasInvertido);
    }
}
