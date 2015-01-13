
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
object agbs extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(userVorname: String):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.23*/("""
"""),_display_(/*2.2*/main("AGBs")/*2.14*/(userVorname)/*2.27*/("2")/*2.32*/ {_display_(Seq[Any](format.raw/*2.34*/("""
	"""),format.raw/*3.2*/("""<div class="row">
		<div class="col-md-4">
			<div class="container-fluid">
				<h1>AGBs</h1>
				<div class="toka_paragraph"></div>
				<p><i>Unsere Seite dient ausschließlich als Informationsquelle für die bessere Planungsentscheidung Ihres nächsten Hotelbesuches. Innerhalb unserer Web-Präsenz kommt es zu keinem Zeitpunkt zu einem Vertragsabschluss. <br/>
				AGBs sind in diesem Sinne keine definiert.</i></p>
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
                  SOURCE: D:/01 HTWG/04 Semester/02 Projekte/ToKa_Hotel-Bewertungsportal/Toka_Hotel-Bewertungsportal_Final_pstmt_design/app/views/agbs.scala.html
                  HASH: e5b2df420b79dbb649ba6c86de62e69cffc8a74d
                  MATRIX: 722->1|831->22|859->25|879->37|900->50|913->55|952->57|981->60
                  LINES: 26->1|29->1|30->2|30->2|30->2|30->2|30->2|31->3
                  -- GENERATED --
              */
          