package model;
import java.util.ArrayDeque;
import java.util.Queue;

import org.jgrapht.*;
import org.jgrapht.graph.*;

import model.Edge.Type;
/**
 * La classe Labyrinth génère automatiquement un labyrinth quand elle est instanciée. 
 * Un objet Labyrinth contient le graph, le tableau des cellules.
 * 
 * @param cellArray
 * 			Nous utilisons un tableau de cellules pour
 *			y avoir accés plus rapidement, sans devoir
 *			chercher dans le graph.
 */
public class Labyrinth {

	private Graph<Cell,Edge> graph;
	private Cell[][] cellArray;		
	private int sizeX;
	private int sizeY;
	
	public Labyrinth(int sizeX, int sizeY) {
		this.sizeX = sizeX;
		this.sizeY = sizeY;
		this.generateGraph();
	}
	
	/**
	 * Se contente d'initialiser le graph
	 * et le tableau de cellules, puis passe la main
	 * à buildLabyrinth() qui implémente l'algo pour créer
	 * un graph correspondant à un labyrinth parfait.
	 */
	private void generateGraph() {
		graph = new SimpleGraph<>(Edge.class);
		cellArray = new Cell[sizeX][sizeY];	
		for(int x = 0; x < sizeX; x++) {	
			for(int y = 0; y < sizeY; y++) {
				cellArray[x][y] = new Cell(x, y);
				
			}
		}
		graph.addVertex(cellArray[0][0]);
		buildLabyrinth(cellArray[0][0]);
		multipleWays();
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
		/*
		 * Pour être sûr qu'on ne laisse aucune cellule non créée ou
		 * non reliée au reste du graph, on vérifie pour toutes les
		 * directions.
		 */
		if(currentY-1 >= 0 && !graph.containsVertex(cellArray[currentX][currentY-1])) {
			graph.addVertex(cellArray[currentX][currentY-1]);
			graph.addEdge(currentCell, cellArray[currentX][currentY-1]);
			buildLabyrinth(cellArray[currentX][currentY-1]);
		}
		if(currentX+1 < sizeX && !graph.containsVertex(cellArray[currentX+1][currentY])) {
			graph.addVertex(cellArray[currentX+1][currentY]);
			graph.addEdge(currentCell, cellArray[currentX+1][currentY]);
			buildLabyrinth(cellArray[currentX+1][currentY]);
		}
		if(currentY+1 < sizeY && !graph.containsVertex(cellArray[currentX][currentY+1])){
			graph.addVertex(cellArray[currentX][currentY+1]);
			graph.addEdge(currentCell, cellArray[currentX][currentY+1]);
			buildLabyrinth(cellArray[currentX][currentY+1]);
		}
		if(currentX-1 >= 0 && !graph.containsVertex(cellArray[currentX-1][currentY])) {
			graph.addVertex(cellArray[currentX-1][currentY]);
			graph.addEdge(currentCell, cellArray[currentX-1][currentY]);
			buildLabyrinth(cellArray[currentX-1][currentY]);
		}
	}
	/**
	 * Permet de rajouter plusieurs chemins au labyrinthe,
	 * boucle simplement sur des cellules aléatoires en essayant
	 * de créer des chemins supplémentaires.
	 */
	public void multipleWays() {
		int x;
		int y;
		int x2;
		int y2;
		int dir;
		for(int i=0; i<100; i++) {
			x = (int) (Math.random()*sizeX);
			y = (int) (Math.random()*sizeY);
			dir = (int) (Math.random()*4);
			if(dir == 0) {
				x2 = x + 1;
				y2 = y;
			}else if(dir == 1) {
				x2 = x - 1;
				y2 = y;
			}else if(dir == 2) {
				x2 = x;
				y2 = y + 1;
			}else { 
				x2 = x;
				y2 = y - 1;
			}
			if(x2 < sizeX && x2 >= 0 && y2 < sizeY && y2 >= 0) {
				if (!graph.containsEdge(cellArray[x][y], cellArray[x2][y2])) {
					graph.addEdge(cellArray[x][y], cellArray[x2][y2]);
				}
			}
		}
	}
	public enum Direction{
		NORTH,
		SOUTH,
		EAST,
		WEST;
	};
	
	public Cell mayGo(Direction dir, Cell cell) {
		int wantedX = cell.getX();
		int wantedY = cell.getY();
		if(dir == Direction.NORTH) {
			wantedY = cell.getY() - 1;
		}else if(dir == Direction.SOUTH) {
			wantedY = cell.getY() + 1;
		}else if(dir == Direction.EAST) {
			wantedX = cell.getX() + 1;
		}else{
			wantedX = cell.getX() - 1;
		}if(wantedX < 0 || wantedX >= sizeX || wantedY < 0 || wantedY >= sizeY) {
			return null;
		}else {
			if(graph.containsEdge(cell, cellArray[wantedX][wantedY])) {
				if(graph.getEdge(cell, cellArray[wantedX][wantedY]).getType() != Type.CLOSED_DOOR) {
					return cellArray[wantedX][wantedY];
				}
			}
		}
		return null;
	}
	
	/**
	 * On implémente ici l'algorithme de Manhattan car il
	 * a directement accès au graph concerné.
	 * @param La cell source, et la cell target 
	 */
	public void manhattan(Cell source, Cell target) {
		Queue<Cell> fifo = new ArrayDeque<Cell>();
		target.setMark(1);
		fifo.add(target);
		while(!fifo.isEmpty()) {
			Cell actual = fifo.remove();
			for(Direction dir : Direction.values()) {
				Cell next = this.mayGo(dir, actual);
				if(next != null) {
					if(next.getMark() == 0) {
						next.setMark(actual.getMark() +1);;
						if(next != source) {
							fifo.add(next);
						}
					}
				}
			}
		}
	}
	public void launchManhattan(Cell source, Cell target) {
		for(Cell cell : graph.vertexSet())
			cell.setMark(0);;
		manhattan(source, target);
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
