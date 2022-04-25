package controllers;

import database.*;
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
	
 	public void handleMessageFromServer(Object arg0) {
 		if (arg0 instanceof String) {
 			String message = (String)arg0;
      
 			if (message.equals("LoginSuccessful")) {
 				loginc.loginSuccessful();
 			}

 			else if (message.equals("CreateAccountSuccessful")) {
 				cac.createAccountSuccess();
 			}
 			else if (message.equals("GameSelected")) {
 				lobc.connectToGame();
 			}
 			else if (message.equals("CreateNewGame")) {
 				lobc.createNewGame();
 			}
 			else if (message.equals("OpponentConnected")) {
 				aoc.connectionDetected();
 			}
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
