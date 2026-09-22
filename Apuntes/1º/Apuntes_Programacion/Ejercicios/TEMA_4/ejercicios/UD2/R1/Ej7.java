package ejercicios.UD2.R1;

import java.util.ArrayList;

public class Ej7 {

    public static void main(String[] args) {
        ArrayList<String> dias  = new ArrayList<String>();
        dias.add("L");
        dias.add("M");
        dias.add("X");
        dias.add("J");
        dias.add("V");
        dias.add("S");
        dias.add("D");
        System.out.println(dias);
        dias.set(6, "Domingo (fin de semana)");
        System.out.println(dias);
    }
}





