package controllers;

import javax.swing.*;

import UI.CreateAccountPanel;
import UI.InitialPanel;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.*;
import java.util.ArrayList;

import database.*;

public class CreateAccountControl implements ActionListener {
	private JPanel container;
	private GameClient client;
	private CreateAccountData data;
	private Database db;
	
	public CreateAccountControl(JPanel panel, GameClient client) {
		setContainer(panel);
		this.setClient(client);
		db = new Database("./database/db.properties");
	}
	
	public void createAccountSuccess() {
		((CreateAccountPanel) container).setError("Account Created Successfully! Press back to log in.", Color.GREEN);
	}
	
	public void createAccountFailed(String error) {
		((CreateAccountPanel) container).setError(error, Color.RED);
	}
	
	public void actionPerformed(ActionEvent ae) {
		String action = ae.getActionCommand();
		ArrayList<String> result = new ArrayList<String>();
		
		if (action.equals("GO!")) {
			String user = ((CreateAccountPanel) container).getUsername();
			String pass = ((CreateAccountPanel) container).getPassword();
			String verify = ((CreateAccountPanel) container).getVerifyPassword();
			
			if (!pass.equals(verify)) {
				createAccountFailed("Password unable to be verified. Passwords should match.");
			}
			
			String toProcess = "SELECT `username` FROM `users` WHERE `username`= \'" + user + "\';";
			result = db.query(toProcess);
			if (result.isEmpty()) {
				createAccountFailed("Account Creation Failed! Username already taken.");
			}
			else {
				createAccountSuccess();
				data = new CreateAccountData(user, pass);
				data.addPlayer();
			}
		}
		else if (action.equals("Back")) {
			InitialPanel ip = (InitialPanel)container.getComponent(1);
			CardLayout cl = (CardLayout)container.getLayout();
			cl.show(container, "2");
		}
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

	public void displayError(String message) {
		
	}
}
