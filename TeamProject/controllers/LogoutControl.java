package controllers;

import javax.swing.*;
import java.awt.event.*;

public class LogoutControl implements ActionListener {
	private GameClient client;
	private JPanel container;
	private LogoutData data;
	
	public LogoutControl(JPanel container, GameClient client) {
		this.setContainer(container);
		this.setClient(client);
	}
	
	public void actionPerformed(ActionEvent ae) {
		
	}
	
	public void notifyPlayers() {
		
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

	public LogoutData getData() {
		return data;
	}

	public void setData(LogoutData data) {
		this.data = data;
	}
}
