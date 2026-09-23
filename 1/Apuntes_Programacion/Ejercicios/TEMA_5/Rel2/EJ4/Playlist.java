package Apuntes.Apuntes_Programacion.Ejercicios.TEMA_5.Rel2.EJ4;

import java.util.ArrayList;

public class Playlist {
    // ### Ejercicio 4: Playlist y Canciones
    // En el `main`, implementa un **menú** para agregar y mostrar canciones. Usa la
    // clase `Faker` para generar 100 canciones.

    private ArrayList<Cancion> canciones; // ← sin static

    public Playlist() {
        this.canciones = new ArrayList<>();
    }

    public void agregarCancion(Cancion cancion) {
        if (!canciones.contains(cancion)) {
            canciones.add(cancion);
        }
    }

    public void mostrarCanciones() { // ← sin static
        for (int i = 0; i < canciones.size(); i++) {
            System.out.println(
                    (i + 1) + " | "+canciones.get(i).getArtista()+" | " + canciones.get(i).getTitulo() + " | " + canciones.get(i).getDuracion());
        }
    }

    public int mostrarDuracion() { // ← sin static
        int totalDuracion = 0;
        for (Cancion cancion : canciones) {
            totalDuracion += cancion.getDuracion();
        }
        return totalDuracion;
    }

    public void cancionesAleatorios(int cantidadGenerar) { // ← sin static
        for (int i = 0; i < cantidadGenerar; i++) {
            canciones.add(FakerCanciones.cancion());
        }

    }
}
