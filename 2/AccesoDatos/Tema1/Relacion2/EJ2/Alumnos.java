package Relacion2.EJ2;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Alumnos {
    public static void main(String[] args) {
        Path ruta = Path.of("alumnos.csv");
        String idBuscar = null;
        Scanner scanner = new Scanner(System.in);
        int id;
        boolean encontrado = false;

        try {

            if (Files.notExists(ruta)) {
                System.out.println("No existe el archivo de alumnos.");
                return;
            }
            List<String> originales = Files.readAllLines(
                    ruta, StandardCharsets.UTF_8);

            System.out.print("Introduce un ID: ");
            idBuscar = scanner.nextLine();

            try {
                id = Integer.parseInt(idBuscar);
                for (String linea : originales) {
                    String[] campos = linea.split(";", -1);
                    if (campos.length == 3 && campos[0].equals(idBuscar)) {
                        String nombre = campos[1];
                        String ciudad = campos[2];
                        System.out.println(id + " -> " + nombre + " (" + ciudad + ")");
                        encontrado = true;
                    }
                }
                if (!encontrado) {
                    System.out.println("No hemos podido encontrar el id");
                }

            } catch (Exception e) {
                System.out.println("El id introducido no es un numero entero. Ejemplos: 1, 77, 67");
            }

        } catch (IOException e) {
            System.err.println("No se pudo modificar: " + e.getMessage());
        }

        scanner.close();
    }
}