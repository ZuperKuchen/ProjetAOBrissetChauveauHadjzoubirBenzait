package view;

import javafx.stage.*;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.*;
import javafx.scene.shape.Rectangle;

public class ViewFrame {
	
	static final int SPAN = 4;
	static final int WALL = 2;
	static final int CELL = 9;
	public static final Paint WALL_COLOR = Color.BURLYWOOD;
	public static final Paint SCENE_COLOR = Color.CORNSILK;
	
	private static Scene scene;
	private static Group pane;
	
	public static void drawFrame(Stage stage, int nbX, int nbY) {
		scene = new Scene(pane, ((WALL + CELL) * nbX + WALL) * SPAN,((WALL + CELL) * nbY + WALL) * SPAN);
		scene.setFill(SCENE_COLOR);
		
		Rectangle square;
		stage.setScene(scene);
		
		square = new Rectangle(0,0, SPAN * (nbX * (CELL + WALL) + WALL), WALL * SPAN);
		square.setFill(WALL_COLOR);
		pane.getChildren().add(square);
		
		square = new Rectangle(0, SPAN *(nbY * (CELL + WALL)), SPAN * (nbX * (CELL + WALL) + WALL), WALL * SPAN);
		square.setFill(WALL_COLOR);
		pane.getChildren().add(square);
		
		square = new Rectangle(0, 0, WALL * SPAN, SPAN * (nbY * (CELL + WALL) + WALL));
		square.setFill(WALL_COLOR);
		pane.getChildren().add(square);
		
		square = new Rectangle(SPAN * (nbX * (CELL + WALL)), 0, WALL * SPAN, SPAN * (nbY * (CELL + WALL) + WALL));
		square.setFill(WALL_COLOR);
		pane.getChildren().add(square);
		
		for (int x = 0; x < nbX-1 ; ++x) {
			int offsetX = ((WALL + CELL) + (WALL + CELL) * x) * SPAN;
			for (int y = 0; y < nbY-1; ++y) {
				int offsetY = ((WALL + CELL) + (WALL + CELL) * y) * SPAN;
				square = new Rectangle(offsetX, offsetY, WALL * SPAN, WALL * SPAN);
				square.setFill(WALL_COLOR);
				pane.getChildren().add(square);
			}
		}
	}
	
	
	
}
