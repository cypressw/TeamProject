package controllers;

import database.Player;
import gamedetails.Space;

public class GameplayData {
	private Space guess;
	private Player player;
	private String status;
	private String gameID;
	
	public GameplayData(Space guess, Player p, String status, String id) {
		setPlayer(p);
		setGuess(guess);
		setStatus(status);
		setGameID(id);
	}
	
	public void setPlayer(Player user) {
		player = user;
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setGameID(String id) {
		gameID = id;
	}
	
	public String getGameID() {
		return gameID;
	}
	
	public void setGuess(Space guess) {
		this.guess = guess;
	}
	
	public Space getGuess() {
		return guess;
	}
}
