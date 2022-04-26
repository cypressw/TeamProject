package server;

import java.awt.*;
import javax.swing.*;

import controllers.*;
import database.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import ocsf.server.AbstractServer;
import ocsf.server.ConnectionToClient;

public class GameServer extends AbstractServer {
	private JTextArea log;
	private JLabel status;
	private boolean running = false;
	private Database db;
	private ArrayList<Player> onlinePlayers;
	private HashMap<String, Game> games;

	public GameServer() {
		super(12345);
		this.setTimeout(500);
	}

	public void setDatabase(Database database) {
		db = database;
	}

	// Getter that returns whether the server is currently running.
	public boolean isRunning() {
		return running;
	}

	// Setters for the data fields corresponding to the GUI elements.
	public void setLog(JTextArea log) {
		this.log = log;
	}

	public void setStatus(JLabel status) {
		this.status = status;
	}

	// When the server starts, update the GUI.
	public void serverStarted() {
		running = true;
		status.setText("Listening");
		status.setForeground(Color.GREEN);
		log.append("Server started\n");
	}

	// When the server stops listening, update the GUI.
	public void serverStopped() {
		status.setText("Stopped");
		status.setForeground(Color.RED);
		log.append("Server stopped accepting new clients - press Listen to start accepting new clients\n");
	}

	// When the server closes completely, update the GUI.
	public void serverClosed() {
		running = false;
		status.setText("Close");
		status.setForeground(Color.RED);
		log.append("Server and all current clients are closed - press Listen to restart\n");
	}

	// When a client connects or disconnects, display a message in the log.
	public void clientConnected(ConnectionToClient client) {
		log.append("Client " + client.getId() + " connected\n");
	}

	// When a message is received from a client, handle it.
	public void handleMessageFromClient(Object arg0, ConnectionToClient arg1) {
		// If we received LoginData, verify the account information.
		if (arg0 instanceof LoginData) {
			// Check the username and password with the database.
			db = new Database("./database/db.properties");
			LoginData data = (LoginData) arg0;
			ArrayList<String> queryResult;
			Object result;

			String toProcess = "SELECT * FROM users WHERE username = \'" + data.getUsername()
					+ "\' AND password = aes_encrypt(\'" + data.getPassword() + "\', \'key\');";
			queryResult = db.query(toProcess);

			if (!queryResult.isEmpty()) {
				log.append("Client " + arg1.getId() + " successfully logged in as " + data.getUsername() + "\n");
				result = "LoginSuccessful";
//				onlinePlayers.add(new Player(data, arg1.getId()));
//				result = onlinePlayers;
			} else {
				result = new Error("The username and password are incorrect.", "Login");
				log.append("Client " + arg1.getId() + " failed to log in\n");
			}

			// Send the result to the client.
			try {
				arg1.sendToClient(result);
			} catch (IOException e) {
				return;
			}
		}

		// If we received CreateAccountData, create a new account.
		else if (arg0 instanceof CreateAccountData) {
			// Try to create the account.
			db = new Database("./database/db.properties");
			CreateAccountData data = (CreateAccountData) arg0;
			ArrayList<String> queryResult;
			Object result = new Object();

			String toQuery = "SELECT * FROM users WHERE username = \'" + data.getUsername() + "\';";
			queryResult = db.query(toQuery);

			if (queryResult.isEmpty()) {
				try {
					String toProcess = "INSERT INTO users(`username`, `password`) VALUES (\'" + data.getUsername()
							+ "\', aes_encrypt(\'" + data.getPassword() + "\', \'key\'))";
					db.executeDML(toProcess);
					result = "CreateAccountSuccessful";
					log.append("Client " + arg1.getId() + " created a new account called " + data.getUsername() + "\n");

				} catch (Exception e) {
					e.printStackTrace();
					result = new Error("Account creation has failed.", "CreateAccount");
					log.append("Client " + arg1.getId() + " failed to create a new account\n");
				}
				;
			} else {
				result = new Error("The username is already in use.", "CreateAccount");
				log.append("Client " + arg1.getId() + " failed to create a new account\n");
			}

			// Send the result to the client.
			try {
				arg1.sendToClient(result);
			} catch (IOException e) {
				return;
			}
		} 
		else if (arg0 instanceof LobbyData) {
			if (((LobbyData)arg0).getCommand().equals("Create New")) {
				Object result;
				Player host = ((LobbyData)arg0).getPlayer();
				Game newGame = new Game();
				newGame.setPlayer(host);
				games.put(host.getUsername(), newGame);
				result = "GameCreateSuccess";
			
				try {
					arg1.sendToClient(result);
					arg1.sendToClient(games);
				} catch(IOException e) {
					e.printStackTrace();
				};
			}
			else if (((LobbyData)arg0).getCommand().equals("Join Selected")) {
				Object result;
				Player connectedPlayer = ((LobbyData)arg0).getPlayer();
				Game selected = games.get(((LobbyData)arg0).getUsername());
				selected.setPlayer(connectedPlayer);
				result = "GameConnectSuccess";
			
				try {
					arg1.sendToClient(result);
				} catch(IOException e) {
					e.printStackTrace();
				};
			}
		} 
		else if (arg0 instanceof AwaitOpponentData) {
			
		} 
		else if (arg0 instanceof GameplayData) {

		}
	}

	// Method that handles listening exceptions by displaying exception information.
	public void listeningException(Throwable exception) {
		running = false;
		status.setText("Exception occurred while listening");
		status.setForeground(Color.RED);
		log.append("Listening exception: " + exception.getMessage() + "\n");
		log.append("Press Listen to restart server\n");
	}

	public ArrayList<Player> getPlayers() {
		return onlinePlayers;
	}

	public void setPlayers(ArrayList<Player> players) {
		this.onlinePlayers = players;
	}

	public HashMap<String, Game> getGames() {
		return games;
	}

	public void setGames(HashMap<String, Game> games) {
		this.games = games;
	}
}
