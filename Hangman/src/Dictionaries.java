
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

// Holds all lists of words for the user to choose from
public class Dictionaries {
	
	public static List<String> demo = new LinkedList<String>(Arrays.asList(
			"PURIFICATION", "SUBROUTINE", "ELEPHANT", "EPITOME"));		
	
	public static List<String> animals = new LinkedList<String>(Arrays.asList(
			"ELEPHANT", "DOG", "CAT", "TIGER", "LION", "SNAKE", "PANDA", "BEAR", 
			"RABBIT", "KOALA", "DUCK", "SNAIL", "LEOPARD", "ZEBRA", "KANGOROO", 
			"FALCON", "EAGLE", "MOUSE", "HORSE", "BAT", "ANT", "BEAVER", "BEE", 
			"BUFFALO", "BULL", "CAMEL", "CHIMPANZEE", "CRAB", "COYOTE", "CROCODILE", 
			"CRAB", "DEOVE", "DONKEY", "FOX", "FROG", "GOAT", "GOOSE", "GORILLA",
			"PARROT", "PENGUIN", "RAT", "SCORPION", "SPIDER", "SQUIRREL", "SWAN", 
			"WHALE", "WOLF", "PIGEON", "PIG", "PEACOCK", "OWL", "OCTOPUS", "MOOSE", 
			"MOLE", "HIPPOPOTAMUS", "GRASSHOPPER", "GIRAFFE", "FLY"));
	
	public static List<String> capitals = new LinkedList<String>(Arrays.asList(
			"SOFIA", "PARIS", "MADRID", "LONDON", "BELGRADE", "MOSKOW", "ATHENS",
			"KABUL", "MINSK", "OTTAWA", "PRAGUE", "CAIRO", "DUBLIN", "TOKYO", "ROME", "MONACO",
			"OSLO", "BRATISLAVA", "SINGAPORE", "BERN", "BANGKOK", "TAIPEI", "ANKARA", "WASHINGTON",
			"BUCHAREST", "LISBON", "AMSTERDAM", "LUXEMBOURG", "SKOPJE", "TRIPOLI", "JERUSALEM", "COPENHAGEN",
			"ZAGREB", "BEIJING", "VIENNA"));		
	
	public static List<String> fruitsAndVegetables = new LinkedList<String>(Arrays.asList(
			"BANNANA", "APPLE", "ORANGE", "ONION", "POTATO", "CABBAGE", "PEAR", "STRAWBERRY"));
	
	// A method that returns the selected list so a word can be picked out of it
	public static List<String> selection(String select, List<String> secretWords){
		switch (String.valueOf(select.toLowerCase())) {
		case "demo":
		case "1": secretWords = demo;		
			break;
		case "animals":
		case "2": secretWords = animals;	
			break;
		case "capitals":
		case "3": secretWords = capitals;	
			break;
		case "fruitsAndVegetables":
		case "4": secretWords = fruitsAndVegetables;	
			break;
		default: secretWords = demo;
			break;
		}
		return secretWords;
	}	
}

