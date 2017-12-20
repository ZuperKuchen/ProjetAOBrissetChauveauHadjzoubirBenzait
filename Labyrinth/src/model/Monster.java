package model;

import model.Labyrinth.Direction;

public class Monster extends Item {

	public Monster(int x, int y) {
		super(x, y);
	}
	
	public void move(Level currentLvl) {
		Cell cellArray[][] = currentLvl.getLab().getCellArray();
		Cell monsterCell = cellArray[this.getX()][this.getY()];
		int playerX = currentLvl.getPlayer().getX();
		int playerY = currentLvl.getPlayer().getY();
		Cell playerCell = cellArray[playerX][playerY];
		currentLvl.getLab().launchManhattan(monsterCell, playerCell);
		int mark = monsterCell.getMark();
		for(Direction dir : Direction.values()) {
			if(dir == Direction.NORTH) {
				if (this.getY() > 0 && cellArray[this.getX()][this.getY() - 1].getMark() == mark - 1) {
					this.setY(this.getY() - 1);
				}
			}
			if(dir == Direction.SOUTH) {
				if (this.getY() < currentLvl.getLab().getSizeY() - 1 && cellArray[this.getX()][this.getY() + 1].getMark() == mark - 1) {
					this.setY(this.getY() + 1);
				}
			}
			if(dir == Direction.EAST) {
				if (this.getX() < currentLvl.getLab().getSizeX() - 1 && cellArray[this.getX() + 1][this.getY()].getMark() == mark - 1) {
					this.setX(this.getX() + 1);
				}
			}
			if(dir == Direction.WEST) {
				if (this.getX() > 0 && cellArray[this.getX() - 1][this.getY()].getMark() == mark - 1) {
					this.setX(this.getX() - 1);
				}
			}

		}
	}
}
