package controllers;

import java.awt.CardLayout;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;

public class LobbyControl implements ActionListener {
	private JPanel container;
	private LobbyData data;
	private GameClient client;
	
	public LobbyControl(JPanel panel) {
		setContainer(panel);
		// this.setClient(client); (aaron do this)
	}
	
	public void actionPerformed(ActionEvent ae) {
		String command = ae.getActionCommand();
		
		if (command == "Back") {
			CardLayout cardLayout = (CardLayout)container.getLayout();
			cardLayout.show(container, "2");
		}
		else if (command == "Join Selected") {
			//connectToGame
			try {
				connectToGame();
			}
			catch (IOException e) {
				displayError("Could not connect to the game!");
			}
		}
		else if (command == "Create Game") {
			//createNewGame
			try {
				createNewGame();
			}
			catch (IOException e) {
				displayError("Could not create game!");
			}
		}
		else if (command == "Refresh") {
			try {
				refreshList();
			}
			catch (IOException e) {
				displayError("Could not refresh!");
			}
			//refreshList
		}
	}
	
	public void displayError(String error) {
		
	}
	
	public void createNewGame() throws IOException {
		
	}
	
	public void connectToGame() throws IOException {
		
	}
	
	public void refreshList() throws IOException {
		// get data for the list 
	}
	
	public void gameConnectSuccess() {
		System.out.println("CONNECT SUCCESS");
	}
	
	public void gameCreateSuccess() {
		System.out.println("CREATE SUCCESS");
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
