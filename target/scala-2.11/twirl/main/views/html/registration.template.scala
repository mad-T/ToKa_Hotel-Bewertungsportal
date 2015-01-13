
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
object registration extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template3[String,Int,String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(userVorname: String, emailPar: Int, loginStatusCode: String):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.63*/("""
"""),_display_(/*2.2*/main("Registrieren")/*2.22*/(userVorname)/*2.35*/("-2")/*2.41*/ {_display_(Seq[Any](format.raw/*2.43*/("""
"""),format.raw/*3.1*/("""<div class="row">
	<div class="col-md-12">
		<div class="container-fluid">
			"""),_display_(/*6.5*/if(emailPar == 1)/*6.22*/{_display_(Seq[Any](format.raw/*6.23*/("""
				"""),format.raw/*7.5*/("""<div class="alert alert-danger" role="alert">Die eMail-Adresse ist bereits vorhanden. Bitte wählen Sie eine andere.</div>
				<div class="toka_paragraph"></div>
			""")))}),format.raw/*9.5*/("""
			"""),_display_(/*10.5*/if(emailPar == 2)/*10.22*/{_display_(Seq[Any](format.raw/*10.23*/("""
				"""),format.raw/*11.5*/("""<div class="alert alert-success" role="alert">Ihr User wurde erfolgreich angelegt!</div>
				<div class="toka_paragraph"></div>
			""")))}),format.raw/*13.5*/("""
			"""),_display_(/*14.5*/if(loginStatusCode == "-1")/*14.32*/ {_display_(Seq[Any](format.raw/*14.34*/("""
				"""),format.raw/*15.5*/("""<div class="alert alert-danger" role="alert">Der User ist nicht vorhanden. Hier können Sie sich einen User anlegen</div>
				<div class="toka_paragraph"></div>
			""")))}),format.raw/*17.5*/("""
			"""),format.raw/*18.4*/("""<h1>Registrieren</h1>
			<div class="toka_paragraph"></div>
		</div>
	</div>
</div>
<div class="row">
	<div class="col-md-4">
		<div class="container-fluid">
			<form method="POST" action="registration_submit" enctype="multipart/form-data">						
				<div class="form-group">
					<input pattern="[a-zA-Z&ouml&Ouml&uuml&Uuml&auml&Auml&szlig]*([ ][a-zA-Z&ouml&Ouml&uuml&Uuml&auml&Auml&szlig]+)*" title="Bitte nur Buchstaben" class="form-control toka_textfelder" placeholder="Vorname" name="vorname" autofocus></br>
					<input pattern="[a-zA-Z&ouml&Ouml&uuml&Uuml&auml&Auml&szlig]*([ ][a-zA-Z&ouml&Ouml&uuml&Uuml&auml&Auml&szlig]+)*" title="Bitte nur Buchstaben" class="form-control toka_textfelder" placeholder="Nachname" name="nachname"></br>
					<input class="form-control toka_textfelder" placeholder="Geburtstag" type="date" name="geburtstag"></br>
								
					<p>Geschlecht</p>
					<select class="form-control toka_textfelder"  name="geschlecht">
						<option value="m">männlich</option>
						<option value="w">weiblich</option>
					</select><br/>
					
					<p>Familienstand<p/>
					<select class="form-control toka_textfelder"  name="familienstand">
						<option value="ld">ledig</option>
						<option value="vh">verheiratet</option>
						<option value="gt">getrennt</option>
						<option value="gs">geschieden</option>
						<option value="vw">verwitwet</option>
					</select><br/>
					<script>
					function passwortCheck()"""),format.raw/*47.30*/("""{"""),format.raw/*47.31*/("""
						 """),format.raw/*48.8*/("""var pw = document.getElementById("pw").value;
						 var pw_wdh = document.getElementById("pw_wdh").value;
						
						 //if(pw_wdh != null)"""),format.raw/*51.28*/("""{"""),format.raw/*51.29*/("""
							 """),format.raw/*52.9*/("""if(pw != pw_wdh)"""),format.raw/*52.25*/("""{"""),format.raw/*52.26*/("""
							  """),format.raw/*53.10*/("""alert("Die PasswÃ¶rter sind nicht gleich, bitte versuchen Sie es nochmal!");
							  document.getElementById("pw_wdh").value = "";
							 """),format.raw/*55.9*/("""}"""),format.raw/*55.10*/("""
						 """),format.raw/*56.8*/("""//"""),format.raw/*56.10*/("""}"""),format.raw/*56.11*/("""

					"""),format.raw/*58.6*/("""}"""),format.raw/*58.7*/("""
					"""),format.raw/*59.6*/("""</script>
					
					<input pattern="[a-zA-Z&ouml&Ouml&uuml&Uuml&auml&Auml&szlig]*([ ][a-zA-Z&ouml&Ouml&uuml&Uuml&auml&Auml&szlig]+)*[.]?[ ]?[1-9][0-9]?[a-zA-Z]?" title="Buchstaben Zahl" class="form-control toka_textfelder" placeholder="Strasse" name="strasse"></br>
					<input pattern="[a-zA-Z&ouml&Ouml&uuml&Uuml&auml&Auml&szlig]*([ ][a-zA-Z&ouml&Ouml&uuml&Uuml&auml&Auml&szlig]+)*" title="Bitte nur Buchstaben" class="form-control toka_textfelder" placeholder="Ort" name="ort"></br>
					<input pattern="[0-9]"""),format.raw/*63.27*/("""{"""),format.raw/*63.28*/("""5"""),format.raw/*63.29*/("""}"""),format.raw/*63.30*/("""" title="fünfstellige Postleitzahl" class="form-control toka_textfelder" placeholder="Postleitzahl" name="plz"></br>
					<input pattern="[a-zA-Z&ouml&Ouml&uuml&Uuml&auml&Auml&szlig]*([ ][a-zA-Z&ouml&Ouml&uuml&Uuml&auml&Auml&szlig]+)*" title="Bitte nur Buchstaben" class="form-control toka_textfelder" placeholder="Land" name="land"></br>
					<input class="form-control toka_textfelder" placeholder="Passwort" type="password" name="passwort" required="required" id="pw"></br>
					<input class="form-control toka_textfelder" placeholder="Passwort wiederholen" type="password" name="passwort_wdh" required="required" onblur="passwortCheck()" id="pw_wdh"></br>
					<input class="form-control toka_textfelder" placeholder="eMail" type="text" name="email" required="required"></br>
					<p><a href=# data-toggle="modal" data-target="#agbModal">AGB's</a> akzeptieren</p>
					<label for="akzeptiert">stimme zu</label>
					<input type="checkbox" name="agb" id="akzeptiert" value="akzeptiert" required="required">
					<!-- Modal -->
					<div class="modal fade" id="agbModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
					  <div class="modal-dialog">
					    <div class="modal-content">
					      <div class="modal-header">
					        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
					        <h4 class="modal-title" id="myModalLabel">ToKa AGBs</h4>
					      </div>
					      <div class="modal-body">
							<h1>AGBs</h1>
							<div class="toka_paragraph"></div>
							<p><i>Unsere Seite dient ausschließlich als Informationsquelle für die bessere Planungsentscheidung Ihres nächsten Hotelbesuches. Innerhalb unserer Web-Präsenz kommt es zu keinem Zeitpunkt zu einem Vertragsabschluss. <br/>
							AGBs sind in diesem Sinne keine definiert.</i></p>
					      </div>
					      <div class="modal-footer">
					        <button type="button" class="btn btn-default" data-dismiss="modal">Schließen</button>
					      </div>
					    </div>
					  </div>
					</div>
				  	</br>      
					<button type="submit" class="btn btn-default">Abschicken</button>
				</div>
		</div>
	</div>
	<div class="col-md-2"></div>
	<div class="col-md-6">
		<div class="container-fluid">
			<img src="""),_display_(/*99.14*/routes/*99.20*/.Assets.at("images/platzhalter.jpg")),format.raw/*99.56*/(""" """),format.raw/*99.57*/("""alt="Profilbild">
			<input name="picture" type="file" size="50" accept="jpg/*" id="upload">
			<div class="row">
					<div class="col-md-12" id="preview">
						<div class="container-fluid" >
						<!-- Hier erscheinen die Vorschaubilder -->
						</div>
					</div>
			</div>
		</div>
	</div>
	</form>
</div>
""")))}))}
  }

  def render(userVorname:String,emailPar:Int,loginStatusCode:String): play.twirl.api.HtmlFormat.Appendable = apply(userVorname,emailPar,loginStatusCode)

  def f:((String,Int,String) => play.twirl.api.HtmlFormat.Appendable) = (userVorname,emailPar,loginStatusCode) => apply(userVorname,emailPar,loginStatusCode)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Mon Jan 12 13:53:12 CET 2015
                  SOURCE: D:/01 HTWG/04 Semester/02 Projekte/ToKa_Hotel-Bewertungsportal/Toka_Hotel-Bewertungsportal_Final_pstmt_design/app/views/registration.scala.html
                  HASH: 07292f00253c13f110f7e772a823f94ac6f44e1f
                  MATRIX: 741->1|890->62|918->65|946->85|967->98|981->104|1020->106|1048->108|1155->190|1180->207|1218->208|1250->214|1446->381|1478->387|1504->404|1543->405|1576->411|1740->545|1772->551|1808->578|1848->580|1881->586|2077->752|2109->757|3612->2232|3641->2233|3677->2242|3849->2386|3878->2387|3915->2397|3959->2413|3988->2414|4027->2425|4196->2567|4225->2568|4261->2577|4291->2579|4320->2580|4356->2589|4384->2590|4418->2597|4963->3114|4992->3115|5021->3116|5050->3117|7419->5459|7434->5465|7491->5501|7520->5502
                  LINES: 26->1|29->1|30->2|30->2|30->2|30->2|30->2|31->3|34->6|34->6|34->6|35->7|37->9|38->10|38->10|38->10|39->11|41->13|42->14|42->14|42->14|43->15|45->17|46->18|75->47|75->47|76->48|79->51|79->51|80->52|80->52|80->52|81->53|83->55|83->55|84->56|84->56|84->56|86->58|86->58|87->59|91->63|91->63|91->63|91->63|127->99|127->99|127->99|127->99
                  -- GENERATED --
              */
          