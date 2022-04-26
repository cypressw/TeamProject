package UI;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.SwingConstants;

import controllers.AwaitOpponentControl;

public class AwaitOpponentPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private JLabel status;
	private AwaitOpponentControl aoc;
	
	public AwaitOpponentPanel(AwaitOpponentControl control) {
		setLayout(null);
		aoc = control;
		this.setSize(800, 545);
		
		status = new JLabel("WAITING FOR PLAYER...");
		status.setHorizontalAlignment(SwingConstants.CENTER);
		status.setFont(new Font("Modern No. 20", Font.BOLD | Font.ITALIC, 56));
		status.setBounds(41, 211, 724, 73);
		add(status);
	}
	
	public void setStatus(String text, Color color) {
		status.setText(text);
		status.setBackground(color);
	}
	
	public void setStatus(JLabel status) {
		this.status = status;
	}
	
	public String getStatus() {
		return status.getText();
	}
}
