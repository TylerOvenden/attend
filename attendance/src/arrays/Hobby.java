package arrays;

public class Hobby extends Thing {
	public Hobby(String description) {
		super(description);
	}
	public static Hobby randomHobby() {
		Hobby[] someHobbies = {new Hobby("programming"), new Hobby("dancing"), new Hobby("my name is jeff vines")};
		
		return someHobbies[(int)(Math.random()*someHobbies.length)];
	}
}
