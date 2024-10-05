package fr.esigelec.model;

public class ActeurInfos {
	private int id;
	private String titre;
	private String informations;
	private String code_mairie;
	private String code_federation;
	
	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getInformations() {
		return informations;
	}
	public void setInformations(String informations) {
		this.informations = informations;
	}
	public String getCode_mairie() {
		return code_mairie;
	}
	public void setCode_mairie(String code_mairie) {
		this.code_mairie = code_mairie;
	}
	public String getCode_federation() {
		return code_federation;
	}
	public void setCode_federation(String code_federation) {
		this.code_federation = code_federation;
	}
}
