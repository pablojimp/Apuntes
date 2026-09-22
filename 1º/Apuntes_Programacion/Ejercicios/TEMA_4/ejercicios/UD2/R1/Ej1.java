package ejercicios.UD2.R1;

import java.util.ArrayList;

public class Ej1 {

    public static void main(String[] args) {
        ArrayList<String> colores = new ArrayList<String>();
        colores.add("5");
        colores.add("10");
        colores.add("15");
        colores.add("20");
        System.out.println(colores.get(0));
        System.out.println(colores.get(colores.size()-1));
    }
}

// Crea un array llamado numeros que contenga los números [5, 10, 15, 20].
// Imprime en la consola el primer y el último elemento accediendo directamente por su índice.