package controllers;

import javax.swing.*;
import java.awt.event.*;

public class InitialControl implements ActionListener {
	private JPanel container;
	
	public InitialControl(JPanel panel) {
		setContainer(panel);
	}
	
	public void actionPerformed(ActionEvent ae) {
		
	}

	public JPanel getContainer() {
		return container;
	}

	public void setContainer(JPanel container) {
		this.container = container;
	}
}
