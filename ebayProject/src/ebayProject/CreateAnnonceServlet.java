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
 		     System.out.println("Connexion effective !");
 		      //request.getSession().setAttribute("utilisateurConnecté", utilisateur);
 		     //if(request.getSession().getAttribute(utilisateurConnecté) !=null){
 		    	 
 		     //}
 		     Connection conn = null;
		
				conn = DriverManager.getConnection(url, user, passwd);
		
				// TODO Auto-generated catch block

 		       
			java.sql.Statement statement = null;
		
				statement = conn.createStatement();
 		      ResultSet resultat = null;
		
				resultat = statement.executeQuery("Select * from annonce");
 		    
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
 	          } else {
 	            message = "Annonce créé avec succès !";
 	          }
 		      /* traitement image
 		     File file ;
 		    ServletContext context = getServletContext();
 		    int maxFileSize = 5000 * 1024;
 		    int maxMemSize = 5000 * 1024;
 		    String filePath = context.getInitParameter("photoannonce");

 		    // Verify the content type
 		    String contentType = request.getContentType();
 		    if ((contentType.indexOf("multipart/form-data") >= 0)) {

 		       DiskFileItemFactory factory = new DiskFileItemFactory();
 		       // maximum size that will be stored in memory
 		       factory.setSizeThreshold(maxMemSize);
 		       // Location to save data that is larger than maxMemSize.
 		       factory.setRepository(new File("c:\\temp"));

 		       // Create a new file upload handler
 		       ServletFileUpload upload = new ServletFileUpload(factory);
 		       // maximum file size to be uploaded.
 		       upload.setSizeMax( maxFileSize );
 		       try{ 
 		          // Parse the request to get file items.
 		          List fileItems = upload.parseRequest((RequestContext) request);

 		          // Process the uploaded file items
 		          Iterator i = fileItems.iterator();

 		          while ( i.hasNext () ) 
 		          {
 		             FileItem fi = (FileItem)i.next();
 		             if ( !fi.isFormField () )	
 		             {
 		             // Get the uploaded file parameters
 		             String fieldName = fi.getFieldName();
 		             String fileName = fi.getName();
 		             boolean isInMemory = fi.isInMemory();
 		             long sizeInBytes = fi.getSize();
 		             // Write the file
 		             if( fileName.lastIndexOf("\\") >= 0 ){
 		             file = new File( filePath + 
 		             fileName.substring( fileName.lastIndexOf("\\"))) ;
 		             }else{
 		             file = new File( filePath + 
 		             fileName.substring(fileName.lastIndexOf("\\")+1)) ;
 		             }
 		             fi.write( file ) ;
 		             System.out.println("Uploaded Filename: " + filePath + 
 		             fileName + "<br>");
 		             }
 		          }
 		        
 		       }catch(Exception ex) {
 		          System.out.println(ex);
 		       }
 		   
 		    }*/
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
// 		      PrintWriter pr = response.getWriter();
// 		      pr.print("Votre annonce s'est bien créée");
 	        
 		      catch (Exception e) {
				// TODO: handle exception
			}
 		     this.getServletContext().getRequestDispatcher( "/affichageAnnonce.jsp" ).forward( request, response );
 		     
}
    							
    	
		
							
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}
}
