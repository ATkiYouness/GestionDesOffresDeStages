/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package conf;

import java.util.MissingResourceException;
import java.util.ResourceBundle;
import javax.faces.context.FacesContext;

/**
 *
 * @author kohan
 */
public class MessagesManager {


       private String varName;

       //mon bute c'est d'avoir un fichier propres à chaque utilisateur
    public MessagesManager(String varName) {
        this.varName = varName;
    }
        
       private ResourceBundle  rbundle;

	public ResourceBundle getRbundle() {

	//il reste le cas ou varName n'existe pas
            if (rbundle == null) {
			FacesContext context = FacesContext.getCurrentInstance();
			rbundle = context.getApplication().getResourceBundle(context, varName);
		}
		return rbundle;
	}

	public String getValue(String s) {

		String str = null;
		try {
			str = getRbundle().getString(s);
		} catch (MissingResourceException e) {
			str = "******" + s + " n'existe pas";
		}
		return str;
	}



}
