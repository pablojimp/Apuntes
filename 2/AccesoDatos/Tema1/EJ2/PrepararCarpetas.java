package EJ2;

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
        Path datos = Path.of("datos");
        Path copias = datos.resolve("copias");
        try {
            Files.createDirectories(datos.getParent());
            Files.createDirectories(copias.getParent());
        } catch (Exception e) {
            System.err.println("No se pudo guardar: " + e.getMessage());
        }
    }
}
