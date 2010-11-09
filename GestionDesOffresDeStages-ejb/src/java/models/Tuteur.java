/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package models;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import javax.persistence.Table;

/**
 *
 * @author kohan
 */
@Entity
@Table(name="Tuteur")//le Tuteur 
@DiscriminatorValue("Tuteur")
public class Tuteur extends Utilisateur {


    

}
