package Apuntes.Apuntes_Programacion.Ejercicios.TEMA_5.Rel2.EJ1;

public class Estudiante {

    private String nombre;
    private int edad;
    private String numeroMatricula;

    Estudiante(String nombre, int edad, String numeroMatricula) {
        this.nombre = nombre;
        this.edad = edad;
        this.numeroMatricula = numeroMatricula;
    }

    /** 
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /** 
     * @return String
     */
    public String getNombre() {
        return nombre;
    }

    /** 
     * @param edad
     */
    public void setEdad(int edad) {
        if (edad>0) {
            this.edad = edad;
        }
    }

    /** 
     * @return int
     */
    public int getEdad() {
        return edad;
    }

    /** 
     * @param numeroMatricula
     */
    public void setNumeroMatricula(String numeroMatricula) {
        this.numeroMatricula = numeroMatricula;
    }

    /** 
     * @return String
     */
    public String getNumeroMatricula() {
        return numeroMatricula;
    }

    /** 
     * @return String
     */
    @Override
    public String toString() {
        return "La persona se llama: " + nombre + ". Tiene: " + edad + " años y su numero de matricula es: "
                + numeroMatricula;

    }

}
