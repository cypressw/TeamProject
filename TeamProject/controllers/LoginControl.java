package controllers;

import javax.swing.*;
import database.LoginData;
import java.awt.event.*;

public class LoginControl implements ActionListener {
	private JPanel container;
	private LoginData data;
	private GameClient client;
	
	public LoginControl(JPanel container, GameClient client) {
		this.container = container;
		this.client = client;
	}
	
	public void actionPerformed(ActionEvent ae) {
		
	}
	
	public void loginSuccessful() {
		
	}
	
	public void displayError(String error) {
		
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
