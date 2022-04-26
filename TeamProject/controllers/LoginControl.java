package controllers;

import javax.swing.*;

import UI.LoginPanel;
import database.LoginData;
import database.Player;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.*;
import java.io.IOException;

public class LoginControl implements ActionListener {
	private JPanel container;
	private LoginData data;
	private GameClient client;
	
	public LoginControl(JPanel container, GameClient client) {
		this.container = container;
		this.client = client;
	}
	
	public void actionPerformed(ActionEvent ae) {
	    String command = ae.getActionCommand();

	    if (command.equals("Back"))
	    {
	    	CardLayout cardLayout = (CardLayout)container.getLayout();
	    	cardLayout.show(container, "1");
	    }

	    // The Submit button submits the login information to the server.
	    else if (command.equals("GO!"))
	    {
	    	LoginPanel loginPanel = (LoginPanel)container.getComponent(1);
	    	data = new LoginData(loginPanel.getUsername(), loginPanel.getPassword());
	      
	    	// Check the validity of the information locally first.
	    	if (data.getUsername().equals("") || data.getPassword().equals(""))
	    	{
	    		displayError("You must enter a username and password.");
	    		return;
	    	}

	    	try
	    	{
	    		client.sendToServer(data);
	    	}
	    	catch (IOException e)
	    	{
	    		e.printStackTrace();
	    		displayError("Error connecting to the server.");
	    	}
	    }
	}
	
	public void loginSuccessful() {
		client.setPlayer(new Player(data));
	    CardLayout cardLayout = (CardLayout)container.getLayout();
	    cardLayout.show(container, "6");
	}
	
	public void displayError(String error) {
		LoginPanel loginPanel = (LoginPanel)container.getComponent(1);
	    loginPanel.setError(error, Color.RED);
	}
	
	public JPanel getContainer() {
		return container;
	}
	
	public void setContainer(JPanel container) {
		this.container = container;
	}
	
	public LoginData getData() {
		return data;
	}
	
	public void setData(LoginData data) {
		this.data = data;
	}
	
	public GameClient getClient() {
		return client;
	}
	
	public void setClient(GameClient client) {
		this.client = client;
	}
	
}
