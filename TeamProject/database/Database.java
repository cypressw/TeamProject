package database;

import java.io.*;
import java.sql.*;
import java.util.*;

public class Database {
	private Connection conn;
	private HashMap<Integer, Player> players;
	  
	//Add any other data fields you like – at least a Connection object is mandatory
	public Database(String fn)
	{
		setConnection(fn);
	}
	
	public void setConnection(String fn) 
	{
		String url = "";
		String user = "";
		String password = "";
		Properties property = new Properties();
		FileInputStream fis = null;
		  
		try {
			fis = new FileInputStream(fn);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		  
		try {
			property.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		  
		user = property.getProperty("user");
		password = property.getProperty("password");
		url = property.getProperty("url");
		  
		try {
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Connection getConnection()
	{
	    return conn;
	}
	
	public void setPlayers(HashMap<Integer, Player> users) {
		players = users;
	}
	
	public boolean addPlayers(Player newUser) {
		String dml = "INSERT INTO `users`(`username`, `password`) VALUES (\'" 
				+ newUser.getUsername() + "\', aes_encrypt(\'" + newUser.getPassword() 
				+ "\', \'key\'));";
		try {
			executeDML(dml);
			players.put(newUser.getID(), newUser);
		} catch (Exception e) {
			return false;
		};
		
		return true;
	}
	
	public HashMap<Integer, Player> getPlayers() {
		return players;
	}
	  
	public ArrayList<String> query(String query)
	{
		ArrayList<String> result = new ArrayList<String>();
		//int counter = 0;
		try 
		{
			Statement st = conn.createStatement();
			String toProcess = query;
			ResultSet rs = st.executeQuery(toProcess);
			while (rs.next()) {
				result.add(rs.getString("aes_decrypt(`password`, \'key\')"));
				//counter++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	  
	public void executeDML(String dml) throws SQLException
	{
		Statement st = conn.createStatement();
		String toProcess = dml;
		st.execute(toProcess);	
	}

}
