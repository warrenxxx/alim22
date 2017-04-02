/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.articulo;

import clases.CArticulo;
import java.util.ArrayList;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author ALIM
 */
public class modal_asignar {

    public static CArticulo display() {
        Stage wind = new Stage();
        wind.initModality(Modality.APPLICATION_MODAL);
        wind.setTitle("BUSCAR Producto");

        TextField lab1 = new TextField("");
        lab1.setPromptText("Buscar");

        ListView<CArticulo> list = new ListView<CArticulo>();
        ArrayList r = new CArticulo().listar();
        CArticulo x = new CArticulo();
        x.setAsignar("Estandar");
        x.setId("");

        ObservableList<CArticulo> items = FXCollections.observableArrayList(x);
        items.addAll(r);
        ObservableList<CArticulo> filter = FXCollections.observableArrayList(x);
        filter.addAll(new CArticulo().listar());
        list.setItems(filter);
        Button ac = new Button("Aceptar");
        ac.setOnAction(e -> {
            wind.close();
        });
        lab1.textProperty().addListener(new ChangeListener<String>() {

            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                filter.clear();

                for (CArticulo p : items) {
                    if (buscar(p, newValue)) {
                        filter.add(p);
                    }
                }
                //            ArrayList<TableColumn<CCategoria, ?>> sortOrder = new ArrayList<>(table.getSortOrder());
                //   table.getSortOrder().clear();
                //  table.getSortOrder().addAll(sortOrder);
            }

        });

        list.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                if (list.getSelectionModel().getSelectedItem() != null) {
                    x.set_datos(list.getSelectionModel().getSelectedItem().get_datos());
                }
            }
        });
        Button can = new Button("Cancelar");
        can.setOnAction(e -> {
            lab1.setText("Estandar");
            wind.close();
        });

        

        VBox vb = new VBox(10);
        vb.getChildren().addAll(lab1, list, ac, can);

        Scene SC = new Scene(vb);
        wind.setScene(SC);
        wind.showAndWait();
        return x;
    }

    private static boolean buscar(CArticulo person, String bus) {
        String filterString = bus;
        if (filterString == null || filterString.isEmpty()) {
            // No filter --> Add all.
            return true;
        }

        String lowerCaseFilterString = filterString.toLowerCase();

        if (person.getNombre().toLowerCase().indexOf(lowerCaseFilterString) != -1) {
            return true;
        } else if (person.getCategoria().toLowerCase().indexOf(lowerCaseFilterString) != -1) {
            return true;
        } else if (person.getCodigo().toLowerCase().indexOf(lowerCaseFilterString) != -1) {
            return true;
        }

        return false; // Does not match
    }
}
