package UI;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class AwaitOpponentPanel extends JPanel {
	private JLabel status;
	
	// add AwaitOpponentControl c once avaliable
	public AwaitOpponentPanel() {
		setLayout(null);
		
		status = new JLabel("WAITING FOR PLAYER...");
		status.setHorizontalAlignment(SwingConstants.CENTER);
		status.setFont(new Font("Modern No. 20", Font.BOLD | Font.ITALIC, 25));
		status.setBounds(48, 101, 350, 49);
		add(status);
		
	}
	
	public void setStatus(String text, Color color) {
		
	}
	
	public void setStatus(JLabel status) {
		
	}
	
	public String getStatus() {
		return "";
	}
}
