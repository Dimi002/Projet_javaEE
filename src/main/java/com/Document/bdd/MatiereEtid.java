package com.Document.bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.Documents.beans.Utilisateur;

public class MatiereEtid{
	  
	private String matieres;
	private String id;
	
	public String getMatieres() {
		return matieres;
	}
	public void setMatieres(String matieres) {
		this.matieres = matieres;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public boolean ajoutMatiere(String nom) {
    	
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
        	 System.out.println("CONNECTE2 INsert"); 
        	 statement = connection.createStatement();
        	 System.out.println("state2");
        	 Date dt = new  Date();
        	 SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); 
        	 String date = s.format(dt);
        	  PreparedStatement pstmt = connection.prepareStatement("INSERT INTO matiere(nom) VALUES (?) ;");             
              pstmt.setString(1, nom);
              pstmt.executeUpdate();
             System.out.println("insertion reussi");
      
         } catch (SQLException e) {
        	 System.out.println("regarde ici -------");
        	 e.printStackTrace();
        	 
               } finally {
             
             try {
                 if (resultat != null)
                     resultat.close();
                 if (statement != null)
                     statement.close();
                 if (connection != null)
                     connection.close();
                return false;
             } catch (SQLException ignore) {
            	 ignore.printStackTrace();
             }
             
         }
       
         return true;
    	
    }
	}