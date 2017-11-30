package search;

public class LionsPuzzle {
	public static void main(String[] args) {
		int lions = 0;
		System.out.println(lions + " lions decide to eat the sheep? "+ eatSheepOrNot(lions));
	}

	private static boolean eatSheepOrNot(int lions) {
		// TODO Auto-generated method stub
		if(lions == 1) {
			return true;
		}else {
			//you would eat the sheep knowing the other lions don't the eat the sheep
			return !eatSheepOrNot(lions-1);
		}	
	}
}
