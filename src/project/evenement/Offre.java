/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.evenement;

/**
 *
 * @author 21696
 */
public class Offre {
      private int id_offre,id;
    private String dure;

    public Offre(int id_offre, int id, String dure) {
        this.id_offre = id_offre;
        this.id = id;
        this.dure = dure;
    }

    public Offre(int id_client, String dure) {
        this.id = id;
        this.dure = dure;
    }

    public Offre() {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
  
    

    public int getId_offre() {
        return id_offre;
    }

    public void setId_offre(int id_offre) {
        this.id_offre = id_offre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDure() {
        return dure;
    }

    public void setDure(String dure) {
        this.dure = dure;
    }

    @Override
    public String toString() {
        return "Offre{" + "id_offre=" + id_offre + ", id=" + id + ", dure=" + dure + '}';
    }

}
