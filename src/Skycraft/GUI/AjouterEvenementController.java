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
import project.evenement.Evenement;
import project.evenement.service.EvenementService;

/**
 * FXML Controller class
 *
 * @author 21696
 */
public class AjouterEvenementController implements Initializable {

    @FXML
    private TextField txtcommentaire;
    @FXML
    private TextField txtdetail;
    @FXML
    private TextField txtdate_debut;
    @FXML
    private TextField txtdate_fin;
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
    private void addevenement(ActionEvent event) {
        String commentaire=txtcommentaire.getText();
        String detail=txtdetail.getText();
        String date_debut=txtdate_debut.getText();
        String date_fin=txtdate_fin.getText();
        Evenement e = new Evenement(0,commentaire,detail,date_debut,date_fin);
        
        EvenementService es= new EvenementService();
        es.ajouterEvenement(e);
        
        
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AfficherEvenement.fxml"));
            Parent root = loader.load();
            AfficherEvenementController ac = loader.getController();
            ac.setList(es.afficherEvenement().toString());
            txtcommentaire.getScene().setRoot(root);
        } catch (IOException ex) {
            //Logger.getLogger(AjouterEvenementController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
        }
        
        
        
    }
    
}
