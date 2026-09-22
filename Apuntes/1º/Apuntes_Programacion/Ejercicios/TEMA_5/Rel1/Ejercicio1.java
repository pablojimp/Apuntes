package Apuntes.Apuntes_Programacion.Ejercicios.TEMA_5.Rel1;

public class Ejercicio1 {

    public static void main(String[] args) {
        Circulo circulo2 = new Circulo(8);


        System.out.println("Circulo de radio: "+ circulo2.radio + " Area: "+ circulo2.calcularArea() + " Perimetro: " + circulo2.calcularPerimetro());
        System.out.println();
    }

}

class Circulo {

    double radio;
    final double PI = 3.1415;

    Circulo(double radio){
        this.radio = radio;
    }
    double calcularArea(){
        return PI * radio * radio;
    }

    double calcularPerimetro(){
        return 2 * PI * radio;
    }

}
