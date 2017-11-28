package main;

import javafx.application.Application;
import javafx.stage.Stage;
import view.*;
import model.*;

public class Main extends Application{

	public static void main(String[] args) {
			launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		primaryStage.setTitle("Labyrinth");
		ViewFrame.drawFrame(primaryStage, 16, 16);
		primaryStage.show();
		Labyrinth lab = new Labyrinth(0,16,16);
		ViewFrame.drawLabyrinth(primaryStage, lab.getGraph(), lab.getCellArray(), 16, 16);
		primaryStage.show();
		Player player = Player.getInstance(0, 0, lab.getGraph(), lab.getCellArray());
		ViewPlayer.View();
		primaryStage.show();
		
		
	}

}
