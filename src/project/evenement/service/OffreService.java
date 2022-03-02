
package project.evenement.service;
import project.evenement.Offre;
import project.tools.MaConnexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OffreService {
    Connection cnx;
    PreparedStatement ste;
    

    public OffreService() {
        cnx=MaConnexion.getInstance().getCnx();
    }
    
    public void ajouterOffre(Offre o){
       
        try {
             String sql ="insert into offre(id,dure) Values(?,?)";
            ste=cnx.prepareStatement(sql);
            ste.setInt(1, o.getId());
            ste.setString(2, o.getDure());
            
            ste.executeUpdate();
            System.out.println("offre Ajoutée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
    public List<Offre> afficherOffre(){
        List<Offre> offre = new ArrayList<>();
        String sql="select * from offre";
        try {
            ste=cnx.prepareStatement(sql);
            ResultSet rs=ste.executeQuery();
            while(rs.next()){
                Offre o = new Offre();
                o.setId_offre(rs.getInt("id_offre"));
                o.setDure(rs.getString("dure"));
                o.setId(rs.getInt("id"));
               offre.add(o);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return offre;
    }

public boolean ModifierOffre(Offre o){
           String sql = "UPdate offre set dure=? where id_offre=? ";
        try {
            ste = cnx.prepareStatement(sql);
            ste.setString(1, o.getDure());
           
            
            ste.setInt(2,o.getId_offre());
            ste.executeUpdate();
            System.out.println(ste);
            
            if (ste.executeUpdate()>0){
                System.out.println("offre modifier");
                 return true;
            }else{
                System.out.println("offre non modifier");
                return false;
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }

        
        
    }
    public void supprimerOffre(int id_offre){
        String sql = "delete from offre where id_offre=? ";
        try {
            ste = cnx.prepareStatement(sql);
            ste.setInt(1,id_offre);
            ste.executeUpdate();
            System.out.println(ste);
            System.out.println("offre supprimer");
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
           
        }

    }
 public List<Offre> Recherche(int id) {
        List<Offre> myList = new ArrayList<>();

        try {
            String sql = "SELECT * From offre  where id_offre like '%" + id + "%'";
           ste=cnx.prepareStatement(sql);
            ResultSet rs = ste.executeQuery(sql);
            while (rs.next()) {
                Offre o = new Offre();
                o.setId_offre(rs.getInt("id_offre"));
                o.setId(rs.getInt("Id"));
                o.setDure(rs.getString("Dure"));
                
                

                myList.add(o);

            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());

        }
        return myList;

    }
    public List<Offre> trierOffre(){
        List<Offre> offre = new ArrayList<>();
        String sql="select * from offre ORDER BY id_offre DESC";
        try {
           ste=cnx.prepareStatement(sql);
            ResultSet rs = ste.executeQuery(sql);
           while(rs.next()){
               Offre o = new Offre();
                o.setId_offre(rs.getInt("id_offre"));
                o.setDure(rs.getString("dure"));
                o.setId(rs.getInt("id"));
                
               
                

               offre.add(o);
               System.out.println(o.toString());
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return offre;
    }
    

    
    
}

