package models;

import java.util.ArrayList;
import java.util.Collection;
import java.sql.*;
import java.security.*;
import java.util.Date;
import java.text.DateFormat;
import java.util.List;
import java.io.*;
import play.mvc.Http.MultipartFormData.FilePart;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Observable;

public class Model extends Observable {

	public static Model sharedInstance = new Model();
	
	private Model(){
		initializeDB();
	};
	
	private static Connection tokaConnection = null;
	
	private static ArrayList<User> registrierteUser = new ArrayList<User>();
	private static ArrayList<Land> laender = new ArrayList<Land>();
	private static ArrayList<Adresse> adressen = new ArrayList<Adresse>();
	private static ArrayList<Hotel> hotels = new ArrayList<Hotel>();
	private static ArrayList<Hotel> hotelsResult = new ArrayList<Hotel>();
	private static ArrayList<Hotel> topHotelsResult = new ArrayList<Hotel>();
	private static ArrayList<Bewertung> recentlyRated = new ArrayList<Bewertung>();
	private static ArrayList<Bewertung> bewertungen = new ArrayList<Bewertung>();
	private static ArrayList<Bild> bilder = new ArrayList<Bild>();
	private static ArrayList<Zusatz> zusaetze = new ArrayList<Zusatz>();
	private static ArrayList<EnthaeltZusatzHotel> entZusatzHotel = new ArrayList<EnthaeltZusatzHotel>();

	//get recently rated (last 3) hotels
	private static int prüfsummeID, lastPrüfsummeID = 0;
	public ArrayList<Bewertung> getRecentlyRatedHotels() throws SQLException{
		try {
        	tokaConnection = DBAccess.getConnection();
            PreparedStatement pstmt = null;
            PreparedStatement pstmtPrüfsummeID = null;
            ResultSet rs = null;
            ResultSet rsPrüfsummeID = null;
            try {
                String query = "SELECT h.Name, b.ID, b.Rating, b.Erfassungsdatum, b.Kurzkommentar FROM Bewertung b, Hotel h WHERE b.FK_Hotel = h.ID order by b.ID desc limit 3;";
                pstmt = tokaConnection.prepareStatement(query);
                rs = pstmt.executeQuery();
                String prüfsummeIDQuery = "SELECT sum(id) FROM Bewertung;";
                pstmtPrüfsummeID = tokaConnection.prepareStatement(prüfsummeIDQuery);
                rsPrüfsummeID = pstmtPrüfsummeID.executeQuery();
                try {
                	prüfsummeID = Integer.parseInt(rsPrüfsummeID.getString("sum(id)"));
                } catch (Exception e){};            
                if (prüfsummeID != lastPrüfsummeID){
                	recentlyRated.clear();
                	lastPrüfsummeID = prüfsummeID;
                	while (rs.next()) {
               			String kurzkommentar = rs.getString("Kurzkommentar");
                	 	String rating = rs.getString("Rating");
                	 	String erfassungsDatum = rs.getString("Erfassungsdatum");
                	 	String fk_hotel = rs.getString("Name");
	               		Bewertung newBewertung = new Bewertung(null, null, kurzkommentar, null, null, null, null, null, rating, erfassungsDatum, fk_hotel);
	               		recentlyRated.add(newBewertung);
	               		}
	               }
	           } finally {
	               try { rs.close(); rsPrüfsummeID.close(); pstmt.close(); pstmtPrüfsummeID.close(); } catch (Exception ignore) {}
	           }
	       } finally {
	           try { tokaConnection.close(); } catch (Exception ignore) {}
	       }
		return recentlyRated;
	}
	
	public ArrayList<User> getUser() throws SQLException {
		try {
	        	tokaConnection = DBAccess.getConnection();
	            PreparedStatement pstmt = null;
	            ResultSet rs = null;
	            try {
	            	String query = "SELECT * FROM User;";
	            	pstmt = tokaConnection.prepareStatement(query);
	                rs = pstmt.executeQuery();
	                int i = 0;
	                while (rs.next()) {
	                	i++;
	            	 	String email = rs.getString("Email");
	            	 	String vorname = rs.getString("Vorname");
	            	 	String nachname = rs.getString("Nachname");
	            	 	String geburtstag = rs.getString("Geburtstag");
	            	 	String geschlecht = rs.getString("Geschlecht");
	            	 	String familienstand = rs.getString("Familienstand");
	            	 	String passwort = rs.getString("Passwort");
	            	 	String fk_Adresse = rs.getString("FK_Adresse");
	            		User newUser = new User(email, vorname, nachname, geburtstag, geschlecht, familienstand, passwort, fk_Adresse);
	            		registrierteUser.add(newUser);
	                }       
	            } finally {
	                try { rs.close(); pstmt.close(); } catch (Exception ignore) {}
	            }
	        } finally {
	            try { tokaConnection.close(); } catch (Exception ignore) {}
	        }
		return registrierteUser;
	}
	
	public ArrayList<Land> getLaender() throws SQLException{
		laender.clear();
		try {
        	tokaConnection = DBAccess.getConnection();
            PreparedStatement pstmt = null;
            ResultSet rs = null;
            try {
            	String query = "SELECT * FROM Land;";
            	pstmt = tokaConnection.prepareStatement(query);
                rs = pstmt.executeQuery();
                while (rs.next()) {
            	 	String id = rs.getString("ID");
            	 	String beschreibung = rs.getString("Beschreibung");
            		Land newLand = new Land(id, beschreibung);
            		laender.add(newLand);
                }       
            } finally {
                try { rs.close(); pstmt.close(); } catch (Exception ignore) {}
            }
        } finally {
            try { tokaConnection.close(); } catch (Exception ignore) {}
        }
		return laender;
	}
	
	public ArrayList<Adresse> getAdressen() throws SQLException{
		adressen.clear();
		try {
        	tokaConnection = DBAccess.getConnection();
           	PreparedStatement pstmt = null;
            ResultSet rs = null;
            try {
            	String query = "SELECT * FROM Adresse;";
            	pstmt = tokaConnection.prepareStatement(query);
                rs = pstmt.executeQuery();
                while (rs.next()) {
            	 	String id = rs.getString("ID");
            	 	String ort = rs.getString("Ort");
            	 	String plz = rs.getString("PLZ");
            	 	String strasse = rs.getString("Strasse");
            	 	String fk_land = rs.getString("FK_Land");
            		Adresse newAdresse = new Adresse(id, ort, plz, strasse, fk_land);
            		adressen.add(newAdresse);
                }       
            } finally {
                try { rs.close(); pstmt.close(); } catch (Exception ignore) {}
            }
        } finally {
            try { tokaConnection.close(); } catch (Exception ignore) {}
        }
		return adressen;
	}
	
	public ArrayList<Hotel> getAllHotels() throws SQLException {
		hotels.clear();
		try {
        	tokaConnection = DBAccess.getConnection();
            PreparedStatement pstmt = null;
            ResultSet rs = null;
            try {
            	String query = "SELECT * FROM Hotel;";
            	pstmt = tokaConnection.prepareStatement(query);
                rs = pstmt.executeQuery();
                while (rs.next()) {
            	 	String id = rs.getString("ID");
            	 	String name = rs.getString("Name");
            	 	String langtext = rs.getString("Langtext");
            	 	String kurzbeschreibung = rs.getString("Kurzbeschreibung");
            	 	String verpflegung = rs.getString("Verpflegung");
            	 	String kinder = rs.getString("Kinder");
            	 	String fk_adresse = rs.getString("FK_Adresse");
            		Hotel newHotel = new Hotel(id, null, name, fk_adresse, langtext, kurzbeschreibung, verpflegung, kinder);
            		hotels.add(newHotel);
                }       
            } finally {
                try { rs.close(); pstmt.close(); } catch (Exception ignore) {}
            }
        } finally {
            try { tokaConnection.close(); } catch (Exception ignore) {}
        }
		return hotels;
	}
	
	public ArrayList<Hotel> getTopHotelsOfYear() throws SQLException {
		topHotelsResult.clear();
		try {
        	tokaConnection = DBAccess.getConnection();
            PreparedStatement pstmt = null;
            ResultSet rs = null;
            try {
            	String query = "SELECT h.Name, h.Kurzbeschreibung, sum(b.Rating) AS summe_Stars, bi.Pfad from Hotel h, Bewertung b, Bild bi where b.FK_Hotel = h.ID AND b.Von LIKE '%2015%' AND bi.FK_Hotel = h.ID AND bi.Pfad LIKE '%titelbild%' group by h.name order by sum(b.Rating) desc limit 6;";
            	pstmt = tokaConnection.prepareStatement(query);
                rs = pstmt.executeQuery();
                while (rs.next()) {
                	String name = rs.getString("Name");
                	String kurzbeschreibung = rs.getString("Kurzbeschreibung");
                	//Wichtig: In variable langtext wird die Summe der Stars pro Hotel gespeichert
                	String langtext = rs.getString("summe_Stars");
                	String titelbild = rs.getString("Pfad");           	 	
            		Hotel newHotel = new Hotel(null, titelbild, name, null, langtext, kurzbeschreibung, null, null);
            		topHotelsResult.add(newHotel);
                }       
            } finally {
                try { rs.close(); pstmt.close(); } catch (Exception ignore) {}
            }
        } finally {
            try { tokaConnection.close(); } catch (Exception ignore) {}
        }
		return topHotelsResult;
	}
	
public ArrayList<Hotel> getHotels(String l, String s, String h, String verpflegung, String pool, String strand, String zentrum, String fahrrad) throws SQLException{
		String leerString = "";
		hotels = getAllHotels();
		hotelsResult.clear();	
		
		String land = null;
		String stadt = null;
		String hotel = null;

		if (l != null) {
			land = l.toUpperCase();
		}
		
		if (s != null) {
			stadt = s.toUpperCase();
		}
		
		if (h != null) {
			 hotel = h.toUpperCase();
		}
		
		//wenn nach nichts gefiltert wird
		 if ((leerString.equals(hotel) || (hotel == null)) && (leerString.equals(land) || (land == null)) && (leerString.equals(stadt) || (stadt == null))) {
			for (int i = 0; i < hotels.size(); i++) {
				hotelsResult.add(hotels.get(i));
			}
		} 
		
		ArrayList<Adresse> adressen = Model.sharedInstance.getAdressen();
		ArrayList<Land> laender = Model.sharedInstance.getLaender();
			
		//Landname wird in ID für die Suche umgewandelt
		if (land != null){
			for (int i = 0 ; i < laender.size() ; i++) {
				if (land.equals(laender.get(i).getBeschreibung().toUpperCase())){
					land = laender.get(i).getId();
				}
			}
		}
		
		////// Ländersuche
		//wenn nur nach Land gesucht wird
		if ((leerString.equals(hotel) || (hotel == null)) && ((!leerString.equals(land)) || (land != null)) && ((leerString.equals(stadt)) || (stadt == null))) {
			for (int i = 0; i < hotels.size(); i++) {
				for (int j = 0; j < adressen.size(); j++) {
					if (hotels.get(i).getFk_adresse().equals(adressen.get(j).getId()) && adressen.get(j).getFk_Land().equals(land)) {
						hotelsResult.add(hotels.get(i));
					}
				}
			}
		}
		
		laender = Model.sharedInstance.getLaender();
		
		////// Städtesuche
		//wenn nur nach Stadt gesucht wird
		if (((leerString.equals(hotel) || (hotel == null)) && ((leerString.equals(land)) || (land == null)) && ((!leerString.equals(stadt)) || (stadt != null)))) {
			for (int i = 0; i < hotels.size(); i++) {
				for (int j = 0; j < adressen.size(); j++) {
					if ((hotels.get(i).getFk_adresse().equals(adressen.get(j).getId()) && adressen.get(j).getOrt().toUpperCase().equals(stadt))) {
						hotelsResult.add(hotels.get(i));
					}
				}
			}
		}
		
		//wenn nur nach Stadt und Land gesucht wird
		if ((leerString.equals(hotel) || (hotel == null)) && ((!leerString.equals(land)) || (land != null)) && ((!leerString.equals(stadt)) || (stadt != null))) {
			for (int i = 0; i < hotels.size(); i++) {
				for (int j = 0; j < adressen.size(); j++) {
					if ((hotels.get(i).getFk_adresse().equals(adressen.get(j).getId()) && adressen.get(j).getFk_Land().equals(land)) && 
							(hotels.get(i).getFk_adresse().equals(adressen.get(j).getId()) && adressen.get(j).getOrt().toUpperCase().equals(stadt))) {
						hotelsResult.add(hotels.get(i));
					}
				}
			}
		}
		
		//////Hotelsuche
		// wenn nur nach Hotel gesucht wird
		if ((!leerString.equals(hotel) || (hotel != null)) && ((leerString.equals(land)) || (land == null)) && ((leerString.equals(stadt)) || (stadt == null))) {
			for (int i = 0; i < hotels.size(); i++) {
				if (hotels.get(i).getName().toUpperCase().equals(hotel)) {
					hotelsResult.add(hotels.get(i));
				}
			}
		}
		
		// wenn nur nach Hotel und Land gesucht wird
		if ((!leerString.equals(hotel) || (hotel != null)) && ((!leerString.equals(land)) || (land != null)) && ((leerString.equals(stadt)) || (stadt == null))) {
			for (int i = 0; i < hotels.size(); i++) {
				for (int j = 0; j < adressen.size(); j++) {
					if ((hotels.get(i).getFk_adresse().equals(adressen.get(j).getId()) && adressen.get(j).getFk_Land().equals(land)) && 
							(hotels.get(i).getName().toUpperCase().equals(hotel))) {
						hotelsResult.add(hotels.get(i));
					}
				}
			}
		}
		
		// wenn nur nach Hotel und Stadt gesucht wird
		if ((!leerString.equals(hotel) || (hotel != null)) && ((leerString.equals(land)) || (land == null)) && ((!leerString.equals(stadt)) || (stadt != null))) {
			for (int i = 0; i < hotels.size(); i++) {
				for (int j = 0; j < adressen.size(); j++) {
					if ((hotels.get(i).getFk_adresse().equals(adressen.get(j).getId()) && adressen.get(j).getOrt().toUpperCase().equals(stadt))
							&& (hotels.get(i).getName().toUpperCase().equals(hotel))) {
						hotelsResult.add(hotels.get(i));
					}
				}
			}
		}
		
		// wenn nach Hotel, Land und Stadt gesucht wird
		if ((!leerString.equals(hotel) || (hotel != null)) && ((!leerString.equals(land)) || (land != null)) && ((!leerString.equals(stadt)) || (stadt != null))) {
			for (int i = 0; i < hotels.size(); i++) {
				for (int j = 0; j < adressen.size(); j++) {
					if ((hotels.get(i).getFk_adresse().equals(adressen.get(j).getId()) && adressen.get(j).getOrt().toUpperCase().equals(stadt))
							&& (hotels.get(i).getFk_adresse().equals(adressen.get(j).getId()) && adressen.get(j).getFk_Land().equals(land)) 
							&& (hotels.get(i).getName().toUpperCase().equals(hotel))) {
						hotelsResult.add(hotels.get(i));
					}
				}
			}
		}

		
		if ((verpflegung != null)) {
			int laenge = hotelsResult.size()-1;
			for (int i = laenge; 0 <= i; i--) {
				if (hotelsResult.get(i).getVerpflegung().equals(verpflegung)) {
					
				}else {
					hotelsResult.remove(i);
				}
			}
		}
		
		ArrayList<EnthaeltZusatzHotel> zusaetze = Model.sharedInstance.getEntZusatzHotel();
		
		if (pool.equals("ja")) {
			boolean loeschen = false;
			int laenge = hotelsResult.size()-1;
			for (int i = laenge; 0 <= i; i--) {
				for (int j = 0; j < zusaetze.size(); j++) {
					if ((hotelsResult.get(i).getId().equals(zusaetze.get(j).getHotelID())) && (zusaetze.get(j).getZusatzID().equals("Pool"))) {
						loeschen = false;
						break;
					}else {
						loeschen = true;
					}
				}
				if (loeschen) {
					hotelsResult.remove(i);
					loeschen = false;
				}
			}
		}
		
		if (strand.equals("ja")) {
			boolean loeschen = false;
			int laenge = hotelsResult.size()-1;
			for (int i = laenge; 0 <= i; i--) {
				for (int j = 0; j < zusaetze.size(); j++) {
					if ((hotelsResult.get(i).getId().equals(zusaetze.get(j).getHotelID())) && (zusaetze.get(j).getZusatzID().equals("Strand"))) {
						loeschen = false;
						break;
					}else {
						loeschen = true;
					}
				}
				if (loeschen) {
					hotelsResult.remove(i);
					loeschen = false;
				}
			}
		}
		
		if (zentrum.equals("ja")) {
			boolean loeschen = false;
			int laenge = hotelsResult.size()-1;
			for (int i = laenge; 0 <= i; i--) {
				for (int j = 0; j < zusaetze.size(); j++) {
					if ((hotelsResult.get(i).getId().equals(zusaetze.get(j).getHotelID())) && (zusaetze.get(j).getZusatzID().equals("Zentrum"))) {
						loeschen = false;
						break;
					}else {
						loeschen = true;
					}
				}
				if (loeschen) {
					hotelsResult.remove(i);
					loeschen = false;
				}
			}
		}
		
		if (fahrrad.equals("ja")) {
			boolean loeschen = false;
			int laenge = hotelsResult.size()-1;
			for (int i = laenge; 0 <= i; i--) {
				for (int j = 0; j < zusaetze.size(); j++) {
					if ((hotelsResult.get(i).getId().equals(zusaetze.get(j).getHotelID())) && (zusaetze.get(j).getZusatzID().equals("Fahrrad"))) {
						loeschen = false;
						break;
					}else {
						loeschen = true;
					}
				}
				if (loeschen) {
					hotelsResult.remove(i);
					loeschen = false;
				}
			}
		}	
		return hotelsResult;
	}
	
	public ArrayList<Bewertung> getBewertungen() throws SQLException{
		try {
        	tokaConnection = DBAccess.getConnection();
            PreparedStatement pstmt = null;
            ResultSet rs = null;
            try {
            	String query = "SELECT * FROM Bewertung;";
            	pstmt = tokaConnection.prepareStatement(query);
                rs = pstmt.executeQuery();
                while (rs.next()) {
            	 	String id = rs.getString("ID");
            	 	String beschreibung = rs.getString("Beschreibung");
            	 	String kurzkommentar = rs.getString("Kurzkommentar");
            	 	String art = rs.getString("Art");
            	 	String kinder = rs.getString("Kinder");
            	 	String verpflegung = rs.getString("Verpflegung");
            	 	String von = rs.getString("Von");
            	 	String bis = rs.getString("Bis");
            	 	String rating = rs.getString("Rating");
            	 	String erfassungsdatum = rs.getString("Erfassungdatum");
            	 	String fk_hotel = rs.getString("FK_Hotel");
            		Bewertung newBewertung = new Bewertung(id, beschreibung, kurzkommentar, art, kinder, verpflegung, von, bis, rating, erfassungsdatum, fk_hotel);
            		bewertungen.add(newBewertung);
                }       
            } finally {
                try { rs.close(); pstmt.close(); } catch (Exception ignore) {}
            }
        } finally {
            try { tokaConnection.close(); } catch (Exception ignore) {}
        }
		return bewertungen;
	}
	
	public ArrayList<Bild> getBilder() throws SQLException{
		try {
        	tokaConnection = DBAccess.getConnection();
            PreparedStatement pstmt = null;
            ResultSet rs = null;
            try {
            	String query = "SELECT * FROM Bild;";
            	pstmt = tokaConnection.prepareStatement(query);
                rs = pstmt.executeQuery();
                while (rs.next()) {
            	 	String id = rs.getString("ID");
            	 	String beschreibung = rs.getString("Beschreibung");
            	 	String pfad = rs.getString("Pfad");
            	 	String fk_hotel = rs.getString("FK_Hotel");
            	 	String fk_bewertung = rs.getString("FK_Bewertung");            	 	
            		Bild newBild = new Bild(id, beschreibung, pfad, fk_hotel, fk_bewertung);
            		bilder.add(newBild);
                }       
            } finally {
                try { rs.close(); pstmt.close(); } catch (Exception ignore) {}
            }
        } finally {
            try { tokaConnection.close(); } catch (Exception ignore) {}
        }
		return bilder;
	}
	
	public static ArrayList<Zusatz> getZusaetze() throws SQLException{
		zusaetze.clear();
		try {
        	tokaConnection = DBAccess.getConnection();
            PreparedStatement pstmt = null;
            ResultSet rs = null;
            try {
            	String query = "SELECT * FROM Zusatz;";
            	pstmt = tokaConnection.prepareStatement(query);
                rs = pstmt.executeQuery();
                while (rs.next()) {
            	 	String id = rs.getString("ID");
            	 	String beschreibung = rs.getString("Beschreibung");            	 	
            		Zusatz newZusatz = new Zusatz(id, beschreibung);
            		zusaetze.add(newZusatz);
                }       
            } finally {
                try { rs.close(); pstmt.close(); } catch (Exception ignore) {}
            }
        } finally {
            try { tokaConnection.close(); } catch (Exception ignore) {}
        }
		return zusaetze;
	}
	
	public static ArrayList<EnthaeltZusatzHotel> getEntZusatzHotel() throws SQLException{
		entZusatzHotel.clear();
		try {
        	tokaConnection = DBAccess.getConnection();
            PreparedStatement pstmt = null;
            ResultSet rs = null;
            try {
            	String query = "SELECT * FROM EnthaeltZusatzHotel;";
            	pstmt = tokaConnection.prepareStatement(query);
                rs = pstmt.executeQuery();
                while (rs.next()) {
            	 	String fk_hotel = rs.getString("FK_Hotel");
            	 	String fk_zusatz = rs.getString("FK_Zusatz");            	 	
            		EnthaeltZusatzHotel newEntZusatzHotel = new EnthaeltZusatzHotel(fk_hotel, fk_zusatz);
            		entZusatzHotel.add(newEntZusatzHotel);
                }       
            } finally {
                try { rs.close(); pstmt.close(); } catch (Exception ignore) {}
            }
        } finally {
            try { tokaConnection.close(); } catch (Exception ignore) {}
        }
		return entZusatzHotel;
	}

	public int createHotelRate(String hotel, String art, String kinder, String verpflegung, String von, String bis, String rating, String kurzkommentar, String beschreibung, play.mvc.Http.MultipartFormData body) throws SQLException{
		String pfad = null;
		String hotelname = null;
		int hotelID = 0;
		int validRate = 0;

		switch(art){
			case "F": art = "Familien-Urlaub";break;
			case "S": art = "Single-Urlaub";break;
			case "P": art = "Party-Urlaub";break;
			case "K": art = "Kultur-Urlaub";break;			
			default: art = "";break;
		}

		switch(kinder){
			case "J": kinder = "Ja";break;
			case "N": kinder = "Nein";break;
			default: kinder = "";break;
		}

		switch(verpflegung){
			case "AI": verpflegung = "All Inclusive";break;
			case "VP": verpflegung = "Vollpension";break;
			case "HP": verpflegung = "Halbpension";break;
			case "N": verpflegung = "Nichts";break;			
			default: verpflegung = "";break;
		}
		ArrayList<String> pfade = new ArrayList<String>();
		if (body != null) {
			List<FilePart> pictures = body.getFiles();
			for (FilePart picture : pictures) {
				pfad = createPicture(picture, "rating");
				pfade.add(pfad);
			}
		}
		try {
        	tokaConnection = DBAccess.getConnection();
            PreparedStatement pstmt = null;
            ResultSet rs = null;
            try {
            	String hoIDQuery = "SELECT ID, Name FROM Hotel h WHERE h.Name = ?;";
            	pstmt = tokaConnection.prepareStatement(hoIDQuery);
            	pstmt.setString(1, hotel);
            	rs = pstmt.executeQuery();
            	while (rs.next()) {
            		hotelname = rs.getString("Name");
            		hotelID = Integer.parseInt(rs.getString("ID"));
            	}
            	String beIDQuery = "SELECT ID FROM Bewertung order by ID desc limit 1;";
            	pstmt = tokaConnection.prepareStatement(beIDQuery);
                rs = pstmt.executeQuery();
                int id = 1; 
                while (rs.next()) {
                	id = Integer.parseInt(rs.getString("ID"));
                	id = id + 1;
                }
                Date date = new Date();
                String erfassungsdatum;
        		DateFormat df;
        		df = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM);
        		erfassungsdatum = df.format(date);
        		String insertUserQuery = "INSERT INTO Bewertung (ID, Beschreibung, Kurzkommentar, Art, Kinder, Verpflegung, Von, Bis, Rating, Erfassungsdatum, FK_Hotel) VALUES("
        				+ "?,?,?,?,?,?,?,?,?,?,?);";
						pstmt = tokaConnection.prepareStatement(insertUserQuery);
        				pstmt.setInt(1, id);
        				pstmt.setString(2, beschreibung);
        				pstmt.setString(3, kurzkommentar);
        				pstmt.setString(4, art);
        				pstmt.setString(5, kinder);
        				pstmt.setString(6, verpflegung);
        				pstmt.setString(7, von);
        				pstmt.setString(8, bis);
        				pstmt.setString(9, rating);
        				pstmt.setString(10, erfassungsdatum);
        				pstmt.setInt(11, hotelID);
		        		pstmt.executeUpdate();
		        		validRate = 1;
		        if(body != null) {
			        for (int i = 0 ; i < pfade.size() ; i++) {
			        	String biIDRateQuery = "SELECT b.ID FROM Bild b WHERE b.Beschreibung LIKE '%Hotelbewertung%' ORDER BY b.ID desc limit 1;";
			        	pstmt = tokaConnection.prepareStatement(biIDRateQuery);
			        	rs = pstmt.executeQuery();
			        	int biIDRate = 1;
			        	while (rs.next()) {
			        		biIDRate = Integer.parseInt(rs.getString("ID"));
			        		biIDRate = biIDRate + 1;
			        	}
			        	String pfad1 = pfade.get(i);
		        		if (pfad1 != null) {
		        		String rateBildbeschreibung = "Hotelbewertung für HotelID " + hotelname;  
		                String insertRatePicQuery = "INSERT INTO Bild (ID, Beschreibung, Pfad, FK_Hotel, FK_Bewertung, FK_User) VALUES ("
		                		+ "?,?,?,?,?,?)";
								pstmt = tokaConnection.prepareStatement(insertRatePicQuery);
		        				pstmt.setInt(1, biIDRate);
		        				pstmt.setString(2, rateBildbeschreibung);
		        				pstmt.setString(3, pfad1);
		        				pstmt.setString(4, "null");
		        				pstmt.setInt(5, id);
		        				pstmt.setString(6, "null");
		        				pstmt.executeUpdate();
						}
					pfade.clear();
					}
				}
        		if(countObservers()>0){
        			setChanged();
        			notifyObservers();
        		}
            } finally {
                try { rs.close(); pstmt.close(); } catch (Exception ignore) {}
            }
        } finally {
            try { tokaConnection.close(); } catch (Exception ignore) {}
        }

        return validRate;
	}
	
	public int checkRegistration(String email, String vorname, String nachname, String geburtstag, String geschlecht, String familienstand, String strasse, String ort, String plz, String land, String passwort, String passwort_wdh, play.mvc.Http.MultipartFormData body) throws SQLException, NoSuchAlgorithmException, NoSuchProviderException {
		ArrayList<User> registrierteUser = Model.sharedInstance.getUser();
		int emailParameter = 2;		
		
		for (User user : registrierteUser) {
			if (user.getEmail().equals(email)) {
				// email adresse ist nicht eindeutig
				emailParameter = 1;
				break;
			}
		}

		if (emailParameter == 2) {
			Model.sharedInstance.createUser(email, vorname, nachname, geburtstag, geschlecht, familienstand, strasse, ort, plz, land,
					passwort);
			String pfad = null;
			if (body != null) {
				List<FilePart> pictures = body.getFiles();
				for (FilePart picture : pictures) {
					pfad = Model.sharedInstance.createPicture(picture, "user");
				}
			}
		
			try {
				tokaConnection = DBAccess.getConnection();
				ResultSet rs = null;
				String query = "SELECT b.ID FROM Bild b WHERE b.Beschreibung LIKE '%User-Pic%' ORDER BY b.ID desc limit 1;";
				PreparedStatement pstmt = tokaConnection.prepareStatement(query);
				try {
					rs = pstmt.executeQuery();
					int id = 1; 
					while (rs.next()) {
						id = Integer.parseInt(rs.getString("ID"));
						id = id + 1;
					}
					if (pfad == null){
						pfad = "null";
					}
					String beschreibung = "User-Pic " + vorname;
					String insertUserPicQuery = "INSERT INTO Bild (ID, Beschreibung, Pfad, FK_Hotel, FK_Bewertung, FK_User) VALUES ("
						+ "?,?,?,?,?,?);";
						pstmt = tokaConnection.prepareStatement(insertUserPicQuery);
        				pstmt.setInt(1, id);
        				pstmt.setString(2, beschreibung);
        				pstmt.setString(3, pfad);
        				pstmt.setString(4, "null");
        				pstmt.setString(5, "null");
        				pstmt.setString(6, email);
						pstmt.executeUpdate();
				} finally {
					try { rs.close(); pstmt.close();} catch (Exception ignore) {}
				}
			} finally {
				try { tokaConnection.close(); } catch (Exception ignore) {}
			}
		}

		return emailParameter;
	}
	
	public void createUser(String email, String vorname, String nachname, String geburtstag, String geschlecht, String familienstand, String strasse, String ort, String plz, String land, String passwort) throws SQLException, NoSuchAlgorithmException, NoSuchProviderException {
		boolean landVorhanden = false;
		boolean adresseVorhanden = false;
		String landID = null;
		String adressID = null;
		
		//prüfen ob Land vorhanden ist
		ArrayList<Land> laender = Model.sharedInstance.getLaender();	
		
		for (Land landTmp : laender) {
			if (landTmp.getBeschreibung().toUpperCase().equals(land.toUpperCase())) {
				landVorhanden = true;
				landID = landTmp.getId();
				break;
			} else {
				landVorhanden = false;
			}
		}

		int idLand = 1;
		if (landVorhanden == false) {
			try {
        		tokaConnection = DBAccess.getConnection();
           	 	PreparedStatement pstmt = null;
            	ResultSet rs = null;
            	String query = "SELECT l.ID FROM Land l ORDER BY l.ID desc limit 1;";
            	pstmt = tokaConnection.prepareStatement(query);
            	try {
                	rs = pstmt.executeQuery(); 
                	while (rs.next()) {
                		idLand = Integer.parseInt(rs.getString("ID"));
                		idLand = idLand + 1;
                	} 
        			String insertLandQuery = "INSERT INTO Land (ID, Beschreibung) VALUES("
        				+ "?,?);";
						pstmt = tokaConnection.prepareStatement(insertLandQuery);
						pstmt.setInt(1, idLand);
						pstmt.setString(2, land);
        				pstmt.executeUpdate();
            } finally {
                try { rs.close(); pstmt.close(); } catch (Exception ignore) {}
            }
       		} finally {
            try { tokaConnection.close(); } catch (Exception ignore) {}
        	}
		}
		
		//prüfen ob adresse vorhanden ist
		//Änderung Tobi: Kriterium Strasse wird noch zur Überprüfung herangezogen / 171214
		ArrayList<Adresse> adressen = Model.sharedInstance.getAdressen();
		for (Adresse adresse : adressen) {
			if ((adresse.getPlz() == plz) && (adresse.getOrt().toUpperCase().equals(ort.toUpperCase())) && (adresse.getStrasse().equals(strasse))) {
				adresseVorhanden = true;
				adressID = adresse.getId();
				break;
			} else {
				adresseVorhanden = false;
			}
		}
		
		int idAdresse = 1;
		if (adresseVorhanden == false) {
			try {
        		tokaConnection = DBAccess.getConnection();
            	PreparedStatement pstmt = null;
            	ResultSet rs = null;
            	String query = "SELECT a.ID FROM Adresse a ORDER BY a.ID desc limit 1;";
            		try {
            			pstmt = tokaConnection.prepareStatement(query);
                		rs = pstmt.executeQuery(); 
                		while (rs.next()) {
                		idAdresse = Integer.parseInt(rs.getString("ID"));
                		idAdresse = idAdresse + 1;

                		String insertAdresseQuery = "INSERT INTO Adresse (ID, Ort, PLZ, Strasse, FK_Land) VALUES("
        				+ "?,?,?,?,?);";
						pstmt = tokaConnection.prepareStatement(insertAdresseQuery);
						pstmt.setInt(1, idAdresse);
						pstmt.setString(2, ort);
						pstmt.setString(3, plz);
						pstmt.setString(4, strasse);
						pstmt.setInt(5, idLand);
        				pstmt.executeUpdate();
                	}
            } finally {
                try { rs.close(); pstmt.close(); } catch (Exception ignore) {}
            }
        	} finally {
            try { tokaConnection.close(); } catch (Exception ignore) {}
        	}
		}

		String hashPasswort = getSecurePassword(passwort);	

		switch(geschlecht){
			case "m": geschlecht = "männlich";break;
			case "w": geschlecht = "weiblich";break;
			default: geschlecht = "";break;
		}

		switch(familienstand){
			case "ld": familienstand = "ledig";break;
			case "vh": familienstand = "verheiratet";break;
			case "gt": familienstand = "getrennt";break;
			case "gs": familienstand = "geschieden";break;
			case "vw": familienstand = "verwitwet";break;
			default: familienstand = "";break;
		}

        try {
        	tokaConnection = DBAccess.getConnection();
            PreparedStatement pstmt = null;
            try {
            	String insertUserQuerie = "INSERT INTO User (Email, Vorname, Nachname, Geburtstag, Geschlecht, Familienstand, Passwort, FK_Adresse) VALUES("
				+ "?,?,?,?,?,?,?,?);";
				pstmt = tokaConnection.prepareStatement(insertUserQuerie);
				pstmt.setString(1, email);
				pstmt.setString(2, vorname);
				pstmt.setString(3, nachname);
				pstmt.setString(4, geburtstag);
				pstmt.setString(5, geschlecht);
				pstmt.setString(6, familienstand);
				pstmt.setString(7, hashPasswort);
				pstmt.setInt(8, idAdresse);     
                pstmt.executeUpdate();          
            } finally {
                try {pstmt.close(); } catch (Exception ignore) {}
            }
        } finally {
            try { tokaConnection.close(); } catch (Exception ignore) {}
        }
	}

	// Methode für das Passwort-Hashing
    public static String getSecurePassword(String passwordToHash)
    {
        String generatedPassword = null;
       try {
            // Create MessageDigest instance for MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
            //Add password bytes to digest
            md.update(passwordToHash.getBytes());
            //Get the hash's bytes
            byte[] bytes = md.digest();
            //This bytes[] has bytes in decimal format;
            //Convert it to hexadecimal format
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            //Get complete hashed password in hex format
            generatedPassword = sb.toString();
        }
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
        return generatedPassword;
    }
	
	public static String createPicture(FilePart picture, String woher) {
		String pfad = null;

		if (woher.equals("user")) {
			if (picture != null) {
				String fileName = picture.getFilename();
				File file = picture.getFile();
				file.renameTo(new File("./public/images/user", fileName));
				pfad = "/assets/images/user/" + fileName;
			}
		}

		if (woher.equals("rating")) {
			if (picture != null) {
				String fileName = picture.getFilename();
				File file = picture.getFile();
				file.renameTo(new File("./public/images/bewertungen", fileName));
				pfad = "/assets/images/bewertungen/" + fileName;
			}
		}						
		return pfad;
	}
	
	public static String autoComplete(String eingabe) throws SQLException {
		
		if( null != eingabe && 0 < eingabe.trim().length() ) {
			
			ArrayList<Hotel> hotels = Model.sharedInstance.getAllHotels();			
			String[] meinTextArray = new String[hotels.size()];
			
			for (int i = 0; i < meinTextArray.length; i++) {
				meinTextArray[i] = hotels.get(i).getName();
			}
		
			java.util.Arrays.sort( meinTextArray );

			StringBuffer auswahl = new StringBuffer();
			boolean resultFound = false;
			for( int i=0; i<meinTextArray.length; i++ ) {
			  if( meinTextArray[i].toUpperCase().startsWith( eingabe.toUpperCase() ) ) {
				auswahl.append( meinTextArray[i] ).append( ";" );
				resultFound = true;
			  } else {
				if( resultFound ) break;
			  }
			}
			if( 0 < auswahl.length() ) {
			  auswahl.setLength( auswahl.length() - 1 );
			}
			return auswahl.toString() ;
		}
		return null;
	}
	
	public static Hotel getOneHotel(String name) throws SQLException{
		Hotel hotel = null;
		
		try {
        	tokaConnection = DBAccess.getConnection();
        	PreparedStatement ps = tokaConnection.prepareStatement("SELECT * FROM Hotel where Name = ?");
        	ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            try {
                while (rs.next()) {
            	 	String id = rs.getString("ID");
            	 	String langtext = rs.getString("Langtext");
            	 	String kurzbeschreibung = rs.getString("Kurzbeschreibung");
            	 	String verpflegung = rs.getString("Verpflegung");
            	 	String kinder = rs.getString("Kinder");
            	 	String fk_adresse = rs.getString("FK_Adresse"); 
            	 	String titelbild = "test"; // muss aus hotel entfernt werden
					switch(verpflegung){
						case "AI": verpflegung = "All Inclusive";break;
						case "VP": verpflegung = "Vollpension";break;
						case "HP": verpflegung = "Halbpension";break;
						case "N": verpflegung = "Nichts";break;			
						default: verpflegung = "";break;
					}
					switch(kinder){
						case "J": kinder = "Ja";break;
						case "N": kinder = "Nein";break;
						default: kinder = "";break;
					}
            	 	hotel = new Hotel(id, titelbild, name, fk_adresse, langtext, kurzbeschreibung, verpflegung, kinder);
                }       
            } finally {
                try { rs.close(); ps.close(); } catch (Exception ignore) {}
            }
        } finally {
            try { tokaConnection.close(); } catch (Exception ignore) {}
        }
		
		return hotel;
	}
	
	public static Bild getOneHotelTitelbild(String hotelId) throws SQLException{
		Bild bild = null;
		
		try {
        	tokaConnection = DBAccess.getConnection();
        	PreparedStatement ps = tokaConnection.prepareStatement("SELECT * FROM Bild WHERE FK_Hotel = ? AND Beschreibung LIKE ?");
        	ps.setString(1, hotelId);
        	ps.setString(2, "Titelbild%");
            ResultSet rs = ps.executeQuery();
            try {
                while (rs.next()) {
                	String id = rs.getString("ID");
            	 	String beschreibung = rs.getString("Beschreibung");
            	 	String pfad = rs.getString("Pfad");
            	 	String fk_Bewertung = rs.getString("FK_Bewertung");
            	 	bild = new Bild(id, beschreibung, pfad, hotelId, fk_Bewertung);
                }       
            } finally {
                try { rs.close(); ps.close(); } catch (Exception ignore) {}
            }
        } finally {
            try { tokaConnection.close(); } catch (Exception ignore) {}
        }
		
		return bild;
	}
	
	public static ArrayList<Bild> getOneHotelBilder(String hotelId) throws SQLException{	
		Bild bild = null;
		ArrayList<Bild> bilder = new ArrayList<Bild>();
		
		try {
        	tokaConnection = DBAccess.getConnection();
            PreparedStatement ps = tokaConnection.prepareStatement("SELECT * FROM Bild WHERE FK_Hotel = ? AND Beschreibung NOT LIKE ?");
        	ps.setString(1, hotelId);
        	ps.setString(2, "Titelbild%");
            ResultSet rs = ps.executeQuery();
            try {
                while (rs.next()) {
                	String id = rs.getString("ID");
            	 	String beschreibung = rs.getString("Beschreibung");
            	 	String pfad = rs.getString("Pfad");
            	 	String fk_Bewertung = rs.getString("FK_Bewertung");
            	 	bild = new Bild(id, beschreibung, pfad, hotelId, fk_Bewertung);
            	 	bilder.add(bild);
                }       
            } finally {
                try { rs.close(); ps.close(); } catch (Exception ignore) {}
            }
        } finally {
            try { tokaConnection.close(); } catch (Exception ignore) {}
        }
		
		return bilder;
	}

	public static ArrayList<Bewertung> getOneHotelRate(String hotelId, boolean all) throws SQLException{
		Bewertung bewertung = null;
		ArrayList<Bewertung> bewertungen = new ArrayList<Bewertung>();

		try {
        	tokaConnection = DBAccess.getConnection();
        	PreparedStatement ps = tokaConnection.prepareStatement("SELECT * FROM Bewertung WHERE FK_Hotel = ? order by Erfassungsdatum desc");
        	ps.setString(1, hotelId);
            ResultSet rs = ps.executeQuery();
            try {
            	int i=0;
                while (rs.next()) {
                	String id = rs.getString("ID");
            	 	String beschreibung = rs.getString("Beschreibung");
            	 	String kurzkommentar = rs.getString("Kurzkommentar");
            	 	String art = rs.getString("Art");
            	 	String kinder = rs.getString("Kinder");
            	 	String verpflegung = rs.getString("Verpflegung");
            	 	String von = rs.getString("Von");
            	 	String bis = rs.getString("Bis");
            	 	String rating = rs.getString("Rating");
            	 	String erfassungsDatum = rs.getString("ErfassungsDatum");
            	 	bewertung = new Bewertung(id, beschreibung, kurzkommentar, art, kinder, verpflegung, von, bis, rating, erfassungsDatum, hotelId);
            	 	
					if (all) {
						bewertungen.add(bewertung);
					}else {
						if (i<3) {
							bewertungen.add(bewertung);
							i++;
						}
					}
                }       
            } finally {
                try { rs.close(); ps.close(); } catch (Exception ignore) {}
            }
        } finally {
            try { tokaConnection.close(); } catch (Exception ignore) {}
        }
		
		return bewertungen;

	}
	
	public static ArrayList<Bild> getPicturesOfRate(String[] rateIds) throws SQLException{
		Bild bild = null;
		ArrayList<Bild> bilder = new ArrayList<Bild>();
		for (int i = 0; i < rateIds.length; i++) {
			try{
				tokaConnection = DBAccess.getConnection();
		        PreparedStatement ps = tokaConnection.prepareStatement("SELECT * FROM Bild WHERE FK_Bewertung = ?");
		    	ps.setString(1, rateIds[i]);
		        ResultSet rs = ps.executeQuery();	

		        try {
			            while (rs.next()) {
			               	String id = rs.getString("ID");
			           	 	String beschreibung = rs.getString("Beschreibung");
			           	 	String pfad = rs.getString("Pfad");
			           	 	String fk_Hotel = rs.getString("FK_Hotel");
			          	 	bild = new Bild(id, beschreibung, pfad, fk_Hotel, rateIds[i]);
			        	 	bilder.add(bild);
		                }       
	            } finally {
	                try { rs.close(); ps.close(); } catch (Exception ignore) {}
	            }
	        } finally {
	            try { tokaConnection.close(); } catch (Exception ignore) {}
	        }

		}
		return bilder;
	}

	public static String[] getSessionData(String email) throws SQLException {
		String[] userDataArray = new String[7];
		try {
	      	tokaConnection = DBAccess.getConnection();
	        PreparedStatement pstmt = tokaConnection.prepareStatement("SELECT u.Email, u.Vorname, u.Nachname, u.Geburtstag, u.Geschlecht, u.Familienstand, b.Pfad FROM User u, Bild b WHERE Email = ? AND b.FK_User = u.Email;");
	        pstmt.setString(1, email);
           	ResultSet rs = pstmt.executeQuery();
	        try {
		        while (rs.next()) {
			       	userDataArray[0] = rs.getString("Email");
			       	userDataArray[1] = rs.getString("Vorname");
			       	userDataArray[2] = rs.getString("Nachname");
			       	userDataArray[3] = rs.getString("Geburtstag");
			       	userDataArray[4] = rs.getString("Geschlecht");
			       	userDataArray[5] = rs.getString("Familienstand");
			       	userDataArray[6] = rs.getString("Pfad");
		     		}        
	        } finally {
	            try { rs.close(); pstmt.close(); } catch (Exception ignore) {}
	        }
	    } finally {
	        try { tokaConnection.close(); } catch (Exception ignore) {}
	    }
	    System.out.println(userDataArray[0] + userDataArray[1] + userDataArray[2] + userDataArray[3] + userDataArray[4] + userDataArray[5] + userDataArray[6]);
		return userDataArray;
	}

	// Defintion Wertigkeiten loginStatusCode
	// -1 -> User nicht vorhanden | 0 -> User vorhanden, Password falsch | 1 -> eingeloggt
	// Definition Index Array loginStatusCode
	// Index 0 -> gibt loginStatusCode an | Index 1 -> email des momentan eingeloggten Users
	public static String[] checkLogin(String checkEmail, String checkPassword) throws SQLException {
		String[] loginStatusCode = new String[2];
		ArrayList<User> registrierteUser = Model.sharedInstance.getUser();
		loginStatusCode[0] = "-1";
		for (User user : registrierteUser) {
			if (user.getEmail().equals(checkEmail)) {
				if (user.getPasswort().equals(checkPassword)) {
					loginStatusCode[0] = "1";
					loginStatusCode[1] = user.getEmail();
				} else {
					loginStatusCode[0] = "0";
				}
			}
		}	

		return loginStatusCode;
	}
	
	public static JsonNode createJSON(){
		System.out.println("json wird erstellt... update bei observer wurde aufgerufen");
		ArrayList<Bewertung> recentlyRatedHotels = null;
		String jsonText = "{\"bewertungen\":[";
		try {
			recentlyRatedHotels = Model.sharedInstance.getRecentlyRatedHotels();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		boolean firstRate = true;
		for (int i = 0; i < recentlyRatedHotels.size(); i++) {
			if (firstRate) {
				jsonText += "{";
				firstRate = false;
			}else {
				jsonText += ",{";
			}
			jsonText += "\"erfasst\":" + "\"" + recentlyRatedHotels.get(i).getErfassungsDatum() + "\",";
			jsonText += "\"hotelname\":" + "\"" + recentlyRatedHotels.get(i).getFk_Hotel() + "\",";
			jsonText += "\"kommentar\":" + "\"" + recentlyRatedHotels.get(i).getKurzkommentar() + "\",";
			jsonText += "\"rating\":" + "\"" + recentlyRatedHotels.get(i).getRating() + "\"";
			jsonText += "}";
		}
		jsonText += "]}";
		System.out.println(jsonText);
		ObjectMapper mapper = new ObjectMapper();
		JsonNode node = null;
		try {
			node = mapper.readValue(jsonText, JsonNode.class);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return node;
	}

	public void initializeDB() {
			Statement stmt = null;
			ResultSet rs = null;
			try {
				tokaConnection = DBAccess.getConnection();
				DatabaseMetaData meta = tokaConnection.getMetaData();
				stmt = tokaConnection.createStatement();
				rs = meta.getTables(null, null, "Zusatz", null);
	if(!rs.next()){
	stmt.executeUpdate(
		"CREATE TABLE Zusatz ('ID' TEXT, 'Beschreibung' TEXT,PRIMARY KEY(ID));"
		+ "INSERT INTO `Zusatz` VALUES ('Pool','Pool im Außenbereich');"
		+ "INSERT INTO `Zusatz` VALUES ('Strand','Strand in der Nähe');"
		+ "INSERT INTO `Zusatz` VALUES ('Zentrum','Zentrum in der Nähe');"
		+ "INSERT INTO `Zusatz` VALUES ('Fahrrad','Fahrradverleih an der Hotelrezeption');");
	}
	rs.close();
	rs = meta.getTables(null, null, "User", null);
	if(!rs.next()){
	stmt.executeUpdate(
		"CREATE TABLE User ("
		+ "`Email`	TEXT NOT NULL,"
		+ "`Vorname`	TEXT NOT NULL,"
		+ "`Nachname`	TEXT NOT NULL,"
		+ "`Geburtstag`	TEXT NOT NULL,"
		+ "`Geschlecht`	TEXT NOT NULL,"
		+ "`Familienstand`	TEXT,"
		+ "`Passwort`	TEXT NOT NULL,"
		+ "`FK_Adresse`	INTEGER,"
		+ "PRIMARY KEY(Email));"
		+ "INSERT INTO `User` VALUES ('tommy@web.de','Tommy','Lala','03.02.1984','männlich','verwitwet','6e1380e75e4d18cf46152ef8d70847b8','1');");
	}
	rs.close();
	rs = meta.getTables(null, null, "Land", null);
	if(!rs.next()){
	stmt.executeUpdate(
		"CREATE TABLE Land ("
		+ " `ID`	INTEGER PRIMARY KEY AUTOINCREMENT,"
		+ "	`Beschreibung`	TEXT);"
		+ "INSERT INTO `Land` VALUES ('1','Deutschland');"
		+ "INSERT INTO `Land` VALUES ('2','Italien');"
		+ "INSERT INTO `Land` VALUES ('3','Griechenland');"
		+ "INSERT INTO `Land` VALUES ('4','Dänemark');"
		+ "INSERT INTO `Land` VALUES ('5','Tschechien');");
	}
	rs.close();
	rs = meta.getTables(null, null, "Hotel", null);
	if(!rs.next()){ 
	stmt.executeUpdate(
	"CREATE TABLE Hotel ("
	+ "`ID`	INTEGER PRIMARY KEY AUTOINCREMENT,"
	+ "`Name`	TEXT,"
	+ "`Langtext`	TEXT,"
	+ "`Kurzbeschreibung`	TEXT,"
	+ "`Verpflegung`	TEXT,"
	+ "`Kinder`	TEXT,"
	+ "`FK_Adresse`	INTEGER);"
	+ "INSERT INTO `Hotel` VALUES ('1','Konstanzia','Hotel wurde im Jahr 1994 gebaut. Restauriert 2008, sehr modernes Hotel, Wlan ist vorhanden und Zimmer sind mit einem Fernsehr ausgestattet. Es gibt sowohl Einzel- als auch Doppelzimmer','modernes Hotel und sehr zentrumnah','AI','J','1');"
	+ "INSERT INTO `Hotel` VALUES ('2','Adlon','Hotel wurde im Jahr 1983 gebaut. Restauriert 2006, elegantes Hotel, Wlan ist vorhanden und Zimmer sind mit einem Fernsehr ausgestattet. Es gibt sowohl Einzel- als auch Doppelzimmer','elegantes Hotel und zum Zentrum sind es ca. 15 Gehminuten','HP','N','6');"
	+ "INSERT INTO `Hotel` VALUES ('3','Römerhaus','Hotel wurde im Jahr 1957 gebaut. Restauriert 2002, eher altmodisches Hotel, Es gibt kein Wlan und Zimmer sind mit einem kleinen Fernsehr ausgestattet. Es gibt sowohl Einzel- als auch Doppelzimmer','altmodisches Hotel und direkte Strandlage','HP','J','2');"
	+ "INSERT INTO `Hotel` VALUES ('4','Adler','Hotel wurde im Jahr 2001 gebaut. Restauriert 2014, sehr schlichtes Hotel, Wlan ist vorhanden und Zimmer sind mit einem Fernsehr ausgestattet. Es gibt sowohl Einzel- als auch Doppelzimmer','schlichtes Hotel und rundum Einkaufsmöglichkeiten','VP','J','4');"
	+ "INSERT INTO `Hotel` VALUES ('5','Atlantikov','Das Hotel Atlantika wurde im Jahr 1975 gebaut. Restauriert 2003, sehr kleines Hotel, Wlan ist vorhanden und Zimmer sind mit einem Fernsehr ausgestattet. Es gibt sowohl Einzel- als auch Doppelzimmer','kleines Hotel gute Verkehrsanbidnung','HP','N','5');"
	+ "INSERT INTO `Hotel` VALUES ('6','Kleopatra','Hotel wurde im Jahr 1994 gebaut. Restauriert 2008, antikes Hotel, Wlan ist vorhanden und Zimmer sind mit einem Fernsehr ausgestattet. Es gibt sowohl Einzel- als auch Doppelzimmer. Bekannt durch seine griechischen Kulinaritäten','antikes Hotel und sehr zentrumnah','AI','J','3');");
	}
	rs.close();
	rs = meta.getTables(null, null, "EnthaeltZusatzHotel", null);
	if(!rs.next()){
	stmt.executeUpdate(
		"CREATE TABLE EnthaeltZusatzHotel ("
		+ "`FK_Hotel`	INTEGER REFERENCES Hotel(ID),"
		+ "`FK_Zusatz`	INTEGER REFERENCES Zusatz(ID),"
		+ "PRIMARY KEY(FK_Hotel,FK_Zusatz));"
		+ "INSERT INTO `EnthaeltZusatzHotel` VALUES ('1','Pool');"
		+ "INSERT INTO `EnthaeltZusatzHotel` VALUES ('1','Fahrrad');"
		+ "INSERT INTO `EnthaeltZusatzHotel` VALUES ('2','Pool');"
		+ "INSERT INTO `EnthaeltZusatzHotel` VALUES ('2','Zentrum');"
		+ "INSERT INTO `EnthaeltZusatzHotel` VALUES ('3','Pool');"
		+ "INSERT INTO `EnthaeltZusatzHotel` VALUES ('3','Strand');"
		+ "INSERT INTO `EnthaeltZusatzHotel` VALUES ('4','Zentrum');"
		+ "INSERT INTO `EnthaeltZusatzHotel` VALUES ('5','Zentrum');"
		+ "INSERT INTO `EnthaeltZusatzHotel` VALUES ('6','Pool');"
		+ "INSERT INTO `EnthaeltZusatzHotel` VALUES ('6','Fahrrad');"
		+ "INSERT INTO `EnthaeltZusatzHotel` VALUES ('6','Zentrum');"
		+ "INSERT INTO `EnthaeltZusatzHotel` VALUES ('6','Strand');");
	}
	rs.close();
	rs = meta.getTables(null, null, "Bild", null);
	if(!rs.next()){
	stmt.executeUpdate(
		"CREATE TABLE Bild ("
		+ "`ID`	INTEGER,"
		+ "`Beschreibung`	TEXT,"
		+ "`Pfad`	TEXT,"
		+ "`FK_Hotel`	INTEGER REFERENCES Hotel(Name),"
		+ "`FK_Bewertung`	INTEGER REFERENCES Bewertung(ID),"
		+ "`FK_User`	INTEGER REFERENCES User(Email),"
		+ "PRIMARY KEY(ID));"
		+ "INSERT INTO `Bild` VALUES ('1','Titelbild Konstanzia','/assets/images/hotels/konstanzia_titelbild.jpg','1','null','null');"
		+ "INSERT INTO `Bild` VALUES ('2','Titelbild Römerhaus','/assets/images/hotels/römerhaus_titelbild.jpg','3','null','null');"
		+ "INSERT INTO `Bild` VALUES ('3','Titelbild Adlon','/assets/images/hotels/adlon_titelbild.jpg','2','null','null');"
		+ "INSERT INTO `Bild` VALUES ('4','Titelbild Adler','/assets/images/hotels/adler_titelbild.jpg','4','null','null');"
		+ "INSERT INTO `Bild` VALUES ('5','Titelbild Atlantikov','/assets/images/hotels/atlantikov_titelbild.jpg','5','null','null');"
		+ "INSERT INTO `Bild` VALUES ('6','Titelbild Kleopatra','/assets/images/hotels/kleopatra_titelbild.jpg','6','null','null');"
		+ "INSERT INTO `Bild` VALUES ('7',NULL,NULL,NULL,NULL,NULL);"
		+ "INSERT INTO `Bild` VALUES ('8',NULL,NULL,NULL,NULL,NULL);"
		+ "INSERT INTO `Bild` VALUES ('9',NULL,NULL,NULL,NULL,NULL);"
		+ "INSERT INTO `Bild` VALUES ('10',NULL,NULL,NULL,NULL,NULL);"
		+ "INSERT INTO `Bild` VALUES ('11','User-Pic Tommy','/assets/images/user/userpic_tommy.jpg','null','null','tommy@web.de');"
		+ "INSERT INTO `Bild` VALUES ('51','Hotelbewertung initial','/','null','null','null');"
		+ "INSERT INTO `Bild` VALUES ('52','Hotelbewertung für HotelID Konstanzia','/assets/images/bewertungen/2011-08-18_Frankfurt_am_Main_Fahrradverleih_Nextbike_Hbf.JPG','null','1','null');"
		+ "INSERT INTO `Bild` VALUES ('53','Hotelbewertung für HotelID Konstanzia','/assets/images/bewertungen/3479_6_rechteck_pool.jpg','null','1','null');"
		+ "INSERT INTO `Bild` VALUES ('54','Hotelbewertung für HotelID Konstanzia','/assets/images/bewertungen/02-kuh-lustig-buffet.jpg','null','1','null');"
		+ "INSERT INTO `Bild` VALUES ('55','Hotelbewertung für HotelID Konstanzia','/assets/images/bewertungen/IC-treffpunkt-konstanz10.jpg','null','2','null');"
		+ "INSERT INTO `Bild` VALUES ('56','Hotelbewertung für HotelID Konstanzia','/assets/images/bewertungen/kaltes-buffet-2.jpg','null','2','null');"
		+ "INSERT INTO `Bild` VALUES ('57','Hotelbewertung für HotelID Konstanzia','/assets/images/bewertungen/apex-hotel-buffet.jpg','null','3','null');"
		+ "INSERT INTO `Bild` VALUES ('58','Hotelbewertung für HotelID Konstanzia','/assets/images/bewertungen/3479_6_rechteck_pool.jpg','null','4','null');"
		+ "INSERT INTO `Bild` VALUES ('59','Hotelbewertung für HotelID Konstanzia','/assets/images/bewertungen/IC-treffpunkt-konstanz10.jpg','null','4','null');"
		+ "INSERT INTO `Bild` VALUES ('60','Hotelbewertung für HotelID Römerhaus','/assets/images/bewertungen/buffet10_1000.jpg','null','5','null');"
		+ "INSERT INTO `Bild` VALUES ('61','Hotelbewertung für HotelID Römerhaus','/assets/images/bewertungen/shakespeare-hotel.jpg','null','5','null');"
		+ "INSERT INTO `Bild` VALUES ('62','Hotelbewertung für HotelID Atlantikov','/assets/images/bewertungen/29714.l.jpg','null','7','null');"
		+ "INSERT INTO `Bild` VALUES ('63','Hotelbewertung für HotelID Atlantikov','/assets/images/bewertungen/die-schimmlige-dusche.jpg','null','7','null');"
		+ "INSERT INTO `Bild` VALUES ('64','Hotelbewertung für HotelID Atlantikov','/assets/images/bewertungen/02-kuh-lustig-buffet.jpg','null','8','null');"
		+ "INSERT INTO `Bild` VALUES ('65','Hotelbewertung für HotelID Atlantikov','/assets/images/bewertungen/2011-08-18_Frankfurt_am_Main_Fahrradverleih_Nextbike_Hbf.JPG','null','8','null');"
		+ "INSERT INTO `Bild` VALUES ('66','Hotelbewertung für HotelID Atlantikov','/assets/images/bewertungen/3479_6_rechteck_pool.jpg','null','8','null');"
		+ "INSERT INTO `Bild` VALUES ('201','Lobby Adler','/assets/images/hotels/adler_lobby.jpg','4','null','null');"
		+ "INSERT INTO `Bild` VALUES ('202','Zimmer Adler','/assets/images/hotels/adler_zimmer.jpg','4','null','null');"
		+ "INSERT INTO `Bild` VALUES ('203','Badezimmer Adlon','/assets/images/hotels/adlon_badezimmer.jpg','2','null','null');"
		+ "INSERT INTO `Bild` VALUES ('204','Zimmer Adlon','/assets/images/hotels/adlon_zimmer.jpg','2','null','null');"
		+ "INSERT INTO `Bild` VALUES ('205','Lobby Atlantikov','/assets/images/hotels/atlantikov_lobby.jpg','5','null','null');"
		+ "INSERT INTO `Bild` VALUES ('206','Zimmer Atlantikov','/assets/images/hotels/atlantikov_zimmer.jpg','5','null','null');"
		+ "INSERT INTO `Bild` VALUES ('207','Badezimmer Kleopatra','/assets/images/hotels/kleopatra_badezimmer.jpg','6','null','null');"
		+ "INSERT INTO `Bild` VALUES ('208','Zimmer Kleopatra','/assets/images/hotels/kleopatra_zimmer.jpg','6','null','null');"
		+ "INSERT INTO `Bild` VALUES ('209','Wellness Konstanzia','/assets/images/hotels/konstanzia_welness.jpg','1','null','null');"
		+ "INSERT INTO `Bild` VALUES ('210','Zimmer Konstanzia','/assets/images/hotels/konstanzia_zimmer.jpg','1','null','null');"
		+ "INSERT INTO `Bild` VALUES ('211','Dachterasse Römerhaus','/assets/images/hotels/römerhaus_dachterasse.jpg','3','null','null');"
		+ "INSERT INTO `Bild` VALUES ('212','Zimmer Römerhaus','/assets/images/hotels/römerhaus_zimmer.jpg','3','null','null');");
	}
	rs.close();
	rs = meta.getTables(null, null, "Bewertung", null);
	if(!rs.next()){ 
	stmt.executeUpdate(
		"CREATE TABLE Bewertung ("
		+ "`ID`	INTEGER,"
		+ "`Beschreibung`	TEXT,"
		+ "`Kurzkommentar`	TEXT,"
		+ "`Art`	TEXT,"
		+ "`Kinder`	TEXT,"
		+ "`Verpflegung`	TEXT,"
		+ "`Von`	TEXT,"
		+ "`Bis`	TEXT,"
		+ "`Rating`	INTEGER,"
		+ "`Erfassungsdatum`	TEXT,"
		+ "`FK_Hotel`	INTEGER,"
		+ "PRIMARY KEY(ID));"
		+ "INSERT INTO `Bewertung` VALUES ('1','Ingesamt schöner Urlaub, war alles super und das essen ist auch lecker. Großes Angebot für Kinder','immer wieder gerne','Familienurlaub','Ja','All-Inclusive','01.01.2015','04.01.2015','5','05.01.2015','1');"
		+ "INSERT INTO `Bewertung` VALUES ('2','Das Hotel würden wir immer wieder aufs neue buchen. Jedoch ein Stern Abzug, da die Fußgängerzone in der Nacht nicht zu überhören ist.','freundliches personal, essen top','Familienurlaub','Ja','All-Inclusive','03.01.2015','08.01.2015','4','12.01.2015','1');"
		+ "INSERT INTO `Bewertung` VALUES ('3','Ich habe lediglich 2 Tage übernachtet und war nicht oft im Hotel. Das Zimmer war immer sauber und es gab ein großes Frühstücksbuffet','war nur ein kurzer Urlaub','Familienurlaub','Ja','All-Inclusive','06.01.2015','08.01.2015','4','12.01.2015','1');"
		+ "INSERT INTO `Bewertung` VALUES ('4','Man befindet sich mitten in der Stadt Konstanz und viele Geschäfte sind mit wenigen Gehminuten zu erreichen. Der Preis / Nacht ist völlig in Ordnung','gute Lage, Preis gerechtfertigt','Familien-Urlaub','Ja','All-Inclusive','05.01.2015','09.01.2015','5','12.01.2015','1');"
		+ "INSERT INTO `Bewertung` VALUES ('5','Zum übernachten reicht das Hotel völlig aus, aber für einen Familienurlaub ungeeignet','sehr altmodisches Hotel','Kultur-Urlaub','Ja','Halbpension','02.01.2015','06.01.2015','3','12.01.2015','3');"
		+ "INSERT INTO `Bewertung` VALUES ('6','Für den Preis sehr schlechtes Essen bekommen. Fliegen haben sich um das Buffet herum gesammelt.','essen war richtig mies','Single-Urlaub','Ja','Halbpension','06.01.2015','08.01.2015','2','12.01.2015','3');"
		+ "INSERT INTO `Bewertung` VALUES ('7','Dieses Hotel würden wir zum Party machen immer wieder buchen. Für Kinder überhaupt nicht geeignet. Das Hotel war besoffen','warn brutaler Absturz, Eskalation!','Party-Urlaub','Nein','Halbpension','09.01.2015','11.01.2015','4','12.01.2015','5');");
	}
	rs.close();
	rs = meta.getTables(null, null, "Adresse", null);
	if(!rs.next()){ 
	stmt.executeUpdate(
		"CREATE TABLE Adresse ("
		+ "`ID`	INTEGER PRIMARY KEY AUTOINCREMENT,"
		+ "`Ort`	TEXT,"
		+ "`PLZ`	INTEGER,"
		+ "`Strasse`	TEXT,"
		+ "`FK_Land`	INTEGER);"
		+ "INSERT INTO `Adresse` VALUES ('1','Konstanz','78462','Untere Laube 4','1');"
		+ "INSERT INTO `Adresse` VALUES ('2','Rom','11223','Römergasse 3','2');"
		+ "INSERT INTO `Adresse` VALUES ('3','Athen','23421','Griechenecke 9','3');"
		+ "INSERT INTO `Adresse` VALUES ('4','Kopenhagen','20320','Am Hafen 9 ','4');"
		+ "INSERT INTO `Adresse` VALUES ('5','Prag','20020','Prager Allee 5','5');"
		+ "INSERT INTO `Adresse` VALUES ('6','Berlin','12559','Berliner Tor 2','1');");
	}
	} catch (SQLException e) {
	// TODO Auto-generated catch block
		e.printStackTrace();
	} finally {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
			}
		}
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
			}
		}
		if (tokaConnection != null) {
			try {
				tokaConnection.close();
			} catch (SQLException e) {
			}
		}
	}
	}
}

