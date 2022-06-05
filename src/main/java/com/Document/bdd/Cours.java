package com.Document.bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class Cours {
	
    public List<String> GetListCours() {
    	
    	try {
    		Class.forName("com.mysql.jdbc.Driver");
    	}catch(ClassNotFoundException e) {}
    	
    	Connection connection  = null;
    	Statement statement = null;
    	ResultSet resultat = null;
    	Utilisateur utilisateur = new Utilisateur();
    	List<String> matieres = new ArrayList<String>();
         try {
        	 System.out.println("j'ai effectuer la requette new");
        	 connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaee","root","");
        	 System.out.println("CONNECTE"); 
        	 statement = connection.createStatement();
        	 System.out.println("state");
            PreparedStatement pstmt = connection.prepareStatement("SELECT nom FROM matiere ");
           
             resultat = pstmt.executeQuery();
             System.out.println("requete");
            
          
             
             while (resultat.next()) {
            	 System.out.println("h‡‡‡");
                 matieres.add(resultat.getString("nom"));
                 System.out.println("ok");
                 
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
         return matieres;
    	
    	}
    
    }



