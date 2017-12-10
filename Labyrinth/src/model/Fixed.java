package model;

/*
 * La classe fixed est implémentée pour les objets qui ne doivent pas être déplacés.
 * "state" qui peut être utilisé dans plusieurs cas. En l'occurence nous avons pour 
 * l'instant les objets "candy" qui utilisent l'attribut "state" pour savoir s'il est 
 * encore à ramasser, et les objets "switch" qui l'utilisent pour savoir si 
 * l'intérupteur est activé ou non.
 */

public class Fixed extends Item {
	
	public enum Name{
		CANDY,
		SWITCH;
	};
	
	private boolean state;
	private Name name;
	
	
	public Fixed(int x, int y, boolean state, Name name) {
		super(x, y);
		this.name = name;
		this.state = state;
	}

	public boolean getState() {
		return state;
	}
	
	public void turn(boolean state) {
		this.state = state;
	}

	public void turnOn() {
		this.state = true;
	}
	
	public void turnOff() {
		this.state = false;
	}
	
	public Name getName() {
		return name;
	}

}
