package main;

import javafx.application.Application;
import javafx.stage.Stage;
import view.*;
import model.*;
import controller.Controller;

public class Main extends Application{

	public static void main(String[] args) {
			launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		/*boolean play = true;
		int difficulty = 0;*/
		Labyrinth lab = new Labyrinth(16,16);
		
		ViewFrame view = ViewFrame.getInstance();
		view.setTitle("Labyrinth");
		view.initFrame(lab.getSizeX(), lab.getSizeY());
		view.drawLabyrinth(lab.getGraph(), lab.getCellArray(), lab.getSizeX(), lab.getSizeY());
		view.show();
		Player player = Player.getInstance(0, 0);
		ViewPlayer vp = ViewPlayer.getInstance(view);
		vp.initView();
		view.show();
		
		Controller c = new Controller(player, lab);
		view.getScene().setOnKeyPressed(c);
		//view.getScene().setOnKeyTyped(c);
		view.show();
	}

}
