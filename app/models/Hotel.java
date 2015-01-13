package models;

public class Hotel {

	private String id;
	private String titelbild;
	private String name;
	private String fk_adresse;
	private String langtext;
	private String kurzbeschreibung;
	private String verpflegung;
	private String kinder;
	
	public Hotel(String id, String titelbild, String name, String fk_adresse, String langtext,
			String kurzbeschreibung, String verpflegung, String kinder) {
		super();
		this.id = id;
		this.titelbild = titelbild;
		this.name = name;
		this.fk_adresse = fk_adresse;
		this.langtext = langtext;
		this.kurzbeschreibung = kurzbeschreibung;
		this.verpflegung = verpflegung;
		this.kinder = kinder;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitelbild() {
		return titelbild;
	}

	public void setTitelbild(String titelbild) {
		this.titelbild = titelbild;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getVerpflegung() {
		return verpflegung;
	}

	public void setVerpflegung(String verpflegung) {
		this.verpflegung = verpflegung;
	}

	public String getKinder() {
		return kinder;
	}

	public void setKinder(String kinder) {
		this.kinder = kinder;
	}
	
}