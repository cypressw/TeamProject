package controllers;

import java.io.*;

import database.Game;
import database.Player;

public class LobbyData implements Serializable{
	private String username;
	private String command;
	private Player player;
	
	public LobbyData(String user, String command) {
		setUsername(user);
		setCommand(command);
//		setChosenGame(game);
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public String getCommand() {
		return command;
	}

	public void setCommand(String command) {
		this.command = command;
	}
	
}
