/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd;

import com.mongodb.*;

/**
 *
 * @author WARREN
 */
public class conecion {
    private String database;
    private String tabla;
    private String url;
    MongoClient mongo=null;    

    public conecion(String tabla) {
        this.database="bd3";
        this.url="127.0.0.1";
        this.tabla=tabla;
    }
    
    public conecion(String database, String tabla, String url) {
        this.database = database;
        this.tabla = tabla;
        this.url = url;
    }
    public DBCollection get_colletion(){
        mongo=new MongoClient(url,27017);
        DB db=mongo.getDB(database);                      
        return db.getCollection(tabla);            
    }
    public int end(){
        try{
            if(mongo!=null)mongo.close();
        }catch(Exception e){
            return -1;
        }
        return 1;
    }
    
}
