package UI;

import java.awt.BorderLayout;
import java.awt.*;

import javax.swing.*;
import javax.swing.border.LineBorder;

import controllers.GameplayControl;
import gamedetails.Board;

public class GameplayPanel extends JPanel {
	private final int FIELD_SIZE = 34;
	private Board board;
	private JLabel status;
	private GameplayControl gpc;
	
	public GameplayPanel(GameplayControl control) {
		gpc = control;	
		setLayout(new BorderLayout(0, 0));
		this.setSize(800, 545);
		
		JPanel boardPanel = new JPanel();
		add(boardPanel, BorderLayout.CENTER);
		
		GridBagConstraints c = new GridBagConstraints();
	    c.fill = GridBagConstraints.BOTH;
	    
		JPanel playerBoard = new JPanel();
		boardPanel.add(playerBoard);
		playerBoard.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		playerBoard.setLayout(new GridLayout(10, 10, 10, 0));
		for (int i = 1; i <= 10; i++) {
			for (int j = 1; j <= 10; j++) {
//				JPanel temp = new JPanel();
//				String row = Integer.toString(i);
//				String column = Integer.toString(j);
//				String name = row + column;
//				Button space = new Button();
//				space.setEnabled(false);
//				space.setActionCommand(name);
//				temp.add(space);
//				playerBoard.add(temp);
				JButton button = new JButton();
		        button.setBackground(new Color(131, 209, 232));
		        button.setBorder(BorderFactory.createLineBorder(new Color(32, 156, 185)));
		        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
		        button.setPreferredSize(new java.awt.Dimension(FIELD_SIZE, FIELD_SIZE));
		        
		        // add button to GUI grid-manager
		        setField(j, i, button);
		        
		        // set field position
		        c.gridx = j;
		        c.gridy = i;
		        
		        // add field to the grid
		        this.add(button, c);
			}
		}
		
		JPanel opponentBoard = new JPanel();
		boardPanel.add(opponentBoard);
		opponentBoard.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		opponentBoard.setLayout(new GridLayout(10, 10, 10, 0));
		for (int i = 1; i <= 10; i++) {
			for (int j = 1; j <= 10; j++) {
				JPanel temp = new JPanel();
				String row = Integer.toString(i);
				String column = Integer.toString(j);
				String name = row + column;
				Button space = new Button();
				space.setActionCommand(name);
				temp.add(space);
				opponentBoard.add(temp);
			}
		}
		
		JPanel labelPanel = new JPanel();
		add(labelPanel, BorderLayout.NORTH);
		labelPanel.setLayout(new GridLayout(0, 3, 0, 20));
		
		JPanel lp1 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) lp1.getLayout();
		flowLayout.setVgap(30);
		labelPanel.add(lp1);
		
		JLabel playerLabel = new JLabel("Your Board");
		playerLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lp1.add(playerLabel);
		playerLabel.setHorizontalAlignment(SwingConstants.LEFT);
		
		JPanel lp2 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) lp2.getLayout();
		flowLayout_1.setVgap(20);
		labelPanel.add(lp2);
		
		status = new JLabel("");
		lp2.add(status);
		status.setFont(new Font("Tahoma", Font.PLAIN, 23));
		status.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel lp3 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) lp3.getLayout();
		flowLayout_2.setVgap(20);
		labelPanel.add(lp3);
		
		JLabel opponentLabel = new JLabel("Their Board");
		opponentLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lp3.add(opponentLabel);
		opponentLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JPanel buttonPanel = new JPanel();
		FlowLayout fl_buttonPanel = (FlowLayout) buttonPanel.getLayout();
		fl_buttonPanel.setVgap(30);
		add(buttonPanel, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("Confirm");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		buttonPanel.add(btnNewButton);
		
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 18));
		buttonPanel.add(btnBack);
		
	}
	
	private void setField(int j, int i, JButton button) {
		// TODO Auto-generated method stub
		
	}

	public void setInfo(String text, Color color) {
		
	}
}
