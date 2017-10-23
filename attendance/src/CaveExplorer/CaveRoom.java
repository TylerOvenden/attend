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
		return description;
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

}
