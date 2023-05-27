import java.util.Scanner;

public class binarySearch {

	public static void main(String[] args) {
		
		System.out.println(bSearch());
		
	}
	
	public static int bSearch() {
		
		Scanner scnr = new Scanner(System.in);
	
		
		int[] arr = {1, 4, 7, 9, 10, 11, 14, 17, 18, 20};
		int num;
		int low = 0;
		int high = arr.length-1;
		int mid;
		
		System.out.println("Array contains 10 numbers between 1 - 20.");
		System.out.print("Choose a number to return its index, else returns -1: ");
		num = scnr.nextInt();
		
		
		while (low <= high) {
			
			mid = (low + high)/2;
			
			if (num < arr[mid]) {
				high = mid - 1;
			}
			else if (num > arr[mid]) {
				low = mid + 1;
			}
			else {
				return mid;
			}
				
		}
		return -1;
	}

}
