package ejercicios.UD2.R2;

import java.util.ArrayList;
import java.util.Scanner;

public class Ej5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> nombreGastos = new ArrayList<String>();
        ArrayList<Double> cantidades = new ArrayList<Double>();
        String nombre = "";
        double cantidad = 0;
        double total = 0;

        boolean ejecutar = true;
        int opcion = 0;

        while (ejecutar) {

            do {
                System.out.println("1. Añadir gasto.\r\n" + //
                        "2. Ver total.\r\n" + //
                        "3. Ver máximo y mínimo.\r\n" + //
                        "4. Promedio diario.\r\n" + //
                        "5. Salir.");
                try {
                    opcion = Integer.parseInt(scanner.nextLine());
                } catch (Exception e) {
                    opcion = -1;
                    System.out.println("ERROR, debes poner un valor entero entre 1 y 5");
                }
            } while (opcion < 1 || opcion > 5);

            if (opcion == 1) {

                System.out.print("Nombre del gasto: ");
                nombre = scanner.nextLine();
                System.out.print("Cantidad: ");
                cantidad = scanner.nextDouble();
                nombreGastos.add(nombre);
                cantidades.add(cantidad);

            } else if (opcion == 2) {

                for (int i = 0; i < cantidades.size(); i++) {

                    total += cantidades.get(i);
                    
                }

                System.out.println("Total: " + total + "€");


            } else if (opcion == 3) {

            } else if (opcion == 4) {

            } else if (opcion == 5) {

                ejecutar = false;

            }

        }

        scanner.close();
    }
}

// *Solución:*
// const nombreGastos = []
// const cantidadGastos = []

// let opcion

// while (opcion !== "5") {
// opcion = prompt("1. Añadir gasto.
// 2. Ver total.
// 3. Ver máximo y mínimo.
// 4. Promedio diario.
// 5. Salir.")

// if (opcion === "1") {
//

// } else if (opcion === "2") {
// let total = 0
// for (let i = 0; i < cantidadGastos.length; i++) total += cantidadGastos[i]
// console.log("Total: " + total + "€")

// } else if (opcion === "3") {

// let posMax = 0
// let posMin = 0

// for (let i = 1; i < cantidadGastos.length; i++) {
// if (cantidadGastos[i] > cantidadGastos[posMax]) posMax = i
// if (cantidadGastos[i] < cantidadGastos[posMin]) posMin = i
// }

// console.log("Mayor: " + nombreGastos[posMax] + " - " + cantidadGastos[posMax]
// + "€")
// console.log("Menor: " + nombreGastos[posMin] + " - " + cantidadGastos[posMin]
// + "€")

// } else if (opcion === "4") {
// let total = 0
// for (let i = 0; i < cantidadGastos.length; i++) total += cantidadGastos[i]
// console.log("Promedio diario: " + (total / 30))
// }
// }