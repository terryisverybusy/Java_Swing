import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class selectPlans {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Select Plans");
		frame.setSize(600, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		frame.add(panel);
		placeComponents(panel);

		frame.setVisible(true);
	}

	private static void placeComponents(JPanel panel) {
		
		panel.setLayout(null);
		
		JButton signOutButton = new JButton("Sign Out");
		signOutButton.setBounds(520, 10, 80, 25);
		panel.add(signOutButton);
		

	}

}
