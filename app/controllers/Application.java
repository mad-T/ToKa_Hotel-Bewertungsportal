package controllers;

import play.*;
import play.mvc.*;
import views.html.*;
import play.data.Form;
import java.util.*;
import models.*;

public class Application extends Controller {
		
    public static Result index() {
		if (session("vorname") == null){
			return ok(index.render("Guest"));	
		} else {
			String username = session("vorname");
			return ok(index.render(username));
		}
    }

	 public static Result contact() {
			if (session("vorname") == null){
				return ok(contact.render("Guest"));	
			} else {
				String username = session("vorname");
				return ok(contact.render(username));
			}
	}
	
	public static Result goodbye() {
		if (session("vorname") == null){
			return ok(goodbye.render("Guest"));	
		} else {
			String username = session("vorname");
			session().clear();
			return ok(goodbye.render(username));
		}
	}
	
	public static Result agbs() {
		if (session("vorname") == null){
			return ok(agbs.render("Guest"));	
		} else {
			String username = session("vorname");
			return ok(agbs.render(username));
		}
	}
	
	public static Result impressum() {
		if (session("vorname") == null){
			return ok(impressum.render("Guest"));	
		} else {
			String username = session("vorname");
			return ok(impressum.render(username));
		}
	}
	
	public static Result information_1hotel() {
		if (session("vorname") == null){
			return ok(information_1hotel.render("Guest"));	
		} else {
			String username = session("vorname");
			return ok(information_1hotel.render(username));
		}
	}
	
	public static Result login() {
		if (session("vorname") == null){
			return ok(login.render("Guest"));	
		} else {
			String username = session("vorname");
			return ok(login.render(username));
		}
	}
	
	public static Result newsletter() {
		if (session("vorname") == null){
			return ok(newsletter.render("Guest"));	
		} else {
			String username = session("vorname");
			return ok(newsletter.render(username));
		}
	}
	
	public static Result profile() {
		if (session("vorname") == null){
			return ok(profile.render("Guest","Guest","Guest","Guest","Guest","Guest"));	
		} else {
			String vorname = session("vorname");
			String nachname = session("nachname");
			String email = session("email");
			String geschlecht = session("geschlecht");
			String familienstand = session("familienstand");
			String alter = session("alter");
			return ok(profile.render(vorname, nachname, email, geschlecht, familienstand, alter));
		}
	}
	
	public static Result rate_hotel() {
		if (session("vorname") == null){
			return ok(rate_hotel.render("Guest"));	
		} else {
			String username = session("vorname");
			return ok(rate_hotel.render(username));
		}
	}
		public static Result registration(){
		int emailParameter = 0;
		int agbParameter = 0;
			if (session("vorname") == null){
			return ok(registration.render("Guest", emailParameter, agbParameter));	
		} else {
			String username = session("vorname");
			return ok(registration.render(username, emailParameter, agbParameter));
		}
	}
	
	public static Result registration1(String email) {
		String username;
		if (session("vorname") == null){
			username="Guest";			
		} else {
			username = session("vorname");
		}
		ArrayList<User> user = Model.sharedInstance.getUser();
		boolean emailAdr = false;
		int emailParameter = 0;
		int agbParameter = 0;
				
		//if (agb.equals("akzeptiert")) {
			if (email != null) {
				for (int i = 0; i < user.size(); i++) {
					if (user.get(i).getEmail().equals(email)) {
						emailAdr = true;
					}
				}
				
				if (emailAdr == true) {
					//User auffordern sich mit einer anderen Emailadresse zu registrieren
					emailParameter = 1;
				}else {
					//User in Datenbank anlegen
					emailParameter = 2;
				}
				
			}else {
				//User auffordern eine email anzugeben
				emailParameter = 3;
			}
		/*}else {
			//User auffordern agb's zu akzeptieren
			agbParameter = 1;
		}*/
		
		
		return ok(registration.render(username, emailParameter, agbParameter));
	}
	
/*	public static Result registration() {
		if (session("vorname") == null){
			return ok(registration.render("Guest"));	
		} else {
			String username = session("vorname");
			return ok(registration.render(username));
		}
	}*/
	
/*	public static Result results_search_hotel() {
		if (session("vorname") == null){
			return ok(results_search_hotel.render("Guest"));	
		} else {
			String username = session("vorname");
			return ok(results_search_hotel.render(username));
		}
	}*/

	public static Result results_search_hotel_fromHeader(String hotel){
				String username;
		if (session("vorname") == null){
			username="Guest";			
		} else {
			username = session("vorname");
		}
		ArrayList<Hotel> ergebnis = Model.sharedInstance.getHotels(null, null, hotel, null);
		int anzahl = ergebnis.size();
		String test = hotel;
		
		return ok(results_search_hotel.render(username, anzahl, ergebnis, test));
	}
	
	public static Result results_search_hotel(String land, String stadt, String hotel) {
		String username;
		if (session("vorname") == null){
			username="Guest";			
		} else {
			username = session("vorname");
		}
		ArrayList<Hotel> ergebnis = Model.sharedInstance.getHotels(land, stadt, hotel, null);
		//int anzahl = ergebnis.size();
		
		/*String test;
		
		if (hotel!=null) {
			test = "leeere";
		}else {
			test = hotel;
		}*/

/*		Hotel test1 = new Hotel("12", "/assets/images/hotel_kn.jpg", "Konstanzia" ,"1111", "langer text aus kn", "llll", "llll", "bbbb", "ffff", "üüüü");
		Hotel test2 = new Hotel("14", "/assets/images/hotel_rom.jpg", "Römerhaus", "1111", "noch längerer text aus rom", "llll", "llll", "bbbb", "ffff", "üüüü");
		ArrayList<Hotel> ergebnis = new ArrayList<Hotel>();*/
/*		ergebnis.add(test1);
		ergebnis.add(test2);*/
		int anzahl = ergebnis.size();
		String test = "standard";
		
		return ok(results_search_hotel.render(username, anzahl, ergebnis, test));
	}
	
	public static Result results_search_hotel_enhanced(String land, String stadt, String hotel, String verpflegung){
		String username;
		if (session("vorname") == null){
			username="Guest";			
		} else {
			username = session("vorname");
		}
		ArrayList<Hotel> ergebnis = Model.sharedInstance.getHotels(land, stadt, hotel, verpflegung);
		int anzahl = ergebnis.size();
		String test = "enhanced " + verpflegung;
		
		return ok(results_search_hotel.render(username, anzahl, ergebnis, test));
	}
	
	public static Result search_hotel() {
		if (session("vorname") == null){
			return ok(search_hotel.render("Guest"));	
		} else {
			String username = session("vorname");
			return ok(search_hotel.render(username));
		}
	}
	
	public static Result welcome() {
		if (session("vorname") == null){
			return ok(welcome.render("Guest"));	
		} else {
			String username = session("vorname");
			return ok(welcome.render(username));
		}
	}
	
	/*
	 * login.scala.html
	 * Methode zur Überprüfung des Logins
	 * programmiert von: tobias ; datum: 23.11.14 */
	
//	public String test(String email, String password){
//			ArrayList<User> registrierteUser = Model.sharedInstance.getUser();
//			String checkEmail = email;
//			String checkPassword = password;
//			for (User user : registrierteUser) {
//				if (user.getEmail().equals(checkEmail)) {
//					if (user.getPasswort().equals(checkPassword)) {
////						session("username", "" + user.getVorname());
//						return "User + PW sind korrekt!";
//					}
//					return "User existiert, PW ist falsch!";
//				}
//			}
//			return "Account gibt es nicht!";
//	}
	
	public static Result checkLogin(String email, String password) {
		ArrayList<User> registrierteUser = Model.sharedInstance.getUser();
		String checkEmail = email;
		String checkPassword = password;
		for (User user : registrierteUser) {
			if (user.getEmail().equals(checkEmail)) {
				if (user.getPasswort().equals(checkPassword)) {
					session("vorname", "" + user.getVorname());
					session("nachname", "" + user.getNachname());
					session("email", "" + user.getEmail());
					session("geschlecht", "" + user.getGeschlecht());
					session("familienstand", "" + user.getFamilienstand());
					session("alter", "" + user.getAlter());
					return redirect("welcome.scala.html");
				}
				return redirect("login.scala.html");
			}
		}
		return badRequest("test");
	}
}
