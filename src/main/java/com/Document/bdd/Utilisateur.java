package com.Document.bdd;

public class Utilisateur {
	private String nom;
	private String prenom;
	private String email;
	private String mot_passe;
	private String classe;
	private int Telephone;
	private String status;
	private String date_Creation;
	
	public void setNom(String nom) {
		this.nom= nom;
	}
	
    public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
    
    public String getNom() {
	 	return this.nom;
	}
	
    public String getPrenom() {
		return this.prenom;
	}
		
}
