package maintainingAnInventory;

import java.io.*;
import java.util.LinkedList;

//checks if want and have value are equivalent else orders more dvd's
public class ModifyAndOrderMenu {
	static int wantV = 3;
	public static void mod(String key, char keyChar, int i, LinkedList<String> movieTitle, String title, int dupe) throws IOException {
		System.out.println("\n\t[MODIFY MENU]");
		System.out.println("Store inventory can only hold 3 DVD's per title.");
		System.out.println("Therefore, want value for all DVD's is set to 3.");
		System.out.println("Now redirecting to [System Menu]");
		MainSystemMenu.commands(key, keyChar, i, title, movieTitle, dupe);
	}
	
	public static void order(String key, char keyChar, int i, LinkedList<String> movieTitle, String title, int dupe) throws IOException {
		System.out.println("\n\t[ORDER MENU]");
		 if (dupe < wantV) {
			 System.out.println("Have Value is less than Want value...\nNow ordering more Movies.");
			 AddMenu.addTitle(key, keyChar, i, movieTitle, title, dupe);
		 }
		 else {
			 System.out.println("Have and Want Values are the same.\nNow redirecting to [System Menu]");
			 MainSystemMenu.commands(key, keyChar, i, title, movieTitle, dupe);
			 
		 }
	}

}
