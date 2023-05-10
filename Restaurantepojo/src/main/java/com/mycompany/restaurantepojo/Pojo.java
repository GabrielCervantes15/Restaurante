/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restaurantepojo;

import Entity.Categorias;
import Entity.Restaurantes;
import com.mongodb.BasicDBObject;
import com.mongodb.ConnectionString;
import com.mongodb.Cursor;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import static com.mongodb.client.model.Updates.push;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import org.bson.Document;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

/**
 *
 * @author Gabriel
 */
public class Pojo {

    String BASE_DATOS = "Restaurante";
    String HOST = "localhost";
    int PUERTO = 27017;

    //INICIO DE LA CONFIGURACIÓN PARA QUE MONGODRIVE REALICE EL MAPEO DE POJOS AUMATICAMENTE
    CodecRegistry pojoCodecRegistry = fromProviders(PojoCodecProvider.builder().automatic(true).build());

    CodecRegistry codecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), pojoCodecRegistry);

    ConnectionString cadenaConexion = new ConnectionString("mongodb://" + HOST + "/" + PUERTO);

    MongoClientSettings clientsSettings = MongoClientSettings.builder()
            .applyConnectionString(cadenaConexion)
            .codecRegistry(codecRegistry)
            .build();
    //FIN DE LA CONFIGURACIÓN PARA QUE MONGODRIVE REALICE EL MAPEO DE POJOS AUMATICAMENTE

    // Conectar a la base de datos
    MongoClient mongoClient = MongoClients.create(clientsSettings);
    MongoDatabase baseDatos = mongoClient.getDatabase(BASE_DATOS);

    // Obtener la colección en la que se insertará el documento
    MongoCollection<Restaurantes> collection = baseDatos.getCollection("Restaurant", Restaurantes.class);

    public List<Restaurantes> Eje1(List<Restaurantes> lista) {
            collection.insertMany(lista);
return lista;
    }

    public List<Restaurantes> Eje2() {
        List<Restaurantes> dieguito = new ArrayList<>();
        MongoCursor<Restaurantes> restaurantes4Estrellas = collection.find(Filters.gt("estrellas", 4)).iterator();
        while (restaurantes4Estrellas.hasNext()) {
            Restaurantes restaurante = restaurantes4Estrellas.next();
            dieguito.add(restaurante);
        }

        return dieguito;
    }
        public List<Restaurantes> Eje3() {
        List<Restaurantes> dieguito = new ArrayList<>();
        MongoCursor<Restaurantes> restaurantes4Estrellas = collection.find(Filters.eq("categorias.nombre", "Pizza")).iterator();
        while (restaurantes4Estrellas.hasNext()) {
            Restaurantes restaurante = restaurantes4Estrellas.next();
            dieguito.add(restaurante);
            
        }
   for (Restaurantes ejem:dieguito) {
            System.out.println(ejem.getNombre());
        } 
        return dieguito;
    }

    public List<Restaurantes> Eje4() {
          List<Restaurantes> dieguito = new ArrayList<>();
        MongoCursor<Restaurantes> restaurantes4Estrellas = collection.find(Filters.regex("nombre", "Sushi","i")).iterator();
        while (restaurantes4Estrellas.hasNext()) {
            Restaurantes restaurante = restaurantes4Estrellas.next();
            dieguito.add(restaurante);
            
        }
   for (Restaurantes ejem:dieguito) {
            System.out.println(ejem.getNombre());
        } 
        return dieguito;
    }
    
       public boolean Eje5(String nombre,Categorias categoria) {
          Bson cate=push("categorias",categoria);
       UpdateResult dell= collection.updateOne(Filters.eq("nombre", nombre),cate);

    if (dell.getModifiedCount()!=0) {
          System.out.println("SI SE AGREGO");
     return true;   
    }else{
           System.out.println("NO SE AGREGO");
          return false;
         
      }
      
    }
       
       
       
public boolean Eje6(String id){
    
   DeleteResult dell=collection.deleteOne(Filters.eq("_id",new ObjectId(id))); 
      if (dell.getDeletedCount()!=0) {
          System.out.println("SI SE BORRO");
     return true;   
    }else{
           System.out.println("NO SE BORRO");
          return false;
         
      }
}   
public boolean Eje7(){
    
   DeleteResult dell=collection.deleteMany(Filters.lte("estrellas",3)); 
      if (dell.getDeletedCount()!=0) {
          System.out.println("SI SE BORRO");
     return true;   
    }else{
           System.out.println("NO SE BORRO");
          return false;
         
      }
}
}
