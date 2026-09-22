package Apuntes.Apuntes_Programacion.Ejercicios.TEMA_5.Rel2.EJ2;

//Crea una clase Libro con atributos id, titulo, autor, sinopsis y disponible (booleano). Implementa los métodos get y set para cada atributo, así como el método toString()
public class Libro {
    private String id;
    private String titulo;
    private String autor;
    private String sipnosis;
    private boolean disponible;

    Libro(String id, String titulo, String autor, String sipnosis, boolean disponible) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.sipnosis = sipnosis;
        this.disponible = disponible;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getSipnosis() {
        return sipnosis;
    }

    public void setSipnosis(String sipnosis) {
        this.sipnosis = sipnosis;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        if (isDisponible()) {
            this.disponible = disponible;
        }
    }

    @Override
    public String toString() {
        String existeLibro = (this.isDisponible()) ? "Esta en el catalogo" : "no esta en el catalogo";
        return "El titulo del libro que estas mirando es: "+titulo+", Su autor es: "+autor+" y su sipnosis: "+sipnosis+" el libro"+existeLibro + "y su id es: " + id;
    }

}
