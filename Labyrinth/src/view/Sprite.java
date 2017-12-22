package view;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.Item;

public abstract class Sprite implements ISprite{


	static final String PLAYER_SPRITE = "/player.png";
	static final String BAD_SPRITE = "/bad.png";
	static final String BUTT_CLOSE_SPRITE = "/button_close.png";
	static final String BUTT_OPEN_SPRITE = "/button_open.png";
	static final String DOOR_SPRITE = "/door_open.png";
	static final String CANDY1_SPRITE = "/candy-1.png";
	static final String CANDY2_SPRITE = "/candy-2.png";
	static final String CANDY3_SPRITE = "/candy-3.png";
	static final String CANDY4_SPRITE = "/candy-4.png";
	
	
	protected ImageView imageView;
	protected Item item;
	protected ViewFrame view;	
	
	public abstract void update();
	
	/**
	 * Class Constructor. Initialize attributes.
	 * @param view the stage where this sprite need to be display
	 * @param item the item corresponding to this sprite in the model
	 * @param imgPath the filename of this sprite
	 */
	public Sprite(ViewFrame view, Item item, String imgPath) {
		this.item = item;
		this.imageView = new ImageView(new Image(imgPath));
		this.view = view;
	}
	
	public ViewFrame getView() {
		return this.view;
	}
	
	public ImageView getImageView() {
		return imageView;
	}
		
	public void setView(ViewFrame view) {
		this.view  = view;
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
