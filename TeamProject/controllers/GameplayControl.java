package controllers;

import javax.swing.*;

import database.Game;
import gamedetails.Space;

import java.awt.event.*;
import java.io.IOException;

public class GameplayControl implements ActionListener {
	private GameplayData data;
	private GameClient client;
	private JPanel container;
	
	public GameplayControl(JPanel container, GameClient client) {
		this.container = container;
		this.client = client;
	}
	
	public void actionPerformed(ActionEvent ae) {
		String command = ae.getActionCommand();
		String xCoord = command.substring(0, 0);
		String yCoord = command.substring(1);
		int x = Integer.parseInt(xCoord);
		int y = Integer.parseInt(yCoord);
		
		Space guess = new Space(x, y);
		
		GameplayData data = new GameplayData(guess, "Their Turn", client.getGame());
		
		try {
			client.sendToServer(data);
		} catch (IOException e) {
			e.printStackTrace();
//			displayError()
		};
	}
	
	public void guess() {

	}
	
	public void switchPlayers() {
		
		Game temp = data.getGame();
	}
	
	public void showHitMiss() {
		
	}

	public GameplayData getData() {
		return data;
	}

	public void setData(GameplayData data) {
		this.data = data;
	}

	public GameClient getClient() {
		return client;
	}

	public void setClient(GameClient client) {
		this.client = client;
	}

	public JPanel getContainer() {
		return container;
	}

	public void setContainer(JPanel container) {
		this.container = container;
	}
	
	public void setSpace(int col, int row, JButton button) {
		
	}
}
