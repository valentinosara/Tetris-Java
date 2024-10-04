package main;

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
	
	public void play() {
		printScreen(initialScreen);
		System.out.println("");
		String[][] down1 = move(initialScreen, Movement.DOWN);
		printScreen(down1);
		System.out.println("");
		String[][] down2 = move(down1, Movement.DOWN);
		printScreen(down2);
	}
	
	public String[][] move(String[][] screen, Movement move) {
		String[][] newScreen = newScreen();
		
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
						System.out.println("");
						break;
					case LEFT:
						System.out.println("");
						break;
					case ROTATE:
						System.out.println("");
						break;
					default:
						System.out.println("");
						break;
					}					
					newScreen[newRowIndex][newColumnIndex] = BLACK;
				}
			}
		}
		return newScreen;
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
