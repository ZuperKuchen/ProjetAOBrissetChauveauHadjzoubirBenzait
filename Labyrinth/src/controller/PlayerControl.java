package controller;

import org.jgrapht.Graph;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import model.Player;
import view.ViewPlayer;
import model.*;

/**
 * This class handle the keyEvent
 * 
 *
 */
public class PlayerControl implements EventHandler<KeyEvent>{

	enum DIR{SOUTH,NORTH,EAST,WEST};


	private Player player;
	private Labyrinth lab;
	private Graph<Cell,Edge> lab_graph;
	ViewPlayer viewP;
	DIR actualDir;



	public PlayerControl(Level currentLevel) {
		super();
		this.player = currentLevel.getPlayer();
		this.lab = currentLevel.getLab();
		this.lab_graph = currentLevel.getLab().getGraph();
		this.viewP = ViewPlayer.getInstance();
		this.actualDir = DIR.NORTH;
	}

	/**
	 * 
	 * @param x current x position of the player
	 * @param y current y position of the player
	 * @param dir the direction the player wants to go to
	 * @return true is the player can move from the position (x,y) to the adjacent tiles according to dir, false otherwise.
	 */
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
					//System.out.println("(x,y): " + x+" "+y +"(nx,ny):" + next_x +" "+ next_y);
					return true;
				}
			}
		}
		return false;
	}
	
	public void movePlayer() {
		if(can_move(this.player.getX(),this.player.getY(),this.actualDir)) {
			switch(this.actualDir) {
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
			default:
				break;
			}
			
		}
		viewP.update();
	}

	/**
	 * 
	 */
	public void handle(KeyEvent event) {
		DIR tmpDir = this.actualDir;
		switch(event.getCode()) {
		case D:
		case RIGHT:
			tmpDir = DIR.EAST;
			break;
		case Q:
		case LEFT:
			tmpDir = DIR.WEST;
			break;
		case Z:
		case UP:
			tmpDir = DIR.NORTH;
			break;
		case S:
		case DOWN:
			tmpDir = DIR.SOUTH;
			break;
		case ESCAPE:
			System.out.println("Wanna escape? \n");
			viewP.getView().close();
		default:
			break;
		}
		if(can_move(this.player.getX(),this.player.getY(),tmpDir)) {
			this.actualDir = tmpDir;
		}
	}

	


}
