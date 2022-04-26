package controllers;

import javax.swing.*;

import UI.CreateAccountPanel;
import UI.GameplayPanel;
import UI.InitialPanel;
import UI.LoginPanel;

import java.awt.event.*;
import java.awt.CardLayout;
import java.awt.Color;

public class InitialControl implements ActionListener {
	private JPanel container;
	private GameClient client;
	
	public InitialControl(JPanel panel, GameClient client) {
		setContainer(panel);
		this.client = client;
	}
	
	public void actionPerformed(ActionEvent ae) {
		String command = ae.getActionCommand();
		
		if (command.equals("Create Account")) {
			CreateAccountPanel cap = (CreateAccountPanel)container.getComponent(2);
			cap.setError("", Color.RED);
			CardLayout cl = (CardLayout)container.getLayout();
			cl.show(container,  "3");
		}
		else if (command.equals("Log In")) {
			LoginPanel lp = (LoginPanel)container.getComponent(1);
			lp.setError("", Color.RED);
			CardLayout cl = (CardLayout)container.getLayout();
			cl.show(container, "2");
		}
		else if (command.equals("DEBUG")) {
			GameplayPanel gp = (GameplayPanel)container.getComponent(6);
			gp.setError("", Color.RED);
			CardLayout cl = (CardLayout)container.getLayout();
			cl.show(container, "7");
		}
	}

	public JPanel getContainer() {
		return container;
	}

	public void setContainer(JPanel container) {
		this.container = container;
	}
}
