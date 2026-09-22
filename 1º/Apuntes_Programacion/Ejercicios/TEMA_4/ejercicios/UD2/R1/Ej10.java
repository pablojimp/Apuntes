package ejercicios.UD2.R1;
import java.util.ArrayList;
public class Ej10 {
    public static void main(String[] args) {
        ArrayList<String> cola = new ArrayList<String>();
        String clienteAtendido;
        cola.add("10");
        cola.add("20");
        cola.add("30");
        System.out.println(cola);

        for (int i = -1; i <= cola.size(); i++) {
        
            clienteAtendido = cola.get(cola.size()-1);
            cola.remove(clienteAtendido);

            System.out.println("Acabo de atender a: " + clienteAtendido);
            System.out.println("Quedan " + cola.size() + " personas por atender");
        }

    }
}

