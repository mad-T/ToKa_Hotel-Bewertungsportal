
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._

import play.api.templates.PlayMagic._
import models._
import controllers._
import java.lang._
import java.util._
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import play.api.i18n._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.data._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._
import views.html._

/**/
object index extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template4[String,List[models.Bewertung],List[models.Hotel],String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(userVorname: String, bewertungen:List[models.Bewertung], topHotels:List[models.Hotel], loginStatusCode: String):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.114*/("""
"""),_display_(/*2.2*/main("ToKa - Startseite")/*2.27*/(userVorname)/*2.40*/(loginStatusCode)/*2.57*/ {_display_(Seq[Any](format.raw/*2.59*/("""
"""),format.raw/*3.1*/("""<div class="row">
		<div class="col-md-4">
			<div class="container-fluid">
				<h2>Hotelsuche</h2>
				<form class="navbar-form navbar-left" role="search" method="GET" action="results_search_hotel.scala.html">
					<div class="form-group">
						<p>
							<input pattern="[a-zA-Z&ouml&Ouml&uuml&Uuml&auml&Auml&szlig]*" title="Bitte nur Buchstaben" placeholder="Land" name="land" class="form-control toka_textfelder">
						</p>
						<p>
							<input pattern="[a-zA-Z&ouml&Ouml&uuml&Uuml&auml&Auml&szlig]*" title="Bitte nur Buchstaben" placeholder="Stadt" name="stadt" class="form-control toka_textfelder">
						</p>
						<p>
							<input pattern="[a-zA-Z&ouml&Ouml&uuml&Uuml&auml&Auml&szlig]*" title="Bitte nur Buchstaben" placeholder="Hotel" name="hotel" class="form-control toka_textfelder">
						</p>
						<button type="submit" onclick="" class="btn btn-default">Suchen</button>
						<a href="hotel_enhancedSearch.scala.html">erweiterte Suche</a>	
					</div>
				</form>
			</div>
		</div>
		<div class="col-md-4">
			<div id="toka_indexTopRowCenter">
				<p class="text-center">
				<h3>
					Schon ihren letzten Hotelbesuch bewertet?<br/><small>Nein ? - Dann <a href="rate_hotel.scala.html">los!!</small></a>
				</h3>
				</p>
			</div>
		</div>
		<script type="text/javascript">
			var webSocket;
			$(function() """),format.raw/*35.17*/("""{"""),format.raw/*35.18*/("""
				"""),format.raw/*36.5*/("""var WS = window["MozWebSocket"] ? MozWebSocket : WebSocket;
				webSocket = new WS(""""),_display_(/*37.26*/routes/*37.32*/.Application.recentlyRate().webSocketURL(request)),format.raw/*37.81*/("""");
				webSocket.onmessage = receiveEvent;
			"""),format.raw/*39.4*/("""}"""),format.raw/*39.5*/(""")
			
			function receiveEvent(event) """),format.raw/*41.33*/("""{"""),format.raw/*41.34*/("""
				"""),format.raw/*42.5*/("""var html = "";
				var jsonObj = JSON.parse(event.data);
				var bewertungen = jsonObj.bewertungen;
				
				for (b in bewertungen)"""),format.raw/*46.27*/("""{"""),format.raw/*46.28*/("""
					"""),format.raw/*47.6*/("""html += '<p>Erfasst: ' + bewertungen[b].erfasst + '<br/>' + 
							"Hotelname: " + bewertungen[b].hotelname + "<br/>" +
							"Kommentar: " + bewertungen[b].kommentar + "<br/>" +
							'<span class="label label-warning"><i>' + bewertungen[b].rating + ' Stars</i></span>'
							//'<input id="input-21e" value=' + bewertungen[b].rating + ' type="number" class="form-control toka_textfelder rating" name="rating" min=0 max=5 step=1 data-size="xs" readonly></p>';
				"""),format.raw/*52.5*/("""}"""),format.raw/*52.6*/("""
				"""),format.raw/*53.5*/("""//html += "</p>";
				document.getElementById("jsonDaten").innerHTML = html;
			"""),format.raw/*55.4*/("""}"""),format.raw/*55.5*/(""";
		</script>
			<div class="col-md-4">
				<h3>Vor kurzem bewertet:</h3>
					<div id="jsonDaten">
						"""),_display_(/*60.8*/for(bewertung <- bewertungen) yield /*60.37*/{_display_(Seq[Any](format.raw/*60.38*/("""
						"""),format.raw/*61.7*/("""<p>	
							Erfasst: """),_display_(/*62.18*/bewertung/*62.27*/.getErfassungsDatum()),format.raw/*62.48*/("""<br/>
							Hotelname: """),_display_(/*63.20*/bewertung/*63.29*/.getFk_Hotel()),format.raw/*63.43*/("""<br/>
							Kommentar: """),_display_(/*64.20*/bewertung/*64.29*/.getKurzkommentar()),format.raw/*64.48*/("""<br/>
							<input id="input-21e" value=""""),_display_(/*65.38*/bewertung/*65.47*/.getRating()),format.raw/*65.59*/("""" type="number" class="form-control toka_textfelder rating" name="rating" min=0 max=5 step=1 data-size="xs" readonly>
						</p>
						""")))}),format.raw/*67.8*/("""
					"""),format.raw/*68.6*/("""</div> 
			</div>
</div>
<div class="row">
	<div class="col-md-12">
		<div class="container-fluid">
			<h2>Traumziele 2015</h2>
				<div class="toka_paragraph"></div>
					<!-- Slideshow -->
					<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
						<!-- Indicators -->
						<ol class="carousel-indicators">
							<li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
					    	<li data-target="#carousel-example-generic" data-slide-to="1"></li>
					    	<li data-target="#carousel-example-generic" data-slide-to="2"></li>
						</ol>

						<!-- Wrapper for slides -->
						<div class="carousel-inner" role="listbox">
							"""),_display_(/*87.9*/for(hotel <- topHotels) yield /*87.32*/{_display_(Seq[Any](format.raw/*87.33*/("""								
								"""),_display_(/*88.10*/if(hotel == topHotels.get(0))/*88.39*/ {_display_(Seq[Any](format.raw/*88.41*/("""
									"""),format.raw/*89.10*/("""<div class="item active">
								""")))}/*90.11*/else/*90.16*/{_display_(Seq[Any](format.raw/*90.17*/("""						
									"""),format.raw/*91.10*/("""<div class="item">
								""")))}),format.raw/*92.10*/("""						
					     				"""),format.raw/*93.15*/("""<a href="information_1hotel.scala.html?name="""),_display_(/*93.60*/hotel/*93.65*/.getName()),format.raw/*93.75*/(""""><img src="""),_display_(/*93.87*/hotel/*93.92*/.getTitelbild()),format.raw/*93.107*/(""" """),format.raw/*93.108*/("""alt="""),_display_(/*93.113*/hotel/*93.118*/.getName()),format.raw/*93.128*/("""></img>
					      				<div class="carousel-caption">
					        				<h3>"""),_display_(/*95.23*/hotel/*95.28*/.getName()),format.raw/*95.38*/("""</h3>
					        				<span class="label label-warning"><i>"""),_display_(/*96.56*/hotel/*96.61*/.getLangtext),format.raw/*96.73*/(""" """),format.raw/*96.74*/("""Stars</i></span>
					        			</a>
					      				</div>
					   				</div>
								""")))}),format.raw/*100.10*/("""
									"""),format.raw/*101.10*/("""<!-- Controls -->
									<a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
										<span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
										<span class="sr-only">Previous</span>
									</a>
					  				<a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
					    				<span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
					    				<span class="sr-only">Next</span>
					  				</a>
					  	</div>
					</div>
		</div>
	</div>
</div>
""")))}),format.raw/*115.2*/("""
"""))}
  }

  def render(userVorname:String,bewertungen:List[models.Bewertung],topHotels:List[models.Hotel],loginStatusCode:String): play.twirl.api.HtmlFormat.Appendable = apply(userVorname,bewertungen,topHotels,loginStatusCode)

  def f:((String,List[models.Bewertung],List[models.Hotel],String) => play.twirl.api.HtmlFormat.Appendable) = (userVorname,bewertungen,topHotels,loginStatusCode) => apply(userVorname,bewertungen,topHotels,loginStatusCode)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Mon Jan 12 16:21:55 CET 2015
                  SOURCE: D:/01 HTWG/04 Semester/02 Projekte/ToKa_Hotel-Bewertungsportal/Toka_Hotel-Bewertungsportal_Final_pstmt_design/app/views/index.scala.html
                  HASH: cbba2c0cf92bfd8dd7ab0c45c2f44ca6f6618e31
                  MATRIX: 772->1|973->113|1001->116|1034->141|1055->154|1080->171|1119->173|1147->175|2538->1538|2567->1539|2600->1545|2713->1631|2728->1637|2798->1686|2874->1735|2902->1736|2970->1776|2999->1777|3032->1783|3195->1918|3224->1919|3258->1926|3758->2399|3786->2400|3819->2406|3928->2488|3956->2489|4094->2601|4139->2630|4178->2631|4213->2639|4263->2662|4281->2671|4323->2692|4376->2718|4394->2727|4429->2741|4482->2767|4500->2776|4540->2795|4611->2839|4629->2848|4662->2860|4830->2998|4864->3005|5601->3716|5640->3739|5679->3740|5725->3759|5763->3788|5803->3790|5842->3801|5897->3838|5910->3843|5949->3844|5994->3861|6054->3890|6104->3912|6176->3957|6190->3962|6221->3972|6260->3984|6274->3989|6311->4004|6341->4005|6374->4010|6389->4015|6421->4025|6526->4103|6540->4108|6571->4118|6660->4180|6674->4185|6707->4197|6736->4198|6860->4290|6900->4301|7531->4901
                  LINES: 26->1|29->1|30->2|30->2|30->2|30->2|30->2|31->3|63->35|63->35|64->36|65->37|65->37|65->37|67->39|67->39|69->41|69->41|70->42|74->46|74->46|75->47|80->52|80->52|81->53|83->55|83->55|88->60|88->60|88->60|89->61|90->62|90->62|90->62|91->63|91->63|91->63|92->64|92->64|92->64|93->65|93->65|93->65|95->67|96->68|115->87|115->87|115->87|116->88|116->88|116->88|117->89|118->90|118->90|118->90|119->91|120->92|121->93|121->93|121->93|121->93|121->93|121->93|121->93|121->93|121->93|121->93|121->93|123->95|123->95|123->95|124->96|124->96|124->96|124->96|128->100|129->101|143->115
                  -- GENERATED --
              */
          