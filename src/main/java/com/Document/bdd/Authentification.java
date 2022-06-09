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
	private boolean etat;
	
	public Authentification() {}
    public Authentification(String mail, String mdp) {
    	this.email=mail;
    	this.Mot_de_passe=mdp;
    	this.etat=false;
    }	
    public Utilisateur EffectuConnexion(String mail, String mdp) {
    	
    	try {
    		Class.forName("com.mysql.jdbc.Driver");
    	}catch(ClassNotFoundException e) {}
    	
    	Connection connection  = null;
    	Statement statement = null;
    	ResultSet resultat = null;
    	Utilisateur utilisateur = new Utilisateur();
    	int taille=0;
    	
         try {
        	
        	 connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaee","root","");       	
        	 statement = connection.createStatement();      	 
            PreparedStatement pstmt = connection.prepareStatement("SELECT nom,prenom FROM utilisateur WHERE email=? AND mot_de_passe=? ;");
            pstmt.setString(1, mail);
            pstmt.setString(2, mdp);
             resultat = pstmt.executeQuery();
            
               taille=resultat.getRow();
             
             while (resultat.next()) {
            	 
                 String nom = resultat.getString("nom");
                 String prenom = resultat.getString("prenom");
                 this.etat=true;
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
         if (etat) {
         return utilisateur;}
         else { return null;}
    	}
    
    }



