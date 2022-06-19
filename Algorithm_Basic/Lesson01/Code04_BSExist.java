package Lesson01;
import java.util.Arrays;

public class Code04_BSExist {

	// 1. exist
	public static boolean exist(int[] arr, int num) {
		if(arr == null || arr.length == 0) {
			return false;
		}
		int left = 0;
		int right = arr.length - 1;
		while(left <= right) {
		//	int mid = left + ((right - left) >> 1);
			int mid = left + ((right - left) >> 1);
			if(arr[mid] == num) {
				return true;
			}else if (arr[mid] < num) {
				left = mid + 1;
			}else {
				right = mid - 1;
			}
		}
		return false;
	}
	
	// 2.  ¶ÔÊýÆ÷
	// 2.1 generateRandomArray
	public static int[] generateRandomArray(int maxSize, int maxValue) {
		int[] arr= new int[(int)(Math.random() * (maxSize + 1))];
		for(int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random() * (maxValue + 1)) - (int)(Math.random() * (maxValue));
		}
		return arr;
	}
	
	// 2.2 test
	public static boolean test(int[] arr, int num) {
		for(int cur :arr ) {
			if(cur == num) {
				return true; 
			}
		}
		return false;
	}
	
	
     // 2.3 main
	public static void main(String[] args) {
		int testTimes = 100000;
		int maxSize = 100;
		int maxValue = 100;
		boolean succeed = true;
		for(int i = 0; i < testTimes; i++) {
			int[] arr = generateRandomArray(maxSize, maxValue);
			Arrays.sort(arr);
			int num = (int)(Math.random() * (maxValue + 1)) - (int)(Math.random() * maxValue);
			if(test(arr, num) != exist(arr, num)) {
				succeed = false;
				break;
			}
		}
		System.out.println(succeed ? "nice" : "bad");
	}

}













