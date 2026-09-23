package Apuntes.Apuntes_Programacion.Ejercicios.TEMA_5.Rel3.Ejercicio1;

import java.util.ArrayList;
import Apuntes.Apuntes_Programacion.Ejercicios.TEMA_5.Rel3.Faker;

public class Ejercicio1 {

    public static void main(String[] args) {

        Embarcacion barco1 = new Embarcacion("Barco1", 10, "Velero");
        Embarcacion barco2 = new Embarcacion("Barco2", 10, "Velero");

        Amarre amarre1 = new Amarre(15, "Normal");
        System.out.println(amarre1);
        Amarre amarre2 = new Amarre(10, "Normal");
        System.out.println(amarre2);

        ArrayList<Amarre> amarres = new ArrayList<>();
        amarres.add(amarre1);
        amarres.add(amarre2);

        Puerto banus = new Puerto("Malaga", 30, "666666666");

        for (int i = 0; i < 20; i++) {
            banus.registrarEmbarcacion(
                    new Embarcacion(Faker.nombre(), Faker.entero(1, 30), Faker.tipoEmbarcacion()));
        }

        for (int i = 0; i < 50; i++) {
            banus.altaAmarre(new Amarre(Faker.longitudMaximaAmarre(), Faker.tipoAmarre()));
        }

        if (banus.asignarAmarre("EMB-8", 3)) {
            System.out.println("Barco amarrado con exito");
        }

    }
}
