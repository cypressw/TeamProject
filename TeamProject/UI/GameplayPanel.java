package UI;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import controllers.GameplayControl;
import gamedetails.Board;

public class GameplayPanel extends JPanel {
	private JButton cell[] = new JButton[100];
	private GameplayControl gpc;
	private char letter;
	
	public GameplayPanel(GameplayControl control) {
		gpc = control;
		this.setPreferredSize(new Dimension(867, 658));
		setLayout(null);
		
		// text to let you know you are where you're supposed to be
		JLabel title = new JLabel("GAME SCREEN");
		title.setFont(new Font("Tahoma", Font.PLAIN, 20));
		title.setBounds(10, 11, 164, 38);
		add(title);
		
		// THIS WILL CONTAIN ALL OUR BUTTONS
		JPanel boardContainer = new JPanel(new GridLayout(10, 10)); // set size for container
		boardContainer.setBounds(257, 47, 600, 600);
		boardContainer.setPreferredSize(new Dimension(600, 600));
		boardContainer.setBorder(BorderFactory.createLineBorder(Color.RED));
		this.add(boardContainer);
		
		// GRID BAG FORMAT (what formats the buttons)
		GridBagConstraints c = new GridBagConstraints();
		
		// set number of columns and rows (and other things)
		c.insets = new Insets(10, 10, 10, 10);
		c.weightx = 1;
		c.gridwidth = 60;
		
		// DO IT
		build(boardContainer, c);
		
		JLabel lblNewLabel = new JLabel("A");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblNewLabel.setBounds(214, 57, 42, 50);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("1");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblNewLabel_1.setBounds(257, -1, 50, 50);
		add(lblNewLabel_1);
	}
	
	public void build(JPanel board, GridBagConstraints c) {
		// render buttons
		for (int i = 0; i < 100; i++) {
			// decide location
			// letter = annoyingLogic(i);
			
			// build 
			cell[i] = new JButton(String.valueOf(i + 1));
			cell[i].setFont(new Font("Tahoma", Font.BOLD, 11));
			
			// add action listener
			cell[i].addActionListener(gpc);
			
			// add to boardContainer
			board.add(cell[i]);
		}
	}
	
	public char annoyingLogic(int i) {
		// annoying logic
		if (i >= 9 && i <= 18) {
			letter = 'B';
		}
		else if (i >= 18 && i <= 27) {
			letter = 'C';
		}
		else if (i >= 27 && i <= 36) {
			letter = 'D';
		}
		else if (i >= 36 && i <= 45) {
			letter = 'E';
		}
		else if (i >= 45 && i <= 54) {
			letter = 'F';
		}
		else if (i >= 54 && i <= 63) {
			letter = 'G';
		}
		else if (i >= 63 && i <= 72) {
			letter = 'H';
		}
		else if (i >= 72 && i <= 81) {
			letter = 'I';
		}
		else if (i >= 81 && i <= 90) {
			letter = 'J';
		}
		else if (i >= 90 && i <= 99) {
			letter = 'K';
		}
		
		return letter;
	}
	
	public void setError(String string, Color red) {
		
	}
}
