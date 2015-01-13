
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
object welcome extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(userVorname: String):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.23*/("""
"""),_display_(/*2.2*/main("Willkommen")/*2.20*/(userVorname)/*2.33*/("2")/*2.38*/ {_display_(Seq[Any](format.raw/*2.40*/("""
"""),format.raw/*3.1*/("""<div class="row">
	<div class="col-md-12">
		<div class="container-fluid">
			<h1>Willkommen bei ToKa - Dein Hotelbewertungsportal</h1>
			<div class="toka_paragraph"></div>
			<h3>Hallo """),_display_(/*8.15*/userVorname),format.raw/*8.26*/("""</h3>
		</div>
	</div>
</div>
<div class="row">
	<div class="col-md-12">
		<div class="container-fluid">
			<h3>Hotel bewerten? Klicken Sie <a href="rate_hotel.scala.html">hier</a></h3>
			<h3><a href="profile.scala.html">Hier</a> geht's zu Ihrem Profil</h3>
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
                  SOURCE: D:/01 HTWG/04 Semester/02 Projekte/ToKa_Hotel-Bewertungsportal/Toka_Hotel-Bewertungsportal_Final_pstmt_design/app/views/welcome.scala.html
                  HASH: 5a22f3118247b256bd05394b18345b34b9aafbbe
                  MATRIX: 725->1|834->22|862->25|888->43|909->56|922->61|961->63|989->65|1208->258|1239->269
                  LINES: 26->1|29->1|30->2|30->2|30->2|30->2|30->2|31->3|36->8|36->8
                  -- GENERATED --
              */
          