import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Game {

	private static int livesLeft;
	private static boolean letterFound = false;
	private static boolean repeated;
	private static char guessLetter;	
	public static LinkedHashSet<String> entries = new LinkedHashSet<String>();
	private static List<String> secretWords;
	private static boolean playing;

	public static void main(String[] args) {		
		Scanner input = new Scanner(System.in);
		Random wordSelector = new Random();
		playing = true;
		boolean dead = false;
		boolean gameWon = false;
		
		// Game continues until user exits or all categories are empty
		while (playing) {			
			if (!entries.isEmpty()) {
				entries.clear();
			}
			
			// Initial window showing rules of play and available categories
			VisualControls.initializeNewGame();
			String category = input.nextLine();			
			
			// Retrieve list of words in the selected categories
			secretWords = Dictionaries.selection(category, secretWords);
			
			// check if the category is empty, prompt user to choose another
			if (secretWords.size() == 0) {
				VisualControls.initializeNewGame();
				System.out.println("\nThe category you selected has no more words left. Please choose another!\n");
				category = input.nextLine();	
				secretWords = Dictionaries.selection(category, secretWords);
			}
			
			while (secretWords.size() > 0) {				
				// Random selector picks a word from the chosen category
				String currentWord = pickWord(wordSelector).toUpperCase();
				
				// Create arrays of chars of the word to guess and the word to be printed
				char[] toGuess = currentWord.toCharArray();
				char[] guessed = new char[currentWord.length()];				
				initializeGuessedWord(guessed);									
				
				// Prints gallows, list of letters already entered, the secret word with revealed letters so far and prompt for new entry
				VisualControls.refreshWindow(livesLeft, guessed, repeated, guessLetter, letterFound, false);

				// Main game loop - ask user to enter letters until he loses or wins
				while (!dead && !gameWon) {
					String userEntry = input.nextLine();
					
					// Loop to fix bug - game closes if user presses Enter
					while (userEntry.equals("")) {
						VisualControls.refreshWindow(livesLeft, guessed, repeated, guessLetter, letterFound, false);
						userEntry = input.nextLine();
					}
					
					guessLetter = userEntry.toUpperCase().charAt(0);
					
					// Check if the letter entered is in the secret word
					checkGuess(toGuess, guessed);
					
					// Check if the user is dead or victorious
					dead = checkDead(currentWord, input, dead, guessed, gameWon);
					gameWon = checkWon(currentWord, input, dead, guessed, gameWon);					
					if (dead || gameWon) {
						break;
					}

					// reset the boolean variable holding the result of the last entry
					letterFound = false;
				}
				
				// When current game ends prompt for a new game
				String choice = input.nextLine().trim().toLowerCase();
				if (choice.equals("y")) {
					dead = false;
					gameWon = false;
					break;
				} else {
					playing = false;
					break;
				}
			}
		}	

		// Prints a Thank-You message before exiting the game
		VisualControls.endGame();
		input.nextLine();
	}

	// Check if the user entered a wrong, correct, or repeated letter
	private static void checkGuess(char[] toGuess, char[] guessed) {
		if (entries.contains("" + guessLetter)) {					
			VisualControls.refreshWindow(livesLeft, guessed, true, guessLetter, letterFound, true);					
		} else {
			entries.add("" + guessLetter);
			letterLookup(toGuess, guessed);

			if (!letterFound) {
				livesLeft--;
			}

			VisualControls.refreshWindow(livesLeft, guessed, false, guessLetter, letterFound, true);
		}
	}

	// checks only if the letter is in the word or not; used by the previous methods
	private static void letterLookup(char[] toGuess, char[] guessed) {
		for (int i = 0; i < guessed.length; i++) {
			if (guessLetter == toGuess[i]) {
				guessed[i] = guessLetter;
				letterFound = true;										
			}			
		}
	}

	// Sets the word to be printed to stars, guessed letters will be revealed during gameplay
	private static void initializeGuessedWord(char[] guessed) {
		for (int i = 0; i < guessed.length; i++) {
			guessed[i] = '*';
		}

		livesLeft = 6;
	}

	// Picks a random word from the selected category and removes it from the list
	private static String pickWord(Random wordSelector) {
		int newWordIndex = wordSelector.nextInt(secretWords.size());
		String currentWord = secretWords.get(newWordIndex);
		secretWords.remove(newWordIndex);
		return currentWord;
	}

	// Checks if the player is dead
	private static boolean checkDead(String currentWord, Scanner input, boolean dead, char[] guessed, boolean gameWon) {
		if (livesLeft < 1) {	
			VisualControls.printDeath(currentWord);						
			return true;
		} return false;
	}

	// Checks for victory condition => no stars left means all letters have been revealed
	private static boolean checkWon(String currentWord, Scanner input, boolean dead, char[] guessed, boolean gameWon) {
		// count the stars
		int starsLeft = 0;
		for (char c : guessed) {
			if (c == '*') {
				starsLeft++;
			}
		}

		if (starsLeft == 0){

			VisualControls.printVictory();							
			return true;

		} else {
			return false;
		}
	}
}