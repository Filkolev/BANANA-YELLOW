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

		while (playing) {			
			if (!entries.isEmpty()) {
				entries.clear();
			}
			
			VisualControls.initializeNewGame();
			String category = input.nextLine();			
			
			secretWords = Dictionaries.selection(category, secretWords);
			
			while (secretWords.size() > 0) {	
				String currentWord = pickWord(wordSelector).toUpperCase();
				char[] toGuess = currentWord.toCharArray();
				char[] guessed = new char[currentWord.length()];
				
				initializeGuessedWord(guessed);									

				VisualControls.refreshWindow(livesLeft, guessed, repeated, guessLetter, letterFound, false);

				while (!dead && !gameWon) {
					String userEntry = input.nextLine();
					while (userEntry.equals("")) {
						VisualControls.refreshWindow(livesLeft, guessed, repeated, guessLetter, letterFound, false);
						userEntry = input.nextLine();
					}
					guessLetter = userEntry.toUpperCase().charAt(0);
					checkGuess(toGuess, guessed);	
					dead = checkDead(currentWord, input, dead, guessed, gameWon);
					gameWon = checkWon(currentWord, input, dead, guessed, gameWon);

					if (dead || gameWon) {
						break;
					}

					letterFound = false;
				}
				
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

		VisualControls.endGame();
		input.nextLine();
	}

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

	private static void letterLookup(char[] toGuess, char[] guessed) {
		for (int i = 0; i < guessed.length; i++) {
			if (guessLetter == toGuess[i]) {
				guessed[i] = guessLetter;
				letterFound = true;										
			}			
		}
	}

	private static void initializeGuessedWord(char[] guessed) {
		for (int i = 0; i < guessed.length; i++) {
			guessed[i] = '*';
		}

		livesLeft = 6;
	}

	private static String pickWord(Random wordSelector) {
		int newWordIndex = wordSelector.nextInt(secretWords.size());
		String currentWord = secretWords.get(newWordIndex);
		secretWords.remove(newWordIndex);
		return currentWord;
	}

	private static boolean checkDead(String currentWord, Scanner input, boolean dead, char[] guessed, boolean gameWon) {
		if (livesLeft < 1) {	
			VisualControls.printDeath(currentWord);						
			return true;
		} return false;
	}

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