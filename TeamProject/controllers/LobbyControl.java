package controllers;

import java.awt.event.*;
import javax.swing.*;

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
}
