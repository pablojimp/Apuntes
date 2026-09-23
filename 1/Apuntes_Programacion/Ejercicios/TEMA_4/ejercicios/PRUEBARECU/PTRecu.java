package ejercicios.PRUEBARECU;
import java.util.ArrayList;
import java.util.Scanner;

public class PTRecu {

    public static int mostrarmenu(Scanner scanner) {
        int opcionMenu = 0;
        do {
            System.out.println(
                    "1. Añadir Estudiante\n2. Mostrar Listado Completo\n3. Mostrar estudiante con mas nota y con mas asistencia\n4. Eliminar Estudiante\n5. Salir");
            System.out.print("Seleccionar Opcion: ");
            try {
                opcionMenu = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                opcionMenu = -1;
                System.out.println("ERROR, debes poner un valor entero entre 1 y 5");
            }
        } while (opcionMenu < 1 || opcionMenu > 5);

        return opcionMenu;
    }

    public static int pedirNotaValida(Scanner scanner) {

        int nuevaNotaFuncion;
        do {
            System.out.print("Nota: ");
            try {
                nuevaNotaFuncion = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                nuevaNotaFuncion = -1;
                System.out.println("ERROR, debes poner un valor entero entre 0 y 10");
            }
        } while (nuevaNotaFuncion < 0 || nuevaNotaFuncion > 10);

        return nuevaNotaFuncion;
    }

    public static int pedirAsistenciaValida(Scanner scanner) {
        int nuevaAsistenciaFuncion;
        do {
            System.out.print("Asistencia: ");
            try {
                nuevaAsistenciaFuncion = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                nuevaAsistenciaFuncion = -1;
                System.out.println("ERROR, debes poner un valor entero entre 0 y 100");
            }
        } while (nuevaAsistenciaFuncion < 0 || nuevaAsistenciaFuncion > 100);

        return nuevaAsistenciaFuncion;
    }

    public static void mostrarListado(ArrayList<String> nombres, ArrayList<Integer> notas,
            ArrayList<Integer> asistencia) {
        String mensajeMostrar = "";
        System.out.println("Listado De Estudiantes: ");
        System.out.println(" ");
        mensajeMostrar = "";
        for (int i = 0; i < nombres.size(); i++) {
            mensajeMostrar += "Nombre " + nombres.get(i) + " - Nota: " + notas.get(i) + " - Asistencia: "
                    + asistencia.get(i) + "%\n";
        }
        System.out.println(mensajeMostrar);
    }

    public static int buscarEstudiante(ArrayList<String> nombres, String nombreEliminar) {
        int posicion = -1;
        for (int i = 0; i < nombres.size(); i++) {
            if (nombres.get(i).equals(nombreEliminar)) {
                posicion = i;
            }
        }
        return posicion;
    }

    public static void mostrarMejores(ArrayList<String> nombres, ArrayList<Integer> notas,
            ArrayList<Integer> asistencia) {
        int mejorNota;
        int mejorAsistencia;
        String nombreNota = "";
        String nombreAsistencia = "";

        if (nombres.isEmpty()) {
            System.out.println("No hay estudiantes registrados");
        } else {

            mejorNota = notas.get(0);
            mejorAsistencia = asistencia.get(0);

            for (int i = 1; i < notas.size(); i++) {
                if (mejorNota < notas.get(i)) {
                    mejorNota = notas.get(i);
                    nombreNota = nombres.get(i);
                }

            }

            System.out.println("La mejor nota: " + nombreNota + " (" + mejorNota + ")");

            for (int i = 1; i < notas.size(); i++) {
                if (mejorAsistencia < asistencia.get(i)) {
                    mejorAsistencia = asistencia.get(i);
                    nombreAsistencia = nombres.get(i);
                }

            }
            System.out.println("La mejor asistencia: " + nombreAsistencia + " (" + mejorAsistencia + ")");
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> nombres = new ArrayList<String>();
        ArrayList<Integer> notas = new ArrayList<Integer>();
        ArrayList<Integer> asistencia = new ArrayList<Integer>();
        boolean ejecutar = true;
        int opcion = 0;
        String nuevoNombre = "";
        int nuevaNota = 0;
        int nuevaAsistencia = 0;
        String nombreEliminar = "";
        int posicionEliminar = 0;

        while (ejecutar) {
            opcion = mostrarmenu(scanner);


            
            if (opcion == 1) {
                System.out.print("Nombre: ");
                nuevoNombre = scanner.nextLine();
                nuevaNota = pedirNotaValida(scanner);
                nuevaAsistencia = pedirAsistenciaValida(scanner);
                nombres.addFirst(nuevoNombre);
                notas.addFirst(nuevaNota);
                asistencia.addFirst(nuevaAsistencia);
            }
            if (opcion == 2) {
                mostrarListado(nombres, notas, asistencia);
            }
            if (opcion == 3) {
                mostrarMejores(nombres, notas, asistencia);
            }
            if (opcion == 4) {
                System.out.print("Nombre a eliminar: ");
                nombreEliminar = scanner.nextLine();
                posicionEliminar = buscarEstudiante(nombres, nombreEliminar);
                if (posicionEliminar != -1) {
                    nombres.remove(posicionEliminar);
                    notas.remove(posicionEliminar);
                    asistencia.remove(posicionEliminar);
                }
            }
            if (opcion == 5) {
                ejecutar = false;
            }
        }
    }
}