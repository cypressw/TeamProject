package UI;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

import controllers.GameplayControl;
import gamedetails.Board;

public class GameplayPanel extends JPanel {
	private Board board;
	private JLabel infoLabel;
	private GameplayControl gpc;
	
	// add GamePlayControl c once avaliable
	public GameplayPanel(GameplayControl control) {
		gpc = control;
		
	}
	
	public void setInfo(String text, Color color) {
		
	}
}
