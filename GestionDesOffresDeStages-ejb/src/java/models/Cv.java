/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package models;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author kohan
 */
@Entity
@Table(name="Cv")
public class Cv implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titre;
    private boolean publicc;
    private boolean disponible;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name="etudiant_fk")
    private Etudiant etudaint_Fk;

    @OneToMany(mappedBy="cv_Fk",cascade=CascadeType.REMOVE)
    private List<Formation> formations;
    @OneToMany(mappedBy="cv_Fk",cascade=CascadeType.REMOVE)
    List<Projet> projets;
    @OneToMany(mappedBy="cv_Fk",cascade=CascadeType.REMOVE)
    List<Experience> experiences;
    @OneToMany(mappedBy="cv_Fk",cascade=CascadeType.REMOVE)
    List<Autre>  autres;
    @OneToMany(mappedBy="cv_Fk",cascade=CascadeType.REMOVE)
    List<Competence> competences;
    @OneToMany(mappedBy="cv_Fk",cascade=CascadeType.REMOVE)
    List<Experience> Experiences;

    public List<Experience> getExperiences() {
        return Experiences;
    }

    public void setExperiences(List<Experience> Experiences) {
        this.Experiences = Experiences;
    }

    public List<Autre> getAutres() {
        return autres;
    }

    public void setAutres(List<Autre> autres) {
        this.autres = autres;
    }

    public List<Competence> getCompetences() {
        return competences;
    }

    public void setCompetences(List<Competence> competences) {
        this.competences = competences;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public Etudiant getEtudaint_Fk() {
        return etudaint_Fk;
    }

    public void setEtudaint_Fk(Etudiant etudaint_Fk) {
        this.etudaint_Fk = etudaint_Fk;
    }

 

    public List<Formation> getFormations() {
        return formations;
    }

    public void setFormations(List<Formation> formations) {
        this.formations = formations;
    }

    public List<Projet> getProjets() {
        return projets;
    }

    public void setProjets(List<Projet> projets) {
        this.projets = projets;
    }

    public boolean isPublicc() {
        return publicc;
    }

    public void setPublicc(boolean publicc) {
        this.publicc = publicc;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
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
        if (!(object instanceof Cv)) {
            return false;
        }
        Cv other = (Cv) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Cv[id=" + id + "]";
    }

}
