package Apuntes.Apuntes_Programacion.Ejercicios.TEMA_5.Rel3.Ejercicio1;

import java.time.Year;
import java.util.ArrayList;
import java.util.Arrays;

public class Embarcacion {

    private static int numeroEmbarcaciones;
    private final static ArrayList<String> TIPOSVALIDOS = new ArrayList<>(
            Arrays.asList("VELERO", "LANCHA", "YATE", "CATAMARAN", "MOTO DE AGUA"));

    private String matricula;
    private String nombre;
    private double eslora;
    private String tipo;
    private String propietario;
    private int anioFabricacion;
    public double valorEstimado;

    public Embarcacion(String nombre, double eslora, String tipo, String propietario,
            int anioFabricacion, double valorEstimado) {
        asignarMatricula();
        this.nombre = nombre;
        setEslora(eslora);
        setTipo(tipo);
        this.propietario = propietario;
        setAnioFabricacion(anioFabricacion);
        this.valorEstimado = valorEstimado;
    }

    public Embarcacion(String nombre, double eslora, String tipo) {
        this(nombre, eslora, tipo, "PROPIETARIO VACIO", 2026, 0.0);
    }

    public String getMatricula() {
        return matricula;
    }

    private void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Devuelve el valor de la eslora o -1 si hay un valor fuera de rango
    public double getEslora() {
        return eslora;
    }

    // Actualiza el valor de eslora y si está fuera de rango
    // usa el valor por defecto -1
    public void setEslora(double eslora) {
        if (eslora > 0) {
            this.eslora = eslora;
        } else {
            this.eslora = -1;
        }
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        if (TIPOSVALIDOS.contains(tipo)) {
            this.tipo = tipo;
        }
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public int getAnioFabricacion() {
        return anioFabricacion;
    }

    public void setAnioFabricacion(int anioFabricacion) {
        //Se actualiza la fecha máxima al año actual, no venia en los requisitos
        if (anioFabricacion >= 1950 && anioFabricacion <= Year.now().getValue()) {
            this.anioFabricacion = anioFabricacion;
        }
    }

    private void asignarMatricula() {
        setMatricula("EMB-" + numeroEmbarcaciones);
        numeroEmbarcaciones++;
    }

    public String mostrarEslora() {
        return eslora != -1 ? "Eslora " + eslora : "<Valor de eslora incorrecto. Actualicelo por favor>";
    }

    public String mostrarTipo() {
        return tipo != null ? tipo : "[Valor de tipo incorrecto. Actualicelo por favor]";
    }

    public String mostrarAnioFabricacion() {
        return anioFabricacion != 0 ? "" + anioFabricacion
                : "[Valor de año fabricaion incorrecto. Actualicelo por favor]";
    }

    @Override
    public String toString() {
        return nombre + " " + mostrarTipo() + " con matricula " + matricula + " de " + propietario +
                ". Mide " + mostrarEslora() + " m. Fabricado en el año " + mostrarAnioFabricacion() +
                ". Su valor estimado es de " + valorEstimado + "€.";
    }

}
