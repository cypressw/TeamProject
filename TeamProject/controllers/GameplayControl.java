package controllers;

import javax.swing.*;

import database.Game;
import gamedetails.Space;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.io.IOException;

public class GameplayControl implements ActionListener {
	private GameplayData data;
	private GameClient client;
	private JPanel container;
	
	public GameplayControl(JPanel container, GameClient client) {
		this.container = container;
		this.client = client;
	}
	
	public void actionPerformed(ActionEvent ae) {
		String cellValue = ae.getActionCommand();
		System.out.println("Cell " + cellValue + " has been selected!");
	}
	
	public void guess() {
		
	}
	
	public void switchPlayers() {
		Game temp = data.getGame();
	}
	
	public void showHitMiss() {
		
	}

	public GameplayData getData() {
		return data;
	}

	public void setData(GameplayData data) {
		this.data = data;
	}

	public GameClient getClient() {
		return client;
	}

	public void setClient(GameClient client) {
		this.client = client;
	}

	public JPanel getContainer() {
		return container;
	}

	public void setContainer(JPanel container) {
		this.container = container;
	}
	
	public void setSpace(int col, int row, JButton button) {
		
	}
}
