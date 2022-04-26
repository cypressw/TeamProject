package UI;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Button;

import javax.swing.SwingConstants;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

import controllers.BoardSetupControl;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

public class BoardSetupPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private JLabel status;
	private BoardSetupControl bsc;
	private JButton confirmBoard;
	private JLabel orientLbl;
	
	public BoardSetupPanel(BoardSetupControl control) {
		setLayout(new BorderLayout(0, 0));
		bsc = control;
		this.setSize(800, 600);
		
		JPanel boardPanel = new JPanel();
		boardPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		add(boardPanel, BorderLayout.CENTER);
		boardPanel.setLayout(new GridLayout(10, 10, 0, 0));
		for (int i = 1; i <= 10; i++) {
			for (int j = 1; j <= 10; j++) {
				String row = Integer.toString(i);
				String column = Integer.toString(j);
				String name = row + column;
				Button space = new Button();
				space.setActionCommand(name);
				boardPanel.add(space);
			}
		}
		
		// STATUS LABEL
		status = new JLabel("Place your Carrier (5 spaces)");
		status.setFont(new Font("Tahoma", Font.PLAIN, 26));
		status.setHorizontalAlignment(SwingConstants.CENTER);
		add(status, BorderLayout.NORTH);
		
		
		// LEFT PANEL
		JPanel spacer1 = new JPanel();
		add(spacer1, BorderLayout.WEST);
		spacer1.setLayout(new BorderLayout(0, 0));
	
		JPanel orientation = new JPanel();
		spacer1.add(orientation, BorderLayout.NORTH);
		orientation.setLayout(new BorderLayout());
		
		orientLbl = new JLabel("Ship Orientation: H");
		orientation.add(orientLbl, BorderLayout.NORTH);
		JButton horizontal = new JButton("Horizontal");
		orientation.add(horizontal, BorderLayout.EAST);
		JButton vertical = new JButton("Vertical");
		orientation.add(vertical, BorderLayout.WEST);
		
		// RIGHT PANEL
		JPanel spacer2 = new JPanel();
		FlowLayout fl_spacer2 = (FlowLayout) spacer2.getLayout();
		fl_spacer2.setHgap(50);
		add(spacer2, BorderLayout.EAST);
		
		
		// BUTTON PANEL (SOUTH)
		JPanel buttonPanel = new JPanel();
		FlowLayout fl_buttonPanel = (FlowLayout) buttonPanel.getLayout();
		fl_buttonPanel.setVgap(15);
		add(buttonPanel, BorderLayout.SOUTH);
	
		JButton nextShipButton = new JButton("Place Ship");
		nextShipButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		buttonPanel.add(nextShipButton);
		
		confirmBoard = new JButton("Confirm Board");
		confirmBoard.setFont(new Font("Tahoma", Font.PLAIN, 18));
		confirmBoard.setVisible(false);
		buttonPanel.add(confirmBoard);
		
		
		
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
	
	public JButton getConfirm() {
		return confirmBoard;
	}
	
	
	public void setOrientLbl(JLabel label) {
		this.orientLbl = label;
	}
	public JLabel getOrientLbl() {
		return orientLbl;
	}
}
