// Desarrolla una clase ListarDatos que muestre solo los archivos ordinarios que hay directamente dentro

import java.nio.file.DirectoryStream;

// de datos .

import java.nio.file.Files;
import java.nio.file.Path;

// Abre el recorrido con Files.newDirectoryStream(...) y ciérralo mediante try-with-resources .
// Recorre las entradas con for (Path elemento : elementos) .
// Utiliza Files.isRegularFile(...) para no mostrar subcarpetas y getFileName() para imprimir
// únicamente el nombre de cada archivo.
// Comprueba: coloca dos archivos y una subcarpeta en datos . Deben mostrarse los dos archivos, no la
// carpeta. 
// Gestiona también el caso en el que datos no exista.F
public class ListarDatos {
    public static void main(String[] args) {
        Path ruta = Path.of("datos");
        if (Files.isDirectory(ruta)) {
            try (DirectoryStream<Path> elementos = Files.newDirectoryStream(ruta);) {
                for (Path elemento : elementos) {
                    if (Files.isRegularFile(elemento)) {
                        System.out.println(elemento.getFileName());
                    }
                }
            } catch (Exception e) {
                System.err.println("Error: " + e.getMessage());
            }

        } else {
            System.out.println("La ruta actual no existe");
        }
    }
}
