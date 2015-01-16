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
ToKa Hotel-Bewertungsportal

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
+ Ermitteln & anzeigen beste Hotels Jahr 2015 (average stars)
+ Ermitteln & anzeigen letzten 3 Bewertungen

###### Nicht-Funktional
+ Design / Responsive
+ Slideshow für Anzeige beste Hotels Jahr 2015
+ Star-Rating (Bootstrap)

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
Im Folgenden zeigen wir 2 wichtigere Mock-Ups. Alle weiteren können in der Dropbox unter folgenden Link angeschaut werden.

Link - [Mock-Ups Dropbox](https://www.dropbox.com/s/2yw0ym3atam1f7g/hotel-rating-platform_toka.pdf?dl=0)

![Index-Seite]
(https://github.com/toka-htwg/ToKa_Hotel-Bewertungsportal/blob/master/public/images/dokumentation/mockup_index.jpg)

![Bewertungs-Seite]
(https://github.com/toka-htwg/ToKa_Hotel-Bewertungsportal/blob/master/public/images/dokumentation/mockup_bewertung.jpg)

Umsetzung
----------
###### HTML(5)
HTML ist eine Sprache, um Webseiten zu strukturieren. HTML5 ist eine neue Version die zusätzliche Funktionen bietet. In unserem Projekt wurde unter anderem der Tag „pattern“ verwendet, um bei der Registrierung Eingabewerte einzuschränken. In der Hotelbewertung wurde der Tag „multiple“ verwendet, um einen Mehrfach-Upload von Bildern zu ermöglichen.
+	u.a registration.scala.html (pattern); 
+	rate_hotel.scala.html (date, multiple, email)

###### CSS / Bootstrap / Responsive
CSS ist eine Gestaltungssprache. Hiermit kann man das Design von HTML Seiten auslagern und anpassen. Bootstrap ist in diesem Zusammenhang ein Framework, welches vordefinierte Gestaltungsmöglichkeiten bzw. Klassen/IDs für CSS bietet. Jede HTML-Seite besitzt Design-Objekte von Bootstrap, aber auch "eigenes" CSS wurde geschrieben (public/stylesheets/toka_style). Es wurde auch das GRID-System zur Layout-Gestaltung von Bootstrap verwendet. Zudem wurde selbst ein Site-Wrapper für eine schönere und übersichtlicher Optik geschrieben. Auch Repsonsive war ein Thema. Responsive beschreibt das proportionale Anpassen der Website zur aktuellen Fenstergröße. Zur Umsetzung von Responsive wurde auch auf Bootstrap-Elemente zurückgegriffen. Im Header beispielsweise werden die Listenpunkte ab einer bestimmten Größe zu einem Toggle zusammengefasst. Weitere nennenswerte Design-Objekte sind das Star-Rating auf der Bewertungseite und die Slideshow auf der Indexseite.
+ Star-Rating: rate_hotel.scala.html
+ Wrapper: main.scala.html / toka_style.css
+ Responsive: main.scala.html
+ Slideshow: index.scala.html

###### PlayFramework / MVC / Java
Java ist eine objektorientierte Programmiersprache. Algorithmen/Methoden zur Erreichung von Lösungen werden implementiert.
Play ist ein vollständiges MVC Framework. Es bietet die Möglichkeit Webprojekte zu implementieren, indem Models, Views, Controller, Konfigurationen usw. klar voneinander getrennt gepflegt und implementiert werden können. Das Framework ist also das Backend der Website. Das Play Framework wurde während des kompletten Projektes durchgängig für sämtliche Implementierungen mittels Java verwendet.
+ Play-Struktur (app/views - models - controller)

###### Scala
Scala bietet die Möglichkeit Variablen, welche an HTML Seiten übergeben werden auszulesen und einfache Logik in einer HTML Seite zu nutzen. Beispielweise wurde bei der Registrierung geprüft ob ein User angelegt wurde oder ob dieser bereits vorhanden ist. Bei den Ergebnissen einer Hotelsuche dagegen wurde Scala verwendet um über die Ergebnis zu iterieren. Weiterhin wurde fast auf jeder Seite eine Variable ausgelesen.
+	result_search_hotel.scala.htlm (@for(hotel <- hotels) )
+	registration.scala.html (@if(emailPar == 1) bzw @if(emailPar == 2)…)

###### SQLite / SQL
SQLite bietet die Möglichkeit, ein relationales Datenbanksystem zu erstellen und zu verwalten. SQLite wurde in das Projekt integriert, um sämtliche Daten wie z.B. Hoteldaten, Userdaten, Bewertungen usw. zu verwalten. Für jedes Model wurde quasi eine eigene Tabelle angelegt.

###### JavaScript / jQuery
Durch JavaScript wird es ermöglicht, interaktive Handlungen innerhalb einer HTML-Seite vorzunehmen. jQuery ist eine dazu vordefinierte JavaScript-Bibliothek, die verschiedene Funktionen anbietet. In diesem Projekt wurde jQuery verwendet, um eine Bildvorschau zu erstellen wenn Bilder bei der Registrierung bzw. der Bewertung eines Hotels hochgeladen werden. JavaScript wurde verwendet, um die Felder Passwort und Passwort wiederholen nach der Eingabe auf Gleichheit zu überprüfen.
+ rate_Hotel.scala.html 
$('#upload').change(function(e))
function previewImage(e)
+ registration.scala.html(function passwortCheck())

###### Ajax
Ajax ist eine asynchrone Datenübertragung zwischen dem Browser und dem Server. Die HTML-Seite reagiert auf Änderungen, ohne diese neu laden zu müssen. Diese Technologie wurde in unserem Projekt eingesetzt, um in der Schnellsuche der Hotels eine automatische Vervollständigung des Suchbegriffes anzubieten. Implementiert wurde dazu an folgenden Stellen:
+	main.scala.html (function vorschlag())
+	routes (/ajax_complete)
+	Application.java(public static Result ajax_complete)
+	Model.java (public static String autoComplete)

> Hinweis: Funktioniert erst, wenn der zweite Buchstabe eingegeben wird oder der Fokus erneut in die Schnellsuche gesetzt wird. Wurde in der Fragestunde untersucht und besprochen.

###### Websockets / Oberserver Observable / JSON
Websockets werden verwendet, um eine Kommunikation zwischen Client und Server zu ermöglichen. Benötigt der Client nun neue Infos, muss keine Aktualisierung der HTLM Seite stattfinden, sondern durch die geöffnete Websocket Verbindung werden die Informationen automatisch vom Server empfangen und verwendet. Das Oberserver Pattern ermöglicht es Objekte zu registrieren, welche stets bei Änderungen die aktuellen Ergebnisse erhalten. Somit muss nicht jedes Objekt einzeln benachrichtigt werden, sondern es werden alle auf einmal automatisch benachrichtigt. JSON ist ein kompaktes Datenformat und in einer einfachen Textform verpackt. Dies ermöglicht einen einfach Datenaustausch innerhalb Anwendungen.
Diese drei Technologien wurden zusammen implementiert um folgendes Szenario abzubilden:
Befinden sich mehrere User auf der Startseite der Website, erhalten diese alle Informationen darüber, welche  3 Hotels zuletzt bewertet wurden. Wird in dieser Zeit durch einen anderen User eine weitere Hotelbewertung angelegt, erhalten alle User automatisch eine Aktualisierung der kürzlich bewerteten Hotels, ohne das die Seite neu geladen werden muss.
+	Routes (/recentlyRate)
+	Index.scala.html (s. 33 – 58)
+	Rate_hotel.scala.htlm (s.167 – 178)
+	Model.java (Die Klasse Model erbt von der Klasse Observable. Weiterhin wird in der Methode createHotelRate die Methode notfiyObserver aufgerufen. In der Methode createJSON werden sämtliche Informationen der Bewertungen in eine JSON Datei geschrieben.)
+	Application (public static WebSocket<JsonNode> recentlyRate())
+	HotelObserver.java

###### SQL-Incection
Um unerwünschte Zu- und Eingriffe auf die Datenbank zu vermeiden, wurden alle Datenbankabfragen im Projekt mittels prepared Statements realisiert. Um (böswillige) SQL-Statements innerhalb der Inputs zu vermeiden, wurden die schon in Kapitel „HTML5“ erwähnten Patterns eingesetzt. Ein SQL-Statement mit seiner entsprechenden Syntax kann also erst gar nicht abgesendet werden.
+ Patterns: registration.scala.html
+ preparedStatements: model.java

###### Hashing
Der Begriff Hashwert stammt aus der Kryptologie innerhalb der IT und bezeichnet einen alphanumerischen Wert. Im Projekt wird der Hashwert verwendet, um Passwörter der User in der Datenbank abzulegen. Einem Unbefugten ist es somit nicht möglich, durch Blick auf die Datenbank, Passwörter zu missbrauchen.
+ Methode getSecurePassword(String passwordToHash): model.java


###### Deployment (Heroku)
Mit Heroku hat man die Möglichkeit, sein Projekt hosten zu lassen. Grob gesagt benötigt man für ein erfolgreiches Deployment einen validen GIT Master-Branch, der für das Deployment auf Heroku verwendet wird. Nach erfolgreichem Deployment ist die eigene Web-Applikation über eine DNS erreichbar.

Link - [Toka Hotelbewertungsportal](http://toka-hotelbewertung.herokuapp.com)

> Hinweis: über https:// funktionieren die Websockets nicht

###### Sonstige Funktionen / wichtiger Code
Außerdem wurden zusätzlich folgende Funktionen implementiert:
+	Fileupload


> Hinweis: File-Upload über Heroku nicht möglich

+ Login
+	Hotel Bewerten (Vorbelegung, wenn expliziter Klick auf Hotel)
+	User anlegen
+ Hotel Suchfunktion (standard, schnell, erweitert)

Fazit
---------
###### Erkenntnisgewinn
Da wir beide noch keine Erfahrung im Bereich Webentwicklung hatten, war dieses Projekt extrem lehrreich. Da wir das Projekt von der Planung, bis zum Deployment komplett selbständig bearbeitet haben wurde uns klar, was für die Umsetzung eines erfolgreichen Web-Projektes alles dazugehört. Fundamentales Know-How für die genannten Techniken konnten wir uns aneignen und ein Verständnis für den Einsatz vieler Technologien wurde erlangt.

###### Probleme
Da wir, wie bereits erwähnt, keine Erfahrungen im Bereich Web-Entwicklung mitbrachten, war es anfangs schwer, den Aufwand genauer einschätzen zu können. Der Zeitaufwand einzelner Funktionen wurde verkannt. Letztendlich stieg der vorerst geplante Zeitaufwand um Eingiges an.
Ein weiterer Punkt der etwas Schwierigkeiten bereitete, war das Implementieren der Websockets / Observer Funktionalität, was gegen Ende dennoch super funktionierte.

Verweise
---------
###### Heroku
Link - [Toka Hotelbewertungsportal](http://toka-hotelbewertung.herokuapp.com)

> Hinweis: über https:// funktionieren die Websockets nicht
