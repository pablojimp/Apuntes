package ejercicios.UD1.PT1;

import java.util.Scanner;

public class PT1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numeroEncargos;
        int stockMadera;
        double stockAcero;
        int contador = 1;
        int maderaPedido;
        double aceroPedido;
        String producto = "";
        int unidades;
        double precioPedido = 0;
        boolean ejecutar = true;
        int maderaAcumulada = 0;
        double aceroAcumulado = 0;

        // Precios Flecha
        final int FLECHAMADERA = 1;
        final double FLECHACERO = 0.05;
        final int FLECHAMONEDAS = 2;
        // Precios Escudo
        final int ESCUDOMADERA = 3;
        final double ESCUDOACERO = 1.5;
        final int ESCUDOMONEDAS = 30;
        // Precio Espada
        final int ESPADAMADERA = 1;
        final double ESPADACERO = 1.2;
        final int ESPADAMONEDAS = 25;

        // Pido el numero de encargos
        do {
            try {
                System.out.print("¿Cuantos encargos piensas realizar? (Int): ");
                numeroEncargos = Integer.parseInt(scanner.nextLine()) ;
            } catch (Exception e) {
                numeroEncargos = 0;
                System.out.println("ERROR al leer entero");
            }
        } while(numeroEncargos <= 0);

        // Pido el stock de Madera
        System.out.print("Introduce el stock de Madera: ");
        stockMadera = scanner.nextInt();
        while (stockMadera < 0) {
            System.out.println("Error Al introducir el stock de madera debe ser un numero mayor que 0");
            System.out.print("Introduce el stock de Madera: ");
            numeroEncargos = scanner.nextInt();
        }

        // Pido el stock de Acero
        System.out.print("Introduce el stock de Acero: ");
        stockAcero = scanner.nextDouble();
        while (stockAcero < 0) {
            System.out.println("Error Al introducir el stock de Acero debe ser un numero mayor que 0");
            System.out.print("Introduce el stock de Acero: ");
            numeroEncargos = scanner.nextInt();
        }
        scanner.nextLine();
        while (ejecutar) {

            System.out.println("--- Encargo " + contador + " ---");

            // Nombre Articulo

            System.out.print("Articulo (flecha / escudo / espada): ");
            producto = scanner.next();
            producto.toLowerCase();
            while (!producto.equals("flecha") && !producto.equals("escudo") && !producto.equals("espada")) {
                System.out.print("Articulo: ");
                producto = scanner.next();
                producto.toLowerCase();
            }
            scanner.nextLine();

            // Unidades Articulo

            System.out.print("Unidades: ");
            unidades = scanner.nextInt();
            while (unidades < 0) {
                System.out.print("Unidades: ");
                unidades = scanner.nextInt();
            }

            if (producto.equals("flecha")) {
                precioPedido = FLECHAMONEDAS * unidades;
                maderaPedido = FLECHAMADERA * unidades;
                aceroPedido = FLECHACERO * unidades;

                if (maderaPedido > stockMadera && aceroPedido > stockAcero) {
                    ejecutar = false;
                    contador--;
                } else {
                    stockMadera -= maderaPedido;
                    stockAcero -= aceroPedido;
                    maderaAcumulada += maderaPedido;
                    aceroAcumulado += aceroPedido;
                }
            } else if (producto.equals("escudo")) {
                precioPedido = ESCUDOMONEDAS * unidades;
                maderaPedido = ESCUDOMADERA * unidades;
                aceroPedido = ESCUDOACERO * unidades;
                if (maderaPedido > stockMadera && aceroPedido > stockAcero) {
                    ejecutar = false;
                    contador--;
                } else {
                    stockMadera -= maderaPedido;
                    stockAcero -= aceroPedido;
                    maderaAcumulada += maderaPedido;
                    aceroAcumulado += aceroPedido;
                }
            } else {
                precioPedido = ESPADAMONEDAS * unidades;
                maderaPedido = ESPADAMADERA * unidades;
                aceroPedido = ESPADACERO * unidades;
                if (maderaPedido > stockMadera && aceroPedido > stockAcero) {
                    ejecutar = false;
                    contador--;
                } else {
                    stockMadera -= maderaPedido;
                    stockAcero -= aceroPedido;
                    maderaAcumulada += maderaPedido;
                    aceroAcumulado += aceroPedido;
                }
            }

            // Verficacion de si el programa continua y te dice el resumen o si por el
            // contrario dice que no hay mas material
            if (ejecutar) {
                System.out.println("Articulo: " + producto + " || Unidades :" + unidades + " || Precio: " + precioPedido);
                System.out.println("Madera Gastada: " + maderaPedido + " | Acumulada: " + maderaAcumulada);
                System.out.println("Acero Gastado: " + aceroPedido + " | Acumulado " + aceroAcumulado);
                contador++;
            } else {
                System.out.println("No hay suficiente material para el pedido");
            }

            // Verifica que se haya cumplido el numero de encargos
            if (numeroEncargos == contador) {
                ejecutar = false;
            }
        }
        // Resumen final
        System.out.println("=== RESUMEN FINAL === \nNºEncargos: " + contador + " de " + numeroEncargos + "\n ");
        scanner.close();
    }
}
