package Apuntes.Apuntes_Programacion.Ejercicios.TEMA_5.Examen;

public class Faker {

    // ===== Datos base (solo para la tarea) =====
    private static final String[] nombresAnimales = {
            "León", "Tigre", "Elefante", "Jirafa", "Cebra", "Hipopótamo", "Rinoceronte", "Panda",
            "Koala", "Canguro", "Lobo", "Oso", "Gorila", "Chimpancé", "Suricata", "Pingüino",
            "Avestruz", "Cocodrilo", "Serpiente", "Tortuga", "Flamenco", "Lémur", "Nutria", "Foca",
            "Camello", "Búfalo", "Antílope", "Jaguar", "Pantera", "Puma"
    };

    private static final String[] adjetivos = {
            "Africano", "Asiático", "Ártico", "Gigante", "Enano", "Albino", "Salvaje", "Joven",
            "Adulto", "Nocturno", "Tropical", "Montañés"
    };

    // =========================================================
    // Utilidades básicas
    // =========================================================

    /**
     * Genera un número entero aleatorio entre min y max (inclusive).
     */
    public static int entero(int min, int max) {
        return (int) (Math.random() * (max - min + 1) + min);
    }

    /**
     * Genera un double aleatorio con 2 decimales entre min y max.
     */
    public static double precio(double min, double max) {
        int minCents = (int) (min * 100);
        int maxCents = (int) (max * 100);
        return entero(minCents, maxCents) / 100.0;
    }

    /**
     * Devuelve un elemento aleatorio de un array de Strings.
     */
    private static String deLista(String[] lista) {
        return lista[entero(0, lista.length - 1)];
    }

    // =========================================================
    // Generadores específicos para la tarea
    // =========================================================

    /**
     * Genera un nombre de animal simple.
     * Ej: "Tigre Asiático"
     */
    public static String nombreAnimal() {
        return deLista(nombresAnimales) + " " + deLista(adjetivos);
    }

    /**
     * Genera un código alfanumérico de 6 caracteres (A-Z, 0-9).
     * Ej: "A1B2C3"
     */
    public static String codigoAnimal() {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        String codigo = "";
        for (int i = 0; i < 6; i++) {
            int pos = entero(0, chars.length() - 1);
            codigo += chars.charAt(pos);
        }
        return codigo;
    }

    /**
     * Genera una cantidad aleatoria para el animal.
     * Rango recomendado: 0 a 50 (puedes ajustarlo en Main si quieres).
     */
    public static int cantidadAnimal() {
        return entero(0, 50);
    }

    /**
     * Genera un precio aleatorio para el animal (2 decimales).
     * Rango recomendado: 5.00 a 200.00
     */
    public static double precioAnimal() {
        return precio(5.00, 200.00);
    }
}