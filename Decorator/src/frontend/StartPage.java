package frontend;

import javax.swing.JPanel;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import backend.User;

import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StartPage extends JPanel {

	/**
	 * Create the panel.
	 */
	public StartPage(User user) {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblWelcome = new JLabel("Welcome, " + user.getFirstName() + ".");
		lblWelcome.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblWelcome = new GridBagConstraints();
		gbc_lblWelcome.insets = new Insets(0, 0, 5, 0);
		gbc_lblWelcome.gridx = 1;
		gbc_lblWelcome.gridy = 0;
		add(lblWelcome, gbc_lblWelcome);
		
		JLabel lblWhatWouldYou = new JLabel("What would you like to do?");
		GridBagConstraints gbc_lblWhatWouldYou = new GridBagConstraints();
		gbc_lblWhatWouldYou.anchor = GridBagConstraints.WEST;
		gbc_lblWhatWouldYou.insets = new Insets(0, 0, 5, 5);
		gbc_lblWhatWouldYou.gridx = 0;
		gbc_lblWhatWouldYou.gridy = 1;
		add(lblWhatWouldYou, gbc_lblWhatWouldYou);
		
		JButton btnCreateNewRoom = new JButton("Create new room");

		GridBagConstraints gbc_btnCreateNewRoom = new GridBagConstraints();
		gbc_btnCreateNewRoom.anchor = GridBagConstraints.WEST;
		gbc_btnCreateNewRoom.insets = new Insets(0, 0, 5, 5);
		gbc_btnCreateNewRoom.gridx = 0;
		gbc_btnCreateNewRoom.gridy = 2;
		add(btnCreateNewRoom, gbc_btnCreateNewRoom);
		
		JButton btnEditAnExisting = new JButton("Edit an existing room");
		GridBagConstraints gbc_btnEditAnExisting = new GridBagConstraints();
		gbc_btnEditAnExisting.anchor = GridBagConstraints.WEST;
		gbc_btnEditAnExisting.insets = new Insets(0, 0, 5, 5);
		gbc_btnEditAnExisting.gridx = 0;
		gbc_btnEditAnExisting.gridy = 3;
		add(btnEditAnExisting, gbc_btnEditAnExisting);
		
		JLabel label = new JLabel(" ");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 0;
		gbc_label.gridy = 4;
		add(label, gbc_label);
		
		JButton btnCreateNewFurniture = new JButton("Create new furniture");
		GridBagConstraints gbc_btnCreateNewFurniture = new GridBagConstraints();
		gbc_btnCreateNewFurniture.anchor = GridBagConstraints.WEST;
		gbc_btnCreateNewFurniture.insets = new Insets(0, 0, 5, 5);
		gbc_btnCreateNewFurniture.gridx = 0;
		gbc_btnCreateNewFurniture.gridy = 5;
		add(btnCreateNewFurniture, gbc_btnCreateNewFurniture);
		
		JButton btnEditExitingFurniture = new JButton("Edit exiting furniture");
		GridBagConstraints gbc_btnEditExitingFurniture = new GridBagConstraints();
		gbc_btnEditExitingFurniture.anchor = GridBagConstraints.WEST;
		gbc_btnEditExitingFurniture.insets = new Insets(0, 0, 0, 5);
		gbc_btnEditExitingFurniture.gridx = 0;
		gbc_btnEditExitingFurniture.gridy = 6;
		add(btnEditExitingFurniture, gbc_btnEditExitingFurniture);

		
		
		btnCreateNewRoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Driver.roomFrame = new CreateRoom();
				Driver.roomFrame.setVisible(true);
			}
		});
		
	}

}
