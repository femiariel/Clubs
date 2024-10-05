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
public class RechercheRayon {
	
	public  Club recupererClubRay(String x) {
		  Club club = new Club();
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
	          
	          
	         
	        
	       	  String sql = "select commune,latitude,longitude from mairie inner join clubs_data on clubs_data.code_commune=mairie.codeInsee where commune=?";
		         
	         
	          
	          
	          PreparedStatement ps = connection.prepareStatement(sql);
	          ps.setString(1, x);
	          
	          result =ps.executeQuery();
                 
	          System.out.println(x);
	   
	          while (result.next()) {
	        	  
	        	  double lat=result.getDouble("Latitude");
	        	  double lon=result.getDouble("Longitude");
	        	  
	        	 
	        	  club.setLatitude(lat);
	        	  club.setLongitude(lon);
	        	  
	
	        	  System.out.println(club.getLatitude()+ "long" +club.getlongitude());
	        	  
	        	  

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
		  return club;
		  
	}
	
	public  List<Club> recupererClubsRayon(String a, String b, String c) {
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
	          
	          
	          System.out.println(a);
	          System.out.println(b);
	          
	              
	        	  String sql = "select commune, latitude,longitude,CodePostal,nom_federation from mairie inner join clubs_data on mairie.codeInsee=clubs_data.code_commune where region=? and nom_federation=?  ";
	        	 
		          PreparedStatement ps = connection.prepareStatement(sql);
		          ps.setString(1, a);
		          ps.setString(2, c);
		         
		          
		          result =ps.executeQuery();
	        	  
	        	  
	          
	          
	         
	         
	   
	          while (result.next()) {
	        	  
	        	  double lat=result.getDouble("Latitude");
	        	  double lon=result.getDouble("Longitude");
	        	  String nomCom = result.getString("commune");
	        	  String nomf = result.getString("nom_federation");
	        	  Club club = new Club();
	        	  club.setLatitude(lat);
	        	  club.setLongitude(lon);
	        	  club.setNomCommune(nomCom);
	        	  club.setNomFederation(nomf);
	        	  club.setRayon(b);
	        	  clubs.add(club);
	        	  System.out.println(club.getLatitude()+ "long" +club.getlongitude()+ club.getNomCommune()+ club.getNomFederation());
	        	  
	        	  

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
	
	
	public  List<Club> recupererListeFed() {
		  List<Club> clubv = new ArrayList<Club>();
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
	          String sql = "select DISTINCT nom_federation from clubs_data";
	          result = statement.executeQuery(sql);
	         
	          while (result.next()) {
	        	  
	        	  
	        	  
	        	  String nomf = result.getString("nom_federation");
	        	  Club clubi = new Club();
	        	  
	        	  
	        	  clubi.setNomFederation(nomf);
	        	  clubv.add(clubi);
	        	  System.out.println(clubi.getNomFederation());
	        	  
	        	  
	        	 

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
		  return clubv;
	
	
	
	

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
