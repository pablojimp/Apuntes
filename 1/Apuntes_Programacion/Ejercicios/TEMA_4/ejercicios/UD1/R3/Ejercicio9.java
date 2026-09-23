package ejercicios.UD1.R3;

import java.util.Scanner;

public class Ejercicio9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Leer datos del usuario
        int numeroUsuario;
        int primerNumero;
        int SegundoNumero;
        int resultado;
        
        System.out.print("Ingresa tu numero: ");
        numeroUsuario = scanner.nextInt();
        scanner.close();

        if (numeroUsuario >= 10 && numeroUsuario <= 99) {
            primerNumero = numeroUsuario / 10;
            SegundoNumero = numeroUsuario % 10;
            resultado = primerNumero + SegundoNumero;
            System.out.println("El resultado de la suma de los 2 numero es: " + resultado);
        } else {
            System.out.println("No es correcto el numero introducido");
        }
    }
}
