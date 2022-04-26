package database;

import gamedetails.Board;

public class Game {
	private Player player1;
	private Player player2;
	private Board board1;
	private Board board2;
	private String status;
	private Player activePlayer;
	
	public Game() {
		player1 = null;
		player2 = null;
		board1 = null;
		board2 = null;
	}
	
	public Game(Player p1, Player p2, Board b1, Board b2) {
		setPlayer(p1);
		setPlayer(p2);
	}
	
	public void setPlayer(Player player) {
		if (player1 == null) {
			player1 = player;
		}
		else if (player2 == null && player1 != null) {
			player2 = player;
		}
	}
	
	public Player getPlayer1() {
		return player1;
	}
	
	public Player getPlayer2() {
		return player2;
	}
	
	public void setBoard(Board board) {
		if (board1 == null) {
			board1 = board;
		}
		else if (board2 == null && board1 != null) {
			board2 = board;
		}
	}
	
	public Board getBoard1() {
		return board1;
	}
	
	public Board getBoard2() {
		return board2;
	}
	
	public void setStatus(String st) {
		status = st;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setActivePlayer(Player active) {
		activePlayer = active;
	}
	
	public Player getActivePlayer() {
		return activePlayer;
	}
}

