package controllers;

import javax.swing.*;

import UI.CreateAccountPanel;
import UI.InitialPanel;
import UI.LoginPanel;

import java.awt.event.*;
import java.awt.CardLayout;
import java.awt.Color;

public class InitialControl implements ActionListener {
	private JPanel container;
	
	public InitialControl(JPanel panel) {
		setContainer(panel);
	}
	
	public void actionPerformed(ActionEvent ae) {
		String command = ae.getActionCommand();
		
		if (command.equals("Create Account")) {
			CreateAccountPanel cap = (CreateAccountPanel)container.getComponent(1);
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
	}

	public JPanel getContainer() {
		return container;
	}

	public void setContainer(JPanel container) {
		this.container = container;
	}
}
