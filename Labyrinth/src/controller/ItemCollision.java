package controller;

import model.Item;
import model.LevelItems;
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
	
	private static boolean sameCell(Item item1, Item item2) {
		return item1.getX() == item2.getX() && item1.getY() == item2.getY();
	}
	
	private static Event whichEvent(Item item) {
		String itemName = item.getClass().getName();
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
	
	public static void Run(LevelItems ItemArray) {
		
		//TODO parcourir le tableau et déterminer s'il y a une collision en cours.
		
	}
}












