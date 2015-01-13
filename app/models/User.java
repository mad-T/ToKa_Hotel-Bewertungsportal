package models;

public class User {
	
	private String email;
	private String vorname;
	private String nachname;
	private String geburtstag;
	private String geschlecht;
	private String familienstand;
	private String passwort;
	private String fk_Adresse;
	
	public User(String email, String vorname, String nachname, String geburtstag,
			String geschlecht, String familienstand, String passwort, String fk_Adresse) {
		super();
		this.email = email;
		this.vorname = vorname;
		this.nachname = nachname;
		this.geburtstag = geburtstag;
		this.geschlecht = geschlecht;
		this.familienstand = familienstand;
		this.passwort = passwort;
		this.fk_Adresse = fk_Adresse;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public String getNachname() {
		return nachname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	public String getGeburtstag() {
		return geburtstag;
	}

	public void setGeburtstag(String geburtstag) {
		this.geburtstag = geburtstag;
	}

	public String getGeschlecht() {
		return geschlecht;
	}

	public void setGeschlecht(String geschlecht) {
		this.geschlecht = geschlecht;
	}

	public String getFamilienstand() {
		return familienstand;
	}

	public void setFamilienstand(String familienstand) {
		this.familienstand = familienstand;
	}

	public String getPasswort() {
		return passwort;
	}

	public void setPasswort(String passwort) {
		this.passwort = passwort;
	}

	public String getFk_Adresse() {
		return fk_Adresse;
	}

	public void setFk_Adresse(String fk_Adresse) {
		this.fk_Adresse = fk_Adresse;
	}	
}
