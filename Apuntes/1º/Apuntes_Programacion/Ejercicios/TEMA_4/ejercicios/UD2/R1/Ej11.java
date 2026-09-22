package ejercicios.UD2.R1;
import java.util.ArrayList;
public class Ej11 {
    public static void main(String[] args) {
        ArrayList<String> cola = new ArrayList<String>();
        cola.add("Ana");
        cola.add("Pedro");
        System.out.println(cola);
        cola.addFirst("Carlos");
        cola.addLast("Laura");
        System.out.println(cola);
    }
}