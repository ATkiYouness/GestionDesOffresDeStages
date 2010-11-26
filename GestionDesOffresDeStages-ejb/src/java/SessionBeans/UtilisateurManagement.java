/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package SessionBeans;

import javax.ejb.Stateless;

import models.Utilisateur;

/**
 *
 * @author kohan
 */
@Stateless
public class UtilisateurManagement extends AGR<Long,Utilisateur> {

    public UtilisateurManagement() {
        super(Utilisateur.class);
    }




}
