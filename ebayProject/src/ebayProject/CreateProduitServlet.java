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
public class CreateProduitServlet extends HttpServlet {
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
		
				resultat = statement.executeQuery("Select * from produit");
 		    
				resultat.next();
 		      
 		      // Recuperatiion des données saisies
 		      String nomPr=request.getParameter("nomprdt");
 		      String descriptionPr=request.getParameter("descprdt");
// 		      System.out.println(request.getParameter("prixannonce"));
 		      Integer prixPr=Integer.parseInt(request.getParameter("prix")); 		    
 		      String photoPr=request.getParameter("imgprdt");
 		      System.out.println(nomPr+" "+descriptionPr+" "+prixPr+" "+photoPr);
 		      String message;
 		      // Test si donnee vide ou pas
 		      if ( nomPr.trim().isEmpty() || descriptionPr.trim().isEmpty() || prixPr==0 ) {
 	            message = "Erreur - Vous n'avez pas rempli tous les champs obligatoires. <br> <a href=\"creerAnnonce.jsp\">Cliquez ici</a> pour accéder au formulaire de création d'un client.";
 	          } else {
 	            message = "Annonce créé avec succès !";
 	          }
 		      
// 		      Creation d'une annonce (initialisation)
 		     Produit produits = new Produit();
 		    produits.setNomP(nomPr);
 		   produits.setDescp(descriptionPr);
 		  produits.setPrixP(prixPr);
 		 produits.setImgP(photoPr);
 	        
 	        //Ajout d'un bean annonce
 	        request.setAttribute( "produits", produits );
 	        request.setAttribute( "message", message );
 	       
 		      
 		      
 		    
		int resultat2 = statement.executeUpdate(("insert into produit (nomprdt, descprdt,prix, imgprdt) values ('"+nomPr+"' ,'"+descriptionPr+"','"+prixPr+"','"+photoPr+"') "));}
// 		     
// 		      PrintWriter pr = response.getWriter();
// 		      pr.print("Votre annonce s'est bien créée");
 	        
 		      catch (Exception e) {
				// TODO: handle exception
			}
 		     this.getServletContext().getRequestDispatcher( "/affichageAnnonce.jsp" ).forward( request, response );
 		     
}
    							
    	
		
							
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}
}
