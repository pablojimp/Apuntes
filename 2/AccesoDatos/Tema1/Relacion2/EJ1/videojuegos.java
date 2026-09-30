package Relacion2.EJ1;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class videojuegos {
    public static void main(String[] args) {
        Path ruta = Path.of("videojuegos.csv");
        try {
            if (Files.notExists(ruta)) {
                System.out.println("No existe el archivo de los videojuegos.");
                return;
            } else {
                List<String> originales = Files.readAllLines(
                        ruta, StandardCharsets.UTF_8);

                for (String linea : originales) {
                    String[] campos = linea.split(";", -1);
                    if (campos.length == 3) {
                        try {
                            int id = Integer.parseInt(campos[0]);
                            String nombre = campos[1];
                            String ciudad = campos[2];
                            System.out.println(id + " -> " + nombre + " (" + ciudad + ")");
                        } catch (NumberFormatException e) {
                            System.out.println("El ID no contiene un número válido.");
                        }
                    }
                }

            }
        }

        catch (Exception e) {
            System.err.println("No se pudo modificar: " + e.getMessage());
        }
    }
}
