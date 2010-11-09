/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

/**
 *
 * @author kohan
 */
@Entity
@Table(name="Utilisateur")
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="Role", discriminatorType=DiscriminatorType.STRING)
public class Utilisateur implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="nom",nullable=false)
    private String nom;
    @Column(name="prenom",nullable=false)
    private String prenom;
    @Column(name="email",nullable=false, unique=true)
    private String email;
    @Column(name="active",nullable=false)
    private boolean active;
    @Column(name="etat_Civil", nullable=false)
    private String etat_Civil;
    @Column(name="tel")
    private String tel;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEtat_Civil() {
        return etat_Civil;
    }

    public void setEtat_Civil(String etat_Civil) {
        this.etat_Civil = etat_Civil;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    
    


    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Utilisateur)) {
            return false;
        }
        Utilisateur other = (Utilisateur) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Utilisateur[id=" + id + "]";
    }

}
