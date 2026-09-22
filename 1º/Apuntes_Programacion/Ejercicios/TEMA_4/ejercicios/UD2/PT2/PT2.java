package ejercicios.UD2.PT2;

import java.util.ArrayList;
import java.util.Scanner;

public class PT2 {

    public static void generadorTablero(ArrayList<String> base, int tamanio, String relleno) {
        while (base.size() != tamanio) {
            base.add(relleno);
        }
    }

    public static void randomTablero(ArrayList<String> arrayInterno, int numeroExplosiones) {
        int bombasPuestas = 0;

        while (bombasPuestas < numeroExplosiones) {
            int numeroAleatorio = (int) (Math.random() * arrayInterno.size());

            if (!arrayInterno.get(numeroAleatorio).equals("1")) {
                arrayInterno.set(numeroAleatorio, "1");
                bombasPuestas++;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int tamanioTablero = 10;
        int casillasDestapadas = 0;
        int numeroInteraccion = 0;
        int numeroBombas;
        int numeroSeleccionado;
        String jugador;
        boolean jugar = true;
        ArrayList<String> tableroInterno = new ArrayList<String>();
        ArrayList<String> tableroExterno = new ArrayList<String>();
        

        generadorTablero(tableroInterno, tamanioTablero, "0");
        generadorTablero(tableroExterno, tamanioTablero, "X");

        do {
            System.out.print("¿Cuantas bombas piensas poner? (Int) (1-5): ");
            try {
                numeroBombas = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                numeroBombas = -1;
                System.out.println("ERROR, debes poner un valor entero entre 1 y 5");
            }
        } while (numeroBombas < 1 || numeroBombas > 5);

        randomTablero(tableroInterno, numeroBombas);
        System.out.println("Tablero interno: " + tableroInterno);
        while (jugar) {

            if (numeroInteraccion % 2 == 0) {
                jugador = "Mario";
            } else {
                jugador = "Luigi";
            }

            System.out.println("Tablero externo: " + tableroExterno);

            do {
                System.out.print(jugador + " elige (Int) (1-10): ");
                try {
                    numeroSeleccionado = Integer.parseInt(scanner.nextLine());
                } catch (Exception e) {
                    numeroSeleccionado = -1;
                    System.out.println("ERROR, debes poner un valor entero entre 1 y 10");
                }
            } while (numeroSeleccionado < 1 || numeroSeleccionado > 10);

            if (tableroInterno.get(numeroSeleccionado - 1).equals("1")) {
                System.out.println("Topo Bomba");
                jugar = false;

            } else {
                numeroInteraccion++;
                casillasDestapadas++;
                tableroExterno.set(numeroSeleccionado - 1, "O");

                if (casillasDestapadas + numeroBombas == tamanioTablero) {
                    jugar = false;
                }
            }
        }
        System.out.println("Fin del juego");
        scanner.close();
    }
}