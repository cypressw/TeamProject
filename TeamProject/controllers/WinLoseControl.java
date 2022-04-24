package controllers;

import javax.swing.*;
import java.awt.event.*;

public class WinLoseControl implements ActionListener {
	private JPanel container;
	private WinLoseData data;
	private GameClient client;
	
	public WinLoseControl(JPanel container, GameClient client) {
		this.setContainer(container);
		this.setClient(client);
	}
	
	public void actionPerformed(ActionEvent ae) {
		
	}
	
	public void notifyPlayers() {
		
	}

	public JPanel getContainer() {
		return container;
	}

	public void setContainer(JPanel container) {
		this.container = container;
	}

	public WinLoseData getData() {
		return data;
	}

	public void setData(WinLoseData data) {
		this.data = data;
	}

	public GameClient getClient() {
		return client;
	}

	public void setClient(GameClient client) {
		this.client = client;
	}
	
}
