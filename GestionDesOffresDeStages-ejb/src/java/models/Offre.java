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
@Table(name="OffreSatge")
public class Offre implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="description", nullable=false)
    private String description ;
    @Column(name="datePublication", nullable=false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date datePublication;
    @Column(name="dateExpiration", nullable=false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateExpiration;
    @Column(name="titre", nullable=false)
    private String titre;
    @Column(name="valide", nullable=false)
    private boolean valide;

    @ManyToOne()
    @JoinColumn(nullable=true,name="structureAcc_fk")
    private StructureAcc structureAcc_fk;

    @ManyToOne()
    @JoinColumn(nullable=true,name="respoCom_Fk")
    private ResCom respoCom_Fk;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateExpiration() {
        return dateExpiration;
    }

    public void setDateExpiration(Date dateExpiration) {
        this.dateExpiration = dateExpiration;
    }

    public Date getDatePublication() {
        return datePublication;
    }

    public void setDatePublication(Date datePublication) {
        this.datePublication = datePublication;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public boolean isValide() {
        return valide;
    }

    public void setValide(boolean valide) {
        this.valide = valide;
    }

    public StructureAcc getStructureAcc_fk() {
        return structureAcc_fk;
    }

    public void setStructureAcc_fk(StructureAcc structureAcc_fk) {
        this.structureAcc_fk = structureAcc_fk;
    }

    public ResCom getRespoCom_Fk() {
        return respoCom_Fk;
    }

    public void setRespoCom_Fk(ResCom respoCom_Fk) {
        this.respoCom_Fk = respoCom_Fk;
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
        if (!(object instanceof Offre)) {
            return false;
        }
        Offre other = (Offre) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Offre[id=" + id + "]";
    }

}
