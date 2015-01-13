package models;

public class Zusatz {

	private String id;
	private String beschreibung;
	
	public Zusatz(String id, String beschreibung) {
		super();
		this.id = id;
		this.beschreibung = beschreibung;
	}

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
