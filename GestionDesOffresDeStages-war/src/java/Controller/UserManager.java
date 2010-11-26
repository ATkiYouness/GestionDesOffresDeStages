/*
 *
 *
 *
 *
 *
 *
 */

package Controller;

import SessionBeans.ResComManagement;
import SessionBeans.UtilisateurManagement;
import Sys.SysQl;
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
    private UtilisateurManagement um;
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


                  
         

              ResCom rsCom= new ResCom(first_name,last_name, email,civilte,
                                 SysQl.crypePasse(passe));
              um.create(rsCom);

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
  
           /*
            * pour se connecter  
            * vérifier si le mail existe dan la base
            * puis vérifier si le mot de passe et correcte
            * puis vérfier si le compte est active
            */
    public String login(){
               MessagesManager ms= new MessagesManager("msg");
               FacesContext context= FacesContext.getCurrentInstance();
               RequestContext requestcontext = RequestContext.getCurrentInstance();
               boolean loggedIn=false;

               utilisateur =null;
        try{
            utilisateur=um.findByEmail(email);
             
            if( SysQl.checkpass(passe, utilisateur.getPasse())) {
                        if(utilisateur.isActive()){
	   		  loggedIn = true;
		          context.addMessage(civilte, new FacesMessage(FacesMessage.SEVERITY_INFO," ", ms.getValue("LoggedIn")));
                          requestcontext.addCallbackParam("loggedIn",loggedIn);
                           
                          return  SysQl.pageUser(utilisateur.getRole());
                          }
                         loggedIn = false;
                         context.addMessage(civilte, new FacesMessage(FacesMessage.SEVERITY_ERROR," ", ms.getValue("ErreurActive")));
                         requestcontext.addCallbackParam("loggedIn",loggedIn);
                         return null;
		   }
            else   {
			 loggedIn = false;
                         context.addMessage(civilte, new FacesMessage(FacesMessage.SEVERITY_ERROR," ", ms.getValue("ErreurPasse")));
                         requestcontext.addCallbackParam("loggedIn",loggedIn);
                         return null;
	         	}

            }catch (Exception e) {
            
                loggedIn = false;
                context.addMessage(civilte, new FacesMessage(FacesMessage.SEVERITY_ERROR," ", ms.getValue("ErreurLogin")));
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


 

}
