package controllers;

import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import models.Model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import play.mvc.WebSocket;

public class HotelObserver implements Observer {
	Object varNull = null;
	public WebSocket.Out<JsonNode> hotel;
	
	public HotelObserver(){
		Model.sharedInstance.addObserver(this);
	}

	@Override
	public void update(Observable arg0, Object varNull) {
		System.out.println("update von HotelObserver wird aufgerufen");
		hotel.write(Model.sharedInstance.createJSON());
	}
}
