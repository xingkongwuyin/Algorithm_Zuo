package Lesson01;

// insertionSort
public class Code03_InsertionSort {
    
	// 1. insetionSort
	public static void insertionsSort(int[] arr) {
		if(arr == null || arr.length <=2) {
			return;
		}
		for(int i = 1; i < arr.length; i++) {
			for(int pre = i - 1; pre >= 0 && arr[pre] > arr[pre + 1]; pre--) {
				if(arr[i] >= arr[i - 1]) {
					continue;
				}
				swap(arr,pre, pre + 1);
			}
		}
	}
	
	// 2. swap
	public static void swap(int[] arr, int i , int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
	
	
	
}
