package database;

import java.io.Serializable;

public class Player implements Serializable {
	private long id;
	private LoginData credentials;
	private boolean connected;
	
	public Player(LoginData ld) {
		setCredentials(ld);
//		this.id = id;
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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}
