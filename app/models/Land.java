package models;

public class Land {
	
	public Land(String id, String beschreibung) {
		super();
		this.id = id;
		this.beschreibung = beschreibung;
	}
	
	private String id;
	private String beschreibung;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBeschreibung() {
		return beschreibung;
	}
	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}
	
}
