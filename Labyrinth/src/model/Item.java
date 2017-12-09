package model;
/*
 * La classe abstraite Item permet d'instancier tous les objets qui seront
 * présents dans le jeu. Elle contient juste la position de l'objet. Ses classes
 * filles sont :
 * -Monster
 * -Player (singleton)
 * -Fixed (pour les items non déplaçables par le controller)
 * -Exit (singleton, et aussi non déplaçable)
 */

public abstract class Item {
	
	private int x;
	private int y;
	
	public Item(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

}
