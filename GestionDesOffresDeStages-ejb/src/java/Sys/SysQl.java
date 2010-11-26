/*
 * 
 * 
 */

package Sys;


import java.util.Properties;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.jasypt.util.password.BasicPasswordEncryptor;

/**
 *
 * @author kohan
 */
public class SysQl {

    public SysQl() {

    }

   //ma fonction de crypatge 
     public static  String crypePasse(String pass){
         
         return new BasicPasswordEncryptor().encryptPassword(pass);
     }

     // fonction pour vérifier le passe
       public static boolean checkpass(String passIn,String encryptePass){

           return new BasicPasswordEncryptor().checkPassword(passIn, encryptePass);

       }

      public static String pageUser(String role){

         if (role != null) 
	    if (role.equals ("ResCom"))
                  {return "views/Admin/indexAdmin?faces-redirect=true" ;}
	     if (role.equals ("Admin")) { return null ; }
         else
             return null;
	 

      }
      //fonction pour alerter l'utilisateur
      //je utilise un simple compte gamil pour l'envoie des mails
      public static  void sendAlertMail(String email){

         //info
        Properties props = new Properties();
    	props.put("mail.smtp.host", "smtp.googlemail.com");
    	props.put("mail.smtp.socketFactory.port", "465");
	props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
	props.put("mail.smtp.port", "465");

           Session session = Session.getDefaultInstance(props,
	new javax.mail.Authenticator()
	{
            @Override
		protected PasswordAuthentication getPasswordAuthentication()
		{ return new PasswordAuthentication("masterql.g@gmail.com","masterql2010");	}
	});
          try {

            Message message = new MimeMessage(session);
	    
	    message.setRecipients(Message.RecipientType.TO,
                        InternetAddress.parse(email));
	    message.setSubject("MasterQl Test");
	    message.setText("Félicitations, la création de votre compte est terminée."
                    + ""
                    + ""
                    + "");



	    Transport.send(message);

          } catch (Exception e) {

              
          }


      }

  

}
