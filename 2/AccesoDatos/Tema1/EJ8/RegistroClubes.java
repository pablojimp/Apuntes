package EJ8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Scanner;

public class RegistroClubes {

    public static void main(String[] args) {

        Path ruta = Path.of("datos", "clubes.txt");

        Scanner sc = new Scanner(System.in);

        int id = 0;
        String nombre = "";
        String ciudad = "";
        boolean cogerDato = true;
        ArrayList<Integer> todasLasId = new ArrayList<>();
        ArrayList<String> todosLosNombres = new ArrayList<>();
        ArrayList<String> todasLasCiudades = new ArrayList<>();

        try {
            // Crear la carpeta datos si no existe
            Files.createDirectories(ruta.getParent());

            while (cogerDato) {
                // Pedir el ID
                System.out.print("Introduce el id: ");

                while (!sc.hasNextInt()) {
                    System.out.println("Error: debes introducir un número entero.");
                    sc.next();
                    System.out.print("Introduce el id: ");
                }

                id = sc.nextInt();
                if (id == -1) {
                    break;
                }

                sc.nextLine(); // Consumir el salto de línea pendiente

                // Pedir el nombre
                System.out.print("Introduce el nombre: ");
                nombre = sc.nextLine();

                // Pedir la ciudad
                System.out.print("Introduce la ciudad: ");
                ciudad = sc.nextLine();

                todasLasId.add(id);
                todosLosNombres.add(nombre);
                todasLasCiudades.add(ciudad);

            }

            // Añadir el nuevo registro al fichero
            try (BufferedWriter salida = Files.newBufferedWriter(
                    ruta,
                    StandardCharsets.UTF_8,
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND)) {

                for (int i = 0; i < todasLasId.size(); i++) {

                    salida.write(todasLasId.get(i) + ";" + todosLosNombres.get(i) + ";" + todasLasCiudades.get(i));
                    salida.newLine();
                }

            }

            // Leer y mostrar todos los registros
            System.out.println("\nContenido del fichero:");

            try (BufferedReader entrada = Files.newBufferedReader(
                    ruta,
                    StandardCharsets.UTF_8)) {

                String linea;

                while ((linea = entrada.readLine()) != null) {
                    System.out.println(linea);
                }
            }

            sc.close();
        } catch (IOException e) {
            System.err.println("Error de entrada/salida: " + e.getMessage());
        }
    }
}