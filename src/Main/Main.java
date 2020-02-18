package Main;
import javax.swing.JFrame;

public class Main extends JFrame {

	public static int N = 400;
	Grid grid = new Grid(N);
	
	public static void main(String[] args) {
		Main window = new Main();
		window.run();
	}
	
	private Main() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(grid);
        this.pack();
        this.setVisible(true);
	}
	
	public void run() {
		while(true) {
			grid.update();
			this.repaint();
		}
	}

}
