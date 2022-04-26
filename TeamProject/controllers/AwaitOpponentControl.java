package controllers;

import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;

import UI.LoginPanel;
import database.Player;

import java.awt.*;

public class AwaitOpponentControl implements ActionListener {
	private AwaitOpponentData data;
	private JPanel container;
	private GameClient client;
	
	public AwaitOpponentControl(JPanel panel, GameClient client) {
		setContainer(panel);
		this.setClient(client);
		data = new AwaitOpponentData(client.getPlayer());
		
		try {
			client.sendToServer(data);
		} catch(IOException e) {
			e.printStackTrace();
		};
	}
	
	public void connectionDetected(Player connected) {
	    CardLayout cardLayout = (CardLayout)container.getLayout();
	    cardLayout.show(container, "5");
	    client.getGame().setPlayer(connected);
	}
	
	public JPanel getContainer() {
		return container;
	}

	public void setContainer(JPanel container) {
		this.container = container;
	}

	public AwaitOpponentData getData() {
		return data;
	}

	public void setData(AwaitOpponentData data) {
		this.data = data;
	}

	public GameClient getClient() {
		return client;
	}

	public void setClient(GameClient client) {
		this.client = client;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
