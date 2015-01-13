package models;

public class EnthaeltMerkliste {

	private String userID;
	private String hotelID;
	
	public EnthaeltMerkliste(String userID, String hotelID) {
		super();
		this.userID = userID;
		this.hotelID = hotelID;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getHotelID() {
		return hotelID;
	}

	public void setHotelID(String hotelID) {
		this.hotelID = hotelID;
	}
}
