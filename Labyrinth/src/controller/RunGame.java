package controller;

import controller.ItemCollision.Event;
import model.Level;
import view.ViewFrame;
import view.ViewPlayer;

public class RunGame {
	public static void run(int sizeX, int sizeY) {
		
		ViewFrame view = ViewFrame.getInstance();
		view.setTitle("Labyrinth");
		view.initFrame(sizeX, sizeY);
		
		int difficulty = 0;
		Event event = Event.NEXT_LEVEL;
		//TODO WHILE EVENT == NEXT_LEVEL
			runLevel(difficulty, sizeX, sizeY);
			difficulty ++;
		
	}
	private static void runLevel(int difficulty, int sizeX, int sizeY) {
		Level currentLevel = new Level(difficulty, sizeX, sizeY);
		
		ViewFrame view = ViewFrame.getInstance();
		view.drawLabyrinth(currentLevel.getLab().getGraph(), currentLevel.getLab().getCellArray(), sizeX, sizeY);
		ViewPlayer vp = ViewPlayer.getInstance(view);
		vp.initView();
		
		PlayerControl playerControl = new PlayerControl(currentLevel);
		view.getScene().setOnKeyPressed(playerControl);
		view.show();
	}
}
