package main;

import javafx.application.Application;
import javafx.stage.Stage;
import view.*;
import model.*;
import controller.RunGame;

public class Main extends Application{

	public static void main(String[] args) {
			launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		RunGame.run(16,16);
	}
	
}
