// @SOURCE:D:/01 HTWG/04 Semester/02 Projekte/ToKa_Hotel-Bewertungsportal/Toka_Hotel-Bewertungsportal_Final_pstmt_design/conf/routes
// @HASH:c2b2851c60e8c6a5c2e7e745478495a1312d980a
// @DATE:Mon Jan 12 13:53:11 CET 2015


import play.core._
import play.core.Router._
import play.core.Router.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._
import _root_.controllers.Assets.Asset
import _root_.play.libs.F

import Router.queryString

object Routes extends Router.Routes {

import ReverseRouteContext.empty

private var _prefix = "/"

def setPrefix(prefix: String) {
  _prefix = prefix
  List[(String,Routes)]().foreach {
    case (p, router) => router.setPrefix(prefix + (if(prefix.endsWith("/")) "" else "/") + p)
  }
}

def prefix = _prefix

lazy val defaultPrefix = { if(Routes.prefix.endsWith("/")) "" else "/" }


// @LINE:6
private[this] lazy val controllers_Application_index0_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix))))
private[this] lazy val controllers_Application_index0_invoker = createInvoker(
controllers.Application.index(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "index", Nil,"GET", """ Home page""", Routes.prefix + """"""))
        

// @LINE:7
private[this] lazy val controllers_Application_index1_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("index.scala.html"))))
private[this] lazy val controllers_Application_index1_invoker = createInvoker(
controllers.Application.index(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "index", Nil,"GET", """""", Routes.prefix + """index.scala.html"""))
        

// @LINE:8
private[this] lazy val controllers_Application_contact2_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("contact.scala.html"))))
private[this] lazy val controllers_Application_contact2_invoker = createInvoker(
controllers.Application.contact(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "contact", Nil,"GET", """""", Routes.prefix + """contact.scala.html"""))
        

// @LINE:9
private[this] lazy val controllers_Application_goodbye3_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("goodbye.scala.html"))))
private[this] lazy val controllers_Application_goodbye3_invoker = createInvoker(
controllers.Application.goodbye(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "goodbye", Nil,"GET", """""", Routes.prefix + """goodbye.scala.html"""))
        

// @LINE:10
private[this] lazy val controllers_Application_agbs4_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("agbs.scala.html"))))
private[this] lazy val controllers_Application_agbs4_invoker = createInvoker(
controllers.Application.agbs(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "agbs", Nil,"GET", """""", Routes.prefix + """agbs.scala.html"""))
        

// @LINE:11
private[this] lazy val controllers_Application_impressum5_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("impressum.scala.html"))))
private[this] lazy val controllers_Application_impressum5_invoker = createInvoker(
controllers.Application.impressum(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "impressum", Nil,"GET", """""", Routes.prefix + """impressum.scala.html"""))
        

// @LINE:12
private[this] lazy val controllers_Application_information_1hotel6_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("information_1hotel.scala.html"))))
private[this] lazy val controllers_Application_information_1hotel6_invoker = createInvoker(
controllers.Application.information_1hotel(fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "information_1hotel", Seq(classOf[String]),"GET", """""", Routes.prefix + """information_1hotel.scala.html"""))
        

// @LINE:13
private[this] lazy val controllers_Application_profile7_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("profile.scala.html"))))
private[this] lazy val controllers_Application_profile7_invoker = createInvoker(
controllers.Application.profile(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "profile", Nil,"GET", """""", Routes.prefix + """profile.scala.html"""))
        

// @LINE:14
private[this] lazy val controllers_Application_rate_hotel8_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rate_hotel.scala.html"))))
private[this] lazy val controllers_Application_rate_hotel8_invoker = createInvoker(
controllers.Application.rate_hotel(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "rate_hotel", Nil,"GET", """""", Routes.prefix + """rate_hotel.scala.html"""))
        

// @LINE:15
private[this] lazy val controllers_Application_rate_hotel_fromHotel9_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rate_hotel_fromHotel"))))
private[this] lazy val controllers_Application_rate_hotel_fromHotel9_invoker = createInvoker(
controllers.Application.rate_hotel_fromHotel(fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "rate_hotel_fromHotel", Seq(classOf[String]),"GET", """""", Routes.prefix + """rate_hotel_fromHotel"""))
        

// @LINE:16
private[this] lazy val controllers_Application_rate_hotel10_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rate_hotel"))))
private[this] lazy val controllers_Application_rate_hotel10_invoker = createInvoker(
controllers.Application.rate_hotel(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "rate_hotel", Nil,"GET", """""", Routes.prefix + """rate_hotel"""))
        

// @LINE:17
private[this] lazy val controllers_Application_registration11_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("registration.scala.html"))))
private[this] lazy val controllers_Application_registration11_invoker = createInvoker(
controllers.Application.registration(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "registration", Nil,"GET", """""", Routes.prefix + """registration.scala.html"""))
        

// @LINE:18
private[this] lazy val controllers_Application_results_search_hotel12_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("results_search_hotel.scala.html"))))
private[this] lazy val controllers_Application_results_search_hotel12_invoker = createInvoker(
controllers.Application.results_search_hotel(fakeValue[String], fakeValue[String], fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "results_search_hotel", Seq(classOf[String], classOf[String], classOf[String]),"GET", """""", Routes.prefix + """results_search_hotel.scala.html"""))
        

// @LINE:19
private[this] lazy val controllers_Application_hotel_enhancedSearch13_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("hotel_enhancedSearch.scala.html"))))
private[this] lazy val controllers_Application_hotel_enhancedSearch13_invoker = createInvoker(
controllers.Application.hotel_enhancedSearch(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "hotel_enhancedSearch", Nil,"GET", """""", Routes.prefix + """hotel_enhancedSearch.scala.html"""))
        

// @LINE:20
private[this] lazy val controllers_Application_welcome14_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("welcome.scala.html"))))
private[this] lazy val controllers_Application_welcome14_invoker = createInvoker(
controllers.Application.welcome(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "welcome", Nil,"GET", """""", Routes.prefix + """welcome.scala.html"""))
        

// @LINE:21
private[this] lazy val controllers_Application_newHotel15_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("newHotel.scala.html"))))
private[this] lazy val controllers_Application_newHotel15_invoker = createInvoker(
controllers.Application.newHotel(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "newHotel", Nil,"GET", """""", Routes.prefix + """newHotel.scala.html"""))
        

// @LINE:22
private[this] lazy val controllers_Application_allRates16_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("allRates.scala.html"))))
private[this] lazy val controllers_Application_allRates16_invoker = createInvoker(
controllers.Application.allRates(fakeValue[String], fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "allRates", Seq(classOf[String], classOf[String]),"GET", """""", Routes.prefix + """allRates.scala.html"""))
        

// @LINE:27
private[this] lazy val controllers_Application_checkLogin17_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("checkLogin"))))
private[this] lazy val controllers_Application_checkLogin17_invoker = createInvoker(
controllers.Application.checkLogin,
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "checkLogin", Nil,"POST", """ Login überprüfen""", Routes.prefix + """checkLogin"""))
        

// @LINE:28
private[this] lazy val controllers_Application_registration18_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("checkLogin"))))
private[this] lazy val controllers_Application_registration18_invoker = createInvoker(
controllers.Application.registration(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "registration", Nil,"GET", """""", Routes.prefix + """checkLogin"""))
        

// @LINE:31
private[this] lazy val controllers_Application_goodbye19_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("logout"))))
private[this] lazy val controllers_Application_goodbye19_invoker = createInvoker(
controllers.Application.goodbye(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "goodbye", Nil,"GET", """ Logout""", Routes.prefix + """logout"""))
        

// @LINE:34
private[this] lazy val controllers_Application_results_hotel_headerSearch20_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("results_hotel_headerSearch"))))
private[this] lazy val controllers_Application_results_hotel_headerSearch20_invoker = createInvoker(
controllers.Application.results_hotel_headerSearch(fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "results_hotel_headerSearch", Seq(classOf[String]),"GET", """ Hotelsuche aus dem Header""", Routes.prefix + """results_hotel_headerSearch"""))
        

// @LINE:37
private[this] lazy val controllers_Application_results_hotel_enhancedSearch21_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("results_hotel_enhancedSearch"))))
private[this] lazy val controllers_Application_results_hotel_enhancedSearch21_invoker = createInvoker(
controllers.Application.results_hotel_enhancedSearch(fakeValue[String], fakeValue[String], fakeValue[String], fakeValue[String], fakeValue[String], fakeValue[String], fakeValue[String], fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "results_hotel_enhancedSearch", Seq(classOf[String], classOf[String], classOf[String], classOf[String], classOf[String], classOf[String], classOf[String], classOf[String]),"GET", """ Hotelsuche aus dem Body (erweiterte Suche)""", Routes.prefix + """results_hotel_enhancedSearch"""))
        

// @LINE:40
private[this] lazy val controllers_Application_registration_submit22_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("registration_submit"))))
private[this] lazy val controllers_Application_registration_submit22_invoker = createInvoker(
controllers.Application.registration_submit,
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "registration_submit", Nil,"POST", """ Registrierung beim submitten""", Routes.prefix + """registration_submit"""))
        

// @LINE:43
private[this] lazy val controllers_Application_rate_hotel_submit23_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("rate_hotel"))))
private[this] lazy val controllers_Application_rate_hotel_submit23_invoker = createInvoker(
controllers.Application.rate_hotel_submit,
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "rate_hotel_submit", Nil,"POST", """ Rate Hotel""", Routes.prefix + """rate_hotel"""))
        

// @LINE:46
private[this] lazy val controllers_Application_ajax_complete24_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("ajax_complete"))))
private[this] lazy val controllers_Application_ajax_complete24_invoker = createInvoker(
controllers.Application.ajax_complete(fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "ajax_complete", Seq(classOf[String]),"GET", """ Ajax für Hotel-Suchvorschläge""", Routes.prefix + """ajax_complete"""))
        

// @LINE:49
private[this] lazy val controllers_Application_recentlyRate25_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("recentlyRate"))))
private[this] lazy val controllers_Application_recentlyRate25_invoker = createInvoker(
controllers.Application.recentlyRate(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "recentlyRate", Nil,"GET", """ Websocket: RecentlyRate""", Routes.prefix + """recentlyRate"""))
        

// @LINE:52
private[this] lazy val controllers_Assets_at26_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("assets/"),DynamicPart("file", """.+""",false))))
private[this] lazy val controllers_Assets_at26_invoker = createInvoker(
controllers.Assets.at(fakeValue[String], fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Assets", "at", Seq(classOf[String], classOf[String]),"GET", """ Map static resources from the /public folder to the /assets URL path""", Routes.prefix + """assets/$file<.+>"""))
        
def documentation = List(("""GET""", prefix,"""controllers.Application.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """index.scala.html""","""controllers.Application.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """contact.scala.html""","""controllers.Application.contact()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """goodbye.scala.html""","""controllers.Application.goodbye()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """agbs.scala.html""","""controllers.Application.agbs()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """impressum.scala.html""","""controllers.Application.impressum()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """information_1hotel.scala.html""","""controllers.Application.information_1hotel(name:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """profile.scala.html""","""controllers.Application.profile()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rate_hotel.scala.html""","""controllers.Application.rate_hotel()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rate_hotel_fromHotel""","""controllers.Application.rate_hotel_fromHotel(name:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rate_hotel""","""controllers.Application.rate_hotel()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """registration.scala.html""","""controllers.Application.registration()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """results_search_hotel.scala.html""","""controllers.Application.results_search_hotel(land:String, stadt:String, hotel:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """hotel_enhancedSearch.scala.html""","""controllers.Application.hotel_enhancedSearch()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """welcome.scala.html""","""controllers.Application.welcome()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """newHotel.scala.html""","""controllers.Application.newHotel()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """allRates.scala.html""","""controllers.Application.allRates(hotel:String, id:String)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """checkLogin""","""controllers.Application.checkLogin"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """checkLogin""","""controllers.Application.registration()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """logout""","""controllers.Application.goodbye()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """results_hotel_headerSearch""","""controllers.Application.results_hotel_headerSearch(hotel:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """results_hotel_enhancedSearch""","""controllers.Application.results_hotel_enhancedSearch(land:String, stadt:String, hotel:String, verpflegung:String, pool:String, strand:String, zentrum:String, fahrrad:String)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """registration_submit""","""controllers.Application.registration_submit"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """rate_hotel""","""controllers.Application.rate_hotel_submit"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """ajax_complete""","""controllers.Application.ajax_complete(hotel:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """recentlyRate""","""controllers.Application.recentlyRate()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
  case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
  case l => s ++ l.asInstanceOf[List[(String,String,String)]]
}}
      

def routes:PartialFunction[RequestHeader,Handler] = {

// @LINE:6
case controllers_Application_index0_route(params) => {
   call { 
        controllers_Application_index0_invoker.call(controllers.Application.index())
   }
}
        

// @LINE:7
case controllers_Application_index1_route(params) => {
   call { 
        controllers_Application_index1_invoker.call(controllers.Application.index())
   }
}
        

// @LINE:8
case controllers_Application_contact2_route(params) => {
   call { 
        controllers_Application_contact2_invoker.call(controllers.Application.contact())
   }
}
        

// @LINE:9
case controllers_Application_goodbye3_route(params) => {
   call { 
        controllers_Application_goodbye3_invoker.call(controllers.Application.goodbye())
   }
}
        

// @LINE:10
case controllers_Application_agbs4_route(params) => {
   call { 
        controllers_Application_agbs4_invoker.call(controllers.Application.agbs())
   }
}
        

// @LINE:11
case controllers_Application_impressum5_route(params) => {
   call { 
        controllers_Application_impressum5_invoker.call(controllers.Application.impressum())
   }
}
        

// @LINE:12
case controllers_Application_information_1hotel6_route(params) => {
   call(params.fromQuery[String]("name", None)) { (name) =>
        controllers_Application_information_1hotel6_invoker.call(controllers.Application.information_1hotel(name))
   }
}
        

// @LINE:13
case controllers_Application_profile7_route(params) => {
   call { 
        controllers_Application_profile7_invoker.call(controllers.Application.profile())
   }
}
        

// @LINE:14
case controllers_Application_rate_hotel8_route(params) => {
   call { 
        controllers_Application_rate_hotel8_invoker.call(controllers.Application.rate_hotel())
   }
}
        

// @LINE:15
case controllers_Application_rate_hotel_fromHotel9_route(params) => {
   call(params.fromQuery[String]("name", None)) { (name) =>
        controllers_Application_rate_hotel_fromHotel9_invoker.call(controllers.Application.rate_hotel_fromHotel(name))
   }
}
        

// @LINE:16
case controllers_Application_rate_hotel10_route(params) => {
   call { 
        controllers_Application_rate_hotel10_invoker.call(controllers.Application.rate_hotel())
   }
}
        

// @LINE:17
case controllers_Application_registration11_route(params) => {
   call { 
        controllers_Application_registration11_invoker.call(controllers.Application.registration())
   }
}
        

// @LINE:18
case controllers_Application_results_search_hotel12_route(params) => {
   call(params.fromQuery[String]("land", None), params.fromQuery[String]("stadt", None), params.fromQuery[String]("hotel", None)) { (land, stadt, hotel) =>
        controllers_Application_results_search_hotel12_invoker.call(controllers.Application.results_search_hotel(land, stadt, hotel))
   }
}
        

// @LINE:19
case controllers_Application_hotel_enhancedSearch13_route(params) => {
   call { 
        controllers_Application_hotel_enhancedSearch13_invoker.call(controllers.Application.hotel_enhancedSearch())
   }
}
        

// @LINE:20
case controllers_Application_welcome14_route(params) => {
   call { 
        controllers_Application_welcome14_invoker.call(controllers.Application.welcome())
   }
}
        

// @LINE:21
case controllers_Application_newHotel15_route(params) => {
   call { 
        controllers_Application_newHotel15_invoker.call(controllers.Application.newHotel())
   }
}
        

// @LINE:22
case controllers_Application_allRates16_route(params) => {
   call(params.fromQuery[String]("hotel", None), params.fromQuery[String]("id", None)) { (hotel, id) =>
        controllers_Application_allRates16_invoker.call(controllers.Application.allRates(hotel, id))
   }
}
        

// @LINE:27
case controllers_Application_checkLogin17_route(params) => {
   call { 
        controllers_Application_checkLogin17_invoker.call(controllers.Application.checkLogin)
   }
}
        

// @LINE:28
case controllers_Application_registration18_route(params) => {
   call { 
        controllers_Application_registration18_invoker.call(controllers.Application.registration())
   }
}
        

// @LINE:31
case controllers_Application_goodbye19_route(params) => {
   call { 
        controllers_Application_goodbye19_invoker.call(controllers.Application.goodbye())
   }
}
        

// @LINE:34
case controllers_Application_results_hotel_headerSearch20_route(params) => {
   call(params.fromQuery[String]("hotel", None)) { (hotel) =>
        controllers_Application_results_hotel_headerSearch20_invoker.call(controllers.Application.results_hotel_headerSearch(hotel))
   }
}
        

// @LINE:37
case controllers_Application_results_hotel_enhancedSearch21_route(params) => {
   call(params.fromQuery[String]("land", None), params.fromQuery[String]("stadt", None), params.fromQuery[String]("hotel", None), params.fromQuery[String]("verpflegung", None), params.fromQuery[String]("pool", None), params.fromQuery[String]("strand", None), params.fromQuery[String]("zentrum", None), params.fromQuery[String]("fahrrad", None)) { (land, stadt, hotel, verpflegung, pool, strand, zentrum, fahrrad) =>
        controllers_Application_results_hotel_enhancedSearch21_invoker.call(controllers.Application.results_hotel_enhancedSearch(land, stadt, hotel, verpflegung, pool, strand, zentrum, fahrrad))
   }
}
        

// @LINE:40
case controllers_Application_registration_submit22_route(params) => {
   call { 
        controllers_Application_registration_submit22_invoker.call(controllers.Application.registration_submit)
   }
}
        

// @LINE:43
case controllers_Application_rate_hotel_submit23_route(params) => {
   call { 
        controllers_Application_rate_hotel_submit23_invoker.call(controllers.Application.rate_hotel_submit)
   }
}
        

// @LINE:46
case controllers_Application_ajax_complete24_route(params) => {
   call(params.fromQuery[String]("hotel", None)) { (hotel) =>
        controllers_Application_ajax_complete24_invoker.call(controllers.Application.ajax_complete(hotel))
   }
}
        

// @LINE:49
case controllers_Application_recentlyRate25_route(params) => {
   call { 
        controllers_Application_recentlyRate25_invoker.call(controllers.Application.recentlyRate())
   }
}
        

// @LINE:52
case controllers_Assets_at26_route(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        controllers_Assets_at26_invoker.call(controllers.Assets.at(path, file))
   }
}
        
}

}
     