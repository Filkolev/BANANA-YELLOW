import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Drawings {
	
	public static void PrintMan(int livesLeft){		
		if (livesLeft == 6) {
			System.out.println("________________________");
			System.out.println("|   ____________________|");
			System.out.println("|   |             |");
			System.out.println("|   |             |");
			System.out.println("|   |");
			System.out.println("|   |");
			System.out.println("|   |");
			System.out.println("|   |");
			System.out.println("|   |");
			System.out.println("|   |");
			System.out.println("|   |");
			System.out.println("|   |");
			System.out.println("|   |");
			System.out.println("|   |");
			System.out.println("|   |");
			System.out.println("|   |");
			System.out.println("|   |");
			System.out.println("|   |");
			System.out.println("|   |");
			System.out.println("|___|");
			System.out.println();
		} else if (livesLeft == 5) {
			System.out.println("________________________");
			System.out.println("|   ____________________|");
			System.out.println("|   |             |");
			System.out.println("|   |             |");
			System.out.println("|   |           *****");
			System.out.println("|   |         ***   ***");
			System.out.println("|   |         ***   ***");
			System.out.println("|   |           *****");
			System.out.println("|   |");
			System.out.println("|   |");
			System.out.println("|   |");
			System.out.println("|   |");
			System.out.println("|   |");
			System.out.println("|   |");
			System.out.println("|   |");
			System.out.println("|   |");
			System.out.println("|   |");
			System.out.println("|   |");
			System.out.println("|   |");
			System.out.println("|___|");
			System.out.println();
		} else if (livesLeft == 4) {
			System.out.println("________________________");
			System.out.println("|   ____________________|");
			System.out.println("|   |             |");
			System.out.println("|   |             |");
			System.out.println("|   |           *****");
			System.out.println("|   |         ***   ***");
			System.out.println("|   |         ***   ***");
			System.out.println("|   |           *****");
			System.out.println("|   |            |||");
			System.out.println("|   |            |||");
			System.out.println("|   |            |||");
			System.out.println("|   |            |||");
			System.out.println("|   |            |||");
			System.out.println("|   |");
			System.out.println("|   |");
			System.out.println("|   |");
			System.out.println("|   |");
			System.out.println("|   |");
			System.out.println("|   |");
			System.out.println("|___|");
			System.out.println();
		} else if (livesLeft == 3) {
			System.out.println("________________________");
			System.out.println("|   ____________________|");
			System.out.println("|   |             |");
			System.out.println("|   |             |");
			System.out.println("|   |           *****");
			System.out.println("|   |         ***   ***");
			System.out.println("|   |         ***   ***");
			System.out.println("|   |           *****");
			System.out.println("|   |          //|||");
			System.out.println("|   |         // |||");
			System.out.println("|   |        //  |||");
			System.out.println("|   |            |||");
			System.out.println("|   |            |||");
			System.out.println("|   |");
			System.out.println("|   |");
			System.out.println("|   |");
			System.out.println("|   |");
			System.out.println("|   |");
			System.out.println("|   |");
			System.out.println("|___|");
			System.out.println();
		} else if (livesLeft == 2) {
			System.out.println("________________________");
			System.out.println("|   ____________________|");
			System.out.println("|   |             |");
			System.out.println("|   |             |");
			System.out.println("|   |           *****");
			System.out.println("|   |         ***   ***");
			System.out.println("|   |         ***   ***");
			System.out.println("|   |           *****");
			System.out.println("|   |          //|||\\\\");
			System.out.println("|   |         // ||| \\\\");
			System.out.println("|   |        //  |||  \\\\");
			System.out.println("|   |            |||");
			System.out.println("|   |            |||");
			System.out.println("|   |");
			System.out.println("|   |");
			System.out.println("|   |");
			System.out.println("|   |");
			System.out.println("|   |");
			System.out.println("|   |");
			System.out.println("|___|");
			System.out.println();
		} else if (livesLeft == 1) {
			System.out.println("________________________");
			System.out.println("|   ____________________|");
			System.out.println("|   |             |");
			System.out.println("|   |             |");
			System.out.println("|   |           *****");
			System.out.println("|   |         ***   ***");
			System.out.println("|   |         ***   ***");
			System.out.println("|   |           *****");
			System.out.println("|   |          //|||\\\\");
			System.out.println("|   |         // ||| \\\\");
			System.out.println("|   |        //  |||  \\\\");
			System.out.println("|   |            |||");
			System.out.println("|   |            |||");
			System.out.println("|   |           //");
			System.out.println("|   |          //");
			System.out.println("|   |         //");
			System.out.println("|   |        //");
			System.out.println("|   |");
			System.out.println("|   |");
			System.out.println("|___|");
			System.out.println();
		} else if (livesLeft < 1) {
			System.out.println("________________________");
			System.out.println("|   ____________________|");
			System.out.println("|   |             |");
			System.out.println("|   |             |");
			System.out.println("|   |           *****");
			System.out.println("|   |         ***   ***");
			System.out.println("|   |         ***   ***");
			System.out.println("|   |           *****");
			System.out.println("|   |          //|||\\\\");
			System.out.println("|   |         // ||| \\\\");
			System.out.println("|   |        //  |||  \\\\");
			System.out.println("|   |            |||");
			System.out.println("|   |            |||");
			System.out.println("|   |           // \\\\");
			System.out.println("|   |          //   \\\\");
			System.out.println("|   |         //     \\\\");
			System.out.println("|   |        //       \\\\");
			System.out.println("|   |");
			System.out.println("|   |");
			System.out.println("|___|");
			System.out.println();
		}
	}
	
	public static void printSmiley() throws IOException {
		try {
			BufferedReader reader = new BufferedReader(new FileReader("Smiley.txt"));
			String line = reader.readLine();
			
			while (line != null) {
				System.out.println(line);
				line = reader.readLine();
			}
			
			System.out.println();
			System.out.println();
			System.out.println();
			
			reader.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}