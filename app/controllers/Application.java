	package controllers;

//import java.DynamicForm.*; */
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;	
import play.mvc.*;
import play.mvc.Http.MultipartFormData.FilePart;
import views.html.*;
import play.api.libs.Files;
import play.data.DynamicForm;
import play.data.Form;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.security.*;
import java.sql.SQLException;
import play.libs.F.Callback;
import play.libs.F.Callback0;
import play.libs.Json;
import models.*;

public class Application extends Controller {

	private static Application application = new Application();
	private static String[] userDataArray = new String[7];	
	private static String[] loginStatusCodeArray = new String[2];
	private static int emailParameter = 0;
	private static int validRate = -1;
	private static ArrayList<Bewertung> recentlyRatedHotels = null;
	private static ArrayList<Hotel> topHotelsOfYear = null;
	private static String loginStatusCode = "-2";
	static HashMap<Integer, HotelObserver> observer = new HashMap<>();
	
	public void aufräumen() {
		session().clear();
	}
	
    public static Result index() throws SQLException {
    	recentlyRatedHotels = Model.sharedInstance.getRecentlyRatedHotels();
		topHotelsOfYear = Model.sharedInstance.getTopHotelsOfYear();
		loginStatusCode = "2";
		if (session("connected") != null) {
			String sessionEmail = session("connected");
			userDataArray = Model.sharedInstance.getSessionData(sessionEmail);
			String vorname = userDataArray[1];
			return ok(index.render(vorname, recentlyRatedHotels, topHotelsOfYear, loginStatusCode));
		} else {
			return ok(index.render("Gast", recentlyRatedHotels, topHotelsOfYear, loginStatusCode));
			/*application.aufräumen();*/
		}
    }

    public static Result newHotel() throws SQLException {
		if (session("connected") != null) {
			String sessionEmail = session("connected");
			userDataArray = Model.sharedInstance.getSessionData(sessionEmail);
			String vorname = userDataArray[1];
			return ok(newHotel.render(vorname));
		} else {
			return ok(newHotel.render("Gast"));
			/*application.aufräumen();*/
		}
	}

	public static Result contact() throws SQLException {
		if (session("connected") != null) {
			String sessionEmail = session("connected");
			userDataArray = Model.sharedInstance.getSessionData(sessionEmail);
			String vorname = userDataArray[1];
			return ok(contact.render(vorname));
		} else {
			return ok(contact.render("Gast"));
			/*application.aufräumen();*/
		}
	}
	
	public static Result goodbye() throws SQLException {
		String vornameTemp = "";
		if (session("connected") != null) {
			String sessionEmail = session("connected");
			userDataArray = Model.sharedInstance.getSessionData(sessionEmail);
			vornameTemp = userDataArray[1];
			application.aufräumen();
		}
		return ok(goodbye.render(vornameTemp));
	}
	
	public static Result agbs() throws SQLException {
		if (session("connected") != null) {
			String sessionEmail = session("connected");
			userDataArray = Model.sharedInstance.getSessionData(sessionEmail);
			String vorname = userDataArray[1];
			return ok(agbs.render(vorname));
		} else {
			return ok(agbs.render("Gast"));
			/*application.aufräumen();*/
		}
	}
	
	public static Result impressum() throws SQLException {
		if (session("connected") != null) {
			String sessionEmail = session("connected");
			userDataArray = Model.sharedInstance.getSessionData(sessionEmail);
			String vorname = userDataArray[1];
			return ok(impressum.render(vorname));
		} else {
			return ok(impressum.render("Gast"));
			/*application.aufräumen();*/
		}
	}
	
	public static Result information_1hotel(String name) throws SQLException {
		
		Hotel hotel = Model.sharedInstance.getOneHotel(name);
		Bild titelbild = Model.sharedInstance.getOneHotelTitelbild(hotel.getId());
		ArrayList<Bild> bilder = Model.sharedInstance.getOneHotelBilder(hotel.getId());
		ArrayList<Bewertung> bewertungen = Model.sharedInstance.getOneHotelRate(hotel.getId(), false);
		
		ArrayList<String> rates = new ArrayList<String>();
		for (int i = 0; i < bewertungen.size(); i++) {
			rates.add(bewertungen.get(i).getId());
		}
		
		String[] rateIds = rates.toArray(new String[rates.size()]);
		
		ArrayList<Bild> bewertungsBilder = Model.sharedInstance.getPicturesOfRate(rateIds);
		//int anzahl = bewertungen.size();
		
		if (session("connected") != null) {
			String sessionEmail = session("connected");
			userDataArray = Model.sharedInstance.getSessionData(sessionEmail);
			String vorname = userDataArray[1];
			return ok(information_1hotel.render(vorname, hotel, titelbild, bilder, bewertungen, bewertungsBilder));
		} else {
			return ok(information_1hotel.render("Gast", hotel, titelbild, bilder, bewertungen, bewertungsBilder));
			/*application.aufräumen();*/
		}
	}
	
	public static Result profile() throws SQLException {
		if (session("connected") != null) {
			String sessionEmail = session("connected");
			userDataArray = Model.sharedInstance.getSessionData(sessionEmail);
			String email = userDataArray[0];
			String vorname = userDataArray[1];
			String nachname = userDataArray[2];
			String geburtstag = userDataArray[3];
			String geschlecht = userDataArray[4];
			String familienstand = userDataArray[5];
			String userPic = userDataArray[6];
			return ok(profile.render(vorname, nachname, email, geschlecht, familienstand, geburtstag, userPic));
		} else {
			return ok(profile.render("Gast", "Gast", "Gast", "Gast", "Gast", "Gast", "Gast"));
			/*application.aufräumen();*/
		}
	}
	
	public static Result rate_hotel() throws SQLException {
		
		ArrayList<Hotel> allHotels = Model.sharedInstance.getAllHotels();

		if (session("connected") != null) {
			String sessionEmail = session("connected");
			userDataArray = Model.sharedInstance.getSessionData(sessionEmail);
			String vorname = userDataArray[1];
			return ok(rate_hotel.render(vorname, allHotels, validRate));
		} else {
			return ok(rate_hotel.render("Gast", allHotels, validRate));
			/*application.aufräumen();*/
		}
	}
	
	public static Result rate_hotel_fromHotel(String name) throws SQLException {

		Hotel hotel = Model.sharedInstance.getOneHotel(name);
		ArrayList<Hotel> allHotels = new ArrayList<Hotel>();
		allHotels.add(hotel);

		if (session("connected") != null) {
			String sessionEmail = session("connected");
			userDataArray = Model.sharedInstance.getSessionData(sessionEmail);
			String vorname = userDataArray[1];
			return ok(rate_hotel.render(vorname, allHotels, validRate));
		} else {
			return ok(rate_hotel.render("Gast", allHotels, validRate));
			/*application.aufräumen();*/
		}	
	}
	
	public static Result allRates(String name, String id) throws SQLException {
				
		ArrayList<Bewertung> bewertungen = Model.sharedInstance.getOneHotelRate(id, true);
		ArrayList<String> rates = new ArrayList<String>();
		
		for (int i = 0; i < bewertungen.size(); i++) {
			rates.add(bewertungen.get(i).getId());
		}
		
		String[] rateIds = rates.toArray(new String[rates.size()]);
		
		ArrayList<Bild> bewertungsBilder = Model.sharedInstance.getPicturesOfRate(rateIds);
		int anzahl = bewertungen.size();

		if (session("connected") != null) {
			String sessionEmail = session("connected");
			userDataArray = Model.sharedInstance.getSessionData(sessionEmail);
			String vorname = userDataArray[1];
			return ok(allRates.render(vorname, bewertungen, anzahl, bewertungsBilder, name));
		} else {
			return ok(allRates.render("Gast", bewertungen, anzahl, bewertungsBilder, name));
			/*application.aufräumen();*/
		}
	}
	
	public static Result rate_hotel_submit() throws SQLException{
		DynamicForm requestData = Form.form().bindFromRequest();
        String hotel = requestData.get("hotel");
        String art = requestData.get("artUrlaub");
        String kinder = requestData.get("kinder");
        String verpflegung = requestData.get("verpflegung");
        String von = requestData.get("von");
        String bis = requestData.get("bis");
        String rating = requestData.get("rating");
        String kurzkommentar = requestData.get("kurzkommentar");
        String beschreibung = requestData.get("beschreibung");

        play.mvc.Http.MultipartFormData body = request().body().asMultipartFormData();
        
        int validRate = Model.sharedInstance.createHotelRate(hotel, art, kinder, verpflegung, von, bis, rating, kurzkommentar, beschreibung, body);
        
        ArrayList<Hotel> allHotels = Model.sharedInstance.getAllHotels();

		if (session("connected") != null) {
			String sessionEmail = session("connected");
			userDataArray = Model.sharedInstance.getSessionData(sessionEmail);
			String vorname = userDataArray[1];
			return ok(rate_hotel.render(vorname, allHotels, validRate));
		} else {
			return ok(rate_hotel.render("Gast", allHotels, validRate));
			/*application.aufräumen();*/
		}
	}
	
	public static Result registration() throws SQLException {
		loginStatusCode = "2";
		if (session("connected") != null) {
			String sessionEmail = session("connected");
			userDataArray = Model.sharedInstance.getSessionData(sessionEmail);
			String vorname = userDataArray[1];
			return ok(registration.render(vorname, emailParameter, loginStatusCode));
		} else {
			return ok(registration.render("Gast", emailParameter, loginStatusCode));
			/*application.aufräumen();*/
		}	
	}
	
	public static Result registration_submit() throws SQLException, NoSuchAlgorithmException, NoSuchProviderException {
		loginStatusCode = "2";
		DynamicForm requestData = Form.form().bindFromRequest();
        String email = requestData.get("email");
        String vorname = requestData.get("vorname");
        String nachname = requestData.get("nachname");
        String geburtstag = requestData.get("geburtstag");
        String geschlecht = requestData.get("geschlecht");
        String familienstand = requestData.get("familienstand");
        String strasse = requestData.get("strasse");
        String ort = requestData.get("ort");
        String plz = requestData.get("plz");
        String land = requestData.get("land");
        String passwort = requestData.get("passwort");
        String passwort_wdh = requestData.get("passwort_wdh");
        
        play.mvc.Http.MultipartFormData body = request().body().asMultipartFormData();

        int emailParameter = Model.sharedInstance.checkRegistration(email, vorname, nachname, geburtstag, geschlecht, familienstand, strasse, ort, plz, land, passwort, passwort_wdh, body);

		if (session("connected") != null) {
			String sessionEmail = session("connected");
			userDataArray = Model.sharedInstance.getSessionData(sessionEmail);
			String vorname2 = userDataArray[1];
			return ok(registration.render(vorname2, emailParameter, loginStatusCode));
		} else {
			return ok(registration.render("Gast", emailParameter, loginStatusCode));
			/*application.aufräumen();*/
		}
	}
	
	public static Result ajax_complete(String eingabe) throws SQLException { 
		return ok(Model.sharedInstance.autoComplete(eingabe));
	}

	public static Result results_hotel_headerSearch(String hotel) throws SQLException{

		ArrayList<Hotel> ergebnis = Model.sharedInstance.getHotels(null, null, hotel, null, "nein", "nein", "nein", "nein");
		int anzahl = ergebnis.size();	 
		
		Bild titelbild = null;
		ArrayList<Bild> bilder = new ArrayList<Bild>();
		
		for (int i = 0; i < ergebnis.size(); i++) {
			titelbild = Model.sharedInstance.getOneHotelTitelbild(ergebnis.get(i).getId());
			bilder.add(titelbild);
		}		

		if (session("connected") != null) {
			String sessionEmail = session("connected");
			userDataArray = Model.sharedInstance.getSessionData(sessionEmail);
			String vorname = userDataArray[1];
			return ok(results_search_hotel.render(vorname, anzahl, ergebnis, bilder));
		} else {
			return ok(results_search_hotel.render("Gast", anzahl, ergebnis, bilder));
			/*application.aufräumen();*/
		}		
	}
	
	public static Result results_search_hotel(String land, String stadt, String hotel) throws SQLException {
		
		ArrayList<Hotel> ergebnis = Model.sharedInstance.getHotels(land, stadt, hotel, null, "nein", "nein", "nein", "nein");
		int anzahl = ergebnis.size();
		
		Bild titelbild = null;
		ArrayList<Bild> bilder = new ArrayList<Bild>();
		
		for (int i = 0; i < ergebnis.size(); i++) {
			titelbild = Model.sharedInstance.getOneHotelTitelbild(ergebnis.get(i).getId());
			bilder.add(titelbild);
		}

		if (session("connected") != null) {
			String sessionEmail = session("connected");
			userDataArray = Model.sharedInstance.getSessionData(sessionEmail);
			String vorname = userDataArray[1];
			return ok(results_search_hotel.render(vorname, anzahl, ergebnis, bilder));
		} else {
			return ok(results_search_hotel.render("Gast", anzahl, ergebnis, bilder));
			/*application.aufräumen();*/
		}
	}
	
	public static Result results_hotel_enhancedSearch(String land, String stadt, String hotel, String verpflegung, String pool, String strand, String zentrum, String fahrrad) throws SQLException{
		
		ArrayList<Hotel> ergebnis = Model.sharedInstance.getHotels(land, stadt, hotel, verpflegung, pool, strand, zentrum, fahrrad);
		int anzahl = ergebnis.size();
		
		Bild titelbild = null;
		ArrayList<Bild> bilder = new ArrayList<Bild>();
		
		for (int i = 0; i < ergebnis.size(); i++) {
			titelbild = Model.sharedInstance.getOneHotelTitelbild(ergebnis.get(i).getId());
			bilder.add(titelbild);
		}

		if (session("connected") != null) {
			String sessionEmail = session("connected");
			userDataArray = Model.sharedInstance.getSessionData(sessionEmail);
			String vorname = userDataArray[1];
			return ok(results_search_hotel.render(vorname, anzahl, ergebnis, bilder));
		} else {
			return ok(results_search_hotel.render("Gast", anzahl, ergebnis, bilder));
			/* application.aufräumen();*/
		} 
	}
	
	public static Result hotel_enhancedSearch() throws SQLException {
		if (session("connected") != null) {
			String sessionEmail = session("connected");
			userDataArray = Model.sharedInstance.getSessionData(sessionEmail);
			String vorname = userDataArray[1];
			return ok(hotel_enhancedSearch.render(vorname));
		} else {
			return ok(hotel_enhancedSearch.render("Gast"));
			/*application.aufräumen();*/
		}
	}
	
	public static Result welcome() throws SQLException {
		if (session("connected") != null) {
			String sessionEmail = session("connected");
			userDataArray = Model.sharedInstance.getSessionData(sessionEmail);
			String vorname = userDataArray[1];
			String userPic = userDataArray[6];
			return ok(welcome.render(vorname));
		} else {
			return ok(welcome.render("Gast"));
			/*application.aufräumen();*/
		} 
	}
	
	public static Result checkLogin() throws SQLException, NoSuchAlgorithmException, NoSuchProviderException {
		String sessionEmail = null;

		DynamicForm requestData = Form.form().bindFromRequest();
		String checkEmail = requestData.get("email");
        String password = requestData.get("password");
		String checkPassword = Model.sharedInstance.getSecurePassword(password);
		loginStatusCodeArray = Model.sharedInstance.checkLogin(checkEmail, checkPassword);


		recentlyRatedHotels = Model.sharedInstance.getRecentlyRatedHotels();
		topHotelsOfYear = Model.sharedInstance.getTopHotelsOfYear();

		loginStatusCode = loginStatusCodeArray[0];

		switch(loginStatusCode) {
			case "-1": 
				return ok(registration.render("Gast", emailParameter, loginStatusCode));
			case "0":
				return ok(index.render("Gast", recentlyRatedHotels, topHotelsOfYear, loginStatusCode));
			case "1": 
				sessionEmail = loginStatusCodeArray[1];
				session("connected", "" + sessionEmail);				
				return redirect("welcome.scala.html");
			default: 
				return redirect("/");
		}
	}

	public static WebSocket<JsonNode> recentlyRate() throws SQLException {
		WebSocket<JsonNode> ws = null;
		try {
			ws = new WebSocket<JsonNode>() {
				public void onReady(WebSocket.In<JsonNode> in, final WebSocket.Out<JsonNode> out) {
					final HotelObserver obs = new HotelObserver();
					System.out.println("++++++++++ Observer angelegt" + obs);
					obs.hotel = out;
					final Integer id = new Integer(obs.hashCode());
					observer.put(id,obs);
					in.onMessage(new Callback<JsonNode>() {
						@Override
						public void invoke(JsonNode event) throws Throwable {
							// out.write(Model.sharedInstance.createJSON());
						}
					});
					in.onClose(new Callback0() {
						public void invoke() {
							observer.remove(id);
							System.out.println("++++++++ Observer wurde geschlossen");
							Model.sharedInstance.deleteObserver(obs);
							System.out.println("Disconnected!");
						}
					});
				}
			};
		} catch (Exception e) {
			System.err.println("Exception while creating WebSocket: "+ e.getMessage());
		}
		return ws;
	}
}