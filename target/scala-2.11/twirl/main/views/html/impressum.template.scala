
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
object impressum extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(userVorname: String):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.23*/("""
"""),_display_(/*2.2*/main("Impressum")/*2.19*/(userVorname)/*2.32*/("2")/*2.37*/ {_display_(Seq[Any](format.raw/*2.39*/("""
"""),format.raw/*3.1*/("""<div class="row">
	<div class="col-md-12">
		<div class="container-fluid">
			<h2>Unternehmen</h2>
			<h4>ToKa GmbH</h4>
			<i>Untere Laube<br/>
			78462 Konstanz<br/>	
			Telefon: +49 0176 00000010<br/>
			<div id="toka_emailLine">
				<a href="mailto:toka@mail.de">
					<div id="toka_emailIcon">
						<img src="""),_display_(/*14.17*/routes/*14.23*/.Assets.at("images/brief-icon1.png")),format.raw/*14.59*/(""">
						toka@mail.de</a></i>
					</div>
			</div>

			<div class="toka_paragraph"></div>

			<h2>Haftungshinweis</h2>
			<p>Trotz sorgfältiger inhaltlicher Kontrolle übernehmen wir keine Haftung für die Inhalte externer Links. 
			Für den Inhalt der verlinkten Seiten sind ausschließlich deren Betreiber verantwortlich.</p>
		</div>
	</div>
</div>
""")))}))}
  }

  def render(userVorname:String): play.twirl.api.HtmlFormat.Appendable = apply(userVorname)

  def f:((String) => play.twirl.api.HtmlFormat.Appendable) = (userVorname) => apply(userVorname)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Mon Jan 12 13:53:12 CET 2015
                  SOURCE: D:/01 HTWG/04 Semester/02 Projekte/ToKa_Hotel-Bewertungsportal/Toka_Hotel-Bewertungsportal_Final_pstmt_design/app/views/impressum.scala.html
                  HASH: 009e43fc08c5992740c72e781c8305a41756ce91
                  MATRIX: 727->1|836->22|864->25|889->42|910->55|923->60|962->62|990->64|1343->391|1358->397|1415->433
                  LINES: 26->1|29->1|30->2|30->2|30->2|30->2|30->2|31->3|42->14|42->14|42->14
                  -- GENERATED --
              */
          