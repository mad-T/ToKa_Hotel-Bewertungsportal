package models;

public class Bewertung {

	private String id;
	private String beschreibung;
	private String art;
	private String kinder;
	private String verpflegung;
	private String von;
	private String bis;
	private String rating;
	private String erfassungsDatum;
	private String fk_Hotel;
	
	public Bewertung(String id, String beschreibung, String art,
			String kinder, String verpflegung, String von, String bis,
			String rating, String erfassungsDatum, String fk_Hotel) {
		super();
		this.id = id;
		this.beschreibung = beschreibung;
		this.art = art;
		this.kinder = kinder;
		this.verpflegung = verpflegung;
		this.von = von;
		this.bis = bis;
		this.rating = rating;
		this.erfassungsDatum = erfassungsDatum;
		this.fk_Hotel = fk_Hotel;
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

	public String getArt() {
		return art;
	}

	public void setArt(String art) {
		this.art = art;
	}

	public String getKinder() {
		return kinder;
	}

	public void setKinder(String kinder) {
		this.kinder = kinder;
	}

	public String getVerpflegung() {
		return verpflegung;
	}

	public void setVerpflegung(String verpflegung) {
		this.verpflegung = verpflegung;
	}

	public String getVon() {
		return von;
	}

	public void setVon(String von) {
		this.von = von;
	}

	public String getBis() {
		return bis;
	}

	public void setBis(String bis) {
		this.bis = bis;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getErfassungsDatum() {
		return erfassungsDatum;
	}

	public void setErfassungsDatum(String erfassungsDatum) {
		this.erfassungsDatum = erfassungsDatum;
	}

	public String getFk_Hotel() {
		return fk_Hotel;
	}

	public void setFk_Hotel(String fk_Hotel) {
		this.fk_Hotel = fk_Hotel;
	}	
}
