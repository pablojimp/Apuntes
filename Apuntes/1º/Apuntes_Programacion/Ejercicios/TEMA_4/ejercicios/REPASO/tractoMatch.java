// package ejercicios.REPASO;

// import java.util.ArrayList;
// import java.util.Scanner;

// public class tractoMatch {

//     public static void mensajeNuevaLinea(String stringMostrar) {
//         System.out.println(stringMostrar);
//     }

//     public static void mensajeMismaLinea(String stringMostrar) {
//         System.out.print(stringMostrar);
//     }

//     public static int pedirRango(Scanner scanner, String menuString, String opcionString, String mensajeError,
//             int minimoR, int maximoR) {
//         int opcionMenu = 0;
//         do {
//             mensajeNuevaLinea(menuString);
//             mensajeMismaLinea(opcionString);
//             try {
//                 opcionMenu = Integer.parseInt(scanner.nextLine());
//             } catch (Exception e) {
//                 opcionMenu = -1;
//                 mensajeNuevaLinea(mensajeError);
//             }
//         } while (opcionMenu < minimoR || opcionMenu > maximoR);
//         return opcionMenu;
//     }
//     public static void aniadirDatos(Scanner lector,ArrayList<String> marca,ArrayList<Integer> potencia,ArrayList<String> trabajo){

//     }

//     public static void main(String[] args) {
//         Scanner scanner = new Scanner(System.in);
//         ArrayList<String> marca = new ArrayList<String>();
//         ArrayList<Integer> potencia = new ArrayList<Integer>();
//         ArrayList<String> trabajo = new ArrayList<String>();
//         int opcion = 0;
//         boolean ejecutar = true;
//         final String MENU = "1. Añadir Tractor\n2. Listado Tractores\n3. Evaluar Tractor \n4. Eliminar Tractor\n0. Salir\n";
//         final String OPCION = "Seleccionar Opcion: ";
//         final String ERRORANGO = "ERROR, debes poner un valor entero entre 0 y 4";

//         while (ejecutar) {
//             opcion = pedirRango(scanner, MENU, OPCION, ERRORANGO, 0, 4);
//             if (opcion == 1) {

//             } else if (opcion == 2) {

//             } else if (opcion == 3) {

//             } else if (opcion == 4) {

//             } else if (opcion == 0) {
//                 ejecutar = false;

//             }

//         }

//     }

// }
