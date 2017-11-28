package model;

import org.jgrapht.Graph;

public class Monster extends Moving {

	public Monster(int x, int y, Graph<Cell, Edge> graph, Cell[][] cellArray) {
		super(x, y, graph, cellArray);
	}
}
