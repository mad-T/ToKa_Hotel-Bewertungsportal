package models;

public class EnthaeltZusatzHotel {

	private String fk_Hotel;
	private String fk_Zusatz;
	
	public EnthaeltZusatzHotel(String fk_Hotel, String fk_Zusatz) {
		super();
		this.fk_Hotel = fk_Hotel;
		this.fk_Zusatz = fk_Zusatz;
	}

	public String getHotelID() {
		return fk_Hotel;
	}

	public void setHotelID(String fk_Hotel) {
		this.fk_Hotel = fk_Hotel;
	}

	public String getZusatzID() {
		return fk_Zusatz;
	}

	public void setZusatzID(String fk_Zusatz) {
		this.fk_Zusatz = fk_Zusatz;
	}
}
