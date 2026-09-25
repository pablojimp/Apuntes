
import java.nio.file.Path;

// Crea una clase RutasProyecto que represente las rutas de la carpeta datos , el fichero clubes.txt y una
// subcarpeta llamada copias . No debes crear todavía ningún archivo ni carpeta.
// Construye la ruta de datos con Path.of(...) .

// Obtén las otras dos rutas utilizando resolve(...) .
// Muestra en consola las tres rutas relativas y sus correspondientes rutas absolutas con
// toAbsolutePath() .
// Comprueba: observa que construir o mostrar una ruta no crea por sí mismo un archivo. Ejecuta la clase
// desde el directorio de trabajo de tu proyecto.
public class RutasProyecto {
    public static void main(String[] args) {

        Path rutaDatos = Path.of("datos");
        Path rutaClubes = rutaDatos.resolve("clubes.txt");
        Path rutaCopias = rutaDatos.resolve("copia");

        System.out.println(
                "Ruta Datos Relativa: \n" + rutaDatos + " \nRuta Datos Absoluta: \n" + rutaDatos.toAbsolutePath());
        System.out.println(
                "Ruta Clubes Relativa: \n" + rutaClubes + " \nRuta Clubes Absoluta: \n" + rutaClubes.toAbsolutePath());
        System.out.println(
                "Ruta Copias Relativa: \n" + rutaCopias + " \nRuta Copias Absoluta: \n" + rutaCopias.toAbsolutePath());
    }

}
