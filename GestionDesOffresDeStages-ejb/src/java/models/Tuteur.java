/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package models;


import java.util.List;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import javax.persistence.Table;

/**
 *
 * @author kohan
 */
@Entity
@Table(name="Tuteur")//le Tuteur 
@DiscriminatorValue("Tuteur")
public class Tuteur extends Utilisateur {

    @ManyToMany(mappedBy="tuteurs")
    private List<Commune> communes;

    public List<Commune> getCommunes() {
        return communes;
    }

    public void setCommunes(List<Commune> communes) {
        this.communes = communes;
    }

    

 





    

}
