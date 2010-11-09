/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package test;

import Tests.NewSessionBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author kohan
 */
@ManagedBean
@RequestScoped
public class test {

    /** Creates a new instance of test */
    public test() {
    }


    private String message;

    @EJB
    NewSessionBean ns;
    public void ajouter(){

        ns.ajouter();
    message= "Bien ajouter";
    }
}
