// @SOURCE:D:/01 HTWG/04 Semester/02 Projekte/ToKa_Hotel-Bewertungsportal/Toka_Hotel-Bewertungsportal_Final_pstmt_design/conf/routes
// @HASH:c2b2851c60e8c6a5c2e7e745478495a1312d980a
// @DATE:Mon Jan 12 13:53:11 CET 2015

import Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.Router.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._
import _root_.controllers.Assets.Asset
import _root_.play.libs.F

import Router.queryString


// @LINE:52
// @LINE:49
// @LINE:46
// @LINE:43
// @LINE:40
// @LINE:37
// @LINE:34
// @LINE:31
// @LINE:28
// @LINE:27
// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
package controllers {

// @LINE:52
class ReverseAssets {


// @LINE:52
def at(file:String): Call = {
   implicit val _rrc = new ReverseRouteContext(Map(("path", "/public")))
   Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[PathBindable[String]].unbind("file", file))
}
                        

}
                          

// @LINE:49
// @LINE:46
// @LINE:43
// @LINE:40
// @LINE:37
// @LINE:34
// @LINE:31
// @LINE:28
// @LINE:27
// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
class ReverseApplication {


// @LINE:15
def rate_hotel_fromHotel(name:String): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "rate_hotel_fromHotel" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("name", name)))))
}
                        

// @LINE:34
def results_hotel_headerSearch(hotel:String): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "results_hotel_headerSearch" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("hotel", hotel)))))
}
                        

// @LINE:40
def registration_submit(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "registration_submit")
}
                        

// @LINE:19
def hotel_enhancedSearch(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "hotel_enhancedSearch.scala.html")
}
                        

// @LINE:12
def information_1hotel(name:String): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "information_1hotel.scala.html" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("name", name)))))
}
                        

// @LINE:21
def newHotel(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "newHotel.scala.html")
}
                        

// @LINE:13
def profile(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "profile.scala.html")
}
                        

// @LINE:27
def checkLogin(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "checkLogin")
}
                        

// @LINE:18
def results_search_hotel(land:String, stadt:String, hotel:String): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "results_search_hotel.scala.html" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("land", land)), Some(implicitly[QueryStringBindable[String]].unbind("stadt", stadt)), Some(implicitly[QueryStringBindable[String]].unbind("hotel", hotel)))))
}
                        

// @LINE:43
def rate_hotel_submit(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "rate_hotel")
}
                        

// @LINE:11
def impressum(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "impressum.scala.html")
}
                        

// @LINE:28
// @LINE:17
def registration(): Call = {
   () match {
// @LINE:17
case ()  =>
  import ReverseRouteContext.empty
  Call("GET", _prefix + { _defaultPrefix } + "registration.scala.html")
                                         
   }
}
                                                

// @LINE:22
def allRates(hotel:String, id:String): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "allRates.scala.html" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("hotel", hotel)), Some(implicitly[QueryStringBindable[String]].unbind("id", id)))))
}
                        

// @LINE:20
def welcome(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "welcome.scala.html")
}
                        

// @LINE:46
def ajax_complete(hotel:String): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "ajax_complete" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("hotel", hotel)))))
}
                        

// @LINE:16
// @LINE:14
def rate_hotel(): Call = {
   () match {
// @LINE:14
case ()  =>
  import ReverseRouteContext.empty
  Call("GET", _prefix + { _defaultPrefix } + "rate_hotel.scala.html")
                                         
   }
}
                                                

// @LINE:49
def recentlyRate(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "recentlyRate")
}
                        

// @LINE:31
// @LINE:9
def goodbye(): Call = {
   () match {
// @LINE:9
case ()  =>
  import ReverseRouteContext.empty
  Call("GET", _prefix + { _defaultPrefix } + "goodbye.scala.html")
                                         
   }
}
                                                

// @LINE:7
// @LINE:6
def index(): Call = {
   () match {
// @LINE:6
case ()  =>
  import ReverseRouteContext.empty
  Call("GET", _prefix)
                                         
   }
}
                                                

// @LINE:8
def contact(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "contact.scala.html")
}
                        

// @LINE:10
def agbs(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "agbs.scala.html")
}
                        

// @LINE:37
def results_hotel_enhancedSearch(land:String, stadt:String, hotel:String, verpflegung:String, pool:String, strand:String, zentrum:String, fahrrad:String): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "results_hotel_enhancedSearch" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("land", land)), Some(implicitly[QueryStringBindable[String]].unbind("stadt", stadt)), Some(implicitly[QueryStringBindable[String]].unbind("hotel", hotel)), Some(implicitly[QueryStringBindable[String]].unbind("verpflegung", verpflegung)), Some(implicitly[QueryStringBindable[String]].unbind("pool", pool)), Some(implicitly[QueryStringBindable[String]].unbind("strand", strand)), Some(implicitly[QueryStringBindable[String]].unbind("zentrum", zentrum)), Some(implicitly[QueryStringBindable[String]].unbind("fahrrad", fahrrad)))))
}
                        

}
                          
}
                  


// @LINE:52
// @LINE:49
// @LINE:46
// @LINE:43
// @LINE:40
// @LINE:37
// @LINE:34
// @LINE:31
// @LINE:28
// @LINE:27
// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
package controllers.javascript {
import ReverseRouteContext.empty

// @LINE:52
class ReverseAssets {


// @LINE:52
def at : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Assets.at",
   """
      function(file) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
   """
)
                        

}
              

// @LINE:49
// @LINE:46
// @LINE:43
// @LINE:40
// @LINE:37
// @LINE:34
// @LINE:31
// @LINE:28
// @LINE:27
// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
class ReverseApplication {


// @LINE:15
def rate_hotel_fromHotel : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.rate_hotel_fromHotel",
   """
      function(name) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "rate_hotel_fromHotel" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("name", name)])})
      }
   """
)
                        

// @LINE:34
def results_hotel_headerSearch : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.results_hotel_headerSearch",
   """
      function(hotel) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "results_hotel_headerSearch" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("hotel", hotel)])})
      }
   """
)
                        

// @LINE:40
def registration_submit : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.registration_submit",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "registration_submit"})
      }
   """
)
                        

// @LINE:19
def hotel_enhancedSearch : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.hotel_enhancedSearch",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "hotel_enhancedSearch.scala.html"})
      }
   """
)
                        

// @LINE:12
def information_1hotel : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.information_1hotel",
   """
      function(name) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "information_1hotel.scala.html" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("name", name)])})
      }
   """
)
                        

// @LINE:21
def newHotel : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.newHotel",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "newHotel.scala.html"})
      }
   """
)
                        

// @LINE:13
def profile : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.profile",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "profile.scala.html"})
      }
   """
)
                        

// @LINE:27
def checkLogin : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.checkLogin",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "checkLogin"})
      }
   """
)
                        

// @LINE:18
def results_search_hotel : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.results_search_hotel",
   """
      function(land,stadt,hotel) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "results_search_hotel.scala.html" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("land", land), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("stadt", stadt), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("hotel", hotel)])})
      }
   """
)
                        

// @LINE:43
def rate_hotel_submit : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.rate_hotel_submit",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "rate_hotel"})
      }
   """
)
                        

// @LINE:11
def impressum : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.impressum",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "impressum.scala.html"})
      }
   """
)
                        

// @LINE:28
// @LINE:17
def registration : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.registration",
   """
      function() {
      if (true) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "registration.scala.html"})
      }
      if (true) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "checkLogin"})
      }
      }
   """
)
                        

// @LINE:22
def allRates : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.allRates",
   """
      function(hotel,id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "allRates.scala.html" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("hotel", hotel), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:20
def welcome : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.welcome",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "welcome.scala.html"})
      }
   """
)
                        

// @LINE:46
def ajax_complete : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.ajax_complete",
   """
      function(hotel) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "ajax_complete" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("hotel", hotel)])})
      }
   """
)
                        

// @LINE:16
// @LINE:14
def rate_hotel : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.rate_hotel",
   """
      function() {
      if (true) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "rate_hotel.scala.html"})
      }
      if (true) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "rate_hotel"})
      }
      }
   """
)
                        

// @LINE:49
def recentlyRate : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.recentlyRate",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "recentlyRate"})
      }
   """
)
                        

// @LINE:31
// @LINE:9
def goodbye : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.goodbye",
   """
      function() {
      if (true) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "goodbye.scala.html"})
      }
      if (true) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "logout"})
      }
      }
   """
)
                        

// @LINE:7
// @LINE:6
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.index",
   """
      function() {
      if (true) {
      return _wA({method:"GET", url:"""" + _prefix + """"})
      }
      if (true) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "index.scala.html"})
      }
      }
   """
)
                        

// @LINE:8
def contact : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.contact",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "contact.scala.html"})
      }
   """
)
                        

// @LINE:10
def agbs : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.agbs",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "agbs.scala.html"})
      }
   """
)
                        

// @LINE:37
def results_hotel_enhancedSearch : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.results_hotel_enhancedSearch",
   """
      function(land,stadt,hotel,verpflegung,pool,strand,zentrum,fahrrad) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "results_hotel_enhancedSearch" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("land", land), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("stadt", stadt), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("hotel", hotel), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("verpflegung", verpflegung), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("pool", pool), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("strand", strand), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("zentrum", zentrum), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("fahrrad", fahrrad)])})
      }
   """
)
                        

}
              
}
        


// @LINE:52
// @LINE:49
// @LINE:46
// @LINE:43
// @LINE:40
// @LINE:37
// @LINE:34
// @LINE:31
// @LINE:28
// @LINE:27
// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
package controllers.ref {


// @LINE:52
class ReverseAssets {


// @LINE:52
def at(path:String, file:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Assets.at(path, file), HandlerDef(this.getClass.getClassLoader, "", "controllers.Assets", "at", Seq(classOf[String], classOf[String]), "GET", """ Map static resources from the /public folder to the /assets URL path""", _prefix + """assets/$file<.+>""")
)
                      

}
                          

// @LINE:49
// @LINE:46
// @LINE:43
// @LINE:40
// @LINE:37
// @LINE:34
// @LINE:31
// @LINE:28
// @LINE:27
// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
class ReverseApplication {


// @LINE:15
def rate_hotel_fromHotel(name:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.rate_hotel_fromHotel(name), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "rate_hotel_fromHotel", Seq(classOf[String]), "GET", """""", _prefix + """rate_hotel_fromHotel""")
)
                      

// @LINE:34
def results_hotel_headerSearch(hotel:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.results_hotel_headerSearch(hotel), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "results_hotel_headerSearch", Seq(classOf[String]), "GET", """ Hotelsuche aus dem Header""", _prefix + """results_hotel_headerSearch""")
)
                      

// @LINE:40
def registration_submit(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.registration_submit(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "registration_submit", Seq(), "POST", """ Registrierung beim submitten""", _prefix + """registration_submit""")
)
                      

// @LINE:19
def hotel_enhancedSearch(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.hotel_enhancedSearch(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "hotel_enhancedSearch", Seq(), "GET", """""", _prefix + """hotel_enhancedSearch.scala.html""")
)
                      

// @LINE:12
def information_1hotel(name:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.information_1hotel(name), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "information_1hotel", Seq(classOf[String]), "GET", """""", _prefix + """information_1hotel.scala.html""")
)
                      

// @LINE:21
def newHotel(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.newHotel(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "newHotel", Seq(), "GET", """""", _prefix + """newHotel.scala.html""")
)
                      

// @LINE:13
def profile(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.profile(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "profile", Seq(), "GET", """""", _prefix + """profile.scala.html""")
)
                      

// @LINE:27
def checkLogin(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.checkLogin(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "checkLogin", Seq(), "POST", """ Login überprüfen""", _prefix + """checkLogin""")
)
                      

// @LINE:18
def results_search_hotel(land:String, stadt:String, hotel:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.results_search_hotel(land, stadt, hotel), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "results_search_hotel", Seq(classOf[String], classOf[String], classOf[String]), "GET", """""", _prefix + """results_search_hotel.scala.html""")
)
                      

// @LINE:43
def rate_hotel_submit(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.rate_hotel_submit(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "rate_hotel_submit", Seq(), "POST", """ Rate Hotel""", _prefix + """rate_hotel""")
)
                      

// @LINE:11
def impressum(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.impressum(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "impressum", Seq(), "GET", """""", _prefix + """impressum.scala.html""")
)
                      

// @LINE:17
def registration(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.registration(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "registration", Seq(), "GET", """""", _prefix + """registration.scala.html""")
)
                      

// @LINE:22
def allRates(hotel:String, id:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.allRates(hotel, id), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "allRates", Seq(classOf[String], classOf[String]), "GET", """""", _prefix + """allRates.scala.html""")
)
                      

// @LINE:20
def welcome(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.welcome(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "welcome", Seq(), "GET", """""", _prefix + """welcome.scala.html""")
)
                      

// @LINE:46
def ajax_complete(hotel:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.ajax_complete(hotel), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "ajax_complete", Seq(classOf[String]), "GET", """ Ajax für Hotel-Suchvorschläge""", _prefix + """ajax_complete""")
)
                      

// @LINE:14
def rate_hotel(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.rate_hotel(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "rate_hotel", Seq(), "GET", """""", _prefix + """rate_hotel.scala.html""")
)
                      

// @LINE:49
def recentlyRate(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.recentlyRate(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "recentlyRate", Seq(), "GET", """ Websocket: RecentlyRate""", _prefix + """recentlyRate""")
)
                      

// @LINE:9
def goodbye(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.goodbye(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "goodbye", Seq(), "GET", """""", _prefix + """goodbye.scala.html""")
)
                      

// @LINE:6
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.index(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "index", Seq(), "GET", """ Home page""", _prefix + """""")
)
                      

// @LINE:8
def contact(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.contact(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "contact", Seq(), "GET", """""", _prefix + """contact.scala.html""")
)
                      

// @LINE:10
def agbs(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.agbs(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "agbs", Seq(), "GET", """""", _prefix + """agbs.scala.html""")
)
                      

// @LINE:37
def results_hotel_enhancedSearch(land:String, stadt:String, hotel:String, verpflegung:String, pool:String, strand:String, zentrum:String, fahrrad:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.results_hotel_enhancedSearch(land, stadt, hotel, verpflegung, pool, strand, zentrum, fahrrad), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "results_hotel_enhancedSearch", Seq(classOf[String], classOf[String], classOf[String], classOf[String], classOf[String], classOf[String], classOf[String], classOf[String]), "GET", """ Hotelsuche aus dem Body (erweiterte Suche)""", _prefix + """results_hotel_enhancedSearch""")
)
                      

}
                          
}
        
    