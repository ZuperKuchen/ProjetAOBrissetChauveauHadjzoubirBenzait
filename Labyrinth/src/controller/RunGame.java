package controller;

import controller.ItemCollision.Event;
import javafx.animation.AnimationTimer;
import model.Level;
import view.ViewFrame;

public class RunGame {
	
	public static void run(int sizeX, int sizeY) {
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
					//TODO
					//Detection des collisions
					Event event = ItemCollision.collision(currentLevel);
					System.out.println(event);
					switch(event) {
					case GET_CANDY:
						System.out.println("Une belle Collision");
						view.updateItems();
						break;						
					case LOSE_GAME:
						break;
					case NEXT_LEVEL:
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
		
		//System.out.print("\n");
		//System.out.print("Je boucle bien salement\n");
		
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
