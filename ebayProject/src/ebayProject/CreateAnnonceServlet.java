package ebayProject;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreateAnnonceServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	 /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
    	
    	 try
         {
         	 Class.forName("org.postgresql.Driver");
 		      System.out.println("Driver O.K.");
 		      String url = "jdbc:postgresql://localhost:5432/bdebayproject";
 		      String user = "postgres";
 		      String passwd = "poste789";

 		      Connection conn = DriverManager.getConnection(url, user, passwd);
 		      System.out.println("Connexion effective !");  
 		      Statement statement = conn.createStatement();
 		      ResultSet resultat = statement.executeQuery("Select * from annonce");
 		      resultat.next();
 		      //String idCategorie=request.getParameter("idCategorie");
 		      String nomAn=request.getParameter("titreannonce");
 		      String descriptionAn=request.getParameter("descriptionannonce");
 		     System.out.println(request.getParameter("prixannonce"));
 		     Integer prixAn=Integer.parseInt(request.getParameter("prixannonce"));
 		    
 		    String photoAn=request.getParameter("photoannonce");
 		      System.out.println(nomAn+" "+descriptionAn+" "+prixAn+" "+photoAn);
 		      int resultat2 = statement.executeUpdate(("insert into annonce (titreannonce, descriptionannonce, prixannonce, photoannonce) values ('"+nomAn+"' ,'"+descriptionAn+"','"+prixAn+"','"+photoAn+"') "));
             
         } catch (Throwable exc)
         {
             System.out.println(exc);
         }

}
}
