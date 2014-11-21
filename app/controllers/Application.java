package controllers;

import play.*;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {

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
