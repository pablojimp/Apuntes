// Define una interfaz DispositivoInteligente con los métodos encender(), apagar() y conectarWiFi(). 
// Cada método debe devolver una cadena indicando la acción realizada.
// Luego, crea dos clases concretas: Smartphone y SmartTV. 
// Cada clase debe implementar la interfaz y proporcionar una implementación específica para cada método.
// Implementa una clase Main para probar la creación de objetos y la llamada a los métodos de la interfaz.
    interface DispositivoInteligente{
        String encender();
        String apagar();
        String conectarWiFi();
    }


