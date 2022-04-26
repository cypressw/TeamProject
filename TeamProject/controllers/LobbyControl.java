package controllers;

import java.awt.event.*;
import java.io.IOException;
import java.util.HashMap;

import javax.swing.*;

import UI.LobbyPanel;
import database.Game;
import database.Player;

public class LobbyControl implements ActionListener {
	private JPanel container;
	private LobbyData data;
	private GameClient client;
	
	public LobbyControl(JPanel panel, GameClient client) {
		setContainer(panel);
		this.setClient(client);
	}
	
	public void displayError(String error) {
		
	}
	
	public void createNewGame() {
		
	}
	
	public void connectToGame() {
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		String command = ae.getActionCommand();
		
		if (command.equals("Join Selected")) {
			String choice = ((LobbyPanel) container).getChosenGame();
			String username = client.getPlayer().getUsername();
			data = new LobbyData(username, choice);
			
			try {
				client.sendToServer(data);
			} catch(IOException e) {
				e.printStackTrace();
			};
		}
	}
	
	public void gameConnectSuccess() {
		
	}
	
	public void gameCreateSuccess() {
		
	}

	public JPanel getContainer() {
		return container;
	}

	public void setContainer(JPanel container) {
		this.container = container;
	}

	public LobbyData getData() {
		return data;
	}

	public void setData(LobbyData data) {
		this.data = data;
	}

	public GameClient getClient() {
		return client;
	}

	public void setClient(GameClient client) {
		this.client = client;
	}
	
	public void displayOnlineGames(HashMap<Player, Game> games) {
		for (Player p : games.keySet()) {
			((LobbyPanel) container).addToGamesList(p.getUsername());
		}
	}
}
