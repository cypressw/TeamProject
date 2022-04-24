package controllers;

import database.Player;

public class WinLoseData {
	private Player winner;
	private Player loser;
	
	public WinLoseData(Player win, Player lose) {
		setWinner(win);
		setLoser(lose);
	}

	public Player getWinner() {
		return winner;
	}

	public void setWinner(Player winner) {
		this.winner = winner;
	}

	public Player getLoser() {
		return loser;
	}

	public void setLoser(Player loser) {
		this.loser = loser;
	}
	
}
