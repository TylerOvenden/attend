package arrays;

import java.util.Arrays;

public class ArraysMain {
	
	private String[] testArray;
	private int[] intRay;	

	public ArraysMain() {
		intRay = new int[100];
		//populate(intRay);
		//checkOccurences(intRay,3,18);
		populate1ToN(intRay);
		shuffle(intRay);
		System.out.println(Arrays.toString(intRay));
	} 
	
	private void shuffle(int[] arr) {
		// TODO Auto-generated method stub
		for (int i = 0; i < arr.length; i++ ) {
			swap(arr,(int) (Math.random()*arr.length), (int)(Math.random()*arr.length));
			
		}
	}

	private void swap(int[] arr, int i, int j) {
		int[] temp = {0,};
		temp[0] = arr[i];
		arr[i] = arr[j];
		arr[j] = temp[0];
		
	}

	private void populate1ToN(int[] arr) {
		for(int i = 0; i < arr.length; i++ ) {
			arr[i] = i + 1;
			
		}
		
	}

	private void checkOccurences(int[] arr, int start, int end) {
		int[] counter = new int[end-start+1];
		for(int value: arr) {
			counter[value-start]++;
		}
		for(int i = 0; i < counter.length; i++) {
			System.out.println("A " + (start+i)+ " was rolled " + counter[i]+ " times.");
			
		}
	}

	private void populate(int[] intRay) {
		for(int i = 0; i < intRay.length; i++) {
		intRay[i] = diceRoll(3);
		}
		//this does not work
		for(int value: intRay) {
		}
	}
	public void notes() {
		//1. collection of primitives or objects
		//Special note: this is the only collection of primitives
		//2. size cannot be modified
		//3. elements of an array are references to objects
		//changing an element of an array changes the reference, 
		//not the object(more on this later)
		//_______________________________
		
		//there are 2 types of contrustors, the first we've seen already:
		int[] firstType = {3,14,-9,10};
		//this constructor can only be used at the declaration. error:
		//firstType = {12,13,13,14};
		
		//2nd type
		testArray = new String[50];
		//special not: for primitive arrays when they are instantiated
		//they are automatically populated with 0s. this is not the case with 
		//object arrays, which are populated with nulls
		for(int i = 0; i < testArray.length; i++) {
			System.out.println("The #" + i + " item is" + testArray[i]);
			
		}
		//for each loop (useful only when you don't need to keep track of an index
		for(String value:testArray) {
			//"for each int in testArray..."
			System.out.println(value);
			
		}
		
	}
	public static void main(String[] args) {
		ArraysMain arrayPractice = new ArraysMain();
		
		// TODO Auto-generated method stub
	/**
	 * returns the result from rolling "numberOfDice" dice
	 */
	}
	public int diceRoll(int numberOfDice) {
		int roll = 0;
		
		for(int i = 0; i< numberOfDice; i++) {
			roll += 1+(int)(Math.random()*6);
			
		}
		return roll;
	}
}
