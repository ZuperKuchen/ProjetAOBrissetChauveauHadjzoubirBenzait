package model;

public class Level {
	
	private Labyrinth lab;
	private int difficulty;
	
	private Player player;
	private Exit exit;
	
	private Fixed[] fixedItems;
	private Monster[] monsters;

	
	
	
	public Level(int difficulty, int sizeX, int sizeY) {
		lab = new Labyrinth(sizeX, sizeY);
		this.difficulty = difficulty;
		itemsGenerator();
		//TODO Ecrire une méthode de vérification de faisabilité
	}

	private void itemsGenerator() {
		player = Player.getInstance(0, 0);								//TODO
		exit = Exit.getInstance(lab.getSizeX()-1, lab.getSizeY()-1);
		fixedItems = null;
		monsters = null;
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

	public Fixed[] getFixedItems() {
		return fixedItems;
	}

	public Monster[] getMonsters() {
		return monsters;
	}
}
