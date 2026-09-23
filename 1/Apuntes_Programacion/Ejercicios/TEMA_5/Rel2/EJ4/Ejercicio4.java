package Apuntes.Apuntes_Programacion.Ejercicios.TEMA_5.Rel2.EJ4;

import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio4 {
    // ### Ejercicio 4: Playlist y Canciones
    // En el `main`, implementa un **menú** para agregar y mostrar canciones. Usa la
    // clase `Faker` para generar 100 canciones.

    public static void mensajeNuevaLineaString(String stringMostrar) {
        System.out.println(stringMostrar);
    }

    public static int pedirNumeroEnteroConControlErrores(Scanner scanner, int numeroMinimo, String mensajePedir,
            String mensajError) {
        int variableRellenar;
        do {
            mensajeMismaLineaString(mensajePedir);
            try {
                variableRellenar = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                variableRellenar = numeroMinimo - 1;
                mensajeMismaLineaString(mensajError);
            }
        } while (variableRellenar < numeroMinimo);
        return variableRellenar;
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
        int rangoMenu;
        Scanner scanner = new Scanner(System.in);
        int numeroCanciones;
        int totalDuracionCanciones;
        Playlist playlist = new Playlist();

        do {
            rangoMenu = pedirRangoMenu(
                    scanner,
                    "\n1. Agregar Canciones\n2. Mostrar Canciones\n3. Mostrar Duración\n4. Salir",
                    "Selecciona una opción: ",
                    "Error: opción no válida",
                    1, 4);

            if (rangoMenu == 1) {
                numeroCanciones = pedirNumeroEnteroConControlErrores(
                        scanner, 1,
                        "Introduce el número de canciones: ",
                        "Error: debe ser mínimo 1");
                playlist.cancionesAleatorios(numeroCanciones);
                mensajeNuevaLineaString("Se han añadido " + numeroCanciones + " canciones.");

            } else if (rangoMenu == 2) {
                playlist.mostrarCanciones();

            } else if (rangoMenu == 3) {
                totalDuracionCanciones = playlist.mostrarDuracion();
                mensajeNuevaLineaString("Duración total: " + totalDuracionCanciones + " segundos");

            }

        } while (rangoMenu != 4);

        mensajeNuevaLineaString("¡Hasta luego!");
        scanner.close();

    }
}