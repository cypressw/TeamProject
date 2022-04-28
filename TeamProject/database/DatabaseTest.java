package database;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class DatabaseTest {
	String[] users = {"jsmith@uca.edu","msmith@uca.edu","tjones@yahoo.com","jjones@yahoo.com", "llewis", "rowang"};
	String[] passwords = {"hello123","pass123","123456","hello1234", "hello123", "henlo123"};
	private Database db;
	private int rando;
	
	public DatabaseTest() {
		db = null;
		rando = 0;
	}

	@Before
	public void setUp() throws Exception {
		rando = ((int)Math.random()*users.length);
	}

	@Test
	public void testSetConnection() {
		db = new Database("./database/db.properties");
		
		Connection temp = db.getConnection();
		
		assertNotNull(temp);
	}

	@Test
	public void testQuery() {
		Connection temp;
		String toProcess = "";
		String username = users[rando];
		ArrayList<String> result;
		String password;
		
		try {
			db = new Database("./database/db.properties");
		} catch(Exception e) {
			e.printStackTrace();
		};
		
		temp = db.getConnection();
		
		if (temp == null) {
			fail("Connection failed.");
		}
		else {
			toProcess = "SELECT aes_decrypt(`password`, \'key\') FROM `users` WHERE `username` = \'" + username + "\';";
			result = db.query(toProcess);
			password = result.get(0);
			assertEquals(password, passwords[rando]);
		}
	}

	@Test
	public void testExecuteDML() throws SQLException {
		Connection temp;
		String toProcess = "";
		
		try {
			db = new Database("./database/db.properties");
		} catch(Exception e) {
			e.printStackTrace();
		};
		
		temp = db.getConnection();
		
		if (temp == null) {
			fail("Connection failed.");
		}
		else {
			toProcess = "INSERT INTO users(`username`, `password`) VALUES (\'llewis@uca.edu\', aes_encrypt(\'cooldude45\', \'key11\'));";
			db.executeDML(toProcess);
		}
	}

}
