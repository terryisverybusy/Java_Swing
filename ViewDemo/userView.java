
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class userView extends JFrame implements ActionListener {

	private JPanel cards;
	// login page
	private JLabel userLabel;
	private JTextField userText;
	private JLabel passwordLabel;
	private JPasswordField passwordText;
	private JButton loginButton;
	private JButton registerButton;

	// personal information page
	private JLabel birthdayLabel;
	private JTextField birthdayText;
	private JLabel ageLabel;
	private JTextField ageText;
	private JLabel SSNLabel;
	private JTextField SSNText;
	private JLabel addressLabel;
	private JTextField addressText;
	private JButton signOutButton;

	public void addComponentToPane(Container pane) {
		// create cards
		JPanel card1 = new JPanel();
		JPanel card2 = new JPanel();

		// login view component initialize
		JLabel userLabel = new JLabel("User");
		userLabel.setBounds(10, 10, 80, 25);
		JTextField userText = new JTextField(20);
		userText.setBounds(100, 10, 160, 25);
		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(10, 40, 80, 25);
		JPasswordField passwordText = new JPasswordField(20);
		passwordText.setBounds(100, 40, 160, 25);
		JButton loginButton = new JButton("login");
		loginButton.setBounds(10, 80, 80, 25);
		JButton registerButton = new JButton("register");
		registerButton.setBounds(180, 80, 80, 25);
		// login view add listener
		loginButton.addActionListener(this);
		registerButton.addActionListener(this);
		
		// add to card1
		card1.add(loginButton);
		card1.add(registerButton);
		card1.add(userLabel);
		card1.add(userText);
		card1.add(passwordLabel);
		card1.add(passwordText);

		// personal information view initialize
		JLabel birthdayLabel = new JLabel("Birthday");
		birthdayLabel.setBounds(10, 40, 80, 25);
		JTextField birthdayText = new JTextField(20);
		birthdayText.setBounds(100, 40, 160, 25);
		JLabel ageLabel = new JLabel("Age");
		ageLabel.setBounds(10, 70, 80, 25);
		JTextField ageText = new JTextField(20);
		ageText.setBounds(100, 70, 160, 25);
		JLabel SSNLabel = new JLabel("SSN");
		SSNLabel.setBounds(10, 100, 80, 25);
		JTextField SSNText = new JTextField(20);
		SSNText.setBounds(100, 100, 160, 25);
		JLabel addressLabel = new JLabel("Address");
		addressLabel.setBounds(10, 130, 80, 25);
		JTextField addressText = new JTextField(20);
		addressText.setBounds(100, 130, 160, 25);
		JButton signOutButton = new JButton("Sign Out");
		signOutButton.setBounds(520, 10, 80, 25);
		//add to listener
		signOutButton.addActionListener(this);
		// add to card2
		card2.add(userLabel);
		card2.add(userText);
		card2.add(birthdayLabel);
		card2.add(birthdayText);
		card2.add(ageLabel);
		card2.add(ageText);
		card2.add(SSNLabel);
		card2.add(SSNText);
		card2.add(addressLabel);
		card2.add(addressText);
		card2.add(signOutButton);

		// create panel that contains cards
		cards = new JPanel(new CardLayout(600,600));
		
		cards.add(card1, "Card 1");
		cards.add(card2, "Card 2");
		pane.add(cards, BorderLayout.PAGE_START);
	}

	public void itemStateChanged(ItemEvent evt) {
		CardLayout cl = (CardLayout) (cards.getLayout());
		cl.show(cards, (String) evt.getItem());
	}

	public static void createAndShowGUI() {
		// create and setup window
		JFrame frame = new JFrame("Frame");
		frame.setSize(600, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// create and setup content pane
		userView main = new userView();
		main.setSize(600, 600);
		main.addComponentToPane(frame.getContentPane());

		// display window
		frame.pack();
		frame.setVisible(true);
	}

	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == registerButton) {

			CardLayout cl = (CardLayout) (cards.getLayout());
			cl.show(cards, "Card 2");

		}
		
		 else if (ae.getSource() == signOutButton) {
		  
		  CardLayout cl = (CardLayout) (cards.getLayout()); cl.show(cards,
		  "Card 1"); }
		 
	}

	public static void main(String[] args) {
		// set look and feel
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
		} catch (UnsupportedLookAndFeelException ex) {
			ex.printStackTrace();
		} catch (IllegalAccessException ex) {
			ex.printStackTrace();
		} catch (InstantiationException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		// turn off metal's bold fonts
		UIManager.put("swing.boldMetal", Boolean.FALSE);

		// schedule job for the event dispatch thread creating and showing GUI
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}
}
