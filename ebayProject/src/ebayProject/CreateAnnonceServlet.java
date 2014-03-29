package ebayProject;
import java.sql.*;
import java.beans.Statement;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;

import org.apache.tomcat.util.http.fileupload.*;
import org.apache.tomcat.util.http.fileupload.*;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class CreateAnnonceServlet extends HttpServlet {
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
 		     System.out.println("Connexion effective 5!");
 		     
		
 		    Connection conn = null;
 			
			conn = DriverManager.getConnection(url, user, passwd);
	
			// TODO Auto-generated catch block

		       
		java.sql.Statement statement = null;
	
			statement = conn.createStatement();
		      ResultSet resultat = null;
	
			resultat = statement.executeQuery("Select * from utilisat");
		    
			resultat.next();
 		      
 		      // Recuperatiion des données saisies
 		      String nomAn=request.getParameter("titreannonce");
 		      String descriptionAn=request.getParameter("descriptionannonce");
 		      System.out.println(request.getParameter("prixannonce"));
 		      Integer prixAn=Integer.parseInt(request.getParameter("prixannonce")); 		    
 		      String photoAn=request.getParameter("photoannonce");
 		      System.out.println(nomAn+" "+descriptionAn+" "+prixAn+" "+photoAn);
 		      String message;
 		      // Test si donnee vide ou pas
 		      if ( nomAn.trim().isEmpty() || descriptionAn.trim().isEmpty() || prixAn==0 ) {
 	            
 		    	  message = "Erreur - Vous n'avez pas rempli tous les champs obligatoires. <br> <a href=\"creerAnnonce.jsp\">Cliquez ici</a> pour accéder au formulaire de création d'un client.";
 	          } 
 		      else {
 	            message = "Annonce créé avec succès !";
 	          }
 		      
// 		      Creation d'une annonce (initialisation)
 		     Annonce annonce = new Annonce();
 	        annonce.setNomA(nomAn );
 	        annonce.setDescriptionA(descriptionAn );
 	        annonce.setPrixA(prixAn );
 	        annonce.setPhotoA(photoAn );
 	        
 	        //Ajout d'un bean annonce
 	        request.setAttribute( "annonce", annonce );
 	        request.setAttribute( "message", message );
 	         
 	       
 		    
 	        int resultat2 = statement.executeUpdate(("insert into annonce (titreannonce, descriptionannonce, prixannonce, photoannonce) values ('"+nomAn+"' ,'"+descriptionAn+"','"+prixAn+"','"+photoAn+"') "));}
// 		     
// 		     
 	        
 		      catch (Exception e) {
				// TODO: handle exception
			}
 		     this.getServletContext().getRequestDispatcher( "/affichageAnnonce.jsp" ).forward( request, response );
 		     
}
    							
    	
		
							
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}
}
