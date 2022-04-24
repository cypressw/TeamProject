package controllers;

import javax.swing.*;
import java.awt.event.*;

public class CreateAccountControl implements ActionListener {
	private JPanel container;
	private GameClient client;
	private CreateAccountData data;
	
	public CreateAccountControl(JPanel panel, GameClient client) {
		setContainer(panel);
		this.setClient(client);
	}
	
	public void createAccountSuccess() {
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		
	}

	public JPanel getContainer() {
		return container;
	}

	public void setContainer(JPanel container) {
		this.container = container;
	}

	public GameClient getClient() {
		return client;
	}

	public void setClient(GameClient client) {
		this.client = client;
	}

	public CreateAccountData getData() {
		return data;
	}

	public void setData(CreateAccountData data) {
		this.data = data;
	}
}
