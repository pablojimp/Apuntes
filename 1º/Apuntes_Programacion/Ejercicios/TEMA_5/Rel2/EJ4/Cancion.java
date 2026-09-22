package Apuntes.Apuntes_Programacion.Ejercicios.TEMA_5.Rel2.EJ4;

public class Cancion {

    private String titulo;
    private String artista;
    private int duracion;

    Cancion(String titulo, String artista, int duracion) {
        this.titulo = titulo;
        this.artista = artista;
        this.duracion = duracion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    @Override
    public String toString() {
        return titulo + " | " + artista + " | " + duracion;
    }

}
