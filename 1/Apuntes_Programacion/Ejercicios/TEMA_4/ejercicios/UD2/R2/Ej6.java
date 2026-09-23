package ejercicios.UD2.R2;

import java.util.ArrayList;
import java.util.Scanner;

public class Ej6 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> tareas = new ArrayList<String>();
        ArrayList<Boolean> completadas = new ArrayList<Boolean>();
        String mensaje = null;
        boolean ejecutar = true;
        int opcion = 0;
        String nuevaTarea = "";

        tareas.add("tarea1");
        tareas.add("tarea2");
        tareas.add("tarea3");

        completadas.add(false);
        completadas.add(true);
        completadas.add(false);

        while (ejecutar) {

            System.out.println("1. Añadir tarea.\r\n" + //
                    "// 2. Marcar completada.\r\n" + //
                    "// 3. Ver pendientes.\r\n" + //
                    "// 4. Ver completadas.\r\n" + //
                    "// 5. Salir.");

            if (opcion == 1) {

                System.out.print("Nueva tarea:");
                nuevaTarea=scanner.nextLine();
                tareas.add(nuevaTarea);
                completadas.add(false);
                
            }
            else if (opcion == 2) {



            }
            else if (opcion == 3) {
                mensaje = "";

                for (int i = 0; i < completadas.size(); i++) {

                    if (!completadas.get(i)) {

                        mensaje += completadas.get(i)+" | ";
                        
                    }
                    
                }
                System.out.println(mensaje);



            }
            else if (opcion == 4) {

                

            }
            else if (opcion == 5) {

                ejecutar = false;

            }

        }
        
        scanner.close();
    }
}

// const tareas = ["tarea1", "tarea2", "tarea3"]
// const completadas = [false, true, false]

// let opcion

// while (opcion !== "5") {
// opcion = prompt("1. Añadir tarea.
// 2. Marcar completada.
// 3. Ver pendientes.
// 4. Ver completadas.
// 5. Salir.")

// if (opcion === "1") {
// let nueva = prompt("Nueva tarea:")
// tareas.push(nueva)
// completadas.push(false)

// } else if (opcion === "2") {
// let buscar = prompt("Nombre de la tarea:")
// let encontrado = false

// for (let i = 0; i < tareas.length && !encontrado; i++) {
// if (tareas[i] === buscar) {
// encontrado = true
// completadas[i] = true
//  }
// }

// if (!encontrado) console.log("No encontrada")

// } else if (opcion === "3") {
// let pendientes = []

// for (let i = 0; i < completadas.length; i++) {
// if (!completadas[i]) pendientes.push(tareas[i])
// }

// console.log("Pendientes: " + pendientes)

// } else if (opcion === "4") {
// let hechas = []

// for (let i = 0; i < completadas.length; i++) {
// if (completadas[i]) hechas.push(tareas[i])
// }

// console.log("Completadas: " + hechas)
// }
// }
