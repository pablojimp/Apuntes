package Apuntes.Apuntes_Programacion.Ejercicios.TEMA_5.Rel3.Ejercicio4;

public class Streamer {

    static int numeroStreamers;
    int id;
    String nombreCanal;
    int seguidores;
    String categoriaPrincipal;
    String pais;

    public Streamer(int id, String nombreCanal, int seguidores, String categoriaPrincipal, String pais) {
        asignarID();
        this.nombreCanal = nombreCanal;
        this.seguidores = seguidores;
        this.categoriaPrincipal = categoriaPrincipal;
        this.pais = pais;
    }

    private void asignarID() {
        setId(numeroStreamers);
        numeroStreamers++;
    }

    public static int getNumeroStreamers() {
        return numeroStreamers;
    }

    public static void setNumeroStreamers(int numeroStreamers) {
        Streamer.numeroStreamers = numeroStreamers;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreCanal() {
        return nombreCanal;
    }

    public void setNombreCanal(String nombreCanal) {
        this.nombreCanal = nombreCanal;
    }

    public int getSeguidores() {
        return seguidores;
    }

    public void setSeguidores(int seguidores) {
        this.seguidores = seguidores;
    }

    public String getCategoriaPrincipal() {
        return categoriaPrincipal;
    }

    public void setCategoriaPrincipal(String categoriaPrincipal) {
        this.categoriaPrincipal = categoriaPrincipal;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    @Override
    public String toString() {
        return nombreCanal + " | Seguidores: " + seguidores + " | Categoria: " + categoriaPrincipal + " | Pais: "
                + pais;
    }

}
