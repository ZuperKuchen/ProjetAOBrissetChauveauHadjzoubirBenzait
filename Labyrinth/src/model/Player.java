package model;

import org.jgrapht.Graph;


public class Player extends Moving {
	
	private Player(int x, int y, Graph<Cell, Edge> graph, Cell[][] cellArray) {
		super(x, y, graph, cellArray);
	}
	
	private static Player INSTANCE = null;
	
	public static Player getInstance(int x, int y, Graph<Cell, Edge> graph, Cell[][] cellArray) {
		if(INSTANCE == null) {
			INSTANCE = new Player(x, x, graph, cellArray);
		}
		return INSTANCE;
	}
}
