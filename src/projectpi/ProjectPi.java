
package projectpi;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProjectPi {
    static Connection cnx;
    static String url ="jdbc:mysql://localhost:3306/skycraft";
    static String user="root";
    static String pwd="";
    static Statement ste;

    public static void main(String[] args) {
        try {
            try {
                cnx=DriverManager.getConnection(url, user, pwd);
                System.out.println("Connexion etablie");
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
           // String sql="INSERT INTO `personne`(`id`, `nom`, `prenom`) VALUES (1,'Ben foulen','foulen')";
            ste=cnx.createStatement();
           // ste.executeUpdate(sql); // L'ajout d'une personne
           // System.out.println("Personne Ajoutée");
           String sql="select * from evenement";
           ResultSet result=ste.executeQuery(sql);
           while(result.next()){
               int id =result.getInt("id");
               String detail=result.getString("detail");
               String commentaire= result.getString("commentaire");
               String date_debut= result.getString("date_debut");
               String date_fin= result.getString("date_fin");
               
               System.out.println("ID : "+id+"\ndetail : "+detail+"\ncommentaire : "+commentaire+"\ndate_debut : "+date_debut+"\ndate_fin : "+date_fin );
               
           }
           
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static Object getInstance() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
