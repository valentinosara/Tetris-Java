package main;

import java.util.Scanner;

public class Tetris {
	private static final String BLACK = "🟫"; 
	private static final String WHITE = "⬛️"; 
	private String[][] initialScreen = {
			{"🟫","⬛","⬛️","⬛️","⬛️","⬛️","⬛️","⬛️","⬛️","⬛️"},
			{"🟫","🟫","🟫","⬛️","⬛️","⬛️","⬛️","⬛️","⬛️","⬛️"},
			{"⬛️","⬛️","⬛️","⬛️","⬛️","⬛️","⬛️","⬛️","⬛️","⬛️"},
			{"⬛️","⬛️","⬛️","⬛️","⬛️","⬛️","⬛️","⬛️","⬛️","⬛️"},
			{"⬛️","⬛️","⬛️","⬛️","⬛️","⬛️","⬛️","⬛️","⬛️","⬛️"},
			{"⬛️","⬛️","⬛️","⬛️","⬛️","⬛️","⬛️","⬛️","⬛️","⬛️"},
			{"⬛️","⬛️","⬛️","⬛️","⬛️","⬛️","⬛️","⬛️","⬛️","⬛️"},
			{"⬛️","⬛️","⬛️","⬛️","⬛️","⬛️","⬛️","⬛️","⬛️","⬛️"},
			{"⬛️","⬛️","⬛️","⬛️","⬛️","⬛️","⬛️","⬛️","⬛️","⬛️"},
			{"⬛️","⬛️","⬛️","⬛️","⬛️","⬛️","⬛️","⬛️","⬛️","⬛️"},
	};
	private int[][][] rotations = {
			{{0, 2}, {-1, 1}, {0, 0}, {1, -1}},
			{{1, 1}, {2, 0}, {0, 0}, {-1, -1}},
			{{-1, 1}, {0, 0}, {1, -1}, {0, -2}},
			{{1, 1}, {0, 0}, {-2, 0}, {-1, -1}},
		};
	private int rotationState;
	
	//CONSTRUCTOR
	public Tetris() {
		this.rotationState = 0;
	}

	public void play() {
		Scanner scanner = new Scanner(System.in);
		boolean running = true;
		String[][] screen = initialScreen;
		System.out.println("Welcome to tetris basic movements");
		System.out.println("Press 'A' to move left, 'S' to move down, 'D' to move rigth, 'R' to rotate and 'Q' to exit.");
		printScreen(screen);
		
		while(running){
			String input = scanner.nextLine();
			input = input.toUpperCase();
			
			switch (input) {
			case "A":
				screen = move(screen, Movement.LEFT);
				printScreen(screen);
				break;
			case "S":
				screen = move(screen, Movement.DOWN);
				printScreen(screen);
				break;
			case "D":
				screen = move(screen, Movement.RIGHT);
				printScreen(screen);
				break;
			case "R":
				screen = move(screen, Movement.ROTATE);
				printScreen(screen);
				break;
			case "Q":
				running = false;
				System.out.println("Ending program..");
				break;

			default:
				System.out.println("Invalid input.");
				break;
			}
		}
	}
	
	public String[][] move(String[][] screen, Movement move) {
		String[][] newScreen = newScreen();
		int actualDot = 0;
		boolean validMove = false;
		System.out.println("");		
		
		for (int rowIndex = 0; rowIndex < screen.length; rowIndex++) {
			
			for (int columnIndex = 0; columnIndex < screen[0].length; columnIndex++) {				
				String item = screen[rowIndex][columnIndex];				
				
				if (item.equals(BLACK)) {
					int newRowIndex = 0, newColumnIndex = 0;
					switch (move) {
					case DOWN:
						newRowIndex = rowIndex + 1;
						newColumnIndex = columnIndex;
						break;
					case RIGHT:
						newRowIndex = rowIndex;
						newColumnIndex = columnIndex + 1;
						break;
					case LEFT:
						newRowIndex = rowIndex;
						newColumnIndex = columnIndex - 1;		
						break;
					case ROTATE:
						newRowIndex = rowIndex + rotations[rotationState][actualDot][0];
						newColumnIndex = columnIndex + rotations[rotationState][actualDot][1];
						actualDot++;
						break;
					default:						
						break;
					}
					validMove = newRowIndex < screen.length && newColumnIndex < screen.length && newColumnIndex >= 0;
					if (validMove) {
						newScreen[newRowIndex][newColumnIndex] = BLACK;						
					} else {
						newScreen = screen;
					}
				}
			}
		}
		if (move.equals(Movement.ROTATE) && validMove) {
			if (rotationState == 3) {
				rotationState = 0;
			} else {
				rotationState++;
			}			
		}
		return (newScreen);
	}
	
	private void printScreen(String[][] screen) {
		for (String[] row : screen) {
			StringBuilder line = new StringBuilder();
			for (String dot : row) {
				line.append(dot);
			}
			System.out.println(line);
		}
	}
	
	private String[][] newScreen(){
		String[][] result = new String[initialScreen.length][initialScreen[0].length];
		for (int i = 0; i < initialScreen.length; i++) {
			for (int j = 0; j < initialScreen[0].length; j++) {
				result[i][j] = WHITE;
			}
		}
		return result;
	}
	
}
