import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.border.MatteBorder;

@SuppressWarnings("serial")
public class MainView extends JFrame implements Observer {

	private JPanel main = new JPanel();
	private MainController ctrlr = null;
	// login page
	private JLabel userLabel;
	private JTextField userText;
	private JLabel passwordLabel;
	private JPasswordField passwordText;
	private JButton loginButton;
	private JButton registerButton;

	public MainView(final MainController ctrlr) {
		super();
		this.ctrlr = ctrlr;
		initialize();
		this.addWindowListener(new WindowListener() {
			public void windowActivated(WindowEvent e) {
			}

			public void windowClosed(WindowEvent e) {
			}

			public void windowClosing(WindowEvent e) {
				quit();
			}

			public void windowDeactivated(WindowEvent e) {
			}

			public void windowDeiconified(WindowEvent e) {
			}

			public void windowIconified(WindowEvent e) {
			}

			public void windowOpened(WindowEvent e) {
			}
		});
	}

	private void initialize() {
		this.setSize(800, 600);
		this.setResizable(true);
		this.setContentPane(getPane());
		// this.getContentPane().setLayout(new BoxLayout(main,
		// BoxLayout.Y_AXIS));
		this.setJMenuBar(getMenu());
		this.bindAction();

	}

	private void bindAction() {
		final JMenuBar menu = this.getJMenuBar();

		menu.getMenu(0).getItem(1).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (quit())
					ctrlr.quitter(main);
			}
		});

		
		
		
		/*
		menu.getMenu(1).getItem(0).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showHelp();
			}
		});*/

	}

	protected boolean quit() {
		int clicked = JOptionPane.showConfirmDialog(this,
				"Do you really want to quit ?");
		return (clicked == JOptionPane.YES_OPTION) ? true : false;
	}

	/*
	private void showHelp() {
		final Help help = new Help();
		((JDesktopPane) main.getComponent(0)).add(help);
		((JButton) ((JPanel) help.getContentPane()).getComponent(((int) help
				.getContentPane().getComponentCount()) - 1))
				.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						help.setVisible(false);
					}
				});
	}
	*/

	private JPanel getPane() {
		/*
		 * main.add(new JDesktopPane()); ((JComponent)
		 * main.getComponent(0)).setBorder(new MatteBorder(0, 0, 1, 0,
		 * Color.GRAY)); main.getComponent(0).setSize(new Dimension(
		 * this.getSize().width, this.getSize().height ));
		 * 
		 * main.add(new JPanel()); ((JPanel) main.getComponent(1)).setLayout(new
		 * FlowLayout()); ((FlowLayout) ((JPanel)
		 * main.getComponent(1)).getLayout()).setAlignment(FlowLayout.RIGHT);
		 * ((JPanel) main.getComponent(1)).add(new JLabel("Status"));
		 */

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

		main.add(userLabel);
		main.add(userText);
		main.add(passwordLabel);
		main.add(passwordText);
		main.add(loginButton);
		main.add(registerButton);

		// login view add listener
		// loginButton.addActionListener(this);
		// registerButton.addActionListener(this);

		
		
		
		
		return main;
	}

	
	private JMenuBar getMenu() {
		JMenuBar menu = new JMenuBar();

		menu.add(new JMenu("File")); // Menu 0
		menu.getMenu(0).addSeparator(); // item 0
		menu.getMenu(0).add(new JMenuItem("Quit")); // item 1
		menu.getMenu(0)
				.getItem(1)
				.setAccelerator(
						KeyStroke.getKeyStroke(KeyEvent.VK_Q, KeyEvent.VK_ALT));

		menu.add(new JMenu("Help")); // Menu 1
		menu.getMenu(1).add(new JMenuItem("Shortcuts")); // item 0
		menu.getMenu(1)
				.getItem(0)
				.setAccelerator(
						KeyStroke.getKeyStroke(KeyEvent.VK_H, KeyEvent.VK_ALT));

		return menu;
	}

	
	protected void alert(String message) {
		JOptionPane.showMessageDialog(this, message);
	}

	

	
	public void update(Observable o, Object arg) {
		if (arg.equals("action"))
			alert("One Action !");

		repaint();
	}
	
}