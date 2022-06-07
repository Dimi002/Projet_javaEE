package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DbConnection {
	Connection connexion = null;
	
	public Connection getConnexion() throws SQLException {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaee", "root", "");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return connexion;	
	}

	public void RemoveConnection() throws SQLException {
		connexion.close();
	}
}
