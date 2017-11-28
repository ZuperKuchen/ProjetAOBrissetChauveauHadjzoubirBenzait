package model;
import org.jgrapht.*;

public abstract class Item {
	
	private int x;
	private int y;
	private Graph<Cell,Edge> lab;
	
	public Item(int x, int y, Graph<Cell,Edge> lab) {
		super();
		this.x = x;
		this.y = y;
		this.lab = lab;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Graph<Cell,Edge> getLab() {
		return lab;
	}

	public void setLab(Graph<Cell,Edge> lab) {
		this.lab = lab;
	}

}
