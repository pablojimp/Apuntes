package ejercicios.UD1.R2;

import java.util.Scanner;

public class Ejercicio5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double constanteLuna = 0.165;
        double peso;
        double pesoLuna;

        // Leer datos del usuario
        System.out.print("Ingresa tu peso: ");
        peso = scanner.nextDouble();
        scanner.close();

        pesoLuna = peso * constanteLuna;
        System.out.println("Su peso en la luna es: " + pesoLuna + " kg");
    }
}
