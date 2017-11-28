package model;

import org.jgrapht.Graph;

public class Switch extends Fixed {
	
	

	public Switch(int x, int y, Graph<Cell, Edge> graph, Cell[][] cellArray, boolean on, Edge door) {
		super(x, y, graph, cellArray, on);
	}

}
