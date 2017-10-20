package arrays;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		ObjectArrays oA = new ObjectArrays();
		Person s = new Person ("Jeff", "Doge", Borough.NY_BOROUGHS[0]);
		int x = 10;
		int [] a = {5,6,7};
		test3(s,x,a);
		System.out.println(s+", "+x+", "+ Arrays.toString(a) );
	}
	// this does change the name
	//changes the array
	// arrays are collections of arrays
	public static void test(Person s, int x, int[] arr) {
		
		s.setFirstName("geoff");
		x = 5;
		arr = new int[3]; 
		arr[0] = 1;
		arr[1] = 2;
		arr[2] = 3;
	}
	public static void test3(Person s, int x, int[] arr) {
		
		s.setFirstName("geoff");
		x = 5;
		// arr = new int[3]; as long as you don't make a new array
		//the references themselves will change
		//no void method can permantly change an int
		//(you can if you can if you set it as a return type
		arr[0] = 1;
		arr[1] = 2;
		arr[2] = 3;
	}
}
