public class PrintHanging {
	public static void main(String[] args) {
		
	}
	
	public static void PrintMan(int livesLeft){
		if (livesLeft == 6) {
			System.out.println("_____");
			System.out.println("|   |");
			System.out.println("|    ");
			System.out.println("|    ");
			System.out.println("|    ");
			System.out.println("|    ");
			System.out.println();
		}
		if (livesLeft == 5) {
			System.out.println("_____");
			System.out.println("|   |");
			System.out.println("|   O");
			System.out.println("|    ");
			System.out.println("|    ");
			System.out.println("|    ");
			System.out.println();
		}
		
		if (livesLeft == 4) {
			System.out.println("_____");
			System.out.println("|   |");
			System.out.println("|   O");
			System.out.println("|   | ");
			System.out.println("|    ");
			System.out.println("|    ");
			System.out.println();
		}
		
		if (livesLeft == 3) {
			System.out.println("_____");
			System.out.println("|   |");
			System.out.println("|   O");
			System.out.println("|  /| ");
			System.out.println("|    ");
			System.out.println("|    ");
			System.out.println();
		}
		
		if (livesLeft == 2) {
			System.out.println("_____");
			System.out.println("|   |");
			System.out.println("|   O");
			System.out.println("|  /|\\ ");
			System.out.println("|    ");
			System.out.println("|    ");
			System.out.println();
		}
		
		if (livesLeft == 1) {
		   System.out.println("_____");
		   System.out.println("|   |");
		   System.out.println("|   o");
		   System.out.println("|  /|\\ ");
		   System.out.println("|    \\");
		   System.out.println("|    ");
		   System.out.println();
		}
		
		if (livesLeft < 1) {
		   System.out.println("_____");
		   System.out.println("|   |");
		   System.out.println("|   o");
		   System.out.println("|  /|\\ ");
		   System.out.println("|  / \\");
		   System.out.println("|    ");
		   System.out.println();
		}
	}
}
