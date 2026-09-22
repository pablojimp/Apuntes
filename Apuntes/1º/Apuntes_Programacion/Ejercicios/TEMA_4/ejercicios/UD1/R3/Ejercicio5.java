package ejercicios.UD1.R3;

import java.util.Scanner;

public class Ejercicio5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numeroUsuario;

        // Leer datos del usuario
        System.out.print("Ingresa tu numero: ");
        numeroUsuario = scanner.nextInt(); 
        scanner.close();

        if (numeroUsuario >= 10 && numeroUsuario <= 20) {
            System.out.println("El numero esta entre 10 y 20");
        }else{
            System.out.println("No esta entre 10 y 20");
        }
    }
}
