
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
object contact extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(userVorname: String):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.23*/("""
"""),_display_(/*2.2*/main("Kontakt")/*2.17*/(userVorname)/*2.30*/("2")/*2.35*/{_display_(Seq[Any](format.raw/*2.36*/("""
"""),format.raw/*3.1*/("""<div class="row">
	<div class="col-md-3">
		<div class="container-fluid">
			<h2>Kontakt</h2>
			<div class="toka_paragraph"></div>
			<h4>ToKa GmbH</h4>
			<i>Untere Laube<br/>
			78462 Konstanz<br/>	
			Telefon: +49 0176 00000010<br/>
			<div id="toka_emailLine">
				<a href="mailto:toka@mail.de">
					<div id="toka_emailIcon">
						<img src="""),_display_(/*15.17*/routes/*15.23*/.Assets.at("images/brief-icon1.png")),format.raw/*15.59*/(""">
						toka@mail.de</a></i>
					</div>
			</div>
		</div>
	</div>
	<div class="col-md-9">
		<div class="container-fluid">
			<h2>Anfahrt</h2>
			<div class="toka_paragraph"></div>
			<iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d671.7623867967785!2d9.173505209815803!3d47.66403385902182!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x479af6fd54193679%3A0x5699218e4bf7d9d3!2sUntere+Laube%2C+78462+Konstanz!5e0!3m2!1sde!2sde!4v1418121932116" width="600" height="450" frameborder="0" style="border:0"></iframe>
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
                  SOURCE: D:/01 HTWG/04 Semester/02 Projekte/ToKa_Hotel-Bewertungsportal/Toka_Hotel-Bewertungsportal_Final_pstmt_design/app/views/contact.scala.html
                  HASH: 821c6498d2e4009dc3956ed1a91314a1f820f280
                  MATRIX: 725->1|834->22|862->25|885->40|906->53|919->58|957->59|985->61|1372->422|1387->428|1444->464
                  LINES: 26->1|29->1|30->2|30->2|30->2|30->2|30->2|31->3|43->15|43->15|43->15
                  -- GENERATED --
              */
          