package model;

import org.jgrapht.Graph;

public class Fixed extends Item {
	
	private boolean on;
	
	public Fixed(int x, int y, Graph<Cell, Edge> graph, Cell[][] cellArray, boolean on) {
		super(x, y, graph, cellArray);
		this.on = on;
	}

	public boolean isOn() {
		return on;
	}

	public void setOn(boolean on) {
		this.on = on;
	}
}
