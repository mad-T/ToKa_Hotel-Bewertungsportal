Projektdokumentation Web-Technologie
===============
---------------

Gruppe 3 | |
:-----------|:------------|
 *Projekt*: | ToKa Hotel-Bewertungsportal |
 *Bearbeiter*: | Kay Gamito & Tobias Spott |

-------------

Projektname
-------------
ToKa-Hotelbewertungsportal

Projektbeschreibung
-------------
In diesem Projekt wurde ein Hotel-Bewertungsportal umgesetzt. Wie der Name es schon erahnen lässt, hat der User die Möglichkeit, sich für ein Hotel zu entscheiden, um dieses zu bewerten.

Projektstart
-------------
Zur Umsetzung des Projekts sollen folgende Technologien zum Einsatz kommen:
+ HTML(5), CSS (Bootstrap), Java, Javascript / jQuery, SQL, Patterns (Singleton, MVC, Observer/Observable), AJAX, Websockets, JSON, Hashing
+ SQLite als relationale Datenbank
+ Play als Fundament für das komplette Projekt , GIT für die Codeversionierung

##### 1. Anforderungsanalyse
###### Funktional
+ Anmelden / Registrieren
+ Profil anzeigen
+ Hotel suchen
+ Hotel bewerten
+ Ermitteln & anzeigen beste Hotels <Jahr> (average stars)
+ Ermitteln & anzeigen letzten 3 Bewertungen

###### Nicht-Funktionale
+ Slideshow für Anzeige beste Hotels <Jahr>

###### Use-Case
![Use-Case]
(https://github.com/toka-htwg/ToKa_Hotel-Bewertungsportal/blob/master/public/images/dokumentation/use_case.JPG)

##### 2. Architektur

###### UML
![UML]
(https://github.com/toka-htwg/ToKa_Hotel-Bewertungsportal/blob/master/public/images/dokumentation/klassendiagramm.jpg)

###### ERM
![ERM]
(https://github.com/toka-htwg/ToKa_Hotel-Bewertungsportal/blob/master/public/images/dokumentation/erm.JPG)

##### 3. Erste Ideen
###### Mock-Ups
![Index-Seite]
(https://github.com/toka-htwg/ToKa_Hotel-Bewertungsportal/blob/master/public/images/dokumentation/mockup_index.jpg)

![Bewertungs-Seite]
(https://github.com/toka-htwg/ToKa_Hotel-Bewertungsportal/blob/master/public/images/dokumentation/mockup_bewertung.jpg)

Umsetzung
----------
###### HTML(5)
HTML ist eine Sprache um Webseiten zu strukturieren. HTML5 ist eine neue Version die zusätzliche Funktionen bietet. Unter anderem wurde das Tag „pattern“ verwendet, um bei der Registrierung Eingabewerte einzuschränken. Während der Hotelbewertung wurde der Tag „multiple“ verwendet um es zu ermöglichen, dass mehrere Bilder hochgeladen werden können.
+	u.a registration.scala.html (pattern); 
+	rate_hotel.scala.html (date, multiple, email)

###### CSS / Bootstrap / Responsive
CSS ist eine Gestaltungssprache. Hiermit kann man das Design von HTML Seiten auslagern und anpassen. Bootstrap ist in diesem Zusammenhang ein Framework, welches vordefinierte Gestaltungsmöglichkeiten für HTML und CSS bietet. Eingesetzt wurden CSS und Bootstrap auf jeder HTML Seite. Hiermit wurde das komplette Projekt gestaltet und vor allem auf Responsive Webdesign wertgelegt. Weiterhin wurde CSS verwendet, um auf der Bewertungsseite Sonnen als Bewertungsskala zu erzeugen.

###### Play / MVC
Play ist ein vollständiges MVC Framework. Es bietet die Möglich Webprojekte zu implementieren, indem Models, Views, Controller, Konfigurationen usw. klar voneinander getrennt gepflegt werden können. Das Play Framework wurde während des kompletten Projektes durchgängig für sämtliche Implementierungen, die mit JAVA realisiert wurden verwendet. 

###### Scala
Scala bietet die Möglichkeit Variablen, welche an HTML Seiten übergeben werden auszulesen und einfache Logik in einer HTML Seite zu nutzen. Beispielweise wurde bei der Registrierung geprüft ob ein User angelegt wurde oder ob dieser bereits vorhanden ist. Bei den Ergebnissen einer Hotelsuche dagegen wurde Scala verwendet um über die Ergebnis zu iterieren. Weiterhin wurde fast auf jeder Seite eine Variable ausgelesen.
+	result_search_hotel.scala.htlm (@for(hotel <- hotels) )
+	registration.scala.html (@if(emailPar == 1) bzw @if(emailPar == 2)…)

###### SQLite / SQL
SQLite bietet die Möglichkeit, ein relationales Datenbanksystem zu erstellen und zu verwalten. SQLite wurde in das Projekt integriert um sämtliche Daten wie z.B. Hoteldaten, Userdaten, Bewertungen usw. zu verwalten.

###### JavaScript / jQuery
Durch JavaScript wird es ermöglicht, interaktive Handlungen innerhalb einer HTML vorzunehmen.  JQuery ist eine dazu vordefinierte Java-Script-Bibliothek, die verschiedene Funktionen anbietet. In diesem Projekt wurde JQuery verwendet, um eine Bildvorschau zu erstellen wenn Bilder bei der Registrierung bzw. der Bewertung eines Hotels hochgeladen werden. JavaScript wurde verwendet, um die Felder Passwort und Passwort wiederholen nach der Eingabe auf Gleichheit zu überprüfen. JavaScript wurde außerdem für die Sonnen-Bewertungsskala eingesetzt.
+ rate_Hotel.scala.html 
++	$('#upload').change(function(e))
++ function previewImage(e)
++	function sterneAusgeben(wert)
+ registration.scala.html(function passwortCheck())

###### Ajax
Ajax bietet die Möglichkeit, Inhalte auf einer HTML Seite zu ändern, ohne die komplette Seite aktualisieren zu müssen. Diese Technologie wurde eingesetzt um in der Schnellsuche der Hotels, eine automatische Vervollständigung des Suchbegriffes anzubieten. Implementiert wurde dazu an folgenden Stellen:
+	main.scala.html (function vorschlag())
+	routes (/ajax_complete)
+	Application.java(public static Result ajax_complete)
+	Model.java (public static String autoComplete)
Anmerkung: Funktioniert erst wenn der zweite Buchstabe eingegeben wird oder der Fokus erneut in die schnellsuche gesetzt wird. Wurde in der Fragestunde untersucht und besprochen.

###### Websockets / Oberserver Observable / JSON
Websockets werden verwendet um eine Kommunikation zwischen Client und Server zu ermöglichen. Benötigt der Client nun neue Infos muss keine Aktualisierung der HTLM Seite stattfinden, sondern durch die geöffnete Websocket Verbindung, werden die Informationen automatisch vom Server empfangen und verwendet. Das Oberserver Pattern ermöglicht es Objekte zu registrieren, welche dadurch ständig Informationen  erhalten wenn sich etwas ändert. Somit muss nicht jedes Objekt einzeln benachrichtigt werden, sondern es werden alle auf einmal automatisch benachrichtigt. JSON ist ein Datenformat, welches es ermöglicht, Daten ohne Probleme zwischen verschiedenen Anwendungen hin und her zu schicken.
Diese drei Technologien wurden zusammen implementiert um folgendes Szenario abzubilden:
Befinden sich mehrere User auf der Startseite der Website, erhalten diese alle Informationen drüber welche Hotels zuletzt bewertet wurden. Wird in dieser Zeit eine weitere Hotelbewertung angelegt, erhalten alle User automatisch eine Aktualisierung der kürzlich Bewerteten Hotels, ohne die Seite neu laden zu müssen.
+	Routes (/recentlyRate)
+	Index.scala.html (s. 33 – 58)
+	Rate_hotel.scala.htlm (s.167 – 178)
+	Model.java (Die Klasse Model erbt von der Klasse Observable. Weiterhin wird in der Methode createHotelRate die Methode notfiyObserver aufgerufen. In der Methode createJSON werden sämtliche Informationen der Bewertungen in eine JSON Datei geschrieben.)
+	Application (public static WebSocket<JsonNode> recentlyRate())
+	HotelObserver.java

###### SQL-Incection
Um unerwünschte Eingriffe in Bezug auf die SQLite Datenbank zu vermeiden, wurden alle Datenbankabfragen im Projekt mittels prepared Statements umgesetzt. Um (böswillige) SQL-Statements innerhalb der Inputs zu vermeiden, wurden die schon in Kapitel „HTML5“ erwähnten Patterns eingesetzt.

###### Hashing
Der Begriff Hashwert stammt aus der Kryptologie innerhalb der IT und bezeichnet einen alphanumerischen Wert. Im Projekt wird der Hashwert verwendet, um Passwörter der User in der Datenbank abzulegen. Einem Unbefugten ist es somit nicht möglich, durch Blick auf die Datenbank, Passwörter zu missbrauchen.

###### Deployment (Heroku)
Mit Heroku hat man die Möglichkeit, mittels DynDNS sein Projekt im Internet zugänglich zu machen. Grob gesagt benötigt man für ein erfolgreiches Deployment einen validen GIT Master-Branch, der für das Deployment auf Heroku verwendet wird. Nach erfolgreichem Deployment ist die eigene Web-Applikation über eine DNS erreichbar.

Link - [Toka Hotelbewertungsportal](http://toka-hotelbewertung.herokuapp.com)

> Hinweis: über https:// funktionieren die Websockets nicht

###### Sonstige Funktionen / wichtiger Code
Außerdem wurden zusätzlich folgende Funktionen implementiert:
+	Fileupload


> Hinweis: File-Upload über Heroku nicht möglich

+ Login
+	Hotel Bewerten (Vorbelegung, wenn expliziter Klick auf Hotel)
+	User anlegen
+	Suchfunktionen (standard, schnell, erweitert)

Fazit
---------
###### Erkenntnisgewinn
Da wir beide noch keine Erfahrung im Bereich Webentwicklung hatten, war dieses Projekt extrem lehrreich. Da wir das Projekt von der Planung, bis zum Deployment komplett selbständig bearbeitet haben wurde uns klar, was alles dazugehört. Auch der Einsatz der vielen verschiedenen Technologien erweiterte unsere Kenntnisse im Bereich Webentwicklung.

###### Probleme
Da wie bereits erwähnt keine Erfahrung vorhanden war, war es schwer den Aufwand genauer einzuschätzen. Es war nicht klar, welche Funktion wieviel Zeit in Anspruch nimmt.
Ein weiterer Punkt der etwas Schwierigkeiten bereitete, war das implementieren der Websockets / Observer Funktionalität.

Verweise
---------
###### Heroku
Link - [Toka Hotelbewertungsportal](http://toka-hotelbewertung.herokuapp.com)

> Hinweis: über https:// funktionieren die Websockets nicht
