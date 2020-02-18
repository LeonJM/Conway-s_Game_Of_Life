package Main;
import java.awt.*;

public class Cell {
	private boolean alive;
	private int X, Y, W;
	
	public Cell(int X, int Y, int W) {
		this.X = X;
		this.Y = Y;
		this.W = W;
		
		if (Math.random() < 0.5) {
			alive = true;
		} else { 
			alive = false; 
		}
	}
	
	public Cell(Cell cell, boolean b) {
		this.X = cell.getX();
		this.Y = cell.getY();
		this.W = cell.getW();
		this.setAlive(b);
	}
	
	public void paint(Graphics g) {
		if (alive) {
			g.setColor(Color.BLACK);
		} else {
			g.setColor(Color.WHITE);
		}
		g.fillRect(X*W, Y*W, W, W);
	}
	
	public boolean action(int liveNeighbours) {
		if (this.getAlive()) {
			if (liveNeighbours <= 1 || liveNeighbours > 3) {
				return false;
			} 
			return true;
		} else {
			if (liveNeighbours == 3) {
				return true;
			}
			return false;
		}
	}
	
	public boolean getAlive() {
		return this.alive;
	}
	
	public void setAlive(boolean b) {
		this.alive = b;
	}
	
	public int getX() {
		return this.X;
	}
	
	public int getY() {
		return this.Y;
	}
	
	public int getW() {
		return this.W;
	}
	
}
