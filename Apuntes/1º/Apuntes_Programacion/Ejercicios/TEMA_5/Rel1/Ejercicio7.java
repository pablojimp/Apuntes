package Apuntes.Apuntes_Programacion.Ejercicios.TEMA_5.Rel1;

// ### **Ejercicio 7: Clase Lampara**
// Crea una clase `Lampara` con un atributo `estado` (encendida o apagada). Agrega métodos `encender()` y `apagar()` para cambiar su estado.

public class Ejercicio7 {
    public static void main(String[] args) {
        Lampara lampara = new Lampara(true);
        System.out.println(lampara);
        lampara.estado = lampara.apagar();
        System.out.println(lampara);
        lampara.estado = lampara.encender();
        System.out.println(lampara);

    }
}
class Lampara {
    boolean estado;
    Lampara(boolean estado) {
        this.estado = estado;

    }

    boolean apagar(){
        return estado = false;
    }
    boolean encender(){
        return estado = true;
    }

    @Override
    public String toString() {
        String estadoLampara = (this.estado) ? "encendida" : "apagada";
        return String.format("Tu lampara esta " + estadoLampara);
    }
}