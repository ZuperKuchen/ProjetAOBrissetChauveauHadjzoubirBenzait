package main;

import javafx.application.Application;
import javafx.stage.Stage;
import model.Labyrinth;
import view.ViewFrame;



public class Main extends Application{

	public static void main(String[] args) {
			launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		primaryStage.setWidth(1024);
		primaryStage.setHeight(968);
		primaryStage.setTitle("Labyrinth");
		ViewFrame.drawFrame(primaryStage, 16, 16);
		primaryStage.show();
		
		
	}

}
