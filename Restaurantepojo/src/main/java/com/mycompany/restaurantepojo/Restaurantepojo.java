/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.restaurantepojo;

import Entity.Categorias;
import Entity.Restaurantes;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gabriel
 */
public class Restaurantepojo {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        Pojo a = new Pojo();

        List<Restaurantes> listas = new ArrayList<>();
        Categorias pizza = new Categorias("Pizza");

        Categorias hamburguesa = new Categorias("Hamburguesa");
        Categorias sushi = new Categorias("Sushi");
        Categorias tacos = new Categorias("tacos");
        Categorias nuggets = new Categorias("Nuggets");

        Restaurantes resta1 = new Restaurantes("Sushilito", 3);
        resta1.addCategorias(sushi);
        resta1.addCategorias(tacos);

        listas.add(resta1);

        Restaurantes resta2 = new Restaurantes("Buger King", 1);
        resta2.addCategorias(hamburguesa);
        resta2.addCategorias(nuggets);

        listas.add(resta2);

        Restaurantes resta3 = new Restaurantes("Little Ceasar", 5);
        resta3.addCategorias(nuggets);
        resta3.addCategorias(pizza);

        listas.add(resta3);

        System.out.println("-------------EJERCICIO 1-------------");
        //a.Eje1(listas);

        List<Restaurantes> hola1 = a.Eje2();
        System.out.println("-------------EJERCICIO 2-------------");
        for (Restaurantes ejem : hola1) {
            System.out.println(ejem.getNombre());
        }

        System.out.println("-------------EJERCICIO 3-------------");
        a.Eje3();

        System.out.println("-------------EJERCICIO 4-------------");
        a.Eje4();

        System.out.println("-------------EJERCICIO 5-------------");
        a.Eje5("Sushilito", pizza);

        System.out.println("-------------EJERCICIO 6-------------");
        a.Eje6("645afc62de5917ce55f6e0fe");

        System.out.println("-------------EJERCICIO 7-------------");
        a.Eje7();
    }
}
