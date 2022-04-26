package UI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import controllers.LogoutControl;

import javax.swing.JButton;

public class LogOutPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private String message;
	private LogoutControl loc;
	
	// no LogOutPanel control?
	public LogOutPanel(String message, LogoutControl control) {
		setLayout(null);
		loc = control;
		this.setSize(800, 545);
		
		// do we really need a message here?
		JLabel lblAreYouSure = new JLabel("Are you sure you want to log out?");
		lblAreYouSure.setHorizontalAlignment(SwingConstants.CENTER);
		lblAreYouSure.setFont(new Font("Modern No. 20", Font.BOLD | Font.ITALIC, 49));
		lblAreYouSure.setBounds(46, 169, 705, 49);
		add(lblAreYouSure);
		
		JButton btnNewButton = new JButton("Log Out");
		btnNewButton.setFont(new Font("Modern No. 20", Font.PLAIN, 28));
		btnNewButton.setBounds(130, 250, 238, 57);
		add(btnNewButton);
		
		JButton btnBackToLobby = new JButton("Back To Lobby");
		btnBackToLobby.setFont(new Font("Modern No. 20", Font.PLAIN, 28));
		btnBackToLobby.setBounds(408, 250, 238, 57);
		add(btnBackToLobby);
		
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		
	}
}
