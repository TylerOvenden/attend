package arrays;

public class Person {

	public static final String[] FIRST_START = {"T", "Chr", "Br", "Ph", "St", "L"};
	public static final String[] FIRST_MIDDLE = {"og", "ef", "im", "ist", "icha", "om"};
	public static final String[] FIRST_END = {"e", "er", "othy", "ian", "then", "", "f", "s", "el"};
	public static final String[] LAST_START = {"W", "L", "H", "J", "Br", "d", };
	public static final String[] LAST_MIDDLE = {"og", "ef", "im", "e", "us", "ic", "i"};
	public static final String[] LAST_END = {"", "er", "al", "er", "ma", "g", "s", "s", "el"};
	private String firstName;
	private String lastName;
	private Borough home;
	private Hobby hobby;
	private Person[] friends;
	
	public Person(String first, String last, Borough home) {
		this.firstName = first;
		this.lastName = last;
		this.home = home;
		this.hobby = Hobby.randomHobby();
		friends = new Person[3];
	}
	/*
	 * chooses friends from people based on who is of the same class
	 * as this instance and who has the same hobbies
	 */
	public void mingle(Person[] people) {
		for(Person p: people) {
			if(p != this)
				p = betterFriend(p, friends[0]);	
				
				addFriendToFirstPlace(p);
		}
		
	}
	private Person betterFriend(Person p, Person q) {
		if(p == null) {
			return q;
		}
		if(q == null) {
			return p;
		}
		if(p.getClass() == this.getClass() && q.getClass() == this.getClass()) {
			if(p.hobby == this.hobby) {
				return p;
			}
			else if(q.hobby == this.hobby) {
				return q;
			}
		}
		if(p.getClass() == this.getClass()) {
			return p;
		}
		if(q.getClass() == this.getClass()) {
			return q;
		}
		else
		return p;
	}
	public void printFriends() {
		System.out.println("My name is" + firstName + lastName + " and these are my friends:");
		
		for(Person f: friends) {
			if(f != null)
				
		}
	}
	/*
	 * moves all Person in friends back one index 
	 * as this instance and who has the same hobbies
	 */
	private void addFriendToFirstPlace(Person p) {
		for(int i = friends.length-1; i >0; i--) {
			friends[i] = friends[i=1];
			
		}
		friends[0] = p;
	}
	
	public String toString() {
		return "My namea "+firstName+" "+lastName+" and I live in "+home+" I like." + hobby;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
