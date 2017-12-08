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
		Labyrinth lab = new Labyrinth(16,16);
		Player player = Player.getInstance(0, 0, lab.getGraph(), lab.getCellArray());
		ViewFrame view = new ViewFrame();
		view.setTitle("Labyrinth");
		view.initFrame(lab.getSizeX(), lab.getSizeY());
		view.drawLabyrinth(lab.getGraph(), lab.getCellArray(), lab.getSizeX(), lab.getSizeY());
		view.show();
		ViewPlayer vp = ViewPlayer.getInstance();
		vp.initView();
		view.show();
		
		Controller c = new Controller(player, lab);
		view.getScene().setOnKeyPressed(c);
		//view.getScene().setOnKeyTyped(c);
		view.show();
		
	}

}
