package controller;

import controller.ItemCollision.Event;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.util.Duration;
import model.Level;
import view.ViewFrame;
import view.ViewPlayer;

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
		/*Timeline timeline = new Timeline(new KeyFrame(Duration.millis(2500), playerControl.movePlayer() ));
		Timeline test = new Tim
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
        */
		System.out.print("\n");
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
