/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Skycraft.GUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import project.evenement.Evenement;
import project.evenement.service.EvenementService;

/**
 * FXML Controller class
 *
 * @author 21696
 */
public class SupprimerEvenementController implements Initializable {

    @FXML
    private TextField txtid;
    @FXML
    private Button btn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void suppevenement(ActionEvent event) {
         String id=txtid.getText();
         EvenementService es= new EvenementService();
          
        es.supprimerEvenement(0);
        
        
        
        
    }
    
}
