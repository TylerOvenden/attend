package attendance;

public class Student implements Attendee {
	private boolean isPres = false;
	private String firstName = "Tyler";
	private String lastName = "Ovenden";
	@Override
	public boolean isPresent() {
		return this.isPres;
	}

	public Student(String firstName , String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	@Override
	public void setPresent(boolean present) {
		// TODO Auto-generated method stub
		this.isPres = present;
	}

	@Override
	public String getFirstName() {
		// TODO Auto-generated method stub
		return firstName;
	}

	@Override
	public String getLastName() {
		// TODO Auto-generated method stub
		return lastName;
	}

	@Override
	public boolean mathces(String first, String last) {
		// TODO Auto-generated method stub
		return first.toLowerCase().equals(firstName.toLowerCase()) && last.toLowerCase().equals(lastName.toLowerCase());
	}

	@Override
	public boolean matches(String last) {
		// TODO Auto-generated method stub
		return last.toLowerCase().equals(lastName.toLowerCase());
	}

	@Override
	public String getReportString() {
		// TODO Auto-generated method stub
		String theResult = lastName;
		if (theResult.length() >20) {
			theResult = theResult.substring(0, 17) + "...";
			
		}
		else {
			while (theResult.length()<20)
			{
				theResult += " ";
				
			}
				theResult += firstName;
			while (theResult.length()<40)
			{
				theResult += " ";
			}
				if (this.isPres)
				{
				theResult += "PRESENT\n";
				return theResult;
				}

		}
		theResult += "ABSENT\n";
		return theResult;
	}

}
