package Pokemon;

public class Pokemon {

	int level;
	int hp;
	String name;
	boolean poisoned;
	public void setHP() {
		this.hp = hp;
	}
	
	public int getHP() {
		return hp;
	}
	public String getName() {
		return name;
	}
	public void setPoisoned(boolean poisoned) {
		this.poisoned = poisoned;
	}
	public Pokemon(String name, int level) {
		this.name = name;
		this.level = level;
		this.hp = 100;
		this.poisoned = false;
	}
	public void iChooseYou(){
		System.out.println(name);
		System.out.println(name);
	}

	public void lapse() {
		if(poisoned) {
			this.hp = this.hp-15;
		}
	}
	 public void attack(Pokemon target, Attack attack){
		 if(Math.random() < .9){
		 attack.attack(target);
		 System.out.println("The attack hit");
		 }else{
		 System.out.println("The attack missed");
		 }
		 }
	 public static void main(String[] args) {
		 Pokemon squirtle = new Pokemon("Squirtle",26);
		 Pokemon bulbasaur = new Pokemon("Bulbasaur",26);
		 squirtle.iChooseYou();
		 bulbasaur.iChooseYou();
		        }
		
		
	}


