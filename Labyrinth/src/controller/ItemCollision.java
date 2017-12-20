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
		if(itemName == "Player") {
			return Event.NOTHING;
		}

		if(itemName == "Exit") {
			return Event.NEXT_LEVEL;
		}
		else if(itemName == "Monster") {
			return Event.LOSE_GAME;
		}
		else if(itemName == "Fixed") {
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
	
	private static Item run(Level itemArray, Event event) {			//Parcours les items et détermine la collision
																	//s'il y en a une. Renvoie l'objet concerné.
		itemArray.getPlayer();
		itemArray.getExit();
		if(sameCell(itemArray.getPlayer(),itemArray.getExit())) {
			event = whichEvent(itemArray.getExit());
			return itemArray.getExit();
		}
		for(int i = 0; i < itemArray.getFixedItems().size(); i++) {
			if(sameCell(itemArray.getPlayer(),itemArray.getFixedItems().get(i))) {
				event = whichEvent(itemArray.getFixedItems().get(i));
				return itemArray.getFixedItems().get(i);
			}
		}
		for(int i = 0; i < itemArray.getMonsters().size(); i++) {
			if(sameCell(itemArray.getPlayer(),itemArray.getMonsters().get(i))) {
				event = whichEvent(itemArray.getMonsters().get(i));
				return itemArray.getMonsters().get(i);
			}
		}
		return null;
	}
	public static Event collision(Level currentGame) {
		Event event = Event.NOTHING;
		Item item = run(currentGame, event);
		
		/*
		 * Ici nous gérons l'interaction avec l'objet concerné par la collision.
		 */
		if(event == Event.GET_CANDY) {
			((Fixed) item).turnOff();
			event = Event.NOTHING;
		}
		if(event == Event.OPEN_DOOR) {
			((Fixed) item).turnOff();
			//TODO Gérer l'ouverture de portes, qui doivent être définies dans Labyrinth (je pense)
			event = Event.NOTHING;
		}
		
		/*
		 * L'évènement que l'on retourne est soit NOTHING, soit LOSE soit NEXT
		 * il doit donc être récupéré par le controller pour savoir quoi
		 * exécuter ensuite.
		 */
		return event;
	}
}












