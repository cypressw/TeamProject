package UI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import controllers.InitialControl;

import java.awt.Color;

public class InitialPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private InitialControl ic;
	
	public InitialPanel(InitialControl control) {
		setLayout(null);
		ic = control;
		
		JLabel welcome = new JLabel("WELCOME TO BATTLESHIP!");
		welcome.setHorizontalAlignment(SwingConstants.CENTER);
		welcome.setBounds(127, 10, 555, 80);
		welcome.setFont(new Font("Modern No. 20", Font.BOLD, 38));
		add(welcome);
		
		JButton create = new JButton("Create Account");
		create.setFont(new Font("Modern No. 20", Font.PLAIN, 18));
		create.setBounds(218, 134, 147, 45);
		create.addActionListener(ic);
		add(create);
		
		JButton login = new JButton("Log In");
		login.setFont(new Font("Modern No. 20", Font.PLAIN, 18));
		login.setBounds(218, 209, 147, 45);
		login.addActionListener(ic);
		add(login);
		
		// we can change these names if we want, they don't really matter
		JLabel lblNewLabel_1 = new JLabel("New user? Log in here.");
		lblNewLabel_1.setFont(new Font("Modern No. 20", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(423, 155, 227, 14);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Existing user? Log in here.");
		lblNewLabel_1_1.setFont(new Font("Modern No. 20", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(423, 219, 227, 24);
		add(lblNewLabel_1_1);
		
		JLabel lblCreatedByJackson = new JLabel("Jackson Torregrossa, Aaron Moody, Cypress Wright, and Levi Lewis");
		lblCreatedByJackson.setForeground(Color.BLACK);
		lblCreatedByJackson.setHorizontalAlignment(SwingConstants.LEFT);
		lblCreatedByJackson.setFont(new Font("Modern No. 20", Font.BOLD, 23));
		lblCreatedByJackson.setBounds(10, 483, 698, 29);
		add(lblCreatedByJackson);
		
		JLabel lblCreatedBy = new JLabel("Created by:");
		lblCreatedBy.setForeground(Color.BLACK);
		lblCreatedBy.setHorizontalAlignment(SwingConstants.LEFT);
		lblCreatedBy.setFont(new Font("Modern No. 20", Font.BOLD, 24));
		lblCreatedBy.setBounds(10, 444, 430, 29);
		add(lblCreatedBy);
		
		this.setSize(800, 600);
		
	}
}
