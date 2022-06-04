package com.Document.bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class Authentification {
	private String email;
	private String Mot_de_passe;
	
	public Authentification() {}
    public Authentification(String mail, String mdp) {
    	this.email=mail;
    	this.Mot_de_passe=mdp;
    }	
    public Utilisateur EffectuConnexion(String mail, String mdp) {
    	
    	try {
    		Class.forName("com.mysql.jdbc.Driver");
    	}catch(ClassNotFoundException e) {}
    	
    	Connection connection  = null;
    	Statement statement = null;
    	ResultSet resultat = null;
    	Utilisateur utilisateur = new Utilisateur();
    	
         try {
        	 System.out.println("j'ai effectuer la requette new");
        	 connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaee","root","");
        	 System.out.println("CONNECTE"); 
        	 statement = connection.createStatement();
        	 System.out.println("state");
            PreparedStatement pstmt = connection.prepareStatement("SELECT nom,prenom FROM utilisateur WHERE email=? AND mot_de_passe=? ;");
            pstmt.setString(1, mail);
            pstmt.setString(2, mdp);
             resultat = pstmt.executeQuery();
             System.out.println("requete");
             System.out.println("hello"+mail);
          
             
             while (resultat.next()) {
            	 System.out.println("h‡‡‡");
                 String nom = resultat.getString("nom");
                 System.out.println("hii"+nom);
                 String prenom = resultat.getString("prenom");
                 System.out.println("hii"+prenom);
                 
                 utilisateur.setNom(nom);
                 utilisateur.setPrenom(prenom);
                 
                 
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
         return utilisateur;
    	
    	}
    
    }



