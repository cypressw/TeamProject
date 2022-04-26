package controllers;

import java.io.*;

import database.Player;

public class AwaitOpponentData implements Serializable{
	private Player player;
	
	public AwaitOpponentData(Player user) {
		setPlayer(player);
	}

	public void setPlayer(Player player) {
		this.player = player;
	}
	
	public Player getPlayer() {
		return player;
	}
}
