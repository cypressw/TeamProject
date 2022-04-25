package controllers;

import java.sql.SQLException;

import database.Database;
import database.LoginData;
import database.Player;
import java.io.*;

public class CreateAccountData implements Serializable{
	private String username;
	private String password;
	
	public CreateAccountData(String user, String pass) {
		setUsername(user);
		setPassword(pass);
	}
	
	public void setUsername(String user) {
		username = user;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setPassword(String pass) {
		password = pass;
	}
	
	public String getPassword() {
		return password;
	}
}
