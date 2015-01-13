
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
object profile extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template7[String,String,String,String,String,String,String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(userVorname: String, userNachname: String, userEmail: String, userGeschlecht: String, userFamilienstand: String, userGeburtstag: String, userPic: String):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.156*/("""
"""),_display_(/*2.2*/main("Profil")/*2.16*/(userVorname)/*2.29*/("2")/*2.34*/ {_display_(Seq[Any](format.raw/*2.36*/("""
"""),_display_(/*3.2*/if(userVorname.equals("Gast"))/*3.32*/ {_display_(Seq[Any](format.raw/*3.34*/("""
  """),format.raw/*4.3*/("""<div class="row">
    <div class="col-md-12">
      <div class="container-fluid">
				<h3>Loggen Sie sich ein, um auf Ihr Profil zugreifen zu können - <small> Jetzt <a href="#" data-toggle="modal" data-target="#myModal">anmelden</a></small>
      </div>
    </div>
  </div>
	""")))}/*11.4*/else/*11.9*/{_display_(Seq[Any](format.raw/*11.10*/("""
  """),format.raw/*12.3*/("""<div class="row">
    <div class="col-md-12">
      <div class="container-fluid">
		     <h1>Profil</h1>
         <div class="toka_paragraph"></div>
      </div>
    </div>
  </div>
  <div class="row">
    <div class="col-md-4">
      <div class="container-fluid">
		     <p>Vorname: """),_display_(/*23.21*/userVorname),format.raw/*23.32*/("""</p>
		     <p>Nachname: """),_display_(/*24.22*/userNachname),format.raw/*24.34*/("""</p>
		     <p>eMail: """),_display_(/*25.19*/userEmail),format.raw/*25.28*/("""</p>
		     <p>Geschlecht: """),_display_(/*26.24*/userGeschlecht),format.raw/*26.38*/("""</p>
		     <p>Familienstand: """),_display_(/*27.27*/userFamilienstand),format.raw/*27.44*/("""</p>
		     <p>Geburtstag: """),_display_(/*28.24*/userGeburtstag),format.raw/*28.38*/("""</p>
	    </div>
    </div>
    """),_display_(/*31.6*/if(userPic.equals("null"))/*31.32*/{_display_(Seq[Any](format.raw/*31.33*/("""
      """),format.raw/*32.7*/("""<div class="col-md-8">
        <div class="container-fluid">
          <h4><i>Es ist kein Userbild vorhanden!</i></h4>
        </div>
      </div>
      """)))}/*37.9*/else/*37.14*/{_display_(Seq[Any](format.raw/*37.15*/("""
        """),format.raw/*38.9*/("""<div class="col-md-8">
          <div class="container-fluid">
            <img src="""),_display_(/*40.23*/userPic),format.raw/*40.30*/(""" """),format.raw/*40.31*/("""alt="Profilbild"  width = "220" height = "250"><br/>
          </div>
        </div>
      """)))}),format.raw/*43.8*/("""
    """)))}),format.raw/*44.6*/("""
  """),format.raw/*45.3*/("""</div>
""")))}))}
  }

  def render(userVorname:String,userNachname:String,userEmail:String,userGeschlecht:String,userFamilienstand:String,userGeburtstag:String,userPic:String): play.twirl.api.HtmlFormat.Appendable = apply(userVorname,userNachname,userEmail,userGeschlecht,userFamilienstand,userGeburtstag,userPic)

  def f:((String,String,String,String,String,String,String) => play.twirl.api.HtmlFormat.Appendable) = (userVorname,userNachname,userEmail,userGeschlecht,userFamilienstand,userGeburtstag,userPic) => apply(userVorname,userNachname,userEmail,userGeschlecht,userFamilienstand,userGeburtstag,userPic)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Mon Jan 12 13:53:12 CET 2015
                  SOURCE: D:/01 HTWG/04 Semester/02 Projekte/ToKa_Hotel-Bewertungsportal/Toka_Hotel-Bewertungsportal_Final_pstmt_design/app/views/profile.scala.html
                  HASH: e6626ab84c0b22e2e9c5ff90720128989bf67910
                  MATRIX: 767->1|1010->155|1038->158|1060->172|1081->185|1094->190|1133->192|1161->195|1199->225|1238->227|1268->231|1569->515|1581->520|1620->521|1651->525|1974->821|2006->832|2060->859|2093->871|2144->895|2174->904|2230->933|2265->947|2324->979|2362->996|2418->1025|2453->1039|2515->1075|2550->1101|2589->1102|2624->1110|2801->1270|2814->1275|2853->1276|2890->1286|3004->1373|3032->1380|3061->1381|3186->1476|3223->1483|3254->1487
                  LINES: 26->1|29->1|30->2|30->2|30->2|30->2|30->2|31->3|31->3|31->3|32->4|39->11|39->11|39->11|40->12|51->23|51->23|52->24|52->24|53->25|53->25|54->26|54->26|55->27|55->27|56->28|56->28|59->31|59->31|59->31|60->32|65->37|65->37|65->37|66->38|68->40|68->40|68->40|71->43|72->44|73->45
                  -- GENERATED --
              */
          