/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gabriel
 */
public class Restaurantes {

    public String Nombre;
    public int estrellas;
    public List<Categorias> categorias;

    public Restaurantes(String Nombre, int estrellas) {
        this.Nombre = Nombre;
        this.estrellas = estrellas;
           categorias = new ArrayList<Categorias>();
    }
        public Restaurantes(){
        categorias = new ArrayList<Categorias>();
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getEstrellas() {
        return estrellas;
    }

    public void setEstrellas(int estrellas) {
        this.estrellas = estrellas;
    }

    public List<Categorias> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categorias> categorias) {
        this.categorias = categorias;
    }
        public void addCategorias(Categorias categorias) {
        this.categorias.add(categorias);
    }

}
