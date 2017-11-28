package model;

import org.jgrapht.Graph;

public class Candy extends Fixed {

	public Candy(int x, int y, Graph<Cell, Edge> graph, Cell[][] cellArray, boolean on) {
		super(x, y, graph, cellArray, on);
	}
}
