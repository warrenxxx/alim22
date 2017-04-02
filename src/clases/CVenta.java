/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;


import bd.DVenta;


import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import org.bson.types.ObjectId;

/**
 *
 * @author WARREN
 */
public class CVenta extends C_Principal{
    
    /*
        datos. put("tipo_documento", "");
        datos. put("nro_documento", "");
        datos. put("persona_recibes", "");
        datos. put("apellidos", "");
        datos. put("fecha_nacimiento", "");
        datos. put("sexo", "");
        datos. put("email", "");
        datos. put("id_usuario", "");
        datos. put("id_entidad", "");
    */
    private final String fecha_hora="fecha_hora";
    private final String persona_atendida="persona_atendida";
    private final String venta_detalle="venta_detalle";
    
    public CVenta(ObjectId id,Date fecha_hora, String persona_atendida) {
        datos=new HashMap();
//        this.id=id;
        setfecha_hora(fecha_hora);
        setPersona_atendida(persona_atendida);
        n=this.datos.size();
    } 
    public CVenta(){       
        this.datos=new HashMap();
        n=this.datos.size();
    }
    
    public String getid(){
        return String.valueOf( this.datos.get("id"));
    }
    public void Autoid(){
        int k=new DVenta().listar().size();
        this.datos.put("id", k);
    }
    public void setfecha_hora(Date x){
        this.datos.put(fecha_hora, x);
    }
    public Date getfecha_hora(){
        return (Date) this.datos.get(fecha_hora);        
    }
    public void setPersona_atendida(String x){
        this.datos.put(persona_atendida, x);
    }
    public Double getPersona_atendida(){
        return (Double) this.datos.get(persona_atendida);        
    }
   
    
    public void addVenta_detalle(CVenta_detalle x){

        ArrayList<HashMap> l=(ArrayList) this.datos.get(venta_detalle);
        if(l==null)l=new ArrayList<HashMap>();
        HashMap aux=x.get_datos();
        aux.put("id", l.size());
        l.add(aux);
        this.datos.put(venta_detalle, l);
    }

    public ArrayList <CVenta_detalle> getVenta_detalle(){
        ArrayList<CVenta_detalle> x=new ArrayList();
        ArrayList<HashMap> y=( ArrayList )this.datos.get(venta_detalle);
        for(HashMap h:y){
            CVenta_detalle d=new CVenta_detalle();    
            d.set_datos(h);
            x.add((CVenta_detalle) d);
        }
        return   x;  
    }
    public CVenta_detalle getVenta_detalle(int a){
        return   (CVenta_detalle) ( (ArrayList)this.datos.get(venta_detalle)).get(a);        
    }
    public void setVenta_detalle(CVenta_detalle x,int a){
        ArrayList l=  (ArrayList) this.datos.get(venta_detalle);
        l.set(a, x.get_datos());
        this.datos.put(venta_detalle, l);
    }
    
    public String insertar(){
        return new DVenta().insertar(this);
    }
    public String modificar(){
        return new DVenta().modificar(this);
    }
    public String eliminar(){
        return new DVenta().eliminar(this);
    }
    
    public ArrayList<CVenta> listar(){
        return new DVenta().listar();        
    }
    public ArrayList<CVenta> listar(HashMap buscar){
        return new DVenta().listar(buscar);        
    }
    public ArrayList<CVenta> listar(String clave,String valor){
        return new DVenta().listar(clave, valor);        
    }
    
    public CVenta buscarid(String id){
        CVenta x= (CVenta) new DVenta().buscar_id(id);   
        return x;
    }
    
    
    @Override
    public String toString() {
        String aux="";
        Iterator<String> it=this.datos.keySet().iterator();
        while(it.hasNext()){
            String s=it.next();
            aux+=s+" = "+datos.get(s)+",";
        }
        return "CVenta{" +aux+'}';
    }
}
