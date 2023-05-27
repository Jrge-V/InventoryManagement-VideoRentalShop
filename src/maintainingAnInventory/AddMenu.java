package maintainingAnInventory;
import java.io.*;
import java.util.*;

public class AddMenu {
	static Scanner scnr = new Scanner(System.in);
	
	
	//adds new title on to inventory
	public static void addTitle(String key, char keyChar, int i, LinkedList<String> movieTitle, String title, int dupe) throws IOException {
		int j;
		i = 0;
		System.out.println("\n\t[ADD MENU]");
		while(i < movieTitle.size()+1) {
			
				System.out.print("Input a movie title: ");
				title = scnr.nextLine().toUpperCase();
				movieTitle.add(title);
				System.out.println(title + " has been successfully added.");
				
				for (j = 0; j < 1; ++j) {
					System.out.print("\nPress \"Y\" if you would like to add another title.\nElse input \"B\" to go back: ");
					key = scnr.next().toUpperCase();
					keyChar = key.charAt(0);
					scnr.nextLine(); //flush buffer
					if (keyChar == 'B') {
						i = 1 + movieTitle.size();
						MainSystemMenu.commands(key, keyChar, i, title, movieTitle, dupe);
					}
					else if (keyChar == 'Y') {
						++i;
						
					}
					else {
						System.out.println("Invalid key, please try again.");
						--j;
					}
					
				}
			
		}
		
	}
	
	
}
