package model;
import org.jgrapht.*;

public abstract class Item {
	
	private int x;
	private int y;
	private Graph<Cell,Edge> graph;
	private Cell[][] cellArray;
	
	public Item(int x, int y, Graph<Cell,Edge> graph, Cell[][] cellArray) {
		super();
		this.x = x;
		this.y = y;
		this.graph = graph;
		this.cellArray = cellArray;
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

	public Graph<Cell,Edge> getGraph() {
		return graph;
	}
	
	public Cell[][] getCellArray(){
		return cellArray;
	}
	
	public int getLabSize() {
		return cellArray.length;
	}

}
