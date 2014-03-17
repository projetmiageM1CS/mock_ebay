package ebayProject;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.io.*;
import java.util.*;

public class conectBd {

		public static void main(String[] args) {
			//CTRL + SHIFT + O pour générer les import  
			    try {
			      Class.forName("org.postgresql.Driver");
			      System.out.println("Driver O.K.");
			      String url = "jdbc:postgresql://localhost:5432/bdebayproject";
			      String user = "postgres";
			      String passwd = "poste789";

			      Connection conn = DriverManager.getConnection(url, user, passwd);
			      System.out.println("Connexion effective !");  
			      Statement statement = conn.createStatement();
			      ResultSet resultat = statement.executeQuery("Select* from Produit");
			      resultat.next();
			      	int IDprdt = resultat.getInt("IDPrdt");
			      	int IDcat = resultat.getInt("IDCat");
				    String Nom = resultat.getString("NomPrdt");
				    String description= resultat.getString("DescPrdt");
				    String image = resultat.getString("img_prdt");
				    int  prix = resultat.getInt("prix");
				    System.out.println("Liste de mes produits");
				    System.out.println("id : "+IDprdt+" nom : "+Nom+" description : "+description+"categorie :"+IDcat);
			         
			    } catch (Exception e) {
			      e.printStackTrace();
			    }  
			    
			   
			  }
			

		}




