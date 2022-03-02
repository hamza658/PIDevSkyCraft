/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.test;

import project.evenement.Evenement;
import project.evenement.Offre;
import project.evenement.service.EvenementService;
import project.tools.MaConnexion;
import project.evenement.service.OffreService;

/**
 *
 * @author Fayechi
 */
public class test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MaConnexion m = MaConnexion.getInstance();
       
//       EvenementService es ;
//       es =new EvenementService();
//        Evenement e;
        //e= new Evenement(1,"detail","commentaire","date_debut","date_fin");
      //es.ajouterEvenement(e);
      //es.afficherEvenement();
      //e.setdetail("dett");
      //es.ModifierEvenement(e);
//System.out.println(es.afficherEvenement());
        //es.supprimerEvenement(1);
      OffreService os;
       os = new OffreService();
       //os.trierOffre();
       //os.Recherche(4);
       //System.out.println(os.Recherche(4));
        Offre o;
       o =new Offre(3,"drrrr");
        os.ajouterOffre(o);
        
        //System.out.println(os.afficherOffre());
        //Offre o1;
        //o1 = new Offre(4,1,"ppppp");
        //o1.setDure("nadhir");
        //os.ModifierOffre(o1);
       //os.supprimerOffre(2);
       
        
    }
    
}
