// Define una interfaz Transporte con los métodos arrancar() y detener(). Cada método debe devolver una cadena indicando la acción realizada.

// Luego, crea tres clases concretas: Autobús, Metro y Bicicleta. Cada clase debe implementar la interfaz y proporcionar una implementación específica para cada método según el tipo de transporte. En el caso de Autobús, se debe indicar la hora de salida al arrancar y la hora de parada al detener. En el caso de Metro se debe indicar el número de vagones al arrancar.

// Implementa una clase Main para probar la creación de objetos y la llamada a los métodos de la interfaz.

public class Main {

    public static void main(String[] args) {
        Autobus autobus = new Autobus("10:00", "11:00");
        Metro metro = new Metro(5);
        Bicicleta bicicleta = new Bicicleta();

        System.out.println(autobus.arrancar());
        System.out.println(autobus.detener());

        System.out.println(metro.arrancar());
        System.out.println(metro.detener());

        System.out.println(bicicleta.arrancar());
        System.out.println(bicicleta.detener());
    }

    

    
    
}
