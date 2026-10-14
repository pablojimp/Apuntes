import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ActualizarEmpleadosBinario {

    public static void main(String[] args) {

        Path archivo = Path.of("datos", "empleados.dat");
        Scanner teclado = new Scanner(System.in);
        veficarSiExisteRuta(archivo);
        List<?> listaComprobada = obtenerListasOriginales(archivo);
        busquedaPorId(teclado, listaComprobada, archivo); 
        teclado.close();
    }

    private static List<?> obtenerListasOriginales(Path ruta) {

        List<?> lineasOriginales = new ArrayList<>();
        try (ObjectInputStream entrada = new ObjectInputStream(
                Files.newInputStream(ruta))) {
            Object dato = entrada.readObject();
            if (!(dato instanceof List<?> lista)) {
                System.out.println("El archivo no contiene una lista.");
    
            }else{
                lineasOriginales = lista;
            }

        } catch (IOException | ClassNotFoundException e) {
            System.err.println("No se pudo recuperar: " + e.getMessage());
        }
        return lineasOriginales;
    }
    private static void escribirArchivo(List<?> lista, Path ruta){
                try {
            try (ObjectOutputStream salida = new ObjectOutputStream(
                    Files.newOutputStream(ruta))) {
                salida.writeObject(lista);
            }
            System.out.println("Empleados guardados en " + ruta);
        } catch (IOException e) {
            System.err.println("Error al guardar: " + e.getMessage());
        }
    }
    private static List<Empleado> busquedaPorId(Scanner lector, List<?> lista, Path ruta) {
        boolean encontrado = false;
        List<Empleado> listaActualizada = new ArrayList<>();
        System.out.print("Introduce un ID: ");
        String idBuscar = lector.nextLine();
        System.out.println("Introduce el departamento que tendra el ID -> " + idBuscar + ": ");
        String departamento = lector.nextLine();

        try {
            for (Object elemento : lista) {
                if (!(elemento instanceof Empleado empleado)) {
                    System.out.println("Se ha encontrado un dato inesperado.");
                } else {
                    String idComparar = String.valueOf(empleado.getId());
                    if (idBuscar.equals(idComparar)) {
                        encontrado = true;
                        empleado.setDepartamento(departamento);
                        listaActualizada.add(empleado);
                    }else{
                        listaActualizada.add(empleado);
                    }
                }
            }
            if (!encontrado) {
                System.out.println("No hemos podido encontrar el id, no se han hecho cambios");
            }else{
                escribirArchivo(listaActualizada, ruta);
            }

        } catch (Exception e) {
            System.out.println("El id introducido no es un numero entero. Ejemplos: 1, 77, 67");
        }

        return listaActualizada;
    }
    public static void veficarSiExisteRuta(Path ruta) {
        // Compruebo si existe o no la ruta
        if (Files.notExists(ruta)) {
            System.out.println("\nNo existe el archivo de datos.");
            // Intento crearlo
            try {
                System.out.println("Creando archivo...");
                Files.createDirectory(ruta.getParent());
                Files.createFile(ruta);

            } catch (Exception e) {
                System.err.println("No se a podido crear el archivo.");
            }
        } else {
            System.out.println("Esta ruta existe: " + ruta.toAbsolutePath());
        }
    }
}
