package models;

public class Bild {
	
	private String id;
	private String beschreibung;
	private String pfad;
	private String fk_Hotel;
	private String fk_Bewertung;
	
	public Bild(String id, String beschreibung, String pfad, String fk_Hotel,
			String fk_Bewertung) {
		super();
		this.id = id;
		this.beschreibung = beschreibung;
		this.pfad = pfad;
		this.fk_Hotel = fk_Hotel;
		this.fk_Bewertung = fk_Bewertung;
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

	public String getPfad() {
		return pfad;
	}

	public void setPfad(String pfad) {
		this.pfad = pfad;
	}

	public String getFk_Hotel() {
		return fk_Hotel;
	}

	public void setFk_Hotel(String fk_Hotel) {
		this.fk_Hotel = fk_Hotel;
	}

	public String getFk_Bewertung() {
		return fk_Bewertung;
	}

	public void setFk_Bewertung(String fk_Bewertung) {
		this.fk_Bewertung = fk_Bewertung;
	}
}
