package model;


public class Monster extends Item {

	public Monster(int x, int y) {
		super(x, y);
	}
	
	public Cell nextCell(Labyrinth lab) {
		
		
		Cell cell= new Cell(1,2);
		return cell;
	}
}
