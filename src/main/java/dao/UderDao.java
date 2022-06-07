package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.Documents.beans.Utilisateur;

import db.DbConnection;

public class UderDao {
	static DbConnection dbConnection = new DbConnection();
	
	public static int addUser(Utilisateur utilisateur) throws SQLException {
		var connexion = dbConnection.getConnexion();
		try {
		if(connexion != null) {
		String query = "INSERT INTO utilisateur(nom,prenom,email,telephone,mot_de_passe,classe,statut)VALUES(?,?,?,?,?,?,?);";
			PreparedStatement preparedStatement = connexion.prepareStatement(query);
			preparedStatement.setString(1,utilisateur.getNom());
			preparedStatement.setString(2,utilisateur.getPrenom());
			preparedStatement.setString(3,utilisateur.getEmail());
			preparedStatement.setString(4,utilisateur.getTelephone());
			preparedStatement.setString(5,utilisateur.getMotDePasse());
			preparedStatement.setString(6,"1");
			preparedStatement.setString(7,"client");
			
			preparedStatement.executeUpdate();
			System.out.println("innnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnsert");
			
		} 
		}catch (Exception e) {
			System.out.print(e.getMessage());
		} finally {
			connexion.close();
		}

		return 0;

	}

			
	}
