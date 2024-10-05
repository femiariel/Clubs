package fr.esigelec.jee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import fr.esigelec.model.ActeurInfos;

public class InfosActeurDAO {
	
	//String url = "jdbc:mysql://localhost/projet8"; // URL of the MySQL database
	String url = "jdbc:mysql://localhost:3306/gasyd"; // URL of the MySQL database
	String username = "root"; // Username of the database user
	String password = "root";
	//String password = "root"; // Password of the database user
	
	public InfosActeurDAO(){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
	}
	
	public ArrayList<ActeurInfos> getInfos(String code_commune, String code_federation){
		ArrayList<ActeurInfos> list = new ArrayList<ActeurInfos>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet res = null;
		
		try {
			con = DriverManager.getConnection(url, username, password);
			ps = con.prepareStatement("SELECT id, titre, informations FROM infos WHERE commune=? and federation=?;");
			ps.setString(1,  code_commune);
			ps.setString(2,  code_federation);
			res = ps.executeQuery();
			while(res.next()) {
				int id = res.getInt("id");
				String titre = res.getString("titre");
				String infos = res.getString("informations");
				
				ActeurInfos newInfo = new ActeurInfos();
				newInfo.setId(id);
				newInfo.setTitre(titre);
				newInfo.setInformations(infos);
				
				list.add(newInfo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(res != null) res.close();
				if(ps != null) ps.close();
				if(con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}
	
	public void ajouter_infos(ActeurInfos infos) {
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = DriverManager.getConnection(url, username, password);
			ps = con.prepareStatement("INSERT INTO infos(titre, informations, commune, federation) VALUES (?, ?, ?, ?);");
			ps.setString(1, infos.getTitre());
			ps.setString(2, infos.getInformations());
			ps.setString(3, infos.getCode_mairie());
			ps.setString(4, infos.getCode_federation());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps != null) ps.close();
				if(con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	public void modifier_infos(ActeurInfos infos) {
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = DriverManager.getConnection(url, username, password);
			ps = con.prepareStatement("UPDATE infos SET titre=? , informations=? WHERE id=?;");
			ps.setString(1, infos.getTitre());
			ps.setString(2, infos.getInformations());
			ps.setInt(3, infos.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps != null) ps.close();
				if(con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void supprimer_infos(ActeurInfos infos) {
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = DriverManager.getConnection(url, username, password);
			ps = con.prepareStatement("DELETE FROM infos WHERE id=? AND titre=? AND informations=?;");
			ps.setInt(1, infos.getId());
			ps.setString(2, infos.getTitre());
			ps.setString(3, infos.getInformations());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps != null) ps.close();
				if(con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void supprimer_infos(int id) {
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = DriverManager.getConnection(url, username, password);
			ps = con.prepareStatement("DELETE FROM infos WHERE id=?");
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps != null) ps.close();
				if(con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
	}
