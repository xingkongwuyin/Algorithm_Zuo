package Lesson02;

public class Code02_EvenTimesOddTimes {

	// arr中，只有一种数出现奇数次
	public static void printOddTimesNum1(int[] arr) {
		int eor = 0;
		for(int i = 0; i < arr.length; i++) {
			eor ^= arr[i];
		}
		System.out.println(eor);
	}
	
	// arr中，有两种数，出现奇数次
	public static void printOddTimesNum2(int[] arr) {
		int eor = 0;
		for(int i = 0; i < arr.length; i++) {
			eor ^= arr[i];
		}
		
		int mostRightOne = eor & (-eor);
		int onlyOne = 0;
		for(int i = 0; i < arr.length; i++) {
			if((mostRightOne & arr[i]) != 0) {
				onlyOne ^= arr[i];
			}
		}
		System.out.println(eor + " " + (eor ^ onlyOne));		
	}
	
	
	
	public static void main(String[] args) {
		
	}

}
