package Apuntes.Apuntes_Programacion.Ejercicios.TEMA_5.Rel1;

public class Ejercicio6 {

    public static void sumarMinutos(Reloj reloj, int minutosASumar) {
        reloj.minutos += minutosASumar;
        while (reloj.minutos >= 60) {
            reloj.minutos -= 60;
            reloj.horas++;
        }
        if (reloj.horas >= 24) {
            reloj.horas = reloj.horas % 24;
        }
    }

    public static void restarMinutos(Reloj reloj, int minutosARestar) {
        reloj.minutos -= minutosARestar;
        while (reloj.minutos < 0) {
            reloj.minutos += 60;
            reloj.horas--;
        }
        while (reloj.horas < 0) {
            reloj.horas += 24;
        }
    }

    public static void main(String[] args) {
        Reloj reloj = new Reloj(5, 40, 30);
        System.out.println(reloj);

        sumarMinutos(reloj, 120);
        System.out.println(reloj);

        restarMinutos(reloj, 120);
        System.out.println(reloj);
    }
}

class Reloj {
    int horas;
    int minutos;
    int segundos;

    Reloj(int horas, int minutos, int segundos) {
        this.horas = horas;
        this.minutos = minutos;
        this.segundos = segundos;
    }

    @Override
    public String toString() {
        return String.format("La hora de tu reloj actualmente es: %02d:%02d:%02d",
                horas, minutos, segundos);
    }
}