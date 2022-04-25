package UI;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;

import controllers.CreateAccountControl;

import javax.swing.JButton;

public class CreateAccountPanel extends JPanel {
	private JTextField usernameField;
	private JPasswordField password;
	private JPasswordField verifyPassword;
	private JLabel errorLabel;
	private CreateAccountControl cac;
	
	public CreateAccountPanel(CreateAccountControl control) {
		setLayout(null);
		cac = control;
		
		JLabel lblLogIn = new JLabel("CREATE ACCOUNT");
		lblLogIn.setBounds(138, 21, 193, 22);
		lblLogIn.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogIn.setFont(new Font("Modern No. 20", Font.BOLD, 20));
		add(lblLogIn);
		
		usernameField = new JTextField();
		usernameField.setBounds(170, 65, 212, 22);
		usernameField.setColumns(10);
		add(usernameField);
		
		password = new JPasswordField();
		password.setBounds(170, 98, 212, 22);
		password.setColumns(10);
		add(password);
		
		verifyPassword = new JPasswordField();
		verifyPassword.setColumns(10);
		verifyPassword.setBounds(170, 131, 212, 22);
		add(verifyPassword);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(94, 69, 78, 14);
		lblUsername.setFont(new Font("Modern No. 20", Font.PLAIN, 16));
		add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(94, 102, 66, 14);
		lblPassword.setFont(new Font("Modern No. 20", Font.PLAIN, 16));
		add(lblPassword);
		
		JLabel lblVerifyPassword = new JLabel("Verify Password:");
		lblVerifyPassword.setFont(new Font("Modern No. 20", Font.PLAIN, 16));
		lblVerifyPassword.setBounds(50, 135, 110, 14);
		add(lblVerifyPassword);
		
		JButton btnGo = new JButton("GO!");
		btnGo.setBounds(124, 172, 78, 23);
		btnGo.setFont(new Font("Modern No. 20", Font.PLAIN, 13));
		btnGo.addActionListener(cac);
		add(btnGo);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(258, 172, 78, 23);
		btnBack.setFont(new Font("Modern No. 20", Font.PLAIN, 13));
		btnBack.addActionListener(cac);
		add(btnBack);
		
		errorLabel = new JLabel("");
		errorLabel.setBounds(37, 220, 363, 22);
		errorLabel.setFont(new Font("Modern No. 20", Font.PLAIN, 18));
		add(errorLabel);
		
	}
	
	public String getUsername() {
		return usernameField.getText();
	}
	
	public String getPassword() {
		return password.getText();
	}
	
	public String getVerifyPassword() {
		return verifyPassword.getText();
	}
	
	public void setError(String text, Color color) {
		errorLabel.setText(text);
		errorLabel.setBackground(color);
	}
	
	public void setError(JLabel errorL) {
		errorLabel = errorL;
	}
}
