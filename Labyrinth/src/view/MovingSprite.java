package view;

import model.Item;

public class MovingSprite extends Sprite{

	public MovingSprite(ViewFrame stage, Item item, String imgPath) {
		super(stage, item, imgPath);
		// TODO Auto-generated constructor stub
	}
	
	public void update() {
		int x = item.getX();
		int y = item.getY();
		if (x < 0 || y < 0){
			this.deleteView();
			return;
		}
		double xt = (int) ((ViewFrame.WALL + x * (ViewFrame.WALL + ViewFrame.CELL)) * ViewFrame.SPAN);
		double yt = (int) ((ViewFrame.WALL + y * (ViewFrame.WALL + ViewFrame.CELL)) * ViewFrame.SPAN);
		this.imageView.setX(xt);
		this.imageView.setY(yt);
	}
	
	
}
