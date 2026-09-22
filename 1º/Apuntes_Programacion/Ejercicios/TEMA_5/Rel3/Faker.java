package Apuntes.Apuntes_Programacion.Ejercicios.TEMA_5.Rel3;

import java.util.ArrayList;
import java.util.Arrays;

public class Faker {

    // ===== Datos base =====
    private static final String[] nombres = {
            "Juan", "Pedro", "María", "Ana", "Luis", "Sofía", "Carlos", "Laura", "Fernando", "Elena",
            "Miguel", "Isabel", "Javier", "Beatriz", "Andrés", "Carmen", "Hugo", "Valeria", "Ricardo", "Paula",
            "Gabriel", "Alejandra", "Roberto", "Manuela", "Diego", "Victoria", "Daniel", "Natalia", "Álvaro", "Marta"
    };

    private static final String[] apellidos = {
            "García", "Rodríguez", "Martínez", "López", "González", "Pérez", "Fernández", "Sánchez", "Ramírez",
            "Torres", "Díaz", "Jiménez", "Moreno", "Vargas", "Rojas", "Castro", "Mendoza", "Romero", "Herrera",
            "Ortega", "Navarro", "Delgado", "Cabrera", "Reyes", "Acosta", "Campos", "Peña", "Vega", "Guerrero", "Cruz"
    };

    private static final String[] ciudades = {
            "Madrid", "Barcelona", "Valencia", "Sevilla", "Zaragoza", "Málaga", "Murcia", "Palma",
            "Bilbao", "Alicante", "Córdoba", "Valladolid", "Vigo", "Gijón", "Granada", "A Coruña",
            "Lisboa", "Roma", "París", "Berlín", "Londres", "Dublín", "Ámsterdam", "Atenas"
    };

    // ===== Puerto Náutico =====
    private static final String[] tiposEmbarcacion = { "Velero", "Lancha", "Yate", "Catamarán", "Moto de agua" };
    private static final String[] tiposAmarre = { "Normal", "Premium", "Megayate" };
    private static final String[] nombresEmbarcacion = {
            "Mar Azul", "Brisa Marina", "La Sirena", "Poseidón", "Costa Viva", "Nácar", "Tramontana", "Atlantis",
            "Faro Norte", "Marea Alta", "Coral", "Neptuno", "Amanecer", "Eolo", "Aurora"
    };

    // ===== Gestoría =====
    private static final String[] tramites = {
            "Transferencia de vehículo", "Alta de autónomo", "Declaración de la renta", "Gestión de multas",
            "Cambio de domicilio fiscal", "Certificado digital", "Solicitud de prestaciones", "Trámite de extranjería",
            "Constitución de sociedad", "Gestión de herencias"
    };

    private static final String[] dominiosCorreo = { "example.com", "mail.com", "correo.es", "demo.net" };

    // ===== Brisca =====
    private static final String[] nivelesBrisca = { "Principiante", "Intermedio", "Experto" };
    private static final String[] paises = { "España", "Portugal", "Italia", "Francia", "Argentina", "México" };

    // ===== Twitch =====
    private static final String[] categoriasTwitch = {
            "Just Chatting", "League of Legends", "Valorant", "Minecraft", "IRL", "EA Sports FC", "Fortnite",
            "Counter-Strike", "Apex Legends", "Music", "Art", "Chess"
    };

    private static final String[] titulosStream = {
            "Ranked hasta que caiga", "Charlando con el chat", "Noche de retos", "Subiendo elo", "Modo historia",
            "Jugando con seguidores", "Torneo improvisado", "Solo buenas vibes", "Directo especial", "Aprendiendo desde cero"
    };

    private static final String[] palabrasLorem = {
            "Lorem", "ipsum", "dolor", "sit", "amet", "consectetur", "adipiscing", "elit", "sed", "do",
            "eiusmod", "tempor", "incididunt", "ut", "labore", "et", "dolore", "magna", "aliqua", "ut",
            "enim", "ad", "minim", "veniam", "quis", "nostrud", "exercitation", "ullamco", "laboris",
            "nisi", "ut", "aliquip", "ex", "ea", "commodo", "consequat", "duis", "aute", "irure",
            "dolor", "in", "reprehenderit", "voluptate", "velit", "esse", "cillum", "fugiat", "pariatur"
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
     * Genera un booleano aleatorio.
     */
    public static boolean booleano() {
        return (entero(0, 1) == 1);
    }

    /**
     * Genera un double aleatorio con 2 decimales entre min y max.
     */
    public static double precio(double min, double max) {
        return entero((int) (min * 100), (int) (max * 100)) / 100.0;
    }

    /**
     * Devuelve un elemento aleatorio de un array de Strings.
     */
    public static String deLista(String[] lista) {
        return lista[entero(0, lista.length - 1)];
    }

    public static String nombre() {
        return deLista(nombres);
    }

    public static String apellido() {
        return deLista(apellidos);
    }

    public static String nombreCompleto() {
        return nombre() + " " + apellido() + " " + apellido();
    }

    public static int edad() {
        return entero(18, 60);
    }

    public static String ciudad() {
        return deLista(ciudades);
    }

    public static String telefono() {
        String telefono = "+34 ";
        telefono += entero(6, 9);

        for (int i = 2; i < 9; i++) {
            telefono += entero(0, 9);
            if (i % 3 == 0) {
                telefono += " ";
            }
        }

        telefono += entero(0, 9);
        return telefono;
    }

    public static String correo() {
        String base = tildesCase(nombre() + apellido() + entero(1, 999));
        return base.toLowerCase() + "@" + deLista(dominiosCorreo);
    }

    /**
     * Genera un DNI español simple (8 dígitos + letra).
     * No hace validación real de la letra: se genera aleatoria.
     */
    public static String dni() {
        String numeros = "";
        for (int i = 0; i < 8; i++) {
            numeros += entero(0, 9);
        }
        char letra = (char) ('A' + entero(0, 25));
        return numeros + letra;
    }

    /**
     * Genera una dirección simple.
     */
    public static String direccion() {
        String[] vias = { "Calle", "Avenida", "Plaza", "Camino", "Paseo" };
        String[] nombresVia = { "Gran Vía", "Andalucía", "Constitución", "Del Sol", "Del Río", "Cervantes", "Real", "Mayor" };

        return deLista(vias) + " " + deLista(nombresVia) + ", " + entero(1, 200);
    }

    /**
     * Transforma una cadena eliminando las tildes (misma idea que tu versión).
     */
    public static String tildesCase(String cadena) {

        Character[] arrayVocalesConTilde = { 'á', 'é', 'í', 'ó', 'ú', 'Á', 'É', 'Í', 'Ó', 'Ú' };
        ArrayList<Character> vocalesConTilde = new ArrayList<>(Arrays.asList(arrayVocalesConTilde));

        Character[] arrayVocalesSinTilde = { 'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U' };
        ArrayList<Character> vocalesSinTilde = new ArrayList<>(Arrays.asList(arrayVocalesSinTilde));

        String resultadoSinTildes = "";

        for (int i = 0; i < cadena.length(); i++) {
            char letraActual = cadena.charAt(i);

            int posicionVocalConTilde = vocalesConTilde.indexOf(letraActual);

            if (posicionVocalConTilde == -1) {
                resultadoSinTildes += letraActual;
            } else {
                resultadoSinTildes += vocalesSinTilde.get(posicionVocalConTilde);
            }
        }

        return resultadoSinTildes;
    }

    /**
     * Genera texto Lorem Ipsum con X palabras.
     */
    public static String lorem(int cantidad) {
        String texto = "";
        for (int i = 0; i < cantidad; i++) {
            texto += deLista(palabrasLorem) + " ";
        }
        return texto.trim();
    }

    public static String loremCorto() {
        return lorem(entero(5, 10));
    }

    public static String loremLargo() {
        return lorem(entero(20, 50));
    }

    // =========================================================
    // Generadores específicos para la Relación 3
    // =========================================================

    // -------- Puerto Náutico --------
    public static String matriculaEmbarcacion() {
        // Formato simple tipo: ES-AB-1234
        String letras = "" + (char) ('A' + entero(0, 25)) + (char) ('A' + entero(0, 25));
        return "ES-" + letras + "-" + entero(1000, 9999);
    }

    public static String nombreEmbarcacion() {
        return deLista(nombresEmbarcacion);
    }

    public static String tipoEmbarcacion() {
        return deLista(tiposEmbarcacion);
    }

    public static double eslora() {
        // Eslora típica: 4m a 30m
        return precio(4.0, 30.0);
    }

    public static int anioFabricacionEmbarcacion() {
        return entero(1980, 2025);
    }

    public static String tipoAmarre() {
        return deLista(tiposAmarre);
    }

    public static double longitudMaximaAmarre() {
        // Amarres: 6m a 40m
        return precio(6.0, 40.0);
    }

    // -------- Gestoría --------
    public static String tramite() {
        return deLista(tramites);
    }

    public static String codigoTramite() {
        // Formato: TR-123
        return "TR-" + entero(100, 999);
    }

    // -------- Brisca --------
    public static String nivelBrisca() {
        return deLista(nivelesBrisca);
    }

    public static String pais() {
        return deLista(paises);
    }

    // -------- Twitch --------
    public static String categoriaTwitch() {
        return deLista(categoriasTwitch);
    }

    public static String tituloStream() {
        return deLista(titulosStream);
    }

    public static String nombreCanal() {
        // Ej: "JuanGamer_42"
        String base = tildesCase(nombre() + entero(1, 999)).replace(" ", "");
        String sufijo = "_" + entero(10, 99);
        return base + sufijo;
    }

    public static int seguidores() {
        // 0 a 500k
        return entero(0, 500_000);
    }

    // -------- Fechas (simple, sin librerías) --------
    /**
     * Devuelve una fecha simple como String "2026-02-17" en un rango.
     * (No valida calendarios reales: solo formato y rango aproximado.)
     */
    public static String fechaYYYYMMDD(int anioMin, int anioMax) {
        int anio = entero(anioMin, anioMax);
        int mes = entero(1, 12);
        int dia = entero(1, 28); // para no complicar meses
        return anio + "-" + dosDigitos(mes) + "-" + dosDigitos(dia);
    }

    private static String dosDigitos(int n) {
        return (n < 10) ? "0" + n : "" + n;
    }
}
