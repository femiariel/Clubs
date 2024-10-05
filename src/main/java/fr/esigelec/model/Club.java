package fr.esigelec.model;
public class Club {
    private double latitude;
    private double longitude;
    private String nomCommune;
    private String nomFederation;
    private String region;
    private String rayon;
    
	public String getNomFederation() {
		return nomFederation;
	}
	
	public String getRayon() {
		return rayon;
	}
	public String getRegion() {
		return region;
	}
	
	public void setNomFederation(String nomFederation) {
		this.nomFederation=nomFederation;
	}
	
	
	
	public double getLatitude() {
	      return latitude;
	   }
	
	public double getlongitude() {
		return longitude;
	}
	
	public String getNomCommune() {
		return nomCommune;
	}

	public void setLatitude(double latitude) {
	      this.latitude = latitude;
	}
	
	public void setRayon(String rayon) {
		this.rayon= rayon;
	}
	   
	public void setLongitude(double longitude) {
	      this.longitude = longitude;
	}
	
	public void setNomCommune(String nomCommune) {
	      this.nomCommune = nomCommune;
	}
	 
	
	public void setRegion(String Region) {
		this.region=Region;
	}
}