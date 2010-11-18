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
import models.ResCom;
import models.Utilisateur;
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

   @NotEmpty(message="Entrer une valeur")
    private String first_name;
    @NotEmpty(message="Entrer une valeur")
    private String last_name;
   @Email( message="Entrez email valide")
   @NotEmpty(message="Entrer une valeur")
    private String email;
    private String civilte;
    @NotEmpty(message="Entrer une valeur")
    private String passe;
    @NotEmpty(message="Entrer une valeur")
    private String rpasse;


    ///ustilisateur ***
    Utilisateur utilisateur;


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

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur Utilisateur) {
        this.utilisateur = Utilisateur;
    }


    

   
 
         public void beforLogin(){

                    MessagesManager ms=new MessagesManager("msg");
                    FacesContext.getCurrentInstance().
                        addMessage(null,new FacesMessage(" ", ms.getValue("ResComRegister")));
                  
             }


      //fonction d'inscription
    public void regerster(){
         MessagesManager ms= new MessagesManager("msg");
         boolean created = false;
         RequestContext requestContext=RequestContext.getCurrentInstance();
        try {

          if(!passe.equals(rpasse)){
         
          String str = ms.getValue("ErreurPassInscription");
          FacesContext.
          getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"",str));
                requestContext.addCallbackParam("created", created);
          }
          else{

              ResCom rsCom= new ResCom(first_name,last_name, email,civilte,passe);
              rcm.create(rsCom);

          String str = ms.getValue("ResComRegister");
          FacesContext.
          getCurrentInstance().addMessage(null,new FacesMessage("",str));

             created =true;
            requestContext.addCallbackParam("created", created);
                     }
        } catch (Exception e) {
           String str = ms.getValue("ErreurRegester");
           FacesContext.
         getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR," ",str));
           created =false;
            requestContext.addCallbackParam("created", created);    
        }
       
       


    }
    //
           //pour se connecter
    public String login(){

               MessagesManager ms= new MessagesManager("msg");
               FacesContext context= FacesContext.getCurrentInstance();
               RequestContext requestcontext = RequestContext.getCurrentInstance();
               boolean loggedIn=false;

               utilisateur=rcm.findByEmail(email);


            	if(utilisateur.getEmail().equalsIgnoreCase(email) && utilisateur.getPasse().equals(passe)) {
	   		  loggedIn = true;
		          context.addMessage(civilte, new FacesMessage(" ", ms.getValue("LoggedIn")));
                          requestcontext.addCallbackParam("loggedIn",loggedIn);
                          return "views/ResCom/HomeResCom?faces-redirect=true";
		} else {
			 loggedIn = false;
                         context.addMessage(civilte, new FacesMessage(FacesMessage.SEVERITY_ERROR," ", ms.getValue("ErreurRegester")));
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
   


   public String  montest(){

              utilisateur=rcm.findByEmail("kohan95@gmail.com");

              return "views/ResCom/HomeResCom";
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
