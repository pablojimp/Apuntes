package Relacion2.EJ8;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class prestamos {
    public static void main(String[] args) {

        Path ruta = Path.of("prestamos.csv");
        Path rutaRespaldo = Path.of("backup", "datos", "prestamos.bak");
        boolean ejecutar = true;
        String opcionMenu;
        Scanner scanner = new Scanner(System.in);
        List<String> originales;
        List<String> actualizacion = new ArrayList<>();

        String[] obtenerCampos;
        String nuevoMaterial;
        String contadorID;
        String personaAlta;
        String materialAlta;

        while (ejecutar) {
            veficarSiExisteRuta(ruta);
            originales = obtenerListasOriginales(ruta);
            mostrarMenu();
            opcionMenu = pedirString("Introduce la opcion deseada: ", scanner);

            if (opcionMenu.equals("1")) {

                try {
                    // Limpio la actualizacion para que no interfiera con elementos
                    actualizacion = new ArrayList<>();
                    // Pido el nombre
                    personaAlta = pedirString("Introduce el nombre del cliente para el nuevo prestamo: ", scanner);
                    // Pido la materia
                    materialAlta = pedirString("Introduce la materia para " + personaAlta + " : ", scanner);
                    // Obtengo el ID
                    contadorID = obtenerID(originales);

                    for (String linea : originales) {
                        String[] camposOriginales = linea.split(";", -1);
                        if (camposOriginales.length == 3) {
                            actualizacion.add(camposOriginales[0] + ";" + camposOriginales[1] + ";" + camposOriginales[2]);
                        }
                    }
                    actualizacion.add(contadorID + ";" + personaAlta + ";" + materialAlta);
                    Files.write(ruta, actualizacion, StandardCharsets.UTF_8);
                    System.out.println("Registrado correctamente");
                } catch (IOException e) {
                    System.err.println("Ha ocurrido un error durante la operacion. Cancelando...");
                }
            }
            else if (opcionMenu.equals("2")) {
                mostrarTodos(originales);
            }
            else if (opcionMenu.equals("3")) {
                obtenerCampos = busquedaPorId(scanner, originales);
                if (obtenerCampos != null) {
                    System.out.println(obtenerCampos[0] + " -> " + obtenerCampos[1] + " (" + obtenerCampos[2] + ")");
                }
            }
            else if (opcionMenu.equals("4")) {
                actualizacion = new ArrayList<>();
                obtenerCampos = busquedaPorId(scanner, originales);

                if (obtenerCampos != null) {
                    nuevoMaterial = pedirString("Introduce el nuevo Material para ID: " + obtenerCampos[0] + " -> " + obtenerCampos[1]+ ": ", scanner);
                    obtenerCampos[2] = nuevoMaterial;

                    for (String linea : originales) {
                        String[] camposOriginales = linea.split(";", -1);
                        if (camposOriginales.length == 3 && camposOriginales[0].equals(obtenerCampos[0])) {
                            actualizacion.add(camposOriginales[0] + ";" + camposOriginales[1] + ";" + nuevoMaterial);
                        } else {
                            actualizacion.add(camposOriginales[0] + ";" + camposOriginales[1] + ";" + camposOriginales[2]);
                        }
                    }

                    try {
                        Files.write(ruta, actualizacion, StandardCharsets.UTF_8);
                        System.out.println("Registrado correctamente");
                    } catch (IOException e) {
                        System.err.println("Error al escribir la actualizacion");
                    }
                }
            }
            else if (opcionMenu.equals("5")) {
                obtenerCampos = busquedaPorId(scanner, originales);
                actualizacion = new ArrayList<>();
            
                if (obtenerCampos != null) {
                    
                    for (String linea : originales) {
                        String[] camposOriginales = linea.split(";", -1);
                        if (camposOriginales.length == 3 && !camposOriginales[0].equals(obtenerCampos[0])) {
                            actualizacion.add(camposOriginales[0] + ";" + camposOriginales[1] + ";" + camposOriginales[2]);
                        }
                    }
    
                    try {
                        Files.write(ruta, actualizacion, StandardCharsets.UTF_8);
                        System.out.println("Borrado correctamente");
                    } catch (IOException e) {
                        System.err.println("Error al escribir la actualizacion");
                    }
                }else{
                    System.err.println("No hemos sido capaces de encontrar el id");
                }

            }
            else if (opcionMenu.equals("6")) {
                crearBackup(ruta, rutaRespaldo);
            } 
            else if (opcionMenu.equals("7")) {
                restaurarBackup(rutaRespaldo, scanner, ruta);
            }
            else if(opcionMenu.equals("0")){
                ejecutar = false;
            }

        }

    }

    private static String obtenerID(List <String> originales) {
        String resultado;
        if (originales.size() <= 1) {
            resultado = "1";
        } else {
            String[] campos = originales.get(originales.size() - 1).split(";", -1);
            resultado = String.valueOf(Integer.parseInt(campos[0]) + 1);
        }
        return resultado;
    }
    private static String pedirString(String mensaje, Scanner lector) {
        System.out.print(mensaje);
        return lector.nextLine();
    }
    private static void restaurarBackup(Path rutaRespaldoArchivoPrincipal, Scanner lector, Path rutaArchivoPrincipal) {
        try {

            if (Files.notExists(rutaRespaldoArchivoPrincipal)) {
                System.out.println("No existe el archivo de backup invetario.");
            } else {

                List<String> rutaBakcup = Files.readAllLines(
                        rutaRespaldoArchivoPrincipal, StandardCharsets.UTF_8);
                boolean sobreEscribir = true;

                while (sobreEscribir) {
                    System.out.println("El archivo Backup quiere ser restaurado:" + rutaRespaldoArchivoPrincipal);
                    System.out.println("Introduce S/N para confirmar: ");
                    String opcionSobreescribir = lector.nextLine();

                    if (opcionSobreescribir.equals("S")) {
                        Files.write(rutaArchivoPrincipal, rutaBakcup, StandardCharsets.UTF_8);
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
            System.out.println("Error restaurando el backup");
        }
    }
    private static void crearBackup(Path rutaArchivoPrincipal, Path rutaRespaldoArchivoPrincipal) {
        try {
            Files.createDirectories(rutaRespaldoArchivoPrincipal.getParent());
            Files.copy(rutaArchivoPrincipal, rutaRespaldoArchivoPrincipal, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Copia creada: " + rutaRespaldoArchivoPrincipal.toAbsolutePath());
        } catch (IOException e) {
            System.err.println("Error al crear la copia de seguridad...");
        }
    }
    private static String[] busquedaPorId(Scanner lector, List<String> lineasOriginales) {
        boolean encontrado = false;
        System.out.print("Introduce un ID: ");
        String idBuscar = lector.nextLine();
        String[] camposDevolver = null;

        try {
            for (String linea : lineasOriginales) {
                String[] campos = linea.split(";", -1);
                if (campos.length == 3 && campos[0].equals(idBuscar)) {
                    encontrado = true;
                    camposDevolver = campos;
                }
            }
            if (!encontrado) {
                System.out.println("No hemos podido encontrar el id");
            }

        } catch (Exception e) {
            System.out.println("El id introducido no es un numero entero. Ejemplos: 1, 77, 67");
        }

        return camposDevolver;
    }
    private static List<String> obtenerListasOriginales(Path ruta) {

        List<String> lineasOriginales = new ArrayList<>();
        try {
            lineasOriginales = Files.readAllLines(ruta, StandardCharsets.UTF_8);
        } catch (IOException e) {
            System.err.println("No hay nada aqui...");
        }
        return lineasOriginales;
    }
    public static void veficarSiExisteRuta(Path ruta) {
        // Compruebo si existe o no la ruta
        if (Files.notExists(ruta)) {
            System.out.println("\nNo existe el archivo de prestamos.");
            // Intento crearlo con la cabezera
            try {
                Files.createFile(ruta);
                System.out.println("Creando archivo...");
                List<String> actualizacion = new ArrayList<>();
                actualizacion.add("id;persona;material");
                Files.write(ruta, actualizacion, StandardCharsets.UTF_8);

            } catch (Exception e) {
                System.err.println("No se a podido crear el archivo...");
            }
        }
    }
    public static void mostrarTodos(List<String> lineasOriginales) {

        for (int i = 1; i < lineasOriginales.size(); i++) {
            String[] campos = lineasOriginales.get(i).split(";", -1);
            System.out.println(campos[0] + " -> " + campos[1] + " (" + campos[2] + ")");
        }

    }
    public static void mostrarMenu() {
        System.out.println();
        System.out.println("1. Alta usuario");
        System.out.println("2. Mostrar usuarios");
        System.out.println("3. Busqueda por ID");
        System.out.println("4. Cambio de Material");
        System.out.println("5. Baja Usuario");
        System.out.println("6. Crea Copia Seguridad");
        System.out.println("7. Restaurar Copia seguridad");
        System.out.println("0. Salir");
    }

}

