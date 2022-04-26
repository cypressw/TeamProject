package controllers;

import database.Game;
import database.Player;
import java.io.*;

import gamedetails.Board;
import gamedetails.Space;

public class GameplayData implements Serializable{
	private Space guess;
	private String status;
	private Game game;
	
	public GameplayData(Space guess, String status, Game game) {
		//setPlayer(p);
		setGuess(guess);
		setStatus(status);
		setGame(game);
	}
	
//	public void setPlayer(Player user) {
//		player = user;
//	}
//	
//	public Player getPlayer() {
//		return player;
//	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setGuess(Space guess) {
		this.guess = guess;
	}
	
	public Space getGuess() {
		return guess;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}
}
