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
@Table(name="StrectureAcc")//le Responsable de communauté
@DiscriminatorValue("StrectureAcc")
public class StructureAcc extends Utilisateur {

   @OneToMany(mappedBy="structureAcc_fk")
    private List<Offre> offres;

    public List<Offre> getOffres() {
        return offres;
    }

    public void setOffres(List<Offre> offres) {
        this.offres = offres;
    }
    

   
}
