package arrays2d;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] test1 = {1,2,3};
		
		changeNeighbors(test1, 0);
	}
	/**
	increase the element in arr at index psn 
	and decreases the element at psn -1 and psn + 1
	if they exist
	another major idea
	it is the idea of avoiding an arrayindexofbounds exception
	you will set it on quizzes, tests and project rubrics
	so always be mindful
	*/
	public static void changeNeighbors(int [] arr, int psn) {
		if(arr.length>psn) {
			arr[psn]++;
			if(arr[psn]>0) {
				arr[psn-1]--;
			}
			if(arr[psn]+1 < arr.length) {
				arr[psn+1]--;
			}
			
		}
		
	}
}
