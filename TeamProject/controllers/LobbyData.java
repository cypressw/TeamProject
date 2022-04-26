package controllers;

import java.io.*;

import database.Game;

public class LobbyData implements Serializable{
	private String username;
	private String chosenGame;
	
	public LobbyData(String user, String game) {
		setUsername(user);
		setChosenGame(game);
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getChosenGame() {
		return chosenGame;
	}

	public void setChosenGame(String chosenGame) {
		this.chosenGame = chosenGame;
	}
	
}
