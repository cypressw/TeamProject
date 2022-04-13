package gamedetails;

public class Space {

	private int x;
	private int y;
	private boolean hit;
	
	public Space() {
		x = 0;
		y = 0;
		hit = false;
	}
	
	public Space(int x, int y) {
		setX(x);
		setY(y);
		hit = false;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public void markHit(boolean hit) {
		this.hit = hit;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY () {
		return y;
	}
	
	public boolean getHitStatus() {
		return hit;
	}
	
	public boolean equals(Space s) {
		if(this.x == s.x && this.y == s.y) {
			return true;
		}
		return false;
	}
	
}
