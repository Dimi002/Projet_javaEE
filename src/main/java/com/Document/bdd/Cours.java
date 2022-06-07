package com.Document.bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import com.Documents.beans.Utilisateur;
 

public class Cours {

	private List<MatiereEtid> listMatiereEtId = new ArrayList<MatiereEtid>();
	private List<Epreuve> listEpreuve = new ArrayList<Epreuve>();
	
    public List<MatiereEtid> GetListCours() {
    	
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
            PreparedStatement pstmt = connection.prepareStatement("SELECT nom,id FROM matiere ");
           
             resultat = pstmt.executeQuery();
             System.out.println("requete");
            
          
             
             while (resultat.next()) {
            	 MatiereEtid matiereEtId = new MatiereEtid();
            	 matiereEtId.setMatieres(resultat.getString("nom"));
            	 matiereEtId.setId(resultat.getString("id"));
            	 System.out.println("regarde"+matiereEtId.getMatieres());
                 this.listMatiereEtId.add(matiereEtId);
                 System.out.println("regardeBien"+listMatiereEtId);
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
         System.out.println("regardeBienBien"+listMatiereEtId);
         return listMatiereEtId;
    	
    	}
    
   
    
    }
    



