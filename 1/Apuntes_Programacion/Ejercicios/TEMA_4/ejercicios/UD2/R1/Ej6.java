package ejercicios.UD2.R1;

import java.util.ArrayList;

public class Ej6 {

    public static void main(String[] args) {
        ArrayList<String> frutas  = new ArrayList<String>();
        frutas.add("manzana");
        frutas.add("banana");
        frutas.add("naranja");
        frutas.remove(0);
        frutas.addLast("fresa");
        System.out.println(frutas);

    }
}
