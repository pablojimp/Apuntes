package Apuntes.Apuntes_Programacion.Ejercicios.TEMA_5.Examen;

import java.util.ArrayList;

import java.util.Scanner;

public class Examen {

    public static void mensajeNuevaLineaString(String stringMostrar) {
        System.out.println(stringMostrar);
    }

    public static void mensajeMismaLineaString(String stringMostrar) {
        System.out.print(stringMostrar);
    }

    public static int pedirRangoMenu(Scanner scanner, String textoMenuString, String textoOpcionString,
            String mensajeError, int minimoPosible, int maximoPosible) {

        int opcionMenu;
        do {
            mensajeNuevaLineaString(textoMenuString);
            mensajeMismaLineaString(textoOpcionString);
            try {
                opcionMenu = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                opcionMenu = minimoPosible - 1;
                mensajeNuevaLineaString(mensajeError);
            }
        } while (opcionMenu < minimoPosible || opcionMenu > maximoPosible);
        return opcionMenu;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Zoologico centralPark = new Zoologico();
        String codigoAnimal;
        int numeroAniadir;
        int numeroRestar;

        final String textoMenuOpciones = "1. Mostrar todos los animales\r\n" + //
                "2. Buscar un animal por código\r\n" + //
                "3. Agregar ejemplares a un animal\r\n" + //
                "4. Retirar ejemplares de un animal\r\n" + //
                "5. Eliminar un animal\r\n" + //
                "6. Salir";
        final String opcion = "Seleccione una opción: ";
        final String errorMenu = "Error, debes introducir un numero entero";

        int opcionMenu;
        boolean ejecutar = true;

        for (int i = 0; i < 1000; i++) {
            centralPark.agregarAnimal(new Animal(Faker.nombreAnimal(), Faker.cantidadAnimal(), Faker.precioAnimal(),Faker.codigoAnimal()));
        }
        while (ejecutar) {
            opcionMenu = pedirRangoMenu(scanner, textoMenuOpciones, opcion, errorMenu, 1, 6);
            if (opcionMenu == 1) {

                for (int i = 0; i < centralPark.getTodosLosAnimales().size(); i++) {
                    System.out.println(centralPark.getTodosLosAnimales().get(i));
                }

            } else if (opcionMenu == 2) {
                System.out.print("Introduce el codigo que quieres buscar: ");
                codigoAnimal = scanner.nextLine();
                if (centralPark.buscarPorCodigo(codigoAnimal) != null) {
                    System.out.println(centralPark.buscarPorCodigo(codigoAnimal));
                } else {
                    System.out.println("No hay Animales Registrados con ese codigo.");
                }
            } else if (opcionMenu == 3) {

                System.out.print("Introduce el codigo que quieres buscar: ");
                codigoAnimal = scanner.nextLine();
                System.out.print("Introduce el numero de ejemplares que quieres eliminar a tu animal: ");
                numeroAniadir = Integer.parseInt(scanner.nextLine());
                if (centralPark.buscarPorCodigo(codigoAnimal) != null) {
                    centralPark.aniadirEjemplares(numeroAniadir, codigoAnimal);
                } else {
                    System.out.println("No hay Animales Registrados con ese codigo.");
                }

            } else if (opcionMenu == 4) {
                System.out.print("Introduce el codigo que quieres buscar: ");
                codigoAnimal = scanner.nextLine();
                System.out.print("Introduce el numero que quieres añadir a tu animal: ");
                numeroRestar = Integer.parseInt(scanner.nextLine());
                int resultado = centralPark.retirarEjemplares(numeroRestar, codigoAnimal);
                if (resultado == -2) {
                    System.out.println("No hay animales registrados con ese codigo");
                } else if (resultado == -1) {
                    System.out.println(
                            "Hay menos animales de los que quieres eliminar, el maximo que puedes eliminar son: "
                                    + centralPark.buscarPorCodigo(codigoAnimal).getCantidad());
                } else {
                    System.out.println("Ejemplares retirados correctamente.");
                }

            } else if (opcionMenu == 5) {
                System.out.print("Introduce el codigo del animal a eliminar: ");
                codigoAnimal = scanner.nextLine();
                int resultado = centralPark.retirarAnimal(codigoAnimal);
                if (resultado == -2) {
                    System.out.println("No hay animales registrados con ese codigo.");
                } else if (resultado == -1) {
                    System.out.println("No se puede eliminar, el animal aún tiene ejemplares.");
                } else {
                    System.out.println("Animal eliminado correctamente.");
                }
            }

            else {
                ejecutar = false;
            }
        }
    }
}
