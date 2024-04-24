package project;
import java.util.*;

public class Game {
	
	static String player = "|"; //player icon...
	static final int gridSize = 30; //Set up the game board size
	static String[][] grid = new String[gridSize][gridSize]; // Create the game board
	static boolean inGame = true; // Check if playing
	

	@SuppressWarnings("finally") //Needed bc error/warning due to break in finally
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int h = gridSize-1; //Variable used for gravity
		Scanner s = new Scanner(System.in); //Prototype check for player movement.
		for (int r = 0; r < gridSize; r++) {
			for (int c = 0; c < gridSize; c++) {
				
				if (r == gridSize-1) {
					grid[r][c] = "-";
				}
				else
					grid[r][c] = " ";
			}
			
		}
		grid[gridSize-2][0] = player;
		
		// Initialize player starting point and game board
		
		int count = 0; // Prototype endGame
		while (inGame) { // Start the game
		for (int r = 0; r < gridSize; r++) {
			for (int c = 0; c < gridSize; c++) {
				
			System.out.print(grid[r][c]);
			
		}
			System.out.println("");
	}
		//Show game board
		String movement = s.next();
		movement = movement.toLowerCase();
		// Get movement
		
		switch(movement) { // Do the movement. w to jump/move up, a to move left, s to go down (may not even be needed), d to move right(Bugged)
		case "w":
			try {
			for (int r = 0; r < gridSize; r++) {
				for (int c = 0; c < gridSize; c++) { //Check for player
					
					if (grid[r][c].equals(player)) {
						grid[r-1][c] = player;
						grid[r][c] = " ";
						h = r;
					}
				}
				
			}
			} catch (Exception e ) {
				System.out.println("Invalid Move");
			}finally {
			break;
			}
		case "a": 
			try {
				for (int r = 0; r < gridSize; r++) {
					for (int c = 0; c < gridSize; c++) {
						
						if (grid[r][c].equals(player)) {
							grid[r][c-1] = player;
							grid[r][c] = " ";
							if (h == r) 
								grid[r+1][c] = player;
						}
					}
					
				}
				} catch (Exception e ) {
					System.out.println("Invalid Move");
				}finally {
				break;
				}
		case "s": 
			try {
				for (int r = 0; r < gridSize; r++) {
					for (int c = 0; c < gridSize; c++) { 
						
						if (grid[r][c].equals(player) && !(grid[r+1][c].equals("-"))) {
							grid[r+1][c] = player;
							grid[r][c] = " ";
							h = r;				
					}
						}
					
				}
				} catch (Exception e ) {
					System.out.println("Invalid Move");
				}finally {
				break;
				}
		case "d": 
			try {
				for (int r = 0; r < gridSize; r++) {
					for (int c = 0; c < gridSize; c++) {
						
						if (grid[r][c].equals(player)) {
							grid[r][c+1] = player;
							grid[r][c] = " ";
							if (h == r)
								grid[r+1][c] = player;
							
						}
					}
					
				}
				} catch (Exception e ) {
					System.out.println("Invalid Move");
				}finally {
				break;
				}
		} // Switch end 


		count++;
		if (count == 10) //Prototype game end
			inGame = false;
		} //While loop end
		System.out.println("Game over!");
}
}
