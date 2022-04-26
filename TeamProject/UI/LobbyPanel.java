package UI;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.SwingConstants;

import controllers.LobbyControl;

import javax.swing.JButton;

public class LobbyPanel extends JPanel {
	private JTextArea gamesList;
	private JLabel errorLabel;
	private LobbyControl lc;
	
	public LobbyPanel(LobbyControl control) {
		setLayout(null);
		lc = control;
		this.setSize(800, 545);
		
		JLabel lblLobby = new JLabel("LOBBY");
		lblLobby.setHorizontalAlignment(SwingConstants.CENTER);
		lblLobby.setFont(new Font("Modern No. 20", Font.BOLD, 29));
		lblLobby.setBounds(254, 19, 284, 33);
		add(lblLobby);
		
		gamesList = new JTextArea();
		gamesList.setEditable(false);
		gamesList.setForeground(Color.GRAY);
		gamesList.setFont(new Font("Modern No. 20", Font.BOLD, 15));
		gamesList.setBounds(41, 129, 720, 379);
		add(gamesList);
		
		JButton btnNewButton = new JButton("Join Selected");
		btnNewButton.setFont(new Font("Modern No. 20", Font.PLAIN, 24));
		btnNewButton.setBounds(41, 63, 178, 55);
		add(btnNewButton);
		
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Modern No. 20", Font.PLAIN, 24));
		btnBack.setBounds(398, 63, 177, 55);
		add(btnBack);
		
		errorLabel = new JLabel("");
		errorLabel.setFont(new Font("Modern No. 20", Font.PLAIN, 18));
		errorLabel.setBounds(273, 64, 233, 22);
		add(errorLabel);
		
		JButton btnCreateNew = new JButton("Create New");
		btnCreateNew.setFont(new Font("Modern No. 20", Font.PLAIN, 24));
		btnCreateNew.setBounds(574, 63, 187, 55);
		add(btnCreateNew);
		
		JButton btnJoin = new JButton("Join Selected");
		btnJoin.setFont(new Font("Modern No. 20", Font.PLAIN, 24));
		btnJoin.setBounds(219, 63, 180, 55);
		add(btnJoin);
		
	}
	
	public String getChosenGame() {
		return "";
	}
	
	public void setError(String text, Color color) {
		
	}
	
	public void setError(JLabel errorL) {
		
	}
	
	public void setInfo(JLabel info) {
		
	}
}
