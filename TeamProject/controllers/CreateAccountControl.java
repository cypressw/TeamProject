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
	private CreateAccountPanel container;
	private GameClient client;
	private CreateAccountData data;
	private Database db;
	
	public CreateAccountControl(CreateAccountPanel panel, GameClient client) {
		setContainer(panel);
		this.setClient(client);
		db = new Database("./database/db.properties");
	}
	
	public void createAccountSuccess() {
		container.setError("Account Created Successfully! Press back to log in.", Color.GREEN);
	}
	
	public void createAccountFailed(String error) {
		container.setError(error, Color.RED);
	}
	
	public void actionPerformed(ActionEvent ae) {
		String action = ae.getActionCommand();
		ArrayList<String> result = new ArrayList<String>();
		
		if (action.equals("GO!")) {
			String user = container.getUsername();
			String pass = container.getPassword();
			String verify = container.getVerifyPassword();
			
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

	public void setContainer(CreateAccountPanel container) {
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
