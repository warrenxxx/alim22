/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.articulo;


import clases.CArticulo;
import static controlador.admi.SideController.borderPane;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author WARREN
 */
public class M_articulo_iniController implements Initializable {

    @FXML  TableView table;
    @FXML  Button nuevo;
    @FXML  TextField buscar;
    @FXML  TextField filterField;
    @FXML TableColumn tid,tcodigo,tnombre,tdescripcion,tcosto,tpreciodia,tprecionoche,tstock,tunidades,tcategoria;
    ObservableList<modeloArticulo> data=FXCollections.observableArrayList();
    ObservableList<modeloArticulo> filter=FXCollections.observableArrayList();;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ini();
    }

    public void insertar(ActionEvent e) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/articulo/insert_articulo.fxml"));
        VBox root = null;
        try {
            root = (VBox) loader.load();
        } catch (IOException ex) {
            Logger.getLogger(M_articulo_iniController.class.getName()).log(Level.SEVERE, null, ex);
        }
        borderPane.setCenter(root);

    }

    public void ini() {           
        tnombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        tcodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        tid.setCellValueFactory(new PropertyValueFactory<>("id"));
        tdescripcion.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
        tcosto.setCellValueFactory(new PropertyValueFactory<>("costo"));
        tpreciodia.setCellValueFactory(new PropertyValueFactory<>("preciodia"));
        tprecionoche.setCellValueFactory(new PropertyValueFactory<>("precionoche"));
        tstock.setCellValueFactory(new PropertyValueFactory<>("stock"));
        tunidades.setCellValueFactory(new PropertyValueFactory<>("unidades"));
        tcategoria.setCellValueFactory(new PropertyValueFactory<>("categoria"));
        
        table.setRowFactory(tv -> {
            TableRow<modeloArticulo> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if ((!row.isEmpty())) {
                    modeloArticulo rowData = row.getItem();
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/articulo/edit_delete_articulo.fxml"));
                    VBox root = null;
                    try {
                        root = (VBox) loader.load();
                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                    }
                    Edit_delete_articuloController pc = (Edit_delete_articuloController) loader.getController();
                    pc.setArticulo(rowData.articulo);
                    Scene sc = new Scene(root);
                    borderPane.setCenter(root);
                }
            });
            return row;
        });
        
        ArrayList<CArticulo> lista = new CArticulo().listar();
        for (CArticulo cat : lista){
            data.add(new modeloArticulo(cat));
            System.out.println(cat);
        }
        table.setItems(filter);        
        filter.addAll(data);
        filterField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                filter.clear();
                for (modeloArticulo p : data) {
                    if (buscar(p)) {
                        filter.add(p);
                    }
                }
                reapplyTableSortOrder();                
            }

        });
    }
    private boolean buscar(modeloArticulo x) {
        String filterString = filterField.getText();
        if (filterString == null || filterString.isEmpty()) {
            return true;
        }
        String lowerCaseFilterString = filterString.toLowerCase();

        if (x.getNombre().toLowerCase().indexOf(lowerCaseFilterString) != -1) return true; else
        if (x.getCategoria().toLowerCase().indexOf(lowerCaseFilterString) != -1) return true;
      
        return false; // Does not match
    }
    
    private void reapplyTableSortOrder() {
        ArrayList<TableColumn<modeloArticulo, ?>> sortOrder = new ArrayList<>(table.getSortOrder());
        table.getSortOrder().clear();
        table.getSortOrder().addAll(sortOrder);
    }
}
