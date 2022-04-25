package controllers;

import database.Player;
import java.io.*;

public class LogoutData implements Serializable{
	private Player player;
	private Player opponent;
	
	public LogoutData(Player p, Player o) {
		setPlayer(p);
		setOpponent(o);
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Player getOpponent() {
		return opponent;
	}

	public void setOpponent(Player opponent) {
		this.opponent = opponent;
	}
	
}
