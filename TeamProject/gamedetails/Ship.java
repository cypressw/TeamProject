package gamedetails;

import java.util.ArrayList;

public class Ship {

	private String name;
	private int size;
	private ArrayList<Space> spacesOccupied;
	private int health;
	private Board board;

	public Ship() {
		name = "unnamed ship";
		size = 0;
		spacesOccupied = new ArrayList<Space>();
		health = size;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public void setSpacesOccupied(ArrayList<Space> spaces) {
		spacesOccupied = spaces;
	}

	public String getName() {
		return name;
	}

	public int getSize() {
		return size;
	}

	public ArrayList<Space> getSpacesOccupied(){
		return spacesOccupied;
	}

	public int getHealth() {
		return health;
	}


	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public void checkShipHit(int x, int y) {	

		// Loop through the spaces occupied by the ship to check for (x,y) guess
		for (Space s : spacesOccupied) {

			// If ship occupies guessed space, mark space hit and decrement ship health
			if (s.getX() == x && s.getY() == y) {
				s.markHit(true);
				health--;
				checkSinkShip();
				break;
			}
		}
	}

	public void checkSinkShip() {

		// Logic here for what needs to happen if ship sinks
		// Might not know how we actually want to handle it until more of the game is built
		if (health == 0) {
			board.setShipCount(board.getShipCount() - 1);
			System.out.println("Ship has been sunk.");
		}
		else {
			System.out.println("Ship is still alive.");
		}
	}
}
