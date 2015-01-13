
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
object results_search_hotel extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template4[String,Int,List[models.Hotel],List[models.Bild],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(userVorname: String, anzahl: Int, hotels:List[models.Hotel], titelbilder:List[models.Bild]):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.94*/("""
"""),_display_(/*2.2*/main("Suchergebnis")/*2.22*/(userVorname)/*2.35*/("2")/*2.40*/ {_display_(Seq[Any](format.raw/*2.42*/("""
	"""),format.raw/*3.2*/("""<div class="row">
		<div class="col-md-12">
			<div class="container-fluid">
				<h1>Ergebnis Ihrer Suche:</h1>
				<div class="toka_paragraph"></div>
				"""),_display_(/*8.6*/if(anzahl == 1)/*8.21*/{_display_(Seq[Any](format.raw/*8.22*/("""
					"""),format.raw/*9.6*/("""<h4>Es wurde """),_display_(/*9.20*/anzahl),format.raw/*9.26*/(""" """),format.raw/*9.27*/("""Hotel gefunden:</h4>
				""")))}/*10.6*/else/*10.10*/{_display_(Seq[Any](format.raw/*10.11*/("""
					"""),format.raw/*11.6*/("""<h4>Es wurden """),_display_(/*11.21*/anzahl),format.raw/*11.27*/(""" """),format.raw/*11.28*/("""Hotels gefunden:</h4>	
				""")))}),format.raw/*12.6*/("""
				"""),format.raw/*13.5*/("""<div class="toka_paragraph"></div>											
				<div class="toka_paragraph"></div>	
			</div>
		</div>
	</div>

	"""),_display_(/*19.3*/for(hotel <- hotels) yield /*19.23*/ {_display_(Seq[Any](format.raw/*19.25*/("""
	"""),format.raw/*20.2*/("""<div class="row">
		<div class="col-md-3">
			<div class="container-fluid">
				"""),_display_(/*23.6*/for(titelbild <- titelbilder) yield /*23.35*/ {_display_(Seq[Any](format.raw/*23.37*/("""
					"""),_display_(/*24.7*/if(hotel.getId() == titelbild.getFk_Hotel())/*24.51*/{_display_(Seq[Any](format.raw/*24.52*/("""
					"""),format.raw/*25.6*/("""<a href="information_1hotel.scala.html?name="""),_display_(/*25.51*/hotel/*25.56*/.getName()),format.raw/*25.66*/("""">
						<img src="""),_display_(/*26.17*/titelbild/*26.26*/.getPfad()),format.raw/*26.36*/(""" """),format.raw/*26.37*/("""alt="Kein Titelbild vorhanden" width = "250" height = "175"></img>
					</a>
					""")))}),format.raw/*28.7*/("""
				""")))}),format.raw/*29.6*/("""
			"""),format.raw/*30.4*/("""</div>
		</div>
		<div class="col-md-9">
			<div class="container-fluid">
				<a href="information_1hotel.scala.html?name="""),_display_(/*34.50*/hotel/*34.55*/.getName()),format.raw/*34.65*/("""">
					"""),_display_(/*35.7*/hotel/*35.12*/.getName()),format.raw/*35.22*/(""" """),format.raw/*35.23*/("""- 	"""),_display_(/*35.27*/hotel/*35.32*/.getKurzbeschreibung()),format.raw/*35.54*/("""</br>
					"""),_display_(/*36.7*/hotel/*36.12*/.getLangtext()),format.raw/*36.26*/("""
				"""),format.raw/*37.5*/("""</a>
			</div>
		</div>
	</div>
	"""),_display_(/*41.3*/if(hotel != hotels.get(hotels.size()-1))/*41.43*/ {_display_(Seq[Any](format.raw/*41.45*/("""
		"""),format.raw/*42.3*/("""<div id="toka_line-separator"></div>
		""")))}),format.raw/*43.4*/("""
	""")))}),format.raw/*44.3*/("""	
""")))}))}
  }

  def render(userVorname:String,anzahl:Int,hotels:List[models.Hotel],titelbilder:List[models.Bild]): play.twirl.api.HtmlFormat.Appendable = apply(userVorname,anzahl,hotels,titelbilder)

  def f:((String,Int,List[models.Hotel],List[models.Bild]) => play.twirl.api.HtmlFormat.Appendable) = (userVorname,anzahl,hotels,titelbilder) => apply(userVorname,anzahl,hotels,titelbilder)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Mon Jan 12 13:53:12 CET 2015
                  SOURCE: D:/01 HTWG/04 Semester/02 Projekte/ToKa_Hotel-Bewertungsportal/Toka_Hotel-Bewertungsportal_Final_pstmt_design/app/views/results_search_hotel.scala.html
                  HASH: 8d589260f5a4c6e899c41a7a145ee810a2d2bfa8
                  MATRIX: 779->1|959->93|987->96|1015->116|1036->129|1049->134|1088->136|1117->139|1303->300|1326->315|1364->316|1397->323|1437->337|1463->343|1491->344|1536->371|1549->375|1588->376|1622->383|1664->398|1691->404|1720->405|1779->434|1812->440|1960->562|1996->582|2036->584|2066->587|2176->671|2221->700|2261->702|2295->710|2348->754|2387->755|2421->762|2493->807|2507->812|2538->822|2585->842|2603->851|2634->861|2663->862|2778->947|2815->954|2847->959|3001->1086|3015->1091|3046->1101|3082->1111|3096->1116|3127->1126|3156->1127|3187->1131|3201->1136|3244->1158|3283->1171|3297->1176|3332->1190|3365->1196|3429->1234|3478->1274|3518->1276|3549->1280|3620->1321|3654->1325
                  LINES: 26->1|29->1|30->2|30->2|30->2|30->2|30->2|31->3|36->8|36->8|36->8|37->9|37->9|37->9|37->9|38->10|38->10|38->10|39->11|39->11|39->11|39->11|40->12|41->13|47->19|47->19|47->19|48->20|51->23|51->23|51->23|52->24|52->24|52->24|53->25|53->25|53->25|53->25|54->26|54->26|54->26|54->26|56->28|57->29|58->30|62->34|62->34|62->34|63->35|63->35|63->35|63->35|63->35|63->35|63->35|64->36|64->36|64->36|65->37|69->41|69->41|69->41|70->42|71->43|72->44
                  -- GENERATED --
              */
          