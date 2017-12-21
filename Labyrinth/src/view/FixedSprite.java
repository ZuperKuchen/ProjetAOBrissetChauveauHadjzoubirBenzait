package view;

import model.Fixed;

public class FixedSprite extends Sprite{

	public FixedSprite(ViewFrame view, Fixed fixed, String imgPath) {
		super(view, fixed, imgPath);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		if(!((Fixed) this.item).getState()) {
			this.deleteView();
		}
	}
	
	

}
