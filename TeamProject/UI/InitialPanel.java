package UI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import controllers.InitialControl;

import java.awt.Color;
import java.awt.Dimension;

public class InitialPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private InitialControl ic;
	
	public InitialPanel(InitialControl control) {
		setLayout(null);
		ic = control;
		
		JLabel welcome = new JLabel("WELCOME TO BATTLESHIP!");
		welcome.setHorizontalAlignment(SwingConstants.CENTER);
		welcome.setBounds(72, 26, 648, 80);
		welcome.setFont(new Font("Modern No. 20", Font.BOLD, 44));
		add(welcome);
		
		JButton create = new JButton("Create Account");
		create.setForeground(Color.BLACK);
		create.setFont(new Font("Modern No. 20", Font.PLAIN, 25));
		create.setBounds(151, 123, 227, 78);
		create.addActionListener(ic);
		add(create);
		
		JButton login = new JButton("Log In");
		login.setFont(new Font("Modern No. 20", Font.PLAIN, 25));
		login.setBounds(151, 224, 227, 80);
		login.addActionListener(ic);
		add(login);
		
		JButton DEBUG = new JButton("DEBUG");
		DEBUG.setFont(new Font("Tahoma", Font.BOLD, 11));
		DEBUG.setForeground(new Color(0, 139, 139));
		DEBUG.setBounds(10, 410, 89, 23);
		DEBUG.addActionListener(ic);
		add(DEBUG);
		
		// we can change these names if we want, they don't really matter
		JLabel lblNewLabel_1 = new JLabel("New user? Log in here.");
		lblNewLabel_1.setFont(new Font("Modern No. 20", Font.PLAIN, 23));
		lblNewLabel_1.setBounds(401, 144, 227, 35);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Existing user? Log in here.");
		lblNewLabel_1_1.setFont(new Font("Modern No. 20", Font.PLAIN, 23));
		lblNewLabel_1_1.setBounds(401, 251, 292, 24);
		add(lblNewLabel_1_1);
		
		JLabel lblCreatedByJackson = new JLabel("Jackson Torregrossa, Aaron Moody, Cypress Wright, and Levi Lewis");
		lblCreatedByJackson.setForeground(Color.BLACK);
		lblCreatedByJackson.setHorizontalAlignment(SwingConstants.LEFT);
		lblCreatedByJackson.setFont(new Font("Modern No. 20", Font.BOLD, 23));
		lblCreatedByJackson.setBounds(10, 472, 698, 29);
		add(lblCreatedByJackson);
		
		JLabel lblCreatedBy = new JLabel("Created by:");
		lblCreatedBy.setForeground(Color.BLACK);
		lblCreatedBy.setHorizontalAlignment(SwingConstants.LEFT);
		lblCreatedBy.setFont(new Font("Modern No. 20", Font.BOLD, 24));
		lblCreatedBy.setBounds(10, 444, 430, 29);
		add(lblCreatedBy);
		
		this.setPreferredSize(new Dimension(800, 545));
	}
}
