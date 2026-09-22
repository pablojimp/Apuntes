package ejercicios.UD2.R1;

import java.util.ArrayList;

public class Ej3 {

    public static void main(String[] args) {
        ArrayList<String> colores = new ArrayList<String>();
        String eliminado = "";
        colores.add("rojo");
        colores.add("verde");
        colores.add("azul");
        System.out.println((colores));
        eliminado = colores.get(0);
        colores.remove(0);  
        System.out.println(colores);
        System.out.println(eliminado);
    }
}




