/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author kohan
 */
@Entity//ajouter les modules
@Table(name="Commune")//La Communauté
public class Commune implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    @Column(name="nomCommune",nullable=false)
    private String nomCommune;
    @Column(name="anneeDEtude", nullable=false)//l'année d'etude
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date anneeDEtude;
    @Column(name="nbEtudiants")//le nombre des etudiants
    private Integer nbreEtudiants;

    @OneToMany(mappedBy="commune_Fk")
    @OrderBy("nom ASC")
    private List<Etudiant> etudiants;

    @ManyToOne()
    @JoinColumn(name="respoCom_Fk")
    private ResCom respoCom_Fk;// le resposable comunauté

    @ManyToMany
    @JoinTable(name="Tuteur_Commune",joinColumns=@JoinColumn(name="Tuteur_Fk",
               referencedColumnName="Id")
                        ,inverseJoinColumns=@JoinColumn(name="Commune_Fk",referencedColumnName="Id"))
     private List<Tuteur> tuteurs;


    public Date getAnneeDEtude()
    {
        return anneeDEtude;
    }

    public void setAnneeDEtude(Date anneeDEtude)
    {
        this.anneeDEtude = anneeDEtude;
    }

    public Integer getNbreEtudiants()
    {
        return nbreEtudiants;
    }

    public void setNbreEtudiants(Integer nbreEtudiants)
    {
        this.nbreEtudiants = nbreEtudiants;
    }

    public String getNomCommune()
    {
        return nomCommune;
    }

    public void setNomCommune(String nomCommune)
    {
        this.nomCommune = nomCommune;
    }

    public List<Etudiant> getEtudiants() {
        return etudiants;
    }

    public void setEtudiants(List<Etudiant> etudiants) {
        this.etudiants = etudiants;
    }

    public ResCom getRespoCom_Fk() {
        return respoCom_Fk;
    }

    public void setRespoCom_Fk(ResCom respoCom_Fk) {
        this.respoCom_Fk = respoCom_Fk;
    }

    public List<Tuteur> getTuteurs() {
        return tuteurs;
    }

    public void setTuteurs(List<Tuteur> tuteurs) {
        this.tuteurs = tuteurs;
    }

  

   

  


    public void calclueNbreEtudiant()
    {

        
    }





    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Commune)) {
            return false;
        }
        Commune other = (Commune) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "models.Commune[id=" + id + "]";
    }

}
