
import java.nio.file.Files;
import java.nio.file.Path;

// Programa una clase PrepararCarpetas que prepare la siguiente estructura de trabajo:
// Crea las carpetas datos y datos/copias mediante Files.createDirectories(...) .

// Crea los archivos vacíos datos/clubes.txt y datos/copias/respaldo.txt únicamente cuando aún no
// existan.
// Muestra para cada archivo si existe y cuál es su tamaño en bytes.
// Comprueba: ejecuta el programa dos veces. Después escribe
public class PrepararCarpetas {
    public static void main(String[] args) {
        Path rutaInicial = Path.of("datos", "copias");
        Path respaldo = rutaInicial.resolve("respaldo.txt");
        Path clubes = rutaInicial.getParent().resolve("clubes.txt");
        try {
            Files.createDirectories(rutaInicial.getParent());
            Files.createDirectories(rutaInicial);

            if (!Files.exists(clubes)) {
                Files.createFile(clubes);
            } else {
                System.out.println("Ya existe clubes.txt");
            }

            if (!Files.exists(respaldo)) {
                Files.createFile(respaldo);
            } else {
                System.out.println("Ya existe respaldo.txt");
            }

            System.out.println("Tamaño clubes.txt = " + Files.size(clubes));
            System.out.println("Tamaño respaldo.txt = " + Files.size(respaldo));

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
