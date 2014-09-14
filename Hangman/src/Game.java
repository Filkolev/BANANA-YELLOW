import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Game {

	public static int livesLeft;
	public static boolean letterFound = false;
	public static boolean repeated;
	public static char guessLetter;	
	public static LinkedHashSet<String> entries = new LinkedHashSet<String>();
	public static List<String> secretWords;

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		while (true) {
			
			if (!entries.isEmpty()) {
				entries.clear();
			}
			// Add user choices; boolean variable to see whether the user is still playing
			secretWords = Dictionaries.demo;

			Scanner input = new Scanner(System.in);

			Random wordSelector = new Random();
			boolean gameWon = false;
			boolean dead = false;

			while (secretWords.size() > 0) {

				int index = wordSelector.nextInt(secretWords.size());
				String currentWord = secretWords.get(index);
				secretWords.remove(index);

				char[] toGuess = currentWord.toCharArray();
				char[] guessed = new char[currentWord.length()];
				
				if (!entries.isEmpty()) {
					entries.clear();
				}

				for (int i = 0; i < guessed.length; i++) {
					guessed[i] = '*';
				}

				livesLeft = 6;	
				VisualControls.clearConsole(); 
				VisualControls.printRules();
				input.nextLine();	

				VisualControls.refreshWindow(livesLeft, guessed, repeated, guessLetter, letterFound, false);

				while (!dead && !gameWon) {

					String userEntry = input.nextLine();				

					guessLetter = userEntry.toUpperCase().charAt(0);

					if (entries.contains("" + guessLetter)) {					
						VisualControls.refreshWindow(livesLeft, guessed, true, guessLetter, letterFound, true);					
					} else {
						entries.add("" + guessLetter);

						for (int i = 0; i < guessed.length; i++) {
							if (guessLetter == toGuess[i]) {
								guessed[i] = guessLetter;
								letterFound = true;										
							}			
						}

						if (!letterFound) {
							livesLeft--;
						}

						VisualControls.refreshWindow(livesLeft, guessed, false, guessLetter, letterFound, true);
					}				

					int starsLeft = 0; 

					if (livesLeft < 1) {					
						dead = true;
						VisualControls.printDeath(currentWord);						
						
						if (input.nextLine().trim().toLowerCase().equals("y")) {
							dead = false;
							break;
						} else {
							return;
						}
						
					} else {
						// count the stars
						for (char c : guessed) {
							if (c == '*') {
								starsLeft++;
							}
						}

						if (starsLeft == 0){
							gameWon = true;
							VisualControls.printVictory();							
							
							if (input.nextLine().trim().toLowerCase().equals("y")) {
								gameWon = false;
								break;
							} else {
								return;
							}
						}
					}

					letterFound = false;
				}
			}

			VisualControls.endGame();
			input.nextLine();
			break;
		}		
	}
}