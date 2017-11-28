package model;
import org.jgrapht.*;

public abstract class Item {
	
	private int x;
	private int y;
	protected Graph<Cell,Edge> graph;
	protected Cell[][] cellArray;
	
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
	
	public int getLabSizeX() {
		return cellArray.length;
	}
	
	public int getLabSizeY() {
		if(cellArray.length==0) return 0;
		else return cellArray[0].length;
	}

}
