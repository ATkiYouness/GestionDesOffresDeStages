/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package models;


import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.Transient;

/**
 *
 * @author kohan
 */
@Entity
@Table(name="Etudiant")//Etudiant
@DiscriminatorValue("Etudiant")
public class Etudiant extends Utilisateur {

    @Column(name="message_Perso")
    private String  message_Perso;
    @Column(name="site_web")
    private String  site_Web;
    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(name="date_Naissance")
    private  Date    date_Naissance;
    @Transient
    private  Integer     age;
    @Column(name="situiationEtud")
    private String situiationEtu;






   

    public String getMessage_Perso() {
        return message_Perso;
    }

    public void setMessage_Perso(String message_Perso) {
        this.message_Perso = message_Perso;
    }

    public String getSite_Web() {
        return site_Web;
    }

    public void setSite_Web(String site_Web) {
        this.site_Web = site_Web;
    }

    public Date getDate_Naissance() {
        return date_Naissance;
    }

    public void setDate_Naissance(Date date_Naissance) {
        this.date_Naissance = date_Naissance;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

 

    public String getSituiationEtu() {
        return situiationEtu;
    }

    public void setSituiationEtu(String situiationEtu) {
        this.situiationEtu = situiationEtu;
    }

    
  

   public void calculeAge(){

        }

    

}
