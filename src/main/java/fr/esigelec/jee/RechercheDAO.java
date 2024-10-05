package fr.esigelec.jee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.util.ArrayList;
//import java.util.HashMap;

public class RechercheDAO {
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
	}
	String url = "jdbc:mysql://localhost/projet8"; // URL of the MySQL database
	String username = "root"; // Username of the database user
	String password = "root"; // Password of the database user
	Connection con=null;//declaring a "Connection" variable initialized to null

	public void dbConnect() {
		try  {
			con = DriverManager.getConnection(url , username, password); // Establish a connection to the database
			if(con != null) {
				System.out.println("Connected to database.");
			}
		} catch (SQLException e) {
			System.err.println("Error connection: " + e.getMessage());
		}
	}

	public void dbClose() {

		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println("Failed to close connection: " + e.getMessage());
			}
		}
	}
}
