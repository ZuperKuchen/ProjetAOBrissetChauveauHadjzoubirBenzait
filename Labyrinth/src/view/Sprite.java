package view;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.Item;

public abstract class Sprite implements ISprite{

	static final String PLAYER_SPRITE = "file:img/player.png";
	static final String BAD_SPRITE = "file:img/bad.png";
	static final String BUTT_CLOSE_SPRITE = "file:img/button_close.png";
	static final String BUTT_OPEN_SPRITE = "file:img/button_open.png";
	static final String DOOR_SPRITE = "file:img/door_open.png";
	static final String CANDY1_SPRITE = "file:img/candy-1.png";
	static final String CANDY2_SPRITE = "file:img/candy-2.png";
	static final String CANDY3_SPRITE = "file:img/candy-3.png";
	static final String CANDY4_SPRITE = "file:img/candy-4.png";
	
	protected ImageView imageView;
	protected Item item;
	protected ViewFrame view;	
	
	public abstract void update();
	
	public Sprite(ViewFrame view, Item item, String imgPath) {
		this.item = item;
		this.imageView = new ImageView(new Image(imgPath));
		this.view = view;
	}
	
	ViewFrame getView() {
		return this.view;
	}
	
	public ImageView getImageView() {
		return imageView;
	}
		
	public void deleteView() {
		this.view.getPane().getChildren().remove(this.imageView);
	}
	
	public void initView(){
		this.view.getPane().getChildren().add(this.imageView);
		double xt = (int) ((ViewFrame.WALL + item.getX() * (ViewFrame.WALL + ViewFrame.CELL)) * ViewFrame.SPAN);
		double yt = (int) ((ViewFrame.WALL + item.getY() * (ViewFrame.WALL + ViewFrame.CELL)) * ViewFrame.SPAN);
		imageView.setX(xt);
		imageView.setY(yt);
	}
	
	
}
