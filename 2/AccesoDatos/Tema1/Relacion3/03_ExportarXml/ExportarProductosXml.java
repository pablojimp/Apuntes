import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class ExportarProductosXml {

    public static void main(String[] args) {

        Path archivo = Path.of("datos", "productos.xml");
        List<Producto> productos = List.of(
                new Producto(1, "Ratón óptico", 24.50, 12),
                new Producto(2, "Teclado & ratón", 69.90, 7),
                new Producto(3, "Monitor", 199.00, 5),
                new Producto(4, "Auriculares", 35.00, 9));

        try {
            Files.createDirectories(archivo.getParent());
            Document documento = DocumentBuilderFactory.newInstance()
                    .newDocumentBuilder().newDocument();
            Element raiz = documento.createElement("productos");
            documento.appendChild(raiz);

            for (Producto producto : productos) {
                Element hijo = documento.createElement("producto");
                hijo.setAttribute("id", String.valueOf(producto.getId()));
                raiz.appendChild(hijo);
                crearHijo(documento, hijo, "nombre", producto.getNombre());
                crearHijo(documento, hijo, "precio", String.valueOf(producto.getPrecio()));
                crearHijo(documento, hijo, "stock", String.valueOf(producto.getStock()));
            }

            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
            transformer.transform(new DOMSource(documento), new StreamResult(archivo.toFile()));
            System.out.println("Exportados " + productos.size() + " productos a " + archivo);
        } catch (Exception e) {
            System.out.println("Error exportando XML: " + e.getMessage());
        }
    }

    private static void crearHijo(Document doc, Element padre, String nombre, String contenido) {
        Element hijo = doc.createElement(nombre);
        hijo.setTextContent(contenido); // Escapa caracteres especiales como &.
        padre.appendChild(hijo);
    }

}
