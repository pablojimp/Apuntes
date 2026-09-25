
import java.nio.file.Files;
import java.nio.file.Path;

public class InspectorFichero {
    public static void main(String[] args) {
        Path ruta = Path.of("datos", "clubes.txt");
        System.out.println("Ruta Absoluta : " + ruta.toAbsolutePath());

        try {
            if (!Files.exists(ruta)) {
                System.out.println("Este Archivo todavia no existe");
            } else {
                System.out.println("Este Archivo existe y pesa: " + Files.size(ruta) + "bytes");

            }

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
