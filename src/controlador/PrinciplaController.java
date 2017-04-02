/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import clases.CPersona;
import controlador.admi.SideController;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Menu;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import static modelo.Fx2.USER;

/**
 * FXML Controller class
 *
 * @author WARREN
 */
public class PrinciplaController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML Menu file;
            
    @FXML BorderPane borderPane;
    
    public void init(String warren) throws IOException{
        file.setText(warren);
        if( warren.compareTo("1")==0){
           FXMLLoader loader=new FXMLLoader(getClass().getResource("/vista/admi/side.fxml"));
           VBox root =(VBox)loader.load();
           SideController pc=(SideController)loader.getController();        
           pc.set_border_pane(borderPane);
           borderPane.setLeft(root);        
        }
    }

    public void init(){
        System.out.println("ss");
    }
        @Override
    public void initialize(URL url, ResourceBundle rb) {
            USER=new CPersona();            
           FXMLLoader loader=new FXMLLoader(getClass().getResource("/vista/admi/side.fxml"));
           VBox root = null;
        try {
            root = (VBox)loader.load();
        } catch (IOException ex) {
            Logger.getLogger(PrinciplaController.class.getName()).log(Level.SEVERE, null, ex);
        }
           SideController pc=(SideController)loader.getController();        
           pc.set_border_pane(borderPane);
           borderPane.setLeft(root);                         
    }    
    
}
