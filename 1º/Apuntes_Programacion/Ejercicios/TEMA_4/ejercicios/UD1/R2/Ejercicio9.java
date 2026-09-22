package ejercicios.UD1.R2;

import java.util.Scanner;

public class Ejercicio9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leer datos del usuario
        System.out.print("Ingresa tu numero de Caramelos: ");
        int caramelos = scanner.nextInt();

        System.out.print("Ingresa el numero de niños: ");
        int niños = scanner.nextInt();

        int caramelosNiños = caramelos / niños;
        int restoCaramelos = caramelos % niños;

        System.out.println("A cada niños le tocan " + caramelosNiños+ " y sobran " + restoCaramelos+" caramelos"); 
        scanner.close();
    }
}
