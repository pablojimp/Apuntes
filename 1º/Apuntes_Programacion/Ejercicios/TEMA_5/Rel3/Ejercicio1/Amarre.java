package Apuntes.Apuntes_Programacion.Ejercicios.TEMA_5.Rel3.Ejercicio1;

import java.util.ArrayList;
import java.util.Arrays;

public class Amarre {

    private static int numeroAmarres;
    private final static ArrayList<String> TIPOSVALIDOS = new ArrayList<>(
            Arrays.asList("NORMAL", "PREMIUM", "MEGAYATE"));

    private int numero;
    private double longitudMaxima;
    private double precioDia;
    private boolean ocupado;
    private String tipoAmarre;

    public Amarre(double longitudMaxima, String tipoAmarre) {
        asignarAmarre();
        setLongitudMaxima(longitudMaxima);
        this.ocupado = false;
        setTipoAmarre(tipoAmarre);
    }

    public Amarre(double longitudMaxima) {
        this(longitudMaxima, "NORMAL");
    }

    private void asignarAmarre() {
        setNumero(numeroAmarres);
        numeroAmarres++;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getLongitudMaxima() {
        return longitudMaxima;
    }

    public void setLongitudMaxima(double longitudMaxima) {
        if (longitudMaxima >= 4.0) {
            this.longitudMaxima = longitudMaxima;
            calcularPrecioDia();
        } else {
            // Añado valor por defecto si falla el setLongitudMaxima a -1
            // para cumplir las restricciones ya que 0 no seria valor valido
            this.longitudMaxima = -1;
            precioDia = -1;
        }
    }

    public double getPrecioDia() {
        return precioDia;
    }

    private void calcularPrecioDia() {
        if (tipoAmarre != null && longitudMaxima != -1)
            if (tipoAmarre.equals(TIPOSVALIDOS.get(0))) {
                precioDia = 25 + (1.5 * longitudMaxima);
            } else if (tipoAmarre.equals(TIPOSVALIDOS.get(1))) {
                precioDia = 60 + (2.2 * longitudMaxima);
            } else if (tipoAmarre.equals(TIPOSVALIDOS.get(2))) {
                precioDia = 120 + (3.5 * longitudMaxima);
            }
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }

    public String getTipoAmarre() {
        return tipoAmarre;
    }

    public void setTipoAmarre(String tipoAmarre) {
        if (TIPOSVALIDOS.contains(tipoAmarre.toUpperCase())) {
            this.tipoAmarre = tipoAmarre.toUpperCase();
            calcularPrecioDia();
        }
    }

    public String consultarDisponibilidad() {
        return ocupado ? "Está ocupado" : "Está libre";
    }

    public String consultarPrecioDiario() {
        return precioDia == -1 ? "[PRECIO DIARIO ERRONEO: Actualice longitud o tipo de amarre]" : "" + precioDia;
    }

    public String consultarLongitudMaxima() {
        return longitudMaxima == -1 ? "[LONGITUD MAXIMA ERRONEA: Actualice longitud ]" : "" + longitudMaxima;
    }

    @Override
    public String toString() {
        return "Amarre " + numero + " del tipo " + tipoAmarre + ". Longitud maxima de "
                + consultarLongitudMaxima() + "m con precio diario de " + consultarPrecioDiario() + "€/dia."
                + consultarDisponibilidad();
    }

}
