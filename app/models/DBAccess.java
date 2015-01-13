package models;

import java.sql.*;
import play.db.*;


public class DBAccess {

	// Variable zum Aufbau & Verwaltung der Connection
	private static Connection tokaConnection = null;

	// String, der Pfad zur ToKa-Datenbank beinhaltet
	//private static final String DB_CONNPARAMSTRING = "jdbc:sqlite:D:/01 HTWG/04 Semester/02 Projekte/ToKa_Hotel-Bewertungsportal/Toka_Hotel-Bewertungsportal/app/db/database";

	public static Connection getConnection() throws SQLException {
		try {
			//SQLite-Treiber registrieren
			Class.forName("org.sqlite.JDBC");
			//Verbindung herstellen
			//tokaConnection = DriverManager.getConnection(DB_CONNPARAMSTRING);
			tokaConnection = DB.getConnection();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("Datenbankverbindung erfolgreich hergestellt");
		return tokaConnection;
	}
}
