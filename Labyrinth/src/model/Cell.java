package model;

public class Cell {
	private int x;
	private int y;
	
	public Cell(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Cell() {
		this.x = 0;
		this.y = 0;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int compareTo(Cell target) {
		if(this.getX() == target.getX() && this.getY() == target.getY()) {
			return 0;
		}
		else{
			return (this.getX()+this.getY()) - (target.getX()+target.getY());
		}
	}


}
