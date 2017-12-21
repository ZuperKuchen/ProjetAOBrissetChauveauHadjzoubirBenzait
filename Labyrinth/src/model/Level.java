package model;

import java.util.ArrayList;
import java.util.List;
import model.Fixed.Name;

public class Level {
	
	private Labyrinth lab;
	private int difficulty;
	
	private Player player;
	private Exit exit;
	
	private List<Fixed> fixedItems;
	private List<Monster> monsters;
	
	
	
	public Level(int difficulty, int sizeX, int sizeY) {
		lab = new Labyrinth(sizeX, sizeY);
		this.difficulty = difficulty;
		this.fixedItems = new ArrayList<>();
		this.monsters = new ArrayList<>();
		itemsGenerator();
		//TODO Ecrire une méthode de vérification de faisabilité
	}

	private void itemsGenerator() {
		player = Player.getInstance(0,0);
		resetPosPlayer(0, 0);
		exit = Exit.getInstance(lab.getSizeX()-1, lab.getSizeY()-1);

		
		for(int i = 0; i < difficulty; i++) {
			int randomX = (int)(Math.random()*lab.getSizeX());
			int randomY = (int)(Math.random()*lab.getSizeY());
			fixedItems.add(0, new Fixed(randomX, randomY, true, Name.CANDY));
			randomX = (int)(Math.random()*lab.getSizeX()/2 + lab.getSizeX()/2);
			randomY = (int)(Math.random()*lab.getSizeY()/2 + lab.getSizeY()/2);
			monsters.add(0, new Monster(randomX, randomY));
		}
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
	
	private void resetPosPlayer(int x,int y){
		this.player.setX(x);
		this.player.setY(y);
	}
}
