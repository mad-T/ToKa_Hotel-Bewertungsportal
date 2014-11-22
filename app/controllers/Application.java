package controllers;

import models.Adresse;
import models.Bewertung;
import models.Bild;
import models.EnthaeltMerkliste;
import models.EnthaeltZusatzHotel;
import models.Hotel;
import models.Land;
import models.User;
import models.Zusatz;
import play.*;
import play.mvc.*;
import views.html.*;

public class Application extends Controller {
		
	Land land1 = new Land("DE", "Deutschland");
	Land land2 = new Land("IT", "Italien");
	
	Adresse adr1 = new Adresse("01", "Konstanz", "DE", "78555");
	Adresse adr2 = new Adresse("02", "Rom", "IT", "6545");
	
	User user1 = new User("user1@web.de", "Paul", "Müller", "20", "maennlich", "ledig", "Haupststrasse 1", "passwort01", "passwort01", "1");
	User user2 = new User("user2@web.de", "Franz", "Wagner", "65", "maennlich", "ledig", "Haupststrasse 5", "passwort02", "passwort02", "1");
	
	Hotel hotel1 = new Hotel("50", "01", "Laaange Beschreibung Hotel in Konstanz", "Schoenes Hotel", "5", "AI", "F", "J");
	Hotel hotel2 = new Hotel("51", "01", "Laaange Beschreibung Hotel in Rom", "Modernes Hotel", "3", "HP", "S", "J");
	
	Bewertung bewertung1 = new Bewertung("90", "Alles Top", "F", "J", "HP", "18/03/2013", "25/03/2013", "4", "22/11/2013", "01");
	Bewertung bewertung2 = new Bewertung("91", "Altes Hotel", "S", "J", "AI", "10/08/2014", "28/08/2014", "3", "29/08/2014", "02");
	
	Bild bild1 = new Bild("80", "Hotel von aussen", "C://", "50", "NULL");
	Bild bild2 = new Bild("81", "Hotelzimmer", "C://", "NULL", "90");
	
	Zusatz zusatz1 = new Zusatz("Pool", "Pool im Aussenbereich");
	Zusatz zusatz2 = new Zusatz("Fahrrad", "Fahrrad Verleih an der Hotelrezeption");
	
	EnthaeltZusatzHotel ezh1 = new EnthaeltZusatzHotel("50", "Pool");
	EnthaeltZusatzHotel ezh2 = new EnthaeltZusatzHotel("50", "Fahrrad");
	EnthaeltZusatzHotel ezh3 = new EnthaeltZusatzHotel("51", "Pool");

    public static Result index() {
         return ok(index.render());
    }

	 public static Result contact() {
		return ok(contact.render());
	}
	
	public static Result goodbye() {
		return ok(goodbye.render());
	}
	
	public static Result agbs() {
		return ok(agbs.render());
	}
	
	public static Result impressum() {
		return ok(impressum.render());
	}
	
	public static Result information_1hotel() {
		return ok(information_1hotel.render());
	}
	
	public static Result login() {
		return ok(login.render());
	}
	
	public static Result newsletter() {
		return ok(newsletter.render());
	}
	
	public static Result profile() {
		return ok(profile.render());
	}
	
	public static Result rate_hotel() {
		return ok(rate_hotel.render());
	}
	
	public static Result registration() {
		return ok(registration.render());
	}
	
	public static Result results_search_hotel() {
		return ok(results_search_hotel.render());
	}
	
	public static Result search_hotel() {
		return ok(search_hotel.render());
	}
	
	public static Result welcome() {
		return ok(welcome.render());
	}
	
}
