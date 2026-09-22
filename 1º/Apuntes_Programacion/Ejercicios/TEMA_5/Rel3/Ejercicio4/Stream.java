package Apuntes.Apuntes_Programacion.Ejercicios.TEMA_5.Rel3.Ejercicio4;

public class Stream {

    static int numeroStreams;
    int id;
    Streamer streamer;
    String titulo;
    int duracionMin;
    String categoria;
    int mediaViewers;
    String fecha;
    Boolean activo;

    public Stream(int id, Streamer streamer, String titulo, int duracionMin, String categoria, int mediaViewers,
            String fecha, Boolean activo) {
        asignarID();
        this.streamer = streamer;
        this.titulo = titulo;
        this.duracionMin = duracionMin;
        this.categoria = categoria;
        this.mediaViewers = mediaViewers;
        this.fecha = fecha;
        this.activo = activo;
    }

    private void asignarID() {
        setId(numeroStreams);
        numeroStreams++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Streamer getStreamer() {
        return streamer;
    }

    public void setStreamer(Streamer streamer) {
        this.streamer = streamer;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getDuracionMin() {
        return duracionMin;
    }

    public void setDuracionMin(int duracionMin) {
        this.duracionMin = duracionMin;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getMediaViewers() {
        return mediaViewers;
    }

    public void setMediaViewers(int mediaViewers) {
        this.mediaViewers = mediaViewers;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public boolean activar(boolean activo) {
        boolean conseguido = false;
        if (!activo) {
            activo = true;
            conseguido = true;
        } else {
            conseguido = false;
        }
        return conseguido;
    }

    public boolean desactivar(boolean activo) {
        boolean conseguido = false;
        if (activo) {
            activo = false;
            conseguido = true;
        } else {
            conseguido = false;
        }
        return conseguido;
    }

    @Override
    public String toString() {
        String estaActivo = (activo) ? "Esta en streaming" : "No esta en streaming";
        return streamer + " | Titulo: " + titulo + " | Media Viewers: " + mediaViewers + " | "
                + estaActivo;
    }

}
