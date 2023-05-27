package maintainingAnInventory;

import java.io.*;
import java.util.*;


//copy delivery titles from a txt file and add them to the inventory list
public class DeliveryMenu {
	
	public static void delivery(String key, char keyChar, int i, String title, LinkedList<String> movieTitle, int dupe) throws IOException {
		try {
			System.out.println("\n\t[DELIVERY MENU]");
			File dlv = new File("/Users/jorge/Desktop/Delivery Information.txt");
			Scanner scnr = new Scanner(dlv);
			
			while(scnr.hasNextLine()) {
				title = scnr.nextLine().toUpperCase();
				scnr.nextLine();
				movieTitle.add(title);	
			}
			
			System.out.println("Delivery titles have been succesfully added.");
			System.out.println("Now redirecting to the [System Menu]");
			MainSystemMenu.commands(key, keyChar, i, title, movieTitle, dupe);
			
		}
		catch (FileNotFoundException e) {
			System.out.println("FileNotFoundException: Delivery file was not found.");
		}
		
		
	}

}
