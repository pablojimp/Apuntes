import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class GuardarEmpleadosBinario {

    public static void main(String[] args) {
        Path ruta = Path.of("datos", "empleados.dat");
        List<Empleado> empleados = new ArrayList<>();
        empleados.add(new Empleado(1, "Carlos", "Recursos Humanos"));
        empleados.add(new Empleado(2, "Pablo", "Progamacion"));
        empleados.add(new Empleado(3, "Maria", "Contabilidad"));
        veficarSiExisteRuta(ruta);

        try {
            try (ObjectOutputStream salida = new ObjectOutputStream(
                    Files.newOutputStream(ruta))) {
                salida.writeObject(empleados);
            }
            System.out.println("Empleados guardados en " + ruta);
        } catch (IOException e) {
            System.err.println("Error al guardar: " + e.getMessage());
        }

    }

    public static void veficarSiExisteRuta(Path ruta) {
        // Compruebo si existe o no la ruta
        if (Files.notExists(ruta)) {
            System.out.println("\nNo existe el archivo de datos.");
            // Intento crearlo
            try {
                Files.createDirectory(ruta.getParent());
                Files.createFile(ruta);
                System.out.println("Creando archivo...");

            } catch (Exception e) {
                System.err.println("No se a podido crear el archivo...");
            }
        }
    }
}
