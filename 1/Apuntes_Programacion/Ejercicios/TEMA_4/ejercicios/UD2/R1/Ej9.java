package ejercicios.UD2.R1;
import java.util.ArrayList;
public class Ej9 {
    public static void main(String[] args) {
        ArrayList<String> cola = new ArrayList<String>();
        String clienteAtendido;
        cola.add("cliente1");
        cola.add("cliente2");
        cola.add("cliente3");
        System.out.println(cola);

        for (int i = -1; i <= cola.size(); i++) {
        
            clienteAtendido = cola.get(0);
            cola.remove(clienteAtendido);

            System.out.println("Acabo de atender a: " + clienteAtendido);
            System.out.println("Quedan " + cola.size() + " personas por atender");
        }

    }
}

