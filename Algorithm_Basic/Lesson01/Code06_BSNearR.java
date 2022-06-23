package Lesson01;
import java.util.Arrays;
// 找出数组中<= num最右的位置

public class Code06_BSNearR {

	// 1. nearestIndex
	public static int nearestIndex(int[] arr, int num) {
		if(arr == null || arr.length <= 0) {
			return -1;
		}
		int index = -1;
		int L = 0;
		int R = arr.length - 1;
		while(L <= R) {
			int mid = (L + R) /2;
			if(arr[mid] <= num) {
				index = mid;
				L = mid + 1;
			}else {
				R = mid - 1;
			}	
		}
		return index;
		
	}
	
	// 2. ������
	// 2.1 generateRandomArray
	public static int[] generateRandomArray(int maxSize, int maxValue) {
		int[] arr = new int[(int)(Math.random() * (maxSize  + 1))];
		for(int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random() * (maxValue + 1)) - (int)(Math.random() * maxValue);
		}
		return arr;
	}
	
	// 2.2 test
	public static int test(int[] arr, int num) {
		if(arr == null || arr.length <= 0) {
			return -1;
		}
		for(int i = arr.length - 1; i >= 0; i--) {
			if(arr[i] <= num) {
				return i;
			}
		}
		return -1;
		
	}
	
	// printArray
	public static void printArray(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i] + " ");
		}
	}
		
	public static void main(String[] args) {
		int testTimes = 10000000;
		int maxSize = 10;
		int maxValue = 100;
		boolean succeed = true;
		for(int i = 0; i < testTimes; i++) {
			int[] arr = generateRandomArray(maxSize, maxValue);
			Arrays.sort(arr);
			int num = (int)(Math.random() * (maxValue + 1)) - (int)(Math.random() * maxValue);
			if(test(arr, num) != nearestIndex(arr, num)) {
				printArray(arr);
				System.out.println(num);
				System.out.println(test(arr, num));
				System.out.println(nearestIndex(arr, num));
				succeed = false;
		        break;
			}
		}
		System.out.println(succeed ? "nice!" :"Bad");
	}

}
