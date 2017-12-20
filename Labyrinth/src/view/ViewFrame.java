package view;

import javafx.stage.*;
import model.Cell;
import model.Edge;
import model.Edge.Type;
import model.Fixed;
import model.Level;

import java.util.ArrayList;
import java.util.List;

import org.jgrapht.Graph;


import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.*;
import javafx.scene.shape.Rectangle;

public class ViewFrame extends Stage{
	
	static final int SPAN = 4;
	static final int WALL = 2;
	static final int CELL = 9;
	public static final Paint WALL_COLOR = Color.BURLYWOOD;
	public static final Paint SCENE_COLOR = Color.CORNSILK;
	public static final Paint CLOSED_DOOR_COLOR = Color.BLACK;
	public static final Paint OPENED_DOOR_COLOR = Color.BROWN;
	
	private Level lvl;
	private Pane pane;
	
	private ViewPlayer player;
	private MovingSprite exit;  //View
	
	private List<FixedSprite> items;
	private List<MovingSprite> monsters;
	//TO ADD OTHER VIEW
	
	/*private static ViewFrame INSTANCE = new ViewFrame();
	
	private ViewFrame() {
		super();
		this.pane = new Pane();
	}
	
	public static ViewFrame getInstance() {
		return INSTANCE;
	}
*/
	public ViewFrame(Level lvl) {
		super();
		this.lvl = lvl;
		this.pane = new Pane();
		this.player = ViewPlayer.getInstance(this);
		this.exit = new MovingSprite(this,lvl.getExit(),Sprite.DOOR_SPRITE); // TO MODIFY
		this.items = new ArrayList<>();
		this.monsters = new ArrayList<>();
		
		//Les monstres
		for (int i=0 ; i < lvl.getMonsters().size() ; i++) {
			this.monsters.add(i, new MovingSprite(this, lvl.getMonsters().get(i),Sprite.BAD_SPRITE)); 
		}
		//Les Items
		int nbCandy = 0;
		for (int i=0 ; i < lvl.getFixedItems().size() ; i++) {
			Fixed item = lvl.getFixedItems().get(i);
			String imgpath = null;
			switch (item.getName()) {
			case CANDY:
				nbCandy++;
				switch (nbCandy%4) {
				case 0:
					imgpath = Sprite.CANDY1_SPRITE;
					break;
				case 1:
					imgpath = Sprite.CANDY2_SPRITE;
					break;
				case 2:
					imgpath = Sprite.CANDY3_SPRITE;
					break;
				case 3:
					imgpath = Sprite.CANDY4_SPRITE;
					break;
				}
				break;
			case SWITCH:
				imgpath = Sprite.BUTT_CLOSE_SPRITE;
				break;
			default:
				System.out.println(" PAS POSSIBLE VIEWFRAME CONSTRUCTOR");
				return;
			}
			this.items.add(i, new FixedSprite(this, lvl.getFixedItems().get(i), imgpath));
		}
		
	}
	
	public Level getLvl() {
		return lvl;
	}

	public Pane getPane() {
		return pane;
	}
	
	public void initFrame() {
		int nbX = this.lvl.getLab().getSizeX();
		int nbY = this.lvl.getLab().getSizeY();
		Scene tmp = new Scene(pane, ((WALL + CELL) * nbX + WALL) * SPAN,((WALL + CELL) * nbY + WALL) * SPAN);
		tmp.setFill(SCENE_COLOR);
		this.setScene(tmp);
		Rectangle square;
		
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
	
	
	public void drawWall(int xs, int ys, int xt, int yt, Paint color) {
		int x = 0, y = 0, xspan = 0, yspan = 0;
		if(ys == yt) {
			x = ((WALL + CELL) + (WALL + CELL) * ((int)(xs + xt) / 2)) * SPAN;
			y = (WALL + ys * (WALL + CELL)) * SPAN;
			xspan = WALL * SPAN;
			yspan = CELL * SPAN;
			Rectangle square = new Rectangle(x, y, xspan, yspan);
			square.setFill(color);
			this.pane.getChildren().add(square);
		}
		else if (xs == xt) {
			x = (WALL + xs * (WALL + CELL)) * SPAN;
			y = ((WALL + CELL) + (WALL + CELL) * ((int)(ys + yt) / 2)) * SPAN;
			xspan = CELL * SPAN;
			yspan = WALL * SPAN;
			Rectangle square = new Rectangle(x, y, xspan, yspan);
			square.setFill(color);
			this.pane.getChildren().add(square);
		}
	}
	
	public void drawLabyrinth() {
		//On parcourt la grille de jeu ligne par ligne depuis le coin supérieur gauche
		//Pour chaque cell, on vérifie  si il existe un chemin vers l'est et vers le sud auquel cas on ne dessine pas
		Graph<Cell,Edge> graph = this.lvl.getLab().getGraph();
		Cell[][] Cell = this.lvl.getLab().getCellArray();
		int nbX = this.lvl.getLab().getSizeX();
		int nbY = this.lvl.getLab().getSizeY();
		for (int j=0; j<nbY; j++){
			for (int i=0; i<nbX; i++) {
				//vers l'est : si pas au bord et pas d'arrete on dessine
				if(i != nbX-1 && !graph.containsEdge(Cell[i][j], Cell[i+1][j])){
					drawWall(i, j, i+1, j, WALL_COLOR);
				}
				//Si une arête de type DOOR on dessine
				else if (i != nbX-1 && graph.containsEdge(Cell[i][j], Cell[i+1][j])) {
					Edge edge = graph.getEdge(Cell[i][j], Cell[i+1][j]);
					if(edge.getType() == Type.CLOSED_DOOR) {
						drawWall(i, j, i+1, j, CLOSED_DOOR_COLOR);

					}
					else if(edge.getType() == Type.OPENED_DOOR) {
						drawWall(i, j, i+1, j, OPENED_DOOR_COLOR);

					}
				}
				//vers le sud: si pas en bas & pas d'arrete on dessine
				if(j != nbY-1 && !graph.containsEdge(Cell[i][j], Cell[i][j+1])) {
					drawWall(i,j,i,j+1,WALL_COLOR);
				}
				//Si une arête de type DOOR on dessine
				else if (j != nbY-1 && graph.containsEdge(Cell[i][j], Cell[i][j+1])) {
					Edge edge = graph.getEdge(Cell[i][j], Cell[i][j+1]);
					if(edge.getType() == Type.CLOSED_DOOR) {
						drawWall(i,j,i,j+1,CLOSED_DOOR_COLOR);
					}
					else if(edge.getType() == Type.OPENED_DOOR) {
						drawWall(i,j,i,j+1,OPENED_DOOR_COLOR);
					}
				}
			}
		}
		this.player.initView();
		this.exit.initView();
		this.items.forEach(FixedSprite-> FixedSprite.initView());
		this.monsters.forEach(MovingSprite -> MovingSprite.initView());
		//TO ADD other initView 
	}


	
	
	
	
}
