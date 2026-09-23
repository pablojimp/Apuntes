package ejercicios.UD2.R1;

import java.util.ArrayList;

public class Ej8 {
    public static void main(String[] args) {
        ArrayList<String> numeros = new ArrayList<String>();
        String temporal;
        String temporal2;
        numeros.add("100");
        numeros.add("200");
        numeros.add("300");
        System.out.println(numeros);

        temporal = numeros.getFirst();
        temporal2 = numeros.getLast();

        numeros.set(0,temporal2);
        numeros.set(2, temporal);
        System.out.println(numeros);
    }
}


