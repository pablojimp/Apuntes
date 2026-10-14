import java.io.Serializable;

public class Empleado implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;
    private String nombre;
    private String departamento;

    public Empleado(int id, String nombre, String departamento) {
        this.id = id;
        this.nombre = nombre;
        this.departamento = departamento;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    @Override
    public String toString() {
        return id + " | " + nombre + " | " + departamento;
    }
}
