/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package SessionBeans;

import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author kohan
 */
@Remote
public interface  GenericRemote<A,T> {


    public void     create(T t);
    public void     remove(T t);
    public void     update(T t);
    public T        findById(A id);
    public T        findByEmail(String email);//car le mail est unique
    public List<T>       findAllNonActive(String role);
    public List<T>  findAll();


}
