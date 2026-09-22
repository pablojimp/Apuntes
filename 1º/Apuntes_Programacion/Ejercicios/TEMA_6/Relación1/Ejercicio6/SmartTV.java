// Define una interfaz DispositivoInteligente con los métodos encender(), apagar() y conectarWiFi(). 
// Cada método debe devolver una cadena indicando la acción realizada.
// Luego, crea dos clases concretas: Smartphone y SmartTV. 
// Cada clase debe implementar la interfaz y proporcionar una implementación específica para cada método.
// Implementa una clase Main para probar la creación de objetos y la llamada a los métodos de la interfaz.
public class SmartTV implements DispositivoInteligente {

    private boolean estadoEncendido = false;
    private boolean estadoWifi = false;

    public boolean isEstadoWifi() {
        return estadoWifi;
    }

    public void setEstadoWifi(boolean estadoWifi) {
        this.estadoWifi = estadoWifi;
    }

    public boolean isEstado() {
        return estadoEncendido;
    }

    public void setEstado(boolean estadoEncendido) {
        this.estadoEncendido = estadoEncendido;
    }

    @Override
    public String encender() {

        String mostrarMensaje;

        if (isEstado()) {
            mostrarMensaje = "Ya esta encendida la tele";
        } else {
            mostrarMensaje = "Acabas de encender la tele";
            setEstado(true);
        }
        return mostrarMensaje;
    }

    @Override
    public String apagar() {

        String mostrarMensaje;

        if (!isEstado()) {
            mostrarMensaje = "Ya esta apagada la tele";
        } else {
            mostrarMensaje = "Acabas de apagar la tele";
            setEstado(false);
        }
        return mostrarMensaje;
    }

    @Override
    public String conectarWiFi() {

        String mostrarMensaje;

        if (isEstadoWifi()) {
            mostrarMensaje = "Ya esta conectado al wifi tu tele";
        } else {
            mostrarMensaje = "Conectando...";
            setEstadoWifi(true);
        }
        return mostrarMensaje;
    }

}
