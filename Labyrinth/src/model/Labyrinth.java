package model;
import org.jgrapht.*;
import org.jgrapht.graph.*;

public class Labyrinth {

	private Graph<Cell, DefaultEdge> graph;
	public Cell[][] cellArray;
	
	private int difficulty;
	private int sizeX;
	private int sizeY;
	
	private int nbMonsters;
	private int nbCandies;
	private int nbDoors;
	private Item[] itemArray;
	
	public Labyrinth(int difficulty, int sizeX, int sizeY) {
		this.difficulty = difficulty;
		this.sizeX = sizeX;
		this.sizeY = sizeY;
		
		this.generateGraph();
		this.generateItems();
	}

	private void generateGraph() {
		//Implémenter l'algo donné
		graph = new SimpleGraph<>(DefaultEdge.class);
		cellArray = new Cell[sizeX][sizeY];
		for(int x = 0; x < sizeX; x++) {
			for(int y = 0; y < sizeY; y++) {
				cellArray[x][y] = new Cell(x, y);
				
			}
		}
		graph.addVertex(cellArray[0][0]);
		buildLabyrinth(cellArray[0][0]);
		
	}
	
	private void buildLabyrinth(Cell currentCell) {
		int c[] = {0,0,0,0};
		c[0] = (int) (Math.random()*4);
		c[1] = (int) (Math.random()*4);
		c[2] = (int) (Math.random()*4);
		c[3] = (int) (Math.random()*4);
		int currentX = currentCell.getX();
		int currentY = currentCell.getY();
		
		for(int i = 0; i < 4; i++) {
			if(c[i] == 0) {
				if(currentY-1 >= 0 && !graph.containsVertex(cellArray[currentX][currentY-1])) {
					graph.addVertex(cellArray[currentX][currentY-1]);
					graph.addEdge(currentCell, cellArray[currentX][currentY-1]);
					buildLabyrinth(cellArray[currentX][currentY-1]);
				}
			}
			else if(c[i] == 1) {
				if(currentX+1 < sizeX && !graph.containsVertex(cellArray[currentX+1][currentY])) {
					graph.addVertex(cellArray[currentX+1][currentY]);
					graph.addEdge(currentCell, cellArray[currentX+1][currentY]);
					buildLabyrinth(cellArray[currentX+1][currentY]);
				}
			}
			else if(c[i] == 2) {
				if(currentY+1 < sizeY && !graph.containsVertex(cellArray[currentX][currentY+1])){
					graph.addVertex(cellArray[currentX][currentY+1]);
					graph.addEdge(currentCell, cellArray[currentX][currentY+1]);
					buildLabyrinth(cellArray[currentX][currentY+1]);
				}
			}
			else if(c[i] == 3) {
				if(currentX-1 >= 0 && !graph.containsVertex(cellArray[currentX-1][currentY])) {
					graph.addVertex(cellArray[currentX-1][currentY]);
					graph.addEdge(currentCell, cellArray[currentX-1][currentY]);
					buildLabyrinth(cellArray[currentX-1][currentY]);
				}
			}
		}
	}
	
	private void generateItems() {
		if(this.difficulty < 1) this.nbMonsters = 1;
		else if(this.difficulty >= 1) this.nbMonsters = 2;
		nbCandies = 0;
		nbDoors = 0;
		itemArray = new Item[2+nbCandies+nbDoors+nbMonsters];
		// A finir
	}

	public Graph<Cell,DefaultEdge> getGraph() {
		return graph;
	}


	public Item[] getItemArray() {
		return itemArray;
	}
	
}
