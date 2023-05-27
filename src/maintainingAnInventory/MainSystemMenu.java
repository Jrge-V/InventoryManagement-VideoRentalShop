package maintainingAnInventory;
import java.io.*;
import java.util.*;

public class MainSystemMenu {

	static Scanner scnr = new Scanner(System.in);
	static LinkedList <String> movieTitle = new LinkedList <String>();

	public static void main(String[] args) throws IOException {
		
		String key = null, title = null;
		char keyChar = 0;
		int i = 0;
		int dupe = 0;
		
		commands(key, keyChar, i, title, movieTitle,dupe);
		
	}
		//main menu, everything gets ran through here
		public static void commands(String key, char keyChar, int i, String title, LinkedList<String> movieTitle, int dupe) throws IOException {
			while (i!=1) {
				i = 0;
				System.out.println("\n\t[SYSTEM MENU]");
				
				System.out.println("H (help)\nI (inquire)\nL (list)\nA (add)\nM"
						+ " (modify)\nD (delivery)\nO (order)\nR (return)\nS (sell)\nQ (quit)");
				System.out.print("Input a Key: ");
				
				key = scnr.next().toUpperCase();
				keyChar = key.charAt(0);
				//help menu
				if (keyChar == 'H') {
					help(key, keyChar, i, title);
					++i;
					
				}
				//inquire menu
				else if (keyChar == 'I') {
					InquireMenu.inquire(key, keyChar, i, title, movieTitle,dupe);
					++i;
					
				}
				//list menu
				else if (keyChar == 'L') {
					ListMenu.sort(key, keyChar, i, title, movieTitle);
					i = 1;
					
				}
				//add menu
				else if (keyChar == 'A') {
					AddMenu.addTitle(key, keyChar, i, movieTitle, title,dupe);
					++i;
					
				}
				//modify menu
				else if (keyChar == 'M') {
					ModifyAndOrderMenu.mod(key, keyChar, i, movieTitle, title,dupe);
					++i;
					
				}
				//delivery menu
				else if (keyChar == 'D') {
					DeliveryMenu.delivery(key, keyChar, i, title, movieTitle,dupe);
					++i;
					
				}
				//order menu
				else if (keyChar == 'O') {
					ModifyAndOrderMenu.order(key, keyChar, i, movieTitle, title,dupe);
					++i;
					
				}
				//return menu
				else if (keyChar == 'R') {
					ReturnAndSellMenu.ret(key, keyChar, i, title, movieTitle);
					++i;
					
				}
				//sell menu
				else if (keyChar == 'S') {
					ReturnAndSellMenu.sell(key, keyChar, i, title, movieTitle);
					++i;
					
				}
				//quit menu
				else if (keyChar == 'Q') {
					quitAndSave(key, keyChar, i, title, movieTitle,dupe);
					++i;
					
				}
				//else input doesn't match either menu, allows user to input again
				else {
					System.out.println("Invalid key, please try again");
					
				}
				
			}
		}
		//more detail about each menu
		public static void help(String key, char keyChar, int i, String title) throws IOException {
			while(i != 1) {
				System.out.println("\n\t[HELP MENU]");
				System.out.println("I (inquire): Display the inventory information for a specified title.");
				System.out.println("L (list): List the entire inventory.");
				System.out.println("A (add): Add a new title to the inventory.");
				System.out.println("M (modify): Modify the want value for a specified title.");
				System.out.println("D (delivery): Take delivery of a shipment of DVDs.");
				System.out.println("O (order): Write a purchase order for additional DVDs.");
				System.out.println("R (return): Write a return order.");
				System.out.println("S (sell): Decrease the count for the specified title by 1.");
				System.out.print("PRESS \"B\" to go back: ");
				
				key = scnr.next().toUpperCase();
				keyChar = key.charAt(0); 
				
				if (keyChar == 'B') {
					commands(key, keyChar, i, title, movieTitle, i);
					++i;
				}
				else {
					System.out.println("Invalid key, please try again");
				}
				
			}
		}
		//quits the program and saves all inventory on to file
		public static void quitAndSave(String key, char keyChar, int i, String title, LinkedList<String> movieTitle, int dupe) throws IOException {
			System.out.println("\nSaving Inventory...");
			System.out.println("Program Terminated.");
			BufferedWriter saveInv = new BufferedWriter(new FileWriter(".\\SavedInventory.txt"));
			
			for (i = 0; i < movieTitle.size(); ++i) {
				saveInv.write(movieTitle.get(i) + "\n");
			}
			
			saveInv.close();
			i=1;
			
		}
}