package controllers;

import java.io.*;

public class AwaitOpponentData implements Serializable{
	private String gameID;
	private String username;
	private String status;
	
	public AwaitOpponentData(String user, String gameID) {
		setGameID(gameID);
		setUsername(user);
	}
	
	public void setGameID(String id) {
		gameID = id;
	}
	
	public String getGameID() {
		return gameID;
	}
	
	public void setUsername(String user) {
		username = user;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getStatus() {
		return status;
	}
}
