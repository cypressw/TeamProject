package controllers;

import java.sql.SQLException;

import database.Database;
import database.LoginData;
import database.Player;

public class CreateAccountData {
	private String username;
	private String password;
	private Database db;
	
	public CreateAccountData(String user, String pass) {
		setUsername(user);
		setPassword(pass);
		db = new Database("./database/db.properties");
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
	
	public void addPlayer() {
		LoginData ld = new LoginData(username, password);
		Player newPlayer = new Player(ld);
		db.addPlayers(newPlayer);
	}
}
