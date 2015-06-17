import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainController {

	private MainModel model;

	public MainController(MainModel model) {
		this.model = model;
		this.model.action();
	}

	public void quitter(JPanel main) {
		((JFrame) main.getTopLevelAncestor()).dispose();
		System.out.println("Quit !");
	}
}