package ejercicios.REPASO;

import java.util.ArrayList;
import java.util.Scanner;

public class revisiones {

    public static void mensajeNuevaLinea(String stringMostrar) {

        System.out.println(stringMostrar);

    }

    public static void mensajeMismaLinea(String stringMostrar) {

        System.out.print(stringMostrar);

    }

    public static int pedirRango(Scanner scanner, String menuString, String opcionString, String mensajeError,
            int minimoR, int maximoR) {
        int opcionMenu = 0;
        do {
            mensajeNuevaLinea(menuString);
            mensajeMismaLinea(opcionString);
            try {
                opcionMenu = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                opcionMenu = -1;
                mensajeNuevaLinea(mensajeError);
            }
        } while (opcionMenu < minimoR || opcionMenu > maximoR);
        return opcionMenu;
    }

    public static void pedirDatos(Scanner scanner, ArrayList<String> matricula, ArrayList<String> tipoRevision,
            ArrayList<Integer> extras, ArrayList<Double> coste) {
        String matriculaV;
        String servicioV;
        int numeroExtrasV;
        double precioV = 0;

        System.out.print("Introduce la Matricula del vehiculo: ");
        matriculaV = scanner.nextLine();
        matricula.addFirst(matriculaV);

        System.out.print("Introduce el tipo de revision del vehiculo: ");
        servicioV = scanner.nextLine();
        while (!servicioV.equals("basica") && !servicioV.equals("completa")) {
            System.out.print("Introduce el tipo de revision del vehiculo: ");
            servicioV = scanner.nextLine();
        }
        tipoRevision.addFirst(servicioV);
        do {
            System.out.print("Introduce el numero de extras: ");
            try {
                numeroExtrasV = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                numeroExtrasV = -2;
                System.out.println("ERROR, debes poner un valor entero igual o mayor a 0");
            }
        } while (numeroExtrasV < -1);

        extras.addFirst(numeroExtrasV);

        if (servicioV.equals("basica")) {

            precioV += 60;
        } else {
            precioV += 120;

        }
        precioV += (15 * numeroExtrasV);

        coste.addFirst(precioV);
    }

    public static void mostrarListado(ArrayList<String> matricula, ArrayList<String> tipoRevision,
            ArrayList<Integer> extras, ArrayList<Double> coste) {

        System.out.println("");
        System.out.println("LISTADO DE REVISIONES:\nIndice | Matricula | Revision | Extras | Coste");

        if (matricula.isEmpty()) {
            System.out.println("No hay vehiculos para mostras");
            System.out.println("");

        } else {
            for (int i = 0; i < matricula.size(); i++) {

                System.out.println(i + " -> " + matricula.get(i) + " | " + tipoRevision.get(i) + " | " + extras.get(i)
                        + " | " + coste.get(i));
            }
            System.out.println("");

        }
    }

    public static void eliminarRegistro(Scanner scanner, ArrayList<String> matricula, ArrayList<String> tipoRevision,
            ArrayList<Integer> extras, ArrayList<Double> coste) {
        int numeroEliminar;

        if (matricula.isEmpty()) {
            System.out.println("No hay matriculas para borrar");

        } else {

            do {
                System.out.print("Introduce el indice que quieres eliminar: ");
                try {
                    numeroEliminar = Integer.parseInt(scanner.nextLine());
                } catch (Exception e) {
                    numeroEliminar = -1;
                    System.out.println("ERROR, debes poner un valor entero igual o mayor a 0");
                }
            } while (numeroEliminar < 0 || numeroEliminar > matricula.size());

            matricula.remove(numeroEliminar);
            tipoRevision.remove(numeroEliminar);
            extras.remove(numeroEliminar);
            coste.remove(numeroEliminar);
        }

    }

    public static void mostrarCoste(Scanner scanner, ArrayList<String> matricula, ArrayList<String> tipoRevision,
            ArrayList<Integer> extras, ArrayList<Double> coste) {
        int numeroMostrar;
        String matriculaV;
        char ultimoCaracter;
        double costeActual;
        double descuento;
        double nuevoCoste;

        if (matricula.isEmpty()) {

            System.out.println("No hay matriculas para ver su coste");

        } else {

            do {
                System.out.print("Introduce el indice que quieres revisar: ");
                try {
                    numeroMostrar = Integer.parseInt(scanner.nextLine());
                } catch (Exception e) {
                    numeroMostrar = -1;
                    System.out.println("ERROR, debes poner un valor entero igual o mayor a 0");
                }
            } while (numeroMostrar < 0 || numeroMostrar > matricula.size());

            matriculaV = matricula.get(numeroMostrar);
            ultimoCaracter = matriculaV.charAt(matriculaV.length() - 1);

            if (Character.isDigit(ultimoCaracter)) {
                int numero = Character.getNumericValue(ultimoCaracter);

                if (numero % 2 == 0) {
                    costeActual = coste.get(numeroMostrar);
                    descuento = costeActual * 0.10;
                    nuevoCoste = costeActual - descuento;
                    coste.set(numeroMostrar, nuevoCoste);
                    System.out.println("Nuevo coste: " + nuevoCoste + ", El ultimo digito es par");
                } else {
                    System.out.println("El ultimo caracter es impar");
                }
            } else {
                System.out.println("El ultimo caracter no es un numero");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<String> matricula = new ArrayList<String>();
        ArrayList<String> tipoRevision = new ArrayList<String>();
        ArrayList<Integer> extras = new ArrayList<Integer>();
        ArrayList<Double> coste = new ArrayList<Double>();
        int opcion = 0;
        boolean ejecutar = true;
        final String MENU = "1. Añadir Revision\n2. Listado Revisiones\n3. Mostrar coste \n4. Eliminar Revision\n0. Salir\n";
        final String OPCION = "Seleccionar Opcion: ";
        final String ERRORANGO = "ERROR, debes poner un valor entero entre 0 y 4";

        while (ejecutar) {
            opcion = pedirRango(scanner, MENU, OPCION, ERRORANGO, 0, 4);
            if (opcion == 1) {
                pedirDatos(scanner, matricula, tipoRevision, extras, coste);
            } else if (opcion == 2) {
                mostrarListado(matricula, tipoRevision, extras, coste);
            } else if (opcion == 3) {

                mostrarCoste(scanner, matricula, tipoRevision, extras, coste);
            } else if (opcion == 4) {
                eliminarRegistro(scanner, matricula, tipoRevision, extras, coste);
            } else if (opcion == 0) {
                ejecutar = false;
            }

        }

    }

}
