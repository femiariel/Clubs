package fr.esigelec.jee;
import java.sql.Connection;
import fr.esigelec.model.*;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProportionDAO {
    public Lic recproportion(String a) {
    	 Statement statement = null;
	      Connection connection = null;
	      ResultSet result = null;
	      Lic li = new Lic();
		  //Chargement du driver
		  try {
			  Class.forName("com.mysql.cj.jdbc.Driver");
		      String url = "jdbc:mysql://localhost/gasyd";
	          String user = "root";
	          String password = "root";
	          connection = DriverManager.getConnection(url, user, password);
	        
	          
	          
	         
	          
	        
	          String sql = "select (sum(l_2019)/pop_2018)*100 as proportion,libelle from lic_data  where libelle=?   ;";
	        	
		          
		      PreparedStatement ps = connection.prepareStatement(sql);
		      ps.setString(1, a);
		         
		          
		      result =ps.executeQuery();
	        	  
	        	  
	        
	         
	   
	          while (result.next()) {
	        	  
	             double prop=result.getDouble("proportion");
	             String com=result.getString("libelle");
	            
	             li.setProportion(prop);
	             li.setCommune(com);
	             System.out.println(li.getProportion());
	        	  

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
		  return li;
		  
	  }
	   
    


   
public  List<Lic> recupererListeLibelle() {
	  List<Lic> lics = new ArrayList<Lic>();
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
        String sql = "select distinct libelle from lic_data ;";
        result = statement.executeQuery(sql);
       
        while (result.next()) {
      	  
      	  
      	  String lib = result.getString("libelle");
      	  
      	  Lic lic = new Lic();
      	  
      	  
      	  lic.setCommune(lib);
      	  lics.add(lic);
      	 
      	  
      	  
      	 

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
	  return lics;




}



public  List<Lic> recupererPropCommune(String a) {
	  List<Lic> licos = new ArrayList<Lic>();
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
      String sql = "select (sum(l_2019)/pop_2018)*100 as proportion,libelle from lic_data where region=? group by libelle;";
      PreparedStatement ps = connection.prepareStatement(sql);
      ps.setString(1, a);
         
          
      result =ps.executeQuery();
    	  
     
      while (result.next()) {
    	  
    	  
    	  String lib = result.getString("libelle");
    	  double pr= result.getDouble("proportion");
    	  
    	  Lic lic = new Lic();
    	  
    	  lic.setProportion(pr);
    	  lic.setCommune(lib);
    	  licos.add(lic);
    	  System.out.println(lic.getCommune()+ lic.getProportion());
    	  
    	  
    	 

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
	  return licos;




}

public  List<Club> recupererListeRegProp() {
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
        String sql = "select DISTINCT region from lic_data";
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



