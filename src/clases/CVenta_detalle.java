/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;


import java.util.HashMap;
import java.util.Iterator;

/**
 *
 * @author WARREN
 */
public class CVenta_detalle extends C_Principal{
    private final String cantidad="cantidad";
    private final String precio="precio";
    private final String descuento="descuento";
    private final String id_articulo="id_articulo";//cajas o bolsas paquetes
 
    public CVenta_detalle(){       
        this.datos=new HashMap();
        n=this.datos.size();
    }       
    public void setCantidad(int x){
        this.datos.put(cantidad, x);
    }
    public int getCantidad(){
        return (int) this.datos.get(cantidad);        
    }
    public void setPrecio(Double x){
        this.datos.put(precio, x);
    }
    public Double getPrecio(){
        return (Double) this.datos.get(precio);
    }
    public void setDescuento(Double x){
        this.datos.put(descuento, x);
    }
    public Double getDescuento(){
        return (Double) this.datos.get(descuento);        
    }
    
    public void setId_articulo(String x){
        this.datos.put(id_articulo, x);
    }
    public String getId_articulo(){
        return (String) this.datos.get(id_articulo);        
    }
    public CArticulo getArticuloAll(){
        System.out.println(this+"warren");
        return new CArticulo().buscarid(getId_articulo());
    }
    @Override
    public String toString() {
        String aux="";
        Iterator<String> it=this.datos.keySet().iterator();
        while(it.hasNext()){
            String s=it.next();
            aux+=s+" = "+datos.get(s)+",";
        }
        return "CArticulo{" +aux+'}';
    }
}
