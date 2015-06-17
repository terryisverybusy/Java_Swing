
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class carInfo {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Car Information");
		frame.setSize(600, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		frame.add(panel);
		placeComponents(panel);

		frame.setVisible(true);
	}

	private static void placeComponents(JPanel panel) {

		panel.setLayout(null);

		JLabel brandLabel = new JLabel("Brand");
		brandLabel.setBounds(10, 10, 80, 25);
		panel.add(brandLabel);

		JTextField brandText = new JTextField(20);
		brandText.setBounds(100, 10, 160, 25);
		panel.add(brandText);

		JLabel valueLabel = new JLabel("Value");
		valueLabel.setBounds(10, 40, 80, 25);
		panel.add(valueLabel);
		
		JTextField valueText = new JTextField(20);
		valueText.setBounds(100, 40, 160, 25);
		panel.add(valueText);
		
		JLabel powerLabel = new JLabel("Power");
		powerLabel.setBounds(10, 70, 80, 25);
		panel.add(powerLabel);
		
		JTextField powerText = new JTextField(20);
		powerText.setBounds(100, 70, 160, 25);
		panel.add(powerText);
		
		JLabel yearsLabel = new JLabel("Years");
		yearsLabel.setBounds(10, 100, 80, 25);
		panel.add(yearsLabel);
		
		JTextField yearsText = new JTextField(20);
		yearsText.setBounds(100, 100, 160, 25);
		panel.add(yearsText);
		
		JLabel milesLabel = new JLabel("miles");
		milesLabel.setBounds(10, 130, 80, 25);
		panel.add(milesLabel);
		
		JTextField milesText = new JTextField(20);
		milesText.setBounds(100, 130, 160, 25);
		panel.add(milesText);
		
		JLabel modelLabel = new JLabel("model");
		modelLabel.setBounds(10, 160, 80, 25);
		panel.add(modelLabel);
		
		JTextField modelText = new JTextField(20);
		modelText.setBounds(100, 160, 160, 25);
		panel.add(modelText);
		
		JLabel IDLabel = new JLabel("ID");
		IDLabel.setBounds(10, 190, 80, 25);
		panel.add(IDLabel);
		
		JTextField IDText = new JTextField(20);
		IDText.setBounds(100, 190, 160, 25);
		panel.add(IDText);
		
		JButton signOutButton = new JButton("Sign Out");
		signOutButton.setBounds(520, 10, 80, 25);
		panel.add(signOutButton);
		
	}

}