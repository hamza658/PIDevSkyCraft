
package project.evenement.service;

import static com.sun.jndi.toolkit.dir.DirSearch.search;
import project.evenement.Evenement;
import project.tools.MaConnexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import static jdk.nashorn.internal.objects.NativeString.search;

public class EvenementService {
    Connection cnx;
    PreparedStatement ste;
    

    public EvenementService() {
        cnx=MaConnexion.getInstance().getCnx();
    }
    
    public void ajouterEvenement(Evenement e){
       
        try {
             String sql ="insert into evenement(commentaire,detail,date_debut,date_fin) Values(?,?,?,?)";
            ste=cnx.prepareStatement(sql);
           
            ste.setString(1, e.getcommentaire());
             ste.setString(2, e.getdetail());
            ste.setString(3, e.getdate_debut());
            ste.setString(4, e.getdate_fin());
            ste.executeUpdate();
            System.out.println("Evenement Ajoutée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
    public List<Evenement> afficherEvenement(){
        List<Evenement> evenement = new ArrayList<>();
        String sql="select * from evenement";
        try {
            ste=cnx.prepareStatement(sql);
            ResultSet rs=ste.executeQuery();
            while(rs.next()){
                Evenement e = new Evenement();
                e.setId_even(rs.getInt("id_even"));
                e.setdetail(rs.getString("detail"));
                e.setcommentaire(rs.getString("commentaire"));
                e.setdate_debut(rs.getString("date_debut"));
                e.setdate_fin(rs.getString("date_fin"));
               evenement.add(e);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return evenement;
    }

public boolean ModifierEvenement(Evenement e){
           String sql = "UPdate evenement set detail=?,date_debut=?,date_fin=? where id_even=? ";
        try {
            ste = cnx.prepareStatement(sql);
            ste.setString(1, e.getdetail());
            ste.setString(2, e.getdate_debut());
            ste.setString(3, e.getdate_fin());
            
            ste.setInt(4,e.getId_even());
            ste.executeUpdate();
            System.out.println(ste);
            
            if (ste.executeUpdate()>0){
                System.out.println("evenement modifier");
                 return true;
            }else{
                System.out.println("evenement non modifier");
                return false;
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }

        
        
    }
    public void supprimerEvenement(int id_even){
        String sql = "delete from evenement where id_even=? ";
        try {
            ste = cnx.prepareStatement(sql);
            ste.setInt(1,id_even);
            ste.executeUpdate();
            System.out.println(ste);
            System.out.println("evenement supprimer");
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
           
        }

    }
    public List<Evenement> Recherche(int id_even) {
        List<Evenement> myList = new ArrayList<>();

        try {
            String sql = "SELECT * From evenement  where id_even like '%" + id_even + "%'";
           ste=cnx.prepareStatement(sql);
            ResultSet rs = ste.executeQuery(sql);
            while (rs.next()) {
                Evenement e = new Evenement();
                e.setId_even(rs.getInt("id_even"));
                e.setcommentaire(rs.getString("commentaire"));
                e.setdate_debut(rs.getString("date_debut"));
                e.setdate_fin(rs.getString("date_fin"));
                e.setdetail(rs.getString("detail"));
                

                myList.add(e);

            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());

        }
        return myList;

    }
    

    public List<Evenement> trierEvenement(){
        List<Evenement> evenement = new ArrayList<>();
        String sql="select * from evenement ORDER BY id DESC";
        try {
           ste=cnx.prepareStatement(sql);
            ResultSet rs = ste.executeQuery(sql);
           while(rs.next()){
               Evenement e = new Evenement();
                e.setId_even(rs.getInt("id_even"));
                e.setdetail(rs.getString("detail"));
                e.setcommentaire(rs.getString("commentaire"));
                e.setdate_debut(rs.getString("date_debut"));
                e.setdate_fin(rs.getString("date_fin"));
               
                

               evenement.add(e);
               System.out.println(e.toString());
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return evenement;
    }

 

   
    
}
