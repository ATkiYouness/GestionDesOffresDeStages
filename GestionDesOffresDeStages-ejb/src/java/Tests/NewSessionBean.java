/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Tests;

import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import models.Admin;
import models.Etudiant;

/**
 *
 * @author kohan
 */
@Stateless
@LocalBean
public class NewSessionBean {
    
    @PersistenceContext
    EntityManager em;


    public void ajouter(){

                Admin  a= new Admin();
                a.setActive(true);
                a.setEmail("dmlkjhg");
                a.setEtat_Civil("ddd");
                a.setNom("eee");
                a.setPrenom("ddd");
                a.setTel("ddd");
                em.persist(a);

    }
 
}
