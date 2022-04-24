package controllers;

import javax.swing.*;
import java.awt.event.*;

public class BoardSetupControl implements ActionListener {
	private BoardSetupData data;
	private GameClient client;
	private JPanel container;
	
	public BoardSetupControl(JPanel panel, GameClient client) {
		setContainer(panel);
		this.setClient(client);
	}
	
	public void boardConfirmed() {
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		
	}

	public BoardSetupData getData() {
		return data;
	}

	public void setData(BoardSetupData data) {
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
