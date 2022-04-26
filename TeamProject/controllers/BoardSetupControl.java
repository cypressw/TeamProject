package controllers;

import javax.swing.*;

import gamedetails.Board;
import gamedetails.Ship;
import gamedetails.Space;

import java.awt.CardLayout;
import java.awt.event.*;
import java.util.ArrayList;

public class BoardSetupControl implements ActionListener {
	private BoardSetupData data;
	private GameClient client;
	private JPanel container;
	private Ship[] ships;
	private int current;
	private Ship currentShip;

	public BoardSetupControl(JPanel panel, GameClient client) {
		setContainer(panel);
		this.setClient(client);
		
		// Make ships for placement
		Ship carrier = new Ship("Carrier", 5);
		Ship battleship = new Ship("Battleship", 4);
		Ship cruiser = new Ship("Cruiser", 3);
		Ship submarine = new Ship("Submarine", 3);
		Ship destroyer = new Ship("Destroyer", 2);
		ships = new Ship[5];
		ships[0] = carrier;
		ships[1] = battleship;
		ships[2] = cruiser;
		ships[3] = submarine;
		ships[4] = destroyer;
		current = 0;
		currentShip = ships[current];
		
	}

	public void boardConfirmed() {
		BoardSetupData data = new BoardSetupData(new Board(), "");
	}

	public void actionPerformed(ActionEvent ae) {
		String command = ae.getActionCommand();
		//
		if (command.equals("Horizontal"))
		{
			// set current ship to be horizontal
			currentShip.setHorizontal(true);
			
			// highlight horizontal button
			
		}
		else if(command.equals("Vertical")) {
			//set current ship to be vertical
			currentShip.setHorizontal(false);
			
			// highlight vertical button
		}
		else if(command.equals("Next Ship")) {
			// If it's the last ship, show the "Confirm Board" button
			if(currentShip.getName().equals("Destroyer")) {
				 
			}
			else {
				
				// Check validity
				Space s = new Space();		// This should go in the grid button's act.list.
				if(isValidPlacement(currentShip, s)) {
					// Set spaces occupied by ship
			
					
					// Move to the next ship
					currentShip = ships[++current];
					
					// Update label
					
				}
				
			}
			
			
		}
		
		else if(command.equals("Confirm Board")) {
			
			// Set board ships
			data = new BoardSetupData(new Board(), "no gameID");
			data.getBoard().setShips(ships);
			
			// Send to server
			client.sendToServer(data);
		}
	}

	public BoardSetupData getData() {
		return data;
	}

	public void setData(BoardSetupData data) {
		this.data = data;
	}

	public GameClient getClient() {
		return client;
	}

	public void setClient(GameClient client) {
		this.client = client;
	}

	public JPanel getContainer() {
		return container;
	}

	public void setContainer(JPanel container) {
		this.container = container;
	}
	
	public boolean isValidPlacement(Ship ship, Space s) {
		boolean valid = false;
		
		// If horizontal, the first square clicked represents the leftmost space
			// Check ship can fit horizontally to the right
			// without hitting the wall or another ship
		
		// If vertical, the first square clicked represents the uppermost space
			// Check ship can fit vertically down
			// without hitting the wall or another ship
		
	
		
		return valid;
	}
}
