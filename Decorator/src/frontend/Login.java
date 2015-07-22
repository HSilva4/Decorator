package frontend;

import javax.swing.JPanel;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;

import backend.User;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JPanel {
	private JTextField textField_username;
	private JPasswordField textField_password;

	/**
	 * Create the panel.
	 */
	public Login() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblRoomDecorator = new JLabel("Room Decorator");
		lblRoomDecorator.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblRoomDecorator = new GridBagConstraints();
		gbc_lblRoomDecorator.insets = new Insets(0, 0, 5, 5);
		gbc_lblRoomDecorator.gridx = 2;
		gbc_lblRoomDecorator.gridy = 1;
		add(lblRoomDecorator, gbc_lblRoomDecorator);
		
		JLabel lblExistingUserLogin = new JLabel("Existing User? Login now:");
		GridBagConstraints gbc_lblExistingUserLogin = new GridBagConstraints();
		gbc_lblExistingUserLogin.anchor = GridBagConstraints.WEST;
		gbc_lblExistingUserLogin.insets = new Insets(0, 0, 5, 5);
		gbc_lblExistingUserLogin.gridx = 1;
		gbc_lblExistingUserLogin.gridy = 2;
		add(lblExistingUserLogin, gbc_lblExistingUserLogin);
		
		JLabel lblUsername = new JLabel("Username:");
		GridBagConstraints gbc_lblUsername = new GridBagConstraints();
		gbc_lblUsername.anchor = GridBagConstraints.WEST;
		gbc_lblUsername.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsername.gridx = 1;
		gbc_lblUsername.gridy = 3;
		add(lblUsername, gbc_lblUsername);
		
		textField_username = new JTextField();
		GridBagConstraints gbc_textField_username = new GridBagConstraints();
		gbc_textField_username.gridwidth = 2;
		gbc_textField_username.insets = new Insets(0, 0, 5, 5);
		gbc_textField_username.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_username.gridx = 2;
		gbc_textField_username.gridy = 3;
		add(textField_username, gbc_textField_username);
		textField_username.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		GridBagConstraints gbc_lblPassword = new GridBagConstraints();
		gbc_lblPassword.anchor = GridBagConstraints.WEST;
		gbc_lblPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblPassword.gridx = 1;
		gbc_lblPassword.gridy = 4;
		add(lblPassword, gbc_lblPassword);
		
		textField_password = new JPasswordField();
		GridBagConstraints gbc_textField_password = new GridBagConstraints();
		gbc_textField_password.gridwidth = 2;
		gbc_textField_password.insets = new Insets(0, 0, 5, 5);
		gbc_textField_password.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_password.gridx = 2;
		gbc_textField_password.gridy = 4;
		add(textField_password, gbc_textField_password);
		textField_password.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		GridBagConstraints gbc_btnLogin = new GridBagConstraints();
		gbc_btnLogin.insets = new Insets(0, 0, 5, 5);
		gbc_btnLogin.gridx = 4;
		gbc_btnLogin.gridy = 5;
		add(btnLogin, gbc_btnLogin);
		
		JLabel label = new JLabel(" ");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 4;
		gbc_label.gridy = 6;
		add(label, gbc_label);
		
		JLabel lblCreateAccountFor = new JLabel("Create account for free.");
		GridBagConstraints gbc_lblCreateAccountFor = new GridBagConstraints();
		gbc_lblCreateAccountFor.insets = new Insets(0, 0, 0, 5);
		gbc_lblCreateAccountFor.gridx = 1;
		gbc_lblCreateAccountFor.gridy = 7;
		add(lblCreateAccountFor, gbc_lblCreateAccountFor);
		
		JButton btnRegister = new JButton("Register");
		GridBagConstraints gbc_btnRegister = new GridBagConstraints();
		gbc_btnRegister.insets = new Insets(0, 0, 0, 5);
		gbc_btnRegister.gridx = 4;
		gbc_btnRegister.gridy = 7;
		add(btnRegister, gbc_btnRegister);
		
//ACTION LISTONERS		
		
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String username = textField_username.getText();
				@SuppressWarnings("deprecation")
				String password = textField_password.getText();
				
				for (User user : Driver.main.getUserList()) {
					if (user.getLoginName().equalsIgnoreCase(username) &&
							user.getLoginPass().equals(password)) {
						Driver.loginPanel.setVisible(false);
						Driver.startPanel = new StartPage(user);
						Driver.contentPane.add(Driver.startPanel);
						Driver.startPanel.setVisible(true);
					} else {
						JOptionPane.showMessageDialog(null, "The login name or password entered is incorrect.");
					}
					
				}
				
			}
		});
		
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Driver.registrationPanel = new Registration();
				Driver.contentPane.add(Driver.registrationPanel);
				Driver.loginPanel.setVisible(false);
				Driver.registrationPanel.setVisible(true);
			}
		});

	}

}
