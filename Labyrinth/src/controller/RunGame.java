package controller;

import controller.ItemCollision.Event;
import javafx.animation.AnimationTimer;
import model.Level;
import model.Player;
import view.ViewFrame;
/**
 * Main controller class
 */
public class RunGame {
	static int difficulty = 1;
	final static int DIFF_MAX = 3; 

	public static synchronized void run(int sizeX, int sizeY) {
		runLevel(difficulty++, sizeX, sizeY);
	}
	
	/**
	 * Run a level by creating a model a view and starting the animationTimer.
	 * If the player won the level, runLevel is called recursively until the player lose, quit or win the last level
	 * of difficulty (DIFF_MAX)
	 * @param difficulty the difficulty of the current level
	 * @param sizeX	width of the game board
	 * @param sizeY height of the game board
	 */
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
						view.removePlayerView();
						if (RunGame.difficulty <= RunGame.DIFF_MAX)
							runLevel(RunGame.difficulty++, sizeX, sizeY);
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
	}
}
