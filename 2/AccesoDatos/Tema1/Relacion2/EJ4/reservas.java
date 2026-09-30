package Relacion2.EJ4;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class reservas {
    public static void main(String[] args) {

        Path ruta = Path.of("reservas.csv");
        String idBuscar = null;
        Scanner scanner = new Scanner(System.in);
        boolean encontrado = false;
        int id;

        try {

            if (Files.notExists(ruta)) {
                System.out.println("No existe el archivo de invetario.");
                return;
            }

            List<String> originales = Files.readAllLines(
                    ruta, StandardCharsets.UTF_8);

            List<String> actualizacion = new ArrayList<>();

            System.out.print("Introduce un ID para cancelar la reserva: ");
            idBuscar = scanner.nextLine();

            try {
                id = Integer.parseInt(idBuscar);
                for (String linea : originales) {
                    String[] campos = linea.split(";", -1);
                    if (campos.length == 3 && campos[0].equals(idBuscar)) {
                        encontrado = true;
                    } else {
                        actualizacion.add(linea);
                    }
                }

                if (encontrado) {
                    Files.write(ruta, actualizacion, StandardCharsets.UTF_8);
                    System.out.println("Reserva Eliminada");
                } else {
                    System.out.println("No existe el id seleccionado.");
                }

            } catch (Exception e) {
                System.out.println("El ID introducido no es un numero entero. Ejemplos: 1, 77, 67");
            }

        } catch (IOException e) {
            System.err.println("No se pudo modificar: " + e.getMessage());
        }

        scanner.close();

    }
}
