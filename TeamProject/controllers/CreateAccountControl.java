package controllers;

import javax.swing.*;

import UI.CreateAccountPanel;
import UI.InitialPanel;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;

public class CreateAccountControl implements ActionListener {
	private JPanel container;
	private GameClient client;
	private CreateAccountData data;
	
	public CreateAccountControl(JPanel panel, GameClient client) {
		setContainer(panel);
		this.client = client;
	}
	
	public void createAccountSuccess() {
		((CreateAccountPanel) container).setError("Account Created! Press back to login.", Color.GREEN);
	}
	
	public void createAccountFailed(String error) {
		((CreateAccountPanel) container).setError(error, Color.RED);
	}
	
	public void actionPerformed(ActionEvent ae) {
	    String command = ae.getActionCommand();

	    if (command.equals("Back")) {
	    	CardLayout cardLayout = (CardLayout)container.getLayout();
	    	cardLayout.show(container, "1");
	    }

	    else if (command.equals("GO!")) {
	    	CreateAccountPanel createAccountPanel = (CreateAccountPanel)container.getComponent(2);
	    	String username = createAccountPanel.getUsername();
	    	String password = createAccountPanel.getPassword();
	    	String passwordVerify = createAccountPanel.getVerifyPassword();

	    	if (username.equals("") || password.equals("")) {
	    		displayError("You must enter a username and password.");
	    		return;
	    	}
	    	
	    	else if (!password.equals(passwordVerify)) {
	    		displayError("The two passwords did not match.");
	    		return;
	    	}
	    	
	    	if (password.length() < 6) {
	    		displayError("The password must be at least 6 characters.");
	    		return;
	    	}
	      
	    	CreateAccountData data = new CreateAccountData(username, password);
	    	try {
	    		client.sendToServer(data);
	    	}
	    	catch (IOException e) {
	    		e.printStackTrace();
	    		displayError("Error connecting to the server.");
	    	}
	    }
	}

	public JPanel getContainer() {
		return container;
	}

	public void setContainer(JPanel container) {
		this.container = container;
	}

	public CreateAccountData getData() {
		return data;
	}

	public void setData(CreateAccountData data) {
		this.data = data;
	}

	public void displayError(String message) {
		CreateAccountPanel cap = (CreateAccountPanel)container.getComponent(2);
		cap.setError(message, Color.RED);
	}
}
