/*
 * 
 * 
 */

package Sys;


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
                  {return "views/ResCom/HomeResCom?faces-redirect=true" ;}
	     if (role.equals ("Admin")) { return null ; }
         else
             return null;
	 

      }

  

}
