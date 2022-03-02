/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Skycraft.GUI;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import project.evenement.Offre;
import project.evenement.service.OffreService;

/**
 * FXML Controller class
 *
 * @author 21696
 */
public class AjouterOffreController implements Initializable {

    @FXML
    private TextField txtid;
    @FXML
    private TextField txtdure;
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
    private void addoffre(ActionEvent event) {
        
        String id =txtid.getText();
    String dure = txtdure.getText();
    Offre o = new Offre(1,1,dure);
    OffreService os = new OffreService();
    os.ajouterOffre(o);
        
    
     try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AfficherOffre.fxml"));
            Parent root = loader.load();
            AfficherOffreController ac = loader.getController();
            ac.setList(os.afficherOffre().toString());
            txtid.getScene().setRoot(root);
        } catch (IOException ex) {
            //Logger.getLogger(AjouterEvenementController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
        }
    
    
    
        
        
    }
    
  
    
     
}
