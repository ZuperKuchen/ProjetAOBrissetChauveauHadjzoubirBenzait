package view;

import model.Item;

public class MovingSprite extends Sprite{

	public MovingSprite(ViewFrame stage, Item item, String imgPath) {
		super(stage, item, imgPath);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Display this sprite according to its coordinates
	 */
	public void update() {
		int x = item.getX();
		int y = item.getY();
		double xt = (int) ((ViewFrame.WALL + x * (ViewFrame.WALL + ViewFrame.CELL)) * ViewFrame.SPAN);
		double yt = (int) ((ViewFrame.WALL + y * (ViewFrame.WALL + ViewFrame.CELL)) * ViewFrame.SPAN);
		this.imageView.setX(xt);
		this.imageView.setY(yt);
	}
	
	
}
