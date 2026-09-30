package EJ8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class RegistroClubes {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Path ruta = Path.of("datos", "clubes.csv");

        try {
            // Crear la carpeta datos si no existe
            Files.createDirectories(ruta.getParent());

            try (BufferedWriter escritor = Files.newBufferedWriter(ruta, StandardCharsets.UTF_8,
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND)) {

                String id = "";

                while (!id.equals("-1")) {
                    System.out.print("Introduce el identificador del club (-1 para terminar): ");
                    id = sc.nextLine();

                    if (!id.equals("-1")) {
                        System.out.print("Introduce el nombre del club: ");
                        String nombre = sc.nextLine();

                        System.out.print("Introduce la ciudad del club: ");
                        String ciudad = sc.nextLine();

                        escritor.write(id + ";" + nombre + ";" + ciudad);
                        escritor.newLine();

                    }
                }

            }

            try (BufferedReader lector = Files.newBufferedReader(ruta, StandardCharsets.UTF_8)) {
                String linea;

                while ((linea = lector.readLine()) != null) {
                    System.out.println(linea);
                }
            }
        } catch (Exception e) {
            System.out.println("Se ha producido un error de entrada/salida:");
            System.out.println(e.getMessage());
        }

        sc.close();
    }
}