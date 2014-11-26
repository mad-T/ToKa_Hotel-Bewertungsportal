package models;

import java.util.ArrayList;
import java.util.Collection;

public class Model {

	public static Model sharedInstance = new Model();
//	public static Model getInstance(){
//		if (Model.instance == null){
//			Model.instance = new Model();
//		}
//		return Model.instance;
//	}
	
	private Model(){};
	
	private static ArrayList<User> registrierteUser = new ArrayList<User>();
	private static ArrayList<Land> laender = new ArrayList<Land>();
	private static ArrayList<Adresse> adressen = new ArrayList<Adresse>();
/*	private static ArrayList<Hotel> hotels = new ArrayList<Hotel>();*/
	private static ArrayList<Bewertung> bewertungen = new ArrayList<Bewertung>();
	private static ArrayList<Bild> bilder = new ArrayList<Bild>();
	private static ArrayList<Zusatz> zusaetze = new ArrayList<Zusatz>();
	private static ArrayList<EnthaeltZusatzHotel> entZusatzHotel = new ArrayList<EnthaeltZusatzHotel>();
	
	public ArrayList<User> getUser(){
		User user1 = new User("user1@web.de", "Paul", "Müller", "20", "maennlich", "ledig", "Haupststrasse 1", "passwort01", "passwort01", "1");
		User user2 = new User("user2@web.de", "Franz", "Wagner", "65", "maennlich", "ledig", "Haupststrasse 5", "passwort02", "passwort02", "1");
		registrierteUser.add(user1);
		registrierteUser.add(user2);
		return registrierteUser;
	}
	
	public ArrayList<Land> getLaender(){
		Land land1 = new Land("DE", "Deutschland");
		Land land2 = new Land("IT", "Italien");
		laender.add(land1);
		laender.add(land2);
		return laender;
	}
	
	public ArrayList<Adresse> getAdressen(){
		Adresse adr1 = new Adresse("01", "Konstanz", "DE", "78555");
		Adresse adr2 = new Adresse("02", "Rom", "IT", "6545");
		adressen.add(adr2);
		adressen.add(adr2);
		return adressen;
	}
	
/*	public ArrayList<Hotel> getHotels(){
		Hotel hotel1 = new Hotel("50", "01", "Laaange Beschreibung Hotel in Konstanz", "Schoenes Hotel", "5", "AI", "F", "J");
		Hotel hotel2 = new Hotel("51", "01", "Laaange Beschreibung Hotel in Rom", "Modernes Hotel", "3", "HP", "S", "J");
		hotels.add(hotel1);
		hotels.add(hotel2);
		return hotels;
	}*/

	static ArrayList<Hotel> hotels;
	static ArrayList<Hotel> hotelsResult;
	
	public static ArrayList<Hotel> getHotels(String land, String stadt, String hotel, String verpflegung){
		
		hotels = new ArrayList<Hotel>();
		hotelsResult = new ArrayList<Hotel>();
		
		Hotel hotel1 = new Hotel("50", "/assets/images/hotel_kn.jpg", "Konstanzia", "01", "Laaange Beschreibung Hotel in Konstanz", "Schoenes Hotel", "5", "AI", "F", "J");
		Hotel hotel2 = new Hotel("51", "/assets/images/hotel_rom.jpg", "Römerhaus", "02", "Laaange Beschreibung Hotel in Rom", "Modernes Hotel", "3", "HP", "S", "J");
		
		hotels.add(hotel1);
		hotels.add(hotel2);
			
		//wenn nach nichts gefiltert wird
		 if (hotel == null && land == null && stadt == null) {
			for (int i = 0; i < hotels.size(); i++) {
				hotelsResult.add(hotels.get(i));
			}
		} 
		 
		//wenn nur nach Land gesucht wird
		if (hotel == null && land != null && stadt == null) {
			for (int i = 0; i < hotels.size(); i++) {
				for (int j = 0; j < adressen.size(); j++) {
					if (hotels.get(i).getFk_adresse().equals(adressen.get(j).getId()) && adressen.get(j).getFk_Land().equals(land)) {
						hotelsResult.add(hotels.get(i));
					}
				}
			}
		}
		
		
		//wenn nur nach Stadt gesucht wird oder nach Land und Stadt
		if ((hotel == null && land == null && stadt != null) || 
				(hotel == null && land != null && stadt != null)) {
			for (int i = 0; i < hotels.size(); i++) {
				for (int j = 0; j < adressen.size(); j++) {
					if (hotels.get(i).getFk_adresse().equals(adressen.get(j).getId()) && adressen.get(j).getOrt().equals(stadt)) {
						hotelsResult.add(hotels.get(i));
					}
				}
			}
		}
		
		//wenn nur nach Hotel gesucht wird oder nach Land und Hotel oder Stadt und Hotel oder nach allem
		if ((hotel != null && land == null && stadt == null) ||
				(hotel != null && land == null && stadt != null) ||
				(hotel != null && land != null && stadt != null) ||
				(hotel != null && land != null && stadt != null)) {
			for (int i = 0; i < hotels.size(); i++) {
				if (hotels.get(i).getName().equals(hotel)) {
					hotelsResult.add(hotels.get(i));
				}
			}
		}
		
		hotelsResult.add(hotel2);
		hotelsResult.add(hotel1);
		hotelsResult.add(hotel2);
		
		////nochmal überprüfen logik stimmt noch nicht ganz
		//if (verpflegung != null) {
			for (int i = 0; i < hotelsResult.size(); i++) {
				if (hotelsResult.get(i).getVerpflegung().equals(verpflegung)) {
					
				}else {
					hotelsResult.remove(i);
				}
			}
		//}
		
		return hotelsResult;
	}
	
	public ArrayList<Bewertung> getBewertungen(){
		Bewertung bewertung1 = new Bewertung("90", "Alles Top", "F", "J", "HP", "18/03/2013", "25/03/2013", "4", "22/11/2013", "01");
		Bewertung bewertung2 = new Bewertung("91", "Altes Hotel", "S", "J", "AI", "10/08/2014", "28/08/2014", "3", "29/08/2014", "02");
		bewertungen.add(bewertung1);
		bewertungen.add(bewertung2);
		return bewertungen;
	}
	
	public ArrayList<Bild> getBilder(){
		Bild bild1 = new Bild("80", "Hotel von aussen", "C://", "50", "NULL");
		Bild bild2 = new Bild("81", "Hotelzimmer", "C://", "NULL", "90");
		bilder.add(bild1);
		bilder.add(bild2);
		return bilder;
	}
	
	public ArrayList<Zusatz> getZusaetze(){
		Zusatz zusatz1 = new Zusatz("Pool", "Pool im Aussenbereich");
		Zusatz zusatz2 = new Zusatz("Fahrrad", "Fahrrad Verleih an der Hotelrezeption");
		zusaetze.add(zusatz1);
		zusaetze.add(zusatz2);
		return zusaetze;
	}
	
	public ArrayList<EnthaeltZusatzHotel> getEntZusatzHotel(){
		EnthaeltZusatzHotel ezh1 = new EnthaeltZusatzHotel("50", "Pool");
		EnthaeltZusatzHotel ezh2 = new EnthaeltZusatzHotel("50", "Fahrrad");
		EnthaeltZusatzHotel ezh3 = new EnthaeltZusatzHotel("51", "Pool");
		entZusatzHotel.add(ezh1);
		entZusatzHotel.add(ezh2);
		entZusatzHotel.add(ezh3);
		return entZusatzHotel;
	}
	
}
