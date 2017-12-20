package view;

import javafx.scene.image.ImageView;

public interface ISprite {
	
	public void initView();
	public void deleteView();
	public void update();
	public ViewFrame getView();
	public ImageView getImageView();

}
