package controllers;

import database.*;
import javax.swing.*;
import ocsf.client.*;

public class GameClient extends AbstractClient{
	private Player user;
	private JPanel container;
	private LoginControl loginc;
	private LobbyControl lobc;
	private AwaitOpponentControl aoc;
	private GameplayControl gpc;
	private BoardSetupControl bsc;
	private WinLoseControl wlc;
	private LogoutControl logout;
	
	public GameClient() {
		super("localhost", 8300);
	}

	@Override
	protected void handleMessageFromServer(Object arg0) {
		// TODO Auto-generated method stub
		
	}
}
