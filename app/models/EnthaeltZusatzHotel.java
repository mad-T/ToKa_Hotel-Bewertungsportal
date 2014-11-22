package models;

public class EnthaeltZusatzHotel {

	private String hotelID;
	private String zusatzID;
	
	public EnthaeltZusatzHotel(String hotelID, String zusatzID) {
		super();
		this.hotelID = hotelID;
		this.zusatzID = zusatzID;
	}

	public String getHotelID() {
		return hotelID;
	}

	public void setHotelID(String hotelID) {
		this.hotelID = hotelID;
	}

	public String getZusatzID() {
		return zusatzID;
	}

	public void setZusatzID(String zusatzID) {
		this.zusatzID = zusatzID;
	}
}
