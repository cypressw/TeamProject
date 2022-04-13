package gamedetails;

import java.util.ArrayList;

public class Ship {

	private String name;
	private int size;
	private ArrayList<Space> spacesOccupied;
	private int health;
	
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
	
	public void shipHit(int x, int y) {
		for (Space s : spacesOccupied) {
			if (s.getX()==x && s.getY() == y) {
				s.markHit(true);
				break;
			}
		}
	}
}
