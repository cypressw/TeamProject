package gamedetails;

public class Board {
	private Space[][] grid;
	private Ship[] ships;
	private int shipCount;

	public Board() {
		grid = new Space[10][10];
		shipCount = 5;
		ships = new Ship[shipCount];

	}

	public void setShipCount(int n) {
		shipCount = n;
	}

	public int getShipCount() {
		return shipCount;
	}

	public void setShips (Ship[] ships) {
		this.ships = ships;

		// Set the board object in the Ship class
		for(Ship s : this.ships) {
			s.setBoard(this);
		}

	}

	public Ship[] getShips() {
		return ships;
	}
}
