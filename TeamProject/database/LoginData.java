package database;

public class LoginData {
	private String username;
	private String password;
	
	public LoginData(String user, String pass) {
		username = user;
		password = pass;
	}
	
	public void setUsername(String user) {
		username = user;
	}
	
	public void setPassword(String pass) {
		password = pass;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public boolean equals(LoginData ld) {
		boolean isEqual = false;
		
		if (ld.username.equals(username)) {
			if (ld.password.equals(password)) {
				isEqual = true;
			}
		}
		
		return isEqual;
	}
	
	public String toString() {
		String toReturn = "Username: " + username + "\nPassword: " + password;
		return toReturn;
	}
}
