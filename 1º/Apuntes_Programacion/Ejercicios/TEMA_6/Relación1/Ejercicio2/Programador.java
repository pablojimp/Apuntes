public class Programador extends Empleado {

    private double sueldoTotal;
    private double bonificador = 2;

    Programador(String nombre, double sueldoBase) {
        super(nombre, sueldoBase);
        sueldoTotal = calcularSueldo(); 
    }

    public double calcularSueldo() { 
        return getSueldoBase() * bonificador; 
    }

    @Override
    public String toString() {
        return super.getNombre() + " | " + sueldoTotal;
    }
}