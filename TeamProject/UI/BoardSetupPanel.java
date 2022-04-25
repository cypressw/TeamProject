package UI;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

import controllers.BoardSetupControl;

public class BoardSetupPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private JLabel status;
	private BoardSetupControl bsc;
	
	public BoardSetupPanel(BoardSetupControl control) {
		setLayout(new BorderLayout(0, 0));
		bsc = control;
		
		JPanel boardPanel = new JPanel();
		boardPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		add(boardPanel, BorderLayout.CENTER);
		boardPanel.setLayout(new GridLayout(10, 10, 0, 0));
		for (int i = 1; i <= 10; i++) {
			for (int j = 1; j <= 10; j++) {
				String row = Integer.toString(i);
				String column = Integer.toString(j);
				String name = row + column;
				JButton space = new JButton();
				space.setActionCommand(name);
				boardPanel.add(space);
			}
		}
		
		status = new JLabel("Place your Carrier (5 spaces)");
		status.setHorizontalAlignment(SwingConstants.CENTER);
		add(status, BorderLayout.NORTH);
		
		JPanel spacer1 = new JPanel();
		FlowLayout fl_spacer1 = (FlowLayout) spacer1.getLayout();
		fl_spacer1.setHgap(35);
		add(spacer1, BorderLayout.WEST);
		
		JPanel spacer2 = new JPanel();
		FlowLayout fl_spacer2 = (FlowLayout) spacer2.getLayout();
		fl_spacer2.setHgap(35);
		add(spacer2, BorderLayout.EAST);
		
		JPanel buttonPanel = new JPanel();
		FlowLayout fl_buttonPanel = (FlowLayout) buttonPanel.getLayout();
		fl_buttonPanel.setVgap(10);
		add(buttonPanel, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("Confirm");
		buttonPanel.add(btnNewButton);
		
		JButton btnBack = new JButton("Back");
		buttonPanel.add(btnBack);
	}
	
	public void setError(String text, Color color) {
		
	}
	
	public void setError(JLabel errorL) {
		
	}

	public JLabel getStatus() {
		return status;
	}

	public void setStatus(JLabel label) {
		this.status = label;
	}
	
	public void setErrorLabel(String text, Color color) {
		status.setText(text);
		status.setBackground(color);
	}
}
