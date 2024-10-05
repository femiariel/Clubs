package fr.esigelec.model;

public class User {
     String nom;
     String prenom;
     String commune;
     String federation;
     String role;
     
     
     public String getRole() {
    	 return role;
     }
     
     public void  setRole(String role) {
    	 this.role=role;
     }
     public String getNom() {
    	 return nom;
     }
     
     public String getPrenom() {
    	 return prenom;
     }
     
     public String getCommune() {
    	 return commune;
     }
     
     public String getFederation() {
    	 return federation;
     }
     
     public void setNom(String nom) {
    	 this.nom=nom;
     }
     
     public void setPrenom(String prenom) {
    	 this.prenom=prenom;
     }
     
     public void setCommune(String commune) {
    	 this.commune=commune;
     }
     
     public void setFederation(String federation) {
    	 this.federation=federation;
     }
}
