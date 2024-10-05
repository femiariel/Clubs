package fr.esigelec.jee;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import fr.esigelec.model.*;
public class RechercheRegionDAO {
	public  List<Club> recupererClubsRegion(String a) {
		  List<Club> clubs = new ArrayList<Club>();
		  Statement statement = null;
	      Connection connection = null;
	      ResultSet result = null;
		  
		  //Chargement du driver
		  try {
			  Class.forName("com.mysql.cj.jdbc.Driver");
		      String url = "jdbc:mysql://localhost/gasyd";
	          String user = "root";
	          String password = "root";
	          connection = DriverManager.getConnection(url, user, password);
	          
	          
	         
	         
	          
	        
	        	  String sql = " SELECT  Commune,latitude, longitude, CodePostal, nom_federation FROM mairie INNER JOIN clubs_data ON mairie.codeInsee = clubs_data.code_commune where region=? limit 500    ;";
	        	
		          
		          PreparedStatement ps = connection.prepareStatement(sql);
		          ps.setString(1, a);
		         
		          
		          result =ps.executeQuery();
	        	  
	        	  
	        
	         
	   
	          while (result.next()) {
	        	  
	        	  double lat=result.getDouble("Latitude");
	        	  double lon=result.getDouble("Longitude");
	        	  String nomCom = result.getString("Commune");
	        	  String nomf = result.getString("nom_federation");
	        	  Club club = new Club();
	        	  club.setLatitude(lat);
	        	  club.setLongitude(lon);
	        	  club.setNomCommune(nomCom);
	        	  club.setNomFederation(nomf);
	        	  clubs.add(club);
	        	  System.out.println(club.getLatitude()+ "long" +club.getlongitude()+ club.getNomCommune());
	        	  
	        	  

	          }
	          
	         
	          

	          // Parcourir les résultats et les afficher
	         
		  } catch (ClassNotFoundException e) {
	          System.out.println("Erreur : driver JDBC introuvable");
	      } catch (SQLException e) {
	          System.out.println("Erreur : impossible de se connecter à la base de données" );
	          e.printStackTrace();

	   }
		  
	    finally {
	       try {
	           if (result != null) {
	               result.close();
	           }
	           if (statement != null) {
	               statement.close();
	           }
	           if (connection != null) {
	               connection.close();
	           }
	       } catch (SQLException e) {
	           System.out.println("Erreur : impossible de fermer la connexion à la base de données");
	       }
	       
	    }
		  return clubs;
		  
	  }
	   
	
	
	
	public  List<Club> recupererListeReg() {
		  List<Club> clubx = new ArrayList<Club>();
		  Statement statement = null;
	      Connection connection = null;
	      ResultSet result = null;
		  
		  //Chargement du driver
		  try {
			  Class.forName("com.mysql.cj.jdbc.Driver");
		      String url = "jdbc:mysql://localhost/gasyd";
	          String user = "root";
	          String password = "root";
	          connection = DriverManager.getConnection(url, user, password);
	          
	          statement = connection.createStatement();
	          String sql = "select DISTINCT region from clubs_data";
	          result = statement.executeQuery(sql);
	         
	          while (result.next()) {
	        	  
	        	  
	        	  
	        	  String nomf = result.getString("region");
	        	  Club clubi = new Club();
	        	  
	        	  
	        	  clubi.setRegion(nomf);
	        	  clubx.add(clubi);
	        	  System.out.println(clubi.getRegion());
	        	  
	        	  
	        	 

	          }
	        
	          
	             
	        	  
	        	  
	          
	          
	         
	         
	   
	         
	          

	          // Parcourir les résultats et les afficher
	         
		  } catch (ClassNotFoundException e) {
	          System.out.println("Erreur : driver JDBC introuvable");
	      } catch (SQLException e) {
	          System.out.println("Erreur : impossible de se connecter à la base de données" );
	          e.printStackTrace();

	   }
		  
	    finally {
	       try {
	           if (result != null) {
	               result.close();
	           }
	           if (statement != null) {
	               statement.close();
	           }
	           if (connection != null) {
	               connection.close();
	           }
	       } catch (SQLException e) {
	           System.out.println("Erreur : impossible de fermer la connexion à la base de données");
	       }
	       
	    }
		  return clubx;
	
	
	
	

}
}
