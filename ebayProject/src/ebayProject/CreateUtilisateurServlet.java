package ebayProject;
import java.sql.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreateUtilisateurServlet extends HttpServlet{
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	
	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  
    		// Connexion à ma base de donnée
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
		
				resultat = statement.executeQuery("Select * from utilisat");
 		    
				resultat.next();
 		      
 		      // Recuperatiion des données saisies
 		      String nomU=request.getParameter("nomuser");
 		      String prenomU=request.getParameter("prenomuser");
 		     String emailU=request.getParameter("emailuser"); 		    
 		      String passwordU=request.getParameter("password");
 		      System.out.println(nomU+" "+prenomU+" "+emailU+" "+passwordU);
 		      String message;
 		      // Test si donnee vide ou pas
 		      if ( nomU.trim().isEmpty() || prenomU.trim().isEmpty() || emailU.trim().isEmpty() || passwordU.trim().isEmpty() ) {
 	            message = "Erreur - Vous n'avez pas rempli tous les champs obligatoires. <br> <a href=\"creerAnnonce.jsp\">Cliquez ici</a> pour accéder au formulaire de création d'un client.";
 	          } else {
 	            message = "votre compte a été bien créer , bienvenue sur eSway ! , bon shopping";
 	          }
 		      
// 		      Creation d'un utilisateur (initialisation)
 		     Utilisateur utilisateur = new Utilisateur();
 		    utilisateur.setNom(nomU );
 		   utilisateur.setPrenom(prenomU);
 		  utilisateur.setEmail(emailU);
 		 utilisateur.setPassword(passwordU);
 	        
 	        //Ajout d'un bean annonce
 	        request.setAttribute( "utilisateur", utilisateur );
 	        request.setAttribute( "message", message );
 	       
 		      
 		      
 		    
		int resultat2 = statement.executeUpdate(("insert into utilisat (nomuser, prenomuser, emailuser,password) values ('"+nomU+"' ,'"+prenomU+"','"+emailU+"','"+passwordU+"') "));}
// 		     
// 		      PrintWriter pr = response.getWriter();
// 		      pr.print("Votre annonce s'est bien créée");
 	        
 		      catch (Exception e) {
				// TODO: handle exception
			}
 		     this.getServletContext().getRequestDispatcher( "/authentification.jsp" ).forward( request, response );
 		     
}
    							
    	
		
							
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}
}



