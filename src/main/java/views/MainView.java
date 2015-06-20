package views;

import controllers.MainController;
import dao.model.Policy;
import dao.model.User;
import dao.model.Vehicle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MainView extends JFrame implements ActionListener {
    //    private static MainView mv;
//
//    public static MainView getInstance() {
//        return mv == null ? new MainView() : mv;
//    }
//
    private static MainController mc = MainController.getInstance();

    private User user;
    private java.util.List<Vehicle> vehicles;
    private java.util.List<Policy> policies;


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
    public JTextField registerBirthdayText;
    public JTextField registerOccupationText;
    public JTextField registerAddressText;
    public JTextField registerLicenseDateText;
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
    public JLabel infoEmailText;
    public JLabel infoFNameText;
    public JLabel infoLNameText;
    public JLabel infoBirthdayText;
    public JLabel infoOccupationText;
    public JLabel infoAddressText;
    public JLabel infoLicenseDateText;
    public JLabel infoBrandText;
    public JLabel infoYearText;
    public JLabel infoModelText;
    public JLabel infoMilesText;
    public JLabel infoBasePriceText;
    public JLabel infoTypeText;
    public JLabel infoDurationText;
    public JLabel infoUsageText;
    public JLabel infoPriceText;

    // component for the claim report
    public JTextField claimTitleText;
    public JTextField claimContentText;
    public JButton claimSignOutButton;
    public JButton claimSubmitButton;

    public MainView() {
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
        userLabel.setBounds(200, 200, 150, 20);
        welcomePanel.add(userLabel);

        welcomeUserField = new JTextField();
        welcomeUserField.setBounds(270, 200, 150, 20);
        welcomePanel.add(welcomeUserField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(200, 230, 150, 20);
        welcomePanel.add(passwordLabel);

        welcomePasswordField = new JPasswordField();
        welcomePasswordField.setBounds(270, 230, 150, 20);
        welcomePanel.add(welcomePasswordField);

        welcomeLoginButton = new JButton("login");
        welcomeLoginButton.setBounds(270, 260, 80, 25);
        welcomePanel.add(welcomeLoginButton);
        welcomeLoginButton.addActionListener(this);

        welcomeRegisterButton = new JButton("register");
        welcomeRegisterButton.setBounds(350, 260, 80, 25);
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

//        this.registerEmailText = new JTextField(20);
//        this.registerEmailText.setBounds(100, 10, 160, 25);
//        registerPanel.add(this.registerEmailText);

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

        registerSubmitButton3 = new JButton("Submit");
        registerSubmitButton3.setBounds(370, 80, 80, 25);
        registerSubmitButton3.addActionListener(this);
        registerPanel.add(registerSubmitButton3);

        JLabel lNameLabel = new JLabel("last Name");
        lNameLabel.setBounds(10, 70, 80, 25);
        registerPanel.add(lNameLabel);

        registerLNameText = new JTextField(20);
        registerLNameText.setBounds(100, 70, 160, 25);
        registerPanel.add(registerLNameText);

        JLabel birthdayLabel = new JLabel("Birthday");
        birthdayLabel.setBounds(10, 100, 80, 25);
        registerPanel.add(birthdayLabel);

//        DateTimeFormatter df = new DateTimeFormatter()
        registerBirthdayText = new JTextField(20);
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

        registerLicenseDateText = new JTextField(20);
        registerLicenseDateText.setBounds(100, 190, 160, 25);
        registerPanel.add(registerLicenseDateText);

        JLabel brandLabel = new JLabel("Brand");
        brandLabel.setBounds(10, 270, 80, 25);
        registerPanel.add(brandLabel);

        registerBrandText = new JTextField(20);
        registerBrandText.setBounds(100, 270, 160, 25);
        registerPanel.add(registerBrandText);

        JLabel yearLabel = new JLabel("Year");
        yearLabel.setBounds(10, 300, 80, 25);
        registerPanel.add(yearLabel);

        registerYearText = new JTextField(20);
        registerYearText.setBounds(100, 300, 160, 25);
        registerPanel.add(registerYearText);

        JLabel modelLabel = new JLabel("model");
        modelLabel.setBounds(10, 330, 80, 25);
        registerPanel.add(modelLabel);

        registerModelText = new JTextField(20);
        registerModelText.setBounds(100, 330, 160, 25);
        registerPanel.add(registerModelText);

        JLabel milesLabel = new JLabel("miles");
        milesLabel.setBounds(10, 360, 80, 25);
        registerPanel.add(milesLabel);

        registerMilesText = new JTextField(20);
        registerMilesText.setBounds(100, 360, 160, 25);
        registerPanel.add(registerMilesText);

        JLabel basePriceLabel = new JLabel("basePrice");
        basePriceLabel.setBounds(10, 390, 80, 25);
        registerPanel.add(basePriceLabel);

        registerBasePriceText = new JTextField(20);
        registerBasePriceText.setBounds(100, 390, 160, 25);
        registerPanel.add(registerBasePriceText);

        registerSubmitButton2 = new JButton("Submit");
        registerSubmitButton2.setBounds(100, 420, 80, 25);
        registerSubmitButton2.addActionListener(this);
        registerPanel.add(registerSubmitButton2);

        JLabel typeLabel = new JLabel("type");
        typeLabel.setBounds(10, 480, 80, 25);
        registerPanel.add(typeLabel);

        String[] typeListString = new String[]{"CI", "TPO", "TPFT"};
        typeList = new JComboBox<String>(typeListString);
        typeList.setBounds(100, 480, 160, 25);
        registerPanel.add(typeList);

        JLabel durationLabel = new JLabel("duration");
        durationLabel.setBounds(10, 510, 80, 25);
        registerPanel.add(durationLabel);

        String[] durationListString = new String[]{"HALF", "ONE"};
        durationList = new JComboBox<String>(durationListString);
        durationList.setBounds(100, 510, 160, 25);
        registerPanel.add(durationList);

        JLabel usageLabel = new JLabel("usage");
        usageLabel.setBounds(10, 540, 80, 25);
        registerPanel.add(usageLabel);

        String[] usageListString = new String[]{"LOW", "MID", "HEAVY"};
        usageList = new JComboBox<String>(usageListString);
        usageList.setBounds(100, 540, 160, 25);
        registerPanel.add(usageList);

        registerSignOutButton = new JButton("Sign Out");
        registerSignOutButton.setBounds(700, 10, 80, 25);
        registerSignOutButton.addActionListener(this);
        registerPanel.add(registerSignOutButton);

        registerSubmitButton = new JButton("Submit");
        registerSubmitButton.setBounds(100, 570, 80, 25);
        registerSubmitButton.addActionListener(this);
        registerPanel.add(registerSubmitButton);
    }

    // create the info page
    public void createInfo() {

        infoPanel = new JPanel();
        infoPanel.setLayout(null);
        String defaultMessage = "N/A";

        JLabel emailLabel = new JLabel("Email");
        emailLabel.setBounds(10, 10, 80, 25);
        infoPanel.add(emailLabel);

        infoEmailText = new JLabel(defaultMessage);
        infoEmailText.setBounds(100, 10, 160, 25);
        infoPanel.add(infoEmailText);

        JLabel fNameLabel = new JLabel("first Name");
        fNameLabel.setBounds(10, 40, 80, 25);
        infoPanel.add(fNameLabel);

        infoFNameText = new JLabel(defaultMessage);
        infoFNameText.setBounds(100, 40, 160, 25);
        infoPanel.add(infoFNameText);

        JLabel lNameLabel = new JLabel("last Name");
        lNameLabel.setBounds(10, 70, 80, 25);
        infoPanel.add(lNameLabel);

        infoLNameText = new JLabel(defaultMessage);
        infoLNameText.setBounds(100, 70, 160, 25);
        infoPanel.add(infoLNameText);

        JLabel birthdayLabel = new JLabel("Birthday");
        birthdayLabel.setBounds(10, 100, 80, 25);
        infoPanel.add(birthdayLabel);

        infoBirthdayText = new JLabel(defaultMessage);
        infoBirthdayText.setBounds(100, 100, 160, 25);
        infoPanel.add(infoBirthdayText);

        JLabel occupationLabel = new JLabel("Occupation");
        occupationLabel.setBounds(10, 130, 80, 25);
        infoPanel.add(occupationLabel);

        infoOccupationText = new JLabel(defaultMessage);
        infoOccupationText.setBounds(100, 130, 160, 25);
        infoPanel.add(infoOccupationText);

        JLabel addressLabel = new JLabel("Address");
        addressLabel.setBounds(10, 160, 80, 25);
        infoPanel.add(addressLabel);

        infoAddressText = new JLabel(defaultMessage);
        infoAddressText.setBounds(100, 160, 160, 25);
        infoPanel.add(infoAddressText);

        JLabel licenseDateLabel = new JLabel("License Date");
        licenseDateLabel.setBounds(10, 190, 80, 25);
        infoPanel.add(licenseDateLabel);

        infoLicenseDateText = new JLabel(defaultMessage);
        infoLicenseDateText.setBounds(100, 190, 160, 25);
        infoPanel.add(infoLicenseDateText);

        JLabel brandLabel = new JLabel("Brand");
        brandLabel.setBounds(10, 220, 80, 25);
        infoPanel.add(brandLabel);

        infoBrandText = new JLabel(defaultMessage);
        infoBrandText.setBounds(100, 220, 160, 25);
        infoPanel.add(infoBrandText);

        JLabel yearLabel = new JLabel("Year");
        yearLabel.setBounds(10, 250, 80, 25);
        infoPanel.add(yearLabel);

        infoYearText = new JLabel(defaultMessage);
        infoYearText.setBounds(100, 250, 160, 25);
        infoPanel.add(infoYearText);

        JLabel modelLabel = new JLabel("model");
        modelLabel.setBounds(10, 280, 80, 25);
        infoPanel.add(modelLabel);

        infoModelText = new JLabel(defaultMessage);
        infoModelText.setBounds(100, 280, 160, 25);
        infoPanel.add(infoModelText);

        JLabel milesLabel = new JLabel("miles");
        milesLabel.setBounds(10, 310, 80, 25);
        infoPanel.add(milesLabel);

        infoMilesText = new JLabel(defaultMessage);
        infoMilesText.setBounds(100, 310, 160, 25);
        infoPanel.add(infoMilesText);

        JLabel basePriceLabel = new JLabel("basePrice");
        basePriceLabel.setBounds(10, 340, 80, 25);
        infoPanel.add(basePriceLabel);

        infoBasePriceText = new JLabel(defaultMessage);
        infoBasePriceText.setBounds(100, 340, 160, 25);
        infoPanel.add(infoBasePriceText);

        JLabel typeLabel = new JLabel("type");
        typeLabel.setBounds(10, 370, 80, 25);
        infoPanel.add(typeLabel);

        infoTypeText = new JLabel(defaultMessage);
        infoTypeText.setBounds(100, 370, 160, 25);
        infoPanel.add(infoTypeText);

        JLabel durationLabel = new JLabel("duration");
        durationLabel.setBounds(10, 400, 80, 25);
        infoPanel.add(durationLabel);

        infoDurationText = new JLabel(defaultMessage);
        infoDurationText.setBounds(100, 400, 160, 25);
        infoPanel.add(infoDurationText);

        JLabel usageLabel = new JLabel("usage");
        usageLabel.setBounds(10, 430, 80, 25);
        infoPanel.add(usageLabel);

        infoUsageText = new JLabel(defaultMessage);
        infoUsageText.setBounds(100, 430, 160, 25);
        infoPanel.add(infoUsageText);

        JLabel priceLabel = new JLabel("price");
        priceLabel.setBounds(10, 460, 80, 25);
        infoPanel.add(priceLabel);

        infoPriceText = new JLabel(defaultMessage);
        infoPriceText.setBounds(100, 460, 160, 25);
        infoPanel.add(infoPriceText);

        infoSignOutButton = new JButton("Sign Out");
        infoSignOutButton.setBounds(480, 10, 80, 25);
        infoSignOutButton.addActionListener(this);
        infoPanel.add(infoSignOutButton);

        infoSubmitButton = new JButton("report claim");
        infoSubmitButton.setBounds(100, 490, 150, 25);
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

        claimSubmitButton = new JButton("report claim");
        claimSubmitButton.setBounds(100, 300, 150, 25);
        claimSubmitButton.addActionListener(this);
        claimPanel.add(claimSubmitButton);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if (e.getSource() == welcomeLoginButton) {
            String userName = welcomeUserField.getText();
            String password = new String(welcomePasswordField.getPassword());
            if (mc.getWelcomeController().validate(userName, password)) {
                JOptionPane.showMessageDialog(null, "Success to Login");
                user = mc.getWelcomeController().getUser(userName);
                vehicles = mc.getWelcomeController().getVehicles(user.getId());
                policies = mc.getWelcomeController().getPolicies(user.getId());
                refreshInfo();



                tabbedPane.setSelectedIndex(2);
            } else {
                JOptionPane.showConfirmDialog(null, "wrong username or password");
            }
        }
        if (e.getSource() == welcomeRegisterButton) {
            vehicles = new ArrayList<>();
            policies = new ArrayList<>();
            tabbedPane.setSelectedIndex(1);
        }
        if (e.getSource() == registerSignOutButton) {
            JOptionPane.showMessageDialog(null, "Sign out from this account");
            signout();
            clearView();
            tabbedPane.setSelectedIndex(0);
        }
        if (e.getSource() == registerSubmitButton) {
            String type = (String) typeList.getSelectedItem();
            String duration = (String) durationList.getSelectedItem();
            String usage = (String) usageList.getSelectedItem();
            Policy p = mc.getRegisterController().addPolicy(vehicles.get(0), user, type, duration, usage);
            policies.add(p);
            tabbedPane.setSelectedIndex(2);
            refreshInfo();
            if (p == null)
                JOptionPane.showMessageDialog(null, "fail to create policy");
            else
                JOptionPane.showMessageDialog(null, "Success to submit policy");
        }

        if (e.getSource() == registerSubmitButton3) {
            String username = registerUserText.getText();
            String password = new String(registerPasswordText.getPassword());
            String email = registerEmailText.getText();
            String firstName = registerFNameText.getText();
            String lastName = registerLNameText.getText();
            String birthday = registerBirthdayText.getText();
            String occupation = registerOccupationText.getText();
            String address = registerAddressText.getText();
            String license = registerLicenseDateText.getText();
            user = mc.getRegisterController().addUser(username, password, email, firstName, lastName,
                    birthday, occupation, address, license);
            if (user == null)
                JOptionPane.showMessageDialog(null, "some fields went wrong");
            else
                JOptionPane.showMessageDialog(null, "Success to submit user profile");
        }

        if (e.getSource() == registerSubmitButton2) {
            String brand = registerBrandText.getText();
            String year = registerYearText.getText();
            String model = registerModelText.getText();
            String miles = registerMilesText.getText();
            String basePrice = registerBasePriceText.getText();
            Vehicle v = mc.getRegisterController().addVehicle(user.getId(), brand, year, model, miles, basePrice);
            vehicles.add(v);
            if (v == null)
                JOptionPane.showMessageDialog(null, "some fields went wrong");
            else
                JOptionPane.showMessageDialog(null, "Success to submit car profile");
        }

        if (e.getSource() == infoSignOutButton) {
            signout();
            clearView();
            JOptionPane.showMessageDialog(null, "Sign out from this account");
            tabbedPane.setSelectedIndex(0);
        }
        if (e.getSource() == infoSubmitButton) {
            tabbedPane.setSelectedIndex(3);
        }
        if (e.getSource() == claimSignOutButton) {
            signout();
            clearView();
            JOptionPane.showMessageDialog(null, "Sign out from this account");
            tabbedPane.setSelectedIndex(0);
        }
        if (e.getSource() == claimSubmitButton) {
            String title = claimTitleText.getText();
            String content = claimContentText.getText();
            boolean result = mc.getClaimController().addClaim(user.getId(), title, content);
            if (result)
                JOptionPane.showMessageDialog(null, "report success, one of our customer service will contact you soon.");
            else
                JOptionPane.showMessageDialog(null, "report fail");
            tabbedPane.setSelectedIndex(2);
        }

    }

    private void signout() {
        user = null;
        vehicles = null;
        policies = null;
    }

    private void clearView() {
        clearClaimView();
        clearInfoView();
        clearRegisterView();
        clearWelcomeView();
    }

    private void clearWelcomeView() {
        welcomeUserField.setText("");
        welcomePasswordField.setText("");
    }

    private void clearRegisterView() {
        registerEmailText.setText("");
        registerUserText.setText("");
        registerPasswordText.setText("");
        registerFNameText.setText("");
        registerLNameText.setText("");
        registerBirthdayText.setText("");
        registerOccupationText.setText("");
        registerAddressText.setText("");
        registerLicenseDateText.setText("");

        registerBrandText.setText("");
        registerYearText.setText("");
        registerModelText.setText("");
        registerMilesText.setText("");
        registerBasePriceText.setText("");
    }

    private void clearInfoView() {
        infoEmailText.setText("");
        infoFNameText.setText("");
        infoLNameText.setText("");
        infoBirthdayText.setText("");
        infoOccupationText.setText("");
        infoAddressText.setText("");
        infoLicenseDateText.setText("");
        infoBrandText.setText("");
        infoYearText.setText("");
        infoModelText.setText("");
        infoMilesText.setText("");
        infoBasePriceText.setText("");
        infoTypeText.setText("");
        infoDurationText.setText("");
        infoUsageText.setText("");
        infoPriceText.setText("");
    }

    private void clearClaimView() {
        claimContentText.setText("");
        claimTitleText.setText("");
    }

    private void refreshInfo(){
        infoEmailText.setText(user.getEmail());
        infoFNameText.setText(user.getFirstName());
        infoLNameText.setText(user.getLastName());
        infoBirthdayText.setText(user.getBirthday().toString());
        infoOccupationText.setText(user.getOccupation());
        infoAddressText.setText(user.getAddress());
        infoLicenseDateText.setText(user.getLicenseDate().toString());
        infoBrandText.setText(vehicles.get(0).getBrand());
        infoYearText.setText(String.valueOf(vehicles.get(0).getYear()));
        infoModelText.setText(vehicles.get(0).getModel());
        infoMilesText.setText(String.valueOf(vehicles.get(0).getMiles()));
        infoBasePriceText.setText(String.valueOf(vehicles.get(0).getBasePrice()));
        infoTypeText.setText(policies.get(0).getType().toString());
        infoDurationText.setText(policies.get(0).getDuration().toString());
        infoUsageText.setText(policies.get(0).getUsage().toString());
        infoPriceText.setText(String.valueOf(policies.get(0).getPrice()));
    }
}
