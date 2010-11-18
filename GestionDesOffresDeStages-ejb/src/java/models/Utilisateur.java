/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author kohan
 */
@Entity
@Table(name="Utilisateur")
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="Role", discriminatorType=DiscriminatorType.STRING)
@NamedQueries({@NamedQuery(name="findByEmail", query="SElECT res FROM Utilisateur res WHERE res.email=:email")})

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

    @Column(name="passe",nullable=false)
    private String passe;
    @Column(name="active",nullable=false)
    private boolean active;
    @Column(name="etat_Civil", nullable=false)
    private String etat_Civil;
    @Column(name="tel")
    private String tel;
    @Column(name="dateInscription", nullable=false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateInscription;
    @Column(name="dateNaissance",nullable=true)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateNnaissance;



     @OneToOne(cascade=CascadeType.ALL)
     @JoinColumn(name="adress_Fk", nullable=true)
     Adresse  adress;


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

    public String getPasse() {
        return passe;
    }

    public void setPasse(String passe) {
        this.passe = passe;
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

    public Adresse getAdress() {
        return adress;
    }

    public void setAdress(Adresse adress) {
        this.adress = adress;
    }

    public Date getDateInscription() {
        return dateInscription;
    }

    public void setDateInscription(Date dateInscription) {
        this.dateInscription = dateInscription;
    }

    public Date getDateNnaissance() {
        return dateNnaissance;
    }

    public void setDateNnaissance(Date dateNnaissance) {
        this.dateNnaissance = dateNnaissance;
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

    public Utilisateur() {
    }

    public Utilisateur(String nom, String prenom, String email,String civilite,String passe) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
      
        this.etat_Civil= civilite;
        this.passe= passe;
    }


    
    //initialisation de date et active
       @PrePersist
    void initActiveAndDateInscription(){

          active=false;
          dateInscription= new Date();

    }


    

}
