package frontend;

import javax.swing.JPanel;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import backend.User;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Registration extends JPanel {
	private JTextField textField_firstName;
	private JTextField textField_lastName;
	private JTextField textField_email;
	private JTextField textField_username;
	private JPasswordField passwordField;
	private JPasswordField passwordField_confirm;

	public static final String EMAIL = 
			"^\\s*([^@+]+)(?:[+](?:[^@]*))*@.*\\..+\\s*$";

	/**
	 * Create the panel.
	 */
	public Registration() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);

		JLabel lblRegistration = new JLabel("Registration");
		lblRegistration.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblRegistration = new GridBagConstraints();
		gbc_lblRegistration.insets = new Insets(0, 0, 5, 5);
		gbc_lblRegistration.gridx = 1;
		gbc_lblRegistration.gridy = 0;
		add(lblRegistration, gbc_lblRegistration);

		JLabel lblFirstName = new JLabel("First Name:");
		GridBagConstraints gbc_lblFirstName = new GridBagConstraints();
		gbc_lblFirstName.anchor = GridBagConstraints.WEST;
		gbc_lblFirstName.insets = new Insets(0, 0, 5, 5);
		gbc_lblFirstName.gridx = 0;
		gbc_lblFirstName.gridy = 1;
		add(lblFirstName, gbc_lblFirstName);

		textField_firstName = new JTextField();
		GridBagConstraints gbc_textField_firstName = new GridBagConstraints();
		gbc_textField_firstName.gridwidth = 2;
		gbc_textField_firstName.insets = new Insets(0, 0, 5, 5);
		gbc_textField_firstName.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_firstName.gridx = 1;
		gbc_textField_firstName.gridy = 1;
		add(textField_firstName, gbc_textField_firstName);
		textField_firstName.setColumns(10);

		JLabel lblLastName = new JLabel("Last Name:");
		GridBagConstraints gbc_lblLastName = new GridBagConstraints();
		gbc_lblLastName.anchor = GridBagConstraints.WEST;
		gbc_lblLastName.insets = new Insets(0, 0, 5, 5);
		gbc_lblLastName.gridx = 0;
		gbc_lblLastName.gridy = 2;
		add(lblLastName, gbc_lblLastName);

		textField_lastName = new JTextField();
		GridBagConstraints gbc_textField_lastName = new GridBagConstraints();
		gbc_textField_lastName.gridwidth = 2;
		gbc_textField_lastName.insets = new Insets(0, 0, 5, 5);
		gbc_textField_lastName.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_lastName.gridx = 1;
		gbc_textField_lastName.gridy = 2;
		add(textField_lastName, gbc_textField_lastName);
		textField_lastName.setColumns(10);

		JLabel lblYourEmail = new JLabel("Your email:");
		GridBagConstraints gbc_lblYourEmail = new GridBagConstraints();
		gbc_lblYourEmail.anchor = GridBagConstraints.WEST;
		gbc_lblYourEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblYourEmail.gridx = 0;
		gbc_lblYourEmail.gridy = 3;
		add(lblYourEmail, gbc_lblYourEmail);

		textField_email = new JTextField();
		GridBagConstraints gbc_textField_email = new GridBagConstraints();
		gbc_textField_email.gridwidth = 2;
		gbc_textField_email.insets = new Insets(0, 0, 5, 5);
		gbc_textField_email.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_email.gridx = 1;
		gbc_textField_email.gridy = 3;
		add(textField_email, gbc_textField_email);
		textField_email.setColumns(10);

		JLabel label = new JLabel(" ");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 0;
		gbc_label.gridy = 4;
		add(label, gbc_label);

		JLabel lblCreateAUsername = new JLabel("Create a username:");
		lblCreateAUsername.setToolTipText("This will be the username that you use to login.");
		GridBagConstraints gbc_lblCreateAUsername = new GridBagConstraints();
		gbc_lblCreateAUsername.anchor = GridBagConstraints.WEST;
		gbc_lblCreateAUsername.insets = new Insets(0, 0, 5, 5);
		gbc_lblCreateAUsername.gridx = 0;
		gbc_lblCreateAUsername.gridy = 5;
		add(lblCreateAUsername, gbc_lblCreateAUsername);

		textField_username = new JTextField();
		GridBagConstraints gbc_textField_username = new GridBagConstraints();
		gbc_textField_username.gridwidth = 2;
		gbc_textField_username.insets = new Insets(0, 0, 5, 5);
		gbc_textField_username.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_username.gridx = 1;
		gbc_textField_username.gridy = 5;
		add(textField_username, gbc_textField_username);
		textField_username.setColumns(10);

		JLabel lblCreateAPassword = new JLabel("Create a password:");
		GridBagConstraints gbc_lblCreateAPassword = new GridBagConstraints();
		gbc_lblCreateAPassword.anchor = GridBagConstraints.WEST;
		gbc_lblCreateAPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblCreateAPassword.gridx = 0;
		gbc_lblCreateAPassword.gridy = 6;
		add(lblCreateAPassword, gbc_lblCreateAPassword);

		passwordField = new JPasswordField();
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.gridwidth = 2;
		gbc_passwordField.insets = new Insets(0, 0, 5, 5);
		gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField.gridx = 1;
		gbc_passwordField.gridy = 6;
		add(passwordField, gbc_passwordField);

		JLabel lblConfirmPassword = new JLabel("Confirm password:");
		GridBagConstraints gbc_lblConfirmPassword = new GridBagConstraints();
		gbc_lblConfirmPassword.anchor = GridBagConstraints.WEST;
		gbc_lblConfirmPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblConfirmPassword.gridx = 0;
		gbc_lblConfirmPassword.gridy = 7;
		add(lblConfirmPassword, gbc_lblConfirmPassword);

		passwordField_confirm = new JPasswordField();
		GridBagConstraints gbc_passwordField_confirm = new GridBagConstraints();
		gbc_passwordField_confirm.gridwidth = 2;
		gbc_passwordField_confirm.insets = new Insets(0, 0, 5, 5);
		gbc_passwordField_confirm.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField_confirm.gridx = 1;
		gbc_passwordField_confirm.gridy = 7;
		add(passwordField_confirm, gbc_passwordField_confirm);

		JButton btnRegister = new JButton("Register");
		GridBagConstraints gbc_btnRegister = new GridBagConstraints();
		gbc_btnRegister.insets = new Insets(0, 0, 0, 5);
		gbc_btnRegister.gridx = 3;
		gbc_btnRegister.gridy = 9;
		add(btnRegister, gbc_btnRegister);
		btnRegister.setEnabled(false);

		//ACTION LISTONERS


		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Boolean available = true;

				String firstName = textField_firstName.getText();

				String lastName = textField_lastName.getText();

				String loginName = textField_username.getText().toLowerCase();
				for (User user : Driver.main.getUserList()) {
					if (user.getLoginName().equals(loginName)) {
						JOptionPane.showMessageDialog(null, "This username is not available,"
								+ " please try a different one.");
						available = false;
					}
				}

				String loginPass = passwordField.getText();
				String confirmPass = passwordField_confirm.getText();
				if (!loginPass.equals(confirmPass)) {
					JOptionPane.showMessageDialog(null, "These passwords do not match, please try again.");
					available = false;
				} else if (loginPass.length() < 6) {
					JOptionPane.showMessageDialog(null, "Your password must be atleast 6 characters long.");
					available = false;
				}

				String email = textField_email.getText();
				if (!email.matches(EMAIL)) {
					JOptionPane.showMessageDialog(null, "Please enter a valid email address.");
					available = false;
				}

				if (available) {
					User user = new User(firstName, lastName, loginName, 
							loginPass, email);

					Driver.main.writeUser(user);

					JOptionPane.showMessageDialog(null, "You have now been registered, thank you.");
					clear();
					Driver.registrationPanel.setVisible(false);
					Driver.loginPanel.setVisible(true);

				}

			}
		});


		textField_firstName.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				if (textField_firstName.getText().length() == 0 || textField_lastName.getText().length() == 0
						|| textField_email.getText().length() == 0 || textField_username.getText().length() == 0
						|| passwordField.getText().length() == 0 || passwordField_confirm.getText().length() == 0) {
					btnRegister.setEnabled(false);
				} else {
					btnRegister.setEnabled(true);
				}
			}
		});

		textField_lastName.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				if (textField_firstName.getText().length() == 0 || textField_lastName.getText().length() == 0
						|| textField_email.getText().length() == 0 || textField_username.getText().length() == 0
						|| passwordField.getText().length() == 0 || passwordField_confirm.getText().length() == 0) {
					btnRegister.setEnabled(false);
				} else {
					btnRegister.setEnabled(true);
				}
			}
		});

		textField_email.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				if (textField_firstName.getText().length() == 0 || textField_lastName.getText().length() == 0
						|| textField_email.getText().length() == 0 || textField_username.getText().length() == 0
						|| passwordField.getText().length() == 0 || passwordField_confirm.getText().length() == 0) {
					btnRegister.setEnabled(false);
				} else {
					btnRegister.setEnabled(true);
				}
			}
		});

		textField_username.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				if (textField_firstName.getText().length() == 0 || textField_lastName.getText().length() == 0
						|| textField_email.getText().length() == 0 || textField_username.getText().length() == 0
						|| passwordField.getText().length() == 0 || passwordField_confirm.getText().length() == 0) {
					btnRegister.setEnabled(false);
				} else {
					btnRegister.setEnabled(true);
				}
			}
		});

		passwordField.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				if (textField_firstName.getText().length() == 0 || textField_lastName.getText().length() == 0
						|| textField_email.getText().length() == 0 || textField_username.getText().length() == 0
						|| passwordField.getText().length() == 0 || passwordField_confirm.getText().length() == 0) {
					btnRegister.setEnabled(false);
				} else {
					btnRegister.setEnabled(true);
				}
			}
		});

		passwordField_confirm.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				if (textField_firstName.getText().length() == 0 || textField_lastName.getText().length() == 0
						|| textField_email.getText().length() == 0 || textField_username.getText().length() == 0
						|| passwordField.getText().length() == 0 || passwordField_confirm.getText().length() == 0) {
					btnRegister.setEnabled(false);
				} else {
					btnRegister.setEnabled(true);
				}
			}
		});


	}

	private void clear() {
		textField_firstName.setText(null);
		textField_lastName.setText(null);
		textField_email.setText(null);
		textField_username.setText(null);
		passwordField.setText(null);
		passwordField_confirm.setText(null);

	}

}
