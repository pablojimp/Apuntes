public class Gerente extends Empleado{

    private double sueldoTotal;
    private double bonificador = 1.5;

    Gerente(String nombre, double sueldoBase) {
        super(nombre, sueldoBase);
        calcularSueldo();
    }
    private void calcularSueldo() {
        setSueldoBase(sueldoTotal*bonificador);
    }
}
