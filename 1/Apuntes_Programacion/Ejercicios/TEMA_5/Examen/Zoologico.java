package Apuntes.Apuntes_Programacion.Ejercicios.TEMA_5.Examen;

import java.util.ArrayList;

public class Zoologico {

    private ArrayList<Animal> animales;

    public Zoologico() {
        this.animales = new ArrayList<>();
    }

    public void agregarAnimal(Animal animal) {
        animales.add(animal);
    }

    public ArrayList<Animal> getTodosLosAnimales() {
        return animales;
    }

    public Animal buscarPorCodigo(String codigo) {
        Animal Ejemplar = null;
        for (Animal animal : animales) {
            if (animal.getCodigo().equals(codigo)) {
                Ejemplar = animal;
            }
        }
        return Ejemplar;
    }

    public boolean aniadirEjemplares(int cantidadAniadir, String codigo) {
        Animal animalAaniadir = buscarPorCodigo(codigo);
        boolean agregado = false;
        if (animalAaniadir != null) {
            animalAaniadir.setCantidad(animalAaniadir.getCantidad() + cantidadAniadir);
            agregado = true;
        }
        return agregado;
    }

    public int retirarEjemplares(int cantidadRetirar, String codigo) {
        int conseguido = 0;
        Animal animalAaniadir = buscarPorCodigo(codigo);
        if (animalAaniadir != null) {
            if (animalAaniadir.getCantidad() >= cantidadRetirar) {
                animalAaniadir.setCantidad(animalAaniadir.getCantidad() - cantidadRetirar);
            } else {
                conseguido = -1;
            }
        } else {
            conseguido = -2;
        }
        return conseguido;
    }

    public int retirarAnimal(String codigo) {
        int conseguido = 0;
        Animal animalAaniadir = buscarPorCodigo(codigo);
        if (animalAaniadir != null) {
            if (animalAaniadir.getCantidad() == 0) {
                animales.remove(animalAaniadir);
            } else {
                conseguido = -1;
            }
        } else {
            conseguido = -2;
        }
        return conseguido;
    }

}
