package arrays;

public class ObjectArrays {

	public ObjectArrays(){
		Person[] people = new Person[20];
		populate(people);
	//	people[0] = new Thing("coffe maker");
		
		System.out.println(p);
	}
		Person[] group = selectGroup(people, 4);
		// System.out.println(ArraysMain.toString(group));
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
	/*return the number of differences between the two arrays
	 * a difference means that don't have the same element 
	 * at the same position
	 */
	public int countDifferences (Person [] arr1, Person[] arr2) {
		int diff = 0;
		for(int i = 0; i<arr1.length; i++) {
			for(int j = 0; j<arr2.length; j++) {
				if (arr1[i].getClass() != arr2[j].getClass())
					diff++;
				if(arr1[i].hobby != arr2[j].hobby) {
					diff++;
				}
			}
			
		}
		return diff;
	}

	public Person[] selectGroup (Person[] populate, int length) {
		Person[] group = new Person[length];
		for (int i = 1; i < group.length; i++) {
		Person nextPerson = selectAPerson(populate);
		while(personInGroup(group, nextPerson)) {
		
			nextPerson = selectAPerson(populate);
		}
			group[i] = nextPerson;
	}
		return group;
}
	
	private boolean personInGroup(Person[] group, Person nextPerson) {
		for (int i = 1; i < group.length; i++) {
			if(group[i] == nextPerson) {
				return true;
			}
		}
		return false;
	}

	private Person selectAPerson(Person[] populate) {
		int randomNum = (int)(Math.random()*populate.length);
		return populate[randomNum];
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
