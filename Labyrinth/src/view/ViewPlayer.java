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
	
}
