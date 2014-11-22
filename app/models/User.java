package models;

public class User {
	
	private String email;
	private String vorname;
	private String nachname;
	private String alter;
	private String geschlecht;
	private String familienstand;
	private String strasse;
	private String passwort;
	private String passwortWdh;
	private String fk_Adresse;
	
	public User(String email, String vorname, String nachname, String alter,
			String geschlecht, String familienstand, String strasse,
			String passwort, String passwortWdh, String fk_Adresse) {
		super();
		this.email = email;
		this.vorname = vorname;
		this.nachname = nachname;
		this.alter = alter;
		this.geschlecht = geschlecht;
		this.familienstand = familienstand;
		this.strasse = strasse;
		this.passwort = passwort;
		this.passwortWdh = passwortWdh;
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

	public String getAlter() {
		return alter;
	}

	public void setAlter(String alter) {
		this.alter = alter;
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

	public String getStrasse() {
		return strasse;
	}

	public void setStrasse(String strasse) {
		this.strasse = strasse;
	}

	public String getPasswort() {
		return passwort;
	}

	public void setPasswort(String passwort) {
		this.passwort = passwort;
	}

	public String getPasswortWdh() {
		return passwortWdh;
	}

	public void setPasswortWdh(String passwortWdh) {
		this.passwortWdh = passwortWdh;
	}

	public String getFk_Adresse() {
		return fk_Adresse;
	}

	public void setFk_Adresse(String fk_Adresse) {
		this.fk_Adresse = fk_Adresse;
	}	
}
