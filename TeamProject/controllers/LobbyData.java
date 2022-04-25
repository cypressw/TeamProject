package controllers;

import java.io.*;

public class LobbyData implements Serializable{
	private String username;
	private String chosenGameID;
	
	public LobbyData(String user, String id) {
		setUsername(user);
		setChosenGameID(id);
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getChosenGameID() {
		return chosenGameID;
	}

	public void setChosenGameID(String chosenGameID) {
		this.chosenGameID = chosenGameID;
	}
	
}
