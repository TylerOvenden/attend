package CaveExplorer;

public class NPC {
		//fields relating to navigation
		private CaveRoom[][] floor;//where the NPC roams
		private int currentRow;
		private int currentCol;
		private NPCRoom currentRoom;
		//fields releating to character
		private boolean active;
		private String activeDescription;
		private String inactiveDescription;
	
		//default constructor
		public NPC() {
			this.floor = CaveExplorer.caves;
			this.activeDescription = "There is a person waiting to talk to you";
			this.inactiveDescription = "The person you spoke to earlier is standing here.";
			//to indicate the NPC doesn't have a position yet, use coordinates -1, -1
			this.currentCol = -1;
			this.currentRow = -1;
			this.currentRoom = null;
			this.active = true;
		}
		/**
		 * Note: you can make custom constructors later that use different parameters
		 * ex: public NPC(String description, String inactiveDescription) 
		 * @return
		 */
		public boolean isActive() {
			// TODO Auto-generated method stub
			return false;
		}
		public void setPosition(int row, int col) {
			if(row >= 0 && row < floor.length && col >= 0 && col < floor[row].length && floor[row][col] instanceof NPCRoom) {
				//remove the npc from current room, keeps the map up to date
				//can't call a method on something that doesn't exist
				//nullpointerexception
				if(currentRoom != null) {
					currentRoom.leaveNPC();
				}
				currentRow = row;
				currentCol = col;
				currentRoom = (NPCRoom)floor[row][col];
				currentRoom.enterNPC(this);
			}
		}

		public void interact() {
			CaveExplorer.print("Hi! I'm a NPC!" + " I say nothing at all until you say 'bye'.");
			String s = CaveExplorer.in.nextLine();
			while(!s.equalsIgnoreCase("Bye")){
				CaveExplorer.print("...");
				s = CaveExplorer.in.nextLine();
			}
			CaveExplorer.print("my nama jeff");
			active = false;
		} 

		public String getInactiveDescription() {
			// TODO Auto-generated method stub
			return inactiveDescription;
		}

		public String getActiveDescription() {
			// TODO Auto-generated method stub
			return activeDescription;
		}
		public void act() {
			if(active) {
			int[] move = calculateMovement();
			int newRow = currentRow + move[0];
			int newCol = currentCol + move[1];
			setPosition(newRow, newCol);
			}
		}
		public int[] calculateMovement() {
			int[] moves = new int[2];
			int[][] possibleMoves = {{-1,0},{0,1},{1,0},{0,-1}};
			int rand = (int)(Math.random()*4);
			moves[0] = possibleMoves[rand][0]+currentRow;
			moves[1] = possibleMoves[rand][1]+currentCol;
			while()
			return null;
		}
}
