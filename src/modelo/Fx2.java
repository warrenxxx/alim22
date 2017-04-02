/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import clases.CPersona;
import clases.CSession;
import java.io.IOException;
import java.util.HashMap;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TitledPane;
import javafx.stage.Stage;

/**
 *
 * @author WARREN
 */
public class Fx2 extends Application {
    public static   Stage ventana;    
    public static   CPersona USER;
    public static CSession SESSION;
    public static final String P_ESTANDAR="58cc32706585592920bafcbb";
    public static final String RUC="1010102021";
    
    
    public Parent login() throws IOException {
        Parent root1 = FXMLLoader.load(getClass().getResource("/vista/Login.fxml"));       
//        Parent root1 = FXMLLoader.load(getClass().getResource("/vista/Principla.fxml"));       
        TitledPane t1 = new TitledPane("Node 1", root1);        
        return root1;
    }
    @Override
    public void start(Stage stage) throws Exception {
//        new DPersona().ini();
        CPersona n=new CPersona();
        n.setUsuario("1");
        n.setPaswword("1");
        HashMap hm=new HashMap();
        hm.put("usuario", "1");
        hm.put("password", "1");       
        if(n.listar(n.get_datos()).size()==0){
            n.insertar();
        }
        ventana=stage;
        ventana.setTitle("warrencitopa");
        ventana.setScene(new Scene(login()));
        ventana.show();

    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
