package models;

public class Adresse {
	
	private String id;
	private String ort;
	private String plz;
	private String strasse;
	private String fk_Land;
	
	public Adresse(String id, String ort, String plz, String strasse, String fk_Land) {
		super();
		this.id = id;
		this.ort = ort;
		this.plz = plz;
		this.strasse = strasse;
		this.fk_Land = fk_Land;
	}
	
	public String getStrasse() {
		return strasse;
	}

	public void setStrasse(String strasse) {
		this.strasse = strasse;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getOrt() {
		return ort;
	}
	public void setOrt(String ort) {
		this.ort = ort;
	}
	public String getFk_Land() {
		return fk_Land;
	}
	public void setFk_Land(String fk_Land) {
		this.fk_Land = fk_Land;
	}
	public String getPlz() {
		return plz;
	}
	public void setPlz(String plz) {
		this.plz = plz;
	}

}

