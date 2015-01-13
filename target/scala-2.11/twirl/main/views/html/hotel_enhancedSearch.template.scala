
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
object hotel_enhancedSearch extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(userVorname: String):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.23*/("""
"""),_display_(/*2.2*/main("Hotelsuche")/*2.20*/(userVorname)/*2.33*/("2")/*2.38*/ {_display_(Seq[Any](format.raw/*2.40*/("""
"""),format.raw/*3.1*/("""<div class="row">
	<div class="col-md-12">
		<div class="container-fluid">
			<h2>Hotelsuche</h2>
				<form method="GET" action="results_hotel_enhancedSearch">
					<p><input pattern="[a-zA-Z&ouml&Ouml&uuml&Uuml&auml&Auml&szlig]*" title="Bitte nur Buchstaben" placeholder="Land" name="land" class="form-control toka_textfelder"></p>
					<p><input pattern="[a-zA-Z&ouml&Ouml&uuml&Uuml&auml&Auml&szlig]*[ ][a-zA-Z&ouml&Ouml&uuml&Uuml&auml&Auml&szlig]*" title="Bitte nur Buchstaben" placeholder="Stadt" name="stadt" class="form-control toka_textfelder"></p>
					<p><input pattern="[a-zA-Z&ouml&Ouml&uuml&Uuml&auml&Auml&szlig]*" title="Bitte nur Buchstaben" placeholder="Hotel" name="hotel" class="form-control toka_textfelder"></p>
										
					<label for="ai" class="radio-inline">All Inclusiv</label>
					<input type="radio" name="verpflegung" id="ai" value="AI" checked="checked"></br>
										
					<label for="hp" class="radio-inline">Halbpension</label>
					<input type="radio" name="verpflegung" id="hp" value="HP"></br>
					
					<label for="vp" class="radio-inline">Vollpension</label>
					<input type="radio" name="verpflegung" id="vp" value="VP"><br>
								
					<div class="checkbox">
						<label for="pool">Pool</label>
						<input type="checkbox" name="pool" id="pool" value="ja">
						<input type="hidden" name="pool" value="nein"></br>
						<label for="strand">Strand</label>
						<input type="checkbox" name="strand" id="strand" value="ja">
						<input type="hidden" name="strand" value="nein"></br>
						<label for="zentrum">Zentrum</label>
						<input type="checkbox" name="zentrum" id="zentrum" value="ja">
						<input type="hidden" name="zentrum" value="nein"></br>
						<label for="fahrrad">Fahrrad verleih</label>
						<input type="checkbox" name="fahrrad" id="fahrrad" value="ja">
						<input type="hidden" name="fahrrad" value="nein"></br>
					</div>
					<div class="toka_paragraph"></div>										
					<button type="submit" class="btn btn-default">Suchen</button>
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
                  SOURCE: D:/01 HTWG/04 Semester/02 Projekte/ToKa_Hotel-Bewertungsportal/Toka_Hotel-Bewertungsportal_Final_pstmt_design/app/views/hotel_enhancedSearch.scala.html
                  HASH: bfc3cd443a51503dc414d1c439a2ca80d354937c
                  MATRIX: 738->1|847->22|875->25|901->43|922->56|935->61|974->63|1002->65
                  LINES: 26->1|29->1|30->2|30->2|30->2|30->2|30->2|31->3
                  -- GENERATED --
              */
          