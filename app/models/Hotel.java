package models;

public class Hotel {

	private String id;
	private String fk_adresse;
	private String langtext;
	private String kurzbeschreibung;
	private String fk_stars;
	private String  verpflegung;
	private String art;
	private String kinder;
	
	public Hotel(String id, String fk_adresse, String langtext,
			String kurzbeschreibung, String fk_stars, String verpflegung,
			String art, String kinder) {
		super();
		this.id = id;
		this.fk_adresse = fk_adresse;
		this.langtext = langtext;
		this.kurzbeschreibung = kurzbeschreibung;
		this.fk_stars = fk_stars;
		this.verpflegung = verpflegung;
		this.art = art;
		this.kinder = kinder;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFk_adresse() {
		return fk_adresse;
	}

	public void setFk_adresse(String fk_adresse) {
		this.fk_adresse = fk_adresse;
	}

	public String getLangtext() {
		return langtext;
	}

	public void setLangtext(String langtext) {
		this.langtext = langtext;
	}

	public String getKurzbeschreibung() {
		return kurzbeschreibung;
	}

	public void setKurzbeschreibung(String kurzbeschreibung) {
		this.kurzbeschreibung = kurzbeschreibung;
	}

	public String getFk_stars() {
		return fk_stars;
	}

	public void setFk_stars(String fk_stars) {
		this.fk_stars = fk_stars;
	}

	public String getVerpflegung() {
		return verpflegung;
	}

	public void setVerpflegung(String verpflegung) {
		this.verpflegung = verpflegung;
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
	
}