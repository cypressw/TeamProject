package controllers;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class AwaitOpponentControl implements ActionListener {
	private AwaitOpponentData data;
	private JPanel container;
	private GameClient client;
	
	public AwaitOpponentControl(JPanel panel, GameClient client) {
		setContainer(panel);
		this.setClient(client);
	}
	
	public void connectionDetected() {
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		
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
}
