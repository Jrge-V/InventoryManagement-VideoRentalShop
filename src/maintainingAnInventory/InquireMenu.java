package maintainingAnInventory;
import java.io.*;
import java.util.*;

public class InquireMenu {
	static Scanner scnr = new Scanner(System.in);
	static LinkedList <String> copy = new LinkedList <String>();
	
	//checks info about a specific title
	public static void inquire(String key, char keyChar, int i, String title, LinkedList<String> movieTitle, int dupe) throws IOException {
		System.out.println("\n\t[INQUIRE MENU]");
		if (movieTitle.size() == 0) {
			System.out.println("No movies have been added, please add a movie to view the inventory information.");
			System.out.println("Now returning to the [SYSTEM MENU].");
			MainSystemMenu.commands(key, keyChar, i, title, movieTitle, dupe);
		}
		
		else {
			System.out.print("Enter a movie title to view inventory information: ");
			title = scnr.nextLine().toUpperCase();
			
			if (movieTitle.contains(title)) {
				for (i = 0; i < movieTitle.size(); ++i) {
					if(movieTitle.get(i).equals(title)) {
						copy.add(title);
					}
				}
				System.out.println("\nMovie Title: " + title);
				dupe = copy.size();
				copy.removeAll(copy);
				System.out.println("Have Value: " + dupe);
				
				
				System.out.print("\nInput \"Y\" to view information about another movie.\nElse input any other key to go back:");
				key = scnr.next().toUpperCase();
				keyChar = key.charAt(0);
				scnr.nextLine(); //flush buffer
				if (keyChar =='Y') {
					inquire(title, keyChar, i, title, movieTitle,dupe);
				}
				else {
					System.out.println("Now redirecting to the [System Menu]");
					i = 0;
					MainSystemMenu.commands(key, keyChar, i, title, movieTitle, dupe);
				}
			}
			
			else {
				System.out.println("Error, specified title not found.");
				System.out.println("Now redirecting to the [System Menu]");
				i = 0;
				MainSystemMenu.commands(key, keyChar, i, title, movieTitle, dupe);
			}
			
		}
	}
	
}