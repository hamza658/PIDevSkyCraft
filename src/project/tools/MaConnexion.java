
package project.tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MaConnexion {

    public static Object getInstance;
    public String url="jdbc:mysql://localhost:3306/skycraft";
    public String user="root";
    public String pwd="";
    public static MaConnexion cn;
    private Connection cnx;
    private MaConnexion(){
        try {
            cnx=DriverManager.getConnection(url, user, pwd);
            System.out.println("Connexion etablie");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public static MaConnexion getInstance(){
        if(cn==null)
            cn= new MaConnexion();
            return cn;
      
    }

    public Connection getCnx() {
        return cnx;
    }
    
    
}