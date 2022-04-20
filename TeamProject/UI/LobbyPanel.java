package UI;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class LobbyPanel extends JPanel {
	private JTextArea gamesList;
	private JLabel errorLabel;
	
	// add LobbyControl c once avaliable
	public LobbyPanel() {
		setLayout(null);
		
		JLabel lblLobby = new JLabel("LOBBY");
		lblLobby.setHorizontalAlignment(SwingConstants.CENTER);
		lblLobby.setFont(new Font("Modern No. 20", Font.BOLD, 23));
		lblLobby.setBounds(129, 22, 284, 22);
		add(lblLobby);
		
		gamesList = new JTextArea();
		gamesList.setEditable(false);
		gamesList.setForeground(Color.GRAY);
		gamesList.setFont(new Font("Modern No. 20", Font.BOLD, 15));
		gamesList.setBounds(31, 97, 475, 243);
		add(gamesList);
		
		JButton btnNewButton = new JButton("Join Selected");
		btnNewButton.setFont(new Font("Modern No. 20", Font.PLAIN, 13));
		btnNewButton.setBounds(31, 63, 111, 23);
		add(btnNewButton);
		
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Modern No. 20", Font.PLAIN, 13));
		btnBack.setBounds(152, 63, 111, 23);
		add(btnBack);
		
		errorLabel = new JLabel("");
		errorLabel.setFont(new Font("Modern No. 20", Font.PLAIN, 18));
		errorLabel.setBounds(273, 64, 233, 22);
		add(errorLabel);
		
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
