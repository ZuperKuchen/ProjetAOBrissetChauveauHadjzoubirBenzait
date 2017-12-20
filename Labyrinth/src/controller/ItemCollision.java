package controller;


import model.Item;
import model.Level;
import model.Fixed;
import model.Fixed.Name;

public class ItemCollision {
	
	public enum Event{
		LOSE_GAME,
		OPEN_DOOR,
		NEXT_LEVEL,
		GET_CANDY,
		NOTHING;
	};
	
	private static boolean sameCell(Item item1, Item item2) {					//Est-ce que les items sont sur
		return item1.getX() == item2.getX() && item1.getY() == item2.getY();	//la même case
	}
	
	private static Event whichEvent(Item item) {					//Détermine quel évènement découle de la collision
		String itemName = item.getClass().getName();				//en cours
		if(itemName == model.Player.class.getName()) {
			return Event.NOTHING;
		}

		if(itemName == model.Exit.class.getName()) {
			return Event.NEXT_LEVEL;
		}
		else if(itemName == model.Monster.class.getName()) {
			return Event.LOSE_GAME;
		}
		else if(itemName == model.Fixed.class.getName()) {
			if(!((Fixed) item).getState()) {
				return Event.NOTHING;
			}
			if(((Fixed) item).getName() == Name.CANDY) {
				return Event.GET_CANDY;
			}
			else if(((Fixed) item).getName() == Name.SWITCH) {
				return Event.OPEN_DOOR;
			}
		}
		return Event.NOTHING;
		
	}
	
	public static Event collision(Level itemArray) {			//Parcours les items et détermine la collision
																	//s'il y en a une. Renvoie l'objet concerné.
		if(sameCell(itemArray.getPlayer(),itemArray.getExit())) {
			return whichEvent(itemArray.getExit());
		}
		for(int i = 0; i < itemArray.getFixedItems().size(); i++) {
			if(sameCell(itemArray.getPlayer(),itemArray.getFixedItems().get(i))) {
				System.out.println("Que Voila?");
				Event event =  whichEvent(itemArray.getFixedItems().get(i));	
				itemArray.getFixedItems().get(i).turnOff();
				return event;
			}
		}
		for(int i = 0; i < itemArray.getMonsters().size(); i++) {
			if(sameCell(itemArray.getPlayer(),itemArray.getMonsters().get(i))) {
				return whichEvent(itemArray.getMonsters().get(i));
			}
		}
		return Event.NOTHING;
	}
	
}












