package UI;

import java.awt.CardLayout;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameGUI extends JFrame {
	//private GameClient client; 
	private CardLayout cardLayout;
	
	public GameGUI() {
		this.setTitle("BATTLESHIP!");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		cardLayout = new CardLayout();
	    JPanel container = new JPanel(cardLayout);
	    
	    // controllers will go here
	    
	    // client info goes here (possibly also other server setup stuff!)
	    
	    // views setup + add to container
	    JPanel InitialPanel = new InitialPanel();
	    JPanel LoginPanel = new LoginPanel();
	    JPanel CreateAccountPanel = new CreateAccountPanel();
	    JPanel AwaitOpponentPanel = new AwaitOpponentPanel();
	    JPanel BoardSetupPanel = new BoardSetupPanel();
	    JPanel LobbyPanel = new LobbyPanel();
	    JPanel GameplayPanel = new GameplayPanel();
	    JPanel WinLosePanel = new LogOutPanel("");
	    JPanel LogOutPanel = new LogOutPanel("");
	    
	    container.add(InitialPanel, "1");
	    container.add(LoginPanel, "2");
	    container.add(CreateAccountPanel, "3");
	    container.add(AwaitOpponentPanel, "4");
	    container.add(BoardSetupPanel, "5");
	    container.add(LobbyPanel, "6");
	    container.add(GameplayPanel, "7");
	    container.add(WinLosePanel, "8");
	    container.add(LogOutPanel, "9");
	    
	    cardLayout.show(container, "1");
	    
	    this.setLayout(new GridBagLayout());
	    this.add(container);

	    this.setSize(550, 350);
	    this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new GameGUI();
	}
}
