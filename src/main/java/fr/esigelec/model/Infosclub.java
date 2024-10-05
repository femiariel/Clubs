package fr.esigelec.model;


public class Infosclub {
    private int code_commune;
    private int l_2019;
    private int lh2019;
    private int lf2019;
    private String nom_fed;

    public Infosclub() {
	
			}
    
    
    public int getlh2019() {
    	return lh2019;
    }
    
    public int getlf2019() {
    	return lf2019;
    }
    
    public void setlh2019(int lh2019) {
    	this.lh2019=lh2019;
    }
    
    public void setlf2019(int lf2019) {
    	this.lf2019=lf2019;
    }
    public int getcode_commune()	{
	    return code_commune;
	
    }
    public int getl_2019() {
	    return l_2019;
	}
    public String getnom_fed() {
	    return nom_fed;
    }
    public void setnom_fed(String nom_fed ) {
	    this.nom_fed=nom_fed;
    }
    public void setcode_commmune(int code_commune) {
	    this.code_commune=code_commune;
    }
    public void setl_2019(int l_2019) {
	    this.l_2019=l_2019;
    }
}