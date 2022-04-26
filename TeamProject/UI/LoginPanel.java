package UI;

import java.awt.Color;
import java.awt.Dimension;

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
		
		JLabel lblLogIn = new JLabel("LOGIN");
		lblLogIn.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogIn.setFont(new Font("Modern No. 20", Font.BOLD, 60));
		lblLogIn.setBounds(176, 93, 479, 67);
		add(lblLogIn);
		
		usernameField = new JTextField();
		usernameField.setBounds(293, 199, 362, 30);
		add(usernameField);
		usernameField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setColumns(10);
		passwordField.setBounds(293, 240, 362, 30);
		add(passwordField);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Modern No. 20", Font.PLAIN, 30));
		lblUsername.setBounds(160, 195, 222, 30);
		add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Modern No. 20", Font.PLAIN, 30));
		lblPassword.setBounds(160, 240, 222, 30);
		add(lblPassword);
		
		JButton btnGo = new JButton("GO!");
		btnGo.setFont(new Font("Modern No. 20", Font.PLAIN, 25));
		btnGo.setBounds(230, 285, 166, 45);
		btnGo.addActionListener(lc);
		add(btnGo);
		
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Modern No. 20", Font.PLAIN, 25));
		btnBack.setBounds(434, 285, 166, 45);
		btnBack.addActionListener(lc);
		add(btnBack);
		
		errorLabel = new JLabel("");
		errorLabel.setHorizontalAlignment(SwingConstants.CENTER);
		errorLabel.setFont(new Font("Modern No. 20", Font.PLAIN, 25));
		errorLabel.setBounds(33, 427, 732, 67);
		add(errorLabel);
		
		this.setPreferredSize(new Dimension(800, 545));
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
