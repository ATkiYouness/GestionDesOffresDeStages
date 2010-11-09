/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author kohan
 */
@Entity
@Table(name="Projet")
public class Projet implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="nomDuProjet")
    private String nomduprojet;
    @Column(name="description")
    private String description;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date  dateDuProjet;


    @ManyToOne
    @JoinColumn(name="cv_fk")
    private Cv cv_Fk;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cv getCv_Fk() {
        return cv_Fk;
    }

    public void setCv_Fk(Cv cv_Fk) {
        this.cv_Fk = cv_Fk;
    }

    public Date getDateDuProjet() {
        return dateDuProjet;
    }

    public void setDateDuProjet(Date dateDuProjet) {
        this.dateDuProjet = dateDuProjet;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String descriptio) {
        this.description = descriptio;
    }

    public String getNomduprojet() {
        return nomduprojet;
    }

    public void setNomduprojet(String nomduprojet) {
        this.nomduprojet = nomduprojet;
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
        if (!(object instanceof Projet)) {
            return false;
        }
        Projet other = (Projet) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Projet[id=" + id + "]";
    }

}
