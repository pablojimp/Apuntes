package Apuntes.Apuntes_Programacion.Ejercicios.TEMA_5.Rel2.EJ4;

public class FakerCanciones {

    private static final String[] titulos = {
            "Bohemian Rhapsody", "Stairway to Heaven", "Hotel California", "Smells Like Teen Spirit",
            "Imagine", "Like a Rolling Stone", "Purple Rain", "Johnny B. Goode", "Hey Jude",
            "What's Going On", "Superstition", "Born to Run", "Respect", "Good Vibrations",
            "Waterloo Sunset", "A Day in the Life", "Gimme Shelter", "London Calling",
            "Billie Jean", "Losing My Religion", "Black", "Redemption Song", "Creep",
            "Nothing Compares 2 U", "Wonderwall"
    };

    private static final String[] autores = {
            "Queen", "Led Zeppelin", "Eagles", "Nirvana", "John Lennon",
            "Bob Dylan", "Prince", "Chuck Berry", "The Beatles", "Marvin Gaye",
            "Stevie Wonder", "Bruce Springsteen", "Aretha Franklin", "The Beach Boys",
            "The Kinks", "The Rolling Stones", "The Clash", "Michael Jackson",
            "R.E.M.", "Pearl Jam", "Bob Marley", "Radiohead", "Sinéad O'Connor", "Oasis"
    };

    public static int entero(int min, int max) {
        return (int) (Math.random() * (max - min + 1) + min);
    }

    public static String titulo() {
        return titulos[entero(0, titulos.length - 1)];
    }

    public static String autor() {
        return autores[entero(0, autores.length - 1)];
    }

    /** Duración aleatoria en segundos entre min y max */
    public static int duracion(int minSegundos, int maxSegundos) {
        return entero(minSegundos, maxSegundos);
    }

    /** Duración aleatoria típica de canción (2:00 - 7:00) */
    public static int duracion() {
        return duracion(120, 420);
    }

    /** Crea una Cancion con valores aleatorios */
    public static Cancion cancion() {
        return new Cancion(titulo(), autor(), duracion());
    }
}