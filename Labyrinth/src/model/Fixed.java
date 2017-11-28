package model;

import org.jgrapht.Graph;

/*
 * La classe abstraite fixed est implémentée pour l'attribut "on" qui peut être utilisé dans
 * plusieurs cas. En l'occurence nous avons pour l'instant les objets de classe "candy" qui utilisent
 * l'attribut ON pour savoir s'il est encore à ramasser, et les objets de classe "switch"
 * qui l'utilisent pour savoir si l'intérupteur est activé ou non.
 */

public abstract class Fixed extends Item {
	
	private boolean on;
	
	public Fixed(int x, int y, Graph<Cell, Edge> graph, Cell[][] cellArray, boolean on) {
		super(x, y, graph, cellArray);
		this.on = on;
	}

	public boolean isOn() {
		return on;
	}
	
	public void turn(boolean on) {
		this.on = on;
	}

	public void turnOn() {
		this.on = true;
	}
	
	public void turnOff() {
		this.on = false;
	}
}
