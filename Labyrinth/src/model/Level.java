package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import model.Fixed.Name;

public class Level {
	
	private Labyrinth lab;
	private int difficulty;
	
	private Player player;
	private Exit exit;
	
	private List<Fixed> fixedItems;
	private List<Monster> monsters;
//use List.add(int index, E element) to add . Besoin de l'index pour view quoi que List.indexOf(Object o) existe
	
	
	
	public Level(int difficulty, int sizeX, int sizeY) {
		lab = new Labyrinth(sizeX, sizeY);
		this.difficulty = difficulty;
		this.fixedItems = new ArrayList<>();
		this.monsters = new ArrayList<>();
		itemsGenerator();
		//TODO Ecrire une méthode de vérification de faisabilité
	}

	private void itemsGenerator() {
		player = Player.getInstance(0, 0);								//TODO
		//exit = Exit.getInstance(3, 3); //just for test
		exit = Exit.getInstance(lab.getSizeX()-1, lab.getSizeY()-1);
		fixedItems.add(0, new Fixed(3, 3, true, Name.CANDY));
		monsters.add(0, new Monster(5, 5));
	}

	public Labyrinth getLab() {
		return lab;
	}

	public int getDifficulty() {
		return difficulty;
	}

	public Player getPlayer() {
		return player;
	}

	public Exit getExit() {
		return exit;
	}

	public List<Fixed> getFixedItems() {
		return fixedItems;
	}

	public List<Monster> getMonsters() {
		return monsters;
	}
}
