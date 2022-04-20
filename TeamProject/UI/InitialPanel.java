package UI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import java.awt.Color;

public class InitialPanel extends JPanel {
	// add InitialPanelControl c once avaliable
	public InitialPanel() {
		setLayout(null);
		
		JLabel welcome = new JLabel("WELCOME TO BATTLESHIP!");
		welcome.setBounds(37, 31, 373, 22);
		welcome.setFont(new Font("Modern No. 20", Font.BOLD, 26));
		add(welcome);
		
		JButton logIn = new JButton("Log In");
		logIn.setFont(new Font("Modern No. 20", Font.PLAIN, 13));
		logIn.setBounds(91, 70, 100, 23);
		add(logIn);
		
		JButton newGameB = new JButton("New Game");
		newGameB.setFont(new Font("Modern No. 20", Font.PLAIN, 13));
		newGameB.setBounds(91, 104, 100, 23);
		add(newGameB);
		
		JButton boardSetupB = new JButton("Board Setup");
		boardSetupB.setFont(new Font("Modern No. 20", Font.PLAIN, 13));
		boardSetupB.setBounds(91, 138, 100, 23);
		add(boardSetupB);
		
		// we can change these names if we want, they don't really matter
		JLabel lblNewLabel_1 = new JLabel("New user? Log in here.");
		lblNewLabel_1.setFont(new Font("Modern No. 20", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(201, 74, 164, 14);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Start a new game here!");
		lblNewLabel_1_1.setFont(new Font("Modern No. 20", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(201, 108, 164, 14);
		add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Go here to set up your board.");
		lblNewLabel_1_2.setFont(new Font("Modern No. 20", Font.PLAIN, 14));
		lblNewLabel_1_2.setBounds(201, 142, 164, 14);
		add(lblNewLabel_1_2);
		
		JLabel lblCreatedByJackson = new JLabel("Jackson Torregrossa, Aaron Moody, Cypress Wright, and Levi Lewis");
		lblCreatedByJackson.setForeground(Color.BLACK);
		lblCreatedByJackson.setHorizontalAlignment(SwingConstants.LEFT);
		lblCreatedByJackson.setFont(new Font("Modern No. 20", Font.BOLD, 14));
		lblCreatedByJackson.setBounds(10, 260, 430, 29);
		add(lblCreatedByJackson);
		
		JLabel lblCreatedBy = new JLabel("Created by:");
		lblCreatedBy.setForeground(Color.BLACK);
		lblCreatedBy.setHorizontalAlignment(SwingConstants.LEFT);
		lblCreatedBy.setFont(new Font("Modern No. 20", Font.BOLD, 17));
		lblCreatedBy.setBounds(10, 233, 430, 29);
		add(lblCreatedBy);
		
	}
}
