
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
object main extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template4[String,String,String,Html,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(title: String)(userVorname: String)(loginStatusCode: String)(content: Html):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.78*/("""

"""),format.raw/*3.1*/("""<!DOCTYPE html>

<html>
    <head>
        <title>"""),_display_(/*7.17*/title),format.raw/*7.22*/("""</title>
		<meta charset="utf-8"/>

		<!-- jQuery Kay 19.12.2014-->
       	<!-- <link href="http://code.jquery.com/ui/1.10.4/themes/ui-lightness/jquery-ui.css" rel="stylesheet"> -->
        <!-- <script src="http://code.jquery.com/jquery-1.10.2.js"></script>-->
        <!-- <script src="http://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>-->  
	    
	    <!-- jQuery Kay 26.12.2014-->
	    <link rel="stylesheet" type="text/css" href="""),_display_(/*16.51*/routes/*16.57*/.Assets.at("stylesheets/jquery_1.10.4.css")),format.raw/*16.100*/(""">
	    <script type="text/javascript" src="""),_display_(/*17.42*/routes/*17.48*/.Assets.at("jquery/jquery_1.10.2.js")),format.raw/*17.85*/("""></script>
	    <script type="text/javascript" src="""),_display_(/*18.42*/routes/*18.48*/.Assets.at("jquery/jqueryui_1.10.4.js")),format.raw/*18.87*/("""></script>

		<!-- Styles -->
        <link rel="stylesheet" type="text/css" href="""),_display_(/*21.54*/routes/*21.60*/.Assets.at("stylesheets/bootstrap.css")),format.raw/*21.99*/(""">
		<!-- <link rel="stylesheet" type="text/css" href="""),_display_(/*22.53*/routes/*22.59*/.Assets.at("stylesheets/bootstrap-theme.css")),format.raw/*22.104*/("""> -->
		<link rel="stylesheet" type="text/css" href="""),_display_(/*23.48*/routes/*23.54*/.Assets.at("stylesheets/toka_style.css")),format.raw/*23.94*/(""">
		
		<!-- JavaScript -->
		<script type="text/javascript" src="""),_display_(/*26.39*/routes/*26.45*/.Assets.at("javascripts/bootstrap.js")),format.raw/*26.83*/("""></script>
		
		<!-- Application specific -->
		<link rel="shortcut icon" type="image/png" href="""),_display_(/*29.52*/routes/*29.58*/.Assets.at("images/favicon.png")),format.raw/*29.90*/(""">
        
        <!-- Star-Rating -->
        <link rel="stylesheet" type="text/css" href="""),_display_(/*32.54*/routes/*32.60*/.Assets.at("star-rating/stylesheet.css")),format.raw/*32.100*/(""">
        
        <link href="""),_display_(/*34.21*/routes/*34.27*/.Assets.at("star-rating/star-rating.css")),format.raw/*34.68*/(""" """),format.raw/*34.69*/("""media="all" rel="stylesheet" type="text/css"/>
        <script src="""),_display_(/*35.22*/routes/*35.28*/.Assets.at("star-rating/star-rating.js")),format.raw/*35.68*/(""" """),format.raw/*35.69*/("""type="text/javascript"></script>

        <script>
        function vorschlag() """),format.raw/*38.30*/("""{"""),format.raw/*38.31*/("""
            """),format.raw/*39.13*/("""var eingabe = document.getElementById("suche");
            var url = "ajax_complete?hotel=" + escape(eingabe.value);
            var req;
            if (window.XMLHttpRequest) """),format.raw/*42.40*/("""{"""),format.raw/*42.41*/("""
                """),format.raw/*43.17*/("""req = new XMLHttpRequest();
            """),format.raw/*44.13*/("""}"""),format.raw/*44.14*/(""" """),format.raw/*44.15*/("""else if (window.ActiveXObject) """),format.raw/*44.46*/("""{"""),format.raw/*44.47*/("""
                """),format.raw/*45.17*/("""req = new ActiveXObject("Microsoft.XMLHTTP");
            """),format.raw/*46.13*/("""}"""),format.raw/*46.14*/("""
            """),format.raw/*47.13*/("""req.onreadystatechange = function() """),format.raw/*47.49*/("""{"""),format.raw/*47.50*/("""
                """),format.raw/*48.17*/("""if (req.readyState == 4) """),format.raw/*48.42*/("""{"""),format.raw/*48.43*/("""
                    """),format.raw/*49.21*/("""if (req.status == 200) """),format.raw/*49.44*/("""{"""),format.raw/*49.45*/("""
                        """),format.raw/*50.25*/("""var ergebnis = req.responseText;
                        auswahlarray = ergebnis.split( ";" );
                        $("#suche").autocomplete("""),format.raw/*52.50*/("""{"""),format.raw/*52.51*/("""source: auswahlarray"""),format.raw/*52.71*/("""}"""),format.raw/*52.72*/(""");
                    """),format.raw/*53.21*/("""}"""),format.raw/*53.22*/("""
                """),format.raw/*54.17*/("""}"""),format.raw/*54.18*/("""
            """),format.raw/*55.13*/("""}"""),format.raw/*55.14*/(""";
            req.open("GET", url, true);
            req.send(null);
        """),format.raw/*58.9*/("""}"""),format.raw/*58.10*/("""
        """),format.raw/*59.9*/("""</script>

    </head>
   	<body>
		<div id="toka_siteWrapper">
			<div class="toka_wrapper">
				<header id="toka_header">
                	<div class = "navbar navbar-inverse navbar-static-top">
                    	<div class = "container-fluid">
                        	<div class = "navbar-brand">
                           		<a href = "index.scala.html" ><img src="""),_display_(/*69.70*/routes/*69.76*/.Assets.at("images/logo.jpg")),format.raw/*69.105*/("""></a>
                            	<button class = "navbar-toggle" data-toggle = "collapse" data-target = ".navHeaderCollapse">
                                	<span class = "icon-bar"></span>
                                	<span class = "icon-bar"></span>
                                	<span class = "icon-bar"></span>
                            	</button>
                        	</div>
                        	<div class = "collapse navbar-collapse navHeaderCollapse">
                            	<ul class = "nav navbar-nav toka_navbar-center">
	                                <li><a href = "index.scala.html">Home</a></li>
                                	<li><a href = "/results_hotel_headerSearch?hotel=">Hotels</a></li>
                                	<li><a href = "rate_hotel.scala.html">Bewerten</a></li>                        
                            	</ul>
                            	<div class = "nav navbar-nav navbar-right">
	                                <div class="toka_headerLinks">
                                        """),_display_(/*84.42*/if(!userVorname.equals("Gast"))/*84.73*/{_display_(Seq[Any](format.raw/*84.74*/("""
                                            """),format.raw/*85.45*/("""<h4>Hallo <a href="profile.scala.html">"""),_display_(/*85.85*/userVorname),format.raw/*85.96*/("""</a></h4>
                                        """)))}),format.raw/*86.42*/(""" 
    	                                	"""),_display_(/*87.40*/if(userVorname.equals("Gast"))/*87.70*/{_display_(Seq[Any](format.raw/*87.71*/("""
                                             """),format.raw/*88.46*/("""<h4>Hallo Gast</h4>
 			                                   	<a href="#" data-toggle="modal" data-target="#myModal">anmelden |</a>
                                    			<a href="registration.scala.html">registrieren</a>
                                    		""")))}/*91.41*/else/*91.46*/{_display_(Seq[Any](format.raw/*91.47*/("""
                                    			"""),format.raw/*92.40*/("""<a href="logout">Logout</a>
                                    		""")))}),format.raw/*93.40*/("""
                                	"""),format.raw/*94.34*/("""</div>                             	     	
                            		<div>
                                		<form class="form-inline" role="search" method="GET" action="results_hotel_headerSearch">
                                			<div class="form-group toka_headerSearch">
                                    			<input pattern="[a-zA-ZöÖüÜäÄß]*" title="Bitte nur Buchstaben" class="form-control" placeholder="Hotel Suchen" name="hotel" id="suche" onkeyup="vorschlag()">
                                    			<button type="submit" class="btn btn-default">suchen</button>                                               
												"""),_display_(/*100.14*/if(loginStatusCode == "0")/*100.40*/{_display_(Seq[Any](format.raw/*100.41*/("""
													"""),format.raw/*101.14*/("""<div class="alert toka_alert-danger" role="alert">Falsches Passwort!</div>
												""")))}),format.raw/*102.14*/("""
                                			"""),format.raw/*103.36*/("""</div>
                                		</form>
                            		</div>
                            	</div>
                        	</div>
                    	</div>
                	</div>    
        		</header>
                <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                    <div class="modal-dialog modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                                <h4 class="modal-title" id="myModalLabel">Anmelden</h4>
                            </div>
                            <div class="modal-body">
                                <form role="form" action="checkLogin" method="POST">
                                    <input placeholder="eMail" type="email" name="email" class="form-control" autofocus>
                                    <input placeholder="Passwort" type="password" name="password" class="form-control">
                                    <a href="registration.scala.html">Keinen Account?</a>                                                                   
                            </div>
                            <div class="modal-footer">
                                <button type="submit" class="btn btn-default">anmelden</button>
                                <button type="button" class="btn btn-default" data-dismiss="modal">schließen</button>                                        
                            </div>
                                </form>
                        </div>
                    </div>
                </div>
				
        		"""),_display_(/*133.12*/content),format.raw/*133.19*/("""

                """),format.raw/*135.17*/("""<footer id="toka_footer">
                    <div id="toka_footerBorder"></div>
                        <div class="container-fluid">
                            <div class="row">
                                <div class="col-md-8">
                                    <div id="toka_footerLeft">
                                        <a href="impressum.scala.html">Impressum</a> | <a href="contact.scala.html">Kontakt</a> | <a href="agbs.scala.html">AGBs</a>
                                    </div>
                                </div>
                                <div class="col-md-4">
                                    <div id="toka_footerRight">
                                        <a target="_blank" href="http://facebook.de"><i>follow us on</i> <img src="""),_display_(/*146.116*/routes/*146.122*/.Assets.at("images/facebook-icon.png")),format.raw/*146.160*/("""></a>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-8">
                                    <div id="toka_footerBottom">
                                        ToKa GmbH © 2014. All Rights Reserved.
                                    </div>
                                </div>
                            </div>
                        </div>
                </footer>
            </div>
        </div>	
    </body>
</html>
"""))}
  }

  def render(title:String,userVorname:String,loginStatusCode:String,content:Html): play.twirl.api.HtmlFormat.Appendable = apply(title)(userVorname)(loginStatusCode)(content)

  def f:((String) => (String) => (String) => (Html) => play.twirl.api.HtmlFormat.Appendable) = (title) => (userVorname) => (loginStatusCode) => (content) => apply(title)(userVorname)(loginStatusCode)(content)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Mon Jan 12 13:53:12 CET 2015
                  SOURCE: D:/01 HTWG/04 Semester/02 Projekte/ToKa_Hotel-Bewertungsportal/Toka_Hotel-Bewertungsportal_Final_pstmt_design/app/views/main.scala.html
                  HASH: 96e95f5445d243c30540a2046975a9304d0b25ae
                  MATRIX: 741->1|905->77|935->81|1016->136|1041->141|1519->592|1534->598|1599->641|1670->685|1685->691|1743->728|1823->781|1838->787|1898->826|2011->912|2026->918|2086->957|2168->1012|2183->1018|2250->1063|2331->1117|2346->1123|2407->1163|2502->1231|2517->1237|2576->1275|2703->1375|2718->1381|2771->1413|2894->1509|2909->1515|2971->1555|3031->1588|3046->1594|3108->1635|3137->1636|3233->1705|3248->1711|3309->1751|3338->1752|3449->1835|3478->1836|3520->1850|3729->2031|3758->2032|3804->2050|3873->2091|3902->2092|3931->2093|3990->2124|4019->2125|4065->2143|4152->2202|4181->2203|4223->2217|4287->2253|4316->2254|4362->2272|4415->2297|4444->2298|4494->2320|4545->2343|4574->2344|4628->2370|4802->2516|4831->2517|4879->2537|4908->2538|4960->2562|4989->2563|5035->2581|5064->2582|5106->2596|5135->2597|5243->2678|5272->2679|5309->2689|5719->3072|5734->3078|5785->3107|6892->4187|6932->4218|6971->4219|7045->4265|7112->4305|7144->4316|7227->4368|7296->4410|7335->4440|7374->4441|7449->4488|7730->4751|7743->4756|7782->4757|7851->4798|7950->4866|8013->4901|8686->5546|8722->5572|8762->5573|8806->5588|8927->5677|8993->5714|10927->7620|10956->7627|11005->7647|11825->8438|11842->8444|11903->8482
                  LINES: 26->1|29->1|31->3|35->7|35->7|44->16|44->16|44->16|45->17|45->17|45->17|46->18|46->18|46->18|49->21|49->21|49->21|50->22|50->22|50->22|51->23|51->23|51->23|54->26|54->26|54->26|57->29|57->29|57->29|60->32|60->32|60->32|62->34|62->34|62->34|62->34|63->35|63->35|63->35|63->35|66->38|66->38|67->39|70->42|70->42|71->43|72->44|72->44|72->44|72->44|72->44|73->45|74->46|74->46|75->47|75->47|75->47|76->48|76->48|76->48|77->49|77->49|77->49|78->50|80->52|80->52|80->52|80->52|81->53|81->53|82->54|82->54|83->55|83->55|86->58|86->58|87->59|97->69|97->69|97->69|112->84|112->84|112->84|113->85|113->85|113->85|114->86|115->87|115->87|115->87|116->88|119->91|119->91|119->91|120->92|121->93|122->94|128->100|128->100|128->100|129->101|130->102|131->103|161->133|161->133|163->135|174->146|174->146|174->146
                  -- GENERATED --
              */
          