
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
object allRates extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template5[String,List[models.Bewertung],Int,List[models.Bild],String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(userVorname: String, bewertungen:List[models.Bewertung], anzahl:Int, bewertungsBilder:List[models.Bild], name:String):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.120*/("""
"""),_display_(/*2.2*/main("Hotelbewertungen")/*2.26*/(userVorname)/*2.39*/("2")/*2.44*/ {_display_(Seq[Any](format.raw/*2.46*/("""
"""),format.raw/*3.1*/("""<div class="row">
	<div class="col-md-12">
		<div class="container-fluid">
			<h1>Hotel """),_display_(/*6.15*/name),format.raw/*6.19*/(""" """),format.raw/*6.20*/("""wurde ingesamt """),_display_(/*6.36*/anzahl),format.raw/*6.42*/(""" """),format.raw/*6.43*/("""mal bewertet</h1>
			<div class="toka_paragraph"></div>
		</div>
	</div>
</div>

"""),_display_(/*12.2*/for(bewertung <- bewertungen) yield /*12.31*/{_display_(Seq[Any](format.raw/*12.32*/("""
	"""),format.raw/*13.2*/("""<div class="row">
		<div class="col-md-12">
			<div class="container-fluid">	
				<p>Beschreibung: """),_display_(/*16.23*/bewertung/*16.32*/.getBeschreibung()),format.raw/*16.50*/("""</p>
				<p>Kommentar: """),_display_(/*17.20*/bewertung/*17.29*/.getKurzkommentar()),format.raw/*17.48*/("""</p>
				<p>Urlaubsart: """),_display_(/*18.21*/bewertung/*18.30*/.getArt()),format.raw/*18.39*/("""</p>
				<p>Kinder: """),_display_(/*19.17*/bewertung/*19.26*/.getKinder()),format.raw/*19.38*/("""</p>
				<p>Verpflegung: """),_display_(/*20.22*/bewertung/*20.31*/.getVerpflegung()),format.raw/*20.48*/("""</p>
				<p>Von: """),_display_(/*21.14*/bewertung/*21.23*/.getVon()),format.raw/*21.32*/("""</p>
				<p>Bis: """),_display_(/*22.14*/bewertung/*22.23*/.getBis()),format.raw/*22.32*/("""</p>
				<p>Rating: """),_display_(/*23.17*/bewertung/*23.26*/.getRating()),format.raw/*23.38*/("""</p>
				
				"""),_display_(/*25.6*/for(bewertungsBild <- bewertungsBilder) yield /*25.45*/ {_display_(Seq[Any](format.raw/*25.47*/("""
					"""),_display_(/*26.7*/if(bewertungsBild.getFk_Bewertung() == bewertung.getId())/*26.64*/{_display_(Seq[Any](format.raw/*26.65*/("""
						"""),format.raw/*27.7*/("""<img src="""),_display_(/*27.17*/bewertungsBild/*27.31*/.getPfad()),format.raw/*27.41*/(""" """),format.raw/*27.42*/("""width = "250" height = "175">
					""")))}),format.raw/*28.7*/("""
				""")))}),format.raw/*29.6*/("""
			"""),format.raw/*30.4*/("""</div>
		</div>
	</div>
	"""),_display_(/*33.3*/if(bewertung != bewertungen.get(bewertungen.size()-1))/*33.57*/ {_display_(Seq[Any](format.raw/*33.59*/("""
		"""),format.raw/*34.3*/("""<div id="toka_line-separator"></div>
		""")))}),format.raw/*35.4*/("""
	""")))}),format.raw/*36.3*/("""
""")))}))}
  }

  def render(userVorname:String,bewertungen:List[models.Bewertung],anzahl:Int,bewertungsBilder:List[models.Bild],name:String): play.twirl.api.HtmlFormat.Appendable = apply(userVorname,bewertungen,anzahl,bewertungsBilder,name)

  def f:((String,List[models.Bewertung],Int,List[models.Bild],String) => play.twirl.api.HtmlFormat.Appendable) = (userVorname,bewertungen,anzahl,bewertungsBilder,name) => apply(userVorname,bewertungen,anzahl,bewertungsBilder,name)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Mon Jan 12 13:53:12 CET 2015
                  SOURCE: D:/01 HTWG/04 Semester/02 Projekte/ToKa_Hotel-Bewertungsportal/Toka_Hotel-Bewertungsportal_Final_pstmt_design/app/views/allRates.scala.html
                  HASH: 8b1abfaa2f63bc34c0957f94da9616de5e63009f
                  MATRIX: 778->1|985->119|1013->122|1045->146|1066->159|1079->164|1118->166|1146->168|1264->260|1288->264|1316->265|1358->281|1384->287|1412->288|1526->376|1571->405|1610->406|1640->409|1770->512|1788->521|1827->539|1879->564|1897->573|1937->592|1990->618|2008->627|2038->636|2087->658|2105->667|2138->679|2192->706|2210->715|2248->732|2294->751|2312->760|2342->769|2388->788|2406->797|2436->806|2485->828|2503->837|2536->849|2579->866|2634->905|2674->907|2708->915|2774->972|2813->973|2848->981|2885->991|2908->1005|2939->1015|2968->1016|3035->1053|3072->1060|3104->1065|3159->1094|3222->1148|3262->1150|3293->1154|3364->1195|3398->1199
                  LINES: 26->1|29->1|30->2|30->2|30->2|30->2|30->2|31->3|34->6|34->6|34->6|34->6|34->6|34->6|40->12|40->12|40->12|41->13|44->16|44->16|44->16|45->17|45->17|45->17|46->18|46->18|46->18|47->19|47->19|47->19|48->20|48->20|48->20|49->21|49->21|49->21|50->22|50->22|50->22|51->23|51->23|51->23|53->25|53->25|53->25|54->26|54->26|54->26|55->27|55->27|55->27|55->27|55->27|56->28|57->29|58->30|61->33|61->33|61->33|62->34|63->35|64->36
                  -- GENERATED --
              */
          