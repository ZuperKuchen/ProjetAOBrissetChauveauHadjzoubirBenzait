package model;

import org.jgrapht.Graph;

import model.Edge.Type;

/*
 * Les objets issus de la classe abstraite moving sont les objets
 * qui seront déplacés au cours d'une partie. On doit pour cela
 * vérifier s'il n'essaie pas de passer par une porte fermé, un mur
 * ou de sortir du tableau de jeu.
 */

public abstract class Moving extends Item {

	public Moving(int x, int y, Graph<Cell, Edge> graph, Cell[][] cellArray) {
		super(x, y, graph, cellArray);
	}
	
	public boolean CanMoveNorth() {
		if(super.getY() > 0){
			Edge tmp = graph.getEdge(cellArray[super.getX()][super.getY()], cellArray[super.getX()][super.getY()-1]);
			if(tmp.getType() == Type.OPENED_DOOR || tmp.getType() == Type.CORRIDOR) {
				return true;
			}
		}
		return false;
	}
	
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
	 * Les méthodes pour déplacer l'item moving font appel
	 * à celles pour vérifier qu'il peut bien se déplacer
	 * dans la direction donnée, et le déplace dans ce cas.
	 * 
	 */
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

}
