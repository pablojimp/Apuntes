package ejercicios.UD2.R1;

import java.util.ArrayList;

public class Ej12 {
    public static void main(String[] args) {
        ArrayList<String> cola = new ArrayList<String>();
        String ultimoEliminado;
        String eliminadoPrimero;
        cola.add("Ana");
        cola.add("Pedro");
        System.out.println(cola);
        cola.addFirst("Carlos");
        cola.addLast("Laura");
        ultimoEliminado = cola.getLast();
        eliminadoPrimero = cola.getFirst();
        System.out.println(eliminadoPrimero);
        System.out.println(ultimoEliminado);
    }
}