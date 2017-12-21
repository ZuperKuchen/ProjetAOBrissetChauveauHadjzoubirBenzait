package model;



public class Player extends Item{
	
	private Player(int x, int y) {
		super(x, y);
	}
	
	private static Player INSTANCE = null;
	
	public static Player getInstance(int x, int y) {
		if(INSTANCE == null) {
			INSTANCE = new Player(x, y);
		}
		return INSTANCE;
	}
	
	public static Player getInstance() {
		return INSTANCE;
	}

}
