
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class personalInfo {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Personal Information");
		frame.setSize(600, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		frame.add(panel);
		placeComponents(panel);

		frame.setVisible(true);
	}

	private static void placeComponents(JPanel panel) {

		panel.setLayout(null);

		JLabel userLabel = new JLabel("User");
		userLabel.setBounds(10, 10, 80, 25);
		panel.add(userLabel);

		JTextField userText = new JTextField(20);
		userText.setBounds(100, 10, 160, 25);
		panel.add(userText);

		JLabel birthdayLabel = new JLabel("Birthday");
		birthdayLabel.setBounds(10, 40, 80, 25);
		panel.add(birthdayLabel);
		
		JTextField birthdayText = new JTextField(20);
		birthdayText.setBounds(100, 40, 160, 25);
		panel.add(birthdayText);
		
		JLabel ageLabel = new JLabel("Age");
		ageLabel.setBounds(10, 70, 80, 25);
		panel.add(ageLabel);
		
		JTextField ageText = new JTextField(20);
		ageText.setBounds(100, 70, 160, 25);
		panel.add(ageText);
		
		JLabel SSNLabel = new JLabel("SSN");
		SSNLabel.setBounds(10, 100, 80, 25);
		panel.add(SSNLabel);
		
		JTextField SSNText = new JTextField(20);
		SSNText.setBounds(100, 100, 160, 25);
		panel.add(SSNText);
		
		JLabel addressLabel = new JLabel("Address");
		addressLabel.setBounds(10, 130, 80, 25);
		panel.add(addressLabel);
		
		JTextField addressText = new JTextField(20);
		addressText.setBounds(100, 130, 160, 25);
		panel.add(addressText);
		
		JButton signOutButton = new JButton("Sign Out");
		signOutButton.setBounds(520, 10, 80, 25);
		panel.add(signOutButton);
		
	}

}