
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
object goodbye extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(userVorname: String):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.23*/("""
"""),_display_(/*2.2*/main("Tschö")/*2.15*/(userVorname)/*2.28*/("2")/*2.33*/ {_display_(Seq[Any](format.raw/*2.35*/("""
"""),format.raw/*3.1*/("""<meta http-equiv="refresh" content="3; URL=index.scala.html">
<div class="row">
	<div class="col-md-12">
		<div class ="container-fluid">
			<h1>Tschüss """),_display_(/*7.17*/userVorname),format.raw/*7.28*/(""" """),format.raw/*7.29*/("""! Bis zum nächsten mal !</h1>
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
                  SOURCE: D:/01 HTWG/04 Semester/02 Projekte/ToKa_Hotel-Bewertungsportal/Toka_Hotel-Bewertungsportal_Final_pstmt_design/app/views/goodbye.scala.html
                  HASH: da572be7a3a79afcb58214b61bd4eb9f08c98c89
                  MATRIX: 725->1|834->22|862->25|883->38|904->51|917->56|956->58|984->60|1168->218|1199->229|1227->230
                  LINES: 26->1|29->1|30->2|30->2|30->2|30->2|30->2|31->3|35->7|35->7|35->7
                  -- GENERATED --
              */
          