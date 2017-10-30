package CaveExplorer;

public class TwoDArrayPractice {

	public static void main(String[] args) {
		String[][] pic = new String[6][10];
		for(int row = 0; row < pic.length; row++) {
			for (int col = 0; col < pic[row].length; col++) {
				pic[row][col] =  "jeff ";
				
			}
		}
		drawHorizontalLine(pic,0);
		drawHorizontalLine(pic,2);
		drawHorizontalLine(pic,3);
		drawHorizontalLine(pic,4);
		drawVerticalLine(pic,5);
		drawBox(pic,3,2);
		print(pic);
	}
	/**
	box likes like this 
		___
		|*|
		|_|
	
	*/
	private static void drawBox(String[][] pic, int i, int j) {
		
		drawSlot(pic, i, j);
		drawSlot(pic, i+1, j);
		drawIfInBounds("_",pic,i+1,j);
		for(int col = j-1; col <= j+1; col++) {
			
			drawIfInBounds("_",pic,i-1,col);
		}
		pic[i][j] = "*";
	}
	private static void drawIfInBounds(String string, String[][] pic, int i, int j) {
			//always check row before column
			//
		if(i>=0 && i < pic.length && j >= 0 && j <pic[i].length ) {
			pic[i][j] = string;
			
		}
		
	}
	/**
	 * 
	 * a slot looks like this 
	 *  | | 
	 * 2 vertical lines with a space between them
	 * coordinates, i,j are the coordinates of the space 
	 * a slot is a vertical line in front of i,j and after i,j
	 * catch: no ArrayIndexOutOfBoundExpections
	 */
	private static void drawSlot(String[][] pic, int i, int j) {
		if(i >=0 && i <pic.length) {
		if(j > 0 && i>= 0) {
			pic[i][j-1] = "|";
		if(j < pic[i].length -1) {
			pic[i][j+1] = "|";
			}	
			
		}
	}
		
}
	
	private static void drawHorizontalLine(String[][] pic, int row) {
		for(int col = 0; col < pic[row].length; col++) {
			pic[row][col] = "-";
		}
		
	}
	private static void drawVerticalLine(String[][] pic, int col) {
		for(int row = 0; row < pic.length; row++) {
			pic[row][col] = "|";
		}
		
	}
	//
	//prints cpnte
	//
	//
	private static void print(String[][]pic) {
		String printed = "";
		for(int row = 0; row < pic.length; row++) {
			for (int col = 0; col < pic[row].length; col++) {
				printed += pic[row][col]+" ";
			}
			printed += "\n";
		}
		System.out.println(printed);
	}
}
