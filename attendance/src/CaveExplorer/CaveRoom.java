package CaveExplorer;

public class CaveRoom {

	private String description; //tells what the room looks like
	private String directions;//tells you what to do
	private String contents;//a symbol representing what's in the room
	private String defaultContents;//
	private CaveRoom[] borderingRooms;//
	private Door[] doors;//
	//rooms organized by direction 
	//room to north index 0, east 1, none null
	
	public static final int NORTH = 0;
	public static final int EAST = 1;
	public static final int SOUTH = 2;
	public static final int WEST = 3;
	
	
	public String getDescription() {
		return description + "/n" + directions;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public void setDefaultContents(String defaultContents) {
		this.defaultContents = defaultContents;
	}

	
	public CaveRoom(String description) {
		this.description = description;
		setDefaultContents(" ");
		contents = defaultContents;
		//difference between defaultContents and contents is "contents" becomes an X when 
		//you're inside a room, when you leave, it goes back to defaultContents
		
		//note: by default, arrays will populate with null, meaning there are no connections
		borderingRooms = new CaveRoom[4];
		doors = new Door[4];
		setDirections();
	}
	/**
	 * for every door in doors[] appends a string to directions describing the access
	 * ex: "there is a door to the north"
	 * if there are no doors at all, directions should say:
	 * there are no doors, you are trapped in here
	 */

	private void setDirections() {
		directions = "";
		boolean doorFound = false;
		for(int i = 0; i<doors.length;i++) {
			if(doors[i] != null) {
				doorFound = true;
				directions += "\n There is a "+doors[i].getDescription() + " to " + 
				toDirection(i)+ ". "+doors[i].getDetails();
			}
			if(!doorFound) {
				directions += "There is a no way out. You're trapped in here";
				
			}
		}
		
	}
	public void enter() {
		contents = "X";
	}
	public void leave() {
		contents = defaultContents;
		
	}
	/**
	 * Gives this room access to anotherRoom (and vice-versa)
	 * and sets a door between them, updating the directions
	 * @param direction
	 * @param anotherRoom
	 * @param door
	 */
	public void setConnection(int direction, CaveRoom anotherRoom, Door door) {
		
		addRoom(direction, anotherRoom,door);
		anotherRoom.addRoom(oppositeDirection(direction), this, door);
	}
	
	public static int oppositeDirection(int direction) {
		// TODO Auto-generated method stub
		return (direction+2)%4;
	}

	private void addRoom(int direction, CaveRoom cave, Door door) {
		borderingRooms[direction] = cave;
		doors[direction] = door;
		setDirections();
	}
	public void interpretInput(String input) {
		while(!isValid(input)) {
			System.out.println("You can only enter 'w', 'a', 's' or 'd'");
			input = CaveExplorer.in.nextLine();
		}
		int direction = 0;
		String dirs = "wdsa";
		goToRoom(dirs.indexOf(input));
	}

	private boolean isValid(String input) {
		String validEntries = "wdsa";
	//System.out.println("Checking for input " +input+ ", got index" + );
		return validEntries.indexOf(input) > -1 && input.length() == 1;
	}

	private void goToRoom(int direction) {
		//first, protect against null pointer exception
		//user cannot go through non-existent door 
		if(borderingRooms[direction] != null && doors[direction] != null) {
			CaveExplorer.currentRoom.leave();
			CaveExplorer.currentRoom = borderingRooms[direction];
			CaveExplorer.currentRoom.enter();
			CaveExplorer.inventory.updateMap();
		}
		
	}
	/*
	 * this will be where your group sets up all the caves 
	 * and all the connections
	 */
	public static void setUpCave() {
		//all of this code can be changed
		//1. decide how big your cave should be 
		CaveExplorer.caves = new CaveRoom[5][5];
		//2. populate with caves and a default description
		for(int row = 0; row < CaveExplorer.caves.length; row++) {
			for(int col = 0; col < CaveExplorer.caves[row].length; col++ ) {
				//create a default caves 
				CaveExplorer.caves[row][col] = new CaveRoom("This cave has coords ("+row+","+col+")");
				
			}
		}
		//3. replace defualt rooms with custom rooms
		// will do this later
		
		//4. set your starting room:
		CaveExplorer.currentRoom = CaveExplorer.caves[0][1];
		CaveExplorer.currentRoom.enter();
		//5. set up doors 
		CaveRoom[][] c = CaveExplorer.caves;
		c[0][1].setConnection(SOUTH, c[1][1], new Door());
		
		
	}

	/** 
	 * converts an int to a direction 
	 * toDirection(0) -> "the north"
	 * @param dir
	 * @return
	 */
	private static String toDirection(int dir) {
		String[] arr= {"the north", "the east", "the south", "the west"};
		return arr[dir];
	}

	public static void setUpCaves() {
		// TODO Auto-generated method stub
		
	}

	public Door getDoor(int direction) {
		return doors[direction];
	}

}
