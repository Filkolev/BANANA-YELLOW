import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Hangman {
	public static int livesLeft;
	public static boolean letterFound = false;				
	public static int counterEntries = 0;
	public static LinkedHashSet<String> entries = new LinkedHashSet<String>();


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

			String currentWord = secretWords.get(index);
			secretWords.remove(index);

			char[] toGuess = currentWord.toCharArray();
			char[] guessed = new char[currentWord.length()];
			
			// add wrong letters array; show it on the console
			
			for (int i = 0; i < guessed.length; i++) {
				guessed[i] = '*';
			}
			
			livesLeft = 6;
			clearConsole(); 
			System.out.println("RULES:");
			System.out.println("1. Enter letters from the English alphabet in order to guess the word!");
			System.out.println("2. If you enter more than one letter, only the first one will matter.");
			System.out.println("3. Entering symbols or digits may get you killed!");
			System.out.println("4. You can make 6 wrong guesses, on the 6th you DIE!");
			System.out.println("\nReady? Press enter.");
			
			input.nextLine();
			
			// to fix - count repeated letters in the word, don't count letters that were already guessed before
			int totalLettersFound = 0;
			
			while (!dead || !gameWon) {
				RefreshWindow(livesLeft, guessed);
				System.out.print("Your guess: ");
				String userEntry = input.nextLine();
				counterEntries++;
				
				char guessLetter = userEntry.toUpperCase().charAt(0);

				for (int i = 0; i < guessed.length; i++) {
					if (guessLetter == toGuess[i]) {
						guessed[i] = guessLetter;
						letterFound = true;
						totalLettersFound++;						
					}			
				}
				// Clear console method
				clearConsole(); 
				
				if (counterEntries != 0) {
					if (!letterFound) {
						livesLeft--;
						System.out.println("Sorry! This letter isn't in the word!");
						System.out.println("Entered letters: " + entries);
					} else if (letterFound) {
						// check for duplicates
						if (entries.contains(userEntry)){
							System.out.println("This letter is already entered");
							System.out.println("Entered letters: " + entries);
							}
						
						else{
							System.out.println("Good guess! Keep going!");
							System.out.println("Entered letters: " + entries);
							letterFound = false;
						}
					}
					entries.add(userEntry);
				}

				int starsLeft = 0; 
				
				if (livesLeft < 1) {
					RefreshWindow(livesLeft, guessed);
					dead = true;
					System.out.println("Sometimes win, sometimes lyun!");
					System.out.println("The word was: " + currentWord);
					System.out.println("Press enter to play again.");
					input.nextLine();
					break;
				}
				else
					// count the stars
					for (int i = 0; i < guessed.length; i++) {			
						 char letter = guessed[i];
						 if (letter=='*')
							 starsLeft++;
					}
						 if (starsLeft == 0){
					gameWon = true;
					for(int clear = 0; clear < 1000; clear++){
					     System.out.println("\b") ;
					} 
					System.out.println("YOU WIN !!!");
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
		
		PrintHanging.PrintMan(livesLeft);

		System.out.println("You have " + livesLeft + " lives left!");

		System.out.printf("%n%n%s%n", new String(guessed));
		
	}

	private static void clearConsole() {
		for(int clear = 0; clear < 50; clear++){
		     System.out.println("\b") ;
		}
	}
}
