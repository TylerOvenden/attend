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
	
	public Person(String first, String last, Borough home) {
		this.firstName = first;
		this.lastName = last;
		this.home = home;
	}
	
	
	public String toString() {
		return "My namea "+firstName+" "+lastName+" and I live in "+home+".";
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
