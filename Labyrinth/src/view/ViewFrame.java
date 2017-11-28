package view;

import javafx.stage.*;
import model.Cell;
import model.Edge;

import org.jgrapht.Graph;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.*;
import javafx.scene.shape.Rectangle;

public class ViewFrame {
	
	static final int SPAN = 4;
	static final int WALL = 2;
	static final int CELL = 9;
	public static final Paint WALL_COLOR = Color.BURLYWOOD;
	public static final Paint SCENE_COLOR = Color.CORNSILK;
	
	private static Scene scene;
	private static Group pane;
	

	
	public static void drawFrame(Stage stage, int nbX, int nbY) {
		pane = new Group();
		scene = new Scene(pane, ((WALL + CELL) * nbX + WALL) * SPAN,((WALL + CELL) * nbY + WALL) * SPAN);
		scene.setFill(SCENE_COLOR);
		Rectangle square;
		stage.setScene(scene);
		
		square = new Rectangle(0,0, SPAN * (nbX * (CELL + WALL) + WALL), WALL * SPAN);
		square.setFill(WALL_COLOR);
		pane.getChildren().add(square);
		
		square = new Rectangle(0, SPAN *(nbY * (CELL + WALL)), SPAN * (nbX * (CELL + WALL) + WALL), WALL * SPAN);
		square.setFill(WALL_COLOR);
		pane.getChildren().add(square);
		
		square = new Rectangle(0, 0, WALL * SPAN, SPAN * (nbY * (CELL + WALL) + WALL));
		square.setFill(WALL_COLOR);
		pane.getChildren().add(square);
		
		square = new Rectangle(SPAN * (nbX * (CELL + WALL)), 0, WALL * SPAN, SPAN * (nbY * (CELL + WALL) + WALL));
		square.setFill(WALL_COLOR);
		pane.getChildren().add(square);
		
		for (int x = 0; x < nbX-1 ; ++x) {
			int offsetX = ((WALL + CELL) + (WALL + CELL) * x) * SPAN;
			for (int y = 0; y < nbY-1; ++y) {
				int offsetY = ((WALL + CELL) + (WALL + CELL) * y) * SPAN;
				square = new Rectangle(offsetX, offsetY, WALL * SPAN, WALL * SPAN);
				square.setFill(WALL_COLOR);
				pane.getChildren().add(square);
			}
		}
	}
	
	
	public static void drawWall(int xs, int ys, int xt, int yt, Paint color) {
		int x = 0, y = 0, xspan = 0, yspan = 0;
		if(ys == yt) {
			x = ((WALL + CELL) + (WALL + CELL) * ((int)(xs + xt) / 2)) * SPAN;
			y = (WALL + ys * (WALL + CELL)) * SPAN;
			xspan = WALL * SPAN;
			yspan = CELL * SPAN;
			Rectangle square = new Rectangle(x, y, xspan, yspan);
			square.setFill(color);
			pane.getChildren().add(square);
		}
		else if (xs == xt) {
			x = (WALL + xs * (WALL + CELL)) * SPAN;
			y = ((WALL + CELL) + (WALL + CELL) * ((int)(ys + yt) / 2)) * SPAN;
			xspan = CELL * SPAN;
			yspan = WALL * SPAN;
			Rectangle square = new Rectangle(x, y, xspan, yspan);
			square.setFill(color);
			pane.getChildren().add(square);
		}
	}
	
	public static void drawLabyrinth(Stage stage, Graph<Cell,Edge> graph, Cell[][] Cell, int nbX, int nbY) {
		stage.setScene(scene);
		//On parcourt la grille de jeu ligne par ligne depuis le coin supérieur gauche
		//Pour chaque cell, on verifie  si il existe un chemin vers l'est et vers le sud auquel cas on ne dessine pas
		
		for (int j=0; j<nbY; j++){
			for (int i=0; i<nbX; i++) {
				//vers l'est : si pas au bord et pas d'arrete on dessine
				if(i != nbX-1 && !graph.containsEdge(Cell[i][j], Cell[i+1][j])){
					//dessin
					drawWall(i, j, i+1, j, WALL_COLOR);
				}
				//vers le sud: si pas en bas & pas d'arrete on dessine
				if(j != nbY-1 && !graph.containsEdge(Cell[i][j], Cell[i][j+1])) {
					//dessin
					drawWall(i,j,i,j+1,WALL_COLOR);
				}
			}
		}
	}
	
	
	
}
