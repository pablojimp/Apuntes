package Apuntes.Apuntes_Programacion.Ejercicios.TEMA_5.Rel1;

public class Ejercicio2 {

    public static void main(String[] args) {
        CuentaBancaria cuentaBancaria = new CuentaBancaria("Pablo", 0);
        System.out.println(cuentaBancaria);
        cuentaBancaria.depositar(1000);
        System.out.println(cuentaBancaria);
        cuentaBancaria.retirar(500);
        System.out.println(cuentaBancaria);

    }

}

class CuentaBancaria {

    String titular;
    int salario;

    CuentaBancaria(String titular, int salario) {
        this.titular = titular;
        this.salario = salario;
    }

    void depositar(int cantidad) {
         salario += cantidad;
    }

    void retirar(int cantidad) {
        if (salario < cantidad) {
            System.out.println("No se puede restar, falta saldo");
        } else {
            salario -= cantidad;
        }
    }

    @Override
    public String toString() {
        return "El titular es: " + this.titular + " | En la cuenta hay: " + this.salario;
    }
}
