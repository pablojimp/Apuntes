package ejercicios;

import java.util.Scanner;

public class sistemas_problemas {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numeroCapas = 0;
        int tamanioCabezeras = 0;
        double velocidad = 0;
        double tamanioMensaje = 0; 

        do {
            System.out.print("Introduce el numero de capas: ");
            try {
                numeroCapas = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                numeroCapas = -1;
                System.out.println("ERROR, debes poner un valor entero mayor que 1");
            }
        } while (numeroCapas < 1);

        do {
            System.out.print("Introduce el tamaño de las cabeceras: ");
            try {
                tamanioCabezeras = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                tamanioCabezeras = -1;
                System.out.println("ERROR, debes poner un valor entero mayor que 1");
            }
        } while (tamanioCabezeras < 1);

        System.out.print("Introduce la velocidad: ");
        velocidad = scanner.nextDouble();

        System.out.print("Introduce el tamaño del mensaje que quieres enviar: ");
        tamanioMensaje = scanner.nextDouble();



        System.out.println("");
        System.out.println("Porcentaje Ocupado por las Capas: " + ((numeroCapas*tamanioCabezeras)/(tamanioMensaje+(numeroCapas*tamanioCabezeras))));
        System.out.println((1-((numeroCapas*tamanioCabezeras)/(tamanioMensaje+(numeroCapas*tamanioCabezeras))))*velocidad);
        scanner.close();



    }

}
