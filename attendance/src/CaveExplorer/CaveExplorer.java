package CaveExplorer;

import java.util.Scanner;
public class CaveExplorer {
	public static CaveRoom[][] caves;
	public static Scanner in;
	public static CaveRoom currentRoom;
	public static Inventory inventory;
	public static boolean playing = true;
	
	public static void main(String[] args) {
		in = new Scanner(System.in);
		CaveRoom.setUpCaves();
		
		inventory = new Inventory();
		startExploring();
	}

	private static void startExploring() {
		while(playing) {
			print(inventory.getDescription());
			print(currentRoom.getDescription());
			print("What would you lik to do");
			String input = in.nextLine();
			currentRoom.interpretInput(input);
		}
		
	}
	public static void print(String s) {
		System.out.println(s);
		
	}

}


