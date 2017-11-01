package CaveExplorer;

public class NPCRoom extends CaveRoom {

	private NPC presentNPC;
	
	
	public NPCRoom(String description) {
		super(description);
		presentNPC = null;
		// TODO Auto-generated constructor stub
	}

	/**
		NPS can enter a room if no other npc is there
	
	**/
	public boolean canEnter() {
		return presentNPC == null;
	}
	public void enterNPC (NPC m) {
		presentNPC = m;
	}	
	public void leaveNPC() {
		presentNPC = null;
		
	}
	/**
	 * there is already a method like this but to me it is helpful
	 * to have this other way of referring to it, especially 
	 * if i decide to change the rules of canEnter
	 * @return
	 */
	public boolean containsNPC() {
		return presentNPC != null;
		
	}
	//above methods are new features to a caveRoom
	//methods below replace caveroom methods (override)
	public String validKeys() {
		return "wdsae";
	}
	public void printAllowedEntry() {
		System.out.println("You can only enter 'w', 'a', 's' or 'd' to move or" + " you can type 'e' to interact");
		
	}
	public void performAction(int direction) {
		// TODO Auto-generated method stub
		if(direction == 4) {
			if(containsNPC() && presentNPC.isActive()) {
				presentNPC.interact();
			}else {
				CaveExplorer.print("There is nothing to interact with. ");
			}
			
		} else {
			CaveExplorer.print("That key does nothing");
		}
	}
	public String getContents() {
		if(containsNPC() && presentNPC.isActive()) {
			return "M";
		}
		else {
			return super.getContents();
			
			}
		}	
	public String getDescription() {
		if(containsNPC() && !presentNPC.isActive()) {
			return super.getDescription() + "\n"+presentNPC.getInactiveDescription();
			}
		else {
			return super.getDescription() + "\n"+presentNPC.getActiveDescription();
			
		} 
		}
		
	}
