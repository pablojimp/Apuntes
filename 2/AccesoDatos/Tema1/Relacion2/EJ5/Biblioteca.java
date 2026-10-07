package Relacion2.EJ5;
/*
 * 05. ALTAS DE BIBLIOTECA SIN DUPLICADOS
 * Apartado 4.3 · Validación y control de duplicados
 *
 * Archivo: biblioteca.csv
 *
 * Tareas:
 * 1. Añadir nuevos libros al final de biblioteca.csv.
 * 2. No permitir IDs repetidos.
 * 3. No permitir títulos repetidos ignorando:
 *    - Mayúsculas/minúsculas.
 *    - Espacios al principio y al final (trim()).
 *    - Comparar títulos con equalsIgnoreCase().
 * 4. Rechazar:
 *    - ID no numérico.
 *    - ID menor o igual que 0.
 *    - Título vacío.
 *    - Autor vacío.
 * 5. Solo añadir el libro si TODOS los datos son válidos.
 *
 * COMPROBACIÓN:
 * - Intentar añadir: id=8, titulo=" NADA "
 * - Debe detectarse como duplicado de "NADA".
 *
 * DESPUÉS:
 * - Añadir un libro realmente nuevo.
 * - Comprobar que se añade correctamente al final del fichero.
 */

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Biblioteca {
    public static void main(String[] args) {
        Path ruta = Path.of("biblioteca.csv");
        Scanner scanner = new Scanner(System.in);
        String idBuscar = null;
        String nombreLibroNuevo = null;
        String autorLibroNuevo = null;
        int id;
        boolean encontrado = false;
        boolean nuevaLinea = true;

        try {

            if (Files.notExists(ruta)) {
                System.out.println("No existe el archivo de invetario.");
                return;
            }

            List<String> originales = Files.readAllLines(ruta, StandardCharsets.UTF_8);
            List<String> nuevas = new ArrayList<>();

            System.out.print("Introduce un ID: ");
            idBuscar = scanner.nextLine();

            try {

                id = Integer.parseInt(idBuscar);
                for (String linea : originales) {
                    String[] campos = linea.split(";", -1);

                    if (campos.length == 3 && campos[0].equals(idBuscar)) {
                        encontrado = true;
                    } else {
                        nuevas.add(linea);
                    }

                }

                if (encontrado) {
                    System.err.println("El id a registrar ya lo tenemos insertado, no se han realizado cambios");

                } else {
                    System.out.print("Introduce el nombre: ");
                    nombreLibroNuevo = scanner.nextLine();

                    System.out.print("Introduce un autor: ");
                    autorLibroNuevo = scanner.nextLine();

                    nuevas.add(idBuscar + ";" + nombreLibroNuevo + ";" + autorLibroNuevo);
                    Files.write(ruta, nuevas, StandardCharsets.UTF_8);
                    System.out.println("Archivo modificado");

                }

            } catch (Exception e) {

                System.err.println("El ID introducido no es un numero entero. Ejemplos: 1, 77, 67");
            }

        } catch (Exception e) {
            System.err.println("No se pudo modificar: " + e.getMessage());
        }
    }

}
