package main;

import model.Labyrinth;



public class main {

	public static void main(String[] args) {
		Labyrinth Test = new Labyrinth(0, 16, 16);
		for(int x = 0; x < 15; x++) {
			for(int y = 0; y < 15; y++) {
				System.out.print(Test.getGraph().containsEdge(Test.cellArray[x][y], Test.cellArray[x+1][y]));
				System.out.print('_');
			}
			System.out.print('\n');
		}
		System.out.print('\n');
		System.out.print('\n');
		
		for(int x = 0; x < 15; x++) {
			for(int y = 0; y < 15; y++) {
				System.out.print(Test.getGraph().containsEdge(Test.cellArray[x][y], Test.cellArray[x][y+1]));
				System.out.print('_');
			}
			System.out.print('\n');
		}

	}

}
