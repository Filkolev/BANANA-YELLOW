
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


// Holds all lists of words for the user to choose from
public class Dictionaries {
	public static String selectedCateg;
	
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
			"KABUL", "MINSK", "OTTAWA", "PRAGUE", "CAIRO", "DUBLIN", "TOKYO", "ROME", 
			"MONACO", "OSLO", "BRATISLAVA", "SINGAPORE", "BERN", "BANGKOK", "TAIPEI", 
			"ANKARA", "WASHINGTON", "BUCHAREST", "LISBON", "AMSTERDAM", "LUXEMBOURG", 
			"SKOPJE", "TRIPOLI", "JERUSALEM", "COPENHAGEN", "ZAGREB", "BEIJING", "VIENNA"));		
	
	public static List<String> fruitsAndVegetables = new LinkedList<String>(Arrays.asList(
			"BANNANA", "APPLE", "ORANGE", "ONION", "POTATO", "CABBAGE", "PEAR", "STRAWBERRY", 
			"APRICOT", "AUBERGINE", "AVOCADO", "BROCCOLI", "CARROT", "CHERRY", "GARLIC", 
			"GRAPE", "MELON", "WATERMELON", "KIWI", "LEMON", "MANGO", "ORANGE", "PEA", "PEANUT", 
			"PEPPER", "PINEAPPLE", "TOMATTO", "PLUM", "CUCUMBER"));
	
	// A method that returns the selected list so a word can be picked out of it
		public static List<String> selection(String select, List<String> secretWords){
	        String s = String.valueOf(select.toLowerCase());
	        if (s.equals("demo") || s.equals("1")) {
	            secretWords = demo;
	            selectedCateg = "DEMO";
	            Game.validCategory = true;
	        } else if (s.equals("animals") || s.equals("2")) {
	            secretWords = animals;
	            selectedCateg = "ANIMALS";
	            Game.validCategory = true;
	        } else if (s.equals("capitals") || s.equals("3")) {
	            secretWords = capitals;
	            selectedCateg = "CAPITALS";
	            Game.validCategory = true;
	        } else if (s.equals("fruits and vegetables") || s.equals("4")){
	            secretWords = fruitsAndVegetables;
	            selectedCateg = "FRUITS AND VEGETABLES";
	            Game.validCategory = true;
	        }
	        else {
	            Game.validCategory = false;
	        }
			return secretWords;
		}	
}
