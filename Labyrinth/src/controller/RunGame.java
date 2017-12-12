package controller;

import controller.ItemCollision.Event;
import model.Level;
import view.ViewFrame;
import view.ViewPlayer;

public class RunGame {
	public static void run(int sizeX, int sizeY) {
		
		
		/*
		 * On a besoin de Level pour créer une view
		 * 
		 */
		/*ViewFrame view = ViewFrame.getInstance();
		view.setTitle("Labyrinth");
		view.initFrame(sizeX, sizeY);
		*/
		int difficulty = 0;
		Event event = Event.NEXT_LEVEL;
		//TODO WHILE EVENT == NEXT_LEVEL
			runLevel(difficulty, sizeX, sizeY);
			difficulty ++;
		
	}
	private static void runLevel(int difficulty, int sizeX, int sizeY) {
		Level currentLevel = new Level(difficulty, sizeX, sizeY);
		
		ViewFrame view = new ViewFrame(currentLevel);
		view.show();
		//ViewFrame view = ViewFrame.getInstance();
		//view.drawLabyrinth(currentLevel.getLab().getGraph(), currentLevel.getLab().getCellArray(), sizeX, sizeY);
		//ViewPlayer vp = ViewPlayer.getInstance(view);
		//vp.initView();
		view.initFrame();
		view.drawLabyrinth();
		
		PlayerControl playerControl = new PlayerControl(currentLevel);
		view.getScene().setOnKeyPressed(playerControl);
		System.out.print("\n");
		System.out.print("Je boucle bien salement\n");
		
		/*while(true) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.print("Je boucle bien salement\n");
			view.show();
		}*/
	}
}
