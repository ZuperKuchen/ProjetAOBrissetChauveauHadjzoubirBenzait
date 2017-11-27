package model;
import org.jgrapht.*;
import org.jgrapht.graph.*;

public class Labyrinth {

	private Graph<Cell, DefaultEdge> graph;
	
	private int difficulty;
	
	private int nbMonsters;
	private int nbCandies;
	private int nbDoors;
	private Item[] itemArray;
	
	public Labyrinth(int difficulty) {
		this.difficulty = difficulty;

		this.generateGraph();
		this.generateItems();
	}

	private void generateGraph() {
		//Implémenter l'algo donné
		graph = new SimpleGraph<>(DefaultEdge.class);
		Cell[][] cellArray = null;
		for(int x = 0; x < 16; x++) {
			for(int y = 0; y < 16; y++) {
				cellArray[x][y] = new Cell(x, y);
				graph.addVertex(cellArray[x][y]);
			}
		}
		
		
		
	}
	
	private void generateItems() {
		if(this.difficulty < 5) this.nbMonsters = 1;
		else if(this.difficulty > 5) this.nbMonsters = 2;
		nbCandies = 0;
		nbDoors = 0;
		//Item[0] = new
		// A finir
	}

	public Graph getGraph() {
		return graph;
	}


	public Item[] getItemArray() {
		return itemArray;
	}
	
}
