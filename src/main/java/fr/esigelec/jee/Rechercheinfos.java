package fr.esigelec.jee;

import fr.esigelec.model.*;
import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.Statement;
	import java.sql.*;
	import java.util.*;
	import java.util.List;

public class Rechercheinfos {
	
	   public Infosclub recupererCode_communelicen(String x, String y) {
		   Infosclub infosclub = new Infosclub();
		  Statement statement = null;
	      Connection connection = null;
	      ResultSet resultat = null;
		  
		  //Chargement du driver
		  try {
			  Class.forName("com.mysql.cj.jdbc.Driver");
		      String url = "jdbc:mysql://localhost/gasyd";
	          String user = "root";
	          String password = "root";
	          connection = DriverManager.getConnection(url, user, password);
	          
	          statement = connection.createStatement();
	          String sql = "select libelle,l_2019,l_h_2019,l_f_2019 from lic_data where libelle=? and nom_fed=?" ;
	          System.out.println( x);
	          System.out.println(y);
	      
	          PreparedStatement ps= connection.prepareStatement(sql);
	          ps.setString (1, x);
	          ps.setString(2, y);
	          resultat = ps.executeQuery();
	          while (resultat.next()) {
	        	  
	        	  int l_year = resultat.getInt("l_2019");
	        	  int lh= resultat.getInt("l_h_2019");
	        	  int lf= resultat.getInt("l_f_2019");
	        	  
	        	  infosclub.setl_2019(l_year);
	        	  infosclub.setlh2019(lh);
	        	  infosclub.setlf2019(lf);
	        	  
	        	  System.out.println("nbre de l icences" + infosclub.getl_2019()+"f"+ infosclub.getlf2019());
	        	  
	        	 
	        	
	      
	        	 
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
	           if (resultat != null) {
	               resultat.close();
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
		  return infosclub;
		  
	  }
	   
	}


