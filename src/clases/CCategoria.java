/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;


import bd.DCategoria;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.bson.types.ObjectId;

/**
 *
 * @author WARREN
 */
public class CCategoria extends C_Principal{
    
    private final String nombre="nombre";
    private final String descripcion="descripcion";//cajas o bolsas paquetes
    private final String proveedor="proveedor";

    public CCategoria(ObjectId id,String nombre, String descripcion, String proveedor) {
        datos=new HashMap();
//        this.id=id;
        setId(id);
        setNombre(nombre);
        setDescripcion(descripcion);
        setProveedor(proveedor);
        n=this.datos.size();
    } 
    public CCategoria(){       
        this.datos=new HashMap();
        n=this.datos.size();
    }       
    public void setNombre(String x){
        this.datos.put(nombre, x);
    }
    public String getNombre(){
        return (String) this.datos.get(nombre);
    }    
    public void setDescripcion(String x){
        this.datos.put(descripcion, x);
    }
    public String getDescripcion(){
        return (String) this.datos.get(descripcion);        
    }
    public void setProveedor(String x){
        this.datos.put(proveedor, x);
    }
    public String getProveedor(){
        return (String) this.datos.get(proveedor);        
    }
    
    
    public String insertar(){
        return new DCategoria().insertar(this);
    }
    public String modificar(){
        return new DCategoria().modificar(this);
    }
    public String eliminar(){
        return new DCategoria().eliminar(this);
    }
    
    public ArrayList<CCategoria> listar(){
        return new DCategoria().listar();        
    }
    public ArrayList<CCategoria> listar(HashMap buscar){
        return new DCategoria().listar(buscar);        
    }
    public ArrayList<CCategoria> listar(String clave,String valor){
        return new DCategoria().listar(clave, valor);        
    }
    
    public CCategoria buscarid(String id){      
        CCategoria x= (CCategoria) new DCategoria().buscar_id(id);           
        return x;
    }
    
    
/*    @Override
    public String toString() {
        String aux="";
        Iterator<String> it=this.datos.keySet().iterator();
        while(it.hasNext()){
            String s=it.next();
            aux+=s+" = "+datos.get(s)+",";
        }
        return "CCategoria{" +aux+'}';
    }*/    
    @Override
    public String toString() {
        return getNombre();
    }    
}
