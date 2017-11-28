package view;



import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.Player;

public class ViewPlayer{
	private static String imgPath = "file:img/player.png";
	private static ImageView imageView;
	private static Player player = Player.getInstance();
	
	
	
	//NOT FINISH
	public static void View(){
		Image image = new Image(imgPath);
		imageView = new ImageView(image);
		
		ViewFrame.pane.getChildren().add(ViewPlayer.imageView);
		double xt = (int) ((ViewFrame.WALL + player.getX() * (ViewFrame.WALL + ViewFrame.CELL)) * ViewFrame.SPAN);
		double yt = (int) ((ViewFrame.WALL + player.getY() * (ViewFrame.WALL + ViewFrame.CELL)) * ViewFrame.SPAN);
		imageView.setX(xt);
		imageView.setY(yt);
	}

	
}
