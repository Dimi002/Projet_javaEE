package com.Document.bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Epreuve {
	
	private String nom;
	private String date;
	private String lien;
	private List<Epreuve> listEpreuve = new ArrayList<Epreuve>();
	 public List<Epreuve> getEpreuve(String classe, String matiere) {
	    	
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
	        	  PreparedStatement pstmt = connection.prepareStatement("SELECT nom,date_depot,url_epreuve FROM epreuve WHERE classe=? AND matiere=? ; ");
	              
	              pstmt.setString(1, classe);
	              pstmt.setString(2, matiere);
	           
	             resultat = pstmt.executeQuery();
	             System.out.println("requete2");
	            
	          
	             
	             while (resultat.next()) {
	            	 Epreuve epreuve = new Epreuve();
	            	 epreuve.setNom(resultat.getString("nom"));
	            	 epreuve.setDate(resultat.getString("date_depot"));
	            	 epreuve.setLien(resultat.getString("url_epreuve"));
	            	 System.out.println("regarde"+epreuve.getNom());
	                 this.listEpreuve.add(epreuve);
	                 System.out.println("regardeBien2"+listEpreuve);
	                 System.out.println("ok2");
	                 
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
	       
	         return listEpreuve;
	    	
	    }
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getLien() {
		return lien;
	}
	public void setLien(String lien) {
		this.lien = lien;
	}

	
}