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

	public class CreateProduitServlet extends HttpServlet{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
		 /**
	     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	     */
	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
			      ResultSet resultat = statement.executeQuery("Select * from categorie");
			      resultat.next();
			      //String idCategorie=request.getParameter("idCategorie");
			      String nomCat=request.getParameter("nomCat");
			      String descriptionCat=request.getParameter("descriptionCat");
			      System.out.println(nomCat+" "+descriptionCat);
			      ResultSet resultat2 = statement.executeQuery("insert into categorie (NomCat, DescriptionCat) values ('"+nomCat+"' ,'"+descriptionCat+"') ");
	            
	        } catch (Throwable exc)
	        {
	            System.out.println(exc);
	        }
	    }
	 
	    /**
	     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	     */

}
