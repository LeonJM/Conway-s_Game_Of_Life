package Main;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Grid extends JPanel{
	private Cell[][] cells;
	private int N;
	private int length = 800;
	
	public Grid(int N) {
		this.N = N;
		cells = new Cell[N][N];
		setPreferredSize(new Dimension(length, length));
		
		for (int i = 0; i < N; i ++) {
			for (int j = 0; j < N; j ++) {
				cells[i][j] = new Cell(i, j, this.length/this.N);
			}
		}
	}

	@Override 
	public void paint(Graphics g) {
		for (int i = 0; i < N; i ++) {
			for (int j = 0; j < N; j ++) {
				cells[i][j].paint(g);
			}
		}
	}
	
	public int getLiveNeighbours(Cell cell) {
		int result = 0;
		int X = cell.getX();
		int Y = cell.getY();
		
		for (int i = -1; i <= 1; i ++) {
			for (int j = -1; j <= 1 ; j ++) {
				if (i == 0 && j == 0) { continue;}
				if (X + i < 0 || X + i >= this.N) { continue;}
				if (Y + j < 0 || Y + j >= this.N) { continue;}
				
				if (this.cells[X+i][Y+j].getAlive()) {
					result ++;
				}
			}
		}
		return result;
	}
	
	public void update() {
		Cell[][] nextGen = new Cell[N][N];
		
		for (int i = 0; i < N; i ++) {
			for (int j = 0; j < N; j ++) {
				int liveNeighbours = this.getLiveNeighbours(cells[i][j]);
				nextGen[i][j] = new Cell(cells[i][j], cells[i][j].action(liveNeighbours));
			}
		}
		
		cells = nextGen;
	}
}
