package view;



import model.Player;

public class ViewPlayer extends ViewMovable{
	
	private static ViewPlayer INSTANCE = null;
	
	private ViewPlayer(Player player, String imgPath) {
		super(player, imgPath);
	}
	
	public static ViewPlayer getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new ViewPlayer(Player.getInstance(),PLAYER_SPRITE);
		}
		return INSTANCE;
	}
	
	
	public void init() {
//		Image image = new Image("file:img/player.png");
//		imageView = new ImageView(image);
//		item = (Player) Player.getInstance();
	}
	
	
	public void update() {
		//ViewFrame.pane.getChildren().add(this.imageView);
		double xt = (int) ((ViewFrame.WALL + item.getX() * (ViewFrame.WALL + ViewFrame.CELL)) * ViewFrame.SPAN);
		double yt = (int) ((ViewFrame.WALL + item.getY() * (ViewFrame.WALL + ViewFrame.CELL)) * ViewFrame.SPAN);
		this.imageView.setX(xt);
		this.imageView.setY(yt);
	}
	
	

	
}
