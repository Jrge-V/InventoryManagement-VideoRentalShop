package maintainingAnInventory;

import java.io.*;
import java.util.*;

//removes titles from the inventory by either returning them or selling them.
public class ReturnAndSellMenu {
	static Scanner scnr = new Scanner (System.in);
	
	public static void ret(String key, char keyChar, int i, String title, LinkedList<String> movieTitle) throws IOException {
		System.out.println("\n\t[RETURN MENU]");
		System.out.print("Type a movie title to return: ");
		title = scnr.nextLine().toUpperCase();
		if (movieTitle.contains(title)) {
			System.out.println(title + " has been returned.");
			movieTitle.remove(title);
			System.out.println("Now redirecting to the [SYSTEM MENU].");
			MainSystemMenu.commands(key, keyChar, i, title, movieTitle, i);
		}
		else {
			System.out.println("No title found.");
			System.out.println("Now redirecting to the [SYSTEM MENU].");
			MainSystemMenu.commands(key, keyChar, i, title, movieTitle, i);
		}
		
	}
	
	public static void sell(String key, char keyChar, int i, String title, LinkedList<String> movieTitle) throws IOException {
		System.out.println("\n\t[SELL MENU]");
		System.out.print("Title of sold movie: ");
		title = scnr.nextLine().toUpperCase();
		if (movieTitle.contains(title)) {
			System.out.println(title + " has been removed.");
			movieTitle.remove(title);
			System.out.println("Now redirecting to the [SYSTEM MENU].");
			MainSystemMenu.commands(key, keyChar, i, title, movieTitle, i);
		}
		else {
			System.out.println("No title found.");
			System.out.println("Now redirecting to the [SYSTEM MENU].");
			MainSystemMenu.commands(key, keyChar, i, title, movieTitle, i);
		}
	}

}
