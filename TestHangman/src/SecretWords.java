import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SecretWords {
	public static List<String> demo(){
		List<String> secretWords = new LinkedList<String>(Arrays.asList("PURIFICATION", "SUBROUTINE", 
				"ELEPHANT", "EPITOME"));
		return secretWords;
	}
	
	public static List<String> animals(){
		List<String> secretWords = new LinkedList<String>(Arrays.asList("ELEPHANT",
				"DOG", "CAT", "TIGER", "LION", "SNAKE", "PANDA", "BEAR", "Rabbit",
				"KOALA", "DUCK", "SNAIL", "LEOPARD", "ZEBRA", "KANGOROO",
				"FALCON", "EAGLE", "MOUSE", "HORSE"));
		return secretWords;
	}
	
	public static List<String> capitals(){
		List<String> secretWords = new LinkedList<String>(Arrays.asList("SOFIA",
				"PARIS", "MADRID", "LONDON", "BEOGRADE", "MOSKOW", "ATHENS"));
		return secretWords;
	}
	
	public static List<String> fruitsAndVegetables(){
		List<String> secretWords = new LinkedList<String>(Arrays.asList("BANNANA",
				"APPLE", "ORANGE", "ONION", "POTATO", "CABBAGE", "PEAR", 
				"STRAWBERRY"));
		return secretWords;
	}	
}
