package model;
import org.jgrapht.*;
import org.jgrapht.graph.*;
/*
 * La classe Labyrinth génère automatiquement un labyrinth quand elle est instanciée. 
 * Un objet Labyrinth contient le graph, le tableau des cellules.
 */
public class Labyrinth {

	private Graph<Cell,Edge> graph;
	private Cell[][] cellArray;				//Nous utilisons un tableau de cellules pour
											//y avoir accés plus rapidement, sans devoir
											//chercher dans le graph.
	private int sizeX;
	private int sizeY;
	
	public Labyrinth(int sizeX, int sizeY) {
		this.sizeX = sizeX;
		this.sizeY = sizeY;
		
		this.generateGraph();
	}

	private void generateGraph() {
		graph = new SimpleGraph<>(Edge.class);
		cellArray = new Cell[sizeX][sizeY];				//generateGraph() se contente d'initialiser le graph
		for(int x = 0; x < sizeX; x++) {				//et le tableau de cellules, puis passe la main
			for(int y = 0; y < sizeY; y++) {			//à buildLabyrinth() qui implémente l'algo pour créer
				cellArray[x][y] = new Cell(x, y);		//un graph correspondant à un labyrinth parfait.
				
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
		System.out.print(c);
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


	public Graph<Cell,Edge> getGraph() {
		return graph;
	}

	public Cell[][] getCellArray() {
		return cellArray;
	}

	public int getSizeX() {
		return sizeX;
	}

	public int getSizeY() {
		return sizeY;
	}
}
