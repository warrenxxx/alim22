package controlador.articulo;

import clases.CArticulo;
import clases.CCategoria;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author WARREN
 */

public class modeloArticulo {
    private final SimpleStringProperty id;
    private final SimpleStringProperty codigo;    
    private final SimpleStringProperty nombre;    
    private final SimpleStringProperty descripcion;
    private final SimpleStringProperty costo;
    private final SimpleStringProperty preciodia;
    private final SimpleStringProperty precionoche;
    private final SimpleStringProperty stock;
    private final SimpleStringProperty unidades;
    private final SimpleStringProperty categoria;

    public CArticulo articulo;
    
    public modeloArticulo(CArticulo x) {
        this.id=new SimpleStringProperty(x.getId().toString());
        this.codigo=new SimpleStringProperty(x.getCodigo());
        this.nombre=new SimpleStringProperty(x.getNombre());
        this.descripcion=new SimpleStringProperty(x.getDescripString());
        this.costo=new SimpleStringProperty(x.getCosto().toString());
        this.preciodia =new SimpleStringProperty(x.getPrecio_dia().toString());
        this.precionoche =new SimpleStringProperty(x.getPrecio_noche().toString());
        this.stock=new SimpleStringProperty(String.valueOf( x.getStock()));
        this.unidades=new SimpleStringProperty(String.valueOf( x.getUnidades_caja()));
        this.categoria=new SimpleStringProperty(new  CCategoria().buscarid(x.getCategoria()).toString());
//        System.out.println(this.categoria.get()+"ggggggggg");
        this.articulo=x;
    }

    public String getId() {
        return id.get();
    }

    public String getCodigo() {
        return codigo.get();
    }

    public String getNombre() {
        return nombre.get();
    }

    public String getDescripcion() {
        return descripcion.get();
    }

    public String getCosto() {
        return costo.get();
    }

    public String getPreciodia() {
        return preciodia.get();
    }

    public String getPrecionoche() {
        return precionoche.get();
    }

    public String getStock() {
        return stock.get();
    }

    public String getUnidades() {
        return unidades.get();
    }

    public String getCategoria() {
        return categoria.get();
    }


    
}
