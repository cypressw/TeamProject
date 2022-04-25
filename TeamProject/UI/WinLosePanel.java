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
		lblYouLost.setFont(new Font("Modern No. 20", Font.BOLD | Font.ITALIC, 40));
		lblYouLost.setBounds(43, 58, 350, 49);
		add(lblYouLost);
		
		JLabel lblPlayAgain = new JLabel("Play Again?");
		lblPlayAgain.setForeground(Color.PINK);
		lblPlayAgain.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlayAgain.setFont(new Font("Modern No. 20", Font.BOLD, 24));
		lblPlayAgain.setBounds(43, 117, 350, 49);
		add(lblPlayAgain);
		
		JButton btnNewButton = new JButton("Play Again");
		btnNewButton.setFont(new Font("Modern No. 20", Font.PLAIN, 13));
		btnNewButton.setBounds(35, 177, 99, 30);
		add(btnNewButton);
		
		JButton btnBackToMain = new JButton("Back To Main Menu");
		btnBackToMain.setFont(new Font("Modern No. 20", Font.PLAIN, 13));
		btnBackToMain.setBounds(144, 177, 148, 30);
		add(btnBackToMain);
		
		JButton btnExitBattleship = new JButton("Exit Battleship");
		btnExitBattleship.setFont(new Font("Modern No. 20", Font.PLAIN, 13));
		btnExitBattleship.setBounds(302, 177, 119, 30);
		add(btnExitBattleship);
		
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		
	}
}
