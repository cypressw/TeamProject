package UI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import controllers.WinLoseControl;

import java.awt.Color;
import javax.swing.JButton;

public class WinLosePanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private String message;
	private WinLoseControl wlc;
	
	// add WinLoseControl c once avaliable
	public WinLosePanel(WinLoseControl control) {
		setLayout(null);
		wlc = control;
		
		// eventually, message will replace "you lost"
		JLabel lblYouLost = new JLabel("YOU LOST!");
		lblYouLost.setHorizontalAlignment(SwingConstants.CENTER);
		lblYouLost.setFont(new Font("Modern No. 20", Font.PLAIN, 47));
		lblYouLost.setBounds(223, 115, 350, 49);
		add(lblYouLost);
		
		JLabel lblPlayAgain = new JLabel("Play Again?");
		lblPlayAgain.setForeground(Color.PINK);
		lblPlayAgain.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlayAgain.setFont(new Font("Modern No. 20", Font.PLAIN, 44));
		lblPlayAgain.setBounds(223, 175, 350, 49);
		add(lblPlayAgain);
		
		JButton btnNewButton = new JButton("Play Again");
		btnNewButton.setFont(new Font("Modern No. 20", Font.PLAIN, 26));
		btnNewButton.setBounds(43, 267, 228, 49);
		add(btnNewButton);
		
		JButton btnBackToMain = new JButton("Back To Main Menu");
		btnBackToMain.setFont(new Font("Modern No. 20", Font.PLAIN, 23));
		btnBackToMain.setBounds(285, 267, 228, 49);
		add(btnBackToMain);
		
		JButton btnExitBattleship = new JButton("Exit Battleship");
		btnExitBattleship.setFont(new Font("Modern No. 20", Font.PLAIN, 26));
		btnExitBattleship.setBounds(523, 267, 228, 49);
		add(btnExitBattleship);
		
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		
	}
}
