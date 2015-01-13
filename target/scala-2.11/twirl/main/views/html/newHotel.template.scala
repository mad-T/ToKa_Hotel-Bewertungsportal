
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
object newHotel extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(userVorname: String):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.23*/("""
"""),_display_(/*2.2*/main("Neues Hotel")/*2.21*/(userVorname)/*2.34*/("2")/*2.39*/ {_display_(Seq[Any](format.raw/*2.41*/("""
"""),format.raw/*3.1*/("""<div class="row">
	<div class="col-md-12">
		<div class="container-fluid">
			<h1>Neues Hotel</h1>
			<div class="toka_paragraph"></div>
			<h4>Füllen Sie alle Felder aus. Nach Abschicken dieses Formulars erhalten wir eine eMail.</h4>
			<div class="toka_paragraph"></div>
				<form action="mailto:tobias.spott@gmx.de" enctype="text/plain">
					<input type="text" class="form-control toka_textfelder" name="name" placeholder="Hotelname"><br/>
					<input type="text" class="form-control toka_textfelder" name="ort" placeholder="Ort"><br/>
					<input type="text" class="form-control toka_textfelder" name="plz" placeholder="PLZ"><br/>
					<input type="text" class="form-control toka_textfelder" name="strasse" placeholder="Strasse"><br/>
					<input type="text" class="form-control toka_textfelder" name="land" placeholder="Land"><br/>
					<p><textarea style="width: 40%;" class="form-control" name="Beschreibung" placeholder="Beschreibung"  cols="100" rows="10"></textarea></p>
					<button type="submit" class="btn btn-default">Hoteldaten abschicken</button>
				</form>
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
                  SOURCE: D:/01 HTWG/04 Semester/02 Projekte/ToKa_Hotel-Bewertungsportal/Toka_Hotel-Bewertungsportal_Final_pstmt_design/app/views/newHotel.scala.html
                  HASH: 5e5af102d0f7be94d31756878e96bf1d3636d5d0
                  MATRIX: 726->1|835->22|863->25|890->44|911->57|924->62|963->64|991->66
                  LINES: 26->1|29->1|30->2|30->2|30->2|30->2|30->2|31->3
                  -- GENERATED --
              */
          