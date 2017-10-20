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
	private String nick;
	public Person(String firstName, String lastName, Borough home){
		this.firstName =  firstName;
		this.lastName = lastName;
		this.home = home;
		//this.nick = createNickname(firstName);
		this.hobby = Hobby.randomHobby();
		this.friends = new Person[3];
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	// java is pass by value 
	// meaning the parameters of a method are just values not references
	//if you change those values, the orignal object is not effected
	//in this case, name will not be changed . in fact, nothing can change 
	//this.firstName via name\
	//if you change the reference you are changing the whole value
	public static String createNickname(String name) {
		String nick; 
		int secondVowel = findSecond(name);
		nick = name.substring(0,secondVowel);
		return nick;
	}
	
	private static int findSecond(String name) {
		int index = name.length();
		boolean secondfound = false;
		name = name.toLowerCase();
		for(int i = 0; i < name.length(); i++) {
			if(name.substring(i,i+1).equals("a") || name.substring(i,i+1).equals("e") || name.substring(i,i+1).equals("i") || name.substring(i,i+1).equals("o") || name.substring(i,i+1).equals("u")){
				secondfound = true;
				
			}
		if(!secondfound) {
			
			
		}	
		}
			
		return index;	
	}
	public void mingle(Person[] people) {
		for (Person p: people){
			if(p != this) {
				p = betterFriend(p,friends[0]);
				
				addFriendToFirstPlace(p);
			}
		}
	}
	public void printFriends() {
		System.out.println("My name is " + firstName + " " + lastName + " and these are all my friends:");
		for (Person f: friends) {
			if(f!= null) {
				System.out.println(f);
			}
		}
	}
	public void addFriendToFirstPlace(Person p) {
		for(int i =friends.length-1; i > 0;i--){
			friends[i] = friends[i-1];
		}
		friends[0] = p;
	}
	private Person betterFriend(Person p, Person q) {
		if(p == null) {
			return q;
		}
		if(q == null) {
			return p;
		}
		if(p.getClass() == q.getClass() && p.getClass() == this.getClass()) {
			if(p.hobby == this.hobby) {
				return p;
			}
			if(q.hobby == this.hobby) {
				return q;
			}
		}
		if(p.getClass() == this.getClass()) {
			return p;
		}
		if(q.getClass() == this.getClass()) {
			return q;
		}
		return q;
	}
	
	public String toString() {
		return "My name is " + firstName + " " + lastName + " and i live in " + home + ". I like " + hobby + ". ";
	}
}