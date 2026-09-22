package Apuntes.Apuntes_Programacion.Ejercicios.TEMA_5.Rel2.EJ1;

import java.util.ArrayList;

public class Universidad {
    ArrayList<Estudiante> alumnado;

    Universidad() {
        this.alumnado = new ArrayList<>();
    }

    /** 
     * @param estudiante
     */
    public void agregarAlumno(Estudiante estudiante) {
        alumnado.add(estudiante);
    }

    /** 
     * @return String
     */
    public String mostrarString(){

        String lista = "";
        for (Estudiante estudiante : alumnado) {
            lista += estudiante.getNombre() + " | " ;
        }

        return lista;

    }

    /** 
     * @param matricula
     * @return Estudiante
     */
    public Estudiante buscarEstudiante(String matricula){

        Estudiante estudianteMostrar = null;
        for (Estudiante estudiante : alumnado) {
            if (estudiante.getNumeroMatricula().equals(matricula)) {

                estudianteMostrar = estudiante;
                
            }

        }
        return estudianteMostrar;
    }


}
