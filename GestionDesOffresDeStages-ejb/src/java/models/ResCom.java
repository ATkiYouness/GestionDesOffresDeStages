/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package models;


import java.util.List;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import javax.persistence.Table;

/**
 *
 * @author kohan
 */
@Entity
@Table(name="ResCom")//le Responsable de communauté
@DiscriminatorValue("ResCom")
public class ResCom extends Utilisateur {

    public ResCom() {
        super();
    }

    public ResCom(String nom, String prenom, String email,String civilite,String passe) {
           super(nom, prenom, email,civilite,passe);

    }

 





  @OneToMany(mappedBy="respoCom_Fk")
   List<Commune> communes;

    @OneToMany(mappedBy="respoCom_Fk")
    private List<Offre> offres;

    public List<Commune> getCommunes() {
        return communes;
    }

    public void setCommunes(List<Commune> communes) {
        this.communes = communes;
    }

    public List<Offre> getOffres() {
        return offres;
    }

    public void setOffres(List<Offre> offres) {
        this.offres = offres;
    }


    
    
    

}
