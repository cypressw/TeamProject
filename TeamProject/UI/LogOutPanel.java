package UI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class LogOutPanel extends JPanel {
	private String message;
	
	// no LogOutPanel control?
	public LogOutPanel(String message) {
		setLayout(null);
		
		// do we really need a message here?
		JLabel lblAreYouSure = new JLabel("Are you sure you want to log out?");
		lblAreYouSure.setHorizontalAlignment(SwingConstants.CENTER);
		lblAreYouSure.setFont(new Font("Modern No. 20", Font.BOLD | Font.ITALIC, 25));
		lblAreYouSure.setBounds(42, 100, 358, 49);
		add(lblAreYouSure);
		
		JButton btnNewButton = new JButton("Log Out");
		btnNewButton.setFont(new Font("Modern No. 20", Font.PLAIN, 13));
		btnNewButton.setBounds(87, 156, 109, 32);
		add(btnNewButton);
		
		JButton btnBackToLobby = new JButton("Back To Lobby");
		btnBackToLobby.setFont(new Font("Modern No. 20", Font.PLAIN, 13));
		btnBackToLobby.setBounds(236, 156, 115, 32);
		add(btnBackToLobby);
		
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		
	}
}
