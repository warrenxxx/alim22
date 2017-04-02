package controlador.admi;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import modelo.rutas;

public class SideController implements Initializable {

    public static BorderPane borderPane;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void m_productos(ActionEvent ev) throws IOException{
        FXMLLoader loader=new FXMLLoader(getClass().getResource("/vista/articulo/m_articulo_ini.fxml"));
        VBox root =(VBox)loader.load();
        root.autosize();
        borderPane.setCenter(root);
    }

    public void m_categoria(ActionEvent ev) throws IOException{
        FXMLLoader loader=new FXMLLoader(getClass().getResource("/vista/categoria/m_categoria_ini.fxml"));
        VBox root =(VBox)loader.load();
        root.autosize();
        borderPane.setCenter(root);
    }
    public void ventas(ActionEvent ev) throws IOException{
        FXMLLoader loader=new FXMLLoader(getClass().getResource("/vista/ventas/ventas.fxml"));
        VBox root =(VBox)loader.load();
        root.autosize();
        borderPane.setCenter(root);
    }
    public void usuarios(ActionEvent ev) throws IOException{
        new rutas().tousuarios();
    }
    
    public void compras(ActionEvent ev) throws IOException{
        FXMLLoader loader=new FXMLLoader(getClass().getResource("/vista/compras/compras.fxml"));
        VBox root =(VBox)loader.load();
        root.autosize();
        borderPane.setCenter(root);
    }

    public void set_border_pane(BorderPane borderPane) {
        this.borderPane=borderPane;
    }
}