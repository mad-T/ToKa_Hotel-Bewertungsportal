
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
object information_1hotel extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template6[String,models.Hotel,models.Bild,List[models.Bild],List[models.Bewertung],List[models.Bild],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(userVorname: String, hotel:models.Hotel, titelbild:models.Bild, bilder:List[models.Bild], bewertungen:List[models.Bewertung], bewertungsBilder:List[models.Bild]):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.164*/("""
"""),_display_(/*2.2*/main("Hotelbewertungen")/*2.26*/(userVorname)/*2.39*/("2")/*2.44*/ {_display_(Seq[Any](format.raw/*2.46*/("""
"""),format.raw/*3.1*/("""<div class="row">
	<div class="col-md-12">
		<div class="container-fluid">
			<h1>"""),_display_(/*6.9*/hotel/*6.14*/.getName()),format.raw/*6.24*/("""</h1>
			<div class="toka_paragraph"></div>
			<h4>Jetzt <a href="rate_hotel_fromHotel?name="""),_display_(/*8.50*/hotel/*8.55*/.getName()),format.raw/*8.65*/("""">Bewertung erfassen</a></h4>
			<div class="toka_paragraph"></div>
			<p>
				<img src="""),_display_(/*11.15*/titelbild/*11.24*/.getPfad()),format.raw/*11.34*/(""" """),format.raw/*11.35*/("""alt="Kein Titelbild vorhanden"></a>
			</p>
		</div>
	</div>
</div>
<div class="row">
	<div class="col-md-12">
		<div class="container-fluid">
			"""),_display_(/*19.5*/for(bild <- bilder) yield /*19.24*/ {_display_(Seq[Any](format.raw/*19.26*/("""
				"""),format.raw/*20.5*/("""<img src="""),_display_(/*20.15*/bild/*20.19*/.getPfad()),format.raw/*20.29*/(""" """),format.raw/*20.30*/("""width = "250" height = "175">
			""")))}),format.raw/*21.5*/("""
		"""),format.raw/*22.3*/("""<div id="toka_line-separator"></div>
		</div>
	</div>		
</div>
<div class="row">
	<div class="col-md-12">
		<div class="container-fluid">
			<p>Kurzbeschreibung: """),_display_(/*29.26*/hotel/*29.31*/.getKurzbeschreibung()),format.raw/*29.53*/("""</p>
			<p>Lange Beschreibung: """),_display_(/*30.28*/hotel/*30.33*/.getLangtext()),format.raw/*30.47*/("""</p>
			<p>Verpflegung: """),_display_(/*31.21*/hotel/*31.26*/.getVerpflegung()),format.raw/*31.43*/("""</p>
			<p>Kindergeiegnet: """),_display_(/*32.24*/hotel/*32.29*/.getKinder()),format.raw/*32.41*/("""</p>
		</div>
	</div>
</div>
<div class="row">
	<div class="col-md-12">
		<div class="container-fluid">
			<h2>Hier die aktuellsten Bewertungen - <a href="allRates.scala.html?hotel="""),_display_(/*39.79*/hotel/*39.84*/.getName()),format.raw/*39.94*/("""&id="""),_display_(/*39.99*/hotel/*39.104*/.getId()),format.raw/*39.112*/("""">alle</a></h2>
			<div class="toka_paragraph"></div>
		</div>
	</div>
</div>
"""),_display_(/*44.2*/for(bewertung <- bewertungen) yield /*44.31*/ {_display_(Seq[Any](format.raw/*44.33*/("""
	"""),format.raw/*45.2*/("""<div class="row">
		<div class="col-md-12">
			<div class="container-fluid">	
				<p>Beschreibung: """),_display_(/*48.23*/bewertung/*48.32*/.getBeschreibung()),format.raw/*48.50*/("""</p>
				<p>Kommentar: """),_display_(/*49.20*/bewertung/*49.29*/.getKurzkommentar()),format.raw/*49.48*/("""</p>
				<p>Urlaubsart: """),_display_(/*50.21*/bewertung/*50.30*/.getArt()),format.raw/*50.39*/("""</p>
				<p>Kinder: """),_display_(/*51.17*/bewertung/*51.26*/.getKinder()),format.raw/*51.38*/("""</p>
				<p>Verpflegung: """),_display_(/*52.22*/bewertung/*52.31*/.getVerpflegung()),format.raw/*52.48*/("""</p>
				<p>Von: """),_display_(/*53.14*/bewertung/*53.23*/.getVon()),format.raw/*53.32*/("""</p>
				<p>Bis: """),_display_(/*54.14*/bewertung/*54.23*/.getBis()),format.raw/*54.32*/("""</p>
				<p>Rating: """),_display_(/*55.17*/bewertung/*55.26*/.getRating()),format.raw/*55.38*/("""</p>

				"""),_display_(/*57.6*/for(bewertungsBild <- bewertungsBilder) yield /*57.45*/ {_display_(Seq[Any](format.raw/*57.47*/("""
					"""),_display_(/*58.7*/if(bewertungsBild.getFk_Bewertung() == bewertung.getId())/*58.64*/{_display_(Seq[Any](format.raw/*58.65*/("""
						"""),format.raw/*59.7*/("""<img src="""),_display_(/*59.17*/bewertungsBild/*59.31*/.getPfad()),format.raw/*59.41*/(""" """),format.raw/*59.42*/("""width = "250" height = "175">
					""")))}),format.raw/*60.7*/("""
				""")))}),format.raw/*61.6*/("""
			"""),format.raw/*62.4*/("""</div>
		</div>
	</div>
	"""),_display_(/*65.3*/if(bewertung != bewertungen.get(bewertungen.size()-1))/*65.57*/ {_display_(Seq[Any](format.raw/*65.59*/("""
		"""),format.raw/*66.3*/("""<div id="toka_line-separator"></div>
		""")))}),format.raw/*67.4*/("""
	""")))}),format.raw/*68.3*/("""
""")))}))}
  }

  def render(userVorname:String,hotel:models.Hotel,titelbild:models.Bild,bilder:List[models.Bild],bewertungen:List[models.Bewertung],bewertungsBilder:List[models.Bild]): play.twirl.api.HtmlFormat.Appendable = apply(userVorname,hotel,titelbild,bilder,bewertungen,bewertungsBilder)

  def f:((String,models.Hotel,models.Bild,List[models.Bild],List[models.Bewertung],List[models.Bild]) => play.twirl.api.HtmlFormat.Appendable) = (userVorname,hotel,titelbild,bilder,bewertungen,bewertungsBilder) => apply(userVorname,hotel,titelbild,bilder,bewertungen,bewertungsBilder)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Mon Jan 12 16:04:35 CET 2015
                  SOURCE: D:/01 HTWG/04 Semester/02 Projekte/ToKa_Hotel-Bewertungsportal/Toka_Hotel-Bewertungsportal_Final_pstmt_design/app/views/information_1hotel.scala.html
                  HASH: 827e571fa9bc08d0301c336fdb491f20e06a18ac
                  MATRIX: 820->1|1071->163|1099->166|1131->190|1152->203|1165->208|1204->210|1232->212|1343->298|1356->303|1386->313|1507->408|1520->413|1550->423|1669->515|1687->524|1718->534|1747->535|1928->690|1963->709|2003->711|2036->717|2073->727|2086->731|2117->741|2146->742|2211->777|2242->781|2439->951|2453->956|2496->978|2556->1011|2570->1016|2605->1030|2658->1056|2672->1061|2710->1078|2766->1107|2780->1112|2813->1124|3029->1313|3043->1318|3074->1328|3106->1333|3121->1338|3151->1346|3261->1430|3306->1459|3346->1461|3376->1464|3506->1567|3524->1576|3563->1594|3615->1619|3633->1628|3673->1647|3726->1673|3744->1682|3774->1691|3823->1713|3841->1722|3874->1734|3928->1761|3946->1770|3984->1787|4030->1806|4048->1815|4078->1824|4124->1843|4142->1852|4172->1861|4221->1883|4239->1892|4272->1904|4311->1917|4366->1956|4406->1958|4440->1966|4506->2023|4545->2024|4580->2032|4617->2042|4640->2056|4671->2066|4700->2067|4767->2104|4804->2111|4836->2116|4891->2145|4954->2199|4994->2201|5025->2205|5096->2246|5130->2250
                  LINES: 26->1|29->1|30->2|30->2|30->2|30->2|30->2|31->3|34->6|34->6|34->6|36->8|36->8|36->8|39->11|39->11|39->11|39->11|47->19|47->19|47->19|48->20|48->20|48->20|48->20|48->20|49->21|50->22|57->29|57->29|57->29|58->30|58->30|58->30|59->31|59->31|59->31|60->32|60->32|60->32|67->39|67->39|67->39|67->39|67->39|67->39|72->44|72->44|72->44|73->45|76->48|76->48|76->48|77->49|77->49|77->49|78->50|78->50|78->50|79->51|79->51|79->51|80->52|80->52|80->52|81->53|81->53|81->53|82->54|82->54|82->54|83->55|83->55|83->55|85->57|85->57|85->57|86->58|86->58|86->58|87->59|87->59|87->59|87->59|87->59|88->60|89->61|90->62|93->65|93->65|93->65|94->66|95->67|96->68
                  -- GENERATED --
              */
          