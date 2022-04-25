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
		lblLogIn.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogIn.setFont(new Font("Modern No. 20", Font.BOLD, 60));
		lblLogIn.setBounds(87, 98, 622, 67);
		add(lblLogIn);
		
		usernameField = new JTextField();
		usernameField.setBounds(293, 199, 362, 30);
		add(usernameField);
		usernameField.setColumns(10);
		
		password = new JPasswordField();
		password.setColumns(10);
		password.setBounds(293, 240, 362, 30);
		add(password);
		
		verifyPassword = new JPasswordField();
		verifyPassword.setColumns(10);
		verifyPassword.setBounds(293, 285, 362, 30);
		add(verifyPassword);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Modern No. 20", Font.PLAIN, 30));
		lblUsername.setBounds(160, 195, 222, 30);
		add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Modern No. 20", Font.PLAIN, 30));
		lblPassword.setBounds(160, 240, 222, 30);
		add(lblPassword);
		
		JLabel lblVerifyPassword = new JLabel("Verify Password:");
		lblVerifyPassword.setFont(new Font("Modern No. 20", Font.PLAIN, 30));
		lblVerifyPassword.setBounds(72, 281, 222, 30);
		add(lblVerifyPassword);
		
		JButton btnGo = new JButton("GO!");
		btnGo.setFont(new Font("Modern No. 20", Font.PLAIN, 25));
		btnGo.setBounds(232, 337, 166, 45);
		btnGo.addActionListener(cac);
		add(btnGo);
		
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Modern No. 20", Font.PLAIN, 25));
		btnBack.setBounds(436, 337, 166, 45);
		btnBack.addActionListener(cac);
		add(btnBack);
		
		errorLabel = new JLabel("");
		errorLabel.setHorizontalAlignment(SwingConstants.CENTER);
		errorLabel.setFont(new Font("Modern No. 20", Font.PLAIN, 25));
		errorLabel.setBounds(33, 427, 732, 67);
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
