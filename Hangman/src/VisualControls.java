import java.io.IOException;

// Holds all methods that print text or graphics on the console with few exceptions
public class VisualControls {
	
	public static void refreshWindow(Integer livesLeft, char[] guessed, boolean repeated, char guessLetter, boolean letterGuessed, boolean gameStarted) {
		clearConsole();
		Drawings.PrintMan(livesLeft);
		if (gameStarted) {
			guessOutcome(letterGuessed, repeated);
		} else {
			System.out.println();
		}
			
		System.out.println("Entries" + Game.entries);
		System.out.println("Selected Category: " + Dictionaries.selectedCateg);
		System.out.println("Lives left: " + livesLeft + "!");
		printGuessWord(guessed);
		System.out.print("Your guess: ");
	}

	public static void clearConsole() {
		for(int clear = 0; clear < 150; clear++){
			System.out.println("\b") ;
		}
	}
	
	public static void printCategorySelection(){
		System.out.print("\nReady? ");		
		System.out.println("Choose a category (enter a number or the category name):\n1. Demo\n2. Animals\n"
				+ "3. Capitals\n4. Fruits and Vegetables\n");
	}
	
	public static void printRules(){
		System.out.println("RULES:");
		System.out.println("1. Enter letters from the English alphabet in order to guess the word!");
		System.out.println("2. If you enter more than one letter, only the first one will matter.");
		System.out.println("3. Entering symbols or digits may get you killed!");
		System.out.println("4. You can make 6 wrong guesses, on the 6th you DIE!");		
		System.out.println();
	}
	
	private static void printGuessWord(char[] guessed){
		System.out.println();
		System.out.println();
		for (char c : guessed) {
			System.out.printf("%s ", c);
		}
		System.out.println();
	}
	
	public static void printDeath(String currentWord) {
		clearConsole();
		Drawings.PrintMan(0);
		System.out.println("Sometimes win, sometimes lyun!");
		System.out.println("The word was: " + currentWord);	
		newGamePrompt();
	}
	
	public static void endGame() {
		clearConsole();

		try {
			Drawings.printThankYou();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("THANK YOU FOR PLAYING!");
		System.out.println("\nIf you ran out of words you can purchase more words for the DISCOUNTED price of JUST $0.99! Call your local representative now!");
		System.out.println();		
		System.out.println("Press any key to exit...");
	}
	
	public static void printVictory() {
		clearConsole();
		try {
			Drawings.printSmiley();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("YOU GUESSED THE WORD !!!");	
		newGamePrompt();
	}
	
	private static void guessOutcome(boolean letterGuessed, boolean repeated) {		
		if (repeated) {
			System.out.println("You already tried this one...");
		} else if (letterGuessed) {
			System.out.println("Good guess! Keep going!");
		} else {
			System.out.println("Sorry! This letter isn't in the word!");
		}
		
		System.out.println();		
	}
	
	private static void newGamePrompt(){
		System.out.print("Would you like to play again? (Y - yes; N - close game): ");
	}
	
	public static void initializeNewGame() throws IOException {
		VisualControls.clearConsole();
		Drawings.printHangman();
		VisualControls.printRules();
		VisualControls.printCategorySelection();		
	}
}