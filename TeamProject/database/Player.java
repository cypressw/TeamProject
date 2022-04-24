package database;

public class Player {
	private int id;
	private LoginData credentials;
	private boolean connected;
	
	public Player(int id, LoginData ld) {
		setID(id);
		setCredentials(ld);
	}
	
	public void setID(int id) {
		this.id = id;
	}
	
	public int getID() {
		return id;
	}
	
	public void setCredentials(LoginData ld) {
		credentials = ld;
	}
	
	public LoginData getCredentials() {
		return credentials;
	}
	
	public String getUsername() {
		return credentials.getUsername();
	}
	
	public String getPassword() {
		return credentials.getPassword();
	}
	
	public void setConnected(boolean x) {
		connected = x;
	}
	
	public boolean getConnected() {
		return connected;
	}
}
