/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.evenement;

public class Evenement {
    private int id_even;
    private String commentaire,detail,date_debut,date_fin;

    public Evenement() {
    }

    public Evenement(int id_even, String commentaire, String detail, String date_debut, String date_fin) {
        this.id_even = id_even;
        this.commentaire = commentaire;
        this.detail = detail;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
    }

    public Evenement(String commentaire, String detail, String date_debut, String date_fin) {
        this.commentaire = commentaire;
        this.detail = detail;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
    }

    
   

   

   
    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Evenement{" + "id_even=" + id_even + ", detail=" + detail + ", commentaire=" + commentaire + ", date_debut=" + date_debut +", date_fin=" + date_fin +  '}';
    }

    public int getId_even() {
        return id_even;
    }

    public void setId_even(int id_even) {
        this.id_even = id_even;
    }

    public String getdetail() {
        return detail;
    }

    public void setdetail(String detail) {
        this.detail = detail;
    }

    public String getcommentaire() {
        return commentaire;
    }

    public void setcommentaire(String commentaire) {
        this.commentaire = commentaire;
    }
    public String getdate_debut() {
        return date_debut;
    }

    public void setdate_debut(String date_debut) {
        this.date_debut = date_debut;
    }
    public String getdate_fin() {
        return date_debut;
    }

    public void setdate_fin(String date_fin) {
        this.date_fin = date_fin;
    }

    public Object getNom() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Object getClassement() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   

   
    
    
}
