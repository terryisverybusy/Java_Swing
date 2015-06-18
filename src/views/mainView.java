import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.*;

class mainView extends JFrame implements ActionListener {
	// component for the main view
	public static JTabbedPane tabbedPane;
	public JPanel welcomePanel;
	public JPanel registerPanel;
	public JPanel infoPanel;
	public JPanel claimPanel;

	// component for the welcome page
	public JButton welcomeLoginButton;
	public JButton welcomeRegisterButton;
	public JTextField welcomeUserField;
	public JPasswordField welcomePasswordField;

	// component for the register page
	public JButton registerSubmitButton;
	public JButton registerSignOutButton;
	public JTextField registerEmailText;
	public JTextField registerUserText;
	public JPasswordField registerPasswordText;
	public JTextField registerFNameText;
	public JTextField registerLNameText;
	public JFormattedTextField registerBirthdayText;
	public JTextField registerOccupationText;
	public JTextField registerAddressText;
	public JFormattedTextField registerLicenseDateText;
	public JTextField registerBrandText;
	public JTextField registerYearText;
	public JTextField registerModelText;
	public JTextField registerMilesText;
	public JTextField registerBasePriceText;
	public JComboBox typeList;
	public JComboBox durationList;
	public JComboBox usageList;
	public JButton registerSubmitButton2;
	public JButton registerSubmitButton3;

	// component for the personal information page
	public JButton infoSubmitButton;
	public JButton infoSignOutButton;
	public JTextField infoEmailText;
	public JTextField infoFNameText;
	public JTextField infoLNameText;
	public JFormattedTextField infoBirthdayText;
	public JTextField infoOccupationText;
	public JTextField infoAddressText;
	public JFormattedTextField infoLicenseDateText;
	public JTextField infoBrandText;
	public JTextField infoYearText;
	public JTextField infoModelText;
	public JTextField infoMilesText;
	public JTextField infoBasePriceText;
	public JTextField infoTypeText;
	public JTextField infoDurationText;

	// component for the claim report
	public JTextField claimTitleText;
	public JTextField claimContentText;
	public JButton claimSignOutButton;
	public JButton claimSubmitButton;

	public mainView() {
		// NOTE: to reduce the amount of code in this example, it uses
		// panels with a NULL layout. This is NOT suitable for
		// production code since it may not display correctly for
		// a look-and-feel.

		setTitle("Insurance Application");
		setSize(800, 800);
		setBackground(Color.BLUE);

		JPanel topPanel = new JPanel();
		topPanel.setLayout(new BorderLayout());
		getContentPane().add(topPanel);

		// Create all the tab pages
		createWelcome();
		createRegister();
		createInfo();
		createClaim();

		// Create a tabbed pane
		tabbedPane = new JTabbedPane();
		tabbedPane.addTab("Welcome Page", welcomePanel);
		tabbedPane.addTab("Register Page", registerPanel);
		tabbedPane.addTab("Information page", infoPanel);
		tabbedPane.addTab("Claim page", claimPanel);
		// add to the topPanel
		topPanel.add(tabbedPane, BorderLayout.CENTER);

	}

	// create the welcome page
	public void createWelcome() {
		welcomePanel = new JPanel();
		welcomePanel.setLayout(null);

		JLabel userLabel = new JLabel("Username:");
		userLabel.setBounds(10, 15, 150, 20);
		welcomePanel.add(userLabel);

		welcomeUserField = new JTextField();
		welcomeUserField.setBounds(10, 35, 150, 20);
		welcomePanel.add(welcomeUserField);

		JLabel passwordLabel = new JLabel("Password:");
		passwordLabel.setBounds(10, 60, 150, 20);
		welcomePanel.add(passwordLabel);

		welcomePasswordField = new JPasswordField();
		welcomePasswordField.setBounds(10, 80, 150, 20);
		welcomePanel.add(welcomePasswordField);

		welcomeLoginButton = new JButton("login");
		welcomeLoginButton.setBounds(10, 120, 80, 25);
		welcomePanel.add(welcomeLoginButton);
		welcomeLoginButton.addActionListener(this);

		welcomeRegisterButton = new JButton("register");
		welcomeRegisterButton.setBounds(180, 120, 80, 25);
		welcomePanel.add(welcomeRegisterButton);
		welcomeRegisterButton.addActionListener(this);
	}

	// create the register page
	public void createRegister() {
		registerPanel = new JPanel();
		registerPanel.setLayout(null);

		JLabel userLabel = new JLabel("Username");
		userLabel.setBounds(300, 10, 80, 25);
		registerPanel.add(userLabel);
		
		this.registerUserText = new JTextField(20);
		this.registerUserText.setBounds(370, 10, 160, 25);
		registerPanel.add(this.registerUserText);

		JLabel emailLabel = new JLabel("Email");
		emailLabel.setBounds(10, 10, 80, 25);
		registerPanel.add(emailLabel);
		
		this.registerEmailText = new JTextField(20);
		this.registerEmailText.setBounds(100, 10, 160, 25);
		registerPanel.add(this.registerEmailText);
	
		this.registerEmailText = new JTextField(20);
		this.registerEmailText.setBounds(100, 10, 160, 25);
		registerPanel.add(this.registerEmailText);

		JLabel fNameLabel = new JLabel("first Name");
		fNameLabel.setBounds(10, 40, 80, 25);
		registerPanel.add(fNameLabel);

		registerFNameText = new JTextField(20);
		registerFNameText.setBounds(100, 40, 160, 25);
		registerPanel.add(registerFNameText);
		
		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(300, 40, 80, 25);
		registerPanel.add(passwordLabel);

		registerPasswordText = new JPasswordField(20);
		registerPasswordText.setBounds(370, 40, 160, 25);
		registerPanel.add(registerPasswordText);

		JLabel lNameLabel = new JLabel("last Name");
		lNameLabel.setBounds(10, 70, 80, 25);
		registerPanel.add(lNameLabel);

		registerLNameText = new JTextField(20);
		registerLNameText.setBounds(100, 70, 160, 25);
		registerPanel.add(registerLNameText);

		JLabel birthdayLabel = new JLabel("Birthday");
		birthdayLabel.setBounds(10, 100, 80, 25);
		registerPanel.add(birthdayLabel);

		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		JFormattedTextField registerBirthdayText = new JFormattedTextField(df);
		registerBirthdayText.setBounds(100, 100, 160, 25);
		registerPanel.add(registerBirthdayText);

		JLabel occupationLabel = new JLabel("Occupation");
		occupationLabel.setBounds(10, 130, 80, 25);
		registerPanel.add(occupationLabel);

		registerOccupationText = new JTextField(20);
		registerOccupationText.setBounds(100, 130, 160, 25);
		registerPanel.add(registerOccupationText);

		JLabel addressLabel = new JLabel("Address");
		addressLabel.setBounds(10, 160, 80, 25);
		registerPanel.add(addressLabel);

		registerAddressText = new JTextField(20);
		registerAddressText.setBounds(100, 160, 160, 25);
		registerPanel.add(registerAddressText);

		JLabel licenseDateLabel = new JLabel("License Date");
		licenseDateLabel.setBounds(10, 190, 80, 25);
		registerPanel.add(licenseDateLabel);

		registerLicenseDateText = new JFormattedTextField(df);
		registerLicenseDateText.setBounds(100, 190, 160, 25);
		registerPanel.add(registerLicenseDateText);

		JLabel brandLabel = new JLabel("Brand");
		brandLabel.setBounds(10, 220, 80, 25);
		registerPanel.add(brandLabel);

		registerBrandText = new JTextField(20);
		registerBrandText.setBounds(100, 220, 160, 25);
		registerPanel.add(registerBrandText);

		JLabel yearLabel = new JLabel("Year");
		yearLabel.setBounds(10, 250, 80, 25);
		registerPanel.add(yearLabel);

		registerYearText = new JTextField(20);
		registerYearText.setBounds(100, 250, 160, 25);
		registerPanel.add(registerYearText);

		JLabel modelLabel = new JLabel("model");
		modelLabel.setBounds(10, 280, 80, 25);
		registerPanel.add(modelLabel);

		registerModelText = new JTextField(20);
		registerModelText.setBounds(100, 280, 160, 25);
		registerPanel.add(registerModelText);

		JLabel milesLabel = new JLabel("miles");
		milesLabel.setBounds(10, 310, 80, 25);
		registerPanel.add(milesLabel);

		registerMilesText = new JTextField(20);
		registerMilesText.setBounds(100, 310, 160, 25);
		registerPanel.add(registerMilesText);

		JLabel basePriceLabel = new JLabel("basePrice");
		basePriceLabel.setBounds(10, 340, 80, 25);
		registerPanel.add(basePriceLabel);

		registerBasePriceText = new JTextField(20);
		registerBasePriceText.setBounds(100, 340, 160, 25);
		registerPanel.add(registerBasePriceText);

		JLabel typeLabel = new JLabel("type");
		typeLabel.setBounds(10, 450, 80, 25);
		registerPanel.add(typeLabel);

		String[] typeListString = new String[] { "CI", "TPO", "TPFT" };
		typeList = new JComboBox<String>(typeListString);
		typeList.setBounds(100, 450, 160, 25);
		registerPanel.add(typeList);

		JLabel durationLabel = new JLabel("duration");
		durationLabel.setBounds(10, 480, 80, 25);
		registerPanel.add(durationLabel);

		String[] durationListString = new String[] { "HALF", "ONE" };
		durationList = new JComboBox<String>(durationListString);
		durationList.setBounds(100, 480, 160, 25);
		registerPanel.add(durationList);

		JLabel usageLabel = new JLabel("usage");
		usageLabel.setBounds(10, 510, 80, 25);
		registerPanel.add(usageLabel);

		String[] usageListString = new String[] { "LOW", "MID", "HEAVY" };
		usageList = new JComboBox<String>(usageListString);
		usageList.setBounds(100, 510, 160, 25);
		registerPanel.add(usageList);

		registerSignOutButton = new JButton("Sign Out");
		registerSignOutButton.setBounds(700, 10, 80, 25);
		registerSignOutButton.addActionListener(this);
		registerPanel.add(registerSignOutButton);

		registerSubmitButton = new JButton("Submit");
		registerSubmitButton.setBounds(100, 540, 80, 25);
		registerSubmitButton.addActionListener(this);
		registerPanel.add(registerSubmitButton);
	}

	// create the info page
	public void createInfo() {

		infoPanel = new JPanel();
		infoPanel.setLayout(null);

		JLabel emailLabel = new JLabel("Email");
		emailLabel.setBounds(10, 10, 80, 25);
		infoPanel.add(emailLabel);

		infoEmailText = new JTextField(20);
		infoEmailText.setBounds(100, 10, 160, 25);
		infoPanel.add(infoEmailText);

		JLabel fNameLabel = new JLabel("first Name");
		fNameLabel.setBounds(10, 40, 80, 25);
		infoPanel.add(fNameLabel);

		infoFNameText = new JTextField(20);
		infoFNameText.setBounds(100, 40, 160, 25);
		infoPanel.add(infoFNameText);

		JLabel lNameLabel = new JLabel("last Name");
		lNameLabel.setBounds(10, 70, 80, 25);
		infoPanel.add(lNameLabel);

		infoLNameText = new JTextField(20);
		infoLNameText.setBounds(100, 70, 160, 25);
		infoPanel.add(infoLNameText);

		JLabel birthdayLabel = new JLabel("Birthday");
		birthdayLabel.setBounds(10, 100, 80, 25);
		infoPanel.add(birthdayLabel);

		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		infoBirthdayText = new JFormattedTextField(df);
		infoBirthdayText.setBounds(100, 100, 160, 25);
		infoPanel.add(infoBirthdayText);

		JLabel occupationLabel = new JLabel("Occupation");
		occupationLabel.setBounds(10, 130, 80, 25);
		infoPanel.add(occupationLabel);

		infoOccupationText = new JTextField(20);
		infoOccupationText.setBounds(100, 130, 160, 25);
		infoPanel.add(infoOccupationText);

		JLabel addressLabel = new JLabel("Address");
		addressLabel.setBounds(10, 160, 80, 25);
		infoPanel.add(addressLabel);

		infoAddressText = new JTextField(20);
		infoAddressText.setBounds(100, 160, 160, 25);
		infoPanel.add(infoAddressText);

		JLabel licenseDateLabel = new JLabel("License Date");
		licenseDateLabel.setBounds(10, 190, 80, 25);
		infoPanel.add(licenseDateLabel);

		infoLicenseDateText = new JFormattedTextField(df);
		infoLicenseDateText.setBounds(100, 190, 160, 25);
		infoPanel.add(infoLicenseDateText);

		JLabel brandLabel = new JLabel("Brand");
		brandLabel.setBounds(10, 220, 80, 25);
		infoPanel.add(brandLabel);

		infoBrandText = new JTextField(20);
		infoBrandText.setBounds(100, 220, 160, 25);
		infoPanel.add(infoBrandText);

		JLabel yearLabel = new JLabel("Year");
		yearLabel.setBounds(10, 250, 80, 25);
		infoPanel.add(yearLabel);

		infoYearText = new JTextField(20);
		infoYearText.setBounds(100, 250, 160, 25);
		infoPanel.add(infoYearText);

		JLabel modelLabel = new JLabel("model");
		modelLabel.setBounds(10, 280, 80, 25);
		infoPanel.add(modelLabel);

		infoModelText = new JTextField(20);
		infoModelText.setBounds(100, 280, 160, 25);
		infoPanel.add(infoModelText);

		JLabel milesLabel = new JLabel("miles");
		milesLabel.setBounds(10, 310, 80, 25);
		infoPanel.add(milesLabel);

		infoMilesText = new JTextField(20);
		infoMilesText.setBounds(100, 310, 160, 25);
		infoPanel.add(infoMilesText);

		JLabel basePriceLabel = new JLabel("basePrice");
		basePriceLabel.setBounds(10, 340, 80, 25);
		infoPanel.add(basePriceLabel);

		infoBasePriceText = new JTextField(20);
		infoBasePriceText.setBounds(100, 340, 160, 25);
		infoPanel.add(infoBasePriceText);

		JLabel typeLabel = new JLabel("type");
		typeLabel.setBounds(10, 370, 80, 25);
		infoPanel.add(typeLabel);

		infoTypeText = new JTextField(20);
		infoTypeText.setBounds(100, 370, 160, 25);
		infoPanel.add(infoTypeText);

		JLabel durationLabel = new JLabel("duration");
		durationLabel.setBounds(10, 400, 80, 25);
		infoPanel.add(durationLabel);

		infoDurationText = new JTextField(20);
		infoDurationText.setBounds(100, 400, 160, 25);
		infoPanel.add(infoDurationText);

		infoSignOutButton = new JButton("Sign Out");
		infoSignOutButton.setBounds(480, 10, 80, 25);
		infoSignOutButton.addActionListener(this);
		infoPanel.add(infoSignOutButton);

		infoSubmitButton = new JButton("Submit");
		infoSubmitButton.setBounds(100, 430, 80, 25);
		infoSubmitButton.addActionListener(this);
		infoPanel.add(infoSubmitButton);
	}

	// create the claim report page
	public void createClaim() {

		claimPanel = new JPanel();
		claimPanel.setLayout(null);

		JLabel titleLabel = new JLabel("Title");
		titleLabel.setBounds(10, 10, 80, 25);
		claimPanel.add(titleLabel);

		claimTitleText = new JTextField(200);
		claimTitleText.setBounds(100, 10, 160, 25);
		claimPanel.add(claimTitleText);

		JLabel contentLabel = new JLabel("Content");
		contentLabel.setBounds(10, 50, 80, 25);
		claimPanel.add(contentLabel);

		claimContentText = new JTextField(300);
		claimContentText.setBounds(100, 40, 250, 250);
		claimPanel.add(claimContentText);

		claimSignOutButton = new JButton("Sign Out");
		claimSignOutButton.setBounds(480, 10, 80, 25);
		claimSignOutButton.addActionListener(this);
		claimPanel.add(claimSignOutButton);

		claimSubmitButton = new JButton("Submit");
		claimSubmitButton.setBounds(100, 300, 80, 25);
		claimSubmitButton.addActionListener(this);
		claimPanel.add(claimSubmitButton);
	}

	// Main method to get things started
	public static void main(String args[]) {
		// Create an instance of the test application
		mainView mainFrame = new mainView();
		mainFrame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == welcomeLoginButton) {
			tabbedPane.setSelectedIndex(2);

		}
		if (e.getSource() == welcomeRegisterButton) {
			tabbedPane.setSelectedIndex(1);
			// Example to get the value from the textField
			String temp = welcomeUserField.getText();
			System.out.println(temp);
		}
		if (e.getSource() == registerSignOutButton) {
			tabbedPane.setSelectedIndex(0);
		}
		if (e.getSource() == registerSubmitButton) {
			tabbedPane.setSelectedIndex(2);
			// example to get the value of the selected item
			String selected = (String) typeList.getSelectedItem();
			System.out.println("You seleted : " + selected);
		}
		if (e.getSource() == infoSignOutButton) {
			tabbedPane.setSelectedIndex(0);
		}
		if (e.getSource() == infoSubmitButton) {
			tabbedPane.setSelectedIndex(0);
		}
		if (e.getSource() == infoSubmitButton) {
			tabbedPane.setSelectedIndex(0);
		}
		if (e.getSource() == claimSignOutButton) {
			tabbedPane.setSelectedIndex(0);
		}

	}
}