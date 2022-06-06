package com.Document.bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class Classe {
	private String id;
	private String nom;
	private String Date_creation;
	private String idClasse ;
	 public String getIdClasse(String classeName) {
	    	
	    	try {
	    		Class.forName("com.mysql.jdbc.Driver");
	    	}catch(ClassNotFoundException e) {}
	    	
	    	Connection connection  = null;
	    	Statement statement = null;
	    	ResultSet resultat = null;
	    	Utilisateur utilisateur = new Utilisateur();
	    	
	         try {
	        	 System.out.println("j'ai effectuer la requette new2");
	        	 connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaee","root","");
	        	 System.out.println("CONNECTE2"); 
	        	 statement = connection.createStatement();
	        	 System.out.println("state2");
	        	  PreparedStatement pstmt = connection.prepareStatement("SELECT id FROM classe WHERE nom=? ;");
	              
	              pstmt.setString(1, classeName);
	           
	           
	             resultat = pstmt.executeQuery();
	             System.out.println("requete2");
	            
	          
	             
	             while (resultat.next()) {
	            	
	            	 idClasse=resultat.getString("id"); 
	             }
	         } catch (SQLException e) {
	         } finally {
	             
	             try {
	                 if (resultat != null)
	                     resultat.close();
	                 if (statement != null)
	                     statement.close();
	                 if (connection != null)
	                     connection.close();
	                
	             } catch (SQLException ignore) {
	             }
	         }
	         System.out.println("le id est ------------------------------->"+idClasse);
	         System.out.println("la classe  est ----------------------------->"+classeName);
	         return idClasse;
	    	
	    }
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getDate_creation() {
		return Date_creation;
	}
	public void setDate_creation(String date_creation) {
		Date_creation = date_creation;
	}

	
}