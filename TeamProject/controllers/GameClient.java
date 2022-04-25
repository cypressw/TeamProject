package controllers;

import database.*;
import javax.swing.*;
import ocsf.client.*;

import ocsf.client.AbstractClient;
import server.Error;

public class GameClient extends AbstractClient
{
	// Private data fields for storing the GUI controllers.
	private Player user;
	private JPanel container;
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

  // Setters for the GUI controllers.
  public void setLoginControl(LoginControl loginControl)
  {
    this.loginc = loginControl;
  }
  public void setCreateAccountControl(CreateAccountControl createAccountControl)
  {
    this.cac = createAccountControl;
  }
  
  // Method that handles messages from the server.
  public void handleMessageFromServer(Object arg0)
  {
    // If we received a String, figure out what this event is.
    if (arg0 instanceof String)
    {
      // Get the text of the message.
      String message = (String)arg0;
      
      // If we successfully logged in, tell the login controller.
      if (message.equals("LoginSuccessful"))
      {
        loginc.loginSuccessful();
      }
      
      // If we successfully created an account, tell the create account controller.
      else if (message.equals("CreateAccountSuccessful"))
      {
        cac.createAccountSuccess();
      }
    }
    
    // If we received an Error, figure out where to display it.
    else if (arg0 instanceof Error)
    {
      // Get the Error object.
      Error error = (Error)arg0;
      
      // Display login errors using the login controller.
      if (error.getType().equals("Login"))
      {
        loginc.displayError(error.getMessage());
      }
      
      // Display account creation errors using the create account controller.
      else if (error.getType().equals("CreateAccount"))
      {
        cac.displayError(error.getMessage());
      }
    }
  }  
}
