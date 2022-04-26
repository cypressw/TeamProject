package controllers;

import java.awt.CardLayout;
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
	
	public void actionPerformed(ActionEvent ae) {
		String command = ae.getActionCommand();
		
		if (command.equals("Join Selected")) {
			String choice = ((LobbyPanel) container).getChosenGame();
			data = new LobbyData(choice, command);
			data.setPlayer(client.getPlayer());
			
			try {
				client.sendToServer(data);
			} catch(IOException e) {
				e.printStackTrace();
			};
		}
		else if (command.equals("Create New")) {
			String username = client.getPlayer().getUsername();
			data = new LobbyData(username, command);
			data.setPlayer(client.getPlayer());
			try {
				client.sendToServer(data);
			} catch(IOException e) {
				e.printStackTrace();
			};
		}
		else if (command.equals("Back")) {
			CardLayout cl = (CardLayout)container.getLayout();
			cl.show(container, "1");
		}
	}
	
	public void gameConnectSuccess() {
		CardLayout cl = (CardLayout)container.getLayout();
		cl.show(container, "5");
	}
	
	public void gameCreateSuccess() {
		CardLayout cl = (CardLayout)container.getLayout();
		cl.show(container, "4");
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
	
	public void displayOnlineGames(HashMap<String, Game> games) {
		for (String s : games.keySet()) {
			((LobbyPanel) container).addToGamesList(s);
		}
	}
}
