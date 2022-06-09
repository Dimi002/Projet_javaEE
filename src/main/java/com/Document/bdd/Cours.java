package com.Document.bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
 

public class Cours {
	private String nom;
	private String date;
	private String lien;

	private List<MatiereEtid> listMatiereEtId = new ArrayList<MatiereEtid>();
	private List<Cours> listcours = new ArrayList<Cours>();
	
	 public List<Cours> getCours(String classe, String matiere) {
	    	
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
	        	  PreparedStatement pstmt = connection.prepareStatement("SELECT nom,date_depot,url_cour FROM cours WHERE classe=? AND matiere=? ; ");
	              
	              pstmt.setString(1, classe);
	              pstmt.setString(2, matiere);
	           
	             resultat = pstmt.executeQuery();
	             System.out.println("requete2çççççççççççççç");
	            
	          
	             
	             while (resultat.next()) {
	            	 Cours cour = new Cours();
	            	 cour.setNom(resultat.getString("nom"));
	            	 cour.setDate(resultat.getString("date_depot"));
	            	 cour.setLien(resultat.getString("url_cour"));
	                 this.listcours.add(cour);
	     	     
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
	       
	         return listcours;
	    	
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
        
         return listMatiereEtId;
    	
    	}
    
    public boolean ajoutCour(String nom, String idclasse, String idmatiere) {
    	
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
        	 //Date dt = new  Date();
        	// SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); 
        	// String date = s.format(dt);
        	  PreparedStatement pstmt = connection.prepareStatement("INSERT INTO cours(nom,matiere,classe,url_cour) VALUES (?,?,?,?) ;");
        	  System.out.println("tttttttttttttttttttt");
              pstmt.setString(1, nom);
              pstmt.setString(2, idmatiere);
              pstmt.setString(3, idclasse); 
              //pstmt.setString(4, date);
              pstmt.setString(4, "documents/"+nom); 
              
              System.out.println("insertion  pret "+nom+""+Integer.parseInt(idclasse)+""+Integer.parseInt(idmatiere)+""+date); 
              pstmt.executeUpdate();
             System.out.println("insertion reussi cours");
      
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
    



