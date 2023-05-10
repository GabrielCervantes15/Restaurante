/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

import Entity.Restaurantes;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import interfaces.IConexionBD;
import interfaces.IRestaurantesDAO;

/**
 *
 * @author Gabriel
 */
public class RestaurantesDAO implements IRestaurantesDAO{
        private IConexionBD conexion;
    private MongoDatabase baseDatos;
    
      public RestaurantesDAO(IConexionBD conexion) {
        this.conexion = conexion;
        this.baseDatos = this.conexion.crearConexion();
    }
        private MongoCollection<Restaurantes> getColeccion(){
        return this.baseDatos.getCollection("Restaurant", Restaurantes.class);
    }
        @Override
    public boolean agregarUno(Restaurantes Restaurante) {
        // TODO: MANEJAR POSIBLES EXCEPCIONES...
        MongoCollection<Restaurantes> coleccion = this.getColeccion();
        coleccion.insertOne(Restaurante);
        return true;
    }
}
