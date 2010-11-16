/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package SessionBeans;

import javax.ejb.Stateless;
import models.ResCom;

/**
 *
 * @author kohan
 */
@Stateless
public class ResComManagement extends AGR<Long,ResCom> {

    public ResComManagement() {
        super(ResCom.class);
    }




}
