
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
object rate_hotel extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template3[String,List[models.Hotel],Int,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(userVorname: String, hotels:List[models.Hotel], validRate: Int):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.66*/("""
"""),_display_(/*2.2*/main("Bewerten")/*2.18*/(userVorname)/*2.31*/("2")/*2.36*/ {_display_(Seq[Any](format.raw/*2.38*/("""
"""),format.raw/*3.1*/("""<div class="row">
	<div class="col-md-12">
		<div class="container-fluid">
			"""),_display_(/*6.5*/if(validRate == 0)/*6.23*/{_display_(Seq[Any](format.raw/*6.24*/("""
				"""),format.raw/*7.5*/("""<div class="alert alert-danger" role="alert">Beim Anlegen Ihrer Bewertung ist leider etwas schief gegangen. Bitte versuchen Sie es erneut.</div>
				<div class="toka_paragraph"></div>
			""")))}),format.raw/*9.5*/("""
			"""),_display_(/*10.5*/if(validRate == 1)/*10.23*/{_display_(Seq[Any](format.raw/*10.24*/("""
				"""),format.raw/*11.5*/("""<div class="alert alert-success" role="alert">Ihre Bewertung wurde erfolgreich angelegt!</div>
				<div class="toka_paragraph"></div>
			""")))}),format.raw/*13.5*/("""
			"""),format.raw/*14.4*/("""<h1>Bewerten Sie Ihren Hotelbesuch</h1>
			<div class="toka_paragraph"></div>
		</div>
	</div>
</div>
<div class="row">	
	"""),_display_(/*20.3*/if(userVorname.equals("Gast"))/*20.33*/ {_display_(Seq[Any](format.raw/*20.35*/("""
		"""),format.raw/*21.3*/("""<div class="col-md-12">
			""")))}/*22.6*/else/*22.11*/{_display_(Seq[Any](format.raw/*22.12*/("""
				"""),format.raw/*23.5*/("""<div class="col-md-6">
			""")))}),format.raw/*24.5*/("""
				"""),format.raw/*25.5*/("""<div class="container-fluid">
					"""),_display_(/*26.7*/if(userVorname.equals("Gast"))/*26.37*/ {_display_(Seq[Any](format.raw/*26.39*/("""
						"""),format.raw/*27.7*/("""<h3>Loggen Sie sich ein, um Ihren letzten Hotelbesuch bewerten zu können - <small> Jetzt <a href="#" data-toggle="modal" data-target="#myModal">anmelden</a></small>
					""")))}/*28.8*/else/*28.13*/{_display_(Seq[Any](format.raw/*28.14*/("""
					"""),format.raw/*29.6*/("""<form method="POST" action="rate_hotel" enctype="multipart/form-data">
						<p>Hotel</p>
						<select class="form-control toka_textfelder" name="hotel">
							"""),_display_(/*32.9*/for(hotel <- hotels) yield /*32.29*/{_display_(Seq[Any](format.raw/*32.30*/("""
								"""),format.raw/*33.9*/("""<option value=""""),_display_(/*33.25*/hotel/*33.30*/.getName()),format.raw/*33.40*/("""">"""),_display_(/*33.43*/hotel/*33.48*/.getName()),format.raw/*33.58*/("""</option>
							""")))}),format.raw/*34.9*/("""
						"""),format.raw/*35.7*/("""</select><br/>
						<p>Art</p>
						<select class="form-control toka_textfelder" name="artUrlaub">
							<option value="F">Familien Urlaub</option>
							<option value="S">Single Urlaub</option>
							<option value="P">Party Urlaub</option>
							<option value="K">Kultur Urlaub</option>
						</select><br/>
						<p>Kindergeeignet</p>
						<select class="form-control toka_textfelder" name="kinder">
							<option value="J">Ja</option>
							<option value="N">Nein</option>
						</select><br/>
						<p>Verpflegung</p>
						<select class="form-control toka_textfelder" name="verpflegung">
							<option value="AI">All Inclusive</option>
							<option value="V">Vollpension</option>
							<option value="H">Halbpension</option>
							<option value="N">Nichts</option>
						</select><br/>
						<p>Von</p>
						<input type="date" class="form-control toka_textfelder" name="von" placeholder="von" required><br/>
						<p>Bis</p>
						<input type="date" class="form-control toka_textfelder" name="bis" placeholder="bis" required><br/>
						<p>Rating</p>
						<script>
						function sterneAusgeben(wert)"""),format.raw/*61.36*/("""{"""),format.raw/*61.37*/("""
							"""),format.raw/*62.8*/("""switch(wert) """),format.raw/*62.21*/("""{"""),format.raw/*62.22*/("""
									case 1:
										var text = "Eine Sonne";
										break;
									case 2:
										var text = "Zwei Sonnen";
										break;
									case 3:
										var text = "Drei Sonnen";
										break;
									case 4:
										var text = "Vier Sonnen";
										break;
									case 5:
										var text = "Fünf Sonnen";
										break;
								"""),format.raw/*78.9*/("""}"""),format.raw/*78.10*/("""		
						"""),format.raw/*79.7*/("""document.getElementById("sterne").innerHTML = text;
						"""),format.raw/*80.7*/("""}"""),format.raw/*80.8*/("""
						"""),format.raw/*81.7*/("""</script>
						
						<div class="starRating">
						  <div>
						    <div>
								<div>
									<div>
									  <input id="rating1" type="radio" name="rating" value="1" onclick="sterneAusgeben(1)">
									  <label for="rating1"><span>1</span></label>
									</div>
									<input id="rating2" type="radio" name="rating" value="2" onclick="sterneAusgeben(2)">
									<label for="rating2"><span>2</span></label>
								</div>
								  <input id="rating3" type="radio" name="rating" value="3" onclick="sterneAusgeben(3)">
								  <label for="rating3"><span>3</span></label>
							</div>
						    <input id="rating4" type="radio" name="rating" value="4" onclick="sterneAusgeben(4)">
						    <label for="rating4"><span>4</span></label>
						  </div>
						  <input id="rating5" type="radio" name="rating" value="5" onclick="sterneAusgeben(5)">
						  <label for="rating5"><span>5</span></label></br>
						</div>
						<div id="sterne"></div></br>
						
						<p>Kurzer Kommentar</p>
						<input type="text" class="form-control toka_textfelder" name="kurzkommentar" placeholder="gut/schlecht war ..." maxlength="35"><br/>
						<p>Beschreibung</p>
						<p><textarea class="form-control toka_textarea" name="beschreibung" placeholder="Beschreibung"  cols="100" rows="10"></textarea></p>

						<script>
						$(function() """),format.raw/*111.20*/("""{"""),format.raw/*111.21*/("""
						    """),format.raw/*112.11*/("""$('#upload').change(function(e) """),format.raw/*112.43*/("""{"""),format.raw/*112.44*/("""				    	
						        """),format.raw/*113.15*/("""// Prüfen ob die File API vorhanden ist
						        if (this.files !== 'undefined' && typeof FileReader !== 'undefined') """),format.raw/*114.84*/("""{"""),format.raw/*114.85*/("""
						            """),format.raw/*115.19*/("""// Schleife über alle gewÃ¤hlten Dateien
						            for (var f = 0; f < this.files.length; f++) """),format.raw/*116.63*/("""{"""),format.raw/*116.64*/("""
						                """),format.raw/*117.23*/("""var file = this.files[f];
						                var reader = new FileReader();
						 
						                // Prüfen, ob auch wirklich ein Bild gewählt wurde
						                if (!/image\/(jpeg|jpg|png|gif)/.test(file.type)) """),format.raw/*121.73*/("""{"""),format.raw/*121.74*/("""
						                    """),format.raw/*122.27*/("""alert('Dateityp "' + file.type + '" wird nicht unterstÃ¼tzt.');
						                    continue;
						                """),format.raw/*124.23*/("""}"""),format.raw/*124.24*/("""
						 
						                """),format.raw/*126.23*/("""// EventListener hinzufügen
						                $(reader).load(previewImage);
						 
										// Einlesen der Datei beginnen
						                reader.readAsDataURL(file);
						            """),format.raw/*131.19*/("""}"""),format.raw/*131.20*/("""
						        """),format.raw/*132.15*/("""}"""),format.raw/*132.16*/("""
						    """),format.raw/*133.11*/("""}"""),format.raw/*133.12*/(""");
						"""),format.raw/*134.7*/("""}"""),format.raw/*134.8*/(""");
						 
						// EventHandler für das onLoad-Event des FileReaders
						function previewImage(e)
						"""),format.raw/*138.7*/("""{"""),format.raw/*138.8*/("""
						    """),format.raw/*139.11*/("""var img = document.createElement('img');
						    
						 	// Bild mittels Data-URL laden
						    img.src = e.target.result;
		    				img.id = "picture";
						    img.width = "150";
						    img.height = "125";
						    var foo = document.getElementById("thumb");
						    foo.appendChild(img);
						"""),format.raw/*148.7*/("""}"""),format.raw/*148.8*/("""
						"""),format.raw/*149.7*/("""</script>

						<div class="toka_paragraph"></div>
						<input name="picture" multiple="multiple" type="file" size="50" accept="jpg/*" id="upload"></br>
						<div id="preview">
							<span id="thumb"></span>
						</div>
		        		
						<div class="toka_paragraph"></div>
						<button type="submit" class="btn btn-default" onclick="sendRecentlyRate()">Bewertung abschicken</button>
					</form>
					<script type="text/javascript">
						var webSocket;
						$(function() """),format.raw/*162.20*/("""{"""),format.raw/*162.21*/("""
							"""),format.raw/*163.8*/("""var WS = window["MozWebSocket"] ? MozWebSocket : WebSocket;
							webSocket = new WS(""""),_display_(/*164.29*/routes/*164.35*/.Application.recentlyRate().webSocketURL(request)),format.raw/*164.84*/("""");
							webSocket.onmessage = receiveEvent;
						"""),format.raw/*166.7*/("""}"""),format.raw/*166.8*/(""")
						function sendRecentlyRate() """),format.raw/*167.35*/("""{"""),format.raw/*167.36*/("""
							"""),format.raw/*168.8*/("""var test = null;
							webSocket.send(test);
						"""),format.raw/*170.7*/("""}"""),format.raw/*170.8*/(""";
					</script>
					""")))}),format.raw/*172.7*/("""
				"""),format.raw/*173.5*/("""</div>
		</div>
	"""),_display_(/*175.3*/if(!userVorname.equals("Gast"))/*175.34*/ {_display_(Seq[Any](format.raw/*175.36*/("""
	"""),format.raw/*176.2*/("""<div class="col-md-1"></div>
	<div class="col-md-4">
		<h4>
			Ist Ihr Hotel nicht dabei?<br/><small>Füllen Sie <a href="newHotel.scala.html">dieses</a> Formular aus. Nach Prüfung auf Gültigkeit wird das Hotel von einem unserer Administratoren angelegt.</small>
		</h4>
	</div>
	<div class="col-md-1"></div>
	""")))}),format.raw/*183.3*/(""" 
"""),format.raw/*184.1*/("""</div>
""")))}))}
  }

  def render(userVorname:String,hotels:List[models.Hotel],validRate:Int): play.twirl.api.HtmlFormat.Appendable = apply(userVorname,hotels,validRate)

  def f:((String,List[models.Hotel],Int) => play.twirl.api.HtmlFormat.Appendable) = (userVorname,hotels,validRate) => apply(userVorname,hotels,validRate)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Mon Jan 12 13:53:12 CET 2015
                  SOURCE: D:/01 HTWG/04 Semester/02 Projekte/ToKa_Hotel-Bewertungsportal/Toka_Hotel-Bewertungsportal_Final_pstmt_design/app/views/rate_hotel.scala.html
                  HASH: 0629673b33b25ab79196ac6222e7d54419c95069
                  MATRIX: 751->1|903->65|931->68|955->84|976->97|989->102|1028->104|1056->106|1163->188|1189->206|1227->207|1259->213|1478->403|1510->409|1537->427|1576->428|1609->434|1779->574|1811->579|1966->708|2005->738|2045->740|2076->744|2123->774|2136->779|2175->780|2208->786|2266->814|2299->820|2362->857|2401->887|2441->889|2476->897|2666->1070|2679->1075|2718->1076|2752->1083|2944->1249|2980->1269|3019->1270|3056->1280|3099->1296|3113->1301|3144->1311|3174->1314|3188->1319|3219->1329|3268->1348|3303->1356|4478->2503|4507->2504|4543->2513|4584->2526|4613->2527|5014->2901|5043->2902|5080->2912|5166->2971|5194->2972|5229->2980|6630->4352|6660->4353|6701->4365|6762->4397|6792->4398|6846->4423|6999->4547|7029->4548|7078->4568|7211->4672|7241->4673|7294->4697|7559->4933|7589->4934|7646->4962|7799->5086|7829->5087|7891->5120|8122->5322|8152->5323|8197->5339|8227->5340|8268->5352|8298->5353|8336->5363|8365->5364|8504->5475|8533->5476|8574->5488|8920->5806|8949->5807|8985->5815|9507->6308|9537->6309|9574->6318|9691->6407|9707->6413|9778->6462|9861->6517|9890->6518|9956->6555|9986->6556|10023->6565|10105->6619|10134->6620|10190->6645|10224->6651|10271->6671|10312->6702|10353->6704|10384->6707|10732->7024|10763->7027
                  LINES: 26->1|29->1|30->2|30->2|30->2|30->2|30->2|31->3|34->6|34->6|34->6|35->7|37->9|38->10|38->10|38->10|39->11|41->13|42->14|48->20|48->20|48->20|49->21|50->22|50->22|50->22|51->23|52->24|53->25|54->26|54->26|54->26|55->27|56->28|56->28|56->28|57->29|60->32|60->32|60->32|61->33|61->33|61->33|61->33|61->33|61->33|61->33|62->34|63->35|89->61|89->61|90->62|90->62|90->62|106->78|106->78|107->79|108->80|108->80|109->81|139->111|139->111|140->112|140->112|140->112|141->113|142->114|142->114|143->115|144->116|144->116|145->117|149->121|149->121|150->122|152->124|152->124|154->126|159->131|159->131|160->132|160->132|161->133|161->133|162->134|162->134|166->138|166->138|167->139|176->148|176->148|177->149|190->162|190->162|191->163|192->164|192->164|192->164|194->166|194->166|195->167|195->167|196->168|198->170|198->170|200->172|201->173|203->175|203->175|203->175|204->176|211->183|212->184
                  -- GENERATED --
              */
          