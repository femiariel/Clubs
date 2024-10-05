package fr.esigelec.jee;

import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;
import javax.servlet.http.HttpSession;
import org.springframework.security.crypto.bcrypt.BCrypt;
import fr.esigelec.model.*;
;public class ConnexionDAO {
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
	}

	//String url = "jdbc:mysql://localhost/projet8"; // URL of the MySQL database
	String url = "jdbc:mysql://localhost/gasyd"; // URL of the MySQL database
	String username = "root"; // Username of the database user
	String password = "root";
	Connection connection=null;//Database connection.

	public void dbConnect() {
		try {
			connection = DriverManager.getConnection(url, username, password); // Establish a connection to the database
			if(connection != null) {
				System.out.println("Connected to database.");
			}
		} catch (SQLException e) {
			System.err.println("Une erreur est subvenue lors de la connection: " + e.getMessage());
		}
	}

	/**
	 * Close the database connection.
	*/

	public void dbClose() {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				System.out.println("Failed to close connection: " + e.getMessage());
			}
		}
	}

	public int get_code_info(String fed, String com, String reg) {
		int code =0;
		int maxCodeInfos=0;
		dbConnect();
		String query="SELECT code_infos FROM utilisateur WHERE commune = ? AND federation = ? AND region = ?";
		PreparedStatement statement;
		//Recupere la valeur maximale du code d'information present dans la base de donn�es
		try {
			statement = connection.prepareStatement(query);
			statement.setString(1, fed);
			statement.setString(2, com);
			statement.setString(3, reg);
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
					code=rs.getInt("code_infos");
			}
		} catch (SQLException e) {
			System.out.println("Erreur : impossible de se connecter à la base de donn�es");
			e.printStackTrace();
		}
		
		
		if(code ==0){
			query="SELECT MAX(code_infos) FROM utilisateur WHERE commune = ? AND federation = ? AND region = ?";
			//Recupere la valeur maximale du code d'information present dans la base de donn�es
			try {
				statement = connection.prepareStatement(query);
				statement.setString(1, fed);
				statement.setString(2, com);
				statement.setString(3, reg);
				ResultSet rs = statement.executeQuery();
				if (rs.next()) {
						maxCodeInfos = rs.getInt(1);
					    if (rs.wasNull()) {
					        maxCodeInfos = 0;
					    }
				}
			} catch (SQLException e) {
				System.out.println("Erreur : impossible de se connecter à la base de donn�es");
				e.printStackTrace();
			}
			// v�rification que les valeurs de commune, f�d�ration et r�gion ne correspondent pas � celles d'un utilisateur existant
		    query = "SELECT COUNT(*) FROM utilisateur WHERE commune = ? AND federation = ? AND region = ?";
		    try {
				statement = connection.prepareStatement(query);
				statement.setString(1, fed);
				statement.setString(2, com);
				statement.setString(3, reg);
				ResultSet rs = statement.executeQuery();
				if (rs.next() && rs.getInt(1) == 0) {
					code = maxCodeInfos + 1;
				}
			} catch (SQLException e) {
				System.out.println("Erreur : impossible de se connecter à la base de donn�es");
				e.printStackTrace();
			}
		}
		
		
		return code;
	}

	public String get_role(String mail) {
		 dbConnect();
			String role = null; // initialise la variable role à null
			String query = "SELECT C_role FROM utilisateur WHERE email = ?";
			PreparedStatement statement;
			try {
				statement = connection.prepareStatement(query);
				statement.setString(1, mail);
				ResultSet rs = statement.executeQuery();
				if (rs.next()) {
					role = rs.getString("C_role"); // récupère la valeur de la colonne C_role
				}
			} catch (SQLException e) {
				System.out.println("Erreur : impossible de se connecter à la base de donn�es");
				e.printStackTrace();
			}
		return role;
	}

	public boolean check_connexion(String mail, String motdp, HttpSession session) {
		dbConnect();
	    String query = "SELECT mdpCrypte, salt FROM utilisateur WHERE email = ?";
	    PreparedStatement statement;
	    boolean userExists = false;
	    try {
	        statement = connection.prepareStatement(query);
	        statement.setString(1, mail);
	        ResultSet rs = statement.executeQuery();
	        while(rs.next()) {
	            String hashedPassword = rs.getString("mdpCrypte");
	            String saltString = rs.getString("salt");
	            // V�rification du mot de passe hach� avec le sel correspondant
	            if (BCrypt.checkpw(motdp, hashedPassword)) {
					userExists = true;
					// Stockage des donn�es utilisateur dans la session
					session.setAttribute("nom", rs.getString("name"));
	                session.setAttribute("prenom", rs.getString("surname"));
	                session.setAttribute("mail", rs.getString("email"));
	                session.setAttribute("status", rs.getInt("status_demande"));
	                session.setAttribute("Role", rs.getString("C_role"));
	                session.setAttribute("federation", rs.getString("federation"));
	                session.setAttribute("commune", rs.getString("commune"));
	                session.setAttribute("region", rs.getString("region"));
	                session.setAttribute("codeInfos", rs.getInt("code_infos"));
				}
			}
		} catch (SQLException e) {
			System.out.println("Erreur : impossible de se connecter à la base de donn�es");
			e.printStackTrace();
		}
		return userExists;
	}

	public boolean check_inscription(String nom, String prenom, String mail, String motdp, int status_demande, String role_demande, String fed, String com, String reg, int code_inf) {
		dbConnect();
		final int SALT_LENGTH = 16;
		// Génération d'un salt aléatoire pour le cryptage du mot de passe
		byte[] salt = new byte[SALT_LENGTH];
		new SecureRandom().nextBytes(salt);
		String saltString = Base64.getEncoder().encodeToString(salt);
		// Cryptage du mot de passe avec Bcrypt et le salt généré
		String mdpCrypte = BCrypt.hashpw(motdp, BCrypt.gensalt(12));
		int l_code=get_code_info(fed,com,reg);
		String query="INSERT INTO utilisateur (name, surname, email, mdpCrypte, salt, status_demande, C_role, federation, commune, region, code_infos) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement p_statement;
		boolean userCreer = false;
		try {
			p_statement = connection.prepareStatement(query);
			p_statement.setString(1, nom);
			p_statement.setString(2, prenom);
			p_statement.setString(3, mail);
			p_statement.setString(4, mdpCrypte);
			p_statement.setString(5, saltString);
			p_statement.setInt(6, status_demande);
			p_statement.setString(7, role_demande);
			p_statement.setString(8, fed);
			p_statement.setString(9, com);
			p_statement.setString(10, reg);
			p_statement.setInt(11, l_code);

			int rowsAffected = p_statement.executeUpdate();
			if (rowsAffected > 0) {
				userCreer = true;
			}
		} catch (SQLException e) {
			System.out.println("Erreur : inscription impossible");
			e.printStackTrace();
		}
		return userCreer;
	}

	public User Sess(String mail, String motdp) {
		dbConnect();
		User us= new User();
		String query = "SELECT * FROM utilisateur WHERE email = ?";
		PreparedStatement statement;
		
		try {
			statement = connection.prepareStatement(query);
			statement.setString(1, mail);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				String hashedPassword = rs.getString("mdpCrypte");
				String saltString = rs.getString("salt");
				// Vérification du mot de passe haché avec le sel correspondant
				if (BCrypt.checkpw(motdp, hashedPassword)) {
					String na=rs.getString("name");
					String su=rs.getString("surname");
					String fe=rs.getString("federation");
					String co=rs.getString("commune");
					String ro=rs.getString("C_role");
					us.setNom(na);
					us.setPrenom(su);
					us.setCommune(co);
					us.setFederation(fe);
					us.setRole(ro);
					System.out.println(us.getNom());
					
				}
			}
		}
			catch (SQLException e) {
				System.out.println("Erreur : impossible de se connecter à la base de donn�es");
				e.printStackTrace();
			}
			return us;
		
	}
	
	
}


