package arrays;

public class ObjectArrays {

	public ObjectArrays(){
		Object[] people = new Person[20];
		populate(people);
		people[0] = new Thing("coffe maker");
		for(Object p: people)
		System.out.println(p);
	}

	private void populate(Object[] people) {
		for(int i = 0; i < people.length; i++) {
			String firstName = randomNameFrom(Person.FIRST_START, Person.FIRST_MIDDLE, Person.FIRST_END);
			String lastName = randomNameFrom(Person.LAST_START, Person.LAST_MIDDLE, Person.LAST_END);
			Borough b = randomBorough();
			//Big idea
			//object arrays (not primitive arrays int [] double [])
			//allow you to have multiple data types
			if(Math.random() < .6) {
			int grade = (int)(Math.random()* 5)+9;
			people[i] = new Student(firstName, lastName, b, grade);
				
			}else
			people[i] = new Person(firstName, lastName, b);
		}
		
	}

	private Borough randomBorough() {
		// TODO Auto-generated method stub
		return Borough.NY_BOROUGHS[(int)(Math.random()*Borough.NY_BOROUGHS.length)];
	}

	private String randomNameFrom(String[] a, String[] b, String[] c) {
		// TODO Auto-generated method stub
		return get(a)+get(b)+get(c);
	}

	private String get(String[] a) {
		// TODO Auto-generated method stub
		return a[(int)(Math.random()*a.length)];
	}
}
