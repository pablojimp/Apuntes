// package chuletas;

// import java.util.ArrayList;
// import java.util.Scanner;

// public class chuletaPT4 {

//     // OBLIGATORIO PARA FUNCIONAR LAS DEMAS (LINEA 15 - 44)

//     // ================== SYSOUT PRINTLN ==================

//     // FUNCION QUE HACE UN SYSOUT CON UNA NUEVA LINEA
//     public static void mensajeNuevaLineaString(String stringMostrar) {
//         System.out.println(stringMostrar);
//     }

//     // FUNCION QUE HACE UN SYSOUT CON UNA NUEVA LINEA
//     public static void mensajeNuevaLineaInt(int intMostrar) {
//         System.out.println(intMostrar);
//     }

//     // FUNCION QUE HACE UN SYSOUT CON UNA NUEVA LINEA
//     public static void mensajeNuevaLineaDouble(double doubleMostrar) {
//         System.out.println(doubleMostrar);
//     }

//     // ================== SYSOUT PRINT ==================

//     // FUNCION QUE HACE UN SYSOUT CON UNA NUEVA LINEA
//     public static void mensajeMismaLineaString(String stringMostrar) {
//         System.out.print(stringMostrar);
//     }

//     // FUNCION QUE HACE UN SYSOUT CON UNA NUEVA LINEA
//     public static void mensajeMismaLineaInt(int intMostrar) {
//         System.out.print(intMostrar);
//     }

//     // FUNCION QUE HACE UN SYSOUT CON UNA NUEVA LINEA
//     public static void mensajeMismaLineaDouble(double doubleMostrar) {
//         System.out.print(doubleMostrar);
//     }

//     // ================== MENU ==================

//     // FUNCION PARA HACER MENU (NECESITA LAS 2 FUNCIONES DE MENSAJES)
//     public static int pedirRangoMenu(Scanner scanner, String textoMenuString, String textoOpcionString,
//             String mensajeError, int minimoPosible, int maximoPosible) {

//         int opcionMenu;
//         do {
//             mensajeNuevaLineaString(textoMenuString);
//             mensajeMismaLineaString(textoOpcionString);
//             try {
//                 opcionMenu = Integer.parseInt(scanner.nextLine());
//             } catch (Exception e) {
//                 opcionMenu = minimoPosible - 1;
//                 mensajeNuevaLineaString(mensajeError);
//             }
//         } while (opcionMenu < minimoPosible || opcionMenu > maximoPosible);
//         return opcionMenu;
//     }

//     // ================== NUMEROS INT Y DOUBLE CON CONTROL DE ERRORES
//     // ==================

//     // FUNCION PARA PEDIR UN INT CON TRYCATCH (NECESITA LAS 2 FUNCIONES DE MENSAJES)
//     public static int pedirNumeroEnteroConControlErrores(Scanner scanner, int numeroMinimo, String mensajePedir,
//             String mensajError) {

//         int variableRellenar;
//         do {
//             mensajeMismaLineaString(mensajePedir);
//             try {
//                 variableRellenar = Integer.parseInt(scanner.nextLine());
//             } catch (Exception e) {
//                 variableRellenar = numeroMinimo - 1;
//                 mensajeMismaLineaString(mensajError);
//             }
//         } while (variableRellenar < numeroMinimo);
//         return variableRellenar;
//     }

//     // FUNCION PARA PEDIR UN DOUBLE CON TRYCATCH (NECESITA LAS 2 FUNCIONES DE
//     // MENSAJES)
//     public static double controlErroresDouble(Scanner scanner, double rango, String mensajePedir, String mensajError) {
//         double variableRellenar;
//         do {
//             mensajeMismaLineaString(mensajePedir);
//             try {
//                 variableRellenar = Double.parseDouble(scanner.nextLine());
//             } catch (Exception e) {
//                 variableRellenar = rango - 1;
//                 mensajeMismaLineaString(mensajError);
//             }
//         } while (variableRellenar < rango);
//         return variableRellenar;
//     }

//     // ================== NUMERO ALEATORIO ==================

//     // FUNCION NUMERO ALEATORIO CON UN MINIMO Y MAXIMO ENTERO
//     public static int numeroRandomEntero(int min, int max) {
//         int numeroAleatorio;
//         numeroAleatorio = (int) (Math.random() * (max - min + 1)) + min;
//         return numeroAleatorio;
//     }

//     // ================== MOSTRAR ==================
//     // FUNCION PARA MOSTRAR ARRAYS POR PANTALLA (ARRAYLIST STRING Y NECESITA LA
//     // FUNCION MENSAJENUEVALINEA)
//     public static void mostrarArrayString(ArrayList<String> arrayAMostrar, String SEPARADOR) {
//         String mensaje = "";
//         if (!arrayAMostrar.isEmpty()) {
//             for (int i = 0; i < arrayAMostrar.size(); i++) {
//                 mensaje += arrayAMostrar.get(i) + " " + SEPARADOR+" ";
//             }
//             mensaje = mensaje.substring(0, mensaje.length() - SEPARADOR.length() - 1);
//             mensajeNuevaLineaString(mensaje);
//         }
//     }

//     // FUNCION PARA MOSTRAR ARRAYS DE INT
//     public static void mostrarArrayInt(ArrayList<Integer> arrayAMostrar, String SEPARADOR) {
//         String mensaje = "";
//         if (!arrayAMostrar.isEmpty()) {
//             for (int i = 0; i < arrayAMostrar.size(); i++) {
//                 mensaje += arrayAMostrar.get(i) + " " + SEPARADOR+" ";
//             }
//             mensaje = mensaje.substring(0, mensaje.length() - SEPARADOR.length() - 1);
//             mensajeNuevaLineaString(mensaje);
//         }
//     }

//     // FUNCION PARA MOSTRAR ARRAYS DE DOUBLE
//     public static void mostrarArrayDouble(ArrayList<Double> arrayAMostrar, String SEPARADOR) {
//         String mensaje = "";
//         if (!arrayAMostrar.isEmpty()) {
//             for (int i = 0; i < arrayAMostrar.size(); i++) {
//                 mensaje += arrayAMostrar.get(i) + " " + SEPARADOR+" ";
//             }
//             mensaje = mensaje.substring(0, mensaje.length() - SEPARADOR.length() - 1);
            
//             mensajeNuevaLineaString(mensaje);
//         }
//     }

//     // ================== BUSCAR ==================

//     // FUNCION PARA BUSCAR UN ELEMENTO EN ARRAYLIST STRING
//     public static int buscarEnArrayString(ArrayList<String> array, String elemento) {
//         int numeroEncontrado = -1;
//         for (int i = 0; i < array.size(); i++) {
//             if (array.get(i).equals(elemento)) {
//                 numeroEncontrado = i;
//             }
//         }
//         return numeroEncontrado;
//     }

//     public static int buscarEnArrayInt(ArrayList<Integer> array, int elemento) {
//         int numeroEncontrado = -1;
//         for (int i = 0; i < array.size(); i++) {
//             if (array.get(i) == elemento) {
//                 numeroEncontrado = i;
//             }
//         }
//         return numeroEncontrado;
//     }

//     // FUNCIÓN PARA BUSCAR UN ELEMENTO EN ARRAYLIST DOUBLE
//     public static int buscarEnArrayDouble(ArrayList<Double> array, double elemento) {
//         int numeroEncontrado = -1;
//         for (int i = 0; i < array.size(); i++) {
//             if (array.get(i) == elemento) {
//                 numeroEncontrado = i;
//             }
//         }
//         return numeroEncontrado;
//     }

//     // ================== PEDIR STRING ==================
//     // FUNCION PARA PEDIR UN STRING NO VACÍO
//     public static String pedirStringNoVacio(Scanner scanner, String mensajePedir, String mensajError) {
//         String texto;
//         do {
//             mensajeMismaLineaString(mensajePedir);
//             texto = scanner.nextLine().trim();
//             if (texto.isEmpty()) {
//                 mensajeNuevaLineaString(mensajError);
//             }
//         } while (texto.isEmpty());
//         return texto;
//     }

//     public static void main(String[] args) {
//         Scanner scanner = new Scanner(System.in);
//         // Variables de diferentes tipos
//         int numeroEntero = 0;
//         double numeroDecimal = 0.0;
//         String textoUsuario = "";
//         Boolean ejecutar;
//         // ArrayLists de diferentes tipos
//         ArrayList<Integer> numerosEnteros = new ArrayList<Integer>();
//         ArrayList<Double> numerosDecimales = new ArrayList<Double>();
//         ArrayList<String> nombres = new ArrayList<String>();
//         scanner.close();
//     }
// }
