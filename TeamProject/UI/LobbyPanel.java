package UI;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.text.DefaultCaret;

import controllers.LobbyControl;

import javax.swing.DefaultListModel;
import javax.swing.JButton;

public class LobbyPanel extends JPanel {
	private JList<String> gamesList;
	private JLabel errorLabel;
	private LobbyControl lc;
	private DefaultListModel<String> list;
	
	public LobbyPanel(LobbyControl control) {
		setLayout(null);
		lc = control;
		this.setSize(800, 545);
		
		JLabel lblLobby = new JLabel("LOBBY");
		lblLobby.setHorizontalAlignment(SwingConstants.CENTER);
		lblLobby.setFont(new Font("Modern No. 20", Font.BOLD, 29));
		lblLobby.setBounds(254, 19, 284, 33);
		add(lblLobby);
		
		list = new DefaultListModel<String>();
		
		gamesList = new JList<String>(list);
		gamesList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		gamesList.setLayoutOrientation(JList.VERTICAL);
		gamesList.setVisibleRowCount(-1);
		gamesList.setPreferredSize(new Dimension(20, 379));
		gamesList.setFont(gamesList.getFont().deriveFont(Font.PLAIN));
		JPanel gamesListBuffer = new JPanel();
		gamesListBuffer.setBounds(41, 129, 720, 379);
		gamesListBuffer.add(gamesList);
		add(gamesListBuffer);
		
		JButton btnNewButton = new JButton("Join Selected");
		btnNewButton.setFont(new Font("Modern No. 20", Font.PLAIN, 24));
		btnNewButton.setBounds(41, 63, 178, 55);
		btnNewButton.addActionListener(lc);
		add(btnNewButton);
		
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Modern No. 20", Font.PLAIN, 24));
		btnBack.setBounds(398, 63, 177, 55);
		btnBack.addActionListener(lc);
		add(btnBack);
		
		errorLabel = new JLabel("");
		errorLabel.setFont(new Font("Modern No. 20", Font.PLAIN, 18));
		errorLabel.setBounds(273, 64, 233, 22);
		add(errorLabel);
		
		JButton btnCreateNew = new JButton("Create New");
		btnCreateNew.setFont(new Font("Modern No. 20", Font.PLAIN, 24));
		btnCreateNew.setBounds(574, 63, 187, 55);
		btnCreateNew.addActionListener(lc);
		add(btnCreateNew);
		
		JButton btnJoin = new JButton("Join Selected");
		btnJoin.setFont(new Font("Modern No. 20", Font.PLAIN, 24));
		btnJoin.setBounds(219, 63, 180, 55);
		btnJoin.addActionListener(lc);
		add(btnJoin);
		
	}
	
	public String getChosenGame() {
		return gamesList.getSelectedValue();
	}
	
	public void setError(String text, Color color) {
		errorLabel.setText(text);
		errorLabel.setBackground(color);
	}
	
	public void setError(JLabel errorL) {
		errorLabel = errorL;
	}
	
	public void addToGamesList(String game) {
		list.addElement(game);
	}
}
