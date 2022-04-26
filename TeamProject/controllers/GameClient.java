package controllers;

import database.*;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.*;
import ocsf.client.*;

import ocsf.client.AbstractClient;
import server.Error;

public class GameClient extends AbstractClient
{
	// Private data fields for storing the GUI controllers.
	private LoginControl loginc;
	private LobbyControl lobc;
	private CreateAccountControl cac;
	private AwaitOpponentControl aoc;
	private GameplayControl gpc;
	private BoardSetupControl bsc;
	private WinLoseControl wlc;
	private LogoutControl logout;
	private Game game;
	private Player player;
	private long id;
	
	public GameClient() {
		super("localhost", 8300);
	}

 	public void setLoginControl(LoginControl loginc) {
 		this.loginc = loginc;
 	}
 	
 	public void setLobbyControl(LobbyControl lobc) {
 		this.lobc = lobc;
 	}
 	
 	public void setCreateAccountControl(CreateAccountControl cac) {
 		this.cac = cac;
 	}
  
	public void setAwaitOpponentControl(AwaitOpponentControl aoc) {
		this.aoc = aoc;
	}
	
	public void setGameplayControl(GameplayControl gpc) {
		this.gpc = gpc;
	}
	
	public void setBoardSetupControl(BoardSetupControl bsc) {
		this.bsc = bsc;
	}
	
	public void setWinLoseControl(WinLoseControl wlc) {
		this.wlc = wlc;
	}
	
	public void setLogoutControl(LogoutControl logout) {
		this.logout = logout;
	}
	
 	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void handleMessageFromServer(Object arg0) {
 		if (arg0 instanceof String) {
 			String message = (String)arg0;
      
 			if (message.equals("CreateAccountSuccessful")) {
 				cac.createAccountSuccess();
 			}
 			
 			else if (message.equals("LoginSuccessful")) {
 				loginc.loginSuccessful();
 			}
 			
 			else if (message.equals("OpponentConnected")) {
 				//aoc.connectionDetected();
 			}
 			
 			else if (message.equals("GuessMade")) {
 				
 			}
 			
 			else if (message.equals("GameConnectSuccess")) {
 				lobc.gameConnectSuccess();
 			}
 			
 			else if (message.equals("GameCreateSuccess")) {
 				lobc.gameCreateSuccess();
 			}
 		}
 		
 		else if (arg0 instanceof Long) {
 			this.setId(((Long) arg0).longValue());
 		}
 		
// 		else if (arg0 instanceof ArrayList) {
// 			loginc.loginSuccessful();
// 		}
 		
 		else if (arg0 instanceof HashMap) {
 			lobc.displayOnlineGames((HashMap<String, Game>) arg0);
 		}
 		
 		else if (arg0 instanceof Error) {
 			Error error = (Error)arg0;

 			if (error.getType().equals("Login")) {
 				loginc.displayError(error.getMessage());
 			}
      
 			else if (error.getType().equals("CreateAccount")) {
 				cac.displayError(error.getMessage());
 			}
 		}
 	}  
}
