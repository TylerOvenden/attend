package arrays;

public class Student extends Person {
	public static final String [] grades = {"Freshman", "Sophomore", "Junior", "Senior", "Super Senior"};
	
	private String grade;
	public Student (String first, String last, Borough home, int gradeLevel) {
		super(first, last, home); //super constructor is first becuase a person must exist before a student can exist
		int index = gradeLevel-9;
		this.grade = grades[index];
	}

	public String toString() {
		
 		return super.toString()+" I am also a "+ grade+ ".";
	}

}
