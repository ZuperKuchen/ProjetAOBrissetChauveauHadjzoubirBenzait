package model;

import org.jgrapht.Graph;

public class Exit extends Item {

	private Exit(int x, int y, Graph<Cell, Edge> graph, Cell[][] cellArray) {
		super(x, y);
	}
	
	private static Exit INSTANCE = null;
	
	public static Exit getInstance(int x, int y, Graph<Cell, Edge> graph, Cell[][] cellArray) {
		if(INSTANCE == null) {
			INSTANCE = new Exit(x, x, graph, cellArray);
		}
		return INSTANCE;
	}

}
