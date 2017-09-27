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
		return this.firstName;
	}

	@Override
	public String getLastName() {
		// TODO Auto-generated method stub
		return this.lastName;
	}

	@Override
	public boolean mathces(String first, String last) {
		// TODO Auto-generated method stub
		return first == firstName && last == lastName;
	}

	@Override
	public boolean matches(String last) {
		// TODO Auto-generated method stub
		return last == lastName;
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
				theResult += "PRESENT";
				return theResult;
				}

		}
		theResult += "ABSENT";
		return theResult;
	}

}
