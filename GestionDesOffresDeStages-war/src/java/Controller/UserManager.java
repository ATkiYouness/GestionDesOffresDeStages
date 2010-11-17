/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import SessionBeans.ResComManagement;
import conf.MessagesManager;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.primefaces.context.RequestContext;

/**
 *
 * @author kohan
 */
@ManagedBean(name="Us")
@SessionScoped
public class UserManager {

   // @NotEmpty(message="Entrer une valeur")
    private String first_name;
    //@NotEmpty(message="Entrer une valeur")
    private String last_name;
    //@Email( message="Entrez email valide")
    //@NotEmpty(message="Entrer une valeur")
    private String email;
    private String civilte;
   // @NotEmpty(message="Entrer une valeur")
    private String passe;
   // @NotEmpty(message="Entrer une valeur")
    private String rpasse;
    @EJB
    private  ResComManagement rcm;
    private   String messageInfo;
    /** Creates a new instance of UserManager */
    public UserManager() {
    }

    public String getCivilte() {
        return civilte;
    }

    public void setCivilte(String civilte) {
        this.civilte = civilte;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPasse() {
        return passe;
    }

    public void setPasse(String passe) {
        this.passe = passe;
    }

    public String getRpasse() {
        return rpasse;
    }

    public void setRpasse(String rpasse) {
        this.rpasse = rpasse;
    }

    public String getMessageInfo() {
        return messageInfo;
    }

    public void setMessageInfo(String messageInfo) {
        this.messageInfo = messageInfo;
    }

   
 
         public void beforLogin(){

                    MessagesManager ms=new MessagesManager("msg");
                    FacesContext.getCurrentInstance().
                        addMessage(null,new FacesMessage(" ", ms.getValue("ResComRegister")));
                  
             }



    public void regerster(){
         MessagesManager ms= new MessagesManager("msg");
        try {


         // ResCom rsCom= new ResCom(first_name,last_name, email,civilte);
       //           rcm.create(rsCom);

    
          String str = ms.getValue("ResComRegister");
          FacesContext.
          getCurrentInstance().addMessage(null,new FacesMessage("",str));

        } catch (Exception e) {
           String str = ms.getValue("ErreurRegester");
           FacesContext.
         getCurrentInstance().addMessage(null,new FacesMessage(" ",str));
        }
       
       


    }
    //

    public String login(){

             MessagesManager ms= new MessagesManager("msg");
               FacesContext context= FacesContext.getCurrentInstance();
               RequestContext requestcontext = RequestContext.getCurrentInstance();
               boolean loggedIn=false;
            

            	if(email != null  && email.equals("admin") && passe != null  && passe.equals("admin")) {
	   		  loggedIn = true;
		          context.addMessage(civilte, new FacesMessage(" ", ms.getValue("LoggedIn")));
                          requestcontext.addCallbackParam("loggedIn",loggedIn);
                          return "views/ResCom/HomeResCom?faces-redirect=true";
		} else {
			 loggedIn = false;
                         context.addMessage(civilte, new FacesMessage(" ", ms.getValue("ErreurRegester")));
                         requestcontext.addCallbackParam("loggedIn",loggedIn);
                         return null;
		}

          
            
            
    }








    /*
     *
     *
     * les fonctions de test
     *
     *
     */




   private String test;

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }
   


   public void  montest(){



 
   }


      public void montest2(){



          MessagesManager ms= new MessagesManager("msg");
         String str = ms.getValue("ErrerurConnexionLogin");
 
          FacesContext.
          getCurrentInstance().addMessage(null,new FacesMessage("info",str));



   }

   public String pageTest(){


       return "test";
   }

}
