package models;

public class Adresse {
	
	public Adresse(String id, String ort, String fk_Land, String plz) {
		super();
		this.id = id;
		this.ort = ort;
		this.fk_Land = fk_Land;
		this.plz = plz;
	}
	
	private String id;
	private String ort;
	private String fk_Land;
	private String plz;
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

