package controller;

import controller.ItemCollision.Event;
import javafx.animation.AnimationTimer;
import model.Level;
import view.ViewFrame;

public class RunGame {
	static int difficulty = 0;

	public static void run(int sizeX, int sizeY) {
		//int difficulty = 0;
		Event event = Event.NEXT_LEVEL;
		//TODO WHILE EVENT == NEXT_LEVEL
			runLevel(difficulty++, sizeX, sizeY);
			System.out.println("I returned from runLevel");
	}
	
	public static void newGame() {
		
	}
	
	private static void runLevel(int difficulty, int sizeX, int sizeY) {
		Level currentLevel = new Level(difficulty, sizeX, sizeY);
		ViewFrame view = new ViewFrame(currentLevel);
		view.show();
		view.initFrame();
		view.drawLabyrinth();
		PlayerControl playerControl = new PlayerControl(currentLevel);
		view.getScene().setOnKeyPressed(playerControl);
		AnimationTimer gameLoop = new AnimationTimer() {
			
			private long lastUp = 0;
			@Override
			public void handle(long now) {
				if(now - lastUp >= 350_000_000) {
					// TODO Auto-generated method stub
					//Player
					playerControl.movePlayer();
					//Monsters
					currentLevel.getMonsters().forEach(Monster -> Monster.move(currentLevel));
					view.updateMonsters();
					//Detection des collisions
					Event event = ItemCollision.collision(currentLevel);
					switch(event) {
					case GET_CANDY:
						view.updateItems();
						break;						
					case LOSE_GAME:
						stop();
						break;
					case NEXT_LEVEL:
						stop();
						view.close();
						System.out.println("Let me try");
						//newGame();
						break;
					case OPEN_DOOR:
						break;
					case NOTHING:
						break;
					default:
						break;
					}
					lastUp = now;
				}
			}
		};
		
		gameLoop.start();
		System.out.println("plz let me out ");
	}
}
