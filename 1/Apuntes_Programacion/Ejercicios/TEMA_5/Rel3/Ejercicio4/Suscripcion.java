package Apuntes.Apuntes_Programacion.Ejercicios.TEMA_5.Rel3.Ejercicio4;

public class Suscripcion {

    static int numeroSuscripciones;
    int id;
    String usuario;
    Streamer Streamer;
    int meses;
    int tier;
    String fechaInicio;

    Suscripcion(int id, String usuario,
            Apuntes.Apuntes_Programacion.Ejercicios.TEMA_5.Rel3.Ejercicio4.Streamer streamer, int meses, int tier,
            String fechaInicio) {

        asignarID();
        this.usuario = usuario;
        Streamer = streamer;
        this.meses = meses;
        this.tier = tier;
        this.fechaInicio = fechaInicio;
    }

    public static int getNumeroSuscripciones() {
        return numeroSuscripciones;
    }

    public static void setNumeroSuscripciones(int numeroSuscripciones) {
        Suscripcion.numeroSuscripciones = numeroSuscripciones;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Streamer getStreamer() {
        return Streamer;
    }

    public void setStreamer(Streamer streamer) {
        Streamer = streamer;
    }

    public int getMeses() {
        return meses;
    }

    public void setMeses(int meses) {
        this.meses = meses;
    }

    public int getTier() {
        return tier;
    }

    public void setTier(int tier) {
        if (tier == 1 || tier == 2 || tier == 3) {
            this.tier = tier;

        } else {
            tier = 0;
        }
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    private void asignarID() {
        setId(numeroSuscripciones);
        numeroSuscripciones++;
    }

    public double precioMensual() {
        int tierPersona = getTier();
        double precio = 0;
        if (tierPersona == 1) {
            precio = 3.99;
        } else if (tierPersona == 2) {
            precio = 5.99;
        } else if (tierPersona == 3) {
            precio = 7.99;
        }
        return precio;
    }

    public double ingresoTotal() {
        return precioMensual() * getMeses();
    }

    @Override
    public String toString() {
        return "=== Suscripción #" + id + " ===" +
                "\n  Usuario      : " + usuario +
                "\n  Streamer     : " + Streamer.getNombreCanal() +
                "\n  Tier         : " + tier +
                "\n  Fecha inicio : " + fechaInicio +
                "\n  Meses        : " + meses +
                "\n  Precio/mes   : " + precioMensual() + "€" +
                "\n  Total pagado : " + ingresoTotal() + "€";
    }
}
