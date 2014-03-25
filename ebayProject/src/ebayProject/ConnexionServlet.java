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
	 		     java.sql.Statement instruction = conn.createStatement();
	 		    String emailform=request.getParameter("emailuser");
 	 		    String passform=request.getParameter("password");
	            ResultSet resultat = instruction.executeQuery("select * from utilisat where emailuser='"+emailform+"' and password='"+passform+"'");
 				boolean trouv = false;

 					if (resultat != null ) 
	     				{
     					   trouv = true;
	     				}
 					if (trouv == false) {
 						JOptionPane.showMessageDialog(null,"Utilisateur non trouvé!!!" );
 					}else{
 						 this.getServletContext().getRequestDispatcher( "/createAnnonce.jsp" ).forward( request, response );
 					}
	     			}catch(Exception e1) // try
	     				{
	     					e1.printStackTrace();
	 
	     				}
	 
						
	 
	     	}

}
//		




