package ebayProject;
import java.sql.*;
import java.beans.Statement;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

public class ConnexionServlet extends HttpServlet {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
		 
		@SuppressWarnings("unused")
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  
	    		// Connexion � ma base de donn�e
	         	 try {
	         		Class.forName("org.postgresql.Driver");
	        		
	   		      System.out.println("Driver O.K.");
	   		      String url = "jdbc:postgresql://localhost:5432/bdebayproject";
	   		      String user = "postgres";
	   		      String passwd = "poste789";
	   		     System.out.println("Connexion effective !");
	   		      
	   		     Connection conn = null;
	  		
	  				conn = DriverManager.getConnection(url, user, passwd);
	  		
	  				// TODO Auto-generated catch block

	   		       
	  			java.sql.Statement statement = null;
	  		
	  				statement = conn.createStatement();
	   		      ResultSet resultat = null;
	   		      
	   		   // Recuperatiion des donn�es saisies
	   		      String emailU=request.getParameter("emailuser"); 		    
	   		      String passwordU=request.getParameter("password");   	
	   		   HttpSession session = request.getSession();
	   		 String message;
		      // Test si donnee vide ou pas
		      if ( emailU.trim().isEmpty() || passwordU.trim().isEmpty() ) {
	            message = "Erreur - Vous n'avez pas rempli tous les champs obligatoires. <br> <a href=\"creerAnnonce.jsp\">Cliquez ici</a> pour acc�der au formulaire de cr�ation d'un client.";
	          } else {
	            message = "Vous avez �tes connect�!";
	          }
		      
//		      Creation d'un utilisateur (initialisation)
		     Utilisateur utilisateur = new Utilisateur();
		  utilisateur.setEmail(emailU);
		 utilisateur.setPassword(passwordU);
//		 utilisateur.setNom(nomU );
//		   utilisateur.setPrenom(prenomU);
//	        
	        //Ajout d'un bean annonce
	        request.setAttribute( "utilisateur", utilisateur );
	        request.setAttribute( "message", message );
	       
	  		
	  				resultat = statement.executeQuery("Select * from utilisat where emailuser='"+emailU+"' and password='"+passwordU+"'");
	   		    
	  				
 				boolean trouv = false;

 					 if(resultat.next() ) 
	     				{
     					   trouv = true;
     					  this.getServletContext().getRequestDispatcher( "/createAnnonce2.jsp" ).forward( request, response );
	     				}
 					else 
 						{
 							trouv = false;
 						JOptionPane.showMessageDialog(null,"Utilisateur non trouv�!!!" );
 						
 					
	     				}
	         	 }
 					
 					catch(Exception e1) // try
	     				{
	     					e1.printStackTrace();
	 
	     				}
	 							 	     	
}
}
		




