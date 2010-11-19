/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package SessionBeans;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author kohan
 */
public  abstract  class   AGR<A,T> implements GenericRemote<A, T> {


     @PersistenceContext
     protected  EntityManager em;

     private Class<T> MyModelEntite;

    public AGR(Class<T> MyModelEntite) {
        
        this.MyModelEntite = MyModelEntite;
    }



    @Override
    public void create(T t) {
       em.persist(t);
    }

    @Override
    public void remove(T t) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void update(T t) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public T findById(A id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

     @Override
     public T  findByEmail(String email){


         return (T) em.createNamedQuery("Utilisateur.findByEmail").setParameter("email", email).getSingleResult();
     }

    @Override
    public List<T> findAll() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    // en attent de trouver une autre solution
    public String getRole(String email){
       //je peux utiliser juste une ligne mais la j'aime bien comme ça ;-)
       Query query= em.createNativeQuery("select Role from Utilisateur where email = ?");
        
        query.setParameter(1,email);
        String resulta=  (String) query.getSingleResult();
                           
        return resulta;
    }







}
