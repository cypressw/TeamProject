package controllers;

import javax.swing.*;
import java.awt.event.*;

public class GameplayControl implements ActionListener {
	private GameplayData data;
	private GameClient client;
	private JPanel container;
	
	public GameplayControl(JPanel container, GameClient client) {
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		
	}
	
	public void guess() {
		
	}
	
	public void switchPlayers() {
		
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
}
