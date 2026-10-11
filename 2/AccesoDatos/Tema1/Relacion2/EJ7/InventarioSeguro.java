import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InventarioSeguro {

    public static void main(String[] args) {

        Path ruta = Path.of("inventario.csv");
        Path rutaRespaldo = Path.of("backup", "datos", "inventario.bak");
        String idBuscar = null;
        String stockNuevo = null;
        Scanner scanner = new Scanner(System.in);
        boolean encontrado = false;
        int id, stock;
        boolean ejecutar = true;
        boolean sobreEscribir = true;
        String opcionMenu;
        String opcionSobreescribir;

        while (ejecutar) {
            mostrarMenu();
            System.out.print("Introduce la opcion que quieras ejecutar: ");
            opcionMenu = scanner.nextLine();

            if (opcionMenu.equals("1")) {

                try {

                    if (Files.notExists(ruta)) {
                        System.out.println("No existe el archivo de invetario.");
                        return;
                    }

                    List<String> originales = Files.readAllLines(
                            ruta, StandardCharsets.UTF_8);

                    List<String> actualizacion = new ArrayList<>();

                    System.out.print("Introduce un ID: ");
                    idBuscar = scanner.nextLine();

                    System.out.print("Introduce el nuevo Stock: ");
                    stockNuevo = scanner.nextLine();

                    try {
                        id = Integer.parseInt(idBuscar);

                        stock = Integer.parseInt(stockNuevo);

                        for (String linea : originales) {

                            String[] campos = linea.split(";", -1);

                            if (campos.length == 3 && campos[0].equals(idBuscar)) {

                                actualizacion.add(campos[0] + ";" + campos[1] + ";" + stock);

                                encontrado = true;
                            } else {

                                actualizacion.add(linea);
                            }
                        }

                        if (encontrado) {

                            Files.createDirectories(rutaRespaldo.getParent());

                            Files.copy(ruta, rutaRespaldo, StandardCopyOption.REPLACE_EXISTING);

                            System.out.println("Copia creada: " + rutaRespaldo.toAbsolutePath());

                            Files.write(ruta, actualizacion, StandardCharsets.UTF_8);

                            System.out.println("Stock Actualizado");

                        } else {

                            System.out.println("No existe el id seleccionado.");
                        }

                    } catch (Exception e) {
                        System.out
                                .println("El ID o Stock nuevo introducido no es un numero entero. Ejemplos: 1, 77, 67");
                    }

                } catch (IOException e) {

                    System.err.println("No se pudo modificar: " + e.getMessage());
                }

            } else if (opcionMenu.equals("2")) {

                try {

                    if (Files.notExists(rutaRespaldo)) {
                        System.out.println("No existe el archivo de backup invetario.");
                    } else {
                        List<String> rutaBakcup = Files.readAllLines(
                                rutaRespaldo, StandardCharsets.UTF_8);
                        sobreEscribir = true;
                        while (sobreEscribir) {
                            System.out.println("El archivo Backup quiere ser restaurado:" + rutaRespaldo);
                            System.out.println("Introduce S/N para confirmar: ");
                            opcionSobreescribir = scanner.nextLine();

                            if (opcionSobreescribir.equals("S")) {
                                Files.write(ruta, rutaBakcup, StandardCharsets.UTF_8);
                                System.out.println("Archivo Actualizado...");
                                sobreEscribir = false;
                            } else if (opcionSobreescribir.equals("N")) {
                                System.out.println("Cancelando operacion...");
                                sobreEscribir = false;
                            } else {
                                System.out.println("Escribe S/N");
                            }
                        }
                    }
                } catch (Exception e) {
                    System.out.println("Error");
                }

            } else if (opcionMenu.equals("0")) {
                ejecutar = false;
            } else {
                System.out.println("Introduce una opcion valida");
            }

        }

        scanner.close();
    }

    public static void mostrarMenu() {
        System.out.println();
        System.out.println("1. Modificar stock");
        System.out.println("2. Restaurar copia");
        System.out.println("0. Salir");
    }
}
