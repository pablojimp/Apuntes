package Apuntes.Apuntes_Programacion.Ejercicios.TEMA_5.Rel3.Ejercicio1;

import java.util.ArrayList;

public class Puerto {

    private static int numeroPuertos;

    private String nombre;
    public String ubicacion;
    private int capacidadMaxima;
    public String telefonoContacto;
    private ArrayList<Amarre> amarres;
    private ArrayList<Embarcacion> embarcaciones;
    private ArrayList<String> matriculasAmarradas;

    public Puerto(String ubicacion, int capacidadMaxima, String telefonoContacto,
            ArrayList<Amarre> amarres, ArrayList<Embarcacion> embarcaciones, ArrayList<String> matriculasAmarradas) {

        asignarNombre();
        this.ubicacion = ubicacion;
        this.telefonoContacto = telefonoContacto;
        setAmarres(amarres);
        setCapacidadMaxima(capacidadMaxima);
        setEmbarcaciones(embarcaciones);
        if (!matriculasAmarradas.isEmpty()) {
            setMatriculasAmarradas(matriculasAmarradas);
        }
    }

    public Puerto(String ubicacion, int capacidadMaxima, String telefonoContacto) {
        this(ubicacion, capacidadMaxima, telefonoContacto, new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
    }

    public Puerto(String ubicacion, int capacidadMaxima, String telefonoContacto, ArrayList<Amarre> amarres) {
        this(ubicacion, capacidadMaxima, telefonoContacto, amarres, new ArrayList<>(), new ArrayList<>());
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public void setCapacidadMaxima(int capacidadMaxima) {
        if (amarres != null) {
            if (capacidadMaxima >= 0 && amarres.size() <= capacidadMaxima) {
                this.capacidadMaxima = capacidadMaxima;
            }
        }
    }

    public ArrayList<Amarre> getAmarres() {
        return amarres;
    }

    public void setAmarres(ArrayList<Amarre> amarres) {
        if (amarres.size() <= capacidadMaxima) {
            this.amarres = amarres;

            for (int i = 0; i < amarres.size(); i++) {
                matriculasAmarradas.set(i, "VACIO");
            }
        }
    }

    public ArrayList<Embarcacion> getEmbarcaciones() {
        return embarcaciones;
    }

    public void setEmbarcaciones(ArrayList<Embarcacion> embarcaciones) {
        this.embarcaciones = embarcaciones;
    }

    public ArrayList<String> getMatriculasAmarradas() {
        return matriculasAmarradas;
    }

    public void setMatriculasAmarradas(ArrayList<String> matriculasAmarradas) {
        this.matriculasAmarradas = matriculasAmarradas;
    }

    public void asignarNombre() {
        setNombre("Puerto-" + numeroPuertos);
        numeroPuertos++;
    }

    // Regitra el barco e. Devuelve true si se ha registrado con exito o false en
    // caso contrario
    public boolean registrarEmbarcacion(Embarcacion e) {
        boolean barcoRegistrado = false;

        if (!embarcaciones.contains(e)) {
            embarcaciones.add(e);
            barcoRegistrado = true;
        }

        return barcoRegistrado;
    }

    // Regitra el amarre a. Devuelve true si se ha registrado con exito o false en
    // caso contrario
    public boolean altaAmarre(Amarre a) {
        boolean amarreRegistrado = false;

        if (!amarres.contains(a) && amarres.size() < capacidadMaxima) {
            amarres.add(a);
            amarreRegistrado = true;
            if (matriculasAmarradas == null) {
                matriculasAmarradas = new ArrayList<>(); 
            }
            matriculasAmarradas.add("VACIO");

        }

        return amarreRegistrado;
    }

    // Busca una embarcacion en el puerto por matricula. Devuelve la embarcacion si
    // está o null en caso contrario
    private Embarcacion encontrarEmbarcacion(String matricula) {
        Embarcacion embarcacionBuscar = null;

        for (Embarcacion embarcacion : embarcaciones) {
            if (matricula.equals(embarcacion.getMatricula())) {
                embarcacionBuscar = embarcacion;
            }
        }

        return embarcacionBuscar;

    }

    // Busca una amarre en el puerto por numero. Devuelve la embarcacion si está o
    // null en caso contrario
    private Amarre encontrarAmarre(int numero) {
        Amarre amarreBuscar = null;

        for (Amarre amarre : amarres) {
            if (numero == amarre.getNumero()) {
                amarreBuscar = amarre;
            }
        }

        return amarreBuscar;
    }

    // Asigna un barco a un amarre y devuelce true si lo consigue hacer, false en
    // otro caso
    public boolean asignarAmarre(String matricula, int numeroAmarre) {
        boolean embarcacionAmarrada = false;
        Embarcacion barcoAmarrar = encontrarEmbarcacion(matricula);
        Amarre amarre = encontrarAmarre(numeroAmarre);

        if (barcoAmarrar != null && amarre != null) {
            if (!matriculasAmarradas.contains(matricula)) {
                if (barcoAmarrar.getEslora() <= amarre.getLongitudMaxima()) {
                    if (!amarre.isOcupado()) {
                        matriculasAmarradas.set(numeroAmarre, matricula);
                        amarre.setOcupado(true);
                        embarcacionAmarrada = true;
                    }
                }
            }
        }

        return embarcacionAmarrada;

    }

    public boolean liberarAmarre(int numeroAmarre) {

        boolean embarcacionSoltada = false;
        Amarre amarre = encontrarAmarre(numeroAmarre);

        if (amarres.contains(amarre)) {
            amarres.remove(amarre);
            embarcacionSoltada = true;
        }
        return embarcacionSoltada;
    }

    public String mostrarAmarresLibres() {
        String mensaje = "";
        for (Amarre amarre : amarres) {
            if (amarre.isOcupado()) {
                mensaje += amarre.getNumero() + " | " + amarre.consultarDisponibilidad();
            }
        }
        return mensaje;
    }

    public String mostrarAmarresOcupados() {
        String mensaje = "";
        for (Amarre amarre : amarres) {
            if (!amarre.isOcupado()) {
                mensaje += amarre.getNumero() + " | " + amarre.consultarDisponibilidad();
            }
        }
        return mensaje;
    }

    // TODO: Terminar esta funcion
    public String buscarEmbarcacion(String matricula){
        String mensaje = "";

        Embarcacion barco = encontrarEmbarcacion(matricula);
        if(!barco.equals(null)){

            for (Amarre amarre : amarres) {
                
            }

        };

        return mensaje;
    }

    public String calcularIngresosDiariosActuales() {
        int total = 0;

        for (Amarre amarre : amarres) {
            if (amarre.isOcupado()) {

                total += amarre.getPrecioDia();
            }

        }

        return "Precio Total Actual: " + total;
    }

    public String calcularIngresosDiariosMaximos() {
        int total = 0;

        for (Amarre amarre : amarres) {
            total += amarre.getPrecioDia();

        }
        return "Precio Total Maximo: " + total;
    }
}