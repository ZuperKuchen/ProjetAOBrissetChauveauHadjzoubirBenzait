package model;

public class Exit extends Item {

	private Exit(int x, int y) {
		super(x, y);
	}
	
	private static Exit INSTANCE = null;
	
	public static Exit getInstance(int x, int y) {
		if(INSTANCE == null) {
			INSTANCE = new Exit(x, y);
		}
		return INSTANCE;
	}

}
