package UI;

import java.awt.CardLayout;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import database.Database;
import controllers.*;

public class GameGUI extends JFrame {
	private GameClient client; 
	private CardLayout cardLayout;
	private Database db;
	private JPanel container;
	
	public GameGUI() {
		client = new GameClient();
		client.setHost("localhost");
		client.setPort(8300);
		try {
			client.openConnection();
		} catch (Exception e) {
			e.printStackTrace();
		};
		
		this.setTitle("BATTLESHIP!");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		db = new Database("./TeamProject/database/db.properties");
		
		cardLayout = new CardLayout();
	    container = new JPanel(cardLayout);
	    
	    // controllers will go here (add client as parameter later)
	    InitialControl ic = new InitialControl(container, client);
	    LoginControl lc = new LoginControl(container, client);
	    CreateAccountControl cac = new CreateAccountControl(container, client);
	    AwaitOpponentControl aoc = new AwaitOpponentControl(container, client);
	    BoardSetupControl bsc = new BoardSetupControl(container, client);
	    LobbyControl lobc = new LobbyControl(container, client);
	    GameplayControl gc = new GameplayControl(container, client);
	    WinLoseControl wlc = new WinLoseControl(container, client);
	    LogoutControl loc = new LogoutControl(container, client);
	    
	    // views setup + add to container
	    JPanel InitialPanel = new InitialPanel(ic);
	    JPanel LoginPanel = new LoginPanel(lc);
	    JPanel CreateAccountPanel = new CreateAccountPanel(cac);
	    JPanel AwaitOpponentPanel = new AwaitOpponentPanel(aoc);
	    JPanel BoardSetupPanel = new BoardSetupPanel(bsc);
	    JPanel LobbyPanel = new LobbyPanel(lobc);
	    JPanel GameplayPanel = new GameplayPanel(gc);
	    JPanel WinLosePanel = new WinLosePanel(wlc);
	    JPanel LogOutPanel = new LogOutPanel("", loc);
	    
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
	    
	    this.add(container);

	    this.setSize(800, 575);
	    this.setResizable(true);
	    this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new GameGUI();
	}
}
