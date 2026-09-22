package Apuntes.Apuntes_Programacion.Ejercicios.TEMA_5.Rel1;

public class Ejercicio8 {
    public static void main(String[] args) {
        Tele tele = new Tele(80,"Telecinco");
        System.out.println(tele);
        tele.cambiarCanal("La sexta");
        System.out.println(tele);
        tele.subirVolumen();
        System.out.println(tele);
    }
}
class Tele {
    int volumen;
    String canal;

    Tele(int volumen, String canal) {
        this.volumen = volumen;
        this.canal = canal;

    }

    void subirVolumen(){
        volumen++;
    }

    void cambiarCanal(String nuevoCanal){
        canal = nuevoCanal;
    }


    @Override
    public String toString() {
        return String.format("Tu tele esta a un volumen de: "+volumen+". Y estas viendo el canal: "+canal);
    }
}