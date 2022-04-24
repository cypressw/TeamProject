package controllers;

import gamedetails.Board;

public class BoardSetupData {
	private Board board;
	private String gameID;
	
	public BoardSetupData(Board b, String id) {
		setBoard(b);
		setGameID(id);
	}
	
	public void setBoard(Board b) {
		board = b;
	}
	
	public Board getBoard() {
		return board;
	}
	
	public void setGameID(String id) {
		gameID = id;
	}
	
	public String getGameID() {
		return gameID;
	}
}
