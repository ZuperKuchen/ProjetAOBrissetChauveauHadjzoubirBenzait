/*package controller;

import org.jgrapht.Graph;

import model.Cell;
import model.Edge;
import model.Edge.Type;
import model.Item;
/*TODO 
 * La classe MoveItem doit gérer le déplacement d'une case pour le player
 * et les monsters. Elle doit vérifier que l'item donné n'est pas fixed, et déplacer
 * l'item dans la direction donnée seulement s'il le peut.
 */

/*
public class MoveItem {
	
	public static boolean CanMoveNorth(Item item, Graph<Cell,Edge> graph, Cell[][] cellArray) {
		if(item.getY() > 0){
			Edge tmp = graph.getEdge(cellArray[item.getX()][item.getY()], cellArray[item.getX()][item.getY()-1]);
			if(tmp.getType() == Type.OPENED_DOOR || tmp.getType() == Type.CORRIDOR) {
				return true;
			}
		}
		return false;
	}
	/*
	public boolean CanMoveSouth() {
		if(super.getY() < super.getLabSizeY()-1){
			Edge tmp = graph.getEdge(cellArray[super.getX()][super.getY()], cellArray[super.getX()][super.getY()+1]);
			if(tmp.getType() == Type.OPENED_DOOR || tmp.getType() == Type.CORRIDOR) {
				return true;
			}
		}
		return false;
	}
	
	public boolean CanMoveEast() {
		if(super.getX() < super.getLabSizeX()-1){
			Edge tmp = graph.getEdge(cellArray[super.getX()][super.getY()], cellArray[super.getX()+1][super.getY()]);
			if(tmp.getType() == Type.OPENED_DOOR || tmp.getType() == Type.CORRIDOR) {
				return true;
			}
		}
		return false;
	}
	
	public boolean CanMoveWest() {
		if(super.getX() > 0){
			Edge tmp = graph.getEdge(cellArray[super.getX()][super.getY()], cellArray[super.getX()-1][super.getY()]);
			if(tmp.getType() == Type.OPENED_DOOR || tmp.getType() == Type.CORRIDOR) {
				return true;
			}
		}
		return false;
	}
	
	
	/*
	 * Les méthodes pour déplacer l'item font appel
	 * à celles pour vérifier qu'il peut bien se déplacer
	 * dans la direction donnée, et le déplace dans ce cas.
	 * 
	 */
/*
	public void MoveNorth() {
		if (this.CanMoveNorth()) super.setY(super.getY()-1);
	}
	
	public void MoveSouth() {
		if (this.CanMoveSouth()) super.setY(super.getY()+1);
	}

	public void MoveEast() {
		if (this.CanMoveEast()) super.setX(super.getX()+1);
	}
	
	public void MoveWest() {
		if (this.CanMoveWest()) super.setX(super.getX()-1);
	}
}*/
