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
	
	// add LobbyControl c once avaliable
	public LobbyPanel() {
		lc = new LobbyControl(this);
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
		
		JButton btnJoin = new JButton("Join Selected");
		// actionListener here
		btnJoin.addActionListener(lc);
		btnJoin.setFont(new Font("Modern No. 20", Font.PLAIN, 13));
		btnJoin.setBounds(31, 62, 111, 23);
		add(btnJoin);
		
		JButton btnBack = new JButton("Back");
		// actionListener here
		btnBack.addActionListener(lc);
		btnBack.setFont(new Font("Modern No. 20", Font.PLAIN, 13));
		btnBack.setBounds(395, 62, 111, 23);
		add(btnBack);
		
		JButton btnCreateGame = new JButton("Create Game");
		// actionListener here
		btnCreateGame.addActionListener(lc);
		btnCreateGame.setFont(new Font("Dialog", Font.PLAIN, 13));
		btnCreateGame.setBounds(150, 62, 111, 23);
		add(btnCreateGame);
		
		JButton btnRefresh = new JButton("Refresh");
		// actionListener here
		btnRefresh.addActionListener(lc);
		btnRefresh.setBounds(273, 59, 117, 29);
		add(btnRefresh);
		
		errorLabel = new JLabel("");
		errorLabel.setFont(new Font("Modern No. 20", Font.PLAIN, 18));
		errorLabel.setBounds(157, 352, 233, 22);
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
