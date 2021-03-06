package UI;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import controllers.*;

public class LoginPanel extends JPanel {
	private JTextField usernameField;
	private JPasswordField passwordField;
	private JLabel errorLabel;
	private LoginControl lc;
	
	public LoginPanel(LoginControl control) {
		setLayout(null);
		lc = control;
		
		JLabel lblLogIn = new JLabel("LOG IN");
		lblLogIn.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogIn.setFont(new Font("Modern No. 20", Font.BOLD, 20));
		lblLogIn.setBounds(80, 11, 284, 22);
		add(lblLogIn);
		
		usernameField = new JTextField();
		usernameField.setBounds(170, 65, 212, 22);
		add(usernameField);
		usernameField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setColumns(10);
		passwordField.setBounds(170, 98, 212, 22);
		add(passwordField);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Modern No. 20", Font.PLAIN, 16));
		lblUsername.setBounds(94, 69, 78, 14);
		add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Modern No. 20", Font.PLAIN, 16));
		lblPassword.setBounds(94, 102, 66, 14);
		add(lblPassword);
		
		JButton btnGo = new JButton("GO!");
		btnGo.setFont(new Font("Modern No. 20", Font.PLAIN, 13));
		btnGo.setBounds(122, 142, 89, 23);
		btnGo.addActionListener(lc);
		add(btnGo);
		
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Modern No. 20", Font.PLAIN, 13));
		btnBack.setBounds(241, 142, 89, 23);
		btnBack.addActionListener(lc);
		add(btnBack);
		
		errorLabel = new JLabel("");
		errorLabel.setFont(new Font("Modern No. 20", Font.PLAIN, 18));
		errorLabel.setBounds(48, 195, 363, 22);
		add(errorLabel);
	}
	
	public String getPassword() {
		return passwordField.getText();
	}
	
	public String getUsername() {
		return usernameField.getText();
	}
	
	public void setError(String text, Color color) {
		errorLabel.setText(text);
		errorLabel.setBackground(color);
	}
	
	public void setError(JLabel errorL) {
		errorLabel = errorL;
	}
}
