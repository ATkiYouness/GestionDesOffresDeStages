/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import SessionBeans.UtilisateurManagement;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import models.ResCom;
import models.Utilisateur;

/**
 *
 * @author kohan
 */
@ManagedBean(name="Aa")
@RequestScoped
public class AdminActions {


    //liste des ResCOm non activé
    private List<Utilisateur> listRCNs;

    @EJB
    private UtilisateurManagement um;


    public List<Utilisateur> getListRCNs() {
        return um.findAllNonActive("ResCom");
      
    }

    public void setListRCNs(List<Utilisateur> listRCNs) {
        this.listRCNs = listRCNs;
    }


    public AdminActions() {
    }




}
