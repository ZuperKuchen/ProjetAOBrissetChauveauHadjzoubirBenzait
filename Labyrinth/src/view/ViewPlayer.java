package view;



import model.Player;

public class ViewPlayer extends MovingSprite{
	
	private static ViewPlayer INSTANCE = null;
	
	private ViewPlayer(ViewFrame stage,Player player, String imgPath) {
		super(stage, player, imgPath);
	}
	
	public static ViewPlayer getInstance(ViewFrame stage) {
		if (INSTANCE == null) {
			INSTANCE = new ViewPlayer(stage,Player.getInstance(),PLAYER_SPRITE);
		}
		return INSTANCE;
	}
	
	public static ViewPlayer getInstance() {
		return INSTANCE;
	}
	
	@Override
	public void update() {
		double xt = (int) ((ViewFrame.WALL + item.getX() * (ViewFrame.WALL + ViewFrame.CELL)) * ViewFrame.SPAN);
		double yt = (int) ((ViewFrame.WALL + item.getY() * (ViewFrame.WALL + ViewFrame.CELL)) * ViewFrame.SPAN);
		this.imageView.setX(xt);
		this.imageView.setY(yt);
	}
	
	

	
}
