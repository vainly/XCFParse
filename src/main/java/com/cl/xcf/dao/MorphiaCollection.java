package com.cl.xcf.dao;

import com.cl.xcf.model.Ingredient;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import java.net.UnknownHostException;

/**
 * CREATE BY INTELLIJ IDEA
 * user: chl
 * Date: 14-2-17 下午4:54
 */
public class MorphiaCollection {

    private final String DB_NAME = "test";

    /**
     * get the default datastore
     * @return
     */
    public Datastore getDatastore(){
        Mongo mongo = null;
        try{
            mongo = new MongoClient();
        }catch (UnknownHostException e){
            e.printStackTrace();
        }catch (MongoException e){
            e.printStackTrace();
        }
        Morphia morphia = new Morphia();
        morphia.mapPackage("com.cl.xcf.model");

        return morphia.createDatastore(mongo,DB_NAME);
    }

    /**
     * get the  datastore by host,dbName
     * @return
     */
    public Datastore getDatastore(String host,String dbName){
        Mongo mongo = null;
        try{
            mongo = new MongoClient(host);
        }catch (UnknownHostException e){
            e.printStackTrace();
        }catch (MongoException e){
            e.printStackTrace();
        }
        Morphia morphia = new Morphia();
        morphia.mapPackage("com.cl.xcf.model");

        return morphia.createDatastore(mongo,dbName);
    }

    /**
     * get the  datastore by host,port,dbName
     * @return
     */
    public Datastore getDatastore(String host,int port,String dbName){
        Mongo mongo = null;
        try{
            mongo = new MongoClient(host,port);
        }catch (UnknownHostException e){
            e.printStackTrace();
        }catch (MongoException e){
            e.printStackTrace();
        }
        Morphia morphia = new Morphia();
        morphia.mapPackage("com.cl.xcf.model");
        //测试映射
        System.out.println(morphia.isMapped(Ingredient.class));

        return morphia.createDatastore(mongo,dbName);
    }


}
