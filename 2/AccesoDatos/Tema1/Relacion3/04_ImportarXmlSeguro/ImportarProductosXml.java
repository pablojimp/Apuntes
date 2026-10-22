import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ImportarProductosXml {

    public static void main(String[] args) {

        Path archivo = Path.of("datos", "productos_correctos.xml");

        List<Producto> productosActuales = new ArrayList<>();
        productosActuales.add(new Producto(99, "Producto existente", 10.0, 1));

        // TODO 1: comprobar Files.exists(...).
        // TODO 2: configurar DocumentBuilderFactory desactivando DTD y entidades externas.
        // TODO 3: leer y validar todo en una lista temporal.
        // TODO 4: comprobar IDs duplicados.
        // TODO 5: sustituir productosActuales solo si TODO el XML es válido.
    }
}
