package database;

public class Player {
	private LoginData credentials;
	private boolean connected;
	
	public Player(LoginData ld) {
		setCredentials(ld);
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
