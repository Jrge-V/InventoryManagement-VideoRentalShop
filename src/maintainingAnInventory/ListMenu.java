package maintainingAnInventory;
import java.io.*;
import java.util.*;

public class ListMenu {
	static Scanner scnr = new Scanner(System.in);
	//sorts in alphabetical order
	public static void sort(String key, char keyChar, int i, String title, LinkedList<String> movieTitle) throws IOException {
		System.out.println("\n\t[LIST MENU]");
		int j = 0;
		if (movieTitle.size() == 0) {
			System.out.println("No movies have been added, please add a movie to view the list.");
			System.out.println("Now redirecting to the [SYSTEM MENU].");
			MainSystemMenu.commands(key, keyChar, i, title, movieTitle, j);
		}
		else {
			Collections.sort(movieTitle);
			System.out.println("Now displaying movie list: ");
			for (j = 0; j < movieTitle.size(); ++j) {
				System.out.println((j+1) + ". " + movieTitle.get(j));
			}
			System.out.println("(End of list)\n");
			System.out.print("Press \"Y\" to view inventory information for a specified title.\nElse input \"B\" to go back: ");
			i = 0;
			while(i!=1) {
				key = scnr.next().toUpperCase();
				keyChar = key.charAt(0);
				scnr.nextLine(); //flush buffer
				if (keyChar == 'B') {
					++i;
					System.out.println("Now redirecting to the [SYSTEM MENU].");
					i = 0;
					MainSystemMenu.commands(key, keyChar, i, title, movieTitle, j);
				}
				else if (keyChar == 'Y') {
					++i;
					System.out.println("Now redirecting to the [INQUIRE MENU]");
					InquireMenu.inquire(key, keyChar, i, title, movieTitle, j);
				}
				else {
					System.out.println("Invalid key, please try again.");
				}
			}
			
		}
		
		
	}

	
}