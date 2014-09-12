// Version 0.02

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Hangman {
	public static void main(String[] args) {
		// Add difficulty levels - three separate lists of words; user will choose after each game;
		List<String> secretWords = new LinkedList<String>(Arrays.asList("PURIFICATION", "SUBROUTINE", "ELEPHANT", "EPITOME"));
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		Random selector = new Random();		

		boolean gameWon = false;
		boolean dead = false;

		while (secretWords.size() > 0) {
			
			int index = selector.nextInt(secretWords.size());
			int livesLeft = 10;

			String currentWord = secretWords.get(index);
			secretWords.remove(index);

			char[] toGuess = currentWord.toCharArray();
			char[] guessed = new char[currentWord.length()];
			
			// add wrong letters array; show it on the console
			
			for (int i = 0; i < guessed.length; i++) {
				guessed[i] = '*';
			}
			
			System.out.println("RULES:");
			System.out.println("1. Enter letters from the English alphabet in order to guess the word!");
			System.out.println("2. If you enter more than one letter, only the first one will matter.");
			System.out.println("3. Entering symbols or digits may get you killed!");
			System.out.println("4. You can make 9 wrong guesses, on the 10th you DIE!");
			System.out.println("\nReady? Press enter.");
			
			input.nextLine();
			
			
			
			// to fix - count repeated letters in the word, don't count letters that were already guessed before
			int totalLettersFound = 0;
			
			while (!dead || !gameWon) {
				RefreshWindow(livesLeft, guessed);
				String userEntry = input.nextLine();
				char guessLetter = userEntry.toUpperCase().charAt(0);
				boolean letterFound = false;				

				for (int i = 0; i < guessed.length; i++) {
					if (guessLetter == toGuess[i]) {
						guessed[i] = guessLetter;
						letterFound = true;
						totalLettersFound++;						
					}			
				}

				if (!letterFound) {
					System.out.println("Sorry! This letter isn't in the word!");
					System.out.println("Press enter to continue.");
					input.nextLine();
					livesLeft--;						
				}
				else {
					System.out.println("Good guess! Keep going!");
					System.out.println("Press enter to continue.");
					input.nextLine();
				}

				if (livesLeft < 0) {
					dead = true;
					System.out.println("Sometimes win, sometimes lyun!");
					System.out.println("The word was: " + currentWord);
					System.out.println("Press enter to play again.");
					input.nextLine();
					break;
				}
				else if (totalLettersFound == currentWord.length()) {
					gameWon = true;
					System.out.println("VIRTULATION!!!");
					System.out.println("Press enter to play again.");
					input.nextLine();
					break;
				}
			}
			
			
		}
		
		System.out.println("No more words left!");
		System.out.println("If you like the game, support the developers! Buy them beer!");

	}
	
	public static void RefreshWindow(Integer l, char[] guessed) {
		// Clear console
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("  __________");
		System.out.println(" |          |");
		System.out.println(" |          |");
		System.out.println(" |          |");
		System.out.println(" |          |");
		System.out.println(" |          |");
		
		
		System.out.printf("%n%n%s%n", new String(guessed));
		System.out.print("Your guess: ");
	}
}
