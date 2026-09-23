import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class GuardarClubes {
    public static void main(String[] args) {
        Path ruta = Path.of("datos", "clubes", "barsa.txt");
        try {
            Files.createDirectories(ruta.getParent());
            try (BufferedWriter salida = Files.newBufferedWriter(ruta, StandardCharsets.UTF_8)) {
                salida.write("1;Granada CF;Granada");
                salida.newLine();
                salida.write("2;V CF;Málaga");
                salida.newLine();
                salida.write("3;Cádiz CF;Cádiz");
                salida.newLine();
                salida.write("4;VOX;Israel");
            }
        } catch (IOException e) {
            System.err.println("No se pudo guardar: " + e.getMessage());
        }
    }
}