package view;

import javafx.scene.image.ImageView;
public interface ISprite {
	
	/**
	 * Initialisation function. Display the sprite in the stage.
	 */
	public void initView();
	
	/**
	 * Remove the sprite from the stage
	 */
	public void deleteView();
	
	/**
	 *Depending on the implementation, update the position of the sprite or 
	 *remove the sprite if it's a collectible
	 */
	public void update();
	
	public ViewFrame getView();
	public ImageView getImageView();

}
