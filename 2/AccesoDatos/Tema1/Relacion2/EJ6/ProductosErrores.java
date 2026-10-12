package Relacion2.EJ6;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ProductosErrores {
    public static void main(String[] args) {
        Path rutaErrores = Path.of("productos_errores.csv");
        Path rutaValidos = Path.of("productos_validos.csv");

        try {
            List<String> originales = Files.readAllLines(rutaErrores, StandardCharsets.UTF_8);
            List<String> validos = new ArrayList<>();
            //ArrayL para guardar id comparar y no duplicar
            List<String> idsAceptados = new ArrayList<>(); 

            validos.add(originales.get(0));

            for (int i = 1; i < originales.size(); i++) {
                String linea = originales.get(i);
                String[] campos = linea.split(";", -1);

                if (campos.length != 3) {
                    System.out.println("Linea " + i + " no tiene 3 campos");
                    continue;
                }

                try {
                    int id = Integer.parseInt(campos[0]);
                    int stock = Integer.parseInt(campos[2]);
                    String nombre = campos[1];

                    if (id <= 0 || stock < 0 || nombre.trim().isEmpty()) {
                        System.out.println("Datos incorrectos");
                    } else if (idsAceptados.contains(campos[0])) {
                        System.out.println("Linea ignorada");
                    } else {
                        validos.add(linea);
                        idsAceptados.add(campos[0]);
                    }
                } catch (NumberFormatException e) {
                    System.err.println("El ID debería ser un numero para la linea " + i);
                }
            }

            Files.write(rutaValidos, validos, StandardCharsets.UTF_8);
            System.out.println("Fichero guardado solo con los datos buenos.");

        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}