package controller;

import org.jgrapht.Graph;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import model.Player;
import view.ViewFrame;
import view.ViewPlayer;
import model.*;
public class Controller implements EventHandler<KeyEvent>{

	enum DIR{SOUTH,NORTH,EAST,WEST};


	private Player player;
	//private ImageView sprite;
	private Labyrinth lab;
	private Graph<Cell,Edge> lab_graph;
	ViewPlayer viewP;



	public Controller(Player player, Labyrinth labyrinth) {
		super();
		this.player = player;
		this.lab = labyrinth;
		this.lab_graph = this.lab.getGraph();
		this.viewP = ViewPlayer.getInstance();
	}

	private boolean can_move(int x,int y,DIR dir) {
		int next_x = x, next_y = y;
		int X = this.lab.getSizeX(); //Max 
		int Y = this.lab.getSizeY();
		switch (dir){
		case NORTH:				
				next_y--;
			break;
		case SOUTH:
				next_y++;
			break;
		case EAST:
				next_x++;
			break;
		case WEST:
				next_x--;				
			break;
		default:
			return false;
		}
		if ( /*x >= 0 && x < X - 1 && y >= 0 && y < Y && */ 
				next_x >= 0 && next_x < X  && next_y >= 0 && next_y < Y) {
			if(this.lab_graph.containsEdge(this.lab.getCellArray()[x][y], this.lab.getCellArray()[next_x][next_y])){
				if(this.lab_graph.getEdge(this.lab.getCellArray()[x][y], this.lab.getCellArray()[next_x][next_y]).getType() != Edge.Type.CLOSED_DOOR) {
					System.out.println("(x,y): " + x+" "+y +"(nx,ny):" + next_x +" "+ next_y);
					return true;
				}
			}
		}
		return false;
	}
	
	public void movePlayer(DIR dir) {
		if(can_move(this.player.getX(),this.player.getY(),dir)) {
			System.out.println(" OUI");
			switch(dir) {
			case SOUTH:
				this.player.setY(this.player.getY() + 1);
				break;
			case NORTH:
				this.player.setY(this.player.getY() - 1);
				break;
			case EAST:
				this.player.setX(this.player.getX() + 1);
				break;
			case WEST:
				this.player.setX(this.player.getX() - 1);
				break;
			}
			viewP.update();
		}
		else System.out.println(" NON");
	}

	public void handle(KeyEvent event) {
		switch(event.getCode()) {
		case B:
			System.out.println("SERIEUX?!");
		case D:
		case RIGHT:
			System.out.println("EAST");	
			movePlayer(DIR.EAST);
			break;
		case Q:
		case LEFT:
			System.out.println("WEST");	
			movePlayer(DIR.WEST);
			break;
		case Z:
		case UP:
			System.out.println("NORTH");	
			movePlayer(DIR.NORTH);
			break;
		case S:
		case DOWN:
			System.out.println("SOUTH");
			movePlayer(DIR.SOUTH);
			break;
		case ESCAPE:
			//this.viewP.deleteView();
			//ViewFrame.getInstance().getScene().setFill(ViewFrame.WALL_COLOR);
			System.out.println("Wanna escape? \n");
		default:
			break;
		}

	}

	


}
